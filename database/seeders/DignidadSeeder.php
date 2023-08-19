<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class DignidadSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::table('dignidades')->delete();
        $dignidades = [
            [
                'nombre_dignidad'   =>  'Presidentes y Vicepresidentes',
                'activo'            =>  1
            ],
            [
                'nombre_dignidad'   =>  'Asambleistas Nacionales',
                'activo'            =>  1
            ],
            [
                'nombre_dignidad'   =>  'Prefectos y Viceprefectos',
                'activo'            =>  0
            ],
            [
                'nombre_dignidad'   =>  'Alcaldes Municipales',
                'activo'            =>  0
            ],
            [
                'nombre_dignidad'   =>  'Concejales Urbanos',
                'activo'            =>  0
            ],
            [
                'nombre_dignidad'   =>  'Concejales Rurales',
                'activo'            =>  0
            ],
            [
                'nombre_dignidad'   =>  'Juntas Parroquiales',
                'activo'            =>  0
            ],
        ];
        DB::table('dignidades')->insert($dignidades);
    }
}
