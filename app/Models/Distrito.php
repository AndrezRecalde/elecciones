<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Distrito extends Model
{
    use HasFactory;

    protected $fillable = [
        'tipo_distrito'
    ];


    public function candidatos()
    {
        return $this->belongsToMany(Candidato::class);
    }
}
