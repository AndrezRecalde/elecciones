/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

/**
 *
 * @author root
 */
public class dignidad {
    private int iddignidad;
    private String nombre_dignidad;
    private boolean activo;
    private boolean es_provincial;
    private int fr_id_id_provincia;
    private String provincia_nombre;
    private int fr_id_eleccion;
    private String eleccion_nombre;
    private int num_candidato_lista;
    
    public void setNum_candidato_lista(int num_candidato_lista) {
        this.num_candidato_lista = num_candidato_lista;
    }

    public void setNombre_dignidad(String nombre_dignidad) {
        this.nombre_dignidad = nombre_dignidad;
    }

    public void setIddignidad(int iddignidad) {
        this.iddignidad = iddignidad;
    }

    public void setFr_id_id_provincia(int fr_id_id_provincia) {
        this.fr_id_id_provincia = fr_id_id_provincia;
    }

    public void setFr_id_eleccion(int fr_id_eleccion) {
        this.fr_id_eleccion = fr_id_eleccion;
    }

    public void setEs_provincial(boolean es_provincial) {
        this.es_provincial = es_provincial;
    }

    public void setEleccion_nombre(String eleccion_nombre) {
        this.eleccion_nombre = eleccion_nombre;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isEs_provincial() {
        return es_provincial;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getProvincia_nombre() {
        return provincia_nombre;
    }

    public int getNum_candidato_lista() {
        return num_candidato_lista;
    }

    public String getNombre_dignidad() {
        return nombre_dignidad;
    }

    public int getIddignidad() {
        return iddignidad;
    }

    public int getFr_id_id_provincia() {
        return fr_id_id_provincia;
    }

    public int getFr_id_eleccion() {
        return fr_id_eleccion;
    }

    public String getEleccion_nombre() {
        return eleccion_nombre;
    }

    public dignidad(int iddignidad, String nombre_dignidad, boolean activo, boolean es_provincial, int fr_id_id_provincia, String provincia_nombre, int fr_id_eleccion, String eleccion_nombre, int num_candidato_lista) {
        this.iddignidad = iddignidad;
        this.nombre_dignidad = nombre_dignidad;
        this.activo = activo;
        this.es_provincial = es_provincial;
        this.fr_id_id_provincia = fr_id_id_provincia;
        this.provincia_nombre = provincia_nombre;
        this.fr_id_eleccion = fr_id_eleccion;
        this.eleccion_nombre = eleccion_nombre;
        this.num_candidato_lista = num_candidato_lista;
    }

    public dignidad() {
    }

}
