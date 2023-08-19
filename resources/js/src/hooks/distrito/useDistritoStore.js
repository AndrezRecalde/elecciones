import { useDispatch, useSelector } from "react-redux";
import { onClearDistritos, onDistritos } from "../../store/admin/distrito/distritoSlice";
import eleccionApi from "../../api/eleccionApi";
import Swal from "sweetalert2";

export const useDistritoStore = () => {
    const { distritos } = useSelector((state) => state.distrito);
    const dispatch = useDispatch();

    const startLoadDistritos = async () => {
        try {
            const { data } = await eleccionApi.get("/admin/listar/distritos");
            const { distritos } = data;
            dispatch(onDistritos(distritos));
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

    const startClearDistritos = () => {
        dispatch(onClearDistritos());
    }

    return {
        distritos,

        startLoadDistritos,
        startClearDistritos
    };
};
