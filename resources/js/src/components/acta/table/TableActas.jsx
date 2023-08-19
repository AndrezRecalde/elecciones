import { useMemo } from "react";
import { MantineReactTable, useMantineReactTable } from "mantine-react-table";
import { Table, useMantineTheme } from "@mantine/core";
import { TitleSections } from "../../../components";
import { useActasResStore } from "../../../hooks";

export const TableActas = () => {
    const { colorScheme } = useMantineTheme();
    const { actas } = useActasResStore();

    const columns = useMemo(
        () => [
            {
                accessorKey: "nombre_canton", //access nested data with dot notation
                header: "Cantón",
            },
            {
                accessorKey: "nombre_parroquia",
                header: "Parroquia",
            },
            {
                accessorKey: "nombre_zona", //normal accessorKey
                header: "Zona",
            },
            {
                accessorKey: "nombre_recinto",
                header: "Recinto",
            },
            {
                accessorKey: "junta_nombre",
                header: "Junta",
            },
        ],
        []
    );

    const table = useMantineReactTable({
        columns,
        data: actas, //must be memoized or stable (useState, useMemo, defined outside of this component, etc.)
        mantineTableProps: {
            highlightOnHover: false,
            withColumnBorders: true,
            withBorder: colorScheme === "light",
        },
        renderTopToolbarCustomActions: () => {
            return (
                <TitleSections
                    title="Resultados de las Actas Ingresadas"
                    fz={16}
                    fw={700}
                    color="black"
                    ta="left"
                />
            );
        },
        renderDetailPanel: ({ row }) => (
            <Table horizontalSpacing="lg" withBorder withColumnBorders>
                <thead>
                    <tr>
                        <th>Total Huellas</th>
                        <th>Votos Blancos</th>
                        <th>Votos Nulos</th>
                        <th>¿Consistente?</th>
                        <th>Responsable</th>
                    </tr>
                </thead>
                <tbody>
                    <tr key={row.original.id}>
                        <td>{row.original.votos_validos}</td>
                        <td>{row.original.votos_blancos}</td>
                        <td>{row.original.votos_nulos}</td>
                        <td>{row.original.cuadrada === 0 ? 'Consistente' : 'Inconsistente'}</td>
                        <td>{row.original.nombres}</td>
                    </tr>
                </tbody>
            </Table>
        ),
    });

    return <MantineReactTable table={table} />;
};
