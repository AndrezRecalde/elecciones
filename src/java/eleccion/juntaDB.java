/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

import herramientas.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class juntaDB {
    
    public junta CargarJuntaxId(int id) {
        junta OBJ = new junta();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select * from junta as j inner join recintos as r on r.cod_recinto=j.cod_recinto where j.idjunta=" + id + " ;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OBJ.setReceptada(rs.getBoolean("receptada"));
                OBJ.setIdjunta(rs.getInt("idjunta"));
                OBJ.setCne_cod_junta(rs.getInt("cne_cod_junta"));
                OBJ.setFr_id_recinto(rs.getInt("cod_recinto"));
                OBJ.setGenero(rs.getString("genero"));
                OBJ.setNum_electores_cne(rs.getInt("num_electores_cne"));
                OBJ.setNum_junta(rs.getInt("num_junta"));
                OBJ.setNum_no_votaron(rs.getInt("num_no_votaron"));
                OBJ.setNum_total_votaron(rs.getInt("num_total_votaron"));
                OBJ.setNum_votaron(rs.getInt("num_votaron"));
                OBJ.setJunta_nombre(OBJ.getNum_junta() + " " + OBJ.getGenero());
                OBJ.setResponsable(rs.getString("responsable"));
                OBJ.setResponsable_telefono(rs.getString("responsable_telefono"));
                OBJ.setRecinto_nombre(rs.getString("nombre_recinto"));
                OBJ.setCedula(rs.getString("responsable_cedula"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OBJ;
    }
    
    public ArrayList<junta> CargarxRecinto(int idrecinto) {
        ArrayList<junta> lista = new ArrayList<junta>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select * from junta where fr_id_recinto= " + idrecinto + ";";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                junta OBJ = new junta();
                OBJ.setReceptada(rs.getBoolean("receptada"));
                OBJ.setIdjunta(rs.getInt("idjunta"));
                OBJ.setCne_cod_junta(rs.getInt("cne_cod_junta"));
                OBJ.setFr_id_recinto(rs.getInt("cod_recinto"));
                OBJ.setGenero(rs.getString("genero"));
                OBJ.setNum_electores_cne(rs.getInt("num_electores_cne"));
                OBJ.setNum_junta(rs.getInt("num_junta"));
                OBJ.setNum_no_votaron(rs.getInt("num_no_votaron"));
                OBJ.setNum_total_votaron(rs.getInt("num_total_votaron"));
                OBJ.setNum_votaron(rs.getInt("num_votaron"));
                OBJ.setJunta_nombre(OBJ.getNum_junta() + " " + OBJ.getGenero());
                OBJ.setResponsable(rs.getString("responsable"));
                OBJ.setResponsable_telefono(rs.getString("responsable_telefono"));
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
    public boolean ActualizarResponsables(int idacta, String Nombre, String Telefono,String cedula) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update junta set responsable='" + Nombre + "', responsable_telefono='" + Telefono + "',responsable_cedula='"+cedula+"' where idjunta=" + idacta + ";";
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
