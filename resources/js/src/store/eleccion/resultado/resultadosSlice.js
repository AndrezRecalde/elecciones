import { createSlice } from "@reduxjs/toolkit";

export const resultadosSlice = createSlice({
    name: "resultados",
    initialState: {
        pageLoad: false,
        totalDeVotos: null,
        totalActasIngresadas: null,
        totalJuntas: null,
        resultadoCandidatos: null,
        errores: undefined,
    },
    reducers: {
        onLoadTotalDeVotos: (state, { payload }) => {
            state.totalDeVotos = payload;
            state.errores = undefined;
        },
        onLoadTotalIngresadas: (state, { payload }) => {
            state.totalActasIngresadas = payload;
        },
        onLoadTotalJuntas: (state, { payload }) => {
            state.totalJuntas = payload;
        },
        onLoadResultadosCandidatos: (state, { payload }) => {
            state.resultadoCandidatos = payload;
            state.pageLoad = true;
        },
        onErrores: (state, { payload }) => {
            state.errores = payload;
            state.totalDeVotos = null;
            state.totalActasIngresadas = null;
            state.totalJuntas = null;
            state.resultadoCandidatos = null;

        },
        onClearErrores: (state) => {
            state.errores = undefined;
        },
        onClearResultados: (state) => {
            state.totalDeVotos = null;
            state.totalActasIngresadas = null;
            state.totalJuntas = null;
            state.resultadoCandidatos = null;
            state.pageLoad = false;
            state.errores = undefined;
        },
    },
});

export const {
    onLoadTotalDeVotos,
    onLoadTotalIngresadas,
    onLoadTotalJuntas,
    onLoadResultadosCandidatos,
    onErrores,
    onClearErrores,
    onClearResultados,
} = resultadosSlice.actions;
