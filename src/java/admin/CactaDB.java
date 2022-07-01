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
public class CactaDB {

    public boolean Ingresar(int Xcod_provincia, int Xcod_canton, int Xcod_parroquia, int Xcod_zona, int Xfr_id_junta, int Xfr_id_dignidad, int Xcne_cod_acta, int Xnum_validos, int Xnum_no_voto, int Xnum_blancos, int Xnum_nulos, int Xacta_usu_ing, int Xacta_usu_mod, boolean Xcuadrada, boolean Xlegible, int Xfr_id_acta_estado) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "insert into acta(cod_provincia,cod_canton,cod_parroquia,cod_zona,fr_id_junta,fr_id_dignidad,cne_cod_acta,num_validos,num_no_voto,num_blancos,num_nulos,acta_usu_ing,acta_usu_mod,cuadrada,legible,fr_id_acta_estado)"
                    + "values( " + Xcod_provincia + "," + Xcod_canton + "," + Xcod_parroquia + "," + Xcod_zona + "," + Xfr_id_junta + "," + Xfr_id_dignidad + "," + Xcne_cod_acta + "," + Xnum_validos + "," + Xnum_no_voto + "," + Xnum_blancos + "," + Xnum_nulos + "," + Xacta_usu_ing + "," + Xacta_usu_mod + "," + Xcuadrada + "," + Xlegible + "," + Xfr_id_acta_estado + ");";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean Actualizar(int Xidacta, int Xcod_provincia, int Xcod_canton, int Xcod_parroquia, int Xcod_zona, int Xfr_id_junta, int Xfr_id_dignidad, int Xcne_cod_acta, int Xnum_validos, int Xnum_no_voto, int Xnum_blancos, int Xnum_nulos, int Xacta_usu_ing, int Xacta_usu_mod, boolean Xcuadrada, boolean Xlegible, int Xfr_id_acta_estado) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update acta set  cod_provincia=" + Xcod_provincia + ", cod_canton=" + Xcod_canton + ", cod_parroquia=" + Xcod_parroquia + ", cod_zona=" + Xcod_zona + ", fr_id_junta=" + Xfr_id_junta + ", fr_id_dignidad=" + Xfr_id_dignidad + ", cne_cod_acta=" + Xcne_cod_acta + ", num_validos=" + Xnum_validos + ", num_no_voto=" + Xnum_no_voto + ", num_blancos=" + Xnum_blancos + ", num_nulos=" + Xnum_nulos + ", acta_usu_ing=" + Xacta_usu_ing + ", acta_usu_mod=" + Xacta_usu_mod + ", cuadrada=" + Xcuadrada + ", legible=" + Xlegible + ", fr_id_acta_estado=" + Xfr_id_acta_estado + " "
                    + " where idacta = " + Xidacta + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public Cacta Seleccionar_Id(int Xidacta) {
        Cacta OBJ = new Cacta();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idacta,cod_provincia,cod_canton,cod_parroquia,cod_zona,fr_id_junta,junta1.cne_cod_junta as junta_string,fr_id_dignidad,cne_cod_acta,num_validos,num_no_voto,num_blancos,num_nulos,acta_usu_ing,acta_usu_mod,acta_fi,acta_um,cuadrada,legible,fr_id_acta_estado"
                    + " from acta"
                    + " INNER JOIN junta AS junta1 ON acta.fr_id_junta = junta1.idjunta "
                    + " where idacta= " + Xidacta + "; ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OBJ.setidacta(rs.getInt("idacta"));
                OBJ.setcod_provincia(rs.getInt("cod_provincia"));
                OBJ.setcod_canton(rs.getInt("cod_canton"));
                OBJ.setcod_parroquia(rs.getInt("cod_parroquia"));
                OBJ.setcod_zona(rs.getInt("cod_zona"));
                OBJ.setfr_id_junta(rs.getInt("fr_id_junta"));
                OBJ.setjunta_string(rs.getString("junta_string"));
                OBJ.setfr_id_dignidad(rs.getInt("fr_id_dignidad"));
                OBJ.setcne_cod_acta(rs.getInt("cne_cod_acta"));
                OBJ.setnum_validos(rs.getInt("num_validos"));
                OBJ.setnum_no_voto(rs.getInt("num_no_voto"));
                OBJ.setnum_blancos(rs.getInt("num_blancos"));
                OBJ.setnum_nulos(rs.getInt("num_nulos"));
                OBJ.setacta_usu_ing(rs.getInt("acta_usu_ing"));
                OBJ.setacta_usu_mod(rs.getInt("acta_usu_mod"));
                OBJ.setacta_fi(rs.getTimestamp("acta_fi"));
                OBJ.setacta_um(rs.getTimestamp("acta_um"));
                OBJ.setcuadrada(rs.getBoolean("cuadrada"));
                OBJ.setlegible(rs.getBoolean("legible"));
                OBJ.setfr_id_acta_estado(rs.getInt("fr_id_acta_estado"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OBJ;
    }

    public ArrayList<Cacta> Cargar_Todos() {
        ArrayList<Cacta> lista = new ArrayList<Cacta>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idacta,acta.cod_provincia,acta.cod_canton,acta.cod_parroquia,acta.cod_zona,fr_id_junta,junta1.junta_nombre as junta_string,fr_id_dignidad,cne_cod_acta,num_validos,num_no_voto,num_blancos,num_nulos,acta_usu_ing,acta_usu_mod,acta_fi,acta_um,cuadrada,legible,fr_id_acta_estado, "
                    + "                      dignidad.nombre_dignidad,zonas.nombre_zona,parroquias.nombre_parroquia,cantones.nombre_canton,recintos.nombre_recinto,usuario.nombres "
                    + "                      from acta "
                    + "                      INNER JOIN dignidad AS dignidad ON dignidad.iddignidad = acta.fr_id_dignidad  "
                    + "                      INNER JOIN junta AS junta1 ON acta.fr_id_junta = junta1.idjunta  "
                    + "                      INNER JOIN zonas AS zonas ON junta1.fr_id_zona = zonas.idzonas  "
                    + "                      INNER JOIN parroquias AS parroquias ON parroquias.cod_parroquia = zonas.cod_parroquia  "
                    + "                      INNER JOIN cantones AS cantones ON cantones.cod_canton = parroquias.cod_canton  "
                    + "                      INNER JOIN usuario AS usuario ON usuario.idusuario = acta.acta_usu_ing  "
                    + "                      LEFT JOIN recintos AS recintos ON recintos.cod_recinto = junta1.cod_recinto";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cacta OBJ = new Cacta();
                OBJ.setidacta(rs.getInt("idacta"));
                OBJ.setcod_provincia(rs.getInt("cod_provincia"));
                OBJ.setcod_canton(rs.getInt("cod_canton"));
                OBJ.setcod_parroquia(rs.getInt("cod_parroquia"));
                OBJ.setcod_zona(rs.getInt("cod_zona"));
                OBJ.setfr_id_junta(rs.getInt("fr_id_junta"));
                OBJ.setjunta_string(rs.getString("junta_string"));
                OBJ.setfr_id_dignidad(rs.getInt("fr_id_dignidad"));
                OBJ.setcne_cod_acta(rs.getInt("cne_cod_acta"));
                OBJ.setnum_validos(rs.getInt("num_validos"));
                OBJ.setnum_no_voto(rs.getInt("num_no_voto"));
                OBJ.setnum_blancos(rs.getInt("num_blancos"));
                OBJ.setnum_nulos(rs.getInt("num_nulos"));
                OBJ.setacta_usu_ing(rs.getInt("acta_usu_ing"));
                OBJ.setacta_usu_mod(rs.getInt("acta_usu_mod"));
                OBJ.setacta_fi(rs.getTimestamp("acta_fi"));
                OBJ.setacta_um(rs.getTimestamp("acta_um"));
                OBJ.setcuadrada(rs.getBoolean("cuadrada"));
                OBJ.setlegible(rs.getBoolean("legible"));
                OBJ.setfr_id_acta_estado(rs.getInt("fr_id_acta_estado"));
                OBJ.setCanton_string(rs.getString("nombre_canton"));
                OBJ.setParroquia_string(rs.getString("nombre_parroquia"));
                OBJ.setRecinto_string(rs.getString("nombre_recinto"));
                OBJ.setZonas_string(rs.getString("nombre_zona"));
                OBJ.setDignidad_string(rs.getString("nombre_dignidad"));
                OBJ.setActa_usu_ing_string(rs.getString("nombres"));
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

    public ArrayList<Cacta> Cargar_Todos_Inconsistentes() {
        ArrayList<Cacta> lista = new ArrayList<Cacta>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idacta,acta.cod_provincia,acta.cod_canton,acta.cod_parroquia,acta.cod_zona,fr_id_junta,junta1.junta_nombre as junta_string,fr_id_dignidad,cne_cod_acta,num_validos,num_no_voto,num_blancos,num_nulos,acta_usu_ing,acta_usu_mod,acta_fi,acta_um,cuadrada,legible,fr_id_acta_estado, "
                    + "                      dignidad.nombre_dignidad,zonas.nombre_zona,parroquias.nombre_parroquia,cantones.nombre_canton,recintos.nombre_recinto,usuario.nombres "
                    + "                      from acta "
                    + "                      INNER JOIN dignidad AS dignidad ON dignidad.iddignidad = acta.fr_id_dignidad  "
                    + "                      INNER JOIN junta AS junta1 ON acta.fr_id_junta = junta1.idjunta  "
                    + "                      INNER JOIN zonas AS zonas ON junta1.fr_id_zona = zonas.idzonas  "
                    + "                      INNER JOIN parroquias AS parroquias ON parroquias.cod_parroquia = zonas.cod_parroquia  "
                    + "                      INNER JOIN cantones AS cantones ON cantones.cod_canton = parroquias.cod_canton  "
                    + "                      INNER JOIN usuario AS usuario ON usuario.idusuario = acta.acta_usu_ing  "
                    + "                      LEFT JOIN recintos AS recintos ON recintos.cod_recinto = junta1.cod_recinto  "
                    + "                      Where not cuadrada or not legible";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cacta OBJ = new Cacta();
                OBJ.setidacta(rs.getInt("idacta"));
                OBJ.setcod_provincia(rs.getInt("cod_provincia"));
                OBJ.setcod_canton(rs.getInt("cod_canton"));
                OBJ.setcod_parroquia(rs.getInt("cod_parroquia"));
                OBJ.setcod_zona(rs.getInt("cod_zona"));
                OBJ.setfr_id_junta(rs.getInt("fr_id_junta"));
                OBJ.setjunta_string(rs.getString("junta_string"));
                OBJ.setfr_id_dignidad(rs.getInt("fr_id_dignidad"));
                OBJ.setcne_cod_acta(rs.getInt("cne_cod_acta"));
                OBJ.setnum_validos(rs.getInt("num_validos"));
                OBJ.setnum_no_voto(rs.getInt("num_no_voto"));
                OBJ.setnum_blancos(rs.getInt("num_blancos"));
                OBJ.setnum_nulos(rs.getInt("num_nulos"));
                OBJ.setacta_usu_ing(rs.getInt("acta_usu_ing"));
                OBJ.setacta_usu_mod(rs.getInt("acta_usu_mod"));
                OBJ.setacta_fi(rs.getTimestamp("acta_fi"));
                OBJ.setacta_um(rs.getTimestamp("acta_um"));
                OBJ.setcuadrada(rs.getBoolean("cuadrada"));
                OBJ.setlegible(rs.getBoolean("legible"));
                OBJ.setfr_id_acta_estado(rs.getInt("fr_id_acta_estado"));
                OBJ.setCanton_string(rs.getString("nombre_canton"));
                OBJ.setParroquia_string(rs.getString("nombre_parroquia"));
                OBJ.setRecinto_string(rs.getString("nombre_recinto"));
                OBJ.setZonas_string(rs.getString("nombre_zona"));
                OBJ.setDignidad_string(rs.getString("nombre_dignidad"));
                OBJ.setActa_usu_ing_string(rs.getString("nombres"));
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

    public boolean Eliminar_Id(int Xidacta) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = " delete from acta"
                    + " where idacta=" + Xidacta + ";";
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
