import { useEffect } from "react";
import {
    Alert,
    Avatar,
    Box,
    Button,
    Card,
    Grid,
    Group,
    PasswordInput,
    TextInput,
} from "@mantine/core";
import { IconAlertCircle, IconKey } from "@tabler/icons-react";
import { isNotEmpty, useForm } from "@mantine/form";
import { BtnSubmit, TitleSections } from "../../components";
import { useAuthStore } from "../../hooks";
import logo from "../../assets/images/logo.png";

export const AuthenticationForm = () => {
    const { startLogin, errores } = useAuthStore();

    const form = useForm({
        initialValues: {
            usuario: "",
            password: "",
        },
        validate: {
            usuario: isNotEmpty("Por favor ingresa el usuario"),
            password: isNotEmpty("Por favor ingresa la contraseña"),
        },
    });

    const { usuario, password } = form.values;

    const handleSubmit = (e) => {
        e.preventDefault();
        startLogin({ usuario, password });
    };

    /* useEffect(() => {
        if (errores !== undefined) {
            Swal.fire("Error", errores, "error");
        }
    }, [errores]); */

    return (
        <Box
            component="form"
            mx="auto"
            onSubmit={form.onSubmit((_, e) => handleSubmit(e))}
        >
            <Grid justify="center">
                <Grid.Col sm={6} md={6} lg={6} xl={6}>
                    <Card
                        withBorder
                        shadow="md"
                        mt={100}
                        p="lg"
                        radius="sm"
                        sx={{ position: "static" }}
                    >
                        <Card.Section withBorder inheritPadding py="xs">
                            <Group position="apart">
                                <TitleSections
                                    title="Sistema de Elecciones"
                                    tt="uppercase"
                                    fw={700}
                                />
                                <Avatar size="sm" src={logo} alt="logo" />
                            </Group>
                        </Card.Section>
                        <Card.Section inheritPadding py="lg">
                            <TitleSections
                                title="Autenticación"
                                fz={14}
                                fw={700}
                            />
                            <TextInput
                                placeholder="Digite su usuario"
                                label="Usuario"
                                radius="sm"
                                withAsterisk
                                mt={15}
                                mb={15}
                                {...form.getInputProps("usuario")}
                            />
                            <PasswordInput
                                placeholder="Digite su contraseña"
                                label="Contraseña"
                                radius="sm"
                                withAsterisk
                                {...form.getInputProps("password")}
                            />
                        </Card.Section>
                        <Card.Section inheritPadding pb="md">
                            <BtnSubmit title="Autenticarse" icon={IconKey} />
                            {errores !== undefined ? (
                                <Alert
                                    icon={<IconAlertCircle size="1rem" />}
                                    title="¡Error!"
                                    color="red.7"
                                    radius="md"
                                    variant="filled"
                                    mt={10}
                                >
                                    {errores}
                                </Alert>
                            ) : null}
                        </Card.Section>
                    </Card>
                </Grid.Col>
            </Grid>
        </Box>
    );
};
