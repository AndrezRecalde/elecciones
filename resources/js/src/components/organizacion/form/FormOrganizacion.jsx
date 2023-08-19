import {
    Box,
    Button,
    Center,
    ColorInput,
    FileInput,
    Grid,
    Group,
    Image,
    TextInput,
    rem,
} from "@mantine/core";
import { IconPhoto, IconPlus } from "@tabler/icons-react";
import { useEffect, useState } from "react";
import { useOrganizacionStore, useUiOrganizacion } from "../../../hooks";
import { BtnSubmit } from "../../elements/btn/BtnSubmit";

export const FormOrganizacion = ({ form }) => {
    const [img, setImg] = useState("")
    const [change, setChange] = useState(null);
    const { modalActionOrganizacion } = useUiOrganizacion();
    const {
        activateOrganizacion,
        startAddOrganizacion,
    } = useOrganizacionStore();
    const { imagen_url } = form.values;


    useEffect(() => {
        if (activateOrganizacion !== null) {
            form.setValues({
                ...activateOrganizacion,
            });
            setImg('/storage' + activateOrganizacion?.imagen_url);
            return;
        }
    }, [activateOrganizacion]);

    const handleSubmit = () => {
        startAddOrganizacion(form.values);
        modalActionOrganizacion(0);
        form.reset();
    };

    function Value({ file }) {
        return (
            <Center
                inline
                sx={(theme) => ({
                    backgroundColor:
                        theme.colorScheme === "dark"
                            ? theme.colors.dark[7]
                            : theme.colors.gray[1],
                    fontSize: theme.fontSizes.xs,
                    padding: `${rem(3)} ${rem(7)}`,
                    borderRadius: theme.radius.sm,
                })}
            >
                <IconPhoto size={rem(14)} style={{ marginRight: rem(5) }} />
                <span
                    style={{
                        whiteSpace: "nowrap",
                        textOverflow: "ellipsis",
                        overflow: "hidden",
                        maxWidth: rem(200),
                        display: "inline-block",
                    }}
                >
                    {file.name}
                </span>
            </Center>
        );
    }

    const ValueComponent = ({ value }) => {
        if (Array.isArray(value)) {
            return (
                <Group spacing="sm" py="xs">
                    {value.map((file, index) => (
                        <Value file={file} key={index} />
                    ))}
                </Group>
            );
        }

        return <Value file={value} />;
    };

    const setImagePrev = (e) => {
        form.setFieldValue("imagen_url", e);
        setChange((change) => change + 1);
    };

    useEffect(() => {
        if (!imagen_url) {
            setImg(`/storage${activateOrganizacion?.imagen_url}`);
            return;
        }
        const objectUrl = URL.createObjectURL(imagen_url);
        setImg(objectUrl);

        // free memory when ever this component is unmounted
        return () => {
            URL.revokeObjectURL(objectUrl);
            setChange(null);
        };
    }, [change]);


    return (
        <Box
            component="form"
            mx="auto"
            sx={(theme) => ({
                padding: theme.spacing.md,
            })}
            onSubmit={form.onSubmit((_, e) => handleSubmit(e))}
        >
            <Grid>
                <Grid.Col sm={12} md={12} lg={12} xl={12}>
                    <TextInput
                        placeholder="Nombre de la organización"
                        label="Organizacion"
                        withAsterisk
                        {...form.getInputProps("nombre_organizacion")}
                    />
                </Grid.Col>
                <Grid.Col sm={12} md={12} lg={12} xl={12}>
                    <TextInput
                        placeholder="Número de lista"
                        label="Número de lista"
                        withAsterisk
                        {...form.getInputProps("lista")}
                    />
                </Grid.Col>
                <Grid.Col sm={12} md={12} lg={12} xl={12}>
                    <TextInput
                        placeholder="Sigla"
                        label="Sigla"
                        withAsterisk
                        {...form.getInputProps("sigla")}
                    />
                </Grid.Col>
                <Grid.Col sm={12} md={12} lg={12} xl={12}>
                    <ColorInput
                        placeholder="Selecciona color de la lista"
                        label="Seleccione color"
                        withAsterisk
                        {...form.getInputProps("color")}
                    />
                </Grid.Col>
                <Grid.Col sm={12} md={12} lg={12} xl={12}>
                    <FileInput
                        label="Logo"
                        placeholder="Logo de la organización"
                        radius="md"
                        accept="image/png,image/jpeg,image/jpeg"
                        valueComponent={ValueComponent}
                        onChange={(e) => setImagePrev(e)}
                        error={
                            imagen_url === null || imagen_url === ""
                                ? "Por favor carga el logo de la organización"
                                : null
                        }
                        withAsterisk
                    />
                    <Group position="center">
                        <Image
                            mt={10}
                            width={100}
                            height={90}
                            src={img}
                            withPlaceholder
                        />
                    </Group>
                </Grid.Col>
            </Grid>
           <BtnSubmit title="Agregar organización" icon={IconPlus} />
        </Box>
    );
};
