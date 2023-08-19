import { Card, Group } from "@mantine/core";
import { BusquedaForm, TitleSections } from "../../../components";
import { useForm } from "@mantine/form";

export const CardBusquedaDignidad = ({ titlePage, dig }) => {
    const form = useForm({
        initialValues: {
            dignidad_id: dig,
            canton_id: 0,
            parroquia_id: 0,
            recinto_id: 0,
            cuadrada: "",
            legible: "",
        },
        transformValues: (values) => ({
            canton_id: Number(values.canton_id) || 0,
            parroquia_id: Number(values.parroquia_id) || 0,
            recinto_id: Number(values.recinto_id) || 0,
        }),
    });

    return (
        <Card
            withBorder
            shadow="sm"
            p="lg"
            mt={10}
            mb={20}
            radius="md"
            sx={{ position: "static" }}
        >
            <Card.Section withBorder inheritPadding py="md">
                <Group position="apart">
                    <TitleSections title={titlePage} fw={700} color="black" />
                </Group>
            </Card.Section>
            <Card.Section inheritPadding mt="sm" pb="lg">
                <BusquedaForm form={form} />
            </Card.Section>
        </Card>
    );
};
