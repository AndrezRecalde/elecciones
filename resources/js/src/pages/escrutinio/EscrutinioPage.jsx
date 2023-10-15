import { useEffect } from "react";
import { Badge, Divider, Group } from "@mantine/core";
import { ChartEscrutinio, TablaEscrutinio, TitleSections } from "../../components";
import { useEscrutinioStore, useFechaActual } from "../../hooks";
import { useNavigate } from "react-router-dom";
import { useState } from "react";

export const EscrutinioPage = () => {
    const navigate = useNavigate();
    const [title, setTitle] = useState("Elecciones | Escrutinio");
    const { fechaActual } = useFechaActual();
    const { startLoadEscrutinio, startClearEscrutinio, errores } = useEscrutinioStore();

    useEffect(() => {
        document.title = title;
        startLoadEscrutinio();

      return () => {
        startClearEscrutinio();
        setTitle("");
      }
    }, []);

    useEffect(() => {
        if (errores !== undefined) {
            if (errores === '403'){
                navigate("/error/403");
                return;
            }
        }
    }, [errores]);


    return (
        <>
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
        </>
    );
};
