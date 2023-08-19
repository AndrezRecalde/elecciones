import { createSlice } from "@reduxjs/toolkit";

export const stateSlice = createSlice({
    name: "state",
    initialState: {
        provincias: [],
        cantones: [],
        parroquias: [],
        zonas: [],
        juntas: [],
        recintos: [],
    },
    reducers: {
        onLoadProvincia: (state, { payload }) => {
            state.provincias = payload;
        },
        onLoadCantones: (state, { payload }) => {
            state.cantones = payload;
        },
        onLoadParroquias: (state, { payload }) => {
            state.parroquias = payload;
        },
        onLoadZonas: (state, { payload }) => {
            state.zonas = payload;
        },
        onLoadJuntas: (state, { payload }) => {
            state.juntas = payload;
        },
        onLoadRecintos: (state, { payload }) => {
            state.recintos = payload;
        },
        onClearStates: (state) => {
            state.provincias = {};
            state.cantones = [];
            state.parroquias = [];
            state.zonas = [];
            state.juntas = [];
            state.recintos = [];
        },
    },
});

export const {
    onLoadProvincia,
    onLoadCantones,
    onLoadParroquias,
    onLoadZonas,
    onLoadJuntas,
    onLoadRecintos,
    onClearStates,
} = stateSlice.actions;
