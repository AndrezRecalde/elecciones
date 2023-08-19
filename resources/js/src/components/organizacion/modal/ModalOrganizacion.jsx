import { Modal, useMantineTheme } from "@mantine/core";
import { useOrganizacionStore, useUiOrganizacion } from "../../../hooks";
import { isNotEmpty, useForm } from "@mantine/form";
import { FormOrganizacion, TitleSections } from "../../../components";

export const ModalOrganizacion = () => {
    const theme = useMantineTheme();
    const { isOpenModalAddOrg, modalActionOrganizacion } = useUiOrganizacion();
    const { setClearActivateOrganizacion } = useOrganizacionStore();

    const form = useForm({
        initialValues: {
            nombre_organizacion: "",
            lista: "",
            sigla: "",
            color: "",
            imagen_url: "",
        },
        validate: {
            nombre_organizacion: isNotEmpty(
                "Por favor ingrese el nombre de la organización"
            ),
            lista: isNotEmpty("Por favor ingresa el # de lista"),
            sigla: isNotEmpty(
                "Por favor ingrese las siglas de la organización"
            ),
            color: isNotEmpty("Por favor ingrese el color de la Organización"),
            imagen_url: isNotEmpty(
                "Por favor ingrese el logo de la organización"
            ),
        },
    });

    const handleCloseModalOrg = () => {
        form.reset();
        modalActionOrganizacion(0);
        setClearActivateOrganizacion()
    }

    return (
        <Modal
            opened={isOpenModalAddOrg}
            onClose={handleCloseModalOrg}
            title={<TitleSections title="Organización" fw={700} />}
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
            <FormOrganizacion form={form} />
        </Modal>
    );
};
