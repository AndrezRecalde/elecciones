/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

/**
 *
 * @author root
 */
public class cantones {
    private int cod_canton;
    private int cod_provincia;
    private String nombre_canton;
    private String provincia_nombre;
    private boolean tiene_circunscipciones;
    private int fr_id_canton_pertenece;

    public cantones() {
    }

    public void setTiene_circunscipciones(boolean tiene_circunscipciones) {
        this.tiene_circunscipciones = tiene_circunscipciones;
    }

    public boolean isTiene_circunscipciones() {
        return tiene_circunscipciones;
    }

    public void setFr_id_canton_pertenece(int fr_id_canton_pertenece) {
        this.fr_id_canton_pertenece = fr_id_canton_pertenece;
    }

    public int getFr_id_canton_pertenece() {
        return fr_id_canton_pertenece;
    }


    public int getCod_canton() {
        return cod_canton;
    }

    public int getCod_provincia() {
        return cod_provincia;
    }

    public String getNombre_canton() {
        return nombre_canton;
    }

    public String getProvincia_nombre() {
        return provincia_nombre;
    }

    public void setCod_canton(int cod_canton) {
        this.cod_canton = cod_canton;
    }

    public void setCod_provincia(int cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public void setNombre_canton(String nombre_canton) {
        this.nombre_canton = nombre_canton;
    }

    public void setProvincia_nombre(String provincia_nombre) {
        this.provincia_nombre = provincia_nombre;
    }
    
}
