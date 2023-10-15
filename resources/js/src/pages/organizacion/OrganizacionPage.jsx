import { Card } from "@mantine/core";
import {
    ModalOrganizacion,
    TableOrganizaciones,
    TitleSections,
} from "../../components";
import { useOrganizacionStore } from "../../hooks";
import { useEffect, useState } from "react";

export const OrganizacionPage = () => {
    const [title, setTitle] = useState("Elecciones | Organizaciones");
    const { startLoadOrganizaciones, startClearOrganizaciones } =
        useOrganizacionStore();

    useEffect(() => {
        document.title = title;
        startLoadOrganizaciones();

        return () => {
            startClearOrganizaciones();
            setTitle("");
        };
    }, []);

    return (
        <>
            <Card
                withBorder
                radius="md"
                mt="lg"
                mb="lg"
                sx={{ position: "static" }}
            >
                <Card.Section withBorder inheritPadding py="lg">
                    <TitleSections title="Lista de Organizaciones" fw={700} color="black" />
                </Card.Section>

                <Card.Section withBorder inheritPadding py="lg">
                    <TableOrganizaciones />
                </Card.Section>
            </Card>
            <ModalOrganizacion />
        </>
    );
};
