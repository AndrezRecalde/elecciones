import { Container } from "@mantine/core";
import {
    CardBusqTendencia,
    ChartTendencia,
    TableTendencia,
} from "../../components";
import { useTendenciaStore } from "../../hooks";

export const TendenciaPage = () => {
    const { pageLoad } = useTendenciaStore();
    return (
        <>
            <CardBusqTendencia titlePage="Tendencia del voto por zona" />

            {pageLoad ? (
                <>
                    <TableTendencia />
                    <ChartTendencia />
                </>
            ) : null}
        </>
    );
};
