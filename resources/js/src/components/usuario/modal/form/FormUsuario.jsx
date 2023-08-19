import { useEffect } from "react";
import {
    Box,
    Button,
    Divider,
    Grid,
    Group,
    Select,
    TextInput,
} from "@mantine/core";
import {
    useStateStore,
    useUiUsuario,
    useUsuarioStore,
} from "../../../../hooks";
import { useRoleStore } from "../../../../hooks/role/useRoleStore";
import { IconChecks } from "@tabler/icons-react";
import { BtnSubmit } from "../../../elements/btn/BtnSubmit";

export const FormUsuario = ({ form }) => {
    const { provincia_id, es_cantonal } = form.values;
    const { modalActionUsuario } = useUiUsuario();
    const { activateUsuario, startAddUsuario } = useUsuarioStore();
    const { roles, startLoadRoles } = useRoleStore();
    const { provincias, cantones, startLoadProvincias, startLoadCantones } =
        useStateStore();

    useEffect(() => {
        startLoadRoles();
        startLoadProvincias();
    }, []);

    useEffect(() => {
        startLoadCantones(provincia_id, "");
    }, [provincia_id]);

    useEffect(() => {
        if (activateUsuario !== null) {
            form.setValues({
                ...activateUsuario,
                role: activateUsuario?.role_id,
            });
            return;
        }
    }, [activateUsuario]);

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(form.values);
        startAddUsuario(form.values);
        form.reset();
        modalActionUsuario(0);
    };

    return (
        <Box
            component="form"
            mx="auto"
            sx={(theme) => ({
                padding: theme.spacing.xs,
            })}
            onSubmit={form.onSubmit((_, e) => handleSubmit(e))}
        >
            <Grid>
                <Grid.Col xs={12} sm={12} md={6} lg={6} xl={6}>
                    <TextInput
                        placeholder="Ingrese los nombres completos"
                        label="Nombres completos"
                        withAsterisk
                        {...form.getInputProps("nombres")}
                    />
                </Grid.Col>
                <Grid.Col xs={12} sm={12} md={6} lg={6} xl={6}>
                    <TextInput
                        placeholder="Ingrese el usuario"
                        label="Usuario"
                        withAsterisk
                        {...form.getInputProps("usuario")}
                    />
                </Grid.Col>
                <Grid.Col xs={12} sm={12} md={12} lg={12} xl={12}>
                    <Select
                        label="Role"
                        placeholder="Seleccione el role"
                        searchable
                        withAsterisk
                        nothingFound="No options"
                        {...form.getInputProps("role")}
                        data={roles.map((role) => {
                            return {
                                label: role.name,
                                value: role.id,
                            };
                        })}
                    />
                </Grid.Col>
                <Grid.Col xs={12} sm={12} md={12} lg={12} xl={12}>
                    <Select
                        label="¿Provincial?"
                        placeholder="¿Es Provincial?"
                        searchable
                        withAsterisk
                        nothingFound="No options"
                        {...form.getInputProps("es_provincial")}
                        data={[
                            { label: "Si", value: 1 },
                            { label: "No", value: 0 },
                        ]}
                    />
                </Grid.Col>
                <Grid.Col xs={12} sm={12} md={12} lg={12} xl={12}>
                    <Select
                        label="Provincia"
                        placeholder="Selecciona la Provincia"
                        searchable
                        withAsterisk
                        nothingFound="No options"
                        {...form.getInputProps("provincia_id")}
                        data={provincias.map((provincia) => {
                            return {
                                label: provincia.nombre_provincia,
                                value: provincia.id,
                            };
                        })}
                    />
                </Grid.Col>
                <Grid.Col xs={12} sm={12} md={12} lg={12} xl={12}>
                    <Select
                        label="¿Cantonal?"
                        placeholder="¿Es Cantonal?"
                        searchable
                        nothingFound="No options"
                        {...form.getInputProps("es_cantonal")}
                        data={[
                            { label: "Si", value: 1 },
                            { label: "No", value: 0 },
                        ]}
                    />
                </Grid.Col>
                {es_cantonal > 0 ? (
                    <Grid.Col xs={12} sm={12} md={12} lg={12} xl={12}>
                        <Select
                            label="Cantón"
                            placeholder="Selecciona el cantón"
                            searchable
                            nothingFound="No options"
                            {...form.getInputProps("canton_id")}
                            data={cantones.map((canton) => {
                                return {
                                    label: canton.nombre_canton,
                                    value: canton.id,
                                };
                            })}
                        />
                    </Grid.Col>
                ) : null}
                <Grid.Col xs={12} sm={6} md={6} lg={6} xl={6}>
                    <Select
                        label="¿Responsable?"
                        placeholder="¿Es Responsable?"
                        searchable
                        withAsterisk
                        nothingFound="No options"
                        {...form.getInputProps("responsable")}
                        data={[
                            { label: "Si", value: 1 },
                            { label: "No", value: 0 },
                        ]}
                    />
                </Grid.Col>
                <Grid.Col xs={12} sm={6} md={6} lg={6} xl={6}>
                    <Select
                        label="¿Activo?"
                        placeholder="¿El usuario esta activo?"
                        searchable
                        withAsterisk
                        nothingFound="No options"
                        {...form.getInputProps("activo")}
                        data={[
                            { label: "Si", value: 1 },
                            { label: "No", value: 0 },
                        ]}
                    />
                </Grid.Col>
            </Grid>
            <Divider my="md" />
            <BtnSubmit title="Agregar usuario" icon={IconChecks} />
        </Box>
    );
};
