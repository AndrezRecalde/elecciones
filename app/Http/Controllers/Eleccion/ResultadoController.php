<?php

namespace App\Http\Controllers\Eleccion;

use App\Enums\MsgStatusEnum;
use App\Http\Controllers\Controller;
use App\Models\Acta;
use App\Models\ActaCandidato;
use App\Models\Junta;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;

class ResultadoController extends Controller
{
    function getResultadosProvinciales(Request $request): JsonResponse
    {
        $candidatos = ActaCandidato::from('acta_candidato as ac')
            ->selectRaw('d.nombre_dignidad, c.nombre_candidato,
                        org.nombre_organizacion, org.lista, org.sigla, org.color,
                        SUM(ac.num_votos) as total_votos')
            ->join('actas as a', 'a.id', 'ac.acta_id')
            ->join('dignidades as d', 'd.id', 'a.dignidad_id')
            ->join('candidatos as c', 'c.id', 'ac.candidato_id')
            ->join('candidato_distrito as cd', 'cd.candidato_id', 'c.id')
            ->join('organizaciones as org', 'org.id', 'c.organizacion_id')
            ->join('juntas as j', 'j.id', 'a.junta_id')
            ->join('zonas as z', 'z.id', 'a.zona_id')
            ->join('parroquias as parr', 'parr.id', 'a.parroquia_id')
            ->join('cantones as cant', 'cant.id', 'parr.canton_id')
            ->dignidad($request->dignidad_id)
            ->provincia($request->provincia_id)
            ->cuadrada($request->cuadrada)
            ->legible($request->legible)
            ->groupBy('ac.candidato_id', 'd.nombre_dignidad')
            ->orderBy('total_votos', 'DESC')
            ->get();

        return response()->json(['status' => 'success', 'candidatos' => $candidatos], 200);
    }

    function getResultadosCantonales(Request $request): JsonResponse
    {
        $candidatos = ActaCandidato::from('acta_candidato as ac')
            ->selectRaw('d.nombre_dignidad, c.nombre_candidato,
                    org.nombre_organizacion, org.lista, org.sigla, org.color,
                    SUM(ac.num_votos) as total_votos')
            ->join('actas as a', 'a.id', 'ac.acta_id')
            ->join('dignidades as d', 'd.id', 'a.dignidad_id')
            ->join('candidatos as c', 'c.id', 'ac.candidato_id')
            ->join('candidato_distrito as cd', 'cd.candidato_id', 'c.id')
            ->join('organizaciones as org', 'org.id', 'c.organizacion_id')
            ->join('juntas as j', 'j.id', 'a.junta_id')
            ->join('zonas as z', 'z.id', 'a.zona_id')
            ->join('parroquias as parr', 'parr.id', 'a.parroquia_id')
            ->join('cantones as cant', 'cant.id', 'parr.canton_id')
            ->dignidad($request->dignidad_id)
            ->canton($request->canton_id)
            ->cuadrada($request->cuadrada)
            ->legible($request->legible)
            ->groupBy('ac.candidato_id', 'd.nombre_dignidad')
            ->orderBy('total_votos', 'DESC')
            ->get();

        return response()->json(['status' => 'success', 'candidatos' => $candidatos], 200);
    }

    function getResultadosParroquiales(Request $request): JsonResponse
    {
        $candidatos = ActaCandidato::from('acta_candidato as ac')
            ->selectRaw('d.nombre_dignidad, c.nombre_candidato,
                    org.nombre_organizacion, org.lista, org.sigla, org.color,
                    SUM(ac.num_votos) as total_votos')
            ->join('actas as a', 'a.id', 'ac.acta_id')
            ->join('dignidades as d', 'd.id', 'a.dignidad_id')
            ->join('candidatos as c', 'c.id', 'ac.candidato_id')
            ->join('candidato_distrito as cd', 'cd.candidato_id', 'c.id')
            ->join('organizaciones as org', 'org.id', 'c.organizacion_id')
            ->join('juntas as j', 'j.id', 'a.junta_id')
            ->join('zonas as z', 'z.id', 'a.zona_id')
            ->join('parroquias as parr', 'parr.id', 'a.parroquia_id')
            ->join('cantones as cant', 'cant.id', 'parr.canton_id')
            ->dignidad($request->dignidad_id)
            ->parroquia($request->parroquia_id)
            ->cuadrada($request->cuadrada)
            ->legible($request->legible)
            ->groupBy('ac.candidato_id', 'd.nombre_dignidad')
            ->orderBy('total_votos', 'DESC')
            ->get();

        return response()->json(['status' => 'success', 'candidatos' => $candidatos], 200);
    }

    function getResultadosRecintos(Request $request): JsonResponse
    {
        $candidatos = ActaCandidato::from('acta_candidato as ac')
            ->selectRaw('d.nombre_dignidad, c.nombre_candidato,
                    org.nombre_organizacion, org.lista, org.sigla, org.color,
                    SUM(ac.num_votos) as total_votos')
            ->join('actas as a', 'a.id', 'ac.acta_id')
            ->join('dignidades as d', 'd.id', 'a.dignidad_id')
            ->join('candidatos as c', 'c.id', 'ac.candidato_id')
            ->join('candidato_distrito as cd', 'cd.candidato_id', 'c.id')
            ->join('organizaciones as org', 'org.id', 'c.organizacion_id')
            ->join('juntas as j', 'j.id', 'a.junta_id')
            ->join('zonas as z', 'z.id', 'a.zona_id')
            ->join('parroquias as parr', 'parr.id', 'a.parroquia_id')
            ->join('cantones as cant', 'cant.id', 'parr.canton_id')
            ->join('recintos as re', 're.id', 'j.recinto_id')
            ->dignidad($request->dignidad_id)
            ->recinto($request->recinto_id)
            ->cuadrada($request->cuadrada)
            ->legible($request->legible)
            ->groupBy('ac.candidato_id', 'd.nombre_dignidad')
            ->orderBy('total_votos', 'DESC')
            ->get();

        return response()->json(['status' => 'success', 'candidatos' => $candidatos], 200);
    }

    function getResultadosTotales(Request $request): JsonResponse
    {
        $candidatos = ActaCandidato::from('acta_candidato as ac')
            ->selectRaw('d.nombre_dignidad, c.nombre_candidato,
                    org.nombre_organizacion, org.lista, org.sigla, org.color,
                    SUM(ac.num_votos) as total_votos')
            ->join('actas as a', 'a.id', 'ac.acta_id')
            ->join('dignidades as d', 'd.id', 'a.dignidad_id')
            ->join('candidatos as c', 'c.id', 'ac.candidato_id')
            ->join('candidato_distrito as cd', 'cd.candidato_id', 'c.id')
            ->join('organizaciones as org', 'org.id', 'c.organizacion_id')
            ->join('juntas as j', 'j.id', 'a.junta_id')
            ->join('zonas as z', 'z.id', 'a.zona_id')
            ->join('parroquias as parr', 'parr.id', 'a.parroquia_id')
            ->join('cantones as cant', 'cant.id', 'parr.canton_id')
            ->join('recintos as re', 're.id', 'j.recinto_id')
            ->dignidad($request->dignidad_id)
            ->provincia($request->provincia_id)
            ->canton($request->canton_id)
            ->parroquia($request->parroquia_id)
            ->recinto($request->recinto_id)
            ->cuadrada($request->cuadrada)
            ->legible($request->legible)
            ->groupBy('ac.candidato_id', 'd.nombre_dignidad')
            ->orderBy('total_votos', 'DESC')
            ->get();

        /* if (sizeof($candidatos) > 0) {
            return response()->json(['status' => 'success', 'candidatos' => $candidatos], 200);
        } else {
            return response()->json(['status' => 'success', 'msg' => 'Aún no existen datos'], 200);
        } */
        return response()->json(['status' => 'success', 'candidatos' => $candidatos], 200);
    }

    function getTotalesDeVotos(Request $request): JsonResponse
    {
        $totalDeVotos = ActaCandidato::from('acta_candidato as ac')
            ->selectRaw('SUM(a.votos_validos) as total_votos_validos,
                         SUM(a.votos_blancos) as total_votos_blancos,
                         SUM(a.votos_nulos) as total_votos_nulos')
            ->join('actas as a', 'a.id', 'ac.acta_id')
            ->join('dignidades as d', 'd.id', 'a.dignidad_id')
            ->join('candidatos as c', 'c.id', 'ac.candidato_id')
            ->join('candidato_distrito as cd', 'cd.candidato_id', 'c.id')
            ->join('organizaciones as org', 'org.id', 'c.organizacion_id')
            ->join('juntas as j', 'j.id', 'a.junta_id')
            ->join('zonas as z', 'z.id', 'a.zona_id')
            ->join('parroquias as parr', 'parr.id', 'a.parroquia_id')
            ->join('cantones as cant', 'cant.id', 'parr.canton_id')
            ->dignidad($request->dignidad_id)
            ->provincia($request->provincia_id)
            ->canton($request->canton_id)
            ->parroquia($request->parroquia_id)
            ->groupBy('ac.candidato_id')
            ->first();

        if ($totalDeVotos) {
            return response()->json(['status' => 'success', 'totalDeVotos' => $totalDeVotos], 200);
        } else {
            return response()->json(['status' => 'success', 'msg' => 'Aún no existen datos'], 200);
        }
    }

    function getTendenciaDeZonas(Request $request): JsonResponse
    {
        $tendencias = ActaCandidato::from('acta_candidato as ac')
            ->selectRaw('d.nombre_dignidad, c.nombre_candidato,
                org.nombre_organizacion, org.lista, org.sigla, org.color,
                j.genero, j.junta_nombre, z.id,
                 SUM(ac.num_votos) as total_votos')
            ->join('actas as a', 'a.id', 'ac.acta_id')
            ->join('dignidades as d', 'd.id', 'a.dignidad_id')
            ->join('candidatos as c', 'c.id', 'ac.candidato_id')
            ->join('candidato_distrito as cd', 'cd.candidato_id', 'c.id')
            ->join('organizaciones as org', 'org.id', 'c.organizacion_id')
            ->join('juntas as j', 'j.id', 'a.junta_id')
            ->join('zonas as z', 'z.id', 'a.zona_id')
            ->dignidad($request->dignidad_id)
            ->zona($request->zona_id)
            ->groupBy('ac.candidato_id', 'd.nombre_dignidad', 'j.genero', 'j.junta_nombre', 'z.id')
            ->orderBy('j.junta_nombre', 'ASC')
            ->orderBy('org.lista', 'ASC')
            ->get();

        return response()->json(['status' => MsgStatusEnum::Success, 'tendencias' => $tendencias], 200);
    }

    function getTendenciaZona(Request $request) : JsonResponse
    {
        $tendencias = Junta::from('juntas as j')
        ->selectRaw('j.id, j.junta_nombre, j.zona_id')
        ->with(['actas'])
        ->join('zonas as z', 'z.id', 'j.zona_id')
        ->zona($request->zona_id)
        ->get();

        return response()->json(['status' => MsgStatusEnum::Success, 'tendencias' => $tendencias], 200);
    }
}
