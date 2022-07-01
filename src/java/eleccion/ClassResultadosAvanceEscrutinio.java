/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

/**
 *
 * @author DQuevedo
 */
public class ClassResultadosAvanceEscrutinio {

    private int cod_canton;
    private String nombre_canton;
    private int fr_id_canton_pertenece;
    private int iddignidad;
    private String nombre_dignidad;
    private int ingresadas;
    private int con_responsable;
    private int total;

    public int getCon_responsable() {
        return con_responsable;
    }

    public void setCon_responsable(int con_responsable) {
        this.con_responsable = con_responsable;
    }

    public int getCod_canton() {
        return cod_canton;
    }

    public int getFr_id_canton_pertenece() {
        return fr_id_canton_pertenece;
    }

    public int getIddignidad() {
        return iddignidad;
    }

    public int getIngresadas() {
        return ingresadas;
    }

    public String getNombre_canton() {
        return nombre_canton;
    }

    public String getNombre_dignidad() {
        return nombre_dignidad;
    }

    public int getTotal() {
        return total;
    }

    public void setCod_canton(int cod_canton) {
        this.cod_canton = cod_canton;
    }

    public void setFr_id_canton_pertenece(int fr_id_canton_pertenece) {
        this.fr_id_canton_pertenece = fr_id_canton_pertenece;
    }

    public void setIddignidad(int iddignidad) {
        this.iddignidad = iddignidad;
    }

    public void setIngresadas(int ingresadas) {
        this.ingresadas = ingresadas;
    }

    public void setNombre_canton(String nombre_canton) {
        this.nombre_canton = nombre_canton;
    }

    public void setNombre_dignidad(String nombre_dignidad) {
        this.nombre_dignidad = nombre_dignidad;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
