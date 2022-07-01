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
public class CaccesosDB {

    public boolean Ingresar(int Xusuario_id, int Xacceso_opcion_id) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "insert into accesos(usuario_id,acceso_opcion_id)"
                    + "values( " + Xusuario_id + "," + Xacceso_opcion_id + ");";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean Actualizar(int Xidaccesos, int Xusuario_id, int Xacceso_opcion_id) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update accesos set  usuario_id=" + Xusuario_id + ", acceso_opcion_id=" + Xacceso_opcion_id + " "
                    + " where idaccesos = " + Xidaccesos + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public Caccesos Seleccionar_Id(int Xidaccesos) {
        Caccesos OBJ = new Caccesos();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idaccesos,usuario_id,usuario2.nombres as usuario_string,acceso_opcion_id,acceso_opcion1.acceso_opcion_nombre as acceso_opcion_string,acceso_fecha"
                    + " from accesos"
                    + " INNER JOIN usuario AS usuario2 ON accesos.usuario_id = usuario2.idusuario "
                    + " INNER JOIN acceso_opcion AS acceso_opcion1 ON accesos.acceso_opcion_id = acceso_opcion1.idacceso_opcion "
                    + " where idaccesos= " + Xidaccesos + "; ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OBJ.setidaccesos(rs.getInt("idaccesos"));
                OBJ.setusuario_id(rs.getInt("usuario_id"));
                OBJ.setusuario_string(rs.getString("usuario_string"));
                OBJ.setacceso_opcion_id(rs.getInt("acceso_opcion_id"));
                OBJ.setacceso_opcion_string(rs.getString("acceso_opcion_string"));
                OBJ.setacceso_fecha(rs.getTimestamp("acceso_fecha"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OBJ;
    }

    public ArrayList<Caccesos> Cargar_Todos() {
        ArrayList<Caccesos> lista = new ArrayList<Caccesos>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idaccesos,usuario_id,usuario2.nombres as usuario_string,acceso_opcion_id,acceso_opcion1.acceso_opcion_nombre as acceso_opcion_string,acceso_fecha"
                    + " from accesos"
                    + " INNER JOIN usuario AS usuario2 ON accesos.usuario_id = usuario2.idusuario "
                    + " INNER JOIN acceso_opcion AS acceso_opcion1 ON accesos.acceso_opcion_id = acceso_opcion1.idacceso_opcion ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Caccesos OBJ = new Caccesos();
                OBJ.setidaccesos(rs.getInt("idaccesos"));
                OBJ.setusuario_id(rs.getInt("usuario_id"));
                OBJ.setusuario_string(rs.getString("usuario_string"));
                OBJ.setacceso_opcion_id(rs.getInt("acceso_opcion_id"));
                OBJ.setacceso_opcion_string(rs.getString("acceso_opcion_string"));
                OBJ.setacceso_fecha(rs.getTimestamp("acceso_fecha"));
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
    
     public ArrayList<Caccesos> Cargar_Todos(int usuario_id) {
        ArrayList<Caccesos> lista = new ArrayList<Caccesos>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idaccesos,usuario_id,usuario2.nombres as usuario_string,acceso_opcion_id,acceso_opcion1.acceso_opcion_nombre as acceso_opcion_string,acceso_fecha"
                    + " from accesos"
                    + " INNER JOIN usuario AS usuario2 ON accesos.usuario_id = usuario2.idusuario "
                    + " INNER JOIN acceso_opcion AS acceso_opcion1 ON accesos.acceso_opcion_id = acceso_opcion1.idacceso_opcion "
                    + " WHERE usuario_id="+usuario_id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Caccesos OBJ = new Caccesos();
                OBJ.setidaccesos(rs.getInt("idaccesos"));
                OBJ.setusuario_id(rs.getInt("usuario_id"));
                OBJ.setusuario_string(rs.getString("usuario_string"));
                OBJ.setacceso_opcion_id(rs.getInt("acceso_opcion_id"));
                OBJ.setacceso_opcion_string(rs.getString("acceso_opcion_string"));
                OBJ.setacceso_fecha(rs.getTimestamp("acceso_fecha"));
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
            String sql = "select idaccesos,idaccesos"
                    + " from accesos";
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

    public boolean Eliminar_Id(int Xidaccesos) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = " delete from accesos"
                    + " where idaccesos=" + Xidaccesos + ";";
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
