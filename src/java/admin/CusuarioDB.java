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
public class CusuarioDB {

    public boolean Ingresar(String Xnombres, String Xusuario, int Xfr_id_provincia, String Xprovincia_nombre, int Xfr_id_tipo_usuario, boolean Xes_provincial, int Xfr_id_canton, boolean Xes_cantonal, String Xtipo_usu_nombre, String Xclave, boolean Xactivo) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "insert into usuario(nombres,usuario,fr_id_provincia,provincia_nombre,fr_id_tipo_usuario,es_provincial,fr_id_canton,es_cantonal,tipo_usu_nombre,login,clave,activo)"
                    + "values( '" + Xnombres + "','" + Xusuario + "'," + Xfr_id_provincia + ",'" + Xprovincia_nombre + "'," + Xfr_id_tipo_usuario + "," + Xes_provincial + "," + Xfr_id_canton + "," + Xes_cantonal + ",'" + Xtipo_usu_nombre + "',md5('" + Xusuario + "'),md5('" + Xclave + "')," + Xactivo + ");";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean Actualizar(int Xidusuario, String Xnombres, String Xusuario, int Xfr_id_provincia, String Xprovincia_nombre, int Xfr_id_tipo_usuario, boolean Xes_provincial, int Xfr_id_canton, boolean Xes_cantonal, String Xtipo_usu_nombre, String Xlogin, String Xclave, boolean Xactivo) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update usuario set  nombres='" + Xnombres + "', usuario='" + Xusuario + "', fr_id_provincia=" + Xfr_id_provincia + ", provincia_nombre='" + Xprovincia_nombre + "', fr_id_tipo_usuario=" + Xfr_id_tipo_usuario + ", es_provincial=" + Xes_provincial + ", fr_id_canton=" + Xfr_id_canton + ", es_cantonal=" + Xes_cantonal + ", tipo_usu_nombre='" + Xtipo_usu_nombre + "', login='" + Xlogin + "', clave='" + Xclave + "', activo=" + Xactivo + " "
                    + " where idusuario = " + Xidusuario + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean Actualizar(int Xidusuario, String Xnombres, String Xusuario, int Xfr_id_provincia, String Xprovincia_nombre, int Xfr_id_tipo_usuario, boolean Xes_provincial, int Xfr_id_canton, boolean Xes_cantonal, String Xtipo_usu_nombre, String Xclave, boolean Xactivo) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update usuario set  nombres='" + Xnombres + "', usuario='" + Xusuario + "', fr_id_provincia=" + Xfr_id_provincia + ", provincia_nombre='" + Xprovincia_nombre + "', fr_id_tipo_usuario=" + Xfr_id_tipo_usuario + ", es_provincial=" + Xes_provincial + ", fr_id_canton=" + Xfr_id_canton + ", es_cantonal=" + Xes_cantonal + ", tipo_usu_nombre='" + Xtipo_usu_nombre + "', login=md5('" + Xusuario + "'), clave=md5('" + Xclave + "'), activo=" + Xactivo + " "
                    + " where idusuario = " + Xidusuario + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean Actualizar(int Xidusuario, String Xnombres, String Xusuario, int Xfr_id_provincia, String Xprovincia_nombre, int Xfr_id_tipo_usuario, boolean Xes_provincial, int Xfr_id_canton, boolean Xes_cantonal, String Xtipo_usu_nombre, boolean Xactivo) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update usuario set  nombres='" + Xnombres + "', usuario='" + Xusuario + "', fr_id_provincia=" + Xfr_id_provincia + ", provincia_nombre='" + Xprovincia_nombre + "', fr_id_tipo_usuario=" + Xfr_id_tipo_usuario + ", es_provincial=" + Xes_provincial + ", fr_id_canton=" + Xfr_id_canton + ", es_cantonal=" + Xes_cantonal + ", tipo_usu_nombre='" + Xtipo_usu_nombre + "', login=md5('" + Xusuario + "'), activo=" + Xactivo + " "
                    + " where idusuario = " + Xidusuario + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean Actualizar(int Xidusuario, String Clave) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update usuario set clave=md5('" + Clave + "') "
                    + " where idusuario = " + Xidusuario + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public Cusuario Seleccionar_Id(int Xidusuario) {
        Cusuario OBJ = new Cusuario();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idusuario,nombres,usuario,fr_id_provincia,provincia2.nombre_provincia as provincia_string,provincia_nombre,fr_id_tipo_usuario,es_provincial,fr_id_canton,cantones1.nombre_canton as cantones_string,es_cantonal,tipo_usu_nombre,tipo_usuario3.nombre_tipo_usuario as tipo_usuario_string,login,clave,usuario.activo,usu_ui,usu_fi,usu_um,cantones1.fr_id_canton_pertenece as id_padre"
                    + " from usuario"
                    + " INNER JOIN provincia AS provincia2 ON usuario.fr_id_provincia = provincia2.cne_cod_prov "
                    + " INNER JOIN cantones AS cantones1 ON usuario.fr_id_canton = cantones1.cod_canton "
                    + " INNER JOIN tipo_usuario AS tipo_usuario3 ON usuario.fr_id_tipo_usuario = tipo_usuario3.idtipo_usuario "
                    + " where idusuario= " + Xidusuario + "; ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OBJ.setidusuario(rs.getInt("idusuario"));
                OBJ.setnombres(rs.getString("nombres"));
                OBJ.setusuario(rs.getString("usuario"));
                OBJ.setfr_id_provincia(rs.getInt("fr_id_provincia"));
                OBJ.setprovincia_string(rs.getString("provincia_string"));
                OBJ.setprovincia_nombre(rs.getString("provincia_nombre"));
                OBJ.setfr_id_tipo_usuario(rs.getInt("fr_id_tipo_usuario"));
                OBJ.setes_provincial(rs.getBoolean("es_provincial"));
                OBJ.setfr_id_canton(rs.getInt("fr_id_canton"));
                OBJ.setFr_id_canton_padre(rs.getInt("id_padre"));
                OBJ.setcantones_string(rs.getString("cantones_string"));
                OBJ.setes_cantonal(rs.getBoolean("es_cantonal"));
                OBJ.settipo_usu_nombre(rs.getString("tipo_usu_nombre"));
                OBJ.settipo_usuario_string(rs.getString("tipo_usuario_string"));
                OBJ.setlogin(rs.getString("login"));
                OBJ.setclave(rs.getString("clave"));
                OBJ.setactivo(rs.getBoolean("activo"));
                OBJ.setusu_ui(rs.getTimestamp("usu_ui"));
                OBJ.setusu_fi(rs.getTimestamp("usu_fi"));
                OBJ.setusu_um(rs.getTimestamp("usu_um"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OBJ;
    }

    public ArrayList<Cusuario> Cargar_Todos() {
        ArrayList<Cusuario> lista = new ArrayList<Cusuario>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idusuario,nombres,usuario,fr_id_provincia,provincia2.nombre_provincia as provincia_string,provincia_nombre,fr_id_tipo_usuario,es_provincial,fr_id_canton,cantones1.nombre_canton as cantones_string,es_cantonal,tipo_usu_nombre,tipo_usuario3.nombre_tipo_usuario as tipo_usuario_string,login,clave,usuario.activo,usu_ui,usu_fi,usu_um"
                    + " from usuario"
                    + " INNER JOIN provincia AS provincia2 ON usuario.fr_id_provincia = provincia2.cne_cod_prov "
                    + " INNER JOIN cantones AS cantones1 ON usuario.fr_id_canton = cantones1.cod_canton "
                    + " INNER JOIN tipo_usuario AS tipo_usuario3 ON usuario.fr_id_tipo_usuario = tipo_usuario3.idtipo_usuario ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cusuario OBJ = new Cusuario();
                OBJ.setidusuario(rs.getInt("idusuario"));
                OBJ.setnombres(rs.getString("nombres"));
                OBJ.setusuario(rs.getString("usuario"));
                OBJ.setfr_id_provincia(rs.getInt("fr_id_provincia"));
                OBJ.setprovincia_string(rs.getString("provincia_string"));
                OBJ.setprovincia_nombre(rs.getString("provincia_nombre"));
                OBJ.setfr_id_tipo_usuario(rs.getInt("fr_id_tipo_usuario"));
                OBJ.setes_provincial(rs.getBoolean("es_provincial"));
                OBJ.setfr_id_canton(rs.getInt("fr_id_canton"));
                OBJ.setcantones_string(rs.getString("cantones_string"));
                OBJ.setes_cantonal(rs.getBoolean("es_cantonal"));
                OBJ.settipo_usu_nombre(rs.getString("tipo_usu_nombre"));
                OBJ.settipo_usuario_string(rs.getString("tipo_usuario_string"));
                OBJ.setlogin(rs.getString("login"));
                OBJ.setclave(rs.getString("clave"));
                OBJ.setactivo(rs.getBoolean("activo"));
                OBJ.setusu_ui(rs.getTimestamp("usu_ui"));
                OBJ.setusu_fi(rs.getTimestamp("usu_fi"));
                OBJ.setusu_um(rs.getTimestamp("usu_um"));
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
            String sql = "select idusuario,nombres"
                    + " from usuario";
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

    public boolean Eliminar_Id(int Xidusuario) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = " delete from usuario"
                    + " where idusuario=" + Xidusuario + ";";
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
