import { useEffect } from "react";
import { Grid } from "@mantine/core";
import {
    CardBusquedaDignidad,
    ChartResultado,
    StatEscrutinio,
    StatVotacion,
    TablaResultado,
} from "../../../components";
import {
    useAuthStore,
    useResultadoStore,
} from "../../../hooks";
import Swal from "sweetalert2";
import { useNavigate } from "react-router-dom";
import { useState } from "react";

const DIGNIDAD_CURRENT = 1;

export const PresidencialRes = () => {
    const navigate = useNavigate();
    const [title, setTitle] = useState("Elecciones | Resultados");
    const { profile } = useAuthStore();
    const {
        pageLoad,
        errores,
        totalDeVotos,
        startLoadTotalDeVotos,
        startLoadTotalActasIngresadas,
        startLoadTotalJuntas,
        startLoadResultadosCandidatos,
        startClearResultados,
    } = useResultadoStore();
    /* const { viewNotificationNotResults } = useNotification(); */

    const { provincia_id } = profile;
    const valores = { dignidad_id: DIGNIDAD_CURRENT, provincia_id };

    useEffect(() => {
        document.title = title;
        startLoadTotalDeVotos(valores);
        startLoadTotalActasIngresadas(valores);
        startLoadTotalJuntas(valores);
        startLoadResultadosCandidatos(valores);
        return () => {
            startClearResultados();
            setTitle("");
        };
    }, []);

    useEffect(() => {
        if (errores !== undefined) {
            if (errores === '403'){
                navigate("/error/403");
                return;
            }
            Swal.fire("Información", errores, "info");
        }
    }, [errores]);

    return (
        <>
            <CardBusquedaDignidad
                titlePage="Resultados | Candidatos Presidenciales"
                dig={DIGNIDAD_CURRENT}
            />

            {pageLoad && totalDeVotos !== null ? (
                <Grid>
                    <Grid.Col xs={12} sm={6} md={6} lg={6} xl={6}>
                        <StatVotacion />
                    </Grid.Col>
                    <Grid.Col xs={12} sm={6} md={6} lg={6} xl={6}>
                        <StatEscrutinio />
                    </Grid.Col>
                    <Grid.Col xs={12} sm={12} md={12} lg={12} xl={12}>
                        <ChartResultado />
                    </Grid.Col>
                    <Grid.Col xs={12} sm={12} md={12} lg={12} xl={12}>
                        <TablaResultado />
                    </Grid.Col>
                </Grid>
            ) : null}
        </>
    );
};
