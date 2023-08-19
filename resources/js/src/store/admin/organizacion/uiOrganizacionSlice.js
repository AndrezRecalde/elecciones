import { createSlice } from "@reduxjs/toolkit";

export const uiOrganizacionSlice = createSlice({
    name: "uiOrganizacion",
    initialState: {
        isOpenModalAddOrg: false,
    },
    reducers: {
        onOpenModalOrg: (state) => {
            state.isOpenModalAddOrg = true;
        },
        onCloseModalOrg: (state) => {
            state.isOpenModalAddOrg = false;
        },
    },
});

export const { onOpenModalOrg, onCloseModalOrg } = uiOrganizacionSlice.actions;
