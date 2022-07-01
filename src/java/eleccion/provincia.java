/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

/**
 *
 * @author userver1
 */
public class provincia {
    private int cne_cod_prov;
    private String nombre_provincia;
    private int num_vot_hombres;
    private int num_vot_mujeres;
    private boolean activa;

    public provincia() {
    }

    public provincia(int cne_cod_prov, String nombre_provincia, int num_vot_hombres, int num_vot_mujeres, boolean activa) {
        this.cne_cod_prov = cne_cod_prov;
        this.nombre_provincia = nombre_provincia;
        this.num_vot_hombres = num_vot_hombres;
        this.num_vot_mujeres = num_vot_mujeres;
        this.activa = activa;
    }

    public int getCne_cod_prov() {
        return cne_cod_prov;
    }

    public String getNombre_provincia() {
        return nombre_provincia;
    }

    public int getNum_vot_hombres() {
        return num_vot_hombres;
    }

    public int getNum_vot_mujeres() {
        return num_vot_mujeres;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public void setCne_cod_prov(int cne_cod_prov) {
        this.cne_cod_prov = cne_cod_prov;
    }

    public void setNombre_provincia(String nombre_provincia) {
        this.nombre_provincia = nombre_provincia;
    }

    public void setNum_vot_hombres(int num_vot_hombres) {
        this.num_vot_hombres = num_vot_hombres;
    }

    public void setNum_vot_mujeres(int num_vot_mujeres) {
        this.num_vot_mujeres = num_vot_mujeres;
    }

    
}
