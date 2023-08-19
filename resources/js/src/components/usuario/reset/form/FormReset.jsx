import { useEffect, useState } from "react";
import {
    ActionIcon,
    Alert,
    Box,
    CopyButton,
    Divider,
    Flex,
    Grid,
    PasswordInput,
    Text,
    Tooltip,
} from "@mantine/core";
import {
    IconAlertCircle,
    IconCheck,
    IconClipboard,
    IconLock,
    IconRotate2,
} from "@tabler/icons-react";
import { useUiUsuario, useUsuarioStore } from "../../../../hooks";
import { BtnSubmit } from "../../../../components";

export const FormReset = ({ form }) => {
    const { activateUsuario, startUpdatePassword } = useUsuarioStore();
    const { modalActionPassword } = useUiUsuario();

    const [btnDisabled, setBtnDisabled] = useState(true);
    const [generatePwd, setGeneratePwd] = useState(activateUsuario?.usuario);

    const { password } = form.values;

    useEffect(() => {
        if (activateUsuario !== null) {
            form.setValues({ ...activateUsuario });
            return;
        }
    }, [activateUsuario]);

    useEffect(() => {
        if (password === activateUsuario?.usuario) {
            setBtnDisabled(false);
        } else {
            setBtnDisabled(true);
        }
    }, [password]);

    const handleUpdatePwd = (e) => {
        e.preventDefault();
        startUpdatePassword(activateUsuario, password);
        modalActionPassword(0);
        form.reset();
    };

    return (
        <Box
            component="form"
            mx="auto"
            onSubmit={form.onSubmit((_, e) => handleUpdatePwd(e))}
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
                        <CopyButton
                            value={activateUsuario?.usuario}
                            timeout={2000}
                        >
                            {({ copied, copy }) => (
                                <Tooltip
                                    label={copied ? "Copiado" : "Copiar"}
                                    withArrow
                                    position="right"
                                >
                                    <ActionIcon
                                        color={copied ? "teal" : "gray"}
                                        onClick={() => {
                                            copy;
                                            form.setFieldValue(
                                                "password",
                                                generatePwd
                                            );
                                        }}
                                    >
                                        {copied ? (
                                            <IconCheck size={30} />
                                        ) : (
                                            <IconClipboard size={30} />
                                        )}
                                    </ActionIcon>
                                </Tooltip>
                            )}
                        </CopyButton>

                        <Text>{activateUsuario?.nombres}</Text>
                    </Flex>
                </Grid.Col>
                <Grid.Col sm={12} md={12} lg={12} xl={12}>
                    <Alert
                        icon={<IconAlertCircle size="1rem" />}
                        title="Informacion!"
                        color="yellow"
                    >
                        Genera la contraseña haciendo click en el icono superior
                        y se reestablecera la contraseña.
                    </Alert>
                </Grid.Col>
                <Grid.Col sm={12} md={12} lg={12} xl={12}>
                    <PasswordInput
                        disabled
                        data-autofocus
                        label="Contraseña"
                        placeholder="Reestablecer contraseña"
                        icon={<IconLock size="0.8rem" />}
                        {...form.getInputProps("password")}
                    />
                    <Divider />
                </Grid.Col>
            </Grid>
            <BtnSubmit title="Reestablecer contraseña" icon={IconRotate2} btnDisabled={btnDisabled} />
        </Box>
    );
};
