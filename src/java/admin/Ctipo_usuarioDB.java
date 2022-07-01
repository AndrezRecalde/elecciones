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
public class Ctipo_usuarioDB {

    public boolean Ingresar(String Xnombre_tipo_usuario, boolean Xactivo) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "insert into tipo_usuario(nombre_tipo_usuario,activo)"
                    + "values( '" + Xnombre_tipo_usuario + "'," + Xactivo + ");";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean Actualizar(int Xidtipo_usuario, String Xnombre_tipo_usuario, boolean Xactivo) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update tipo_usuario set  nombre_tipo_usuario='" + Xnombre_tipo_usuario + "', activo=" + Xactivo + " "
                    + " where idtipo_usuario = " + Xidtipo_usuario + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public Ctipo_usuario Seleccionar_Id(int Xidtipo_usuario) {
        Ctipo_usuario OBJ = new Ctipo_usuario();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idtipo_usuario,nombre_tipo_usuario,activo"
                    + " from tipo_usuario"
                    + " where idtipo_usuario= " + Xidtipo_usuario + "; ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OBJ.setidtipo_usuario(rs.getInt("idtipo_usuario"));
                OBJ.setnombre_tipo_usuario(rs.getString("nombre_tipo_usuario"));
                OBJ.setactivo(rs.getBoolean("activo"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OBJ;
    }

    public ArrayList<Ctipo_usuario> Cargar_Todos() {
        ArrayList<Ctipo_usuario> lista = new ArrayList<Ctipo_usuario>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idtipo_usuario,nombre_tipo_usuario,activo"
                    + " from tipo_usuario";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Ctipo_usuario OBJ = new Ctipo_usuario();
                OBJ.setidtipo_usuario(rs.getInt("idtipo_usuario"));
                OBJ.setnombre_tipo_usuario(rs.getString("nombre_tipo_usuario"));
                OBJ.setactivo(rs.getBoolean("activo"));
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
            String sql = "select idtipo_usuario,nombre_tipo_usuario"
                    + " from tipo_usuario";
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

    public boolean Eliminar_Id(int Xidtipo_usuario) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = " delete from tipo_usuario"
                    + " where idtipo_usuario=" + Xidtipo_usuario + ";";
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
