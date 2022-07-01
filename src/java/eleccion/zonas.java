/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

/**
 *
 * @author root
 */
public class zonas {
    private int idzonas;
    private int cod_parroquia;
    private String parroquia_nombre;
    private String nombre_zona;
    private String est_parroquia;
    private int cod_zona;
    private int num_elec_zona;
    private int num_elec_hombres_zona;
    private int num_elec_mujeres_zona;
    private int num_juntas;
    private int num_junta_hombre;
    private int num_junta_mujeres;
    private int num_elec_zona_max;
 
    public String getEst_parroquia() {
        return est_parroquia;
    }

    public int getCod_zona() {
        return cod_zona;
    }

    public int getCod_parroquia() {
        return cod_parroquia;
    }

    public zonas(int idzonas, int cod_parroquia, String parroquia_nombre, String nombre_zona, String est_parroquia, int cod_zona, int num_elec_zona, int num_elec_hombres_zona, int num_elec_mujeres_zona, int num_juntas, int num_junta_hombre, int num_junta_mujeres, int num_elec_zona_max) {
        this.idzonas = idzonas;
        this.cod_parroquia = cod_parroquia;
        this.parroquia_nombre = parroquia_nombre;
        this.nombre_zona = nombre_zona;
        this.est_parroquia = est_parroquia;
        this.cod_zona = cod_zona;
        this.num_elec_zona = num_elec_zona;
        this.num_elec_hombres_zona = num_elec_hombres_zona;
        this.num_elec_mujeres_zona = num_elec_mujeres_zona;
        this.num_juntas = num_juntas;
        this.num_junta_hombre = num_junta_hombre;
        this.num_junta_mujeres = num_junta_mujeres;
        this.num_elec_zona_max = num_elec_zona_max;
    }

    public zonas() {
    }
 
    public int getNum_elec_hombres_zona() {
        return num_elec_hombres_zona;
    }

    public String getNombre_zona() {
        return nombre_zona;
    }

    public int getIdzonas() {
        return idzonas;
    }

    public int getNum_junta_hombre() {
        return num_junta_hombre;
    }

    public int getNum_junta_mujeres() {
        return num_junta_mujeres;
    }

    public int getNum_juntas() {
        return num_juntas;
    }

    public String getParroquia_nombre() {
        return parroquia_nombre;
    }

    public void setCod_parroquia(int cod_parroquia) {
        this.cod_parroquia = cod_parroquia;
    }

    public void setCod_zona(int cod_zona) {
        this.cod_zona = cod_zona;
    }

    public void setEst_parroquia(String est_parroquia) {
        this.est_parroquia = est_parroquia;
    }

    public void setIdzonas(int idzonas) {
        this.idzonas = idzonas;
    }

    public void setNombre_zona(String nombre_zona) {
        this.nombre_zona = nombre_zona;
    }

    public void setNum_elec_hombres_zona(int num_elec_hombres_zona) {
        this.num_elec_hombres_zona = num_elec_hombres_zona;
    }

    public void setNum_elec_mujeres_zona(int num_elec_mujeres_zona) {
        this.num_elec_mujeres_zona = num_elec_mujeres_zona;
    }

    public void setNum_elec_zona(int num_elec_zona) {
        this.num_elec_zona = num_elec_zona;
    }

    public void setNum_elec_zona_max(int num_elec_zona_max) {
        this.num_elec_zona_max = num_elec_zona_max;
    }

    public void setNum_junta_hombre(int num_junta_hombre) {
        this.num_junta_hombre = num_junta_hombre;
    }

    public void setNum_junta_mujeres(int num_junta_mujeres) {
        this.num_junta_mujeres = num_junta_mujeres;
    }

    public void setNum_juntas(int num_juntas) {
        this.num_juntas = num_juntas;
    }

    public void setParroquia_nombre(String parroquia_nombre) {
        this.parroquia_nombre = parroquia_nombre;
    }
   
    public int getNum_elec_zona_max() {
        return num_elec_zona_max;
    }

    public int getNum_elec_zona() {
        return num_elec_zona;
    }

    public int getNum_elec_mujeres_zona() {
        return num_elec_mujeres_zona;
    }

}
