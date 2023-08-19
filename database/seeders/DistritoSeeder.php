<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class DistritoSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::table('distritos')->delete();

        $distritos = [
            [
                'tipo_distrito' => 'Provincial',
            ],
            [
                'tipo_distrito' => 'Cantonal',
            ],
            [
                'tipo_distrito' => 'Parroquial',
            ],
        ];
        DB::table('distritos')->insert($distritos);
    }
}
