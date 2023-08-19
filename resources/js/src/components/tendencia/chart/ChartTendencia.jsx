import React from "react";
import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend,
} from "chart.js";
import { Line } from "react-chartjs-2";
import { useTendenciaStore } from "../../../hooks";

ChartJS.register(
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend
);

export function ChartTendencia() {
    const { tendencias } = useTendenciaStore();
    const options = {
        responsive: true,
        plugins: {
            legend: {
                position: "top",
            },
            title: {
                display: true,
                text: "Gráfico de tendencia del voto",
            },
        },
    };

    const labels = tendencias.map(tendencia => tendencia.junta_nombre);

    const data = {
        labels,
        datasets: [
            {
                label: "Dataset 1",
                data: labels.map(() =>
                    Math.floor(Math.random()*(20-50+1)+50)
                ),
                borderColor: "rgb(255, 99, 132)",
                backgroundColor: "rgba(255, 99, 132, 0.5)",
            },
            {
                label: "Dataset 2",
                data: labels.map(() =>
                    Math.floor(Math.random()*(20-50+1)+50)
                ),
                borderColor: "rgb(53, 162, 235)",
                backgroundColor: "rgba(53, 162, 235, 0.5)",
            },
        ],
    };
    return <Line options={options} data={data} />;
}
