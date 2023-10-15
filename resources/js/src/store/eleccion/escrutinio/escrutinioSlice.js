import { createSlice } from "@reduxjs/toolkit";

export const escrutinioSlice = createSlice({
    name: "escrutinio",
    initialState: {
        resultadosEscrutinio: [],
        dashboardEscrutinio: [],
        errores: undefined,
    },
    reducers: {
        onLoadEscrutinio: (state, { payload }) => {
            state.resultadosEscrutinio = payload;
        },
        onDashboardEscrutinio: (state, { payload }) => {
            state.dashboardEscrutinio = payload;
        },
        onErrores: (state, { payload }) => {
            state.errores = payload;
            state.resultadosEscrutinio = [];
            state.dashboardEscrutinio = [];
        },
        onClearEscrutinio: (state) => {
            state.resultadosEscrutinio = [];
            state.dashboardEscrutinio = [];
        },
    },
});

export const { onLoadEscrutinio, onDashboardEscrutinio, onErrores, onClearEscrutinio } =
    escrutinioSlice.actions;
