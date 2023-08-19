import { createSlice } from "@reduxjs/toolkit";

export const actaSlice = createSlice({
    name: "acta",
    initialState: {
        pageLoad: false,
        searchDisabled: false,
        isLoading: false,
        existeActa: false,
        selectedFields: null,
        activateJunta: null,
        activateActa: null,
        activateCandidatos: null,
        errores: undefined,
    },
    reducers: {
        onActiveSearch: (state, { payload }) => {
            state.searchDisabled = payload;
        },
        onLoading: (state) => {
            state.isLoading = true;
        },
        onStorageFields: (state, { payload }) => {
            state.selectedFields = payload;
            state.errores = undefined;
        },
        onActivateJunta: (state, { payload }) => {
            state.activateJunta = payload;
            state.pageLoad = true;
            state.errores = undefined;
        },
        onActivateActa: (state, { payload }) => {
            state.activateActa = payload;
            state.existeActa = true;
            state.isLoading = false;
        },
        onActivateCandidatos: (state, { payload }) => {
            state.activateCandidatos = payload;
        },
        onErrores: (state, { payload }) => {
            state.errores = payload;
        },
        onClearActa: (state) => {
            state.pageLoad = false;
            state.searchDisabled = false;
            state.existeActa = false;
            state.selectedFields = null;
            state.activateJunta = null;
            state.activateActa = null;
            state.activateCandidatos = null;
            state.errores = undefined;
        },
    },
});

export const {
    onActiveSearch,
    onLoading,
    onStorageFields,
    onActivateJunta,
    onActivateActa,
    onActivateCandidatos,
    onErrores,
    onClearActa,

    onPushNumeros
} = actaSlice.actions;
