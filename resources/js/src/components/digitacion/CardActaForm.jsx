import { Card, Grid, Group, NumberInput, Text, TextInput } from "@mantine/core";
import { useCreateStyles } from "../../hooks";
import { TitleSections } from "../elements/TitleSections";

export const CardActaForm = ({ actaForm }) => {
    const { useStyles } = useCreateStyles();
    const { classes } = useStyles();

    return (
        <Card withBorder shadow="sm" radius="md">
            <Card.Section withBorder inheritPadding py="xs">
                <Group position="apart">
                    <TitleSections title="Rellena los campos del acta" fw={700} />
                </Group>
            </Card.Section>
            <Card.Section withBorder inheritPadding py="xs">
                <Grid>
                    <Grid.Col xs={12} sm={12} md={6} lg={6} xl={6}>
                        <TextInput
                            label="Código CNE"
                            placeholder="Digita el código CNE"
                            classNames={classes}
                            {...actaForm.getInputProps("cod_cne")}
                        />
                    </Grid.Col>
                    <Grid.Col xs={12} sm={12} md={6} lg={6} xl={6}>
                        <NumberInput
                            label="Total Firmas y Huellas"
                            placeholder="Registra el total de Firmas y Huellas"
                            classNames={classes}
                            hideControls
                            min={0}
                            {...actaForm.getInputProps("votos_validos")}
                        />
                    </Grid.Col>
                    <Grid.Col xs={12} sm={12} md={6} lg={6} xl={6}>
                        <NumberInput
                            label="Votos en Blanco"
                            placeholder="Registra los votos en blanco"
                            classNames={classes}
                            hideControls
                            min={0}
                            {...actaForm.getInputProps("votos_blancos")}
                        />
                    </Grid.Col>
                    <Grid.Col xs={12} sm={12} md={6} lg={6} xl={6}>
                        <NumberInput
                            label="Votos Nulos"
                            placeholder="Registra los votos nulos"
                            classNames={classes}
                            hideControls
                            min={0}
                            {...actaForm.getInputProps("votos_nulos")}
                        />
                    </Grid.Col>
                </Grid>
            </Card.Section>
        </Card>
    );
};
