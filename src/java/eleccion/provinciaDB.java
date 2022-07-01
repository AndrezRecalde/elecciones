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
public class provinciaDB {
    
   public provincia CargarxId(int idProv)
   {
      provincia OBJ = new provincia();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select * from provincia where cne_cod_prov="+idProv+";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            OBJ.setActiva(rs.getBoolean("activa"));
            OBJ.setCne_cod_prov(rs.getInt("cne_cod_prov"));
            OBJ.setNombre_provincia(rs.getString("nombre_provincia"));
            OBJ.setNum_vot_hombres(rs.getInt("num_vot_hombres"));
            OBJ.setNum_vot_mujeres(rs.getInt("num_vot_mujeres"));
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
   
   
   public ArrayList<provincia> CargarActivas()
   {
        ArrayList<provincia> lista = new ArrayList<provincia>();
        Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select * from provincia where activa;";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            provincia OBJ = new provincia();
            OBJ.setActiva(rs.getBoolean("activa"));
            OBJ.setCne_cod_prov(rs.getInt("cne_cod_prov"));
            OBJ.setNombre_provincia(rs.getString("nombre_provincia"));
            OBJ.setNum_vot_hombres(rs.getInt("num_vot_hombres"));
            OBJ.setNum_vot_mujeres(rs.getInt("num_vot_mujeres"));
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
