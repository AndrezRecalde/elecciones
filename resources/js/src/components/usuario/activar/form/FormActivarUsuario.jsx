import { useEffect } from "react";
import {
    Box,
    Button,
    Divider,
    Flex,
    Grid,
    Group,
    Select,
    Text,
} from "@mantine/core";
import { isNotEmpty, useForm } from "@mantine/form";
import { IconChecks, IconUserCheck } from "@tabler/icons-react";
import { BtnSubmit } from "../../../../components";
import { useUiUsuario, useUsuarioStore } from "../../../../hooks";

export const FormActivarUsuario = () => {
    const { modalActivateUsuario } = useUiUsuario();
    const { activateUsuario, startUpdateActivo } = useUsuarioStore();

    const form = useForm({
        initialValues: {
            activo: null,
        },
        validate: {
            activo: isNotEmpty("Por favor ingrese un estado para el usuario"),
        },
    });

    useEffect(() => {
        if (activateUsuario !== null) {
            form.setValues({ ...activateUsuario });
            return;
        }
    }, [activateUsuario]);

    const handleSubmit = (e) => {
        e.preventDefault();
        startUpdateActivo(form.values);
        form.reset();
        modalActivateUsuario(0);
    };

    return (
        <Box
            component="form"
            mx="auto"
            onSubmit={form.onSubmit((_, e) => handleSubmit(e))}
            mb={15}
            sx={(theme) => ({
                padding: theme.spacing.sm,
            })}
        >
            <Grid>
                <Grid.Col sm={12} md={12} lg={12} xl={12}>
                    <Flex
                        mih={50}
                        gap="md"
                        justify="center"
                        align="center"
                        direction="column"
                        wrap="wrap"
                    >
                        <IconUserCheck size={30} />
                        <Text>{activateUsuario?.nombres}</Text>
                    </Flex>
                </Grid.Col>
                <Grid.Col sm={12} md={12} lg={12} xl={12}>
                    <Select
                        data={[
                            { label: "Sí", value: 1 },
                            { label: "No", value: 0 },
                        ]}
                        placeholder="¿Desea activar el usuario?"
                        label="Activar"
                        description="El usuario podrá acceder a la plataforma cuando este activado."
                        radius="md"
                        mb={20}
                        withAsterisk
                        {...form.getInputProps("activo")}
                    />
                </Grid.Col>
                <Divider />
            </Grid>
            <BtnSubmit title="Activar usuario" icon={IconChecks} />
        </Box>
    );
};
