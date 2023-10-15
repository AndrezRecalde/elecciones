import { Box, Grid, Select } from "@mantine/core";
import {
    useAuthStore,
    useDignidadStore,
    useResultadoStore,
    useStateStore,
} from "../../../hooks";
import { useEffect } from "react";
import { IconDatabaseSearch } from "@tabler/icons-react";
import { BtnSubmit } from "../../elements/btn/BtnSubmit";

export const BusquedaForm = ({ form }) => {
    const { canton_id, parroquia_id } = form.values;
    const { profile } = useAuthStore();
    const { dignidades, startLoadDignidades, startClearDignidades } =
        useDignidadStore();

    const {
        cantones,
        parroquias,
        recintos,
        startLoadCantones,
        startLoadParroquias,
        startLoadRecintos,
    } = useStateStore();

    const {
        startLoadTotalDeVotos,
        startLoadTotalActasIngresadas,
        startLoadTotalJuntas,
        startLoadResultadosCandidatos,
    } = useResultadoStore();

    useEffect(() => {
        startLoadDignidades();
        return () => {
            startClearDignidades();
        };
    }, []);

    useEffect(() => {
        startLoadCantones(profile?.provincia_id);
    }, [profile]);

    useEffect(() => {
        startLoadParroquias(canton_id);
        form.setFieldValue("parroquia_id", 0);
    }, [canton_id]);

    useEffect(() => {
        startLoadRecintos(parroquia_id);
        form.setFieldValue("recinto_id", 0);
    }, [parroquia_id]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        /* if (!canton_id && !parroquia_id && !recinto_id) {
            console.log("Provinciales");
            startLoadTotalDeVotos()
        } else if (!parroquia_id && !recinto_id) {
            console.log("Cantonales");
        } else if (!recinto_id) {
            console.log("Parroquiales");
        } else {
            console.log("Recintal");
        } */
        await startLoadTotalDeVotos(form.values);
        await startLoadTotalActasIngresadas(form.values);
        await startLoadTotalJuntas(form.values);
        await startLoadResultadosCandidatos(form.values);
    };

    return (
        <Box
            component="form"
            mx="auto"
            sx={(theme) => ({
                padding: theme.spacing.xs,
            })}
            onSubmit={form.onSubmit((_, e) => handleSubmit(e))}
        >
            <Grid grow gutter="sm" mb={15}>
                <Grid.Col xs={12} sm={6} md={6} lg={3} xl={3}>
                    <Select
                        label="Dignidad"
                        placeholder="Seleccione una Dignidad"
                        searchable
                        clearable
                        nothingFound="No options"
                        disabled
                        {...form.getInputProps("dignidad_id")}
                        data={dignidades.map((dignidad) => {
                            return {
                                label: dignidad.nombre_dignidad,
                                value: dignidad.id,
                            };
                        })}
                    />
                </Grid.Col>
                <Grid.Col xs={12} sm={6} md={6} lg={3} xl={3}>
                    <Select
                        label="Cantón"
                        placeholder="Seleccione una cantón"
                        searchable
                        clearable
                        nothingFound="No options"
                        {...form.getInputProps("canton_id")}
                        data={cantones.map((canton) => {
                            return {
                                label: canton.nombre_canton,
                                value: canton.id,
                            };
                        })}
                    />
                </Grid.Col>
                <Grid.Col xs={12} sm={6} md={6} lg={3} xl={3}>
                    <Select
                        label="Parroquia"
                        placeholder="Seleccione una Parroquia"
                        searchable
                        clearable
                        nothingFound="No options"
                        {...form.getInputProps("parroquia_id")}
                        data={parroquias.map((parroquia) => {
                            return {
                                label: parroquia.nombre_parroquia,
                                value: parroquia.id,
                            };
                        })}
                    />
                </Grid.Col>
                <Grid.Col xs={12} sm={6} md={6} lg={3} xl={3}>
                    <Select
                        label="Recinto"
                        placeholder="Seleccione un Recinto"
                        searchable
                        clearable
                        nothingFound="No options"
                        {...form.getInputProps("recinto_id")}
                        data={recintos.map((recinto) => {
                            return {
                                label: recinto.nombre_recinto,
                                value: recinto.id,
                            };
                        })}
                    />
                </Grid.Col>
                <Grid.Col xs={12} sm={6} md={6} lg={6} xl={6}>
                    <Select
                        label="Actas Cuadradas"
                        placeholder="¿Filtrar actas cuadradas?"
                        nothingFound="No options"
                        {...form.getInputProps("cuadrada")}
                        data={[
                            { label: "Si", value: 1 },
                            { label: "No", value: 0 },
                        ]}
                        defaultValue="Si"
                    />
                </Grid.Col>
                <Grid.Col xs={12} sm={6} md={6} lg={6} xl={6}>
                    <Select
                        label="Actas Legibles"
                        placeholder="¿Filtrar actas legibles?"
                        nothingFound="No options"
                        {...form.getInputProps("legible")}
                        data={[
                            { label: "No", value: 0 },
                            { label: "Si", value: 1 },
                        ]}
                        defaultValue="No"
                    />
                </Grid.Col>
            </Grid>
            <BtnSubmit
                title="Realizar Búsqueda"
                icon={IconDatabaseSearch}
                fullWidth={true}
            />
        </Box>
    );
};
