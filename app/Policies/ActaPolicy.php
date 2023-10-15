<?php

namespace App\Policies;

use App\Models\User;

class ActaPolicy
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
}
