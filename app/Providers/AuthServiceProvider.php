<?php

namespace App\Providers;

// use Illuminate\Support\Facades\Gate;

use App\Models\Acta;
use App\Models\ActaCandidato;
use App\Models\User;
use App\Policies\ActaCandidatoPolicy;
use App\Policies\ActaPolicy;
use App\Policies\UserPolicy;
use Illuminate\Foundation\Support\Providers\AuthServiceProvider as ServiceProvider;

class AuthServiceProvider extends ServiceProvider
{
    /**
     * The model to policy mappings for the application.
     *
     * @var array<class-string, class-string>
     */
    protected $policies = [
        User::class => UserPolicy::class,
        ActaCandidato::class => ActaCandidatoPolicy::class,
        Acta::class => ActaPolicy::class
    ];

    /**
     * Register any authentication / authorization services.
     */
    public function boot(): void
    {
        //
    }
}
