package admin;

import herramientas.conexion;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Generador V1.0
 */
public class CprovinciaDB{
public boolean Ingresar(String Xnombre_provincia,int Xnum_vot_hombres,int Xnum_vot_mujeres,boolean Xactiva) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "insert into provincia(nombre_provincia,num_vot_hombres,num_vot_mujeres,activa)"
            +"values( '"+ Xnombre_provincia+"',"+ Xnum_vot_hombres+","+ Xnum_vot_mujeres+","+ Xactiva+");";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }
public boolean Actualizar(int Xcne_cod_prov,String Xnombre_provincia,int Xnum_vot_hombres,int Xnum_vot_mujeres,boolean Xactiva) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update provincia set  nombre_provincia='"+ Xnombre_provincia+"', num_vot_hombres="+ Xnum_vot_hombres+", num_vot_mujeres="+ Xnum_vot_mujeres+", activa="+ Xactiva+" "
            +" where cne_cod_prov = " + Xcne_cod_prov+ ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }
 public Cprovincia Seleccionar_Id(int Xcne_cod_prov) {
        Cprovincia OBJ = new Cprovincia();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select cne_cod_prov,nombre_provincia,num_vot_hombres,num_vot_mujeres,activa"
                    + " from provincia"
                    + " where cne_cod_prov= "+ Xcne_cod_prov+ "; "; 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
		OBJ.setcne_cod_prov(rs.getInt("cne_cod_prov"));
		OBJ.setnombre_provincia (rs.getString("nombre_provincia"));
		OBJ.setnum_vot_hombres(rs.getInt("num_vot_hombres"));
		OBJ.setnum_vot_mujeres(rs.getInt("num_vot_mujeres"));
		OBJ.setactiva (rs.getBoolean("activa"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OBJ;
    }
 public ArrayList<Cprovincia> Cargar_Todos() {
        ArrayList<Cprovincia> lista = new ArrayList<Cprovincia>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select cne_cod_prov,nombre_provincia,num_vot_hombres,num_vot_mujeres,activa"
                    + " from provincia"
;            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
             Cprovincia OBJ = new Cprovincia();
		OBJ.setcne_cod_prov(rs.getInt("cne_cod_prov"));
		OBJ.setnombre_provincia (rs.getString("nombre_provincia"));
		OBJ.setnum_vot_hombres(rs.getInt("num_vot_hombres"));
		OBJ.setnum_vot_mujeres(rs.getInt("num_vot_mujeres"));
		OBJ.setactiva (rs.getBoolean("activa"));
             lista.add(OBJ);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
 public ArrayList<CObjetoCombo> Cargar_Combo() {
        ArrayList<CObjetoCombo> lista = new ArrayList<CObjetoCombo>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select cne_cod_prov,nombre_provincia"
                    + " from provincia"; 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
             CObjetoCombo OBJ = new CObjetoCombo();

		OBJ.setId(rs.getInt(1));
		OBJ.setValor(rs.getString(2));
             lista.add(OBJ);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
public boolean Eliminar_Id(int Xcne_cod_prov) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = " delete from provincia"
            +" where cne_cod_prov="+ Xcne_cod_prov+";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }
}