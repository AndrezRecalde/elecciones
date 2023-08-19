import { useEffect } from "react";
import { Badge, Container, Divider, Group } from "@mantine/core";
import { ChartEscrutinio, TablaEscrutinio, TitleSections } from "../../components";
import { useEscrutinioStore, useFechaActual } from "../../hooks";

export const EscrutinioPage = () => {
    const { fechaActual } = useFechaActual();
    const { startLoadEscrutinio, startClearEscrutinio } = useEscrutinioStore();

    useEffect(() => {
        startLoadEscrutinio();

      return () => {
        startClearEscrutinio();
      }
    }, []);


    return (
        <Container size="lg">
            <TitleSections
                title="Avance de Escrutinio por Dignidades"
                ta="center"
                color="black"
                fw={700}
                fz={16}
            />
            <Group position="center">
                <Badge size="lg" radius="md" color="indigo.7">
                    {`Fecha & Hora del reporte: ${fechaActual()}`}
                </Badge>
            </Group>
            <Divider my="sm" />
            <ChartEscrutinio />
            <TablaEscrutinio />
        </Container>
    );
};
