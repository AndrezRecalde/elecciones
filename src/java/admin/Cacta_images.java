package admin;

import herramientas.conexion;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Generador V1.0
 */
public class Cacta_images {

    private int idacta_images;
    private int acta_image_usu_ing;
    private String usuario_string;
    private int acta_image_id_junta;
    private String canton_string;
    private String parroquia_string;
    private String zona_string;
    private String recinto_string;
    private String junta_string;
    private int acta_image_id_dignidad;
    private String dignidad_string;
    private boolean acta_image_activa;
    private Timestamp acta_image_fi;
    private Timestamp acta_image_um;

    public String getCanton_string() {
        return canton_string;
    }

    public void setCanton_string(String canton_string) {
        this.canton_string = canton_string;
    }

    public String getZona_string() {
        return zona_string;
    }

    public void setZona_string(String zona_string) {
        this.zona_string = zona_string;
    }

    public void setParroquia_string(String parroquia_string) {
        this.parroquia_string = parroquia_string;
    }

    public String getParroquia_string() {
        return parroquia_string;
    }

    public String getRecinto_string() {
        return recinto_string;
    }

    public void setRecinto_string(String recinto_string) {
        this.recinto_string = recinto_string;
    }

    public void setidacta_images(int idacta_images) {
        this.idacta_images = idacta_images;
    }

    public void setacta_image_usu_ing(int acta_image_usu_ing) {
        this.acta_image_usu_ing = acta_image_usu_ing;
    }

    public void setusuario_string(String usuario_string) {
        this.usuario_string = usuario_string;
    }

    public void setacta_image_id_junta(int acta_image_id_junta) {
        this.acta_image_id_junta = acta_image_id_junta;
    }

    public void setjunta_string(String junta_string) {
        this.junta_string = junta_string;
    }

    public void setacta_image_id_dignidad(int acta_image_id_dignidad) {
        this.acta_image_id_dignidad = acta_image_id_dignidad;
    }

    public void setdignidad_string(String dignidad_string) {
        this.dignidad_string = dignidad_string;
    }

    public void setacta_image_activa(boolean acta_image_activa) {
        this.acta_image_activa = acta_image_activa;
    }

    public void setacta_image_fi(Timestamp acta_image_fi) {
        this.acta_image_fi = acta_image_fi;
    }

    public void setacta_image_um(Timestamp acta_image_um) {
        this.acta_image_um = acta_image_um;
    }

    public int getidacta_images() {
        return idacta_images;
    }

    public int getacta_image_usu_ing() {
        return acta_image_usu_ing;
    }

    public String getusuario_string() {
        return usuario_string;
    }

    public int getacta_image_id_junta() {
        return acta_image_id_junta;
    }

    public String getjunta_string() {
        return junta_string;
    }

    public int getacta_image_id_dignidad() {
        return acta_image_id_dignidad;
    }

    public String getdignidad_string() {
        return dignidad_string;
    }

    public boolean getacta_image_activa() {
        return acta_image_activa;
    }

    public Timestamp getacta_image_fi() {
        return acta_image_fi;
    }

    public Timestamp getacta_image_um() {
        return acta_image_um;
    }
}
