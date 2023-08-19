import { useDispatch, useSelector } from "react-redux";
import {
    onClearStates,
    onLoadCantones,
    onLoadJuntas,
    onLoadParroquias,
    onLoadProvincia,
    onLoadRecintos,
    onLoadZonas,
} from "../../store/eleccion/states/stateSlice";
import eleccionApi from "../../api/eleccionApi";
import Swal from "sweetalert2";

export const useStateStore = () => {
    const { provincias, cantones, parroquias, recintos, zonas, juntas } = useSelector(
        (state) => state.state
    );

    const dispatch = useDispatch();

    const startLoadProvincia = async (id) => {
        try {
            const { data } = await eleccionApi.post("/digitacion/provincia", {
                id,
            });
            const { provincia } = data;
            dispatch(onLoadProvincia(provincia));
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

    const startLoadProvincias = async(id) => {
        try {
            const { data } = await eleccionApi.get("/admin/listar/provincias");
            const { provincias } = data;
            dispatch(onLoadProvincia(provincias));
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

    const startLoadCantones = async (provincia_id) => {
        try {
            const { data } = await eleccionApi.post("/digitacion/cantones", {
                provincia_id,
            });
            const { cantones } = data;
            dispatch(onLoadCantones(cantones));
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

    const startLoadParroquias = async (canton_id) => {
        try {
            const { data } = await eleccionApi.post("/digitacion/parroquias", {
                canton_id,
            });
            const { parroquias } = data;
            dispatch(onLoadParroquias(parroquias));
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

    const startLoadZonas = async (parroquia_id) => {
        try {
            const { data } = await eleccionApi.post("/digitacion/zonas", {
                parroquia_id,
            });
            const { zonas } = data;
            dispatch(onLoadZonas(zonas));
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

    const startLoadJuntas = async (zona_id) => {
        try {
            const { data } = await eleccionApi.post("/digitacion/juntas", {
                zona_id,
            });
            const { juntas } = data;
            dispatch(onLoadJuntas(juntas));
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

    const startLoadRecintos = async(parroquia_id) => {
        try {
            const { data } = await eleccionApi.post("/digitacion/recintos", { parroquia_id });
            const { recintos } = data;
            dispatch(onLoadRecintos(recintos));
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

    const startClearStates = () => {
        dispatch(onClearStates());
    }

    return {
        provincias,
        cantones,
        parroquias,
        recintos,
        zonas,
        juntas,

        startLoadProvincia,
        startLoadProvincias,
        startLoadCantones,
        startLoadParroquias,
        startLoadZonas,
        startLoadJuntas,
        startLoadRecintos,
        startClearStates
    };
};
