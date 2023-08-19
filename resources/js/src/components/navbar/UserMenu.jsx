import { Avatar, Group, Menu, UnstyledButton } from "@mantine/core";
import {
    IconApps,
    IconChevronDown,
    IconLogout,
    IconSettings,
    IconUserCircle,
    IconUserEdit,
    IconUsersPlus,
} from "@tabler/icons-react";
import { useEffect, useState } from "react";
import { useAuthStore, useCreateStyles } from "../../hooks";
import { useNavigate } from "react-router-dom";
import { TitleSections } from "../elements/TitleSections";

export const UserMenu = () => {
    const { profile, startLogout, startProfile } = useAuthStore();
    const { useStyles } = useCreateStyles();
    const { classes, cx } = useStyles();
    const [userMenuOpened, setUserMenuOpened] = useState(false);

    const navigate = useNavigate();

    useEffect(() => {
        startProfile();
    }, []);

    const handleChangePwd = () => {
        navigate("/profile/password");
    };

    const handleAddUsuarios = () => {
        navigate("/admin/usuarios");
    };

    const handleAddOrganizacion = () => {
        navigate("/admin/organizaciones");
    };

    const handleAddCandidato = () => {
        navigate("/admin/candidatos");
    };

    const handleLogout = () => {
        startLogout();
    };

    return (
        <Menu
            width={260}
            position="bottom-end"
            transitionProps={{ transition: "slide-left" }}
            onClose={() => setUserMenuOpened(false)}
            onOpen={() => setUserMenuOpened(true)}
            withinPortal
        >
            <Menu.Target>
                <UnstyledButton
                    className={cx(classes.user, {
                        [classes.userActive]: userMenuOpened,
                    })}
                >
                    <Group spacing={7}>
                        <Avatar radius="xl" size={22} color="indigo.7">
                            <IconUserCircle stroke={2} />
                        </Avatar>
                        <TitleSections
                            fw={500}
                            fz="sm"
                            title={profile.nombres}
                            color="black"
                            tt=""
                        />

                        <IconChevronDown size="0.9rem" stroke={1.5} />
                    </Group>
                </UnstyledButton>
            </Menu.Target>
            <Menu.Dropdown>
                {profile.role === "Superadministrador" ||
                profile.role === "Administrador" ? (
                    <>
                        <Menu.Label>Administración</Menu.Label>
                        <Menu.Item
                            onClick={handleAddUsuarios}
                            icon={<IconUsersPlus size="0.9rem" stroke={1.5} />}
                        >
                            Agregar usuarios
                        </Menu.Item>
                        <Menu.Item
                            onClick={handleAddOrganizacion}
                            icon={<IconApps size="0.9rem" stroke={1.5} />}
                        >
                            Agregar Organización
                        </Menu.Item>
                        <Menu.Item
                            onClick={handleAddCandidato}
                            icon={<IconUserEdit size="0.9rem" stroke={1.5} />}
                        >
                            Agregar Candidato
                        </Menu.Item>
                    </>
                ) : null}
                <Menu.Divider />
                <Menu.Label>Ajustes</Menu.Label>
                <Menu.Item
                    onClick={handleChangePwd}
                    icon={<IconSettings size="0.9rem" stroke={1.5} />}
                >
                    Cambiar contraseña
                </Menu.Item>
                <Menu.Divider />
                <Menu.Label>Zona de salida</Menu.Label>
                <Menu.Item
                    color="red"
                    onClick={handleLogout}
                    icon={<IconLogout size="0.9rem" stroke={2.3} />}
                >
                    Cerrar sesión
                </Menu.Item>
            </Menu.Dropdown>
        </Menu>
    );
};
