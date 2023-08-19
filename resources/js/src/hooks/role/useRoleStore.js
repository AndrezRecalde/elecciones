import { useDispatch, useSelector } from "react-redux";
import { onClearRoles, onLoadRoles } from "../../store/admin/roles/roleSlice";
import eleccionApi from "../../api/eleccionApi";


export const useRoleStore = () => {
    const { roles } = useSelector((state) => state.role);
    const dispatch = useDispatch();

    const startLoadRoles = async () => {
        try {
            const { data } = await eleccionApi.get("/admin/listar/roles");
            const { roles } = data;
            dispatch(onLoadRoles(roles));
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

    const startClearRoles = () => {
        dispatch(onClearRoles());
    }

    return {
        roles,

        startLoadRoles,
        startClearRoles
    };
};
