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
        Schema::create('actas', function (Blueprint $table) {
            $table->id();
            $table->unsignedInteger('provincia_id');
            $table->unsignedInteger('canton_id');
            $table->unsignedInteger('parroquia_id');
            $table->unsignedInteger('zona_id');
            $table->unsignedInteger('junta_id');
            $table->unsignedInteger('dignidad_id');
            $table->string('cod_cne')->nullable();
            $table->unsignedInteger('votos_validos')->default(0);
            $table->unsignedInteger('votos_blancos')->default(0);
            $table->unsignedInteger('votos_nulos')->default(0);
            $table->boolean('cuadrada')->default(1);
            $table->boolean('legible')->default(1);
            $table->unsignedInteger('user_add');
            $table->unsignedInteger('user_update')->nullable();
            $table->boolean('estado')->default(1);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('actas');
    }
};
