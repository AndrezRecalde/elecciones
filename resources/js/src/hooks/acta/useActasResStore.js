import { useDispatch, useSelector } from "react-redux";
import {
    onClearActas,
    onLoadActas,
    onLoading,
} from "../../store/eleccion/acta/actasResSlice";
import Swal from "sweetalert2";
import eleccionApi from "../../api/eleccionApi";

export const useActasResStore = () => {
    const { actas, isLoading, pageLoad } = useSelector(
        (state) => state.actasRes
    );
    const dispatch = useDispatch();

    const startLoadActas = async ({
        dignidad_id,
        canton_id,
        parroquia_id,
        tipo_acta,
    }) => {
        dispatch(onLoading());
        try {
            const { data } = await eleccionApi.post("/admin/listar/actas", {
                dignidad_id,
                canton_id,
                parroquia_id,
                tipo_acta,
            });
            const { actas } = data;
            if (actas) {
                dispatch(onLoadActas(actas));
            } else {
                Swal.fire({
                    icon: "info",
                    title: "No existen datos para esa zona",
                    showConfirmButton: false,
                    timer: 1000,
                });
            }
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

    const startLoadAllActas = async ({
        dignidad_id,
        canton_id,
        parroquia_id,
    }) => {
        dispatch(onLoading());
        try {
            const { data } = await eleccionApi.post(
                "/admin/listar/actas/todas",
                {
                    dignidad_id,
                    canton_id,
                    parroquia_id,
                }
            );
            const { actas } = data;
            if (actas) {
                dispatch(onLoadActas(actas));
            } else {
                Swal.fire({
                    icon: "info",
                    title: "No existen datos para esa zona",
                    showConfirmButton: false,
                    timer: 1000,
                });
            }
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

    const startExportExcelActas = async (values = {}) => {
        try {
            const response = await eleccionApi.post(
                "/admin/exportacion/actas",
                values,
                { responseType: "blob" }
            );
            const url = window.URL.createObjectURL(
                new Blob([response.data], {
                    type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;",
                })
            );
            window.open(url, "_blank");
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

    const startExportExcelActasAll = async (values = {}) => {
        try {
            const response = await eleccionApi.post(
                "/admin/exportacion/actas/todas",
                values,
                { responseType: "blob" }
            );
            const url = window.URL.createObjectURL(
                new Blob([response.data], {
                    type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;",
                })
            );
            window.open(url, "_blank");
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

    const startClearActas = () => {
        dispatch(onClearActas());
    };

    return {
        isLoading,
        actas,
        pageLoad,

        startLoadActas,
        startLoadAllActas,
        startExportExcelActas,
        startExportExcelActasAll,
        startClearActas,
    };
};
