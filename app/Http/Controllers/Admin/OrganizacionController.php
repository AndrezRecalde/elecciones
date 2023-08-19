<?php

namespace App\Http\Controllers\Admin;

use File;
use App\Enums\MsgStatusEnum;
use App\Http\Controllers\Controller;
use App\Http\Requests\OrganizacionRequest;
use App\Http\Requests\OrganizacionUpdateRequest;
use App\Models\Organizacion;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Storage;

class OrganizacionController extends Controller
{
    public function getOrganizacionesAdmin()
    {
        $organizaciones = Organizacion::get(['id', 'nombre_organizacion', 'lista', 'sigla', 'color', 'imagen_url']);

        return response()->json(['status' => MsgStatusEnum::Success, 'organizaciones' => $organizaciones], 200);
    }

    public function store(OrganizacionRequest $request)
    {
        try {
            $organizacion = Organizacion::create($request->validated());

            $logo = $request->file('imagen_url');
            $filename = 'logo_' . uniqid() . '.' . $logo->getClientOriginalExtension();
            $save_path = '/organizaciones/logos/' . $organizacion->id . '/';
            $public_path = $save_path . $filename;
            $path = Storage::putFileAs(
                'public' . $save_path,
                $logo,
                $filename
            );

            if (!$path) {
                DB::rollback();
                return response()->json(['status' => MsgStatusEnum::Error, 'msg' => 'Error al cargar los archivos'], 500);
            }
            $organizacion->imagen_url = $public_path;
            $organizacion->save();
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Creacion], 201);
        } catch (\Throwable $th) {
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => $th->getMessage()], 500);
        }
    }

    public function update(OrganizacionUpdateRequest $request, int $id)
    {
        $organizacion = Organizacion::find($id);

        try {
            if ($organizacion) {

                if ($request->hasFile('imagen_url')) {
                    $filename = $organizacion->imagen_url;

                    if ($filename) {
                        Storage::disk('public')->delete($filename);
                    }
                    $organizacion->fill($request->validated());
                    $logo = $request->file('imagen_url');
                    $filename = 'logo_' . uniqid() .  '.' . $logo->getClientOriginalExtension();
                    $save_path = '/organizaciones/logos/' . $organizacion->id . '/';
                    $public_path = $save_path . $filename;
                    $path = Storage::putFileAs(
                        'public' . $save_path,
                        $logo,
                        $filename
                    );

                    if (!$path) {
                        DB::rollback();
                        return response()->json(['status' => MsgStatusEnum::Error, 'msg' => 'Error al cargar los archivos'], 500);
                    }
                    $organizacion->imagen_url = $public_path;
                    $res = $organizacion->save();
                } else {
                    $res = $organizacion->update(array_filter($request->validated()));
                }
            } else {
                return response()->json(['status' => MsgStatusEnum::Error, 'msg' => MsgStatusEnum::NotFound], 404);
            }

            if ($res) {
                return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Actualizado], 201);
            }
        } catch (\Throwable $th) {
            return response()->json(['status' => MsgStatusEnum::Error, 'msg' => $th->getMessage()], 500);
        }
    }

    public function destroy(int $id)
    {
        $organizacion = Organizacion::find($id);

        if ($organizacion) {
            if ($organizacion->imagen_url) {
                File::deleteDirectory(storage_path('app/public') . '/organizaciones/logos/' . $organizacion->id);
                $organizacion->delete();
                return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Eliminado], 200);
            } else {
                $organizacion->delete();
                return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Eliminado], 200);
            }
        } else {
            return response()->json(['status' => MsgStatusEnum::Error, 'msg' => MsgStatusEnum::NotFound], 404);
        }
    }
}
