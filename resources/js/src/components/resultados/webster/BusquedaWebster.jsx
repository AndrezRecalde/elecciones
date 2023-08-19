import { useForm } from "@mantine/form";
import { Card } from "@mantine/core";
import { BusqWebsterForm, TitleSections } from "../../../components";

export const BusquedaWebster = ({ dig }) => {
    const form = useForm({
        initialValues: {
            dignidad_id: dig,
            canton_id: "",
        },
    });

    return (
        <Card
            withBorder
            shadow="sm"
            p="lg"
            radius="md"
            sx={{ position: "static", height: "310px" }}
        >
            <Card.Section withBorder inheritPadding py="xs">
                <TitleSections title="Filtros" fw={500} color="black" />
            </Card.Section>
            <Card.Section inheritPadding mt="sm" pb="lg">
                <BusqWebsterForm form={form} />
            </Card.Section>
        </Card>
    );
};
