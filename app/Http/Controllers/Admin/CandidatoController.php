<?php

namespace App\Http\Controllers\Admin;

use App\Enums\MsgStatusEnum;
use App\Http\Controllers\Controller;
use App\Http\Requests\CandidatoActivoReq;
use App\Http\Requests\CandidatoRequest;
use App\Interfaces\ActaInterface;
use App\Models\Candidato;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;

class CandidatoController extends Controller
{

    private ActaInterface $actaRepository;

    public function __construct(ActaInterface $actaRepository)
    {
        $this->actaRepository = $actaRepository;
    }

    /* EndPoint para visualizar los
    candidatos para el acta de digitación */
    public function getCandidatosProvinciales(Request $request)
    {
        $candidatos = Candidato::from('candidatos as c')
            ->selectRaw('c.id, c.nombre_candidato, org.nombre_organizacion,
                         org.lista, org.sigla, org.color, org.imagen_url')
            ->join('organizaciones as org', 'org.id', 'c.organizacion_id')
            ->join('candidato_distrito as cd', 'cd.candidato_id', 'c.id')
            ->join('provincias as p', 'p.id', 'cd.state')
            ->where('c.dignidad_id', $request->dignidad_id)
            ->where('p.id', $request->provincia_id)
            ->where('c.activo', 1)
            ->orderBy('org.lista', 'ASC')
            ->get();

        return response()->json(['status' => MsgStatusEnum::Success, 'candidatos' => $candidatos], 200);
    }

    public function getDignidadesForActaWithId(Request $request)
    {
        try {
            $dignidad = (int)$request->dignidad_id;
            $provincia = (int)$request->provincia_id;
            $canton = (int)$request->canton_id;
            $parroquia = (int)$request->parroquia_id;
            $acta = (int)$request->acta_id;

            /* Presidentes, Asambleístas, Prefectos son a nivel de cada provincia */
            if ($dignidad === 1 || $dignidad === 2 || $dignidad === 3) {
                $candidatos = $this->actaRepository->getDignidadesForActaWithId($dignidad, $provincia, 0, 0, $acta);
                /* Alcaldes son a nivel cantonal */
            } else if ($dignidad === 4 || $dignidad === 5 || $dignidad === 6) {
                $candidatos = $this->actaRepository->getDignidadesForActaWithId($dignidad, $provincia, $canton, 0, $acta);
            } else if ($dignidad === 7) {
                $candidatos = $this->actaRepository->getDignidadesForActaWithId($dignidad, $provincia, $canton, $parroquia, $acta);
            }

            return response()->json(['status' => MsgStatusEnum::Success, 'candidatos' => $candidatos], 200);
        } catch (\Throwable $th) {
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => $th->getMessage()], 500);
        }
    }

    public function getDignidadesForActa(Request $request)
    {
        try {
            $dignidad = (int)$request->dignidad_id;
            $provincia = (int)$request->provincia_id;
            $canton = (int)$request->canton_id;
            $parroquia = (int)$request->parroquia_id;

            /* Presidentes, Asambleístas, Prefectos son a nivel de cada provincia */
            if ($dignidad === 1 || $dignidad === 2 || $dignidad === 3) {
                $candidatos = $this->actaRepository->getDignidadesForActa($dignidad, $provincia, 0, 0);
                /* Alcaldes son a nivel cantonal */
            } else if ($dignidad === 4 || $dignidad === 5 || $dignidad === 6) {
                $candidatos = $this->actaRepository->getDignidadesForActa($dignidad, $provincia, $canton, 0);
            } else if ($dignidad === 7) {
                $candidatos = $this->actaRepository->getDignidadesForActa($dignidad, $provincia, $canton, $parroquia);
            }

            return response()->json(['status' => MsgStatusEnum::Success, 'candidatos' => $candidatos], 200);
        } catch (\Throwable $th) {
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => $th->getMessage()], 500);
        }
    }

    function getCandidatosForActa(Request $request): JsonResponse
    {
        try {

            $dignidad = (int)$request->dignidad_id;
            $provincia = (int)$request->provincia_id;
            $canton = (int)$request->canton_id;
            $parroquia = (int)$request->parroquia_id;

            if ($request->acta_id) {
                $acta = (int)$request->acta_id;
                /* Presidentes, Asambleístas, Prefectos son a nivel de cada provincia */
                if ($dignidad === 1 || $dignidad === 2 || $dignidad === 3) {
                    $candidatos = $this->actaRepository->getDignidadesForActaWithId($dignidad, $provincia, 0, 0, $acta);
                    /* Alcaldes son a nivel cantonal */
                } else if ($dignidad === 4 || $dignidad === 5 || $dignidad === 6) {
                    $candidatos = $this->actaRepository->getDignidadesForActaWithId($dignidad, $provincia, $canton, 0, $acta);
                } else if ($dignidad === 7) {
                    $candidatos = $this->actaRepository->getDignidadesForActaWithId($dignidad, $provincia, $canton, $parroquia, $acta);
                }
            } else {
                /* Presidentes, Asambleístas, Prefectos son a nivel de cada provincia */
                if ($dignidad === 1 || $dignidad === 2 || $dignidad === 3) {
                    $candidatos = $this->actaRepository->getDignidadesForActa($dignidad, $provincia, 0, 0);
                    /* Alcaldes son a nivel cantonal */
                } else if ($dignidad === 4 || $dignidad === 5 || $dignidad === 6) {
                    $candidatos = $this->actaRepository->getDignidadesForActa($dignidad, $provincia, $canton, 0);
                } else if ($dignidad === 7) {
                    $candidatos = $this->actaRepository->getDignidadesForActa($dignidad, $provincia, $canton, $parroquia);
                }
            }
            return response()->json(['status' => MsgStatusEnum::Success, 'candidatos' => $candidatos], 200);
        } catch (\Throwable $th) {
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => $th->getMessage()], 500);
        }
    }

    public function getCandidatosAdmin()
    {
        $candidatos = Candidato::from('candidatos as c')
            ->selectRaw('c.id, c.nombre_candidato, c.activo,org.nombre_organizacion,
                                c.dignidad_id, c.organizacion_id,
                                dis.id as distrito_id, dis.tipo_distrito,
                                prov.id as provincia_id, prov.nombre_provincia,
                                cant.id as canton_id, cant.nombre_canton,
                                parr.id as parroquia_id, parr.nombre_parroquia,
                                org.lista, org.sigla, org.color, org.imagen_url,
                                d.nombre_dignidad')
            ->join('organizaciones as org', 'org.id', 'c.organizacion_id')
            ->join('dignidades as d', 'd.id', 'c.dignidad_id')
            ->join('candidato_distrito as cd', 'cd.candidato_id', 'c.id')
            ->join('distritos as dis', 'dis.id', 'cd.distrito_id')
            ->join('provincias as prov', 'prov.id', 'cd.provincia_id')
            ->leftJoin('cantones as cant', 'cant.id', 'cd.canton_id')
            ->leftJoin('parroquias as parr', 'parr.id', 'cd.parroquia_id')
            ->orderBy('d.id', 'ASC')
            ->orderBy('org.lista', 'ASC')
            ->get();

        return response()->json(['status' => MsgStatusEnum::Success, 'candidatos' => $candidatos], 200);
    }

    public function store(CandidatoRequest $request)
    {
        try {
            $candidato = Candidato::create($request->validated());
            $candidato->distritos()->attach(
                $request->distrito_id,
                [
                    'provincia_id'  =>  $request->provincia_id,
                    'canton_id'     =>  $request->canton_id,
                    'parroquia_id'  =>  $request->parroquia_id
                ]
            );
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Creacion], 201);
        } catch (\Throwable $th) {
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => $th->getMessage()], 500);
        }
    }

    public function update(CandidatoRequest $request, int $id)
    {
        $candidato = Candidato::find($id);

        if ($candidato) {
            $candidato->update($request->validated());

            if (
                $request->filled('distrito_id') ||
                $request->filled('provincia_id') ||
                $request->filled('canton_id') ||
                $request->filled('parroquia_id')
            ) {
                $candidato->distritos()->detach();
                $candidato->distritos()
                    ->sync([
                        $request->distrito_id => [
                            "provincia_id" =>   $request->provincia_id,
                            "canton_id"    =>   $request->canton_id,
                            "parroquia_id" =>   $request->parroquia_id
                        ]
                    ]);
            }

            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Actualizado], 201);
        } else {
            return response()->json(['status' => MsgStatusEnum::Error, 'msg' => MsgStatusEnum::NotFound], 404);
        }
    }

    public function destroy(int $id)
    {
        $candidato = Candidato::find($id);

        if ($candidato) {
            $candidato->distritos()->detach();
            $candidato->delete();
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Eliminado], 201);
        } else {
            return response()->json(['status' => MsgStatusEnum::Error, 'msg' => MsgStatusEnum::NotFound], 404);
        }
    }

    function updateActivo(CandidatoActivoReq $request, int $id): JsonResponse
    {
        $candidato = Candidato::find($id);
        if ($candidato) {
            $candidato->update($request->validated());
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Actualizado], 201);
        } else {
            return response()->json(['status' => MsgStatusEnum::Error, 'msg' => MsgStatusEnum::NotFound], 404);
        }
    }
}
