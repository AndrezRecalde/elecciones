import { createStyles, rem } from "@mantine/core";

export const useCreateStyles = () => {
    const useStyles = createStyles((theme) => ({
        root: {
            position: "relative",
        },

        user: {
            color:
                theme.colorScheme === "dark"
                    ? theme.colors.dark[0]
                    : theme.black,
            padding: `${theme.spacing.xs} ${theme.spacing.sm}`,
            borderRadius: theme.radius.sm,
            transition: "background-color 100ms ease",

            "&:hover": {
                backgroundColor:
                    theme.colorScheme === "dark"
                        ? theme.colors.dark[8]
                        : theme.white,
            },

            [theme.fn.smallerThan("xs")]: {
                display: "none",
            },
        },

        input: {
            height: rem(55),
            paddingTop: rem(18),
        },

        label: {
            position: "absolute",
            pointerEvents: "none",
            fontSize: theme.fontSizes.sm,
            paddingLeft: theme.spacing.sm,
            paddingTop: `calc(${theme.spacing.xs} / 3)`,
            zIndex: 1,
        },
        item: {
            "& + &": {
                paddingTop: theme.spacing.sm,
                marginTop: theme.spacing.sm,
                borderTop: `${rem(1)} solid ${
                    theme.colorScheme === "dark"
                        ? theme.colors.dark[4]
                        : theme.colors.gray[2]
                }`,
            },
        },
        link: {
            display: "flex",
            alignItems: "center",
            height: "100%",
            paddingLeft: theme.spacing.md,
            paddingRight: theme.spacing.md,
            textDecoration: "none",
            color: theme.colorScheme === "dark" ? theme.white : theme.black,
            fontWeight: 500,
            fontSize: theme.fontSizes.sm,

            [theme.fn.smallerThan("sm")]: {
                height: rem(42),
                display: "flex",
                alignItems: "center",
                width: "100%",
            },

            ...theme.fn.hover({
                backgroundColor:
                    theme.colorScheme === "dark"
                        ? theme.colors.dark[6]
                        : theme.colors.gray[0],
            }),
        },
        linkR: {
            textDecoration: "none",
            color: "gray",
        },

        linkA: {
            textDecoration: "none",
            color: "black",
        },
        subLink: {
            width: "100%",
            padding: `${theme.spacing.xs} ${theme.spacing.md}`,
            borderRadius: theme.radius.md,

            ...theme.fn.hover({
                backgroundColor:
                    theme.colorScheme === "dark"
                        ? theme.colors.dark[7]
                        : theme.colors.gray[0],
            }),

            "&:active": theme.activeStyles,
        },
        subLinkDisa: {
            backgroundColor: "#e9ecef",
            pointerEvents: "none",
            width: "100%",
            padding: `${theme.spacing.xs} ${theme.spacing.md}`,
            borderRadius: theme.radius.md,

            ...theme.fn.hover({
                backgroundColor:
                    theme.colorScheme === "dark"
                        ? theme.colors.dark[7]
                        : theme.colors.gray[0],
            }),

            "&:active": theme.activeStyles,
        },

        dropdownFooter: {
            backgroundColor:
                theme.colorScheme === "dark"
                    ? theme.colors.dark[7]
                    : theme.colors.gray[0],
            margin: `calc(${theme.spacing.md} * -1)`,
            marginTop: theme.spacing.sm,
            padding: `${theme.spacing.md} calc(${theme.spacing.md} * 2)`,
            paddingBottom: theme.spacing.xl,
            borderTop: `${rem(1)} solid ${
                theme.colorScheme === "dark"
                    ? theme.colors.dark[5]
                    : theme.colors.gray[1]
            }`,
        },

        hiddenMobile: {
            [theme.fn.smallerThan("sm")]: {
                display: "none",
            },
        },

        hiddenDesktop: {
            [theme.fn.largerThan("sm")]: {
                display: "none",
            },
        },

        cardTotales: {
            backgroundImage: theme.fn.gradient({ from: 'indigo.3', to: 'indigo.2', deg: 60 }),
        },
        cardUserInfo: {
            backgroundImage: theme.fn.gradient({ from: 'blue.2', to: 'blue.5', deg: 60 }),
        }
    }));
    return {
        useStyles,
    };
};
