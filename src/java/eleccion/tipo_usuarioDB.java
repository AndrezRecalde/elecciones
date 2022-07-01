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
 * @author userver1
 */
public class tipo_usuarioDB {
    
    public tipo_usuario CargarxId(int idProv)
   {
      tipo_usuario OBJ = new tipo_usuario();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select * from tipo_usuario where idusuario="+idProv+";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            OBJ.setActivo(rs.getBoolean("activo"));
            OBJ.setIdtipo_usuario(rs.getInt("idtipo_usuario"));
            OBJ.setNombre_tipo_usuario(rs.getString("nombre_tipo_usuario"));
         }
         rs.close();
         st.close();
         con.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return OBJ;
   }
   
   
   public ArrayList<tipo_usuario> CargarActivas()
   {
        ArrayList<tipo_usuario> lista = new ArrayList<tipo_usuario>();
        Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select * from tipo_usuario where activo;";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            tipo_usuario OBJ = new tipo_usuario();
            OBJ.setActivo(rs.getBoolean("activo"));
            OBJ.setIdtipo_usuario(rs.getInt("idtipo_usuario"));
            OBJ.setNombre_tipo_usuario(rs.getString("nombre_tipo_usuario"));
            lista.add(OBJ);
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
   
}
