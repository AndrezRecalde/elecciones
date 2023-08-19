import { createStyles, Container, Group, rem, Avatar } from '@mantine/core';
import logo from "../../assets/images/logo.png";

const useStyles = createStyles((theme) => ({
  footer: {
    marginTop: rem(20),
    borderTop: `${rem(1)} solid ${
      theme.colorScheme === 'dark' ? theme.colors.dark[5] : theme.colors.gray[2]
    }`,
  },

  inner: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    paddingTop: theme.spacing.xl,
    paddingBottom: theme.spacing.xl,

    [theme.fn.smallerThan('xs')]: {
      flexDirection: 'column',
    },
  },

  links: {
    [theme.fn.smallerThan('xs')]: {
      marginTop: theme.spacing.md,
    },
  },
}));


export const FooterSection = () => {
  const { classes } = useStyles();

  return (
    <div className={classes.footer}>
      <Container className={classes.inner}>
        <Avatar src={logo} size={45} />
        <Group className={classes.links}>
            Todos los Derechos Reservados
        </Group>
      </Container>
    </div>
  );
}
