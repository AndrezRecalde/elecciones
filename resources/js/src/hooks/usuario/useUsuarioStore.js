import { useDispatch, useSelector } from "react-redux";
import {
    onAddUsuario,
    onClearUsuarios,
    onLoading,
    onUpdateUsuario,
    onLoadUsuarios,
    onSetActivateUsuario,
} from "../../store/admin/usuario/usuarioSlice";
import Swal from "sweetalert2";
import eleccionApi from "../../api/eleccionApi";


export const useUsuarioStore = () => {
    const { isLoading, usuarios, activateUsuario, errores } =
        useSelector((state) => state.usuario);

    const dispatch = useDispatch();

    const startLoadUsuarios = async () => {
        dispatch(onLoading());
        try {
            const { data } = await eleccionApi.get("/admin/listar/usuarios");
            const { usuarios } = data;
            dispatch(onLoadUsuarios(usuarios));
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

    const startAddUsuario = async (usuario) => {
        try {
            if (usuario.id) {
                const { data } = await eleccionApi.put(
                    `/admin/update/usuario/${usuario.id}`,
                    usuario
                );
                dispatch(onUpdateUsuario({ ...usuario }));
                Swal.fire({
                    icon: "success",
                    title: data.msg,
                    showConfirmButton: false,
                    timer: 1000,
                });
                startLoadUsuarios();
                return;
            }
            const { data } = await eleccionApi.post(
                "/admin/create/usuario",
                usuario
            );
            dispatch(onAddUsuario({ ...usuario }));
            Swal.fire({
                icon: "success",
                title: data.msg,
                showConfirmButton: false,
                timer: 1000,
            });
            startLoadUsuarios();
        } catch (error) {
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: error.response ? error.response.data.msg : error,
                confirmButtonColor: "#c81d11",
            });
        }
    };

    const startUpdateActivo = async (usuario) => {
        try {
            const { data } = await eleccionApi.put(
                `/admin/update/usuario/activo/${usuario.id}`,
                usuario
            );
            dispatch(onUpdateUsuario({ ...usuario }));
            Swal.fire({
                icon: "success",
                title: data.msg,
                showConfirmButton: false,
                timer: 1000,
            });
            startLoadUsuarios();
        } catch (error) {
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: error.response ? error.response.data.msg : error,
                confirmButtonColor: "#c81d11",
            });
        }
    };

    const startDeleteUsuario = async (usuario) => {
        Swal.fire({
            icon: "warning",
            text: `Estas seguro de eliminar ${usuario.nombres}?`,
            showDenyButton: true,
            confirmButtonColor: "#3085d6",
            confirmButtonText: "Si",
            denyButtonText: "No",
        }).then(async (result) => {
            if (result.isConfirmed) {
                try {
                    await eleccionApi.delete(`/admin/delete/usuario/${usuario.id}`);
                    Swal.fire("¡Eliminado!", "", "success");
                    startLoadUsuarios();
                } catch (error) {
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: error.response ? error.response.data.msg : error,
                        confirmButtonColor: "#c81d11",
                    });
                }
            }
        });
    };

    const startUpdatePassword = async (usuario, password) => {
        Swal.fire({
            icon: "warning",
            text: `¿Estas seguro de cambiar la contraseña?`,
            showDenyButton: true,
            confirmButtonColor: "#3085d6",
            confirmButtonText: "Si",
            denyButtonText: "No",
        }).then(async (result) => {
            if (result.isConfirmed) {
                try {
                    const { data } = await eleccionApi.put(
                        `/admin/update/password/usuario/${usuario.id}`,
                        { password }
                    );
                    Swal.fire({
                        icon: "success",
                        title: data.msg,
                        showConfirmButton: false,
                        timer: 1000,
                    });
                } catch (error) {
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: error.response ? error.response.data.msg : error,
                        confirmButtonColor: "#c81d11",
                    });
                }
            }
        });
    };

    const setActivateUsuario = (usuario) => {
        dispatch(onSetActivateUsuario({ ...usuario }));
    };

    const startClearUsuarios = () => {
        dispatch(onClearUsuarios());
    };

    const setClearActivateUsuario = () => {
        dispatch(onSetActivateUsuario(null));
    };

    return {
        isLoading,
        usuarios,
        activateUsuario,
        errores,

        startLoadUsuarios,
        startAddUsuario,
        startUpdateActivo,
        setActivateUsuario,
        startDeleteUsuario,
        startUpdatePassword,
        startClearUsuarios,
        setClearActivateUsuario,
    };
};
