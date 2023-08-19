<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class CantidadAsambleista extends Model
{
    use HasFactory;

    protected $fillable = [
        'provincia_id',
        'cantidad'
    ];
}
