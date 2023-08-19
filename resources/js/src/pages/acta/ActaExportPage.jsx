import { CardBusquedaActa, TableActas } from "../../components";
import {
    useActasResStore,
    useAuthStore,
    useDignidadStore,
    useStateStore,
} from "../../hooks";
import { useEffect } from "react";

export const ActaExportPage = () => {
    const { profile } = useAuthStore();
    const { pageLoad, startClearActas } = useActasResStore();
    const { startLoadDignidades } = useDignidadStore();
    const { startLoadCantones } = useStateStore();

    useEffect(() => {
        startLoadDignidades();
        startLoadCantones(profile?.provincia_id);

        return () => {
            startClearActas();
        }
    }, []);

    return (
        <>
            <CardBusquedaActa titlePage="Búsqueda de Actas" />
            {pageLoad ? <TableActas /> : null}
        </>
    );
};
