import { createSlice } from "@reduxjs/toolkit";

export const cantidadSlice = createSlice({
    name: "cantidad",
    initialState: {
        cantidad: null,
    },
    reducers: {
        onLoadCantidadCandidatos: (state, { payload }) => {
            state.cantidad = payload;
        },
        onClearCantidadCandidatos: (state) => {
            state.cantidad = null;
        },
    },
});

export const { onLoadCantidadCandidatos, onClearCantidadCandidatos } =
    cantidadSlice.actions;
