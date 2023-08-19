<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\BelongsToMany;
use Illuminate\Database\Eloquent\Relations\HasMany;

class Candidato extends Model
{
    use HasFactory;

    protected $fillable = [
        'organizacion_id',
        'dignidad_id',
        'nombre_candidato',
        'activo'
    ];

    public function distritos(): BelongsToMany
    {
        return $this->belongsToMany(Distrito::class);
    }

    public function actas(): BelongsToMany
    {
        return $this->belongsToMany(Acta::class);
    }

    public function scopeCandidato($query, $dignidad_id)
    {
        if($dignidad_id > 0) {
            return $query->where('c.dignidad_id', $dignidad_id)->where('c.activo', 1);
        }
    }

    public function scopeProvincia($query, $provincia_id)
    {
        if($provincia_id > 0){
            return $query->where('p.id', $provincia_id);
        }
    }

    public function scopeCanton($query, $canton_id)
    {
        if($canton_id > 0){
            return $query->where('cant.id', $canton_id);
        }
    }

    public function scopeParroquia($query, $parroquia_id)
    {
        if($parroquia_id > 0) {
            return $query->where('parr.id', $parroquia_id);
        }
    }

    public function scopeActa($query, $acta_id)
    {
        if($acta_id > 0) {
            return $query->where('ac.acta_id', $acta_id);
        }
    }

}
