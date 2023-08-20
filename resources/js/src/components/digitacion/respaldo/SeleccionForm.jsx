import {
    ActionIcon,
    Box,
    Button,
    Flex,
    Select,
} from "@mantine/core";
import { isNotEmpty, useForm } from "@mantine/form";
import { useEffect } from "react";
import { useDignidadStore } from "../../../hooks/dignidad/useDignidadStore";
import { useStateStore } from "../../../hooks/state/useStateStore";
import { IconChevronsLeft } from "@tabler/icons-react";
import { useCreateStyles } from "../../../hooks/styled/useCreateStyles";

export const SeleccionForm = () => {
    const { useStyles } = useCreateStyles();
    const { classes } = useStyles();
    const { dignidades, startLoadDignidades, startClearDignidades } =
        useDignidadStore();

    const {
        provincias,
        cantones,
        parroquias,
        zonas,
        juntas,
        startLoadProvincia,
        startLoadCantones,
        startLoadParroquias,
        startLoadZonas,
        startLoadJuntas,
    } = useStateStore();

    const seleccion = useForm({
        initialValues: {
            dignidad_id: "",
            provincia_id: 8,
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

    const { provincia_id, canton_id, parroquia_id, zona_id } = seleccion.values;

    useEffect(() => {
        startLoadDignidades();
        startLoadProvincia(8); //Reemplazarlo por el provincia_id del usuario
        startLoadCantones(provincia_id); //Reemplazarlo por el provincia_id del usuario
        return () => {
            startClearDignidades();
        };
    }, []);

    useEffect(() => {
        seleccion.setFieldValue("parroquia_id", "");
        startLoadParroquias(canton_id);
    }, [canton_id]);

    useEffect(() => {
        seleccion.setFieldValue("zona_id", "");
        startLoadZonas(parroquia_id);
    }, [parroquia_id]);

    useEffect(() => {
        seleccion.setFieldValue("junta_id", "");
        startLoadJuntas(zona_id);
    }, [zona_id]);

    const handleSubmit = (e) => {
        e.preventDefault();
        //console.log(seleccion.values);
    };

    return (
        <Box
            component="form"
            mx="auto"
            onSubmit={seleccion.onSubmit((_, e) => handleSubmit(e))}
            sx={(theme) => ({
                padding: theme.spacing.sm,
            })}
        >
            <Select
                mb={15}
                radius="sm"
                label="Dignidad"
                placeholder="Seleccione la Dignidad"
                withAsterisk
                searchable
                data={dignidades.map((dignidad) => {
                    return {
                        value: dignidad.id,
                        label: dignidad.nombre_dignidad,
                    };
                })}
                {...seleccion.getInputProps("dignidad_id")}
                classNames={classes}
            />
            <Select
                mt={15}
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
                {...seleccion.getInputProps("provincia_id")}
                classNames={classes}
            />
            <Select
                mt={15}
                mb={15}
                radius="sm"
                label="Cantón"
                placeholder="Seleccione el Cantón"
                withAsterisk
                searchable
                data={cantones.map((canton) => {
                    return {
                        value: canton.id,
                        label: canton.nombre_canton,
                    };
                })}
                {...seleccion.getInputProps("canton_id")}
                classNames={classes}
            />
            <Select
                mt={15}
                mb={15}
                radius="sm"
                label="Parroquia"
                placeholder="Seleccione la Parroquia"
                withAsterisk
                searchable
                data={parroquias.map((parroquia) => {
                    return {
                        value: parroquia.id,
                        label: parroquia.nombre_parroquia,
                    };
                })}
                {...seleccion.getInputProps("parroquia_id")}
                classNames={classes}
            />
            <Select
                mt={15}
                mb={15}
                radius="sm"
                label="Zona"
                placeholder="Seleccione la Zona"
                withAsterisk
                searchable
                data={zonas.map((zona) => {
                    return {
                        value: zona.id,
                        label: zona.nombre_zona,
                    };
                })}
                {...seleccion.getInputProps("zona_id")}
                classNames={classes}
            />
            <Select
                mt={15}
                mb={15}
                radius="sm"
                label="Junta"
                placeholder="Seleccione la Junta"
                withAsterisk
                searchable
                data={juntas.map((junta) => {
                    return {
                        value: junta.id,
                        label: junta.junta_nombre,
                    };
                })}
                {...seleccion.getInputProps("junta_id")}
                classNames={classes}
            />

            <Flex
                gap="xs"
                align="center"
                direction="row"
                mt={25}
            >
                <ActionIcon variant="filled" size="xl" color="red.8">
                    <IconChevronsLeft />
                </ActionIcon>

                <Button type="submit" fullWidth size="md" radius="sm" color="blue.8">
                    Digitar Acta
                </Button>
            </Flex>
        </Box>
    );
};
