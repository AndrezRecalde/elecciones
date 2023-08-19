import { useDispatch, useSelector } from "react-redux";
import {
    onCloseModalOrg,
    onOpenModalOrg,
} from "../../store/admin/organizacion/uiOrganizacionSlice";

export const useUiOrganizacion = () => {
    const { isOpenModalAddOrg } = useSelector((state) => state.uiOrganizacion);

    const dispatch = useDispatch();

    const modalActionOrganizacion = (behavior) => {
        if (behavior === 1) {
            dispatch(onOpenModalOrg());
        } else {
            dispatch(onCloseModalOrg());
        }
    };

    return {
        isOpenModalAddOrg,

        modalActionOrganizacion
    };
};
