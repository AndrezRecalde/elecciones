import { Card, Text, Title } from "@mantine/core";
import { EscrutinioParcial } from "./escrutinio/EscrutinioParcial";
import { useResultadoStore } from "../../../hooks";
import { TitleSections } from "../../elements/TitleSections";

export const StatEscrutinio = () => {
    const { totalActasIngresadas, totalJuntas } = useResultadoStore();

    return (
        //<Flex justify="center" align="center">
        <Card withBorder p="lg">
            <Card.Section withBorder inheritPadding py="xs">
                <TitleSections fz="xs" fw={700} title="Total Actas" />
            </Card.Section>
            <Card.Section withBorder inheritPadding py="xs">
                <EscrutinioParcial />
            </Card.Section>
            <Card.Section withBorder inheritPadding py="xs">
                <TitleSections
                    title={`${
                        totalJuntas?.total - totalActasIngresadas?.digitadas ===
                        0
                            ? "Actas 100% Ingresadas"
                            : `Faltan: ${
                                  totalJuntas?.total -
                                  totalActasIngresadas?.digitadas
                              } actas`
                    }`}
                    fz={14}
                    fw={700}
                    ta="center"
                    color="indigo.7"
                />
            </Card.Section>
        </Card>
        //</Flex>
    );
};
