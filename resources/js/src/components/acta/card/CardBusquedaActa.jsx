import { Box, Button, Card, Group } from "@mantine/core";
import { IconDatabase, IconDatabaseExport } from "@tabler/icons-react";
import { FormBusquedaActa, TitleSections, BtnSubmit } from "../..";
import { isNotEmpty, useForm } from "@mantine/form";
import { useActasResStore } from "../../../hooks";

export const CardBusquedaActa = ({ titlePage }) => {
    const {
        startLoadActas,
        startLoadAllActas,
        startExportExcelActas,
        startExportExcelActasAll,
    } = useActasResStore();

    const form = useForm({
        initialValues: {
            dignidad_id: 0,
            canton_id: 0,
            parroquia_id: 0,
            tipo_acta: "",
        },
        validate: {
            dignidad_id: isNotEmpty("Por favor ingrese la dignidad"),
        },
    });

    const { tipo_acta, canton_id, parroquia_id } = form.values;

    const handleSearch = (e) => {
        e.preventDefault();
        const { errors } = form.validate();
        if (!errors.hasOwnProperty("dignidad_id")) {
            if (!tipo_acta) {
                startLoadAllActas(form.values);
                //console.log(form.values);
                form.reset();
            } else if (tipo_acta) {
                startLoadActas(form.values);
                //console.log(form.values);
                form.reset();
            }
        }
    };

    const handleExportExcel = (e) => {
        e.preventDefault();
        const { errors } = form.validate();
        if (!errors.hasOwnProperty("dignidad_id")) {
            if (!tipo_acta) {
                startExportExcelActasAll(form.values);
                //console.log(form.values);
                form.reset();
            } else if (tipo_acta) {
                startExportExcelActas(form.values);
                //console.log(form.values);
                form.reset();
            }
        }
    };

    return (
        <Box
            component="form"
            mx="auto"
            onSubmit={form.onSubmit((_, e) => handleSearch(e))}
        >
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
                        <TitleSections
                            title={titlePage}
                            fw={700}
                            color="black"
                        />
                        <Button
                            onClick={(e) => handleExportExcel(e)}
                            variant="light"
                            color="teal.7"
                            radius="md"
                            size="xs"
                            leftIcon={
                                <IconDatabaseExport size={16} color="teal" />
                            }
                        >
                            Excel
                        </Button>
                    </Group>
                </Card.Section>
                <Card.Section inheritPadding mt="sm" pb="lg">
                    <FormBusquedaActa form={form} />
                </Card.Section>

                <Card.Section inheritPadding mt="sm" pb="md">
                    <BtnSubmit title="Realizar Búsqueda" icon={IconDatabase} fullWidth={true} />
                </Card.Section>
            </Card>
        </Box>
    );
};
