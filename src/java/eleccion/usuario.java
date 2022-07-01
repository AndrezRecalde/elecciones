/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author USUARIO
 */
public class usuario {
    private int idusuario;
    private String nombres;
    private String usuario;
    private int fr_id_provincia;
    private String provincia_nombre;
    private int fr_id_tipo_usuario;
    private String tipo_usu_nombre;
    private String login;
    private String clave;
    private boolean activo;
    private Timestamp usu_ui;
    private Timestamp usu_fi;
    private Timestamp usu_um;

    public usuario() {
    }

    public usuario(int idusuario, String nombres, String usuario, int fr_id_provincia, String provincia_nombre, int fr_id_tipo_usuario, String tipo_usu_nombre, String login, String clave, boolean activo, Timestamp usu_ui, Timestamp usu_fi, Timestamp usu_um) {
        this.idusuario = idusuario;
        this.nombres = nombres;
        this.usuario = usuario;
        this.fr_id_provincia = fr_id_provincia;
        this.provincia_nombre = provincia_nombre;
        this.fr_id_tipo_usuario = fr_id_tipo_usuario;
        this.tipo_usu_nombre = tipo_usu_nombre;
        this.login = login;
        this.clave = clave;
        this.activo = activo;
        this.usu_ui = usu_ui;
        this.usu_fi = usu_fi;
        this.usu_um = usu_um;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getClave() {
        return clave;
    }

    public int getFr_id_provincia() {
        return fr_id_provincia;
    }

    public int getFr_id_tipo_usuario() {
        return fr_id_tipo_usuario;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public String getNombres() {
        return nombres;
    }

    public Timestamp getUsu_fi() {
        return usu_fi;
    }

    public String getTipo_usu_nombre() {
        return tipo_usu_nombre;
    }

    public String getProvincia_nombre() {
        return provincia_nombre;
    }

    public void setTipo_usu_nombre(String tipo_usu_nombre) {
        this.tipo_usu_nombre = tipo_usu_nombre;
    }

    public void setProvincia_nombre(String provincia_nombre) {
        this.provincia_nombre = provincia_nombre;
    }

    public Timestamp getUsu_ui() {
        return usu_ui;
    }

    public Timestamp getUsu_um() {
        return usu_um;
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setFr_id_provincia(int fr_id_provincia) {
        this.fr_id_provincia = fr_id_provincia;
    }

    public void setFr_id_tipo_usuario(int fr_id_tipo_usuario) {
        this.fr_id_tipo_usuario = fr_id_tipo_usuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setUsu_fi(Timestamp usu_fi) {
        this.usu_fi = usu_fi;
    }

    public void setUsu_ui(Timestamp usu_ui) {
        this.usu_ui = usu_ui;
    }

    public void setUsu_um(Timestamp usu_um) {
        this.usu_um = usu_um;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
