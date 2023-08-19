<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

/* Route::get('{any}', function () {
    return view('welcome');
})->where('any', '.*'); */
/* Route::view('/{path?}', 'welcome'); */

/* Route::fallback(function() {
    return view('welcome');
}); */

/* Route::get('{reactRoutes}', function () {
    return view('welcome');
})->where('reactRoutes', '^((?!api).)*$');  */


Route::get('/{all}', function () {
    return view('welcome');
})->where('all', '^(?!api).*$');
