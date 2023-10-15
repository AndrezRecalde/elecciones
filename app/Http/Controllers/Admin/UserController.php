<?php

namespace App\Http\Controllers\Admin;

use App\Enums\MsgStatusEnum;
use App\Http\Controllers\Controller;
use App\Http\Requests\UserPassword;
use App\Http\Requests\UserRequest;
use App\Http\Requests\UserUpdateActivo;
use App\Models\User;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class UserController extends Controller
{
    public function getUsuarios(): JsonResponse
    {
        if (auth()->user()->cannot('view', User::class)) {
            return response()->json([
                'status' => MsgStatusEnum::Error,
                'msg' => '403'
            ], 403);
        }

        $usuarios = User::from('users as u')
            ->join('provincias as prov', 'prov.id', 'u.provincia_id')
            ->leftJoin('cantones as cant', 'cant.id', 'u.canton_id')
            ->join('model_has_roles as mhr', 'mhr.model_id', 'u.id')
            ->join('roles as r', 'r.id', 'mhr.role_id')
            ->selectRaw('u.id, u.nombres, u.usuario,
                        u.es_provincial, u.provincia_id, prov.nombre_provincia,
                        u.es_cantonal, u.canton_id, cant.nombre_canton, r.name as role, r.id as role_id,
                        u.responsable, u.activo')
            ->orderBy('u.id', 'ASC')
            ->allowed()
            ->get();

        return response()->json([
            'status' => MsgStatusEnum::Success,
            'usuarios' => $usuarios->filter(function ($value) {
                if ($value->role_id > 1) {
                    return $value;
                }
            })->values()
        ], 200);
    }

    public function store(UserRequest $request): JsonResponse
    {
        try {
            $usuario = User::create($request->validated());
            $usuario->assignRole($request->role);
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Creacion], 201);
        } catch (\Throwable $th) {
            DB::rollback();
            return response()->json(['status' => MsgStatusEnum::Error, 'msg' => $th->getMessage()], 500);
        }
    }

    public function update(UserRequest $request, int $id): JsonResponse
    {
        $usuario = User::find($id);
        try {
            if ($usuario) {
                $usuario->update($request->validated());

                if ($request->filled('role')) {
                    $usuario->roles()->detach();
                    $usuario->assignRole($request->role);
                }
                return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Creacion], 201);
            } else {
                return response()->json(['status' => MsgStatusEnum::Error, 'msg' => MsgStatusEnum::NotFound], 404);
            }
        } catch (\Throwable $th) {
            return response()->json(['status' => MsgStatusEnum::Error, 'msg' => $th->getMessage()], 500);
        }
    }

    public function destroy(int $id): JsonResponse
    {
        $usuario = User::find($id);

        if ($usuario) {
            $usuario->roles()->detach();
            $usuario->delete();
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Eliminado], 200);
        } else {
            return response()->json(['status' => MsgStatusEnum::Error, 'msg' => MsgStatusEnum::NotFound], 404);
        }
    }

    public function updatePassword(UserPassword $request, int $id): JsonResponse
    {
        $usuario = User::find($id);

        try {
            if ($usuario) {
                $usuario->update($request->validated());
                return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Actualizado], 201);
            } else {
                return response()->json(['status' => MsgStatusEnum::Error, 'msg' => MsgStatusEnum::NotFound], 404);
            }
        } catch (\Throwable $th) {
            return response()->json(['status' => MsgStatusEnum::Error, 'msg' => $th->getMessage()], 500);
        }
    }

    public function updateActivo(UserUpdateActivo $request, int $id): JsonResponse
    {
        $usuario = User::find($id);
        if ($usuario) {
            $usuario->update($request->validated());
            return response()->json(['status' => MsgStatusEnum::Success, 'msg' => MsgStatusEnum::Actualizado], 201);
        } else {
            return response()->json(['status' => MsgStatusEnum::Error, 'msg' => MsgStatusEnum::NotFound], 404);
        }
    }
}
