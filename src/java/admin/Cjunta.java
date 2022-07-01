package admin;

import herramientas.conexion;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Generador V1.0
 */
public class Cjunta {

    private int idjunta;
    private int fr_id_zona;
    private String canton_string;
    private String parroquia_string;
    private String zonas_string;
    private String recinto_string;
    private int cne_cod_junta;
    private int num_junta;
    private String genero;
    private String junta_nombre;
    private int num_electores_cne;
    private int num_votaron;
    private int num_no_votaron;
    private int num_total_votaron;
    private boolean receptada;
    private String responsable;
    private String responsable_telefono;
    private int cod_recinto;

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

    public void setidjunta(int idjunta) {
        this.idjunta = idjunta;
    }

    public void setfr_id_zona(int fr_id_zona) {
        this.fr_id_zona = fr_id_zona;
    }

    public void setzonas_string(String zonas_string) {
        this.zonas_string = zonas_string;
    }

    public void setcne_cod_junta(int cne_cod_junta) {
        this.cne_cod_junta = cne_cod_junta;
    }

    public void setnum_junta(int num_junta) {
        this.num_junta = num_junta;
    }

    public void setgenero(String genero) {
        this.genero = genero;
    }

    public void setjunta_nombre(String junta_nombre) {
        this.junta_nombre = junta_nombre;
    }

    public void setnum_electores_cne(int num_electores_cne) {
        this.num_electores_cne = num_electores_cne;
    }

    public void setnum_votaron(int num_votaron) {
        this.num_votaron = num_votaron;
    }

    public void setnum_no_votaron(int num_no_votaron) {
        this.num_no_votaron = num_no_votaron;
    }

    public void setnum_total_votaron(int num_total_votaron) {
        this.num_total_votaron = num_total_votaron;
    }

    public void setreceptada(boolean receptada) {
        this.receptada = receptada;
    }

    public void setresponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setresponsable_telefono(String responsable_telefono) {
        this.responsable_telefono = responsable_telefono;
    }

    public void setcod_recinto(int cod_recinto) {
        this.cod_recinto = cod_recinto;
    }

    public int getidjunta() {
        return idjunta;
    }

    public int getfr_id_zona() {
        return fr_id_zona;
    }

    public String getzonas_string() {
        return zonas_string;
    }

    public int getcne_cod_junta() {
        return cne_cod_junta;
    }

    public int getnum_junta() {
        return num_junta;
    }

    public String getgenero() {
        return genero;
    }

    public String getjunta_nombre() {
        return junta_nombre;
    }

    public int getnum_electores_cne() {
        return num_electores_cne;
    }

    public int getnum_votaron() {
        return num_votaron;
    }

    public int getnum_no_votaron() {
        return num_no_votaron;
    }

    public int getnum_total_votaron() {
        return num_total_votaron;
    }

    public boolean getreceptada() {
        return receptada;
    }

    public String getresponsable() {
        return responsable;
    }

    public String getresponsable_telefono() {
        return responsable_telefono;
    }

    public int getcod_recinto() {
        return cod_recinto;
    }
}
