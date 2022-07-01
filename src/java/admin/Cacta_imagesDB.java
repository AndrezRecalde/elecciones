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
public class Cacta_imagesDB {

    public int Ingresar(int Xacta_image_usu_ing, int Xacta_image_id_junta, int Xacta_image_id_dignidad, boolean Xacta_image_activa) {
        boolean exito = false;
        int id = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "insert into acta_images(acta_image_usu_ing,acta_image_id_junta,acta_image_id_dignidad,acta_image_activa)"
                    + "values( " + Xacta_image_usu_ing + "," + Xacta_image_id_junta + "," + Xacta_image_id_dignidad + "," + Xacta_image_activa + ");";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            if (exito) {
                ResultSet rs = st.executeQuery("select max(idacta_images) as id from acta_images");
                while (rs.next()) {
                    id= rs.getInt("id");
                }
                rs.close();
            }
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public boolean Actualizar(int Xidacta_images, int Xacta_image_usu_ing, int Xacta_image_id_junta, int Xacta_image_id_dignidad, boolean Xacta_image_activa) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update acta_images set  acta_image_usu_ing=" + Xacta_image_usu_ing + ", acta_image_id_junta=" + Xacta_image_id_junta + ", acta_image_id_dignidad=" + Xacta_image_id_dignidad + ", acta_image_activa=" + Xacta_image_activa + " "
                    + " where idacta_images = " + Xidacta_images + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }
    
    public boolean Actualizar(int Xidacta_images) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update acta_images set acta_image_activa=false "
                    + " where idacta_images = " + Xidacta_images + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public Cacta_images Seleccionar_Id(int Xidacta_images) {
        Cacta_images OBJ = new Cacta_images();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idacta_images,acta_image_usu_ing,usuario3.nombres as usuario_string,acta_image_id_junta,junta2.junta_nombre as junta_string,acta_image_id_dignidad,dignidad1.nombre_dignidad as dignidad_string,acta_image_activa,acta_image_fi,acta_image_um"
                    + " from acta_images"
                    + " INNER JOIN usuario AS usuario3 ON acta_images.acta_image_usu_ing = usuario3.idusuario "
                    + " INNER JOIN junta AS junta2 ON acta_images.acta_image_id_junta = junta2.idjunta "
                    + " INNER JOIN dignidad AS dignidad1 ON acta_images.acta_image_id_dignidad = dignidad1.iddignidad "
                    + " where idacta_images= " + Xidacta_images + "; ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OBJ.setidacta_images(rs.getInt("idacta_images"));
                OBJ.setacta_image_usu_ing(rs.getInt("acta_image_usu_ing"));
                OBJ.setusuario_string(rs.getString("usuario_string"));
                OBJ.setacta_image_id_junta(rs.getInt("acta_image_id_junta"));
                OBJ.setjunta_string(rs.getString("junta_string"));
                OBJ.setacta_image_id_dignidad(rs.getInt("acta_image_id_dignidad"));
                OBJ.setdignidad_string(rs.getString("dignidad_string"));
                OBJ.setacta_image_activa(rs.getBoolean("acta_image_activa"));
                OBJ.setacta_image_fi(rs.getTimestamp("acta_image_fi"));
                OBJ.setacta_image_um(rs.getTimestamp("acta_image_um"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OBJ;
    }

    public ArrayList<Cacta_images> Cargar_Todos() {
        ArrayList<Cacta_images> lista = new ArrayList<Cacta_images>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idacta_images,acta_image_usu_ing,usuario3.nombres as usuario_string,acta_image_id_junta,junta2.junta_nombre as junta_string,acta_image_id_dignidad,dignidad1.nombre_dignidad as dignidad_string,acta_image_activa,acta_image_fi,acta_image_um,"
                    + " zonas.nombre_zona,parroquias.nombre_parroquia,cantones.nombre_canton,recintos.nombre_recinto "
                    + " from acta_images INNER JOIN junta AS junta1 ON acta_images.acta_image_id_junta = junta1.idjunta  "
                    + "                      INNER JOIN zonas AS zonas ON junta1.fr_id_zona = zonas.idzonas  "
                    + "                      INNER JOIN parroquias AS parroquias ON parroquias.cod_parroquia = zonas.cod_parroquia  "
                    + "                      INNER JOIN cantones AS cantones ON cantones.cod_canton = parroquias.cod_canton  "
                    + " INNER JOIN recintos AS recintos ON recintos.cod_recinto = junta1.cod_recinto "
                    + " INNER JOIN usuario AS usuario3 ON acta_images.acta_image_usu_ing = usuario3.idusuario "
                    + " INNER JOIN junta AS junta2 ON acta_images.acta_image_id_junta = junta2.idjunta "
                    + " INNER JOIN dignidad AS dignidad1 ON acta_images.acta_image_id_dignidad = dignidad1.iddignidad ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cacta_images OBJ = new Cacta_images();
                OBJ.setidacta_images(rs.getInt("idacta_images"));
                OBJ.setacta_image_usu_ing(rs.getInt("acta_image_usu_ing"));
                OBJ.setusuario_string(rs.getString("usuario_string"));
                
                OBJ.setCanton_string(rs.getString("nombre_canton"));
                OBJ.setZona_string(rs.getString("nombre_zona"));
                OBJ.setParroquia_string(rs.getString("nombre_parroquia"));
                OBJ.setRecinto_string(rs.getString("nombre_recinto"));
                
                OBJ.setacta_image_id_junta(rs.getInt("acta_image_id_junta"));
                OBJ.setjunta_string(rs.getString("junta_string"));
                OBJ.setacta_image_id_dignidad(rs.getInt("acta_image_id_dignidad"));
                OBJ.setdignidad_string(rs.getString("dignidad_string"));
                OBJ.setacta_image_activa(rs.getBoolean("acta_image_activa"));
                OBJ.setacta_image_fi(rs.getTimestamp("acta_image_fi"));
                OBJ.setacta_image_um(rs.getTimestamp("acta_image_um"));
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

    public ArrayList<Cacta_images> Cargar_Activas(int id_junta, int id_dignidad) {
        ArrayList<Cacta_images> lista = new ArrayList<Cacta_images>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select idacta_images,acta_image_usu_ing,usuario3.nombres as usuario_string,acta_image_id_junta,junta2.junta_nombre as junta_string,acta_image_id_dignidad,dignidad1.nombre_dignidad as dignidad_string,acta_image_activa,acta_image_fi,acta_image_um"
                    + " from acta_images"
                    + " INNER JOIN usuario AS usuario3 ON acta_images.acta_image_usu_ing = usuario3.idusuario "
                    + " INNER JOIN junta AS junta2 ON acta_images.acta_image_id_junta = junta2.idjunta "
                    + " INNER JOIN dignidad AS dignidad1 ON acta_images.acta_image_id_dignidad = dignidad1.iddignidad "
                    + " WHERE acta_image_id_junta=" + id_junta + " and acta_image_id_dignidad=" + id_dignidad + " and acta_image_activa";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cacta_images OBJ = new Cacta_images();
                OBJ.setidacta_images(rs.getInt("idacta_images"));
                OBJ.setacta_image_usu_ing(rs.getInt("acta_image_usu_ing"));
                OBJ.setusuario_string(rs.getString("usuario_string"));
                OBJ.setacta_image_id_junta(rs.getInt("acta_image_id_junta"));
                OBJ.setjunta_string(rs.getString("junta_string"));
                OBJ.setacta_image_id_dignidad(rs.getInt("acta_image_id_dignidad"));
                OBJ.setdignidad_string(rs.getString("dignidad_string"));
                OBJ.setacta_image_activa(rs.getBoolean("acta_image_activa"));
                OBJ.setacta_image_fi(rs.getTimestamp("acta_image_fi"));
                OBJ.setacta_image_um(rs.getTimestamp("acta_image_um"));
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
            String sql = "select idacta_images,idacta_images"
                    + " from acta_images";
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

    public boolean Eliminar_Id(int Xidacta_images) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = " delete from acta_images"
                    + " where idacta_images=" + Xidacta_images + ";";
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
