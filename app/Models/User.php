<?php

namespace App\Models;

// use Illuminate\Contracts\Auth\MustVerifyEmail;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;
use Illuminate\Support\Facades\Hash;
use Laravel\Sanctum\HasApiTokens;
use Spatie\Permission\Traits\HasRoles;

class User extends Authenticatable
{
    use HasApiTokens, HasFactory, Notifiable, HasRoles;

    /**
     * The attributes that are mass assignable.
     *
     * @var array<int, string>
     */
    protected $fillable = [
        'nombres',
        'usuario',
        'es_provincial',
        'provincia_id',
        'es_cantonal',
        'canton_id',
        'password',
        'responsable',
        'activo',
        'user_id'

    ];

    /**
     * The attributes that should be hidden for serialization.
     *
     * @var array<int, string>
     */
    protected $hidden = [
        'password',
        'remember_token',
    ];

    /**
     * The attributes that should be cast.
     *
     * @var array<string, string>
     */
    protected $casts = [
        'email_verified_at' => 'datetime',
        'password' => 'hashed',
    ];

    public function scopeAllowed($query)
    {
        if(auth()->user()->hasRole('Superadministrador') || auth()->user()->hasRole('Administrador'))
        {
            return $query;
        }else {
            return $query->where('user_id', auth()->id());
        }
    }

    public static function create(array $attributes = [])
    {
        $attributes['password'] = Hash::make($attributes['usuario']);

        $attributes['user_id'] = auth()->id();

        $user = static::query()->create($attributes);

        return $user;
    }

    public function setPasswordAttribute($password)
    {
    return $this->attributes['password'] = Hash::needsRehash($password) ? Hash::make($password) : $password;
    }
}
