import { useMemo } from "react";
import { MantineReactTable, useMantineReactTable } from "mantine-react-table";
import { TitleSections } from "../../../components";
import { useMantineTheme } from "@mantine/core";
import { useTendenciaStore } from "../../../hooks";

export const TableTendencia = () => {
    const { colorScheme } = useMantineTheme();
    const { tendencias } = useTendenciaStore();
    const columns = useMemo(
        () => [
            {
                accessorKey: "nombre_candidato",
                header: "Candidato",
            },
            {
                accessorKey: "sigla",
                header: "Sigla",
            },
            {
                accessorKey: "junta_nombre",
                header: "Junta",
            },
            {
                accessorKey: "total_votos",
                header: "Total Votos",
            },
        ],
        []
    );

    const table = useMantineReactTable({
        columns,
        data: tendencias,
        enablePagination: false,
        mantineTableProps: {
            highlightOnHover: false,
            withColumnBorders: true,
            withBorder: colorScheme === "light",
        },
        renderTopToolbarCustomActions: () => {
            return (
                <TitleSections
                    title="Avance de Tendencia de Juntas"
                    fw={700}
                    color="black"
                />
            );
        },
        initialState: { pagination: { pageSize: 9, pageIndex: 0 } },
    });

    return <MantineReactTable table={table} />;
};
