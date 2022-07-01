/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

/**
 *
 * @author root
 */
public class candidato {
    private int idcandidato;
    private int fr_id_organizacion;
    private String organizacion_nombre;
    private String organizacion_lista;
    private String nombre;
    private int fr_id_dignidad;
    private String dignidad_nombre;
    private String imagen;
    private boolean activo;
    private boolean es_provincial;
    private int fr_id_provincia;
    private String provincia_nombre;
    private boolean es_cantonal;
    private int fr_id_canton;
    private boolean es_parroquial;
    private int fr_id_parroquia;

    public candidato() {
    }

    public void setFr_id_parroquia(int fr_id_parroquia) {
        this.fr_id_parroquia = fr_id_parroquia;
    }

    public void setFr_id_canton(int fr_id_canton) {
        this.fr_id_canton = fr_id_canton;
    }

    public void setEs_parroquial(boolean es_parroquial) {
        this.es_parroquial = es_parroquial;
    }

    public void setEs_cantonal(boolean es_cantonal) {
        this.es_cantonal = es_cantonal;
    }

    public boolean isEs_parroquial() {
        return es_parroquial;
    }

    public boolean isEs_cantonal() {
        return es_cantonal;
    }

    public int getFr_id_parroquia() {
        return fr_id_parroquia;
    }

    public int getFr_id_canton() {
        return fr_id_canton;
    }

    public String getDignidad_nombre() {
        return dignidad_nombre;
    }

    public int getFr_id_dignidad() {
        return fr_id_dignidad;
    }

    public int getFr_id_organizacion() {
        return fr_id_organizacion;
    }

    public int getFr_id_provincia() {
        return fr_id_provincia;
    }

    public int getIdcandidato() {
        return idcandidato;
    }

    public String getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrganizacion_lista() {
        return organizacion_lista;
    }

    public String getOrganizacion_nombre() {
        return organizacion_nombre;
    }

    public String getProvincia_nombre() {
        return provincia_nombre;
    }

    public boolean isEs_provincial() {
        return es_provincial;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setDignidad_nombre(String dignidad_nombre) {
        this.dignidad_nombre = dignidad_nombre;
    }

    public void setEs_provincial(boolean es_provincial) {
        this.es_provincial = es_provincial;
    }

    public void setFr_id_dignidad(int fr_id_dignidad) {
        this.fr_id_dignidad = fr_id_dignidad;
    }

    public void setFr_id_organizacion(int fr_id_organizacion) {
        this.fr_id_organizacion = fr_id_organizacion;
    }

    public void setFr_id_provincia(int fr_id_provincia) {
        this.fr_id_provincia = fr_id_provincia;
    }

    public void setIdcandidato(int idcandidato) {
        this.idcandidato = idcandidato;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrganizacion_lista(String organizacion_lista) {
        this.organizacion_lista = organizacion_lista;
    }

    public void setOrganizacion_nombre(String organizacion_nombre) {
        this.organizacion_nombre = organizacion_nombre;
    }

    public void setProvincia_nombre(String provincia_nombre) {
        this.provincia_nombre = provincia_nombre;
    }

    
}
