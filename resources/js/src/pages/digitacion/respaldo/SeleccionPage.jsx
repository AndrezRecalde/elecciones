import { ActionIcon, Card, Container, Grid, Group, Text } from "@mantine/core";
import { useEffect, useState } from "react";
import { IconChevronsLeft } from "@tabler/icons-react";
import { SeleccionForm } from "../../../components/digitacion/respaldo/SeleccionForm";


export const SeleccionPage = () => {
    const [title, setTitle] = useState("Elecciones | Digitación");

    useEffect(() => {
        document.title = title;

        return () => {
            setTitle("");
        };
    }, []);

    return (
        <Container>
            <Grid justify="center">
                <Grid.Col sm={6} md={6} lg={6} xl={6}>
                    <Card
                        withBorder
                        shadow="sm"
                        radius="sm"
                        sx={{ position: "static" }}
                    >
                        <Card.Section withBorder inheritPadding py="xs">
                            <Group position="apart">
                                <Text
                                    tt="uppercase"
                                    color="dimmed"
                                    weight={700}
                                >
                                    Digitar Actas
                                </Text>
                                <ActionIcon variant="transparent">
                                    <IconChevronsLeft size="1.2rem" />
                                </ActionIcon>
                            </Group>
                        </Card.Section>
                        <Card.Section
                            withBorder
                            inheritPadding
                            py="xs"
                        >
                            <SeleccionForm />
                        </Card.Section>
                    </Card>
                </Grid.Col>
            </Grid>
        </Container>
    );
};
