import {
    Progress,
    Box,
    Text,
    Group,
    Paper,
    SimpleGrid,
    rem,
} from "@mantine/core";
import { IconArrowUpRight, IconBuildingBank } from "@tabler/icons-react";
import { TitleSections } from "../../elements/TitleSections";

export const StatDashboard = ({ classes, escrutinio }) => {
    return (
        <Paper withBorder p="md" radius="md">
            <Group position="apart">
                <Group align="flex-end" spacing="xs">
                    <TitleSections
                        fz="xl"
                        fw={700}
                        title={1402}
                        color="black"
                    />
                    <Text c="teal" className={classes.diff} fz="sm" fw={700}>
                        <span>{Math.floor(Math.random() * 18)}%</span>
                        <IconArrowUpRight
                            size="1rem"
                            style={{ marginBottom: rem(4) }}
                            stroke={1.5}
                        />
                    </Text>
                </Group>
                <IconBuildingBank
                    size="1.8rem"
                    className={classes.icon}
                    stroke={1.5}
                />
            </Group>

            <Text c="dimmed" fz="sm">
                Total de actas ingresadas por la dignidad de{" "}
                <Text fz={18} fw={700}>
                    {escrutinio?.nombre_dignidad}
                </Text>
            </Text>

            <Progress
                sections={[
                    {
                        value: escrutinio.porcentaje,
                        color: "#47d6ab",
                        label:
                            escrutinio.porcentaje > 10
                                ? `${escrutinio.porcentaje}%`
                                : undefined,
                        tooltip: `${escrutinio.porcentaje}%`,
                    },
                    {
                        value: 100 - escrutinio.porcentaje,
                        color: "#03141a",
                        label:
                            100 - escrutinio.porcentaje > 10
                                ? `${100 - escrutinio.porcentaje}%`
                                : undefined,
                        tooltip: `${100 - escrutinio.porcentaje}%`,
                    },
                ]}
                size={34}
                classNames={{ label: classes.progressLabel }}
                mt={40}
            />
            <SimpleGrid
                cols={2}
                breakpoints={[{ maxWidth: "xs", cols: 1 }]}
                mt="xl"
            >
                <Box
                    sx={{ borderBottomColor: "#47d6ab" }}
                    className={classes.stat}
                >
                    <TitleSections fz="xs" fw={700} title="Actas Ingresadas" />

                    <Group position="apart" align="flex-end" spacing={0}>
                        <TitleSections title={escrutinio.total_ingresadas} color="teal.7" fw={700} />

                        <Text
                            c="#47d6ab"
                            fw={700}
                            size="sm"
                            className={classes.statCount}
                        >
                            {escrutinio.porcentaje} %
                        </Text>
                    </Group>
                </Box>
                <Box
                    sx={{ borderBottomColor: "#03141a" }}
                    className={classes.stat}
                >
                    <TitleSections
                        fz="xs"
                        c="dimmed"
                        fw={700}
                        title="Actas por Ingresar"
                    />

                    <Group position="apart" align="flex-end" spacing={0}>
                        <TitleSections
                            color="black"
                            fz={16}
                            fw={700}
                            title={1402 - escrutinio.total_ingresadas}
                        />

                        <Text
                            c="#03141a"
                            fw={700}
                            size="sm"
                            className={classes.statCount}
                        >
                            {100 - escrutinio.porcentaje} %
                        </Text>
                    </Group>
                </Box>
            </SimpleGrid>
        </Paper>
    );
};
