/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

/**
 *
 * @author root
 */
public class parroquias {
    
    private int cod_parroquia;
    private int cod_canton;
    private String canton_nombre;
    private String nombre_parroquia;
    private String estado_parroquia;

    public parroquias() {
        
    }

    public parroquias(int cod_parroquia, int cod_canton, String canton_nombre, String nombre_parroquia, String estado_parroquia) {
        this.cod_parroquia = cod_parroquia;
        this.cod_canton = cod_canton;
        this.canton_nombre = canton_nombre;
        this.nombre_parroquia = nombre_parroquia;
        this.estado_parroquia = estado_parroquia;
    }

    public String getCanton_nombre() {
        return canton_nombre;
    }

    public int getCod_canton() {
        return cod_canton;
    }

    public int getCod_parroquia() {
        return cod_parroquia;
    }

    public String getEstado_parroquia() {
        return estado_parroquia;
    }

    public String getNombre_parroquia() {
        return nombre_parroquia;
    }

    public void setCod_canton(int cod_canton) {
        this.cod_canton = cod_canton;
    }

    public void setCanton_nombre(String canton_nombre) {
        this.canton_nombre = canton_nombre;
    }

    public void setCod_parroquia(int cod_parroquia) {
        this.cod_parroquia = cod_parroquia;
    }

    public void setEstado_parroquia(String estado_parroquia) {
        this.estado_parroquia = estado_parroquia;
    }

    public void setNombre_parroquia(String nombre_parroquia) {
        this.nombre_parroquia = nombre_parroquia;
    }
    
    
}
