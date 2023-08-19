import { useEffect, useState } from "react";
import { SeleccionForm } from "../../components";
import { useActaStore } from "../../hooks";
import { ActaPage } from "../../pages";

export const SeleccionPage = () => {
    const [title, setTitle] = useState("Elecciones | Digitación");
    const { pageLoad, startClearActa } = useActaStore();

    useEffect(() => {
        document.title = title;
        return () => {
            setTitle("");
            startClearActa();
        };
    }, []);

    return (
        <>
            <SeleccionForm />
            { pageLoad ? <ActaPage /> : null }
        </>
    );
};
