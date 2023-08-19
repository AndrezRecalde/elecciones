import { configureStore } from "@reduxjs/toolkit";
import {
    actaSlice,
    actasResSlice,
    cantidadSlice,
    dignidadSlice,
    escrutinioSlice,
    resultadosSlice,
    stateSlice,
    tendenciaSlice,
} from "./eleccion";
import {
    candidatoSlice,
    distritoSlice,
    organizacionSlice,
    roleSlice,
    uiCandidatoSlice,
    uiOrganizacionSlice,
    uiUsuarioSlice,
    usuarioSlice,
} from "./admin";
import { authSlice } from "./auth/authSlice";

export const store = configureStore({
    reducer: {
        auth: authSlice.reducer,
        usuario: usuarioSlice.reducer,
        uiUsuario: uiUsuarioSlice.reducer,
        role: roleSlice.reducer,
        dignidad: dignidadSlice.reducer,
        state: stateSlice.reducer,
        distrito: distritoSlice.reducer,
        acta: actaSlice.reducer,
        actasRes: actasResSlice.reducer,
        uiOrganizacion: uiOrganizacionSlice.reducer,
        organizacion: organizacionSlice.reducer,
        candidato: candidatoSlice.reducer,
        uiCandidato: uiCandidatoSlice.reducer,
        resultado: resultadosSlice.reducer,
        cantidad: cantidadSlice.reducer,
        escrutinio: escrutinioSlice.reducer,
        tendencia: tendenciaSlice.reducer
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware({
            serializableCheck: false,
        }),
});
