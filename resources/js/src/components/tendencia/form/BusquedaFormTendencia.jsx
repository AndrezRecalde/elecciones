import { useEffect } from "react";
import { Box, Grid, Select } from "@mantine/core";
import { IconDatabaseSearch } from "@tabler/icons-react";
import {
    useAuthStore,
    useDignidadStore,
    useStateStore,
    useTendenciaStore,
} from "../../../hooks";
import { BtnSubmit } from "../../../components";

export const BusquedaFormTendencia = ({ form }) => {
    const { canton_id, parroquia_id } = form.values;
    const { profile } = useAuthStore();
    const { dignidades, startLoadDignidades, startClearDignidades } =
        useDignidadStore();
    const {
        cantones,
        parroquias,
        zonas,
        startLoadCantones,
        startLoadParroquias,
        startLoadZonas,
    } = useStateStore();
    const { startLoadTendencias } = useTendenciaStore();

    useEffect(() => {
        startLoadDignidades();
        startLoadCantones(profile?.provincia_id);

        return () => {
            startClearDignidades();
        };
    }, []);

    useEffect(() => {
        startLoadParroquias(canton_id);
        form.setFieldValue("parroquia_id", "");
    }, [canton_id]);

    useEffect(() => {
        form.setFieldValue("zona_id", "");
        startLoadZonas(parroquia_id);
    }, [parroquia_id]);

    const handleSubmit = (e) => {
        e.preventDefault();
        //console.log(form.values);
        startLoadTendencias(form.values);
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
            <Grid grow gutter="sm" mb={20}>
                <Grid.Col xs={12} sm={6} md={6} lg={3} xl={3}>
                    <Select
                        label="Dignidad"
                        placeholder="Seleccione una Dignidad"
                        searchable
                        clearable
                        nothingFound="No options"
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
                        label="Zona"
                        placeholder="Seleccione una Zona"
                        searchable
                        clearable
                        nothingFound="No options"
                        {...form.getInputProps("zona_id")}
                        data={zonas.map((zona) => {
                            return {
                                label: zona.nombre_zona,
                                value: zona.id,
                            };
                        })}
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
