<?php

namespace Database\Seeders;

use App\Models\User;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\Hash;
use Spatie\Permission\Models\Role;

class UserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        User::truncate();
        Role::truncate();

        $superRole = Role::create(['name' => 'Superadministrador']);
        $adminRole = Role::create(['name' => 'Administrador']);
        $digitadorRole = Role::create(['name' => 'Digitador']);
        $visualizadorRole = Role::create(['name' => 'Visualizador']);

        $super = New User;
        $super->nombres = 'Cristhian Recalde';
        $super->usuario = '0802704171';
        $super->es_provincial = 1;
        $super->provincia_id = 8;
        $super->es_cantonal = 0;
        $super->password = Hash::make('a123456');
        $super->activo = 1;
        $super->user_id = 1;
        $super->save();
        $super->assignRole($superRole);

        $admin = New User;
        $admin->nombres = 'Franklin Francis';
        $admin->usuario = '0111111111';
        $admin->es_provincial = 1;
        $admin->provincia_id = 8;
        $admin->es_cantonal = 0;
        $admin->password = Hash::make('a123456');
        $admin->activo = 1;
        $admin->user_id = 1;
        $admin->save();
        $admin->assignRole($adminRole);

        $digitador = New User;
        $digitador->nombres = 'Digitador';
        $digitador->usuario = '0888888888';
        $digitador->es_provincial = 1;
        $digitador->provincia_id = 8;
        $digitador->es_cantonal = 0;
        $digitador->password = Hash::make('a123456');
        $digitador->activo = 1;
        $digitador->user_id = 1;
        $digitador->save();
        $digitador->assignRole($digitadorRole);

        $visualizador = New User;
        $visualizador->nombres = 'Visualizador';
        $visualizador->usuario = '0999999999';
        $visualizador->es_provincial = 1;
        $visualizador->provincia_id = 8;
        $visualizador->es_cantonal = 0;
        $visualizador->password = Hash::make('a123456');
        $visualizador->activo = 1;
        $visualizador->user_id = 1;
        $visualizador->save();
        $visualizador->assignRole($visualizadorRole);
    }
}
