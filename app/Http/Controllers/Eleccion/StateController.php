<?php

namespace App\Http\Controllers\Eleccion;

use App\Enums\MsgStatusEnum;
use App\Http\Controllers\Controller;
use App\Models\Canton;
use App\Models\Junta;
use App\Models\Parroquia;
use App\Models\Provincia;
use App\Models\Recinto;
use App\Models\Zona;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Laravel\Ui\Presets\React;

class StateController extends Controller
{
    public function getProvinciaDigitacion(Request $request): JsonResponse
    {
        $provincia = Provincia::where('id', $request->id)
            ->where('activo', 1)
            ->get();

        if ($provincia) {
            return response()->json(['status' => MsgStatusEnum::Success, 'provincia' => $provincia], 200);
        } else {
            return response()->json(['status' => MsgStatusEnum::Error, 'msg' => MsgStatusEnum::ErrorProvincia], 404);
        }
    }

    function getProvincias() : JsonResponse {
        $provincias = Provincia::get(['id', 'nombre_provincia']);

        return response()->json(['status' => MsgStatusEnum::Success, 'provincias' => $provincias], 200);
    }

    public function getCantones(Request $request): JsonResponse
    {
        $cantones = Canton::where('provincia_id', $request->provincia_id)->get(['id', 'nombre_canton',]);

        return response()->json(['status' => MsgStatusEnum::Success, 'cantones' => $cantones], 200);
    }

    public function getParroquias(Request $request): JsonResponse
    {
        $parroquias = Parroquia::where('canton_id', $request->canton_id)->get(['id', 'nombre_parroquia', 'tipo']);

        return response()->json(['status' => MsgStatusEnum::Success, 'parroquias' => $parroquias], 200);
    }

    public function getRecintos(Request $request): JsonResponse
    {
        $recintos = Recinto::where('parroquia_id', $request->parroquia_id)->get(['id', 'nombre_recinto']);

        return response()->json(['status' => MsgStatusEnum::Success, 'recintos' => $recintos], 200);
    }

    public function getZonas(Request $request): JsonResponse
    {
        $zonas = Zona::where('parroquia_id', $request->parroquia_id)->get(['id', 'nombre_zona', 'est_parroquia']);

        return response()->json(['status' => MsgStatusEnum::Success, 'zonas' => $zonas], 200);
    }

    public function getJuntas(Request $request): JsonResponse
    {
        $juntas = Junta::where('zona_id', $request->zona_id)->get(['id', 'junta_nombre']);

        return response()->json(['status' => MsgStatusEnum::Success, 'juntas' => $juntas], 200);
    }
}
