import { useEffect } from "react";
import { Divider, Grid } from "@mantine/core";
import {
    BusquedaWebster,
    ChartResultado,
    StatEscrutinio,
    StatVotacion,
    TablaWebster,
    TitleSections,
} from "../../../../components";
import {
    useAuthStore,
    useResultadoStore,
} from "../../../../hooks";
import Swal from "sweetalert2";

const DIGNIDAD_CURRENT = 2;

export const AsambleistasRes = () => {
    const { profile } = useAuthStore();
    const {
        pageLoad,
        totalDeVotos,
        errores,
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
        startLoadTotalDeVotos(valores);
        startLoadTotalActasIngresadas(valores);
        startLoadTotalJuntas(valores);
        startLoadResultadosCandidatos(valores);
        return () => {
            startClearResultados();
        };
    }, []);

    useEffect(() => {
        if (errores !== undefined) {
            /* viewNotificationNotResults("Sin registro", errores); */
            Swal.fire("Información", errores, "info");
        }
    }, [errores]);

    return (
        <>
            <TitleSections
                title="Resultados | Webster Asambleístas"
                ta="center"
                fw={700}
                color="black"
            />
            <Divider my="sm" />

            <Grid>
                <Grid.Col xs={12} sm={12} md={4} lg={4}>
                    <BusquedaWebster dig={DIGNIDAD_CURRENT} />
                </Grid.Col>

                {pageLoad && totalDeVotos !== null ? (
                    <>
                        <Grid.Col xs={12} sm={12} md={4} lg={4}>
                            <StatVotacion />
                        </Grid.Col>
                        <Grid.Col xs={12} sm={12} md={4} lg={4}>
                            <StatEscrutinio />
                        </Grid.Col>
                        <Grid.Col xs={12} sm={12} md={12} lg={12}>
                            <TablaWebster />
                        </Grid.Col>
                        <Grid.Col xs={12} sm={12} md={12} lg={12}>
                            <ChartResultado />
                        </Grid.Col>
                    </>
                ) : null}
            </Grid>
        </>
    );
};
