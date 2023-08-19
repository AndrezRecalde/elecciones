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
        Schema::create('cantidad_concejales', function (Blueprint $table) {
            $table->id();
            $table->unsignedInteger('provincia_id');
            $table->unsignedInteger('canton_id');
            $table->integer('cantidad_urbanos');
            $table->integer('cantidad_rurales');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('cantidad_concejales');
    }
};
