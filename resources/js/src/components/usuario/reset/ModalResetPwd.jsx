import { Modal, useMantineTheme } from "@mantine/core";
import { isNotEmpty, useForm } from "@mantine/form";
import { FormReset, TitleSections } from "../../../components";
import { useUiUsuario } from "../../../hooks";

export const ModalResetPwd = () => {
    const theme = useMantineTheme();

    const { isOpenModalPassword, modalActionPassword } = useUiUsuario();

    const form = useForm({
        initialValues: {
            password: ""
        },
        validate: {
            password: isNotEmpty("Por favor genere la contraseña")
        }
    });

    const handleCloseModal = () => {
        modalActionPassword(0);
        //setClearPassword();
        form.reset();
    }

    return (
        <Modal
            opened={isOpenModalPassword}
            onClose={() => handleCloseModal()}
            title={<TitleSections title="Reestablecer contraseña" fw={700} />}
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
            <FormReset form={form} />
        </Modal>
    );
};
