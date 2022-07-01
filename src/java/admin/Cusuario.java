package admin;

import herramientas.conexion;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Generador V1.0
 */
public class Cusuario {

    private int idusuario;
    private String nombres;
    private String usuario;
    private int fr_id_provincia;
    private String provincia_string;
    private String provincia_nombre;
    private int fr_id_tipo_usuario;
    private boolean es_provincial;
    private int fr_id_canton;
    private int fr_id_canton_padre;
    private String cantones_string;
    private boolean es_cantonal;
    private String tipo_usu_nombre;
    private String tipo_usuario_string;
    private String login;
    private String clave;
    private boolean activo;
    private Timestamp usu_ui;
    private Timestamp usu_fi;
    private Timestamp usu_um;

    public int getFr_id_canton_padre() {
        return fr_id_canton_padre;
    }

    public void setFr_id_canton_padre(int fr_id_canton_padre) {
        this.fr_id_canton_padre = fr_id_canton_padre;
    }

    
    public void setidusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public void setnombres(String nombres) {
        this.nombres = nombres;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public void setfr_id_provincia(int fr_id_provincia) {
        this.fr_id_provincia = fr_id_provincia;
    }

    public void setprovincia_string(String provincia_string) {
        this.provincia_string = provincia_string;
    }

    public void setprovincia_nombre(String provincia_nombre) {
        this.provincia_nombre = provincia_nombre;
    }

    public void setfr_id_tipo_usuario(int fr_id_tipo_usuario) {
        this.fr_id_tipo_usuario = fr_id_tipo_usuario;
    }

    public void setes_provincial(boolean es_provincial) {
        this.es_provincial = es_provincial;
    }

    public void setfr_id_canton(int fr_id_canton) {
        this.fr_id_canton = fr_id_canton;
    }

    public void setcantones_string(String cantones_string) {
        this.cantones_string = cantones_string;
    }

    public void setes_cantonal(boolean es_cantonal) {
        this.es_cantonal = es_cantonal;
    }

    public void settipo_usu_nombre(String tipo_usu_nombre) {
        this.tipo_usu_nombre = tipo_usu_nombre;
    }

    public void settipo_usuario_string(String tipo_usuario_string) {
        this.tipo_usuario_string = tipo_usuario_string;
    }

    public void setlogin(String login) {
        this.login = login;
    }

    public void setclave(String clave) {
        this.clave = clave;
    }

    public void setactivo(boolean activo) {
        this.activo = activo;
    }

    public void setusu_ui(Timestamp usu_ui) {
        this.usu_ui = usu_ui;
    }

    public void setusu_fi(Timestamp usu_fi) {
        this.usu_fi = usu_fi;
    }

    public void setusu_um(Timestamp usu_um) {
        this.usu_um = usu_um;
    }

    public int getidusuario() {
        return idusuario;
    }

    public String getnombres() {
        return nombres;
    }

    public String getusuario() {
        return usuario;
    }

    public int getfr_id_provincia() {
        return fr_id_provincia;
    }

    public String getprovincia_string() {
        return provincia_string;
    }

    public String getprovincia_nombre() {
        return provincia_nombre;
    }

    public int getfr_id_tipo_usuario() {
        return fr_id_tipo_usuario;
    }

    public boolean getes_provincial() {
        return es_provincial;
    }

    public int getfr_id_canton() {
        return fr_id_canton;
    }

    public String getcantones_string() {
        return cantones_string;
    }

    public boolean getes_cantonal() {
        return es_cantonal;
    }

    public String gettipo_usu_nombre() {
        return tipo_usu_nombre;
    }

    public String gettipo_usuario_string() {
        return tipo_usuario_string;
    }

    public String getlogin() {
        return login;
    }

    public String getclave() {
        return clave;
    }

    public boolean getactivo() {
        return activo;
    }

    public Timestamp getusu_ui() {
        return usu_ui;
    }

    public Timestamp getusu_fi() {
        return usu_fi;
    }

    public Timestamp getusu_um() {
        return usu_um;
    }
}
