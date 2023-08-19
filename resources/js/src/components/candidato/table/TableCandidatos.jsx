import { useCallback, useMemo } from "react";
import { MantineReactTable } from "mantine-react-table";
import { ActionsTable, ActivateButton, BtnAdd } from "../../../components";
import { useCandidatoStore, useUiCandidato } from "../../../hooks";

export const TableCandidatos = () => {
    const { modalActionCandidato, modalActivateCandidato } = useUiCandidato();
    const {
        isLoading,
        candidatos,
        setActivateCandidato,
        startDeleteCandidato,
        setClearActivateCandidato,
    } = useCandidatoStore();

    const columns = useMemo(
        () => [
            {
                accessorKey: "activo",
                header: "Activo",
                wrap: true,
                Cell: ({ cell }) => (
                    <ActivateButton cell={cell} handleActivar={handleActivar} />
                ),
            },
            {
                accessorKey: "nombre_dignidad",
                header: "Dignidad",
                wrap: true,
            },
            {
                accessorKey: "nombre_organizacion",
                header: "Organización",
                wrap: true,
            },
            {
                accessorKey: "nombre_candidato",
                header: "Candidato",
                wrap: true,
            },
            {
                accessorFn: (row) => `${row.lista} ${row.sigla}`,
                id: "partido",
                header: "Partido",
                wrap: true,
            },
        ],
        []
    );

    const handleAddCandidato = useCallback(() => {
        setClearActivateCandidato();
        modalActionCandidato(1);
    }, [candidatos]);

    const handleActivar = useCallback(
        (selected) => {
            setActivateCandidato(selected);
            modalActivateCandidato(1);
        },
        [candidatos]
    );

    const handleEdit = useCallback(
        (selected) => {
            console.log(selected);
            setActivateCandidato(selected);
            modalActionCandidato(1);
        },
        [candidatos]
    );

    const handleDelete = useCallback(
        (selected) => {
            console.log(selected);
            setActivateCandidato(selected);
            startDeleteCandidato(selected);
        },
        [candidatos]
    );

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
            data={candidatos}
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
                    texto="Agregar candidato"
                    handleAction={handleAddCandidato}
                />
            )}
        />
    );
};
