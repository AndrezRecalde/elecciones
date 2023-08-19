import { useCallback, useMemo } from "react";
import { useUiUsuario, useUsuarioStore } from "../../../hooks";
import { ActionIcon } from "@mantine/core";
import {
    IconBan,
    IconDiscountCheckFilled,
} from "@tabler/icons-react";
import { MantineReactTable } from "mantine-react-table";
import { ActivateButton, ActionsTableUsuario, BtnAdd } from "../../../components";

export const TableUsuarios = () => {
    const { modalActionUsuario, modalActivateUsuario, modalActionPassword } = useUiUsuario();

    const {
        isLoading,
        usuarios,
        setActivateUsuario,
        startDeleteUsuario,
        setClearActivateUsuario
    } = useUsuarioStore();

    const columns = useMemo(
        () => [
            {
                accessorKey: "activo",
                header: "Activo",
                enableColumnOrdering: false,
                enableEditing: false, //disable editing on this column
                enableSorting: false,
                enableColumnFilter: false,
                size: 40,
                Cell: ({ cell }) => (
                    <ActivateButton cell={cell} handleActivar={handleActivar} />
                ),
            },
            {
                accessorKey: "nombres",
                header: "Nombres",
                size: 80,
                wrap: true,
            },
            {
                accessorKey: "usuario",
                header: "DNI/Usuario",
                wrap: true,
            },
            {
                accessorFn: (row) =>
                    row.es_provincial === 1 ? (
                        <ActionIcon color="indigo.7" variant="transparent">
                            <IconDiscountCheckFilled size="1.3rem" />
                        </ActionIcon>
                    ) : (
                        <ActionIcon color="red.7" variant="transparent">
                            <IconBan />{" "}
                        </ActionIcon>
                    ),
                header: "¿Es Provincial?",
                wrap: true,
                size: 80,
            },
            {
                accessorKey: "nombre_provincia",
                header: "Provincia",
                wrap: true,
            },
            {
                accessorFn: (row) =>
                    row.es_cantonal === 1 ? (
                        <ActionIcon color="indigo.7" variant="transparent">
                            <IconDiscountCheckFilled size="1.3rem" />
                        </ActionIcon>
                    ) : (
                        <ActionIcon color="red.7" variant="transparent">
                            <IconBan size="1.3rem" />{" "}
                        </ActionIcon>
                    ),
                header: "¿Es Cantonal?",
                wrap: true,
                size: 80,
            },
            {
                accessorKey: "role",
                header: "Tipo de usuario",
                size: 80,
                wrap: true,
            },
        ],
        [usuarios]
    );

    const handleActivar = useCallback((selected) => {
        setActivateUsuario(selected);
        modalActivateUsuario(1);
    }, [usuarios]);

    const handleEdit = useCallback((selected) => {
        setActivateUsuario(selected);
        modalActionUsuario(1);
    }, [usuarios]);

    const handlePassword = useCallback((selected) => {
        setActivateUsuario(selected);
        modalActionPassword(1);
    }, [usuarios]);

    const handleDelete = useCallback((selected) => {
        startDeleteUsuario(selected);
    }, [usuarios]);

    const handleOpen = (e) => {
        e.preventDefault();
        setClearActivateUsuario();
        modalActionUsuario(1);
    };

    return (
        <>
            <MantineReactTable
                displayColumnDefOptions={{
                    "mrt-row-actions": {
                        mantineTableHeadCellProps: {
                            align: "center",
                        },
                        header: "Acciones",
                        size: 50,
                    },
                }}
                state={{ showProgressBars: isLoading }}
                columns={columns}
                data={usuarios}
                enableColumnOrdering
                enableRowActions
                positionActionsColumn="last"
                renderRowActionMenuItems={({ row }) => (
                    <ActionsTableUsuario
                        row={row}
                        handleEdit={handleEdit}
                        handlePassword={handlePassword}
                        handleDelete={handleDelete}
                    />
                )}
                renderTopToolbarCustomActions={() => (
                    <BtnAdd texto="Agregar usuario" handleAction={handleOpen} />
                )}
            />
        </>
    );
};
