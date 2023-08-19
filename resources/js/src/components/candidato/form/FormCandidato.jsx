import { useEffect } from "react";
import { Box, Button, Grid, Group, Select, TextInput } from "@mantine/core";
import { IconPlus } from "@tabler/icons-react";
import {
    useCandidatoStore,
    useDignidadStore,
    useDistritoStore,
    useOrganizacionStore,
    useStateStore,
    useUiCandidato,
} from "../../../hooks";
import { BtnSubmit } from "../../elements/btn/BtnSubmit";

export const FormCandidato = ({ form }) => {
    const { provincia_id, canton_id, dignidad_id } = form.values;
    const { modalActionCandidato } = useUiCandidato();
    const { activateCandidato, startAddCandidato, setClearActivateCandidato } =
        useCandidatoStore();
    const { organizaciones, startLoadOrganizaciones } = useOrganizacionStore();
    const { dignidades, startLoadDignidades } = useDignidadStore();
    const { distritos, startLoadDistritos } = useDistritoStore();
    const {
        provincias,
        cantones,
        parroquias,
        startLoadProvincias,
        startLoadCantones,
        startLoadParroquias,
    } = useStateStore();

    useEffect(() => {
        startLoadOrganizaciones();
        startLoadDignidades();
        startLoadDistritos();
        startLoadProvincias();

        return () => {
            setClearActivateCandidato();
        };
    }, []);

    useEffect(() => {
        startLoadCantones(provincia_id);
        form.setFieldValue("canton_id", activateCandidato?.canton_id ?? "");
    }, [provincia_id]);

    useEffect(() => {
        startLoadParroquias(canton_id);
        form.setFieldValue(
            "parroquia_id",
            activateCandidato?.parroquia_id ?? ""
        );
    }, [canton_id]);

    useEffect(() => {
        if (activateCandidato !== null) {
            form.setValues({
                ...activateCandidato,
            });
            return;
        }
    }, [activateCandidato]);

    const handleSubmit = (e) => {
        e.preventDefault();
        startAddCandidato(form.values);
        form.reset();
        modalActionCandidato(0);
    };

    return (
        <Box
            component="form"
            mx="auto"
            sx={(theme) => ({
                padding: theme.spacing.md,
            })}
            onSubmit={form.onSubmit((_, e) => handleSubmit(e))}
        >
            <Grid>
                <Grid.Col sm={12} md={6} lg={6} xl={6}>
                    <Select
                        label="Tipo de Organización"
                        placeholder="Seleccione el tipo de organización"
                        searchable
                        nothingFound="No options"
                        {...form.getInputProps("organizacion_id")}
                        data={organizaciones.map((org) => {
                            return {
                                label: org.nombre_organizacion,
                                value: org.id,
                            };
                        })}
                    />
                </Grid.Col>
                <Grid.Col sm={12} md={6} lg={6} xl={6}>
                    <Select
                        label="Tipo de Dignidad"
                        placeholder="Seleccione el tipo de dignidad"
                        searchable
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
                <Grid.Col sm={12} md={12} lg={12} xl={12}>
                    <TextInput
                        placeholder="Nombres del candidato"
                        label="Nombres candidato"
                        {...form.getInputProps("nombre_candidato")}
                    />
                </Grid.Col>
                <Grid.Col sm={12} md={6} lg={6} xl={6}>
                    <Select
                        label="Activo"
                        placeholder="Activo"
                        searchable
                        nothingFound="No options"
                        {...form.getInputProps("activo")}
                        data={[
                            { label: "Sí", value: 1 },
                            { label: "No", value: 0 },
                        ]}
                    />
                </Grid.Col>
                <Grid.Col sm={12} md={6} lg={6} xl={6}>
                    <Select
                        label="Distrito"
                        placeholder="Seleccione el tipo de distrito"
                        searchable
                        nothingFound="No options"
                        {...form.getInputProps("distrito_id")}
                        data={distritos.map((distrito) => {
                            return {
                                label: distrito.tipo_distrito,
                                value: distrito.id,
                            };
                        })}
                    />
                </Grid.Col>
                <Grid.Col sm={12} md={12} lg={12} xl={12}>
                    <Select
                        label="Provincia"
                        placeholder="Seleccione la provincia"
                        searchable
                        nothingFound="No options"
                        {...form.getInputProps("provincia_id")}
                        data={provincias.map((provincia) => {
                            return {
                                label: provincia.nombre_provincia,
                                value: provincia.id,
                            };
                        })}
                    />
                </Grid.Col>
                {dignidad_id === 4 || dignidad_id === 5 || dignidad_id === 6 ? (
                    <Grid.Col sm={12} md={12} lg={12} xl={12}>
                        <Select
                            label="Cantón"
                            placeholder="Seleccione el cantón"
                            searchable
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
                ) : null}
                {dignidad_id === 7 ? (
                    <Grid.Col sm={12} md={12} lg={12} xl={12}>
                        <Select
                            label="Parroquia"
                            placeholder="Seleccione la parroquia"
                            searchable
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
                ) : null}
            </Grid>
            <BtnSubmit title="Agregar candidato" icon={IconPlus} />
        </Box>
    );
};
