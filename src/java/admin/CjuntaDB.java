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
public class CjuntaDB {

    public boolean Ingresar(int Xfr_id_zona, int Xcne_cod_junta, int Xnum_junta, String Xgenero, String Xjunta_nombre, int Xnum_electores_cne, int Xnum_votaron, int Xnum_no_votaron, int Xnum_total_votaron, boolean Xreceptada, String Xresponsable, String Xresponsable_telefono, int Xcod_recinto) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "insert into junta(fr_id_zona,cne_cod_junta,num_junta,genero,junta_nombre,num_electores_cne,num_votaron,num_no_votaron,num_total_votaron,receptada,responsable,responsable_telefono,cod_recinto)"
                    + "values( " + Xfr_id_zona + "," + Xcne_cod_junta + "," + Xnum_junta + ",'" + Xgenero + "','" + Xjunta_nombre + "'," + Xnum_electores_cne + "," + Xnum_votaron + "," + Xnum_no_votaron + "," + Xnum_total_votaron + "," + Xreceptada + ",'" + Xresponsable + "','" + Xresponsable_telefono + "'," + Xcod_recinto + ");";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean Actualizar(int Xidjunta, int Xfr_id_zona, int Xcne_cod_junta, int Xnum_junta, String Xgenero, String Xjunta_nombre, int Xnum_electores_cne, int Xnum_votaron, int Xnum_no_votaron, int Xnum_total_votaron, boolean Xreceptada, String Xresponsable, String Xresponsable_telefono, int Xcod_recinto) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update junta set  fr_id_zona=" + Xfr_id_zona + ", cne_cod_junta=" + Xcne_cod_junta + ", num_junta=" + Xnum_junta + ", genero='" + Xgenero + "', junta_nombre='" + Xjunta_nombre + "', num_electores_cne=" + Xnum_electores_cne + ", num_votaron=" + Xnum_votaron + ", num_no_votaron=" + Xnum_no_votaron + ", num_total_votaron=" + Xnum_total_votaron + ", receptada=" + Xreceptada + ", responsable='" + Xresponsable + "', responsable_telefono='" + Xresponsable_telefono + "', cod_recinto=" + Xcod_recinto + " "
                    + " where idjunta = " + Xidjunta + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public Cjunta Seleccionar_Id(int Xidjunta) {
        Cjunta OBJ = new Cjunta();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idjunta,fr_id_zona,zonas1.nombre_zona as zonas_string,cne_cod_junta,num_junta,genero,junta_nombre,num_electores_cne,num_votaron,num_no_votaron,num_total_votaron,receptada,responsable,responsable_telefono,cod_recinto"
                    + " from junta"
                    + " INNER JOIN zonas AS zonas1 ON junta.fr_id_zona = zonas1.idzonas "
                    + " where idjunta= " + Xidjunta + "; ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OBJ.setidjunta(rs.getInt("idjunta"));
                OBJ.setfr_id_zona(rs.getInt("fr_id_zona"));
                OBJ.setzonas_string(rs.getString("zonas_string"));
                OBJ.setcne_cod_junta(rs.getInt("cne_cod_junta"));
                OBJ.setnum_junta(rs.getInt("num_junta"));
                OBJ.setgenero(rs.getString("genero"));
                OBJ.setjunta_nombre(rs.getString("junta_nombre"));
                OBJ.setnum_electores_cne(rs.getInt("num_electores_cne"));
                OBJ.setnum_votaron(rs.getInt("num_votaron"));
                OBJ.setnum_no_votaron(rs.getInt("num_no_votaron"));
                OBJ.setnum_total_votaron(rs.getInt("num_total_votaron"));
                OBJ.setreceptada(rs.getBoolean("receptada"));
                OBJ.setresponsable(rs.getString("responsable"));
                OBJ.setresponsable_telefono(rs.getString("responsable_telefono"));
                OBJ.setcod_recinto(rs.getInt("cod_recinto"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OBJ;
    }

    public ArrayList<Cjunta> Cargar_Todos() {
        ArrayList<Cjunta> lista = new ArrayList<Cjunta>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idjunta,fr_id_zona,zonas1.nombre_zona as zonas_string,cne_cod_junta,num_junta,genero,junta_nombre,num_electores_cne,num_votaron,num_no_votaron,num_total_votaron,receptada,responsable,junta.responsable_telefono,recintos.cod_recinto,"
                    + " parroquias.nombre_parroquia,cantones.nombre_canton,recintos.nombre_recinto"
                    + " from junta"
                    + " INNER JOIN zonas AS zonas1 ON junta.fr_id_zona = zonas1.idzonas "
                    + " INNER JOIN parroquias AS parroquias ON parroquias.cod_parroquia = zonas1.cod_parroquia "
                    + " INNER JOIN cantones AS cantones ON cantones.cod_canton = parroquias.cod_canton "
                    + " LEFT JOIN recintos AS recintos ON recintos.cod_recinto = junta.cod_recinto ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cjunta OBJ = new Cjunta();
                OBJ.setidjunta(rs.getInt("idjunta"));
                OBJ.setfr_id_zona(rs.getInt("fr_id_zona"));
                OBJ.setCanton_string(rs.getString("nombre_canton"));
                OBJ.setParroquia_string(rs.getString("nombre_parroquia"));
                OBJ.setRecinto_string(rs.getString("nombre_recinto"));
                OBJ.setzonas_string(rs.getString("zonas_string"));
                OBJ.setcne_cod_junta(rs.getInt("cne_cod_junta"));
                OBJ.setnum_junta(rs.getInt("num_junta"));
                OBJ.setgenero(rs.getString("genero"));
                OBJ.setjunta_nombre(rs.getString("junta_nombre"));
                OBJ.setnum_electores_cne(rs.getInt("num_electores_cne"));
                OBJ.setnum_votaron(rs.getInt("num_votaron"));
                OBJ.setnum_no_votaron(rs.getInt("num_no_votaron"));
                OBJ.setnum_total_votaron(rs.getInt("num_total_votaron"));
                OBJ.setreceptada(rs.getBoolean("receptada"));
                OBJ.setresponsable(rs.getString("responsable"));
                OBJ.setresponsable_telefono(rs.getString("responsable_telefono"));
                OBJ.setcod_recinto(rs.getInt("cod_recinto"));
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

    public boolean Eliminar_Id(int Xidjunta) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = " delete from junta"
                    + " where idjunta=" + Xidjunta + ";";
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
