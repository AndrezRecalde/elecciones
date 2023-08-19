import { useDispatch, useSelector } from "react-redux";
import { onClearCantidadCandidatos, onLoadCantidadCandidatos } from "../../store/eleccion/cantidad/cantidadSlice";
import eleccionApi from "../../api/eleccionApi";
import Swal from "sweetalert2";

export const useCantidadStore = () => {
    const { cantidad } = useSelector((state) => state.cantidad);
    const dispatch = useDispatch();

    const startLoadCantidades = async (provincia_id) => {
        try {
                const { data } = await eleccionApi.post("/admin/total/asambleistas", {
                    provincia_id
                });
                const { total } = data;
                dispatch(onLoadCantidadCandidatos(total));
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

    const startClearCantidad = () => {
        dispatch(onClearCantidadCandidatos());
    }

    return {
        cantidad,

        startLoadCantidades,
        startClearCantidad
    };
};
