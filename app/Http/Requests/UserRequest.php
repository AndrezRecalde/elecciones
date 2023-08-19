<?php

namespace App\Http\Requests;

use Illuminate\Validation\Rule;
use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Http\Exceptions\HttpResponseException;

class UserRequest extends FormRequest
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
            'nombres'       =>  'required',
            'usuario'       =>  ['required', Rule::unique('users')->ignore($this->request->get('id'))],
            'es_provincial' =>  'required',
            'provincia_id'  =>  'required',
            'es_cantonal'   =>  '',
            'canton_id'     =>  '',
            'responsable'   =>  '',
            'activo'        =>  'required',
            'role'          =>  'required'
        ];
    }

    public function messages(): array
    {
        return [
            'nombres.required'  =>  'Los nombres son requeridos',
            'usuario.required'  =>  'El usuario es requerido',
            'usuario.unique'  =>  'El usuario ya está registrado',
            'es_provincial.required'    =>  'Especifica si el usuario es Provincial',
            'provincia_id.required'     =>  'Especifica la provincia del usuario',
            'activo.required'           =>  'Especifica el estado del usuario',
            'role.required'             =>  'Especifique el role del usuario'
        ];
    }

    protected function failedValidation(Validator $validator)
    {
        throw new HttpResponseException(response()->json(['errores' => $validator->errors()], 422));
    }
}
