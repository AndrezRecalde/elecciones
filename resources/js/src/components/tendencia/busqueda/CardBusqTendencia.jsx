import { Card } from "@mantine/core";
import { isNotEmpty, useForm } from "@mantine/form";
import { BusquedaFormTendencia, TitleSections } from "../../../components";


export const CardBusqTendencia = ({ titlePage }) => {

    const form = useForm({
        initialValues: {
            dignidad_id: "",
            canton_id: "",
            parroquia_id: "",
            zona_id: ""
        },
        validate: {
            dignidad_id: isNotEmpty("Por favor seleccione una dignidad"),
            canton_id: isNotEmpty("Por favor seleccione un cantón"),
            parroquia_id: isNotEmpty("Por favor seleccione una parroquia"),
            zona_id: isNotEmpty("Por favor seleccione una zona")
        },
    })

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
                <TitleSections title={titlePage} fw={700} color="black" />
            </Card.Section>
            <Card.Section inheritPadding mt="sm" pb="lg">
                <BusquedaFormTendencia form={form} />
            </Card.Section>
        </Card>
    );
};
