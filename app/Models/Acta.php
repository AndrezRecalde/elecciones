<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\HasMany;

class Acta extends Model
{
    use HasFactory;

    protected $fillable = [
        'provincia_id',
        'canton_id',
        'parroquia_id',
        'zona_id',
        'junta_id',
        'dignidad_id',
        'cod_cne',
        'votos_validos',
        'votos_blancos',
        'votos_nulos',
        'cuadrada',
        'legible',
        'user_add',
        'user_update'
    ];

    protected $attributes = [
        'votos_blancos' => 0,
        'votos_nulos' => 0
    ];

    public function detalles(): HasMany
    {
        return $this->hasMany(Detalle::class);
    }

    function votos(): HasMany
    {
        return $this->hasMany(ActaCandidato::class, 'acta_id', 'id')
            ->join('candidatos as c', 'c.id', 'acta_candidato.candidato_id');
    }

    public function candidatos()
    {
        return $this->belongsToMany(Candidato::class);
    }

    public static function create(array $attributes = [])
    {

        $attributes['user_add'] = auth()->id();

        $acta = static::query()->create($attributes);

        return $acta;
    }

    function scopeDignidad($query, $dignidad_id)
    {
        if ($dignidad_id > 0) {
            return $query->where('d.id', $dignidad_id);
        }
    }

    function scopeProvincia($query, $provincia_id)
    {
        if ($provincia_id > 0) {
            return $query->where('prov.id', $provincia_id);
        }
    }

    function scopeCanton($query, $canton_id)
    {
        if ($canton_id > 0) {
            return $query->where('cant.id', $canton_id);
        }
    }

    function scopeParroquia($query, $parroquia_id)
    {
        if ($parroquia_id > 0) {
            return $query->where('parr.id', $parroquia_id);
        }
    }

    function scopeZona($query, $zona_id)
    {
        if ($zona_id > 0) {
            return $query->where('z.id', $zona_id);
        }
    }

    function scopeCuadrada($query, $tipo_acta)
    {
        return $query->where('a.cuadrada', $tipo_acta);
    }
}
