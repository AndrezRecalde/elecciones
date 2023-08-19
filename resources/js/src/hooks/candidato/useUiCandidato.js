import { useDispatch, useSelector } from "react-redux";
import {
    onCloseModalActiveCandidato,
    onCloseModalCandidato,
    onOpenModalActiveCandidato,
    onOpenModalCandidato,
} from "../../store/admin/candidato/uiCandidatoSlice";

export const useUiCandidato = () => {
    const { isOpenModalAddCandidato, isOpenModalActiveCandidato } = useSelector(
        (state) => state.uiCandidato
    );

    const dispatch = useDispatch();

    const modalActionCandidato = (behavior) => {
        if (behavior === 1) {
            dispatch(onOpenModalCandidato());
        } else {
            dispatch(onCloseModalCandidato());
        }
    };

    const modalActivateCandidato = (behavior) => {
        if( behavior === 1) {
            dispatch(onOpenModalActiveCandidato());
        } else {
            dispatch(onCloseModalActiveCandidato());
        }
    }

    return {
        isOpenModalAddCandidato,
        isOpenModalActiveCandidato,

        modalActionCandidato,
        modalActivateCandidato
    };
};
