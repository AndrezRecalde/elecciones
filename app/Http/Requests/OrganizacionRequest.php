<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Http\Exceptions\HttpResponseException;

class OrganizacionRequest extends FormRequest
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
            'nombre_organizacion'   =>  'required',
            'lista'                 =>  'required',
            'sigla'                 =>  'required',
            'color'                 =>  'required',
            'imagen_url'            =>  'required|mimes:png,jpg,jpeg'
        ];
    }

    public function messages(): array
    {
        return [
            'nombre_organizacion.required'  => 'El nombre de la Organización es requerida',
            'lista.required'                =>  'La lista es requerida',
            'sigla.required'                =>  'Las siglas de la organización son requeridas',
            'color.required'                =>  'El color es requerido',
            'imagen_url.required'           =>  'El logo de la organización es requerido'
        ];
    }

    protected function failedValidation(Validator $validator): HttpResponseException
    {
        /* $errors = (new ValidationException($validator))->errors(); */
        throw new HttpResponseException(response()->json(['errores' => $validator->errors()], 422));
    }
}
