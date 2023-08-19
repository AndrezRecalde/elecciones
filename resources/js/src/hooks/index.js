/* Authentication */
import { useAuthStore } from "./auth/useAuthStore";

/* Dignidad */
import { useDignidadStore } from "./dignidad/useDignidadStore";

/* Role */
import { useRoleStore } from "./role/useRoleStore";

/* Estados: Provincia, Cantones, Parroquias, Zonas, Juntas, Recintos */
import { useStateStore } from "./state/useStateStore";

/* Styleds */
import { useCreateStyles } from "./styled/useCreateStyles";
import { useStatStyles } from "./styled/useStatStyles";

/* Usuarios */
import { useUiUsuario } from "./usuario/useUiUsuario";
import { useUsuarioStore } from "./usuario/useUsuarioStore";

/* Acta */
import { useActaStore } from "./acta/useActaStore";

/* Helper: Fecha Actual de Reportes */
import { useFechaActual } from "./helper/useFechaActual";

/* Organizacion  */
import { useOrganizacionStore } from "./organizacion/useOrganizacionStore";
import { useUiOrganizacion } from './organizacion/useUiOrganizacion';

/* Distrito */
import { useDistritoStore } from './distrito/useDistritoStore'

/* Candidato */
import { useCandidatoStore } from "./candidato/useCandidatoStore";
import { useUiCandidato } from "./candidato/useUiCandidato";

/* Resultados */
import { useResultadoStore } from "./resultado/useResultadoStore";

/* Exportacion y Vista de Actas */
import { useActasResStore } from "./acta/useActasResStore";


/* Notificaciones */
import { useNotification } from "./helper/useNotification";

/* Escrutinio */
import { useEscrutinioStore } from "./escrutinio/useEscrutinioStore";

/* Tendencias */
import { useTendenciaStore } from "./tendencia/useTendenciaStore";

/* Cantidades */
import { useCantidadStore } from "./cantidad/useCantidadStore";

export {

    /* Authentication */
    useAuthStore,

    /* Role */
    useRoleStore,

    /* Dignidad */
    useDignidadStore,

    /* Estados */
    useStateStore,

    /* Styles */
    useCreateStyles,
    useStatStyles,

    /* Usuarios */
    useUiUsuario,
    useUsuarioStore,

    /* Acta */
    useActaStore,

    /* Fecha Actual */
    useFechaActual,

    /* Organizacion */
    useOrganizacionStore,
    useUiOrganizacion,

    /* Distritos */
    useDistritoStore,

    /* Candidato */
    useCandidatoStore,
    useUiCandidato,

    /* Resultados */
    useResultadoStore,

    /* Exportacion y Vista de actas */
    useActasResStore,

    /* Notificacion */
    useNotification,

    /* Escrutinio */
    useEscrutinioStore,

    /* Tendencias */
    useTendenciaStore,

    /* Cantidades */
    useCantidadStore
}

