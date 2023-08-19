import { useEffect } from "react";
import { Box, Grid } from "@mantine/core";
import { isNotEmpty, useForm } from "@mantine/form";
import { useActaStore } from "../../hooks";
import {
    TitleSections,
    NovedadActaForm,
    CardActaDetalleForm,
    CardActaForm,
    CardActaInfo,
} from "../../components";

export const ActaPage = () => {
    const {
        activateActa,
        existeActa,
        selectedFields,
        startAddActa,
        startUpdateActa,
    } = useActaStore();

    const actaForm = useForm({
        initialValues: {
            cod_cne: "",
            votos_validos: "",
            votos_blancos: "",
            votos_nulos: "",
            cuadrada: false,
            legible: false,
            num_votos: [],
        },
        validate: {
            votos_validos: isNotEmpty(
                "Por favor ingrese el Total de Firmas y Huellas"
            ),
            votos_blancos: isNotEmpty("Por favor ingrese los votos blancos"),
            votos_nulos: isNotEmpty("Por favor ingrese los votos nulos"),
        },
        transformValues: (values) => ({
            votos_blancos: Number(values.votos_blancos) || 0,
            votos_nulos: Number(values.votos_nulos) || 0,
        }),
    });

    useEffect(() => {
        if (activateActa !== null) {
            actaForm.setValues({
                cod_cne:
                    activateActa?.cod_cne !== null ? activateActa?.cod_cne : "",
                votos_validos: parseInt(activateActa?.votos_validos)
                    ? parseInt(activateActa?.votos_validos)
                    : "",
                votos_blancos: parseInt(activateActa?.votos_blancos)
                    ? parseInt(activateActa?.votos_blancos)
                    : 0,
                votos_nulos: parseInt(activateActa?.votos_nulos)
                    ? parseInt(activateActa?.votos_nulos)
                    : 0,
                cuadrada: activateActa?.cuadrada,
                legible: activateActa?.legible,
            });
            return;
        }
    }, [activateActa]);

    const handleSubmit = (e) => {
        e.preventDefault();
        if (existeActa) {
            startUpdateActa(activateActa.id, selectedFields, actaForm.values);
            actaForm.reset();
            return;
        }
        startAddActa(selectedFields, actaForm.values);
        actaForm.reset();
    };

    return (
        <>
            <TitleSections
                title={`${
                    selectedFields.dignidad_id === 1
                        ? "Presidentes y Vicepresidentes"
                        : "Asambleístas Provinciales"
                }`}
                color="black"
                ta="center"
                fw={700}
                fz={18}
            />
            <Box
                component="form"
                onSubmit={actaForm.onSubmit((_, e) => handleSubmit(e))}
                mt={15}
            >
                <Grid>
                    <Grid.Col xs={12} sm={12} md={6} lg={6} xl={6}>
                        <CardActaInfo />
                    </Grid.Col>
                    <Grid.Col xs={12} sm={12} md={6} lg={6} xl={6}>
                        <CardActaForm actaForm={actaForm} />
                    </Grid.Col>
                    <Grid.Col xs={12} sm={12} md={6} lg={6} xl={6}>
                        <CardActaDetalleForm actaForm={actaForm} />
                    </Grid.Col>
                    <Grid.Col xs={12} sm={12} md={6} lg={6} xl={6}>
                        <NovedadActaForm actaForm={actaForm} />
                    </Grid.Col>
                </Grid>
            </Box>
        </>
    );
};
