<?php

namespace App\Http\Controllers\Eleccion;

use App\Enums\MsgStatusEnum;
use App\Exports\ActasAllExport;
use App\Exports\ActasExport;
use App\Http\Controllers\Controller;
use App\Http\Requests\ActaRequest;
use App\Interfaces\ActaInterface;
use App\Models\Acta;
use App\Models\Junta;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Maatwebsite\Excel\Facades\Excel;
use Symfony\Component\HttpFoundation\BinaryFileResponse;

class ActaController extends Controller
{

    private ActaInterface $actaRepository;

    public function __construct(ActaInterface $actaRepository)
    {
        $this->actaRepository = $actaRepository;
    }

    public function existeJuntaDignidad(Request $request)
    {
        $acta = Acta::from('actas as a')
            ->selectRaw('a.*, u.nombres as creador, us.nombres as actualizador')
            ->join('users as u', 'u.id', 'a.user_add')
            ->leftJoin('users as us', 'us.id', 'a.user_update')
            ->where('junta_id', $request->junta_id)
            ->where('dignidad_id', $request->dignidad_id)
            ->first();

        if ($acta) {
            return response()->json(['status' => true, 'acta' => $acta], 200);
        } else {
            return response()->json(['status' => false, 'msg' => MsgStatusEnum::NotFound], 200);
        }
    }

    public function store(ActaRequest $request)
    {
        try {
            $acta = Acta::create($request->validated());

            $dignidad = (int)$request->dignidad_id;

            /* Presidentes, Asambleístas, Prefectos son a nivel de cada provincia */
            if ($dignidad === 1 || $dignidad === 2 || $dignidad === 3) {
                $candidatos = $this->actaRepository->getDignidadesForActa($acta->dignidad_id, $acta->provincia_id, 0, 0);
                /* Alcaldes son a nivel cantonal */
            } else if ($dignidad === 4 || $dignidad === 5 || $dignidad === 6) {
                $candidatos = $this->actaRepository->getDignidadesForActa($acta->dignidad_id, $acta->provincia_id, $acta->canton_id, 0);
            } else if ($dignidad === 7) {
                $candidatos = $this->actaRepository->getDignidadesForActa($acta->dignidad_id, $acta->provincia_id, $acta->canton_id, $acta->parroquia_id);
            }

            $votos = [];
            $index = 0;

            foreach ($candidatos as $candidato) {
                $votos[$index] = $request->num_votos[$index];
                $acta->candidatos()->attach([
                    $candidato->id => ['num_votos' => !is_null($votos[$index]) ? $votos[$index] : 0]
                ]);
                $index += 1;
            }


            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Creacion], 201);
        } catch (\Throwable $th) {
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => $th->getMessage()], 500);
        }
    }

    public function update(ActaRequest $request)
    {
        $acta = Acta::find($request->id);

        try {
            if ($acta) {

                $acta->fill($request->validated());

                $acta->user_update = auth()->id();

                $acta->save();

                $dignidad = (int)$acta->dignidad_id;

                /* Presidentes, Asambleístas, Prefectos son a nivel de cada provincia */
                if ($dignidad === 1 || $dignidad === 2 || $dignidad === 3) {
                    $candidatos = $this->actaRepository->getDignidadesForActa($acta->dignidad_id, $acta->provincia_id, 0, 0, 0);
                    /* Alcaldes son a nivel cantonal */
                } else if ($dignidad === 4 || $dignidad === 5 || $dignidad === 6) {
                    $candidatos = $this->actaRepository->getDignidadesForActa($acta->dignidad_id, $acta->provincia_id, $acta->canton_id, 0, 0);
                } else if ($dignidad === 7) {
                    $candidatos = $this->actaRepository->getDignidadesForActa($acta->dignidad_id, $acta->provincia_id, $acta->canton_id, $acta->parroquia_id, 0);
                }

                $votos = [];
                $index = 0;
                $acta->candidatos()->detach();
                foreach ($candidatos as $candidato) {
                    $votos[$index] = $request->num_votos[$index];
                    $acta->candidatos()->attach([
                        $candidato->id => ['num_votos' => !is_null($votos[$index]) ? $votos[$index] : 0]
                    ]);
                    $index += 1;
                }

                return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Actualizado], 201);
            } else {
                return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::NotFound], 404);
            }
        } catch (\Throwable $th) {
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => $th->getMessage()], 500);
        }
    }

    public function destroy(int $id)
    {
        $acta = Acta::find($id);

        if ($acta) {
            $acta->candidatos()->detach();
            $acta->delete();
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Eliminado], 200);
        } else {
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::NotFound], 404);
        }
    }

    function getTotalActasIngresadas(Request $request): JsonResponse
    {
        $totalActasIngresadas = Acta::from('actas as a')
            ->selectRaw('COUNT(a.id) AS digitadas')
            ->join('dignidades as d', 'd.id', 'a.dignidad_id')
            ->join('provincias as prov', 'prov.id', 'a.provincia_id')
            ->join('cantones as cant', 'cant.id', 'a.canton_id')
            ->join('parroquias as parr', 'parr.id', 'a.parroquia_id')
            ->dignidad($request->dignidad_id)
            ->provincia($request->provincia_id)
            ->canton($request->canton_id)
            ->parroquia($request->parroquia_id)
            ->first();

        return response()->json([
            'status' => MsgStatusEnum::Success,
            'totalActasIngresadas' => $totalActasIngresadas
        ], 200);
    }

    function getActas(Request $request): JsonResponse
    {
        $actas = Acta::from('actas as a')
            ->selectRaw('a.id, j.junta_nombre, a.cod_cne,
                        a.votos_validos, a.votos_blancos, a.votos_nulos,
                        a.cuadrada, a.legible, d.nombre_dignidad,
                        z.nombre_zona, parr.nombre_parroquia, cant.nombre_canton,
                        r.nombre_recinto, u.nombres')
            ->join('dignidades as d', 'd.id', 'a.dignidad_id')
            ->join('juntas as j', 'j.id', 'a.junta_id')
            ->join('zonas as z', 'z.id', 'j.zona_id')
            ->join('parroquias as parr', 'parr.id', 'z.parroquia_id')
            ->join('cantones as cant', 'cant.id', 'parr.canton_id')
            ->leftJoin('users as u', 'u.id', 'a.user_add')
            ->leftJoin('recintos as r', 'r.id', 'j.recinto_id')
            ->dignidad($request->dignidad_id)
            ->canton($request->canton_id)
            ->parroquia($request->parroquia_id)
            ->cuadrada($request->tipo_acta)
            ->orderBy('parr.nombre_parroquia', 'ASC')
            ->orderBy('j.junta_nombre', 'ASC')
            ->get();

        return response()->json(['status' => MsgStatusEnum::Success, 'actas' => $actas], 200);
    }

    function getAllActas(Request $request): JsonResponse
    {
        $actas = Acta::from('actas as a')
            ->selectRaw('a.id, j.junta_nombre, a.cod_cne,
                        a.votos_validos, a.votos_blancos, a.votos_nulos,
                        a.cuadrada, a.legible, d.nombre_dignidad,
                        z.nombre_zona, parr.nombre_parroquia, cant.nombre_canton,
                        r.nombre_recinto, u.nombres')
            ->join('dignidades as d', 'd.id', 'a.dignidad_id')
            ->join('juntas as j', 'j.id', 'a.junta_id')
            ->join('zonas as z', 'z.id', 'j.zona_id')
            ->join('parroquias as parr', 'parr.id', 'z.parroquia_id')
            ->join('cantones as cant', 'cant.id', 'parr.canton_id')
            ->leftJoin('users as u', 'u.id', 'a.user_add')
            ->leftJoin('recintos as r', 'r.id', 'j.recinto_id')
            ->dignidad($request->dignidad_id)
            ->canton($request->canton_id)
            ->parroquia($request->parroquia_id)
            ->orderBy('parr.nombre_parroquia', 'ASC')
            ->orderBy('j.junta_nombre', 'ASC')
            ->get();

        return response()->json(['status' => MsgStatusEnum::Success, 'actas' => $actas], 200);
    }

    function exportExcelActas(Request $request)
    {
        return Excel::download(new ActasExport(
            $request->dignidad_id,
            $request->canton_id,
            $request->parroquia_id,
            $request->tipo_acta
        ), 'actasExport.xlsx');
    }

    function exportExcelAllActas(Request $request)
    {
        return Excel::download(new ActasAllExport(
            $request->dignidad_id,
            $request->canton_id,
            $request->parroquia_id
        ), 'TodasLasActas.xlsx');
    }
}




            /*
                Primera forma en el store

                $votos = [];
                $index = 0;

                foreach ($request->candidato_id as $candidato) {
                    $votos[$index] = $request->num_votos[$index];
                    $acta->detalles()->create([
                        'candidato_id'  =>  $candidato,
                        'num_votos'     =>  $votos[$index]
                    ]);
                    $index += 1;
                }
            */

            /*
            Segunda Forma

            $votos = [];
            $index = 0;

            foreach ($candidatos as $candidato) {
                $votos[$index] = $request->num_votos[$index];
                $acta->detalles()->create([
                    'candidato_id'  =>  $candidato->id,
                    'num_votos'     =>  $votos[$index]
                ]);
                $index += 1;
            }
             */
