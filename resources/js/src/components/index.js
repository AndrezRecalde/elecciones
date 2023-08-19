/* Autenticacion */
import { AuthenticationForm } from './auth/AuthenticationForm';

/* Exportacion y Visualizacion de Actas */
import { CardBusquedaActa } from "./acta/card/CardBusquedaActa";
import { FormBusquedaActa } from "./acta/form/FormBusquedaActa";
import { TableActas } from "./acta/table/TableActas";

/* Dashboard */
import { StatAlcalde } from "./dashboard/alcaldes/StatAlcalde";
import { StatAsambleista } from "./dashboard/asambleistas/StatAsambleista";
import { StatConUrbanos } from "./dashboard/concejales/urbanos/StatConUrbanos";
import { StatConRurales } from "./dashboard/concejales/rurales/StatConRurales";
import { StatJuntasParroquiales } from "./dashboard/juntas/StatJuntasParroquiales";
import { StatPrefecto } from "./dashboard/prefectos/StatPrefecto";
import { StatPresidente } from "./dashboard/presidentes/StatPresidente";
import { StatDashboard } from './dashboard/stats/StatDashboard'
import { BannerStat } from "./dashboard/banner/BannerStat";

/* Digitacion */
import { CardActaDetalleForm } from "./digitacion/CardActaDetalleForm";
import { CardActaForm } from "./digitacion/CardActaForm";
import { CardActaInfo } from "./digitacion/CardActaInfo";
import { NovedadActaForm } from "./digitacion/NovedadActaForm";
import { SeleccionForm } from "./digitacion/SeleccionForm";

/* Elements */
import { TitleSections } from "./elements/TitleSections";
import { ActionsTable } from "./elements/actions/ActionsTable";
import { ActivateButton } from "./elements/activate/ActivateButton";
import { BtnSubmit } from "./elements/btn/BtnSubmit";
import { BtnAdd } from "./elements/btn/BtnAdd";
import { FechaActual } from "./elements/badge/FechaActual";
import { CandidatosEntran } from "./elements/badge/CandidatosEntran";

/* Usuario Menu */
import { UserMenu } from './navbar/UserMenu';

/* Usuarios */
import { FormUsuario } from "./usuario/modal/form/FormUsuario";
import { ModalUsuario } from "./usuario/modal/ModalUsuario";
import { ModalResetPwd } from "./usuario/reset/ModalResetPwd";
import { FormReset } from "./usuario/reset/form/FormReset";
import { ActionsTableUsuario } from "./usuario/table/ActionsTableUsuario";
import { TableUsuarios } from "./usuario/table/TableUsuarios";
import { FormActivarUsuario } from "./usuario/activar/form/FormActivarUsuario";
import { ModalActivateUser } from "./usuario/activar/ModalActivateUser";

import { PasswordForm } from "./auth/password/PasswordForm";

/* Resultados: Stats */
import { StatVotacion } from "./resultados/stats/StatVotacion";


/* Resultados: totales */
import { BusquedaForm } from "./resultados/totales/BusquedaForm";
import { CardBusquedaDignidad } from "./resultados/totales/CardBusquedaDignidad";
import { TablaResultado } from "./resultados/totales/TablaResultado";
import { StatEscrutinio } from "./resultados/stats/StatEscrutinio";
import { EscrutinioParcial } from "./resultados/stats/escrutinio/EscrutinioParcial";
import { ChartResultado } from "./resultados/chart/ChartResultado";


import { BusquedaWebster } from "./resultados/webster/BusquedaWebster";
import { TablaWebster } from "./resultados/webster/TablaWebster";
import { BusqWebsterForm } from "./resultados/webster/form/BusqWebsterForm";

/* Escrutinio */
import { ChartEscrutinio } from "./escrutinios/ChartEscrutinio";
import { TablaEscrutinio } from "./escrutinios/TablaEscrutinio";


/* Organizacion */
import { TableOrganizaciones } from "./organizacion/table/TableOrganizaciones";
import { FormOrganizacion } from "./organizacion/form/FormOrganizacion";
import { ModalOrganizacion } from "./organizacion/modal/ModalOrganizacion";

/* Candidatos */
import { FormCandidato } from "./candidato/form/FormCandidato";
import { ModalCandidato } from "./candidato/modal/ModalCandidato";
import { TableCandidatos } from "./candidato/table/TableCandidatos";
import { FormActivarCandidato } from "./candidato/activar/form/FormActivarCandidato";
import { ModalActivateCandidato } from "./candidato/activar/modal/ModalActivateCandidato";

/* Tendencia */
import { CardBusqTendencia } from "./tendencia/busqueda/CardBusqTendencia";
import { BusquedaFormTendencia } from "./tendencia/form/BusquedaFormTendencia";
import { ChartTendencia } from "./tendencia/chart/ChartTendencia";
import { TableTendencia } from "./tendencia/table/TableTendencia";

export {
    /* Auth */
    AuthenticationForm,

    /* Export Actas */
    CardBusquedaActa,
    FormBusquedaActa,
    TableActas,

    /*Dashboard */
    StatAlcalde,
    StatAsambleista,
    StatConUrbanos,
    StatConRurales,
    StatJuntasParroquiales,
    StatPrefecto,
    StatPresidente,
    StatDashboard,
    BannerStat,

    /* Digitacion */
    CardActaDetalleForm,
    CardActaForm,
    CardActaInfo,
    NovedadActaForm,
    SeleccionForm,

    /* Elements */
    TitleSections,
    ActionsTable,
    BtnSubmit,
    BtnAdd,
    FechaActual,
    CandidatosEntran,

    /* Navbar - User */
    UserMenu,

    /* Usuarios */
    FormUsuario,
    ModalUsuario,
    ModalResetPwd,
    FormReset,
    ActionsTableUsuario,
    TableUsuarios,
    FormActivarUsuario,
    ModalActivateUser,
    PasswordForm,

    /* Resultados: totales */
    BusquedaForm,
    CardBusquedaDignidad,
    TablaResultado,
    StatVotacion,
    StatEscrutinio,
    EscrutinioParcial,
    ChartResultado,

    /* Resultados: Webster */
    BusquedaWebster,
    TablaWebster,
    BusqWebsterForm,

    /* Escrutinio */
    ChartEscrutinio,
    TablaEscrutinio,

    /* Organizaciones */
    TableOrganizaciones,
    FormOrganizacion,
    ModalOrganizacion,

    /* Candidatos */
    FormCandidato,
    ModalCandidato,
    TableCandidatos,
    ActivateButton,
    FormActivarCandidato,
    ModalActivateCandidato,

    /* Tendencia */
    CardBusqTendencia,
    BusquedaFormTendencia,
    ChartTendencia,
    TableTendencia


}
