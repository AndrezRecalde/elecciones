/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

import java.sql.Timestamp;

/**
 *
 * @author root
 */
public class acta {
    private int idacta;
    private int cod_provincia;
    private int cod_canton;
    private int cod_parroquia;
    private int cod_zona;
    private int fr_id_junta;
    private String provincia_nombre;
    private String canton_nombre;
    private String parroquia_nombre;
    private String zona_nombre;
    private String recinto_nombre;
    private String junta_nombre;
    private String responsable;
    private String responsable_telefono;
    private int fr_id_dignidad;
    private String dignidad_nombre;
    private int cne_cod_acta;
    private int num_validos;
    private int num_no_voto;
    private int num_blancos;
    private int num_nulos;
    private int acta_usu_ing;
    private int acta_usu_mod;
    private Timestamp acta_fi;
    private Timestamp acta_um;
    private boolean cuadrada;
    private boolean legible;
    private int fr_id_acta_estado;
    private String estado_nombre;
    private String usuario_nombre;
    private String usuario_usuario;
    private String responsable_cedula;

    public String getResponsable_cedula() {
        return responsable_cedula;
    }

    public void setResponsable_cedula(String responsable_cedula) {
        this.responsable_cedula = responsable_cedula;
    }

    public acta() {
    }

    public void setUsuario_usuario(String usuario_usuario) {
        this.usuario_usuario = usuario_usuario;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_usuario() {
        return usuario_usuario;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setZona_nombre(String zona_nombre) {
        this.zona_nombre = zona_nombre;
    }

    public void setProvincia_nombre(String provincia_nombre) {
        this.provincia_nombre = provincia_nombre;
    }

    public void setParroquia_nombre(String parroquia_nombre) {
        this.parroquia_nombre = parroquia_nombre;
    }

    public void setCanton_nombre(String canton_nombre) {
        this.canton_nombre = canton_nombre;
    }

    public void setRecinto_nombre(String recinto_nombre) {
        this.recinto_nombre = recinto_nombre;
    }

    public String getRecinto_nombre() {
        return recinto_nombre;
    }

    public String getZona_nombre() {
        return zona_nombre;
    }

    public String getProvincia_nombre() {
        return provincia_nombre;
    }

    public String getParroquia_nombre() {
        return parroquia_nombre;
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

    public int getCod_provincia() {
        return cod_provincia;
    }

    public int getCod_zona() {
        return cod_zona;
    }

    public void setCod_canton(int cod_canton) {
        this.cod_canton = cod_canton;
    }

    public void setResponsable_telefono(String responsable_telefono) {
        this.responsable_telefono = responsable_telefono;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getResponsable_telefono() {
        return responsable_telefono;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setCod_parroquia(int cod_parroquia) {
        this.cod_parroquia = cod_parroquia;
    }

    public void setCod_provincia(int cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public void setCod_zona(int cod_zona) {
        this.cod_zona = cod_zona;
    }

    public Timestamp getActa_fi() {
        return acta_fi;
    }

    public Timestamp getActa_um() {
        return acta_um;
    }

    public int getActa_usu_ing() {
        return acta_usu_ing;
    }

    public int getActa_usu_mod() {
        return acta_usu_mod;
    }

    public int getCne_cod_acta() {
        return cne_cod_acta;
    }

    public String getDignidad_nombre() {
        return dignidad_nombre;
    }

    public String getEstado_nombre() {
        return estado_nombre;
    }

    public int getFr_id_acta_estado() {
        return fr_id_acta_estado;
    }

    public int getFr_id_dignidad() {
        return fr_id_dignidad;
    }

    public int getFr_id_junta() {
        return fr_id_junta;
    }

    public int getIdacta() {
        return idacta;
    }

    public String getJunta_nombre() {
        return junta_nombre;
    }

    public int getNum_blancos() {
        return num_blancos;
    }

    public int getNum_no_voto() {
        return num_no_voto;
    }

    public int getNum_nulos() {
        return num_nulos;
    }

    public int getNum_validos() {
        return num_validos;
    }

    public boolean isCuadrada() {
        return cuadrada;
    }

    public boolean isLegible() {
        return legible;
    }

    public void setActa_fi(Timestamp acta_fi) {
        this.acta_fi = acta_fi;
    }

    public void setActa_um(Timestamp acta_um) {
        this.acta_um = acta_um;
    }

    public void setActa_usu_ing(int acta_usu_ing) {
        this.acta_usu_ing = acta_usu_ing;
    }

    public void setActa_usu_mod(int acta_usu_mod) {
        this.acta_usu_mod = acta_usu_mod;
    }

    public void setCne_cod_acta(int cne_cod_acta) {
        this.cne_cod_acta = cne_cod_acta;
    }

    public void setCuadrada(boolean cuadrada) {
        this.cuadrada = cuadrada;
    }

    public void setDignidad_nombre(String dignidad_nombre) {
        this.dignidad_nombre = dignidad_nombre;
    }

    public void setEstado_nombre(String estado_nombre) {
        this.estado_nombre = estado_nombre;
    }

    public void setFr_id_acta_estado(int fr_id_acta_estado) {
        this.fr_id_acta_estado = fr_id_acta_estado;
    }

    public void setFr_id_dignidad(int fr_id_dignidad) {
        this.fr_id_dignidad = fr_id_dignidad;
    }

    public void setFr_id_junta(int fr_id_junta) {
        this.fr_id_junta = fr_id_junta;
    }

    public void setIdacta(int idacta) {
        this.idacta = idacta;
    }

    public void setJunta_nombre(String junta_nombre) {
        this.junta_nombre = junta_nombre;
    }

    public void setLegible(boolean legible) {
        this.legible = legible;
    }

    public void setNum_blancos(int num_blancos) {
        this.num_blancos = num_blancos;
    }

    public void setNum_no_voto(int num_no_voto) {
        this.num_no_voto = num_no_voto;
    }

    public void setNum_nulos(int num_nulos) {
        this.num_nulos = num_nulos;
    }

    public void setNum_validos(int num_validos) {
        this.num_validos = num_validos;
    }
     
}

