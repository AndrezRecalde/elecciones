package admin;

import herramientas.conexion;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Generador V1.0
 */
public class Cacta {

    private int idacta;
    private int cod_provincia;
    private int cod_canton;
    private int cod_parroquia;
    private int cod_zona;
    private int fr_id_junta;
    private String junta_string;
    private String dignidad_string;
    private int fr_id_dignidad;
    private int cne_cod_acta;
    private int num_validos;
    private int num_no_voto;
    private int num_blancos;
    private int num_nulos;
    private int acta_usu_ing;
    private String acta_usu_ing_string;
    private int acta_usu_mod;
    private Timestamp acta_fi;
    private Timestamp acta_um;
    private boolean cuadrada;
    private boolean legible;
    private int fr_id_acta_estado;
    private String canton_string;
    private String parroquia_string;
    private String zonas_string;
    private String recinto_string;

    public String getActa_usu_ing_string() {
        return acta_usu_ing_string;
    }

    public void setActa_usu_ing_string(String acta_usu_ing_string) {
        this.acta_usu_ing_string = acta_usu_ing_string;
    }
    
    public String getDignidad_string() {
        return dignidad_string;
    }

    public void setDignidad_string(String dignidad_string) {
        this.dignidad_string = dignidad_string;
    }

    
    public String getCanton_string() {
        return canton_string;
    }

    public void setCanton_string(String canton_string) {
        this.canton_string = canton_string;
    }

    public String getParroquia_string() {
        return parroquia_string;
    }

    public void setParroquia_string(String parroquia_string) {
        this.parroquia_string = parroquia_string;
    }

    public String getRecinto_string() {
        return recinto_string;
    }

    public void setRecinto_string(String recinto_string) {
        this.recinto_string = recinto_string;
    }

    public String getZonas_string() {
        return zonas_string;
    }

    public void setZonas_string(String zonas_string) {
        this.zonas_string = zonas_string;
    }

    public void setidacta(int idacta) {
        this.idacta = idacta;
    }

    public void setcod_provincia(int cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public void setcod_canton(int cod_canton) {
        this.cod_canton = cod_canton;
    }

    public void setcod_parroquia(int cod_parroquia) {
        this.cod_parroquia = cod_parroquia;
    }

    public void setcod_zona(int cod_zona) {
        this.cod_zona = cod_zona;
    }

    public void setfr_id_junta(int fr_id_junta) {
        this.fr_id_junta = fr_id_junta;
    }

    public void setjunta_string(String junta_string) {
        this.junta_string = junta_string;
    }

    public void setfr_id_dignidad(int fr_id_dignidad) {
        this.fr_id_dignidad = fr_id_dignidad;
    }

    public void setcne_cod_acta(int cne_cod_acta) {
        this.cne_cod_acta = cne_cod_acta;
    }

    public void setnum_validos(int num_validos) {
        this.num_validos = num_validos;
    }

    public void setnum_no_voto(int num_no_voto) {
        this.num_no_voto = num_no_voto;
    }

    public void setnum_blancos(int num_blancos) {
        this.num_blancos = num_blancos;
    }

    public void setnum_nulos(int num_nulos) {
        this.num_nulos = num_nulos;
    }

    public void setacta_usu_ing(int acta_usu_ing) {
        this.acta_usu_ing = acta_usu_ing;
    }

    public void setacta_usu_mod(int acta_usu_mod) {
        this.acta_usu_mod = acta_usu_mod;
    }

    public void setacta_fi(Timestamp acta_fi) {
        this.acta_fi = acta_fi;
    }

    public void setacta_um(Timestamp acta_um) {
        this.acta_um = acta_um;
    }

    public void setcuadrada(boolean cuadrada) {
        this.cuadrada = cuadrada;
    }

    public void setlegible(boolean legible) {
        this.legible = legible;
    }

    public void setfr_id_acta_estado(int fr_id_acta_estado) {
        this.fr_id_acta_estado = fr_id_acta_estado;
    }

    public int getidacta() {
        return idacta;
    }

    public int getcod_provincia() {
        return cod_provincia;
    }

    public int getcod_canton() {
        return cod_canton;
    }

    public int getcod_parroquia() {
        return cod_parroquia;
    }

    public int getcod_zona() {
        return cod_zona;
    }

    public int getfr_id_junta() {
        return fr_id_junta;
    }

    public String getjunta_string() {
        return junta_string;
    }

    public int getfr_id_dignidad() {
        return fr_id_dignidad;
    }

    public int getcne_cod_acta() {
        return cne_cod_acta;
    }

    public int getnum_validos() {
        return num_validos;
    }

    public int getnum_no_voto() {
        return num_no_voto;
    }

    public int getnum_blancos() {
        return num_blancos;
    }

    public int getnum_nulos() {
        return num_nulos;
    }

    public int getacta_usu_ing() {
        return acta_usu_ing;
    }

    public int getacta_usu_mod() {
        return acta_usu_mod;
    }

    public Timestamp getacta_fi() {
        return acta_fi;
    }

    public Timestamp getacta_um() {
        return acta_um;
    }

    public boolean getcuadrada() {
        return cuadrada;
    }

    public boolean getlegible() {
        return legible;
    }

    public int getfr_id_acta_estado() {
        return fr_id_acta_estado;
    }
}
