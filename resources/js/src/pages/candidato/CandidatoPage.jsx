import { useEffect } from "react";
import { Card } from "@mantine/core";
import {
    ModalActivateCandidato,
    ModalCandidato,
    TableCandidatos,
    TitleSections,
} from "../../components";
import { useCandidatoStore } from "../../hooks";

export const CandidatoPage = () => {
    const { startLoadCandidatos, startClearCandidatos } = useCandidatoStore();

    useEffect(() => {
        startLoadCandidatos();

        return () => {
            startClearCandidatos();
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
                    <TitleSections title="Lista de Candidatos" color="black" ta="center" fw={700} />
                </Card.Section>

                <Card.Section withBorder inheritPadding py="lg">
                    <TableCandidatos />
                </Card.Section>
            </Card>
            <ModalCandidato />
            <ModalActivateCandidato />
        </>
    );
};
