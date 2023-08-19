import { useDispatch, useSelector } from "react-redux";
import {
    onAddOrganizacion,
    onClearOrganizaciones,
    onDeleteOrganizacion,
    onLoading,
    onOrganizaciones,
    onSetActivateOrganizacion,
    onUpdateOrganizacion,
} from "../../store/admin/organizacion/organizacionSlice";
import eleccionApi from "../../api/eleccionApi";
import Swal from "sweetalert2";

export const useOrganizacionStore = () => {
    const { isLoading, organizaciones, activateOrganizacion, errores } =
        useSelector((state) => state.organizacion);

    const dispatch = useDispatch();

    const startLoadOrganizaciones = async () => {
        dispatch(onLoading());
        try {
            const { data } = await eleccionApi.get(
                "/admin/listar/organizaciones"
            );
            const { organizaciones } = data;
            dispatch(onOrganizaciones(organizaciones));
        } catch (error) {
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

    const startAddOrganizacion = async (organizacion) => {
        try {
            if (organizacion.id) {
                const { data } = await eleccionApi.post(
                    `/admin/update/organizacion/${organizacion.id}`,
                    organizacion,
                    {
                        headers: {
                            "Content-Type": "multipart/form-data",
                        },
                    }
                );
                dispatch(onUpdateOrganizacion({ ...organizacion }));
                startLoadOrganizaciones();
                Swal.fire({
                    icon: "success",
                    title: data.msg,
                    showConfirmButton: false,
                    timer: 1000,
                });
                return;
            }

            const { data } = await eleccionApi.post(
                "/admin/store/organizacion",
                organizacion,
                {
                    headers: {
                        "Content-Type": "multipart/form-data",
                    },
                }
            );
            dispatch(onAddOrganizacion({ ...organizacion }));
            startLoadOrganizaciones();
            Swal.fire({
                icon: "success",
                title: data.msg,
                showConfirmButton: false,
                timer: 1000,
            });
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

    const startDeleteOrganizacion = async (organizacion) => {
        Swal.fire({
            icon: "warning",
            text: `Estas seguro de eliminar ${organizacion.nombre_organizacion}?`,
            showDenyButton: true,
            confirmButtonColor: "#3085d6",
            confirmButtonText: "Si",
            denyButtonText: "No",
        }).then(async (result) => {
            if (result.isConfirmed) {
                try {
                    await eleccionApi.delete(
                        `/admin/delete/organizacion/${organizacion.id}`
                    );
                    Swal.fire("¡Eliminado!", "", "success");
                    //startLoadOrganizaciones();
                    dispatch(onDeleteOrganizacion());
                } catch (error) {
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
        });
    }

    const setActivateOrganizacion = (organizacion) => {
        dispatch(
            onSetActivateOrganizacion({
                ...organizacion,
            })
        );
    };

    const setClearActivateOrganizacion = () => {
        dispatch(onSetActivateOrganizacion(null));
    }

    const startClearOrganizaciones = () => {
        dispatch(onClearOrganizaciones());
    };

    return {
        isLoading,
        organizaciones,
        activateOrganizacion,
        errores,

        startLoadOrganizaciones,
        startAddOrganizacion,
        startDeleteOrganizacion,
        setActivateOrganizacion,
        startClearOrganizaciones,
        setClearActivateOrganizacion
    };
};
