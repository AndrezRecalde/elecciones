import { useDispatch, useSelector } from "react-redux";
import {
    onAddCandidato,
    onCandidatos,
    onClearCandidatos,
    onDeleteCandidato,
    onSetActivateCandidato,
    onUpdateCandidato,
} from "../../store/admin/candidato/candidatoSlice";
import eleccionApi from "../../api/eleccionApi";
import Swal from "sweetalert2";

export const useCandidatoStore = () => {
    const {
        isLoading,
        candidatos,
        activateCandidato,
        errores,
    } = useSelector((state) => state.candidato);

    const dispatch = useDispatch();

    const startLoadCandidatos = async () => {
        try {
            const { data } = await eleccionApi.get("/admin/candidatos");
            const { candidatos } = data;
            dispatch(onCandidatos(candidatos));
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

    const startAddCandidato = async (candidato) => {
        try {
            if (candidato.id) {
                console.log(candidato);
                const { data } = await eleccionApi.put(
                    `/admin/update/candidato/${candidato.id}`,
                    candidato
                );
                dispatch(onUpdateCandidato({ ...candidato }));
                startLoadCandidatos();
                Swal.fire({
                    icon: "success",
                    text: data.msg,
                    showConfirmButton: false,
                    timer: 1000,
                });
                return;
            }

            const { data } = await eleccionApi.post(
                "/admin/create/candidato",
                candidato
            );
            dispatch(onAddCandidato({ ...candidato }));
            startLoadCandidatos();
            Swal.fire({
                icon: "success",
                text: data.msg,
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

    const startDeleteCandidato = async (candidato) => {
        Swal.fire({
            icon: "warning",
            text: `Estas seguro de eliminar ${candidato.nombre_candidato}?`,
            showDenyButton: true,
            confirmButtonColor: "#3085d6",
            confirmButtonText: "Si",
            denyButtonText: "No",
        }).then(async (result) => {
            if (result.isConfirmed) {
                try {
                    await eleccionApi.delete(
                        `/admin/delete/candidato/${candidato.id}`
                    );
                    Swal.fire("¡Eliminado!", "", "success");
                    //startLoadOrganizaciones();
                    dispatch(onDeleteCandidato());
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
        });
    };

    const startUpdateActivo = async (candidato) => {
        try {
            const { data } = await eleccionApi.put(
                `/admin/update/candidato/activo/${candidato.id}`,
                candidato
            );
            dispatch(onUpdateCandidato({ ...candidato }));
            Swal.fire({
                icon: "success",
                text: data.msg,
                showConfirmButton: false,
                timer: 1000,
            });
            startLoadCandidatos();
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

    const setActivateCandidato = (candidato) => {
        dispatch(onSetActivateCandidato({ ...candidato }));
    };

    const setClearActivateCandidato = () => {
        dispatch(onSetActivateCandidato(null));
    };

    const startClearCandidatos = () => {
        dispatch(onClearCandidatos());
    };

    return {
        isLoading,
        candidatos,
        activateCandidato,
        errores,

        startLoadCandidatos,
        startAddCandidato,
        startDeleteCandidato,
        startUpdateActivo,
        setActivateCandidato,
        setClearActivateCandidato,
        startClearCandidatos,
    };
};
