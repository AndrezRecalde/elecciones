import { Badge, Group } from "@mantine/core";
import { useFechaActual } from "../../../hooks";

export const FechaActual = () => {
    const { fechaActual } = useFechaActual();

    return (
        <Group position="center">
            <Badge mt={3} size="lg" radius="sm" color="indigo.7">
                {`Fecha & Hora del reporte: ${fechaActual()}`}
            </Badge>
        </Group>
    );
};
