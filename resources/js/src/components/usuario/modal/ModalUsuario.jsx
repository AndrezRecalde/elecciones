import { Modal, useMantineTheme } from "@mantine/core";
import { isNotEmpty, useForm } from "@mantine/form";
import { TitleSections, FormUsuario } from "../../../components";
import { useUiUsuario } from "../../../hooks";

export const ModalUsuario = () => {
    const theme = useMantineTheme();
    const { isOpenModalUser, modalActionUsuario } = useUiUsuario();

    const form = useForm({
        initialValues: {
           nombres: "",
           usuario: "",
           role: 3,
           es_provincial: 1,
           provincia_id: "",
           es_cantonal: 0,
           canton_id: "",
           responsable: 0,
           activo: 1,
        },
        validate: {
            nombres: isNotEmpty("Por favor ingrese los nombres"),
            usuario: isNotEmpty("Por favor ingrese el usuario"),
            role: isNotEmpty("Especifíque el Role del usuario"),
            es_provincial: isNotEmpty("¿Es provincial?"),
            provincia_id: isNotEmpty("Por favor ingrese la provincia"),
            es_cantonal: isNotEmpty("¿Es cantonal?"),
            responsable: isNotEmpty("¿Es responsable de algún cantón?"),
            activo: isNotEmpty("Especifique el estado del usuario"),
        }
    });

    const handleCloseModal = () => {
        form.reset();
        modalActionUsuario(0);
    }

    return (
        <Modal
            opened={isOpenModalUser}
            onClose={handleCloseModal}
            title={<TitleSections title="Usuario" fw={700} />}
            overlayProps={{
                color:
                    theme.colorScheme === "dark"
                        ? theme.colors.dark[9]
                        : theme.colors.gray[2],
                opacity: 0.55,
                blur: 3,
            }}
            size="lg"
            radius="md"
        >
            <FormUsuario form={form} />
        </Modal>
    );
};
