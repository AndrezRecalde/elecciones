import { useCallback } from "react";

export const useFechaActual = () => {

    const fechaActual = useCallback(() => {
        let hoy = new Date();
        return hoy.toLocaleString();
    }, []);

  return { fechaActual }
}
