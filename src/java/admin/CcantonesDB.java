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
public class CcantonesDB {

    public boolean Ingresar(int Xcod_provincia, String Xnombre_canton, boolean Xtiene_circunscipciones, int Xfr_id_canton_pertenece) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "insert into cantones(cod_provincia,nombre_canton,tiene_circunscipciones,fr_id_canton_pertenece)"
                    + "values( " + Xcod_provincia + ",'" + Xnombre_canton + "'," + Xtiene_circunscipciones + "," + Xfr_id_canton_pertenece + ");";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean Actualizar(int Xcod_canton, int Xcod_provincia, String Xnombre_canton, boolean Xtiene_circunscipciones, int Xfr_id_canton_pertenece) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update cantones set  cod_provincia=" + Xcod_provincia + ", nombre_canton='" + Xnombre_canton + "', tiene_circunscipciones=" + Xtiene_circunscipciones + ", fr_id_canton_pertenece=" + Xfr_id_canton_pertenece + " "
                    + " where cod_canton = " + Xcod_canton + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public Ccantones Seleccionar_Id(int Xcod_canton) {
        Ccantones OBJ = new Ccantones();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select cod_canton,cod_provincia,provincia1.nombre_provincia as provincia_string,nombre_canton,tiene_circunscipciones,fr_id_canton_pertenece"
                    + " from cantones"
                    + " INNER JOIN provincia AS provincia1 ON cantones.cod_provincia = provincia1.cne_cod_prov "
                    + " where cod_canton= " + Xcod_canton + "; ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OBJ.setcod_canton(rs.getInt("cod_canton"));
                OBJ.setcod_provincia(rs.getInt("cod_provincia"));
                OBJ.setprovincia_string(rs.getString("provincia_string"));
                OBJ.setnombre_canton(rs.getString("nombre_canton"));
                OBJ.settiene_circunscipciones(rs.getBoolean("tiene_circunscipciones"));
                OBJ.setfr_id_canton_pertenece(rs.getInt("fr_id_canton_pertenece"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OBJ;
    }

    public ArrayList<Ccantones> Cargar_Todos() {
        ArrayList<Ccantones> lista = new ArrayList<Ccantones>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select cod_canton,cod_provincia,provincia1.nombre_provincia as provincia_string,nombre_canton,tiene_circunscipciones,fr_id_canton_pertenece"
                    + " from cantones"
                    + " INNER JOIN provincia AS provincia1 ON cantones.cod_provincia = provincia1.cne_cod_prov ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Ccantones OBJ = new Ccantones();
                OBJ.setcod_canton(rs.getInt("cod_canton"));
                OBJ.setcod_provincia(rs.getInt("cod_provincia"));
                OBJ.setprovincia_string(rs.getString("provincia_string"));
                OBJ.setnombre_canton(rs.getString("nombre_canton"));
                OBJ.settiene_circunscipciones(rs.getBoolean("tiene_circunscipciones"));
                OBJ.setfr_id_canton_pertenece(rs.getInt("fr_id_canton_pertenece"));
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
            String sql = "select cod_canton,nombre_canton"
                    + " from cantones";
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

    public boolean Eliminar_Id(int Xcod_canton) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = " delete from cantones"
                    + " where cod_canton=" + Xcod_canton + ";";
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
