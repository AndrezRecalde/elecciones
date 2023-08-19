import { createSlice } from "@reduxjs/toolkit";

export const tendenciaSlice = createSlice({
    name: "tendencia",
    initialState: {
        pageLoad: false,
        isLoading: false,
        tendencias: null,
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
        onClearTendencias: (state) => {
            state.tendencias = null;
            state.pageLoad = false;
        },
    },
});

export const { onLoading, onLoadTendencias, onClearTendencias } =
    tendenciaSlice.actions;
