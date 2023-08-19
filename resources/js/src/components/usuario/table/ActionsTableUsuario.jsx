import { Menu } from "@mantine/core";
import { IconEdit, IconLock, IconTrash } from "@tabler/icons-react";

export const ActionsTableUsuario = ({ row, handleEdit, handlePassword, handleDelete }) => {
    return (
        <>
            <Menu.Item onClick={() => handleEdit(row.original)} icon={<IconEdit />}>
                Editar
            </Menu.Item>
            <Menu.Item onClick={() => handlePassword(row.original)} icon={<IconLock />}>
                Reestablecer Contraseña
            </Menu.Item>
            <Menu.Item onClick={() => handleDelete(row.original)} icon={<IconTrash />}>
                Eliminar
            </Menu.Item>
        </>
    );
};
