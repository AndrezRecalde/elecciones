/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

/**
 *
 * @author USUARIO
 */

import herramientas.conexion;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class usuarioDB {
    
   public boolean isCorrecto(String usuario, String password,int cne_cod_prov)
   {
      boolean correcta=false;
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         Statement st = con.createStatement();
         String sql="select count(*)>0 from usuario where login='"+usuario+"' and clave='"+password+"' and fr_id_provincia="+cne_cod_prov+" and activo;";
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            correcta = rs.getBoolean(1);
         }
         rs.close();
         st.close();
         con.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return correcta;
   }

   public boolean existe(String usuario)
   {
      boolean correcta=false;
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         Statement st = con.createStatement();
         String sql="select count(*)>0 from usuario where usuario='"+usuario+"';";
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            correcta = rs.getBoolean(1);
         }
         rs.close();
         st.close();
         con.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return correcta;
   }
   
   public ArrayList<usuario> CargarxProvincias(int idProv)
   {
      ArrayList<usuario> lista = new ArrayList<usuario>();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select * from usuario as u inner join provincia as p on "
                 + "p.cne_cod_prov=u.fr_id_provincia "
                 + " inner join tipo_usuario as tu on tu.idtipo_usuario=u.fr_id_tipo_usuario"
                 + " where fr_id_provincia="+idProv+";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            usuario USU = new usuario();
            USU.setActivo(rs.getBoolean("activo"));
            USU.setClave(rs.getString("clave"));
            USU.setFr_id_provincia(rs.getInt("fr_id_provincia"));
            USU.setProvincia_nombre(rs.getString("nombre_provincia"));
            USU.setFr_id_tipo_usuario(rs.getInt("fr_id_tipo_usuario"));
            USU.setTipo_usu_nombre(rs.getString("nombre_tipo_usuario"));
            USU.setIdusuario(rs.getInt("idusuario"));
            USU.setNombres(rs.getString("nombres"));
            USU.setUsu_fi(rs.getTimestamp("usu_fi"));
            USU.setUsu_ui(rs.getTimestamp("usu_ui"));
            USU.setUsu_um(rs.getTimestamp("usu_um"));
            USU.setUsuario(rs.getString("usuario"));
            USU.setLogin(rs.getString("login"));
            lista.add(USU);
            
         }
         rs.close();
         st.close();
         con.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return lista;
   }
   
   public usuario CargarxId(int idUsu)
   {
      usuario USU = new usuario();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select * from usuario as u inner join provincia as p on "
                 + "p.cne_cod_prov=u.fr_id_provincia "
                 + " inner join tipo_usuario as tu on tu.idtipo_usuario=u.fr_id_tipo_usuario"
                 + " where idusuario="+idUsu+";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            USU.setActivo(rs.getBoolean("activo"));
            USU.setClave(rs.getString("clave"));
            USU.setFr_id_provincia(rs.getInt("fr_id_provincia"));
            USU.setProvincia_nombre(rs.getString("nombre_provincia"));
            USU.setFr_id_tipo_usuario(rs.getInt("fr_id_tipo_usuario"));
            USU.setTipo_usu_nombre(rs.getString("nombre_tipo_usuario"));
            USU.setIdusuario(rs.getInt("idusuario"));
            USU.setNombres(rs.getString("nombres"));
            USU.setUsu_fi(rs.getTimestamp("usu_fi"));
            USU.setUsu_ui(rs.getTimestamp("usu_ui"));
            USU.setUsu_um(rs.getTimestamp("usu_um"));
            USU.setUsuario(rs.getString("usuario"));
            USU.setLogin(rs.getString("login"));
         }
         rs.close();
         st.close();
         con.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return USU;
   }
   
   
   public usuario CargarUsuario(String usuario)
   {
      usuario USU = new usuario();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select * from usuario as u inner join provincia as p on "
                 + " p.cne_cod_prov=u.fr_id_provincia "
                 + " inner join tipo_usuario as tu on tu.idtipo_usuario=u.fr_id_tipo_usuario"
                 + " where login='"+usuario+"';";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            USU.setActivo(rs.getBoolean("activo"));
            USU.setClave(rs.getString("clave"));
            USU.setFr_id_provincia(rs.getInt("fr_id_provincia"));
            USU.setProvincia_nombre(rs.getString("nombre_provincia"));
            USU.setFr_id_tipo_usuario(rs.getInt("fr_id_tipo_usuario"));
            USU.setTipo_usu_nombre(rs.getString("nombre_tipo_usuario"));
            USU.setIdusuario(rs.getInt("idusuario"));
            USU.setNombres(rs.getString("nombres"));
            USU.setUsu_fi(rs.getTimestamp("usu_fi"));
            USU.setUsu_ui(rs.getTimestamp("usu_ui"));
            USU.setUsu_um(rs.getTimestamp("usu_um"));
            USU.setUsuario(rs.getString("usuario"));
            USU.setLogin(rs.getString("login"));
         }
         rs.close();
         st.close();
         con.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return USU;
   }
   
   public boolean ActualizaUltimoAcceso(int idusuario)
   {
      boolean correcta=false;
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         Statement st = con.createStatement();
         String sql="UPDATE usuario SET usu_ui=now() "
                 + " where idusuario="+idusuario+";";
         correcta = st.executeUpdate(sql) == 1 ? true : false;
         st.close();
         con.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return correcta;
   }
   
}
