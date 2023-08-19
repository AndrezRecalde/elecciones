import { createSlice } from "@reduxjs/toolkit";

export const uiCandidatoSlice = createSlice({
    name: "uiCandidato",
    initialState: {
        isOpenModalAddCandidato: false,
        isOpenModalActiveCandidato: false,
    },
    reducers: {
        onOpenModalCandidato: (state) => {
            state.isOpenModalAddCandidato = true;
        },
        onCloseModalCandidato: (state) => {
            state.isOpenModalAddCandidato = false;
        },
        onOpenModalActiveCandidato: (state) => {
            state.isOpenModalActiveCandidato = true;
        },
        onCloseModalActiveCandidato: (state) => {
            state.isOpenModalActiveCandidato = false;
        },
    },
});

export const {
    onOpenModalCandidato,
    onCloseModalCandidato,
    onOpenModalActiveCandidato,
    onCloseModalActiveCandidato,
} = uiCandidatoSlice.actions;
