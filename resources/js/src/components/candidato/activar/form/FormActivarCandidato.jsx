import { useEffect } from "react";
import { Box, Divider, Flex, Grid, Select } from "@mantine/core";
import { IconCheckbox, IconChecks } from "@tabler/icons-react";
import { BtnSubmit, TitleSections } from "../../../../components";
import { useCandidatoStore, useUiCandidato } from "../../../../hooks";

export const FormActivarCandidato = ({ form }) => {
    const { activateCandidato, startUpdateActivo } = useCandidatoStore();
    const { modalActivateCandidato } = useUiCandidato();

    useEffect(() => {
        if (activateCandidato !== null) {
            form.setValues({ ...activateCandidato });
            return;
        }
    }, [activateCandidato]);

    const handleSubmit = (e) => {
        e.preventDefault();
        startUpdateActivo(form.values);
        form.reset();
        modalActivateCandidato(0);
    };

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
                    <Flex
                        mih={50}
                        gap="md"
                        justify="center"
                        align="center"
                        direction="column"
                        wrap="wrap"
                    >
                        <IconCheckbox size={30} />
                        <TitleSections
                            title={activateCandidato?.nombre_candidato}
                            fw={500}
                            fz={12}
                            color="black"
                        />
                    </Flex>
                </Grid.Col>
                <Grid.Col sm={12} md={12} lg={12} xl={12}>
                    <Select
                        data={[
                            { label: "Si", value: 1 },
                            { label: "No", value: 0 },
                        ]}
                        placeholder="¿Esta activo?"
                        label="Activo"
                        description="El candidato se visualizará en las actas cuando este activo."
                        radius="md"
                        mb={20}
                        withAsterisk
                        {...form.getInputProps("activo")}
                    />
                    <Divider />
                </Grid.Col>
            </Grid>
            <BtnSubmit title="Activar candidato" icon={IconChecks} />
        </Box>
    );
};
