import { useDispatch, useSelector } from "react-redux";
import { onClearDignidades, onLoadDignidades } from "../../store/eleccion/dignidad/dignidadSlice";
import eleccionApi from "../../api/eleccionApi";
import Swal from "sweetalert2";

export const useDignidadStore = () => {
    const { dignidades } = useSelector((state) => state.dignidad);

    const dispatch = useDispatch();

    const startLoadDignidades = async () => {
        try {
            const { data } = await eleccionApi.get("/dignidades");
            const { dignidades } = data;
            dispatch(onLoadDignidades(dignidades));
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

    const startLoadAdminDignidades = async() => {
        try {
            const { data } = await eleccionApi.get("/admin/dignidades");
            const { dignidades } = data;
            dispatch(onLoadDignidades(dignidades));
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
    }

    const startClearDignidades = () => {
        dispatch(onClearDignidades());
    }

    return {
        dignidades,

        startLoadDignidades,
        startClearDignidades,
        startLoadAdminDignidades
    };
};
