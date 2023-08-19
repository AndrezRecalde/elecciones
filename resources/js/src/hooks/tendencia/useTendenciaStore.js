import { useDispatch, useSelector } from "react-redux";
import Swal from "sweetalert2";
import eleccionApi from "../../api/eleccionApi";
import { onClearTendencias, onLoadTendencias, onLoading } from "../../store/eleccion/tendencia/tendenciaSlice";

export const useTendenciaStore = () => {
    const { pageLoad, isLoading, tendencias } = useSelector((state) => state.tendencia);
    const dispatch = useDispatch();

    const startLoadTendencias = async ({ dignidad_id, zona_id }) => {
        dispatch(onLoading());
        try {
            const { data } = await eleccionApi.post("/resultados/tendencias", {
                dignidad_id,
                zona_id,
            });
            const { tendencias } = data;
            dispatch(onLoadTendencias(tendencias));
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

    const startClearTendencias = () => {
        dispatch(onClearTendencias());
    }

    return {
        pageLoad,
        isLoading,
        tendencias,

        startLoadTendencias,
        startClearTendencias
    };
};
