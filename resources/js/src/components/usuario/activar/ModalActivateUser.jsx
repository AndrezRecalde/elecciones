import { Modal, useMantineTheme } from "@mantine/core";
import { useUiUsuario, useUsuarioStore } from "../../../hooks";
import { FormActivarUsuario, TitleSections } from "../../../components";

export const ModalActivateUser = () => {
    const theme = useMantineTheme();
    const { isOpenModalActivateUser, modalActivateUsuario } = useUiUsuario();
    const { setClearActivateUsuario } = useUsuarioStore();

    const handleCloseModal = () => {
        modalActivateUsuario(0);
        setClearActivateUsuario();
    }

    return (
        <Modal
            opened={isOpenModalActivateUser}
            onClose={() => handleCloseModal()}
            title={<TitleSections title="Activar usuario" fw={700} />}
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
            <FormActivarUsuario />
        </Modal>
    );
};
