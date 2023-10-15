import { useEffect, useState } from "react";
import { Card } from "@mantine/core";
import {
    ModalActivateUser,
    ModalUsuario,
    ModalResetPwd,
    TableUsuarios,
    TitleSections,
} from "../../components";
import { useUsuarioStore, useRoleStore } from "../../hooks";
import { useNavigate } from "react-router-dom";

export const UsuariosPage = () => {
    const navigate = useNavigate();
    const [title, setTitle] = useState("Elecciones | Usuarios");
    const {
        usuarios,
        startLoadUsuarios,
        startClearUsuarios,
        setClearActivateUsuario,
        errores,
    } = useUsuarioStore();
    const { startClearRoles } = useRoleStore();

    useEffect(() => {
        document.title = title;
        startLoadUsuarios();

        return () => {
            startClearUsuarios();
            setClearActivateUsuario();
            startClearRoles();
            setTitle("");
        };
    }, []);

    useEffect(() => {
        if (errores !== undefined) {
            navigate("/error/403");
            return;
        }
    }, [errores]);

    return (
        <>
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
                {/* Los Modales */}
                <ModalUsuario />
                <ModalActivateUser />
                <ModalResetPwd />
            </>
        </>
    );
};
