package admin;

import herramientas.conexion;
import java.sql.Timestamp;
import java.util.Date;
/**
 *
 * @author Generador V1.0
 */
public class Ccantones{
	private int cod_canton;
	private int cod_provincia;
	private String provincia_string;
	private String nombre_canton;
	private boolean tiene_circunscipciones;
	private int fr_id_canton_pertenece;
	public void setcod_canton(int cod_canton){
		this.cod_canton=cod_canton;
	}
	public void setcod_provincia(int cod_provincia){
		this.cod_provincia=cod_provincia;
	}
	public void setprovincia_string(String provincia_string){
		this.provincia_string=provincia_string;
	}
	public void setnombre_canton(String nombre_canton){
		this.nombre_canton=nombre_canton;
	}
	public void settiene_circunscipciones(boolean tiene_circunscipciones){
		this.tiene_circunscipciones=tiene_circunscipciones;
	}
	public void setfr_id_canton_pertenece(int fr_id_canton_pertenece){
		this.fr_id_canton_pertenece=fr_id_canton_pertenece;
	}
	public int getcod_canton(){
		return cod_canton;
	}
	public int getcod_provincia(){
		return cod_provincia;
	}
	public String getprovincia_string(){
		return provincia_string;
	}
	public String getnombre_canton(){
		return nombre_canton;
	}
	public boolean gettiene_circunscipciones(){
		return tiene_circunscipciones;
	}
	public int getfr_id_canton_pertenece(){
		return fr_id_canton_pertenece;
	}
}