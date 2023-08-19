<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class ActaRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     */
    public function authorize(): bool
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, \Illuminate\Contracts\Validation\ValidationRule|array|string>
     */
    public function rules(): array
    {
        return [
            'provincia_id'  =>  'required',
            'canton_id'     =>  'required',
            'parroquia_id'  =>  'required',
            'zona_id'       =>  'required',
            'junta_id'      =>  'required',
            'dignidad_id'   =>  'required',
            'cod_cne'       =>  '',
            'votos_validos' =>  'required',
            'votos_blancos' =>  '',
            'votos_nulos'   =>  '',
            'cuadrada'      =>  'required',
            'legible'       =>  'required',

            /* Detalles */
            'num_votos[]'     =>  '',
            'user_update'    => ''
        ];
    }
}
