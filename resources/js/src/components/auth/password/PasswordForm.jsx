import {
    Box,
    Card,
    Grid,
    PasswordInput,
} from "@mantine/core";
import { useDisclosure } from "@mantine/hooks";
import { IconLock } from "@tabler/icons-react";
import { BtnSubmit, TitleSections } from "../../../components";
import { useAuthStore, useUsuarioStore } from "../../../hooks";


export const PasswordForm = ({ form }) => {
    const [visible, { toggle }] = useDisclosure(false);
    const { startUpdatePassword } = useUsuarioStore();
    const { user } = useAuthStore();
    const { password } = form.values;


    const handleSubmit = (e) => {
        e.preventDefault();
        startUpdatePassword(user, password);
        form.reset();
    };

    return (
        <Box
            component="form"
            mx="auto"
            sx={(theme) => ({
                padding: theme.spacing.sm,
            })}
            onSubmit={form.onSubmit((_, e) => handleSubmit(e))}
        >
            <Card
                withBorder
                radius="md"
                mt="lg"
                mb="lg"
                shadow="sm"
                sx={{ position: "static" }}
            >
                <Card.Section withBorder inheritPadding py="md">
                    <TitleSections title="Cambiar contraseña" fw={700} />
                </Card.Section>
                <Card.Section inheritPadding py="lg">
                    <Grid justify="center">
                        <Grid.Col sm={12} md={12} lg={12} xl={12}>
                            <PasswordInput
                                label="Nueva Contraseña"
                                visible={visible}
                                onVisibilityChange={toggle}
                                {...form.getInputProps("password")}
                            />
                        </Grid.Col>
                        <Grid.Col sm={12} md={12} lg={12} xl={12}>
                            <PasswordInput
                                label="Confirmar Contraseña"
                                visible={visible}
                                onVisibilityChange={toggle}
                                {...form.getInputProps("confirmPassword")}
                            />
                        </Grid.Col>
                    </Grid>
                </Card.Section>
                <BtnSubmit title="Cambiar contraseña" icon={IconLock} />
            </Card>
        </Box>
    );
};
