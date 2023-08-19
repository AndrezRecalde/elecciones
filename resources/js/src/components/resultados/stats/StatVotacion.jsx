import { Card, Grid } from "@mantine/core";
import { useResultadoStore } from "../../../hooks";
import { TitleSections } from "../../../components";

export const StatVotacion = () => {
    const { totalDeVotos } = useResultadoStore();
    return (
        <Grid>
            <Grid.Col xs={12} sm={12} md={12} lg={12} xl={12}>
                <Card
                    withBorder
                    radius="md"
                    p="xl"
                    sx={(theme) => ({
                        backgroundColor:
                            theme.colorScheme === "dark"
                                ? theme.colors.dark[7]
                                : theme.white,
                    })}
                >
                    <TitleSections
                        title="Total Huellas/Firmas"
                        fz="xs"
                        fw={700}
                    />
                    <TitleSections
                        title={`${totalDeVotos?.total_votos_validos} votos`}
                        tt=""
                        color="black"
                        fz="lg"
                        fw={500}
                    />
                </Card>
            </Grid.Col>
            <Grid.Col xs={12} sm={12} md={12} lg={12} xl={12}>
                <Card
                    withBorder
                    radius="md"
                    p="xl"
                    sx={(theme) => ({
                        backgroundColor:
                            theme.colorScheme === "dark"
                                ? theme.colors.dark[7]
                                : theme.white,
                    })}
                >
                    <TitleSections
                        title="Total Votos en Blanco"
                        fz="xs"
                        fw={700}
                    />

                    <TitleSections
                        title={`${
                            totalDeVotos?.total_votos_blancos
                        } votos -${" "}
                        ${(
                            (totalDeVotos?.total_votos_blancos * 100) /
                            totalDeVotos?.total_votos_validos
                        ).toFixed(2)} ${" "}
                        %`}
                        fz="lg"
                        fw={500}
                        color="black"
                        tt=""
                    />
                </Card>
            </Grid.Col>
            <Grid.Col xs={12} sm={12} md={12} lg={12} xl={12}>
                <Card
                    withBorder
                    radius="md"
                    p="xl"
                    sx={(theme) => ({
                        backgroundColor:
                            theme.colorScheme === "dark"
                                ? theme.colors.dark[7]
                                : theme.white,
                    })}
                >
                    <TitleSections title="Total Votos Nulos" fz="xs" fw={700} />

                    <TitleSections title={`${totalDeVotos?.total_votos_nulos} votos -${" "}
                        ${(
                            (totalDeVotos?.total_votos_nulos * 100) /
                            totalDeVotos?.total_votos_validos
                        ).toFixed(2)}${" "}%`} tt="" fz="lg" fw={500} color="black">

                    </TitleSections>
                </Card>
            </Grid.Col>
        </Grid>
    );
};
