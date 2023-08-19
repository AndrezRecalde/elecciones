import { MantineReactTable } from "mantine-react-table";
import { ActionIcon, Image } from "@mantine/core";
import { IconInnerShadowRightFilled } from "@tabler/icons-react";
import { useCallback, useMemo } from "react";
import { useOrganizacionStore, useUiOrganizacion } from "../../../hooks";
import { ActionsTable, BtnAdd } from "../../../components";

export const TableOrganizaciones = () => {
    const { modalActionOrganizacion } = useUiOrganizacion();
    const {
        isLoading,
        organizaciones,
        setActivateOrganizacion,
        startDeleteOrganizacion,
        setClearActivateOrganizacion,
    } = useOrganizacionStore();

    const columns = useMemo(
        () => [
            {
                accessorKey: "nombre_organizacion",
                header: "Organización",
                wrap: true,
            },
            {
                accessorFn: (row) => `${row.lista} ${row.sigla}`,
                id: "partido",
                header: "Partido",
                wrap: true,
            },
            {
                accessorKey: "color",
                header: "Color",
                wrap: true,
                Cell: ({ cell }) => (
                    <ActionIcon radius="xl" c={cell.getValue()}>
                        <IconInnerShadowRightFilled size="1.5rem" />
                    </ActionIcon>
                ),
            },
            {
                accessorKey: "imagen_url",
                id: "imagen_url",
                header: "Logo",
                wrap: true,
                Cell: ({ cell }) => (
                    <Image
                        width={50}
                        height={50}
                        src={`/storage${cell.getValue()}`}
                        alt="With default placeholder"
                        withPlaceholder
                    />
                ),
            },
        ],
        [organizaciones]
    );

    const handleEdit = useCallback(
        (selected) => {
            setActivateOrganizacion(selected);
            modalActionOrganizacion(1);
        },
        [organizaciones]
    );

    const handleDelete = useCallback(
        (selected) => {
            startDeleteOrganizacion(selected);
            setActivateOrganizacion(selected);
        },
        [organizaciones]
    );

    const handleOpen = (e) => {
        e.preventDefault();
        setClearActivateOrganizacion();
        modalActionOrganizacion(1);
    };

    return (
        <MantineReactTable
            displayColumnDefOptions={{
                "mrt-row-actions": {
                    mantineTableHeadCellProps: {
                        align: "center",
                    },
                    header: "Acciones",
                    size: 100,
                },
            }}
            state={{ showProgressBars: isLoading }}
            columns={columns}
            data={organizaciones}
            enableColumnOrdering
            enableRowActions
            positionActionsColumn="last"
            renderRowActionMenuItems={({ row }) => (
                <ActionsTable
                    row={row}
                    handleEdit={handleEdit}
                    handleDelete={handleDelete}
                />
            )}
            renderTopToolbarCustomActions={() => (
                <BtnAdd
                    texto="Agregar organización"
                    handleAction={handleOpen}
                />
            )}
        />
    );
};
