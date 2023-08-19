import { Pie } from "react-chartjs-2";
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from "chart.js";
import { useResultadoStore } from "../../../../hooks";

ChartJS.register(ArcElement, Tooltip, Legend);

export const EscrutinioParcial = () => {
    const { totalActasIngresadas, totalJuntas } = useResultadoStore();

    const data = {
        labels: ["Ingresadas", "Restantes"],
        datasets: [
            {
                label: "Total",
                data: [totalActasIngresadas?.digitadas, totalJuntas?.total - totalActasIngresadas?.digitadas],
                backgroundColor: ["rgba(73, 81, 239, 0.8)", "rgba(255, 99, 132, 0.5)"],
                borderColor: ["rgba(8, 20, 230, 0.8)", "rgba(255, 99, 132, 1)"],
                borderWidth: 2,
            },
        ],
    };

    return (
        <Pie
            data={data}
            width={230}
            height={200}
            options={{ maintainAspectRatio: false }}
        />
    );
};
