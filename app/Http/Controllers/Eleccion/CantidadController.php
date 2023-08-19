<?php

namespace App\Http\Controllers\Eleccion;

use App\Enums\MsgStatusEnum;
use App\Http\Controllers\Controller;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class CantidadController extends Controller
{
    function getTotalAsambleistas(Request $request) : JsonResponse
    {
        $total = DB::table('cantidad_asambleistas as ca')
                ->selectRaw('ca.cantidad')
                ->where('ca.provincia_id', $request->provincia_id)
                ->first();

        return response()->json(['status' => MsgStatusEnum::Success, 'total' => $total], 200);
    }
}
