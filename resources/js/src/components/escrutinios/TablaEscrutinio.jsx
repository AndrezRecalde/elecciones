import { useMemo } from "react";
import { MantineReactTable, useMantineReactTable } from "mantine-react-table";
import { useMantineTheme } from "@mantine/core";
import { useEscrutinioStore } from "../../hooks";
import { TitleSections } from "../../components"

export const TablaEscrutinio = () => {
    const { colorScheme } = useMantineTheme();
    const { resultadosEscrutinio } = useEscrutinioStore();

    const columns = useMemo(
        () => [
            {
                accessorKey: "nombre_canton",
                header: "Cantón",
            },
            {
                accessorFn: (row) =>
                    row.nombre_dignidad.toUpperCase()
                ,
                header: "Dignidad",
            },
            {
                accessorKey: "ingresadas",
                header: "Actas Ingresadas",
            },
            {
                accessorKey: "total",
                header: "Total Juntas",
            },
            {
                accessorFn: (row) => ((row.ingresadas * 100) / row.total).toFixed(2) + ' %',
                header: "Porcentaje",
            },
        ],
        []
    );

    const table = useMantineReactTable({
        columns,
        data: resultadosEscrutinio,
        mantineTableProps: {
            highlightOnHover: false,
            withColumnBorders: true,
            withBorder: colorScheme === "light",
        },
        renderTopToolbarCustomActions: () => {
            return <TitleSections title="Avance de Escrutinio" ta="left" />;
        },
        initialState: { pagination: { pageSize: 9, pageIndex: 0 } },
        rowsPerPageOptions: ["8", "18"],
    });
    return <MantineReactTable table={table} />;
};
