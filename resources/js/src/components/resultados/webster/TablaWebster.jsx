import { useEffect, useState } from "react";
import { Table } from "@mantine/core";
import { useResultadoStore } from "../../../hooks";
import { TitleSections, FechaActual, CandidatosEntran } from "../../../components";

const ths = (
    <tr>
        <th>Lista</th>
        <th>Organización</th>
        <th>Siglas</th>
        <th>Total Votos</th>
        <th>1</th>
        <th>3</th>
        <th>5</th>
        <th>7</th>
        <th>Porcentaje</th>
    </tr>
);

export const TablaWebster = () => {
    const [valores, setValores] = useState([]);
    const { resultadoCandidatos, totalDeVotos } = useResultadoStore();

    useEffect(() => {
        funTotales();

        return () => {
            setValores([]);
        };
    }, [resultadoCandidatos]);

    let funTotales = () => {
        resultadoCandidatos?.some((candidato) => {
            let div1 = candidato.total_votos;
            let div3 = parseFloat(candidato.total_votos / 3).toFixed(2);
            let div5 = parseFloat(candidato.total_votos / 5).toFixed(2);
            let div7 = parseFloat(candidato.total_votos / 7).toFixed(2);

            setValores((prev) => [
                ...prev,
                parseFloat(div1),
                parseFloat(div3),
                parseFloat(div5),
                parseFloat(div7),
            ]);
        });
    };

    const rows = resultadoCandidatos?.map((candidato) => {
        let total_1 = parseFloat(candidato.total_votos / 1);
        let total_3 = parseFloat(candidato.total_votos / 3).toFixed(2);
        let total_5 = parseFloat(candidato.total_votos / 5).toFixed(2);
        let total_7 = parseFloat(candidato.total_votos / 7).toFixed(2);

        return (
            <tr key={candidato.lista}>
                <td>{candidato.lista}</td>
                <td>{candidato.nombre_candidato}</td>
                <td>{candidato.sigla}</td>
                <td>{candidato.total_votos}</td>
                <td>
                    {valores
                        .sort((a, b) => {
                            return b - a;
                        })
                        .slice(0, 4)
                        .includes(parseFloat(total_1)) ? (
                        <div
                            style={{
                                fontWeight: "bold",
                                color: "black",
                                background: candidato.color,
                                padding: "5px",
                            }}
                        >
                            {total_1}
                        </div>
                    ) : (
                        <div>{total_1}</div>
                    )}
                </td>
                <td>
                    {valores
                        .sort((a, b) => {
                            return b - a;
                        })
                        .slice(0, 4)
                        .includes(parseFloat(total_3)) ? (
                        <div
                            style={{
                                fontWeight: "bold",
                                color: "black",
                                background: candidato.color,
                                padding: "5px",
                            }}
                        >
                            {total_3}
                        </div>
                    ) : (
                        <div>{total_3}</div>
                    )}
                </td>
                <td>
                    {valores
                        .sort((a, b) => {
                            return b - a;
                        })
                        .slice(0, 4)
                        .includes(parseFloat(total_5)) ? (
                        <div
                            style={{
                                fontWeight: "bold",
                                color: "black",
                                background: candidato.color,
                                padding: "5px",
                            }}
                        >
                            {total_5}
                        </div>
                    ) : (
                        <div>{total_5}</div>
                    )}
                </td>
                <td>
                    {valores
                        .sort((a, b) => {
                            return b - a;
                        })
                        .slice(0, 4)
                        .includes(parseFloat(total_7)) ? (
                        <div
                            style={{
                                fontWeight: "bold",
                                color: "black",
                                background: candidato.color,
                                padding: "5px",
                            }}
                        >
                            {total_7}
                        </div>
                    ) : (
                        <div>{total_7}</div>
                    )}
                </td>
                <td>
                    {(
                        (candidato.total_votos * 100) /
                        totalDeVotos.total_votos_validos
                    ).toFixed(2)}{" "}
                    %
                </td>
            </tr>
        );
    });

    return (
        <>
            <CandidatosEntran />
            <FechaActual />
            <Table
                mt="md"
                mb="md"
                fontSize="md"
                verticalSpacing="sm"
                withBorder
                withColumnBorders
                captionSide="top"
            >
                <caption>
                    <TitleSections
                        title="Resultados Webster - Asambleístas"
                        ta="center"
                        fw={700}
                        fz={16}
                        color="black"
                    />
                </caption>
                <thead>{ths}</thead>
                <tbody>{rows}</tbody>
            </Table>
        </>
    );
};
