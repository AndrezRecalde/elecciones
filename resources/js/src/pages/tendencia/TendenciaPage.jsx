import { useEffect, useState } from "react";
import { CardBusqTendencia, TableTendencia } from "../../components";
import { useTendenciaStore } from "../../hooks";

export const TendenciaPage = () => {
    const [title, setTitle] = useState("Elecciones | Tendencia");
    const { pageLoad } = useTendenciaStore();

    useEffect(() => {
        document.title = title;

        return () => {
            setTitle("");
        };
    }, []);

    return (
        <>
            <CardBusqTendencia titlePage="Tendencia del voto por zona" />

            {pageLoad ? (
                <>
                    <TableTendencia />
                    {/*<ChartTendencia /> */}
                </>
            ) : null}
        </>
    );
};
