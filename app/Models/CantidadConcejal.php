<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class CantidadConcejal extends Model
{
    use HasFactory;

    protected $table = 'cantidad_concejales';

    protected $fillable = [
        'canton_id',
        'cantidad_urbanos',
        'cantidad_rurales'
    ];
}
