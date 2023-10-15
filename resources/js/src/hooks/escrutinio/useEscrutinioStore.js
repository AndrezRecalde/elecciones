import { useDispatch, useSelector } from "react-redux";
import {
    onClearEscrutinio,
    onDashboardEscrutinio,
    onErrores,
    onLoadEscrutinio,
} from "../../store/eleccion/escrutinio/escrutinioSlice";
import eleccionApi from "../../api/eleccionApi";
import Swal from "sweetalert2";

export const useEscrutinioStore = () => {
    const { resultadosEscrutinio, dashboardEscrutinio, errores } = useSelector(
        (state) => state.escrutinio
    );
    const dispatch = useDispatch();

    const startLoadEscrutinio = async () => {
        try {
            const { data } = await eleccionApi.get(
                "/admin/resultado/escrutinio"
            );
            const { escrutinio } = data;
            dispatch(onLoadEscrutinio(escrutinio));
        } catch (error) {
            //console.log(error);
            if (error.response.data.msg === "403") {
                dispatch(onErrores(error.response.data.msg));
                return;
            }
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: error.response.data.msg
                    ? error.response.data.msg
                    : error.response.data.msg
                    ? error.response.data.errores
                    : Object.values(error.response.data.errores),
                confirmButtonColor: "#c81d11",
            });
        }
    };

    const startDashboardEscrutinio = async () => {
        try {
            const { data } = await eleccionApi.get(
                "/dashboard/avance/escrutinio"
            );
            const { total } = data;
            dispatch(onDashboardEscrutinio(total));
        } catch (error) {
            //console.log(error);
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: error.response.data.msg
                    ? error.response.data.msg
                    : error.response.data.msg
                    ? error.response.data.errores
                    : Object.values(error.response.data.errores),
                confirmButtonColor: "#c81d11",
            });
        }
    };

    const startClearEscrutinio = () => {
        dispatch(onClearEscrutinio());
    };

    return {
        resultadosEscrutinio,
        dashboardEscrutinio,
        errores,

        startLoadEscrutinio,
        startDashboardEscrutinio,
        startClearEscrutinio,
    };
};
