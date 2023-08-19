import { Modal, useMantineTheme } from "@mantine/core";
import { useCandidatoStore, useUiCandidato } from "../../../hooks";
import { FormCandidato, TitleSections } from "../../../components";
import { isNotEmpty, useForm } from "@mantine/form";

export const ModalCandidato = () => {
    const theme = useMantineTheme();
    const { isOpenModalAddCandidato, modalActionCandidato } = useUiCandidato();
    const { setClearActivateCandidato } = useCandidatoStore();

    const form = useForm({
        initialValues: {
            organizacion_id: "",
            dignidad_id: "",
            nombre_candidato: "",
            activo: 1,
            distrito_id: "",
            provincia_id: "",
            canton_id: "",
            parroquia_id: "",
        },
        validate: {
            organizacion_id: isNotEmpty("Por favor ingrese la organización"),
            dignidad_id: isNotEmpty("Por favor ingrese la dignidad"),
            nombre_candidato: isNotEmpty(
                "Por favor ingrese los nombres del candidato"
            ),
            distrito_id: isNotEmpty(
                "Por favor ingrese a que tipo de distrito pertenece"
            ),
            provincia_id: isNotEmpty("Por favor ingrese la Provincia"),
        },
    });

    const handleCloseModalCandidato = () => {
        form.reset();
        modalActionCandidato(0);
        setClearActivateCandidato();
    };

    return (
        <Modal
            opened={isOpenModalAddCandidato}
            onClose={handleCloseModalCandidato}
            title={<TitleSections title="Candidato" fw={700} />}
            overlayProps={{
                color:
                    theme.colorScheme === "dark"
                        ? theme.colors.dark[9]
                        : theme.colors.gray[2],
                opacity: 0.55,
                blur: 3,
            }}
            size="xl"
        >
            <FormCandidato form={form} />
        </Modal>
    );
};
