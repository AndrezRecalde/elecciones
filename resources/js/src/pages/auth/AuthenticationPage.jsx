import { Container, createStyles, rem } from "@mantine/core";
import { AuthenticationForm } from "../../components";

import imagen from "../../assets/images/73120452-01.jpg";

const useStyles = createStyles(() => ({
    wrapper: {
        minHeight: rem(980),
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
        backgroundImage: `url(${imagen})`,
    },
}));

export const AuthenticationPage = () => {
    const { classes } = useStyles();
    return (
        <div className={classes.wrapper}>
            <Container>
                <AuthenticationForm />
            </Container>
        </div>
    );
};
