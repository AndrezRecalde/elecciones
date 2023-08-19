<?php

namespace App\Http\Controllers\Eleccion;

use App\Enums\MsgStatusEnum;
use App\Http\Controllers\Controller;
use App\Models\Acta;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;


class EscrutinioController extends Controller
{
    function getAvanceEscrutinio(): JsonResponse
    {
        $escrutinio = DB::select('CALL getAvanceEscrutinio()');

        return response()->json(['status' => MsgStatusEnum::Success, 'escrutinio' => $escrutinio], 200);
    }

    function getEscrutinioPorDignidad(): JsonResponse
    {
        $total = Acta::from('actas as a')
            ->selectRaw('COUNT(a.id) as total_ingresadas, d.nombre_dignidad,
            CONCAT(ROUND((COUNT(a.id) / 1402 * 100), 2)) as porcentaje')
            ->join('dignidades as d', 'd.id', 'a.dignidad_id')
            ->groupBy('a.dignidad_id')
            ->get();

        return response()->json(['status' => MsgStatusEnum::Success, 'total' => $total], 200);
    }
}
