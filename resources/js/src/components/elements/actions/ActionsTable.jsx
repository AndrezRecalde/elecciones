import { Menu } from "@mantine/core";
import { IconEdit, IconTrash } from "@tabler/icons-react";

export const ActionsTable = ({ row, handleEdit, handleDelete }) => {
    return (
        <>
            <Menu.Item
                onClick={() => handleEdit(row.original)}
                icon={<IconEdit />}
            >
                Editar
            </Menu.Item>
            <Menu.Item
                onClick={() => handleDelete(row.original)}
                icon={<IconTrash />}
            >
                Eliminar
            </Menu.Item>
        </>
    );
};
