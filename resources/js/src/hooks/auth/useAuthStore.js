import { useDispatch, useSelector } from "react-redux";
import { clearErrores, onAuthenticate, onLoading, onLogout, onProfile } from "../../store/auth/authSlice";
import eleccionApi from "../../api/eleccionApi";
import Swal from "sweetalert2";

export const useAuthStore = () => {
    const { isLoading, user, profile, isLogin, errores } = useSelector(
        (state) => state.auth
    );
    const dispatch = useDispatch();

    const startLogin = async ({ usuario, password }) => {
        try {
            const { data } = await eleccionApi.post("/auth/login", { usuario, password });
            const { user } = data;
            localStorage.setItem("eth_token", data.access_token);
            localStorage.setItem("token_init_date", new Date().getTime());
            dispatch(onAuthenticate(user));
        } catch (error) {
            dispatch(onLogout(error.response.data.msg));
            setTimeout(() => {
                dispatch(clearErrores());
            }, 2000);
        }
    };

    const startProfile = async () => {
        dispatch(onLoading());
        try {
            const { data } = await eleccionApi.get("/profile");
            const { profile } = data;
            dispatch(onProfile(profile));
        } catch (error) {
            //console.log(error)
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

    const checkAuthToken = async () => {
        const token = localStorage.getItem("eth_token");

        if(!token) return dispatch(onLogout());

        try {
            const { data } = await eleccionApi.get("/refresh");
            const { user } = data;
            localStorage.setItem("eth_token", data.access_token);
            localStorage.setItem("token_init_date", new Date().getTime());
            dispatch(onAuthenticate(user));
            //startProfile();
        } catch (error) {
            localStorage.clear();
            dispatch(onLogout());
        }
    }

    const startLogout = () => {
        localStorage.clear();
        dispatch(onLogout());
    }

    return {
        isLoading,
        user,
        profile,
        isLogin,
        errores,

        startLogin,
        startProfile,
        checkAuthToken,
        startLogout
    };
};
