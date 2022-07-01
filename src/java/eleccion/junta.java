/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

/**
 *
 * @author root
 */
public class junta {
    private int idjunta;
    private int fr_id_recinto;
    private int cne_cod_junta;
    private int num_junta;
    private String genero;
    private String cedula;
    private String junta_nombre;
    private int num_electores_cne;
    private int num_votaron;
    private int num_no_votaron;
    private int num_total_votaron;
    private boolean receptada;
    private String responsable;
    private String responsable_telefono;
    private String recinto_nombre;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    
    public junta() {
        recinto_nombre="PRUEBA";
    }

    public String getRecinto_nombre() {
        return recinto_nombre;
    }

    public void setRecinto_nombre(String recinto_nombre) {
        this.recinto_nombre = recinto_nombre;
    }
    

    public String getResponsable() {
        return responsable;
    }

    public String getResponsable_telefono() {
        return responsable_telefono;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setResponsable_telefono(String responsable_telefono) {
        this.responsable_telefono = responsable_telefono;
    }

    public String getJunta_nombre() {
        return junta_nombre;
    }

    public void setJunta_nombre(String junta_nombre) {
        this.junta_nombre = junta_nombre;
    }

    public int getCne_cod_junta() {
        return cne_cod_junta;
    }

    public int getFr_id_recinto() {
        return fr_id_recinto;
    }

    public String getGenero() {
        return genero;
    }

    public int getIdjunta() {
        return idjunta;
    }

    public int getNum_electores_cne() {
        return num_electores_cne;
    }

    public int getNum_junta() {
        return num_junta;
    }

    public int getNum_no_votaron() {
        return num_no_votaron;
    }

    public int getNum_total_votaron() {
        return num_total_votaron;
    }

    public int getNum_votaron() {
        return num_votaron;
    }

    public boolean isReceptada() {
        return receptada;
    }

    public void setCne_cod_junta(int cne_cod_junta) {
        this.cne_cod_junta = cne_cod_junta;
    }

    public void setFr_id_recinto(int fr_id_recinto) {
        this.fr_id_recinto = fr_id_recinto;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdjunta(int idjunta) {
        this.idjunta = idjunta;
    }

    public void setNum_electores_cne(int num_electores_cne) {
        this.num_electores_cne = num_electores_cne;
    }

    public void setNum_junta(int num_junta) {
        this.num_junta = num_junta;
    }

    public void setNum_no_votaron(int num_no_votaron) {
        this.num_no_votaron = num_no_votaron;
    }

    public void setNum_total_votaron(int num_total_votaron) {
        this.num_total_votaron = num_total_votaron;
    }

    public void setNum_votaron(int num_votaron) {
        this.num_votaron = num_votaron;
    }

    public void setReceptada(boolean receptada) {
        this.receptada = receptada;
    }
    
}
