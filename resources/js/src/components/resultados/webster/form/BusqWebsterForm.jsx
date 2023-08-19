import { useEffect } from "react";
import { Box, Grid, Select } from "@mantine/core";
import { IconDatabaseSearch } from "@tabler/icons-react";
import {
    useAuthStore,
    useDignidadStore,
    useResultadoStore,
    useStateStore,
} from "../../../../hooks";
import { BtnSubmit } from "../../../../components";

export const BusqWebsterForm = ({ form }) => {
    const { profile } = useAuthStore();
    const { dignidades, startLoadDignidades, startClearDignidades } =
        useDignidadStore();
    const { cantones, startLoadCantones } = useStateStore();
    const {
        startLoadTotalDeVotos,
        startLoadTotalActasIngresadas,
        startLoadTotalJuntas,
        startLoadResultadosCandidatos,
    } = useResultadoStore();

    useEffect(() => {
        startLoadDignidades();
        startLoadCantones(profile.provincia_id);

        return () => {
            startClearDignidades();
        };
    }, []);

    const handleSubmit = async (e) => {
        e.preventDefault();
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
            <Grid grow gutter="sm" mb={20}>
                <Grid.Col md={12} lg={12}>
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
                <Grid.Col md={12} lg={12}>
                    <Select
                        label="Cantón"
                        placeholder="Seleccione un cantón"
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
            </Grid>

            <BtnSubmit title="Realizar Búsqueda" icon={IconDatabaseSearch} />
        </Box>
    );
};
