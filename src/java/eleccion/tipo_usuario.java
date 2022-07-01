/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

/**
 *
 * @author userver1
 */
public class tipo_usuario {
    private int idtipo_usuario;
    private String nombre_tipo_usuario;
    private boolean activo;

    public tipo_usuario() {
    }

    public tipo_usuario(int idtipo_usuario, String nombre_tipo_usuario, boolean activo) {
        this.idtipo_usuario = idtipo_usuario;
        this.nombre_tipo_usuario = nombre_tipo_usuario;
        this.activo = activo;
    }

    public int getIdtipo_usuario() {
        return idtipo_usuario;
    }

    public String getNombre_tipo_usuario() {
        return nombre_tipo_usuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setIdtipo_usuario(int idtipo_usuario) {
        this.idtipo_usuario = idtipo_usuario;
    }

    public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }
    
}
