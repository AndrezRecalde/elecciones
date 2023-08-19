import { Avatar, Card, Grid, Group, NumberInput, Text } from "@mantine/core";
import { useCreateStyles } from "../../hooks/styled/useCreateStyles";

import up2 from "../../assets/images/up2.png";
import { useActaStore } from "../../hooks";
import { useEffect } from "react";
import { TitleSections } from "../elements/TitleSections";

export const CardActaDetalleForm = ({ actaForm }) => {
    const { useStyles } = useCreateStyles();
    const { classes } = useStyles();

    const {
        existeActa,
        activateActa,
        selectedFields,
        startLoadCandidatos,
        activateCandidatos,
    } = useActaStore();

    useEffect(() => {
        if (activateActa !== null) {
            startLoadCandidatos(activateActa);
            return;
        }
        startLoadCandidatos(selectedFields);
    }, [activateActa]);

    useEffect(() => {
        if (activateCandidatos !== null) {
            activateCandidatos?.map((candidato, index) =>
                actaForm.setFieldValue(
                    `num_votos.${index}`,
                    candidato?.num_votos ? candidato?.num_votos : ""
                )
            );
            return;
        }
    }, [activateCandidatos]);

    return (
        <Card withBorder shadow="sm" radius="md">
            <Card.Section withBorder inheritPadding py="xs">
                <Group position="apart">
                    <TitleSections title="Asignar Votos" fw={700} />
                </Group>
            </Card.Section>
            <Card.Section withBorder inheritPadding py="lg">
                {activateCandidatos?.map((candidato, index) => (
                    <div className={classes.item} key={candidato.id}>
                        <Grid>
                            <Grid.Col span={2}>
                                <Avatar
                                    src={`/storage${candidato.imagen_url}`}
                                    alt="log"
                                    size="lg"
                                    radius="xl"
                                />
                            </Grid.Col>
                            <Grid.Col span={6}>
                                <div>
                                    <Text
                                        fz="sm"
                                        fw={500}
                                        mb={5}
                                        tt="uppercase"
                                        sx={{ lineHeight: 1 }}
                                    >
                                        {candidato.nombre_candidato}
                                    </Text>
                                    <Text fz="sm" c="dimmed">
                                        {candidato.nombre_organizacion}
                                    </Text>
                                </div>
                                <div>
                                    <Text fz="sm" c="dimmed">
                                        Lista: {candidato.lista}
                                    </Text>
                                </div>
                            </Grid.Col>
                            <Grid.Col span={4}>
                                <NumberInput
                                    hideControls
                                    min={0}
                                    size="md"
                                    {...actaForm.getInputProps(
                                        `num_votos.${index}`
                                    )}
                                />
                            </Grid.Col>
                        </Grid>
                    </div>
                ))}
            </Card.Section>
        </Card>
    );
};
