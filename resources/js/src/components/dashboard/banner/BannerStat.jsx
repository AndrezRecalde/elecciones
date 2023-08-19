import {
    Image,
    Text,
    Title,
    createStyles,
    rem,
} from "@mantine/core";
import image from "../../../assets/images/8046555.jpg";

const useStyles = createStyles((theme) => ({
    wrapper: {
        display: "flex",
        alignItems: "center",
        padding: `calc(${theme.spacing.xl} * 2)`,
        borderRadius: theme.radius.md,
        backgroundColor:
            theme.colorScheme === "dark" ? theme.colors.dark[8] : theme.white,
        border: `${rem(1)} solid ${
            theme.colorScheme === "dark"
                ? theme.colors.dark[8]
                : theme.colors.gray[3]
        }`,

        [theme.fn.smallerThan("sm")]: {
            flexDirection: "column-reverse",
            padding: theme.spacing.xl,
        },
    },

    image: {
        maxWidth: "40%",

        [theme.fn.smallerThan("sm")]: {
            maxWidth: "100%",
        },
    },

    body: {
        paddingRight: `calc(${theme.spacing.xl} * 4)`,

        [theme.fn.smallerThan("sm")]: {
            paddingRight: 0,
            marginTop: theme.spacing.xl,
        },
    },

    title: {
        color: theme.colorScheme === "dark" ? theme.white : theme.black,
        fontFamily: `Greycliff CF, ${theme.fontFamily}`,
        lineHeight: 1,
        marginBottom: theme.spacing.md,
    },

    controls: {
        display: "flex",
        marginTop: theme.spacing.xl,
    },

    inputWrapper: {
        width: "100%",
        flex: "1",
    },

    input: {
        borderTopRightRadius: 0,
        borderBottomRightRadius: 0,
        borderRight: 0,
    },

    control: {
        borderTopLeftRadius: 0,
        borderBottomLeftRadius: 0,
    },
}));

export const BannerStat = () => {
    const { classes } = useStyles();
    return (
        <div className={classes.wrapper}>
            <div className={classes.body}>
                <Title className={classes.title}>Esperemos...</Title>
                <Text fw={500} fz="lg" mb={10}>
                    Todavía no se registra ninguna acta.
                </Text>
                <Text fz="md" fs="italic" c="dimmed">
                    Cuando se ingrese las actas, se visualizará un panel general
                    de contabilización de actas y escrutinio a nivel provincial
                    de cada dignidad habilitada.
                </Text>
            </div>
            <Image src={image} className={classes.image} radius="md" />
        </div>
    );
};
