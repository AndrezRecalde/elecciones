import { createSlice } from "@reduxjs/toolkit";

export const authSlice = createSlice({
    name: "auth",
    initialState: {
        isLoading: false,
        user: {},
        isLogin: false,
        profile: {},
        errores: undefined,
    },
    reducers: {
        onLoading: (state) => {
            state.isLoading = true;
        },
        onAuthenticate: (state, { payload }) => {
            state.user = payload;
            state.isLogin = true;
            state.isLoading = false;
        },
        onProfile: (state, { payload }) => {
            state.profile = payload;
            state.isLogin = true;
            state.isLoading = false;
        },
        onLogout: (state, { payload }) => {
            state.isLoading = false;
            state.user = {};
            state.profile = {};
            state.isLogin = false;
            state.errores = payload;
        },
        clearErrores: (state) => {
            state.errores = undefined;
        },
    },
});

export const { onLoading, onAuthenticate, onProfile, onLogout, clearErrores } =
    authSlice.actions;
