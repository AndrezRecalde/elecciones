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
public class parroquiasDB {
   public ArrayList<parroquias> CargarParroquiaCanton(int idcanton)
   {
        ArrayList<parroquias> lista = new ArrayList<parroquias>();
        Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select p.cod_parroquia,p.cod_canton,"
                 + " p.nombre_parroquia,p.estado_parroquia , c.nombre_canton"
                 + " from parroquias as p"
                 + " inner join cantones as c on c.cod_canton=p.cod_canton"
                 + " where p.cod_canton="+idcanton+";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            parroquias OBJ = new parroquias();
            OBJ.setCanton_nombre(rs.getString("nombre_canton"));
            OBJ.setCod_canton(rs.getInt("cod_canton"));
            OBJ.setCod_parroquia(rs.getInt("cod_parroquia"));
            OBJ.setEstado_parroquia(rs.getString("estado_parroquia"));
            OBJ.setNombre_parroquia(rs.getString("nombre_parroquia"));
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
    
   public parroquias CargarParroquiaId(int idparroquia)
   {
      parroquias OBJ = new parroquias();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select p.cod_parroquia,p.cod_canton,"
                 + " p.nombre_parroquia,p.estado_parroquia, c.nombre_canton"
                 + " from parroquias as p"
                 + " inner join cantones as c on c.cod_canton=p.cod_canton"
                 + " where p.cod_parroquia="+idparroquia+";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            OBJ.setCanton_nombre(rs.getString("nombre_canton"));
            OBJ.setCod_canton(rs.getInt("cod_canton"));
            OBJ.setCod_parroquia(rs.getInt("cod_parroquia"));
            OBJ.setEstado_parroquia(rs.getString("estado_parroquia"));
            OBJ.setNombre_parroquia(rs.getString("nombre_parroquia"));
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
}
