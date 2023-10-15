import { createSlice } from "@reduxjs/toolkit";

export const tendenciaSlice = createSlice({
    name: "tendencia",
    initialState: {
        pageLoad: false,
        isLoading: false,
        tendencias: null,
        tendenciasChart: null,
    },
    reducers: {
        onLoading: (state) => {
            state.isLoading = true;
        },
        onLoadTendencias: (state, { payload }) => {
            state.tendencias = payload;
            state.isLoading = false;
            state.pageLoad = true;
        },
        onLoadTendenciasChart: (state, { payload }) => {
            state.tendenciasChart = payload;
        },
        onClearTendencias: (state) => {
            state.tendencias = null;
            state.tendenciasChart = null;
            state.pageLoad = false;
        },
    },
});

export const {
    onLoading,
    onLoadTendencias,
    onLoadTendenciasChart,
    onClearTendencias,
} = tendenciaSlice.actions;
