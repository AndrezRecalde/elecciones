<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Dignidad extends Model
{
    use HasFactory;

    protected $table = 'dignidades';

    protected $fillable = [
        'nombre_dignidad',
        'activo'
    ];
}
