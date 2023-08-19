<?php

namespace App\Http\Controllers\Admin;

use App\Enums\MsgStatusEnum;
use App\Http\Controllers\Controller;
use App\Models\Dignidad;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;

class DignidadController extends Controller
{

    function getDignidadesAdmin(): JsonResponse
    {
        $dignidades = Dignidad::get(['id', 'nombre_dignidad', 'activo']);

        return response()->json(['status' => MsgStatusEnum::Success, 'dignidades' => $dignidades], 200);
    }

    function getDignidades(): JsonResponse
    {
        $dignidades = Dignidad::where('activo', 1)
            ->get(['id', 'nombre_dignidad']);

        return response()->json(['status' => MsgStatusEnum::Success, 'dignidades' => $dignidades], 200);
    }

    function getDignidadesResTotales(): JsonResponse  /* Dignidades de resultados Totales */
    {
        $dignidades = Dignidad::where('activo', 1)
            ->whereIn('id', [1, 3, 4])
            ->get(['id', 'nombre_dignidad']);

        return response()->json(['status' => MsgStatusEnum::Success, 'dignidades' => $dignidades], 200);
    }

    function getDignidadesWebster(): JsonResponse   /* Dignidades de resultados con webster */
    {
        $dignidades = Dignidad::where('activo', 1)
            ->whereIn('id', [2, 5, 6])
            ->get(['id', 'nombre_dignidad']);

        return response()->json(['status' => MsgStatusEnum::Success, 'dignidades' => $dignidades], 200);
    }

    function getJuntas(): JsonResponse
    {
        $dignidades = Dignidad::where('id', 7)->get(['id', 'nombre_dignidad']);

        return response()->json(['status' => MsgStatusEnum::Success, 'dignidades' => $dignidades], 200);
    }
}
