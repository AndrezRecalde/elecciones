import { useEffect, useState } from "react";
import { Box, Grid, Select } from "@mantine/core";
import { isNotEmpty, useForm } from "@mantine/form";
import { IconDatabaseSearch } from "@tabler/icons-react";
import {
    useActaStore,
    useAuthStore,
    useCreateStyles,
    useDignidadStore,
    useStateStore,
} from "../../hooks";
import { BtnSubmit, TitleSections } from "../../components";

export const SeleccionForm = () => {
    const [disabled, setDisabled] = useState(false);
    const { profile } = useAuthStore();
    const { useStyles } = useCreateStyles();
    const { classes } = useStyles();
    const { dignidades, startLoadDignidades } = useDignidadStore();
    const {
        provincias,
        cantones,
        parroquias,
        zonas,
        juntas,
        startLoadProvincias,
        startLoadCantones,
        startLoadParroquias,
        startLoadZonas,
        startLoadJuntas,
    } = useStateStore();
    const {
        searchDisabled,
        startLoadInfoJunta,
        startLoadActa,
        startStorageFields,
        startActivateSearch,
    } = useActaStore();

    const searchForm = useForm({
        initialValues: {
            dignidad_id: "",
            provincia_id: profile?.provincia_id,
            canton_id: "",
            parroquia_id: "",
            zona_id: "",
            junta_id: "",
        },
        validate: {
            dignidad_id: isNotEmpty("Por favor ingrese una dignidad"),
            provincia_id: isNotEmpty("Por favor ingrese la provincia del acta"),
            canton_id: isNotEmpty("Por favor ingrese el cantón del acta"),
            parroquia_id: isNotEmpty("Por favor ingresa la parroquia del acta"),
            zona_id: isNotEmpty("Por favor ingrese la zona del acta"),
            junta_id: isNotEmpty("Por favor ingrese la junta del acta"),
        },
    });

    const {
        dignidad_id,
        provincia_id,
        canton_id,
        parroquia_id,
        zona_id,
        junta_id,
    } = searchForm.values;

    useEffect(() => {
        startLoadDignidades();
        startLoadProvincias();
        startLoadCantones(provincia_id);
    }, []);

    useEffect(() => {
        if (profile.canton_id !== null) {
            searchForm.setFieldValue("canton_id", profile.canton_id);
            setDisabled(true);
            return;
        }
    }, []);

    useEffect(() => {
        searchForm.setFieldValue("parroquia_id", "");
        startLoadParroquias(canton_id);
    }, [canton_id]);

    useEffect(() => {
        searchForm.setFieldValue("zona_id", "");
        startLoadZonas(parroquia_id);
    }, [parroquia_id]);

    useEffect(() => {
        searchForm.setFieldValue("junta_id", "");
        startLoadJuntas(zona_id);
    }, [zona_id]);

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(searchForm.values);
        startStorageFields(searchForm.values);
        startLoadInfoJunta(junta_id);
        startLoadActa(dignidad_id, junta_id);
        startActivateSearch(1);
    };

    return (
        <Box
            component="form"
            mx="auto"
            onSubmit={searchForm.onSubmit((_, e) => handleSubmit(e))}
            mb={15}
        >
            <TitleSections
                title="Acta de escrutinio"
                ta="center"
                fw={700}
                fz={16}
            />
            <Grid mt={10}>
                <Grid.Col xs={4} sm={4} md={2} lg={2} xl={2}>
                    <Select
                        mb={15}
                        radius="sm"
                        label="Provincia"
                        placeholder="Seleccione la Provincia"
                        variant="filled"
                        withAsterisk
                        disabled
                        data={provincias.map((provincia) => {
                            return {
                                value: provincia.id,
                                label: provincia.nombre_provincia,
                            };
                        })}
                        {...searchForm.getInputProps("provincia_id")}
                        classNames={classes}
                    />
                </Grid.Col>
                <Grid.Col xs={4} sm={4} md={2.2} lg={2.2} xl={2.2}>
                    <Select
                        mb={15}
                        radius="sm"
                        label="Dignidad"
                        placeholder="Seleccione la Dignidad"
                        withAsterisk
                        searchable
                        disabled={searchDisabled}
                        data={dignidades.map((dignidad) => {
                            return {
                                value: dignidad.id,
                                label: dignidad.nombre_dignidad,
                            };
                        })}
                        {...searchForm.getInputProps("dignidad_id")}
                        classNames={classes}
                    />
                </Grid.Col>

                <Grid.Col xs={4} sm={4} md={2} lg={2} xl={2}>
                    <Select
                        mb={15}
                        radius="sm"
                        label="Cantón"
                        placeholder="Seleccione el Cantón"
                        withAsterisk
                        searchable
                        disabled={disabled ? disabled : searchDisabled}
                        data={cantones.map((canton) => {
                            return {
                                value: canton.id,
                                label: canton.nombre_canton,
                            };
                        })}
                        {...searchForm.getInputProps("canton_id")}
                        classNames={classes}
                    />
                </Grid.Col>
                <Grid.Col xs={4} sm={4} md={2} lg={2} xl={2}>
                    <Select
                        mb={15}
                        radius="sm"
                        label="Parroquia"
                        placeholder="Seleccione la Parroquia"
                        withAsterisk
                        searchable
                        disabled={searchDisabled}
                        data={parroquias.map((parroquia) => {
                            return {
                                value: parroquia.id,
                                label: parroquia.nombre_parroquia,
                            };
                        })}
                        {...searchForm.getInputProps("parroquia_id")}
                        classNames={classes}
                    />
                </Grid.Col>
                <Grid.Col xs={4} sm={4} md={2} lg={2} xl={2}>
                    <Select
                        mb={15}
                        radius="sm"
                        label="Zona"
                        placeholder="Seleccione la Zona"
                        withAsterisk
                        searchable
                        disabled={searchDisabled}
                        data={zonas.map((zona) => {
                            return {
                                value: zona.id,
                                label: zona.nombre_zona,
                            };
                        })}
                        {...searchForm.getInputProps("zona_id")}
                        classNames={classes}
                    />
                </Grid.Col>
                <Grid.Col xs={4} sm={4} md={1.8} lg={1.8} xl={1.8}>
                    <Select
                        mb={15}
                        radius="sm"
                        label="Junta"
                        placeholder="Seleccione la Junta"
                        withAsterisk
                        searchable
                        disabled={searchDisabled}
                        data={juntas.map((junta) => {
                            return {
                                value: junta.id,
                                label: junta.junta_nombre,
                            };
                        })}
                        {...searchForm.getInputProps("junta_id")}
                        classNames={classes}
                    />
                </Grid.Col>
            </Grid>
            <BtnSubmit
                title="Buscar acta"
                fullWidth={true}
                btnDisabled={searchDisabled}
                icon={IconDatabaseSearch}
            />
        </Box>
    );
};
