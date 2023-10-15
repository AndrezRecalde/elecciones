import { CardBusquedaActa, TableActas } from "../../components";
import {
    useActasResStore,
    useAuthStore,
    useDignidadStore,
    useStateStore,
} from "../../hooks";
import { useEffect, useState } from "react";

export const ActaExportPage = () => {
    const [title, setTitle] = useState("Elecciones | Actas");
    const { profile } = useAuthStore();
    const { pageLoad, startClearActas } = useActasResStore();
    const { startLoadDignidades } = useDignidadStore();
    const { startLoadCantones } = useStateStore();

    useEffect(() => {
        document.title = title;
        startLoadDignidades();
        startLoadCantones(profile?.provincia_id);

        return () => {
            startClearActas();
            setTitle("");
        };
    }, []);

    return (
        <>
            <CardBusquedaActa titlePage="Búsqueda de Actas" />
            {pageLoad ? <TableActas /> : null}
        </>
    );
};
