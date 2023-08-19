import { Navigate, Route, Routes } from "react-router-dom";
import { HeaderMenu } from "../../layouts/navbar/HeaderMenu";
import {
    ActaExportPage,
    AsambleistasRes,
    CandidatoPage,
    ChangePwd,
    DashboardPage,
    EscrutinioPage,
    OrganizacionPage,
    PresidencialRes,
    SeleccionPage,
    TendenciaPage,
    UsuariosPage,
} from "../../pages";
import { Container } from "@mantine/core";

export const PrivatePages = () => {
    return (
        <>
            <HeaderMenu />
            <Container size="xl">
                <Routes>
                    <Route path="home" element={<DashboardPage />} />
                    <Route path="admin/usuarios" element={<UsuariosPage />} />
                    <Route
                        path="admin/organizaciones"
                        element={<OrganizacionPage />}
                    />
                    <Route
                        path="admin/candidatos"
                        element={<CandidatoPage />}
                    />

                    <Route path="profile/password" element={<ChangePwd />} />
                    <Route path="digitacion" element={<SeleccionPage />} />
                    <Route path="escrutinio" element={<EscrutinioPage />} />
                    <Route
                        path="resultados/presidenciales"
                        element={<PresidencialRes />}
                    />
                    <Route
                        path="resultados/webster/asamblea"
                        element={<AsambleistasRes />}
                    />
                    <Route path="admin/actas" element={<ActaExportPage />} />
                    <Route path="admin/tendencia" element={<TendenciaPage />} />
                    <Route path="/*" element={<Navigate to="/home" />} />
                </Routes>
            </Container>
        </>
    );
};
