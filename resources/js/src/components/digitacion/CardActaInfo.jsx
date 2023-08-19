import { Badge, Card, Grid, Group, Text } from "@mantine/core";
import { useActaStore } from "../../hooks";
import { TitleSections } from "../elements/TitleSections";

export const CardActaInfo = () => {
    const { activateJunta } = useActaStore();

    return (
        <Card withBorder shadow="sm" radius="md" mb="md">
            <Card.Section withBorder inheritPadding py="xs">
                <Group position="apart">
                    <TitleSections title={activateJunta.recinto} fw={700} />
                    <Badge
                        variant="filled"
                        radius="sm"
                        size="md"
                        color="indigo.7"
                    >
                        {activateJunta.junta}
                    </Badge>
                </Group>
            </Card.Section>
            <Card.Section withBorder inheritPadding py="xs">
                <Grid grow>
                    <Grid.Col xs={6} sm={6} md={6} lg={6} xl={6}>
                        <TitleSections title="Acta Nº" fz="xs" fw={700} />
                        <TitleSections
                            title={
                                activateJunta.acta_id !== null
                                    ? activateJunta.acta_id
                                    : "[AUTO]"
                            }
                            fz="sm"
                            color="black"
                            fw={500}
                        />
                    </Grid.Col>
                    <Grid.Col xs={6} sm={6} md={6} lg={6} xl={6}>
                        <TitleSections title="Zona:" fz="xs" fw={700} />
                        <TitleSections
                            fz="sm"
                            fw={500}
                            color="black"
                            title={activateJunta.zona}
                        />
                    </Grid.Col>

                    <Grid.Col xs={6} sm={6} md={4} lg={4} xl={4}>
                        <TitleSections title="Provincia:" fz="xs" fw={700} />
                        <TitleSections
                            fz="sm"
                            fw={500}
                            title={activateJunta.provincia}
                            color="black"
                        />
                    </Grid.Col>
                    <Grid.Col xs={6} sm={6} md={4} lg={4} xl={4}>
                        <TitleSections title="Cantón:" fz="xs" fw={700} />
                        <TitleSections
                            fz="sm"
                            fw={500}
                            title={activateJunta.canton}
                            color="black"
                        />
                    </Grid.Col>
                    <Grid.Col xs={6} sm={6} md={4} lg={4} xl={4}>
                        <TitleSections title="Parroquia:" fz="xs" fw={700} />
                        <TitleSections
                            fz="sm"
                            fw={500}
                            title={activateJunta.parroquia}
                            color="black"
                        />
                    </Grid.Col>
                </Grid>
            </Card.Section>
        </Card>
    );
};
