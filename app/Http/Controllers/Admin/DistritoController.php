<?php

namespace App\Http\Controllers\Admin;

use App\Enums\MsgStatusEnum;
use App\Http\Controllers\Controller;
use App\Models\Distrito;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;

class DistritoController extends Controller
{
    function getDistritos(): JsonResponse
    {
        $distritos = Distrito::get(['id', 'tipo_distrito']);

        return response()->json(['status' => MsgStatusEnum::Success, 'distritos' => $distritos], 200);
    }
}
