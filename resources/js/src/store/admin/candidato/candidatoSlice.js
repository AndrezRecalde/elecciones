import { createSlice } from "@reduxjs/toolkit";

export const candidatoSlice = createSlice({
    name: "candidato",
    initialState: {
        isLoading: false,
        candidatos: [],
        activateCandidato: null,
        errores: undefined,
    },
    reducers: {
        onLoading: (state) => {
            state.isLoading = true;
            state.errores = undefined;
        },
        onCandidatos: (state, { payload }) => {
            state.candidatos = payload;
            state.isLoading = false;
            state.errores = undefined;
        },
        onAddCandidato: (state, { payload }) => {
            state.candidatos.push(payload);
            state.activateCandidato = null;
            state.errores = undefined;
        },
        onUpdateCandidato: (state, { payload }) => {
            state.candidatos = state.candidatos.map((candidato) => {
                if (candidato.id === payload.id) {
                    return payload;
                }
                return candidato;
            });
            state.activateCandidato = null;
            state.errores = undefined;
        },
        onDeleteCandidato: (state) => {
            if (state.activateCandidato) {
                state.candidatos = state.candidatos.filter(
                    (candidato) => candidato.id !== state.activateCandidato.id
                );
                state.activateCandidato = null;
                state.errores = undefined;
            }
        },
        onSetActivateCandidato: (state, { payload }) => {
            state.activateCandidato = payload;
            state.isLoading = false;
            state.errores = undefined;
        },
        onClearCandidatos: (state) => {
            state.candidatos = [];
            state.activateCandidato = null;
            state.errores = undefined;
        },
        onErrores: (state, { payload }) => {
            state.errores = payload;
        },
    },
});

export const {
    onLoading,
    onCandidatos,
    onAddCandidato,
    onUpdateCandidato,
    onDeleteCandidato,
    onSetActivateCandidato,
    onSetActivateEstado,
    onClearCandidatos,
    onErrores,
} = candidatoSlice.actions;
