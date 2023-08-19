import { useForm } from "@mantine/form";
import { PasswordForm } from "../../../components";
import { Grid } from "@mantine/core";

export const ChangePwd = () => {
    const form = useForm({
        initialValues: {
            password: "",
            confirmPassword: "",
        },
        validate: {
            confirmPassword: (value, values) =>
                value !== values.password ? "Contraseñas no coinciden" : null,
        },
    });

    return (
        <Grid justify="center">
            <Grid.Col md={6} lg={6} xl={6}>
                <PasswordForm form={form} />
            </Grid.Col>
        </Grid>
    );
};
