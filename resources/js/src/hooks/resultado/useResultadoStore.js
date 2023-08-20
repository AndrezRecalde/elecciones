import { useDispatch, useSelector } from "react-redux";
import {
    onClearErrores,
    onClearResultados,
    onErrores,
    onLoadResultadosCandidatos,
    onLoadTotalDeVotos,
    onLoadTotalIngresadas,
    onLoadTotalJuntas,
} from "../../store/eleccion/resultado/resultadosSlice";
import eleccionApi from "../../api/eleccionApi";
import Swal from "sweetalert2";

export const useResultadoStore = () => {
    const {
        pageLoad,
        totalDeVotos,
        totalActasIngresadas,
        totalJuntas,
        resultadoCandidatos,
        errores
    } = useSelector((state) => state.resultado);
    const dispatch = useDispatch();

    const startLoadTotalDeVotos = async ({
        dignidad_id,
        provincia_id,
        canton_id = 0,
        parroquia_id = 0,
    }) => {
        //console.log(dignidad_id)
        try {
            const { data } = await eleccionApi.post("/resultados/total/votos", {
                dignidad_id,
                provincia_id,
                canton_id,
                parroquia_id,
            });
            if(data.msg){
                dispatch(onErrores(data.msg));
                setTimeout(() => {
                    dispatch(onClearErrores());
                }, 20);
            } else {
                const { totalDeVotos } = data;
                dispatch(onLoadTotalDeVotos(totalDeVotos));
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

    const startLoadTotalActasIngresadas = async ({
        dignidad_id,
        provincia_id,
        canton_id = 0,
        parroquia_id = 0,
    }) => {
        try {
            const { data } = await eleccionApi.post("/admin/actas/ingresadas", {
                dignidad_id,
                provincia_id,
                canton_id,
                parroquia_id,
            });
            const { totalActasIngresadas } = data;
            dispatch(onLoadTotalIngresadas(totalActasIngresadas));
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

    const startLoadTotalJuntas = async ({
        provincia_id,
        canton_id = 0,
        parroquia_id = 0,
    }) => {
        try {
            const { data } = await eleccionApi.post("/admin/total/juntas", {
                provincia_id,
                canton_id,
                parroquia_id,
            });
            const { totalJuntas } = data;
            dispatch(onLoadTotalJuntas(totalJuntas));
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

    const startLoadResultadosCandidatos = async ({
        dignidad_id,
        provincia_id = 0,
        canton_id = 0,
        parroquia_id = 0,
        recinto_id = 0,
        cuadrada = 0,
        legible = 0,
    }) => {
        try {
            const { data } = await eleccionApi.post("/resultados/totales", {
                dignidad_id,
                provincia_id,
                canton_id,
                parroquia_id,
                recinto_id,
                cuadrada,
                legible,
            });
            const { candidatos } = data;
            dispatch(onLoadResultadosCandidatos(candidatos));
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

    const startClearResultados = () => {
        dispatch(onClearResultados());
    }

    return {
        pageLoad,
        totalDeVotos,
        totalActasIngresadas,
        totalJuntas,
        resultadoCandidatos,
        errores,

        startLoadTotalDeVotos,
        startLoadTotalActasIngresadas,
        startLoadTotalJuntas,
        startLoadResultadosCandidatos,
        startClearResultados
    };
};
