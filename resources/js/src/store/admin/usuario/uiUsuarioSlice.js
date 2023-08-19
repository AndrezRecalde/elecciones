import { createSlice } from "@reduxjs/toolkit";

export const uiUsuarioSlice = createSlice({
    name: "uiUsuario",
    initialState: {
        isOpenModalUser: false,
        isOpenModalActivateUser: false,
        isOpenModalPassword: false,
    },
    reducers: {
        onOpenModalUser: (state) => {
            state.isOpenModalUser = true;
        },
        onCloseModalUser: (state) => {
            state.isOpenModalUser = false;
        },
        onOpenModalActivateUser: (state) => {
            state.isOpenModalActivateUser = true;
        },
        onCloseModalActivateUser: (state) => {
            state.isOpenModalActivateUser = false;
        },
        onOpenModalPassword: (state) => {
            state.isOpenModalPassword = true;
        },
        onCloseModalPassword: (state) => {
            state.isOpenModalPassword = false;
        }
    },
});

export const {
    onOpenModalUser,
    onCloseModalUser,
    onOpenModalActivateUser,
    onCloseModalActivateUser,
    onOpenModalPassword,
    onCloseModalPassword
} = uiUsuarioSlice.actions;
