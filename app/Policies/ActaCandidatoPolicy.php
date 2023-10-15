<?php

namespace App\Policies;

use App\Models\User;

class ActaCandidatoPolicy
{
    /**
     * Create a new policy instance.
     */
    public function __construct()
    {
        //
    }

    function before(User $user): bool
    {
        if ($user->hasRole('Superadministrador') || $user->hasRole('Administrador') || $user->hasRole('Visualizador')) {
            return true;
        }
        return false;
    }

    function view(): bool
    {
        return false;
    }

    function viewResultados(User $user): bool
    {
        return true;
    }
}
