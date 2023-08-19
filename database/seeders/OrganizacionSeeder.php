<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class OrganizacionSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::table('organizaciones')->delete();
        $organizaciones = [
            [
                'nombre_organizacion' => 'Centro Democrático',
                'lista' => '1', 'sigla' => 'CD', 'color' => '#f3982d'
            ],
            [
                'nombre_organizacion' => 'Unidad Popular',
                'lista' => '2', 'sigla' => 'U.P', 'color' => '#ff0000'
            ],
            [
                'nombre_organizacion' => 'Partido Sociedada Patriótica',
                'lista' => '3', 'sigla' => 'PSP', 'color' => '#338c52'
            ],
            [
                'nombre_organizacion' => 'Ecuatoriano Unido',
                'lista' => '4', 'sigla' => 'EC.U', 'color' => '#3f3a60'
            ],
            [
                'nombre_organizacion' => 'Alianza Revolucion Ciudadana',
                'lista' => '5', 'sigla' => 'RC5', 'color' => '#0af2e3'
            ],
            [
                'nombre_organizacion' => 'Partido Social Cristiano',
                'lista' => '6', 'sigla' => 'PSC', 'color' => '#f4dd40'
            ],
            [
                'nombre_organizacion' => 'Avanza Ecuador',
                'lista' => '8', 'sigla' => 'AVANZA', 'color' => '#0079b0'
            ],
            [
                'nombre_organizacion' => 'Fuerza Ecuador',
                'lista' => '10', 'sigla' => 'F.E', 'color' => '#f4dd40'
            ],
            [
                'nombre_organizacion' => 'Movimiento Justicia Social',
                'lista' => '11', 'sigla' => 'JS', 'color' => '#0044ab'
            ],
            [
                'nombre_organizacion' => 'Izquierda Democrática',
                'lista' => '12', 'sigla' => 'ID', 'color' => '#f18c3e'
            ],
            [
                'nombre_organizacion' => 'Movimiento Acción Movilizadora Independiente Generando Oportunidades',
                'lista' => '16', 'sigla' => 'AMIGO', 'color' => '#d8516c'
            ],
            [
                'nombre_organizacion' => 'Partido Socialista Ecuatoriano',
                'lista' => '17', 'sigla' => 'PSE', 'color' => '#b50000'
            ],
            [
                'nombre_organizacion' => 'Pachakutik',
                'lista' => '18', 'sigla' => 'PACHK.', 'color' => '#661f84'
            ],
            [
                'nombre_organizacion' => 'Union Ecuatoriana',
                'lista' => '19', 'sigla' => 'UE.', 'color' => '#e05642'
            ],
            [
                'nombre_organizacion' => 'Democracia SI',
                'lista' => '20', 'sigla' => 'DSÍ', 'color' => '#e72a40'
            ],
            [
                'nombre_organizacion' => 'Movimiento CREO, Creando Oportunidades',
                'lista' => '21', 'sigla' => 'CREO', 'color' => '#005aa1'
            ],
            [
                'nombre_organizacion' => 'Partido SUMA, Sociedad Unida Más Acción',
                'lista' => '23', 'sigla' => 'SUMA', 'color' => '#f08d1c'
            ],
            [
                'nombre_organizacion' => 'Movimiento Construye!',
                'lista' => '25', 'sigla' => 'MC25', 'color' => '#1919e6'
            ],
            [
                'nombre_organizacion' => 'Movimiento RETO, Renovación Total',
                'lista' => '33', 'sigla' => 'RETO', 'color' => '#0068eb'
            ],
            [
                'nombre_organizacion' => 'Movimiento Verde Ético Revolucionario y Democrático',
                'lista' => '35', 'sigla' => 'MOVER', 'color' => '#1cec00'
            ],
        ];
        DB::table('organizaciones')->insert($organizaciones);
    }
}
