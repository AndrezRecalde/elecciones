import { useEffect } from "react";
import { Card } from "@mantine/core";
import {
    ModalActivateUser,
    ModalUsuario,
    ModalResetPwd,
    TableUsuarios,
    TitleSections,
} from "../../components";
import { useUsuarioStore, useRoleStore } from "../../hooks";

export const UsuariosPage = () => {
    const {
        usuarios,
        startLoadUsuarios,
        startClearUsuarios,
        setClearActivateUsuario,
    } = useUsuarioStore();
    const { startClearRoles } = useRoleStore();

    useEffect(() => {
        startLoadUsuarios();

        return () => {
            startClearUsuarios();
            setClearActivateUsuario();
            startClearRoles();
        };
    }, []);
    return (
        <>
            <Card withBorder radius="md" mt="lg" mb="lg" shadow="sm">
                <Card.Section withBorder inheritPadding py="lg">
                    <TitleSections
                        title={`Lista de usuarios - ${usuarios.length} registrados`}
                        fw={700}
                        color="black"

                    />
                </Card.Section>
                <Card.Section>
                    <TableUsuarios />
                </Card.Section>
            </Card>
            {/* Los modales */}
            <ModalUsuario />
            <ModalActivateUser />
            <ModalResetPwd />
        </>
    );
};
