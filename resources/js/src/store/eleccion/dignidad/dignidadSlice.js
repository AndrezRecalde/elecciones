import { createSlice } from "@reduxjs/toolkit";

export const dignidadSlice = createSlice({
    name: "dignidad",
    initialState: {
        dignidades: [],
    },
    reducers: {
        onLoadDignidades: (state, { payload }) => {
            state.dignidades = payload;
        },
        onClearDignidades: (state) => {
            state.dignidades = [];
        },
    },
});

export const { onLoadDignidades, onClearDignidades } = dignidadSlice.actions;
