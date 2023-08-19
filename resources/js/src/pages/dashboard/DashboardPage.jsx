import { useEffect } from "react";
import { Grid } from "@mantine/core";
import { data } from "../../helpers/data.json";
import { StatDashboard, TitleSections } from "../../components";
import { useEscrutinioStore, useStatStyles } from "../../hooks";

export const DashboardPage = () => {
    const { useStyles } = useStatStyles();
    const { classes } = useStyles();
    const {
        startDashboardEscrutinio,
        dashboardEscrutinio,
        startClearEscrutinio,
    } = useEscrutinioStore();

    useEffect(() => {
        startDashboardEscrutinio();

        return () => {
            startClearEscrutinio();
        };
    }, []);

    return (
        <>
            <TitleSections
                title="Sistema de Elecciones"
                fz={16}
                fw={700}
                ta="center"
            />
            <Grid grow mt={15}>
                {dashboardEscrutinio
                    ? dashboardEscrutinio?.map((escrutinio, i) => (
                          <Grid.Col
                              xs={12}
                              sm={12}
                              md={6}
                              lg={6}
                              xl={6}
                              key={i}
                          >
                              <StatDashboard
                                  classes={classes}
                                  data={data}
                                  escrutinio={escrutinio}
                              />
                          </Grid.Col>
                      ))
                    : null}
            </Grid>
        </>
    );
};
