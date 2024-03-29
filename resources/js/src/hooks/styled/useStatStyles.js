import { createStyles, rem } from "@mantine/core";

export const useStatStyles = () => {
    const useStyles = createStyles((theme) => ({
        progressLabel: {
            fontFamily: `Greycliff CF, ${theme.fontFamily}`,
            lineHeight: 1,
            fontSize: theme.fontSizes.sm,
        },

        stat: {
            borderBottom: `${rem(3)} solid`,
            paddingBottom: rem(5),
        },

        statCount: {
            fontFamily: `Greycliff CF, ${theme.fontFamily}`,
            lineHeight: 1.3,
        },

        diff: {
            fontFamily: `Greycliff CF, ${theme.fontFamily}`,
            display: "flex",
            alignItems: "center",
        },

        icon: {
            color:
                theme.colorScheme === "dark"
                    ? theme.colors.dark[3]
                    : theme.colors.gray[4],
        },
    }));

    return { useStyles };
};
