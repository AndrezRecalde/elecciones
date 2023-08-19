<?php

namespace App\Http\Controllers\Auth;

use App\Enums\MsgStatusEnum;
use App\Http\Controllers\Controller;
use App\Http\Requests\LoginRequest;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class AuthController extends Controller
{
    public function login(LoginRequest $request)
    {
        try {
            if (!Auth::attempt($request->validated())) {
                return response()->json([
                    'msg' => 'Credenciales incorrectas'
                ], 401);
            }

            $user = User::from('users as u')
                ->selectRaw('u.id, u.nombres, u.usuario, r.name as role, p.nombre_provincia as provincia,
                            p.cod_cne_prov as cod_cne')
                ->join('provincias as p', 'p.id', 'u.provincia_id')
                ->join('model_has_roles as mhr', 'mhr.model_id', 'u.id')
                ->join('roles as r', 'r.id', 'mhr.role_id')
                ->where('u.usuario', $request->usuario)
                ->where('u.activo', 1)
                ->first();

            if ($user) {
                $token = $user->createToken('auth_token')->plainTextToken;
                return response()->json([
                    'status'        =>  'success',
                    'access_token'  =>  $token,
                    'token_type'    =>  'Bearer',
                    'user' => $user
                ]);
            } else {
                return response()->json(['status' => 'error', 'msg' => 'Usuario no activo'], 401);
            }
        } catch (\Throwable $th) {
            return response()->json(['status' => MsgStatusEnum::Error, 'msg' => $th->getMessage()], 500);
        }
    }

    public function refresh()
    {
        $user = User::from('users as u')
            ->selectRaw('u.id, u.nombres, u.usuario, r.name as role,
                         u.provincia_id, p.nombre_provincia as provincia,
                         u.canton_id, c.nombre_canton as canton,
                        p.cod_cne_prov as cod_cne')
            ->join('provincias as p', 'p.id', 'u.provincia_id')
            ->leftJoin('cantones as c', 'c.id', 'u.canton_id')
            ->join('model_has_roles as mhr', 'mhr.model_id', 'u.id')
            ->join('roles as r', 'r.id', 'mhr.role_id')
            ->where('u.id', Auth::user()->id)
            ->first();

        if ($user) {
            $token = $user->createToken('auth_token')->plainTextToken;
            return response()->json([
                'status'        =>  'success',
                'access_token'  =>  $token,
                'token_type'    =>  'Bearer',
                'user'          =>  $user
            ]);
        } else {
            return response()->json(['status' => 'error', 'msg' => 'Usuario no activo'], 401);
        }
    }

    public function profile()
    {
        $profile = User::from('users as u')
            ->selectRaw('u.id, u.nombres, u.usuario, r.name as role,
                        u.provincia_id, p.nombre_provincia as provincia,
                        u.canton_id, c.nombre_canton as canton,
                        p.cod_cne_prov as cod_cne')
            ->join('provincias as p', 'p.id', 'u.provincia_id')
            ->leftJoin('cantones as c', 'c.id', 'u.canton_id')
            ->join('model_has_roles as mhr', 'mhr.model_id', 'u.id')
            ->join('roles as r', 'r.id', 'mhr.role_id')
            ->where('u.id', Auth::user()->id)
            ->first();

        return response()->json(['status' => MsgStatusEnum::Success, 'profile' => $profile], 200);
    }

    public function logout(Request $request)
    {
        auth()->user()->tokens()->delete();

        return response()->json([
            'status' => MsgStatusEnum::Success,
            'msg' => 'Logged out'
        ], 200);
    }
}
