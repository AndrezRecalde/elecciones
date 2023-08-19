<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('users', function (Blueprint $table) {
            $table->id();
            $table->string('nombres');
            $table->string('usuario')->unique();
            $table->boolean('es_provincial');
            $table->unsignedInteger('provincia_id');
            $table->boolean('es_cantonal');
            $table->unsignedInteger('canton_id')->nullable();
            $table->string('password');
            $table->boolean('responsable')->default(0);
            $table->boolean('activo')->default(1);
            $table->unsignedInteger('user_id');
            $table->rememberToken();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('users');
    }
};
