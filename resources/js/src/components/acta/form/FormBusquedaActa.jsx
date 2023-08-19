import { useEffect } from "react";
import { Grid, Select } from "@mantine/core";
import { useDignidadStore, useStateStore } from "../../../hooks";

export const FormBusquedaActa = ({ form }) => {
    const { canton_id } = form.values;
    const { dignidades } =
        useDignidadStore();
    const {
        startLoadParroquias,
        cantones,
        parroquias,
    } = useStateStore();


    useEffect(() => {
        form.setFieldValue("parroquia_id", 0);
        startLoadParroquias(canton_id);
    }, [canton_id]);

    return (
        <Grid grow gutter="sm">
            <Grid.Col md={6} lg={4}>
                <Select
                    label="Dignidad"
                    placeholder="Seleccione una Dignidad"
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
            <Grid.Col md={6} lg={4}>
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
            <Grid.Col md={6} lg={4}>
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
            <Grid.Col md={12} lg={12}>
                <Select
                    label="Tipo de Acta"
                    placeholder="Seleccione un tipo de Acta"
                    searchable
                    clearable
                    nothingFound="No options"
                    {...form.getInputProps("tipo_acta")}
                    data={[
                        { label: "TODAS", value: "" },
                        { label: "Consistentes", value: 1 },
                        { label: "Inconsistentes", value: 0 },
                    ]}
                />
            </Grid.Col>
        </Grid>
    );
};
