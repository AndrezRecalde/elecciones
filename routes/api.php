<?php

use App\Http\Controllers\Admin\CandidatoController;
use App\Http\Controllers\Admin\DignidadController;
use App\Http\Controllers\Admin\DistritoController;
use App\Http\Controllers\Admin\OrganizacionController;
use App\Http\Controllers\Admin\RoleController;
use App\Http\Controllers\Admin\UserController;
use App\Http\Controllers\Auth\AuthController;
use App\Http\Controllers\Eleccion\ActaController;
use App\Http\Controllers\Eleccion\CantidadController;
use App\Http\Controllers\Eleccion\EscrutinioController;
use App\Http\Controllers\Eleccion\JuntaController;
use App\Http\Controllers\Eleccion\ResultadoController;
use App\Http\Controllers\Eleccion\StateController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

/* Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
}); */

/* Autenticacion */

Route::post('/auth/login', [AuthController::class, 'login']);

Route::group(
    ['middleware' => ['auth:sanctum']],
    function () {
        Route::get('/refresh', [AuthController::class, 'refresh']);
        Route::get('/profile', [AuthController::class, 'profile']);
        Route::post('/auth/logout', [AuthController::class, 'logout']);

        /* Dignidades */
        Route::get('/admin/dignidades', [DignidadController::class, 'getDignidadesAdmin']);
        Route::get('/dignidades', [DignidadController::class, 'getDignidades']);
        Route::get('/listar/dignidades/resultado/total', [DignidadController::class, 'getDignidadesResTotales']);
        Route::get('/listar/dignidades/resultado/webster', [DignidadController::class, 'getDignidadesWebster']);
        Route::get('/listar/dignidades/resultado/juntas', [DignidadController::class, 'getJuntas']);



        /* Cuadro de Digitación */
        Route::post('/digitacion/provincia', [StateController::class, 'getProvinciaDigitacion']);
        Route::post('/digitacion/cantones', [StateController::class, 'getCantones']);
        Route::post('/digitacion/parroquias', [StateController::class, 'getParroquias']);
        Route::post('/digitacion/recintos', [StateController::class, 'getRecintos']);
        Route::post('/digitacion/zonas', [StateController::class, 'getZonas']);
        Route::post('/digitacion/juntas', [StateController::class, 'getJuntas']);

        /* Provincias */
        Route::get('/admin/listar/provincias', [StateController::class, 'getProvincias']);

        /* Organizaciones */
        Route::get('/admin/listar/organizaciones', [OrganizacionController::class, 'getOrganizacionesAdmin']);
        Route::post('/admin/store/organizacion', [OrganizacionController::class, 'store']);
        Route::post('/admin/update/organizacion/{id}', [OrganizacionController::class, 'update']);
        Route::delete('/admin/delete/organizacion/{id}', [OrganizacionController::class, 'destroy']);


        /* Candidatos */
        Route::post('/acta/listar/dignidades/acta', [CandidatoController::class, 'getCandidatosForActa']);
        Route::post('/acta/listar/candidatos', [CandidatoController::class, 'getDignidadesForActa']);
        Route::post('/acta/listar/candidatos/with', [CandidatoController::class, 'getDignidadesForActaWithId']);
        Route::get('/admin/candidatos', [CandidatoController::class, 'getCandidatosAdmin']);
        Route::post('/admin/create/candidato', [CandidatoController::class, 'store']);
        Route::put('/admin/update/candidato/{id}', [CandidatoController::class, 'update']);
        Route::delete('/admin/delete/candidato/{id}', [CandidatoController::class, 'destroy']);
        Route::put('/admin/update/candidato/activo/{id}', [CandidatoController::class, 'updateActivo']);

        /* Distritos */
        Route::get('/admin/listar/distritos', [DistritoController::class, 'getDistritos']);

        /* Acta de Información */
        Route::post('/informacion/junta', [JuntaController::class, 'getInfoJunta']);

        /* Cuadro del Acta */
        Route::post('/digitacion/buscar/acta', [ActaController::class, 'existeJuntaDignidad']);
        Route::post('/digitacion/store/acta', [ActaController::class, 'store']);
        Route::post('/digitacion/update/acta', [ActaController::class, 'update']);
        Route::delete('/admin/delete/acta/{id}', [ActaController::class, 'destroy']);

        /* Totales de Actas Ingresadas */
        Route::post('/admin/actas/ingresadas', [ActaController::class, 'getTotalActasIngresadas']);

        /* Exportación de Actas */
        Route::post('/admin/exportacion/actas', [ActaController::class, 'exportExcelActas']);
        Route::post('/admin/exportacion/actas/todas', [ActaController::class, 'exportExcelAllActas']);

        /* Visualizacion de Actas */
        Route::post('/admin/listar/actas', [ActaController::class, 'getActas']);
        Route::post('/admin/listar/actas/todas', [ActaController::class, 'getAllActas']);


        /* Usuarios */
        Route::get('/admin/listar/usuarios', [UserController::class, 'getUsuarios']);
        Route::post('/admin/create/usuario', [UserController::class, 'store']);
        Route::put('/admin/update/usuario/{id}', [UserController::class, 'update']);
        Route::delete('/admin/delete/usuario/{id}', [UserController::class, 'destroy']);
        Route::put('/admin/update/password/usuario/{id}', [UserController::class, 'updatePassword']);
        Route::put('/admin/update/usuario/activo/{id}', [UserController::class, 'updateActivo']);

        /* Juntas - Totales para cada distrito */
        Route::post('/admin/total/juntas/provincial', [JuntaController::class, 'getTotalJuntasProvincial']);
        Route::post('/admin/total/juntas/cantonal', [JuntaController::class, 'getTotalJuntasCanton']);
        Route::post('/admin/total/juntas/parroquial', [JuntaController::class, 'getTotalJuntasParroquial']);
        Route::post('/admin/total/juntas', [JuntaController::class, 'getTotalJuntas']);

        /* Roles */
        Route::get("/admin/listar/roles", [RoleController::class, 'getRoles']);

        /* Resultados */
        Route::post('/resultados/totales', [ResultadoController::class, 'getResultadosTotales']);
        Route::post('/resultados/provinciales', [ResultadoController::class, 'getResultadosProvinciales']);
        Route::post('/resultados/cantonales',   [ResultadoController::class, 'getResultadosCantonales']);
        Route::post('/resultados/parroquiales', [ResultadoController::class, 'getResultadosParroquiales']);
        Route::post('/resultados/recintos',     [ResultadoController::class, 'getResultadosRecintos']);
        Route::post('/resultados/total/votos', [ResultadoController::class, 'getTotalesDeVotos']);
        Route::post('/resultados/tendencias', [ResultadoController::class, 'getTendenciaDeZonas']);
        Route::post('/resultados/tendencias/zonas', [ResultadoController::class, 'getTendenciaZona']);



        /* Escrutinio */
        Route::get('/admin/resultado/escrutinio', [EscrutinioController::class, 'getAvanceEscrutinio']);
        Route::get('/dashboard/avance/escrutinio', [EscrutinioController::class, 'getEscrutinioPorDignidad']);

        /* Total Candidatos */
        Route::post('/admin/total/asambleistas', [CantidadController::class, 'getTotalAsambleistas']);
    }
);
