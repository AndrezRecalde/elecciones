package admin;

import herramientas.conexion;
import java.sql.Timestamp;
import java.util.Date;
/**
 *
 * @author Generador V1.0
 */
public class Ctipo_usuario{
	private int idtipo_usuario;
	private String nombre_tipo_usuario;
	private boolean activo;
	public void setidtipo_usuario(int idtipo_usuario){
		this.idtipo_usuario=idtipo_usuario;
	}
	public void setnombre_tipo_usuario(String nombre_tipo_usuario){
		this.nombre_tipo_usuario=nombre_tipo_usuario;
	}
	public void setactivo(boolean activo){
		this.activo=activo;
	}
	public int getidtipo_usuario(){
		return idtipo_usuario;
	}
	public String getnombre_tipo_usuario(){
		return nombre_tipo_usuario;
	}
	public boolean getactivo(){
		return activo;
	}
}