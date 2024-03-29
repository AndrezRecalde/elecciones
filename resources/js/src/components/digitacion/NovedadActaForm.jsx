import {
    ActionIcon,
    Button,
    Card,
    Checkbox,
    Flex,
    Grid,
    Group,
    Text,
} from "@mantine/core";
import { IconRotate2 } from "@tabler/icons-react";
import { useActaStore, useCreateStyles } from "../../hooks";
import { useEffect, useState } from "react";
import { TitleSections } from "../elements/TitleSections";

export const NovedadActaForm = ({ actaForm }) => {
    const [totales, setTotales] = useState(0);
    const { useStyles } = useCreateStyles();
    const { classes } = useStyles();
    const { startClearActa, startActivateSearch, activateActa } =
        useActaStore();

    const { num_votos, votos_blancos, votos_nulos, votos_validos } =
        actaForm.values;

    useEffect(() => {
        setTotales(
            num_votos
                .filter((num) => num !== undefined)
                .reduce((a, b) => parseInt(a) + parseInt(b), 0)
        );
    }, [num_votos]);

    useEffect(() => {
      if(totales + votos_blancos + votos_nulos !== votos_validos){
        actaForm.setFieldValue('cuadrada', false);
      } else {
        actaForm.setFieldValue('cuadrada', true);
      }
    }, [totales, votos_validos, votos_blancos, votos_nulos]);


    const handleResetSearch = () => {
        startClearActa();
        startActivateSearch(0);
    };

    return (
        <>
            <Card withBorder radius="md" p="xl">
                <Group
                    position="left"
                    className={classes.item}
                    noWrap
                    spacing="xl"
                >
                    <Checkbox
                        color="indigo.7"
                        styles={{ input: { cursor: "pointer" } }}
                        mr="xl"
                        size="md"
                        {...actaForm.getInputProps("legible", {
                            type: "checkbox",
                        })}
                    />
                    <div>
                        <TitleSections
                            title="Si el acta no es legible, quite el check."
                            fz="md"
                            tt=""
                            fw={500}
                        />
                    </div>
                </Group>
                <Group
                    position="left"
                    className={classes.item}
                    noWrap
                    spacing="xl"
                >
                    <Checkbox
                        color="indigo.7"
                        styles={{ input: { cursor: "pointer" } }}
                        mr="xl"
                        size="md"
                        {...actaForm.getInputProps("cuadrada", {
                            type: "checkbox",
                        })}
                    />
                    <div>
                        <TitleSections
                            title="Si los valores del acta no coinciden, quite el
                            check."
                            fz="md"
                            tt=""
                            fw={500}
                        />
                    </div>
                </Group>
                <Flex gap="xs" align="center" direction="row" mt={25}>
                    <ActionIcon
                        color="dark"
                        radius="xl"
                        size="xl"
                        onClick={handleResetSearch}
                    >
                        <IconRotate2 />
                    </ActionIcon>

                    <Button
                        fullWidth
                        size="md"
                        radius="md"
                        color="indigo.7"
                        type="submit"
                    >
                        Ingresar Acta
                    </Button>
                </Flex>
                { activateActa?.actualizador ? (
                    <Card
                        withBorder
                        mt={20}
                        radius="md"
                        p="sm"
                        className={classes.cardUserInfo}
                    >
                        <TitleSections
                            title="Acta modificada por: "
                            fw={700}
                            fz="xs"
                            color="black"
                        />
                        <TitleSections
                            title={`${activateActa?.actualizador}`}
                            fw={500}
                            fz="lg"
                            tt=""
                            color="black"
                        />
                    </Card>
                ) : activateActa?.creador ? (
                    <Card
                        withBorder
                        mt={20}
                        radius="md"
                        p="sm"
                        className={classes.cardUserInfo}
                    >
                        <TitleSections
                            title="Acta ingresada por: "
                            fw={700}
                            fz="xs"
                            color="black"
                        />
                        <TitleSections
                            title={`${activateActa?.creador}`}
                            fw={500}
                            fz="lg"
                            tt=""
                            color="black"
                        />
                    </Card>
                ) : null}
            </Card>
            <Grid mt={10} mb={10}>
                <Grid.Col span={6}>
                    <Card
                        withBorder
                        radius="md"
                        p="sm"
                        className={
                            totales + votos_blancos + votos_nulos ===
                            votos_validos
                                ? classes.cardTotales
                                : null
                        }
                    >
                        <TitleSections
                            title="Total huellas"
                            fw={700}
                            fz="xs"
                            color="black"
                        />
                        <Text fz="lg" fw={500}>
                            {votos_validos.toString()}
                        </Text>
                    </Card>
                </Grid.Col>

                <Grid.Col span={6}>
                    <Card
                        withBorder
                        radius="md"
                        p="sm"
                        className={
                            totales + votos_blancos + votos_nulos ===
                            votos_validos
                                ? classes.cardTotales
                                : null
                        }
                    >
                        <TitleSections
                            title="Total votos"
                            fw={700}
                            fz="xs"
                            color="black"
                        />
                        <Text fz="lg" fw={500} className={classes.titleTotales}>
                            {(
                                votos_blancos +
                                votos_nulos +
                                parseInt(totales * 1)
                            ).toString()}
                        </Text>
                    </Card>
                </Grid.Col>
            </Grid>
        </>
    );
};
