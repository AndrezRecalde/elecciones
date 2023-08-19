import { useDispatch, useSelector } from "react-redux";
import { onCloseModalActivateUser, onCloseModalPassword, onCloseModalUser, onOpenModalActivateUser, onOpenModalPassword, onOpenModalUser } from "../../store/admin/usuario/uiUsuarioSlice";

export const useUiUsuario = () => {
    const { isOpenModalUser, isOpenModalActivateUser, isOpenModalPassword } = useSelector(
        (state) => state.uiUsuario
    );

    const dispatch = useDispatch();

    const modalActionUsuario = (behavior) => {
        if(behavior === 1) {
            dispatch(onOpenModalUser());
        } else {
            dispatch(onCloseModalUser());
        }
    }

    const modalActivateUsuario = (behavior) => {
        if(behavior === 1) {
            dispatch(onOpenModalActivateUser());
        }else {
            dispatch(onCloseModalActivateUser());
        }
    }

    const modalActionPassword = (behavior) => {
        if(behavior === 1) {
            dispatch(onOpenModalPassword());
        }else {
            dispatch(onCloseModalPassword());
        }
    }

    return {
        isOpenModalUser,
        isOpenModalActivateUser,
        isOpenModalPassword,

        modalActionUsuario,
        modalActivateUsuario,
        modalActionPassword

    };
};
