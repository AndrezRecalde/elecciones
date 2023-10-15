import { useDisclosure } from "@mantine/hooks";
import {
    Header,
    HoverCard,
    Group,
    UnstyledButton,
    Text,
    SimpleGrid,
    ThemeIcon,
    Divider,
    Center,
    Box,
    Burger,
    Drawer,
    Collapse,
    ScrollArea,
    rem,
    Avatar,
    Button,
} from "@mantine/core";
import {
    IconChevronDown,
    IconBuildingBank,
    IconUsersGroup,
    IconListNumbers,
    IconListDetails,
    IconBuildingSkyscraper,
    IconBuilding,
} from "@tabler/icons-react";
import { Link, NavLink, useNavigate } from "react-router-dom";
import { UserMenu } from "../../components";
import { useAuthStore, useCreateStyles } from "../../hooks";

import logo from "../../assets/images/logo.png";

const mockdata = [
    {
        icon: IconBuildingBank,
        title: "Resultados Presidenciales",
        description:
            "Resultados de cada candidato/lista a tráves del conteo de voto para la sección Presidencial.",
        disabled: false,
        to: "/resultados/presidenciales",
        target: "_blank",
    },
    {
        icon: IconUsersGroup,
        title: "Resultados Asambleístas",
        description:
            "Resultados mediante el método Webster de los candidatos a Asamblea Nacional.",
        disabled: true,
        to: "/resultados/webster/asamblea",
        target: "_blank",
    },
    {
        icon: IconBuildingSkyscraper,
        title: "Prefectos",
        description:
            "Resultados mediante votos totales de los candidatos a Prefectura.",
        disabled: true,
        target: "_blank",
    },
    {
        icon: IconBuilding,
        title: "Alcaldía",
        description:
            "Resultados mediante votos totales de los candidatos a Alcaldía.",
        disabled: true,
        target: "_blank",
    },
    {
        icon: IconListNumbers,
        title: "Concejales",
        description:
            "Resultados mediante el método Webster de los candidatos a Concejales Urbanos y Rurales.",
        disabled: true,
        target: "_blank",
    },
    {
        icon: IconListDetails,
        title: "Juntas Parroquiales",
        description:
            "Resultados mediante el método Webster de los candidatos de las Juntas Parroquiales.",
        disabled: true,
        target: "_blank",
    },
];

export const HeaderMenu = () => {
    const { profile, startLogout } = useAuthStore();
    const { useStyles } = useCreateStyles();
    const [drawerOpened, { toggle: toggleDrawer, close: closeDrawer }] =
        useDisclosure(false);
    const [linksOpened, { toggle: toggleLinks }] = useDisclosure(false);
    const { classes, theme } = useStyles();
    const navigate = useNavigate();

    const handleActa = () => {
        navigate("/admin/actas");
    };

    const links = mockdata.map((item) => (
        <UnstyledButton
            className={item.disabled ? classes.subLinkDisa : classes.subLink}
            key={item.title}
        >
            <Group noWrap align="flex-start">
                <ThemeIcon size={34} variant="default" radius="md">
                    <item.icon size={rem(22)} color={theme.fn.primaryColor()} />
                </ThemeIcon>
                <Link
                    to={item.to}
                    className={item.disabled ? classes.linkR : classes.linkA}
                >
                    <Text size="sm" fw={500}>
                        {item.title}
                    </Text>
                    <Text size="xs" color="dimmed">
                        {item.description}
                    </Text>
                </Link>
            </Group>
        </UnstyledButton>
    ));

    return (
        <Box pb={20}>
            <Header height={60} px="md">
                <Group position="apart" sx={{ height: "100%" }}>
                    <Avatar src={logo} size={45} />

                    <Group
                        sx={{ height: "100%" }}
                        spacing={0}
                        className={classes.hiddenMobile}
                    >
                        <NavLink to="/" className={classes.link}>
                            Inicio
                        </NavLink>
                        {profile.role === "Superadministrador" ||
                        profile.role === "Digitador" ? (
                            <NavLink to="/digitacion" className={classes.link}>
                                Digitación
                            </NavLink>
                        ) : null}

                        {profile.role === "Superadministrador" ||
                        profile.role === "Visualizador" ? (
                            <HoverCard
                                width={600}
                                position="bottom"
                                radius="md"
                                shadow="md"
                                withinPortal
                            >
                                <HoverCard.Target>
                                    <a href="#" className={classes.link}>
                                        <Center inline>
                                            <Box component="span" mr={5}>
                                                Resultados
                                            </Box>
                                            <IconChevronDown
                                                size={12}
                                                color={theme.fn.primaryColor()}
                                            />
                                        </Center>
                                    </a>
                                </HoverCard.Target>

                                <HoverCard.Dropdown sx={{ overflow: "hidden" }}>
                                    <Text fw={500}>Resultados Seccionales</Text>
                                    <Divider
                                        my="sm"
                                        mx="-md"
                                        color={
                                            theme.colorScheme === "dark"
                                                ? "dark.5"
                                                : "gray.1"
                                        }
                                    />

                                    <SimpleGrid cols={2} spacing={0}>
                                        {links}
                                    </SimpleGrid>
                                    <div className={classes.dropdownFooter}>
                                        <Group position="apart">
                                            <div>
                                                <Text fw={500} fz="sm">
                                                    Exportar Actas
                                                </Text>
                                                <Text size="xs" color="dimmed">
                                                    Visualiza y exporta las
                                                    actas previamente ingresadas
                                                </Text>
                                            </div>
                                            <Button
                                                variant="default"
                                                onClick={handleActa}
                                            >
                                                Ver actas
                                            </Button>
                                        </Group>
                                    </div>
                                </HoverCard.Dropdown>
                            </HoverCard>
                        ) : null}
                        {profile.role === "Superadministrador" ||
                        profile.role === "Administrador" ? (
                            <>
                                <NavLink
                                    to="/escrutinio"
                                    className={classes.link}
                                >
                                    Escrutinio
                                </NavLink>
                                <NavLink
                                    to="/admin/tendencia"
                                    className={classes.link}
                                >
                                    Tendencia
                                </NavLink>
                            </>
                        ) : null}
                    </Group>
                    <Group className={classes.hiddenMobile}>
                        <UserMenu />
                    </Group>
                    <Burger
                        opened={drawerOpened}
                        onClick={toggleDrawer}
                        className={classes.hiddenDesktop}
                    />
                </Group>
            </Header>

            <Drawer
                opened={drawerOpened}
                onClose={closeDrawer}
                size="100%"
                padding="md"
                title="Navigation"
                className={classes.hiddenDesktop}
                zIndex={1000000}
            >
                <ScrollArea h={`calc(100vh - ${rem(60)})`} mx="-md">
                    <Divider
                        my="sm"
                        color={
                            theme.colorScheme === "dark" ? "dark.5" : "gray.1"
                        }
                    />

                    <NavLink to="/" className={classes.link}>
                        Inicio
                    </NavLink>
                    <NavLink to="/digitacion" className={classes.link}>
                        Digitación
                    </NavLink>
                    {profile.role === "Superadministrador" ||
                    profile.role === "Visualizador" ? (
                        <UnstyledButton
                            className={classes.link}
                            onClick={toggleLinks}
                        >
                            <Center inline>
                                <Box component="span" mr={5}>
                                    Resultados
                                </Box>
                                <IconChevronDown
                                    size={16}
                                    color={theme.fn.primaryColor()}
                                />
                            </Center>
                        </UnstyledButton>
                    ) : null}
                    {profile.role === "Superadministrador" ||
                    profile.role === "Administrador" ? (
                        <>
                            <NavLink to="/escrutinio" className={classes.link}>
                                Escrutinio
                            </NavLink>
                            <NavLink to="/admin/actas" className={classes.link}>
                                Actas
                            </NavLink>
                        </>
                    ) : null}
                    <Collapse in={linksOpened}>{links}</Collapse>

                    <Divider
                        my="sm"
                        color={
                            theme.colorScheme === "dark" ? "dark.5" : "gray.1"
                        }
                    />
                    <Group position="center" grow pb="xl" px="md">
                        <Button color="red.7" onClick={startLogout}>
                            Cerrar sesión
                        </Button>
                    </Group>
                    <Group position="center" grow pb="xl" px="md">
                        <UserMenu />
                    </Group>
                </ScrollArea>
            </Drawer>
        </Box>
    );
};
