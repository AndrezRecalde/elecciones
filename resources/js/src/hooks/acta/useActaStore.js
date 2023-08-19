import { useDispatch, useSelector } from "react-redux";
import {
    onActivateActa,
    onActivateCandidatos,
    onActivateJunta,
    onActiveSearch,
    onClearActa,
    onPushNumeros,
    onStorageFields,
} from "../../store/eleccion/acta/actaSlice";
import eleccionApi from "../../api/eleccionApi";
import Swal from "sweetalert2";

export const useActaStore = () => {
    const {
        pageLoad,
        searchDisabled,
        isLoading,
        existeActa,
        selectedFields,
        activateJunta,
        activateActa,
        activateCandidatos,
        errores,
    } = useSelector((state) => state.acta);

    const dispatch = useDispatch();

    const startActivateSearch = (behavior) => {
        if (behavior === 1) {
            dispatch(onActiveSearch(true));
        } else {
            dispatch(onActiveSearch(false));
        }
    };

    const startStorageFields = (seleccion) => {
        dispatch(onStorageFields({ ...seleccion }));
    };

    const startLoadInfoJunta = async (junta_id) => {
        try {
            const { data } = await eleccionApi.post("/informacion/junta", {
                junta_id,
            });
            const { infoJunta } = data;
            dispatch(onActivateJunta(infoJunta));
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

    const startLoadActa = async (dignidad_id, junta_id) => {
        try {
            const { data } = await eleccionApi.post("/digitacion/buscar/acta", {
                dignidad_id,
                junta_id,
            });
            const { status, acta } = data;
            if (status) {
                dispatch(onActivateActa(acta));
                return;
            }
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

    const startLoadCandidatos = async ({
        dignidad_id,
        provincia_id,
        canton_id,
        parroquia_id,
        id = 0,
    }) => {
        try {
            const { data } = await eleccionApi.post(
                "/acta/listar/dignidades/acta",
                {
                    dignidad_id,
                    provincia_id,
                    canton_id,
                    parroquia_id,
                    acta_id: id,
                }
            );
            const { candidatos } = data;
            dispatch(onActivateCandidatos(candidatos));
        } catch (error) {
            console.log(error);
        }
    };

    const startAddActa = async (seleccion, acta) => {
        try {
            const finalForm = { ...seleccion, ...acta };
            const { data } = await eleccionApi.post(
                "/digitacion/store/acta",
                finalForm
            );
            Swal.fire({
                icon: "success",
                title: data.msg,
                showConfirmButton: false,
                timer: 1000,
            });
            dispatch(onClearActa());
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

    const startUpdateActa = async (id, seleccion, acta) => {
        try {
            const finalForm = { id, ...seleccion, ...acta };
            const { data } = await eleccionApi.post("/digitacion/update/acta", finalForm);
            Swal.fire({
                icon: "success",
                title: data.msg,
                showConfirmButton: false,
                timer: 1000,
            });
            dispatch(onClearActa());
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

    const startClearActa = () => {
        dispatch(onClearActa());
    };


    return {
        pageLoad,
        searchDisabled,
        isLoading,
        existeActa,
        selectedFields,
        activateJunta,
        activateActa,
        activateCandidatos,
        errores,

        startActivateSearch,
        startStorageFields,
        startLoadInfoJunta,
        startLoadActa,
        startLoadCandidatos,
        startClearActa,
        startAddActa,
        startUpdateActa,
    };
};
