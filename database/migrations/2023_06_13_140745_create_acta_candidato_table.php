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
        Schema::create('acta_candidato', function (Blueprint $table) {
            $table->id();
            $table->unsignedInteger('acta_id');
            $table->unsignedInteger('candidato_id');
            $table->unsignedInteger('num_votos')->default('0')->change();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('acta_candidato');
    }
};
