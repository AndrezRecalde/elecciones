import { useDispatch, useSelector } from "react-redux";
import { onClearEscrutinio, onDashboardEscrutinio, onLoadEscrutinio } from "../../store/eleccion/escrutinio/escrutinioSlice";
import eleccionApi from "../../api/eleccionApi";
import Swal from "sweetalert2";

export const useEscrutinioStore = () => {
    const { resultadosEscrutinio, dashboardEscrutinio } = useSelector((state) => state.escrutinio);
    const dispatch = useDispatch();

    const startLoadEscrutinio = async () => {
        try {
            const { data } = await eleccionApi.get(
                "/admin/resultado/escrutinio"
            );
            const { escrutinio } = data;
            dispatch(onLoadEscrutinio(escrutinio));
        } catch (error) {
            console.log(error);
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: error.response ? error.response.data.msg : error,
                confirmButtonColor: "#c81d11",
            });
        }
    };

    const startDashboardEscrutinio = async() => {
        try {
            const { data } = await eleccionApi.get("/dashboard/avance/escrutinio");
            const { total } = data;
            dispatch(onDashboardEscrutinio(total));
        } catch (error) {
            console.log(error);
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: error.response ? error.response.data.msg : error,
                confirmButtonColor: "#c81d11",
            });
        }
    }

    const startClearEscrutinio = () => {
        dispatch(onClearEscrutinio());
    }

    return {
        resultadosEscrutinio,
        dashboardEscrutinio,

        startLoadEscrutinio,
        startDashboardEscrutinio,
        startClearEscrutinio
    };
};
