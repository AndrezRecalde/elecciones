import { Modal, useMantineTheme } from "@mantine/core";
import { isNotEmpty, useForm } from "@mantine/form";
import { FormActivarCandidato, TitleSections } from "../../../../components";
import { useCandidatoStore, useUiCandidato } from "../../../../hooks";

export const ModalActivateCandidato = () => {
    const theme = useMantineTheme();
    const {
        isOpenModalActiveCandidato,
        modalActivateCandidato,
    } = useUiCandidato();
    const { setClearActivateCandidato } = useCandidatoStore();

    const form = useForm({
        initialValues: {
            activo: null,
        },
        validate: {
            activo: isNotEmpty("Por favor seleccione el estado del candidato"),
        },
    });

    const handleCloseModalCandidato = () => {
        form.reset();
        modalActivateCandidato(0);
        setClearActivateCandidato();
    };

    return (
        <Modal
            opened={isOpenModalActiveCandidato}
            onClose={handleCloseModalCandidato}
            title={<TitleSections title="Activar candidato" fw={700} />}
            centered
            overlayProps={{
                color:
                    theme.colorScheme === "dark"
                        ? theme.colors.dark[9]
                        : theme.colors.gray[2],
                opacity: 0.55,
                blur: 3,
            }}
        >
            <FormActivarCandidato form={form} />
        </Modal>
    );
};
