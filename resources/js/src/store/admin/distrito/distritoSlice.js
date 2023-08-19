import { createSlice } from "@reduxjs/toolkit";

export const distritoSlice = createSlice({
    name: "distrito",
    initialState: {
        distritos: [],
    },
    reducers: {
        onDistritos: (state, { payload }) => {
            state.distritos = payload;
        },
        onClearDistritos: (state) => {
            state.distritos = [];
        }
    },
});

export const { onDistritos, onClearDistritos } = distritoSlice.actions;
