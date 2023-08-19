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
        Schema::create('candidato_distrito', function (Blueprint $table) {
            $table->id();
            $table->unsignedInteger('candidato_id');
            $table->unsignedInteger('distrito_id');
            $table->unsignedInteger('provincia_id');
            $table->unsignedInteger('canton_id')->nullable();
            $table->unsignedInteger('parroquia_id')->nullable();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('candidato_distrito');
    }
};
