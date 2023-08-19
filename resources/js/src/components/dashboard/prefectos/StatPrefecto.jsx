import {
    Progress,
    Box,
    Text,
    Group,
    Paper,
    SimpleGrid,
    rem,
} from "@mantine/core";
import { IconArrowUpRight, IconBuildingSkyscraper } from "@tabler/icons-react";

export const StatPrefecto = ({ classes, data }) => {
    const segments = data.map((segment) => ({
        value: segment.part,
        color: segment.color,
        label: segment.part > 10 ? `${segment.part}%` : undefined,
    }));

    const descriptions = data.map((stat) => (
        <Box
            key={stat.label}
            sx={{ borderBottomColor: stat.color }}
            className={classes.stat}
        >
            <Text tt="uppercase" fz="xs" c="dimmed" fw={700}>
                {stat.label}
            </Text>

            <Group position="apart" align="flex-end" spacing={0}>
                <Text fw={700}>{stat.count}</Text>
                <Text
                    c={stat.color}
                    fw={700}
                    size="sm"
                    className={classes.statCount}
                >
                    {stat.part}%
                </Text>
            </Group>
        </Box>
    ));

    return (
        <Paper withBorder p="md" radius="md">
            <Group position="apart">
                <Group align="flex-end" spacing="xs">
                    <Text fz="xl" fw={700} c="gray">
                        345,765
                    </Text>
                    <Text c="dimgray" className={classes.diff} fz="sm" fw={700}>
                        <span>18%</span>
                        <IconArrowUpRight
                            size="1rem"
                            style={{ marginBottom: rem(4) }}
                            stroke={1.5}
                        />
                    </Text>
                </Group>
                <IconBuildingSkyscraper
                    size="1.8rem"
                    className={classes.icon}
                    stroke={1.5}
                />
            </Group>

            <Text c="dimmed" fz="sm">
                Total de actas ingresadas por la dignidad de{" "}
                <Text fz={18} fw={700}>Prefectura</Text>
            </Text>

            <Progress
                sections={segments}
                size={34}
                classNames={{ label: classes.progressLabel }}
                mt={40}
            />
            <SimpleGrid
                cols={2}
                breakpoints={[{ maxWidth: "xs", cols: 1 }]}
                mt="xl"
            >
                {descriptions}
            </SimpleGrid>
        </Paper>
    );
}
