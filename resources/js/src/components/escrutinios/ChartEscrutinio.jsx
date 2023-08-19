import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend,
} from "chart.js";
import { Bar } from "react-chartjs-2";
import { useEscrutinioStore } from "../../hooks";

ChartJS.register(
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend
);


export const ChartEscrutinio = () => {
    const { resultadosEscrutinio } = useEscrutinioStore();

    const labels = resultadosEscrutinio?.slice(0, 9).map(escrutinio => escrutinio.nombre_canton);

    const options = {
        responsive: true,
        plugins: {
            legend: {
                position: "top",
            },
            title: {
                display: true,
                text: "Avance de Escrutinio Nivel Provincial",
            },
        },
    };

    const data = {
        labels,
        datasets: [
            {
                label: resultadosEscrutinio[0]?.nombre_dignidad,
                data: resultadosEscrutinio?.slice(0, 9).map(escrutinio => escrutinio.ingresadas),
                backgroundColor: "rgba(240, 39, 39, 0.8)",
                datalabels: {
                    color: "black",
                    align: "top",
                    labels: {
                        title: {
                            font: {
                                weight: "italic",
                                size: 15
                            }
                        }
                    }
                }
            },
            {
                label: resultadosEscrutinio[9]?.nombre_dignidad,
                data: resultadosEscrutinio?.slice(9, 19).map(escrutinio => escrutinio.ingresadas),
                backgroundColor: "rgba(30, 150, 250, 0.8)",
                datalabels: {
                    color: "black",
                    align: "top",
                    labels: {
                        title: {
                            font: {
                                weight: "italic",
                                size: 15
                            }
                        }
                    }
                }
            },
        ],

    };
    return <Bar options={options} data={data} />;
};
