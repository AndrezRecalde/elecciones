import { createSlice } from "@reduxjs/toolkit";

export const actasResSlice = createSlice({
    name: "actasRes",
    initialState: {
        pageLoad: false,
        isLoading: false,
        actas: null,
    },
    reducers: {
        onLoading: (state) => {
            state.isLoading = true;
        },
        onLoadActas: (state, { payload }) => {
            state.actas = payload;
            state.isLoading = false;
            state.pageLoad = true;
        },
        onClearActas: (state) => {
            state.actas = null;
            state.pageLoad = false;
        },
    },
});

export const {
    onLoading,
    onLoadActas,
    onClearActas,
} = actasResSlice.actions;
