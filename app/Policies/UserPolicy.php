<?php

namespace App\Policies;

use App\Models\User;

class UserPolicy
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

    function update(User $authUser, User $user): bool
    {
        return $authUser->id === $user->id;
    }

    function delete(User $authUser, User $user): bool
    {
        return $authUser->id === $user->id;
    }

    function viewResultados(User $user): bool
    {
        return true;
    }
}
