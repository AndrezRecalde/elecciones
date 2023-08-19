<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Detalle extends Model
{
    use HasFactory;

    protected $fillable = [
        'acta_id',
        'candidato_id',
        'num_votos'
    ];

    public function acta()
    {
        return $this->belongsTo(Acta::class);
    }
}
