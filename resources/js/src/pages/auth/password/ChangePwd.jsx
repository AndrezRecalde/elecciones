import { useForm } from "@mantine/form";
import { PasswordForm } from "../../../components";
import { Grid } from "@mantine/core";
import { useEffect, useState } from "react";

export const ChangePwd = () => {
    const [title, setTitle] = useState("Elecciones | Password");
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

    useEffect(() => {
        document.title = title;

        return () => {
            setTitle("");
        };
    }, []);

    return (
        <Grid justify="center">
            <Grid.Col md={6} lg={6} xl={6}>
                <PasswordForm form={form} />
            </Grid.Col>
        </Grid>
    );
};
