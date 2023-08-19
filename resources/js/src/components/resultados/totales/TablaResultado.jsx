import { Table } from "@mantine/core";
import { useResultadoStore } from "../../../hooks";

const ths = (
    <tr>
        <th>Lista</th>
        <th>Candidato</th>
        <th>Total Votos</th>
        <th>Porcentaje</th>
    </tr>
);

export const TablaResultado = () => {

    const { resultadoCandidatos, totalDeVotos } = useResultadoStore();

    const rows = resultadoCandidatos?.map((candidato) => (
        <tr key={candidato.lista}>
            <td>{candidato.lista}</td>
            <td>{candidato.nombre_candidato}</td>
            <td>{candidato.total_votos}</td>
            <td>{((candidato.total_votos * 100)/totalDeVotos.total_votos_validos).toFixed(2)} %</td>
        </tr>
    ));

    return (
        <Table
            mt="md"
            mb="md"
            fontSize="md"
            verticalSpacing="sm"
            highlightOnHover
            striped
            withBorder
            withColumnBorders
        >
            <thead>{ths}</thead>
            <tbody>{rows}</tbody>
        </Table>
    );
};
