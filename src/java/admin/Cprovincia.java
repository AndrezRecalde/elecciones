package admin;

import herramientas.conexion;
import java.sql.Timestamp;
import java.util.Date;
/**
 *
 * @author Generador V1.0
 */
public class Cprovincia{
	private int cne_cod_prov;
	private String nombre_provincia;
	private int num_vot_hombres;
	private int num_vot_mujeres;
	private boolean activa;
	public void setcne_cod_prov(int cne_cod_prov){
		this.cne_cod_prov=cne_cod_prov;
	}
	public void setnombre_provincia(String nombre_provincia){
		this.nombre_provincia=nombre_provincia;
	}
	public void setnum_vot_hombres(int num_vot_hombres){
		this.num_vot_hombres=num_vot_hombres;
	}
	public void setnum_vot_mujeres(int num_vot_mujeres){
		this.num_vot_mujeres=num_vot_mujeres;
	}
	public void setactiva(boolean activa){
		this.activa=activa;
	}
	public int getcne_cod_prov(){
		return cne_cod_prov;
	}
	public String getnombre_provincia(){
		return nombre_provincia;
	}
	public int getnum_vot_hombres(){
		return num_vot_hombres;
	}
	public int getnum_vot_mujeres(){
		return num_vot_mujeres;
	}
	public boolean getactiva(){
		return activa;
	}
}