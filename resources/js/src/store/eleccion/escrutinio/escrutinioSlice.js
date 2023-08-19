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
        onClearEscrutinio: (state) => {
            state.resultadosEscrutinio = [];
            state.dashboardEscrutinio = [];
        },
    },
});

export const { onLoadEscrutinio, onDashboardEscrutinio, onClearEscrutinio } =
    escrutinioSlice.actions;
