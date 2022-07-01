package admin;

import herramientas.conexion;
import java.sql.Timestamp;
import java.util.Date;
/**
 *
 * @author Generador V1.0
 */
public class Caccesos{
	private int idaccesos;
	private int usuario_id;
	private String usuario_string;
	private int acceso_opcion_id;
	private String acceso_opcion_string;
	private Timestamp acceso_fecha;
	public void setidaccesos(int idaccesos){
		this.idaccesos=idaccesos;
	}
	public void setusuario_id(int usuario_id){
		this.usuario_id=usuario_id;
	}
	public void setusuario_string(String usuario_string){
		this.usuario_string=usuario_string;
	}
	public void setacceso_opcion_id(int acceso_opcion_id){
		this.acceso_opcion_id=acceso_opcion_id;
	}
	public void setacceso_opcion_string(String acceso_opcion_string){
		this.acceso_opcion_string=acceso_opcion_string;
	}
	public void setacceso_fecha(Timestamp acceso_fecha){
		this.acceso_fecha=acceso_fecha;
	}
	public int getidaccesos(){
		return idaccesos;
	}
	public int getusuario_id(){
		return usuario_id;
	}
	public String getusuario_string(){
		return usuario_string;
	}
	public int getacceso_opcion_id(){
		return acceso_opcion_id;
	}
	public String getacceso_opcion_string(){
		return acceso_opcion_string;
	}
	public Timestamp getacceso_fecha(){
		return acceso_fecha;
	}
}