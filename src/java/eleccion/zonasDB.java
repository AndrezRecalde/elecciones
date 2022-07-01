/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eleccion;

import herramientas.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author root
 */
public class zonasDB {
   
   public zonas CargarxId(int cod_zona, int cod_parroquia)
   {
      zonas OBJ = new zonas();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select z.idzonas,z.cod_parroquia,z.nombre_zona,z.est_parroquia, "
                 + " z.cod_zona,z.num_elec_zona,z.num_elec_hombres_zona,z.num_elec_mujeres_zona,"
                 + " z.num_juntas,z.num_junta_hombre,z.num_junta_mujeres,z.num_elec_zona_max,p.nombre_parroquia from zonas "
                 + " as z inner join parroquias as p on p.cod_parroquia=z.cod_parroquia where cod_zona="+  cod_zona 
                 + " and z.cod_parroquia="+ cod_parroquia +";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            OBJ.setCod_parroquia(rs.getInt("cod_parroquia"));
            OBJ.setCod_zona(rs.getInt("cod_zona"));
            OBJ.setEst_parroquia(rs.getString("est_parroquia"));
            OBJ.setIdzonas(rs.getInt("idzonas"));
            OBJ.setNombre_zona(rs.getString("nombre_zona"));
            OBJ.setNum_elec_hombres_zona(rs.getInt("num_elec_hombres_zona"));
            OBJ.setNum_elec_mujeres_zona(rs.getInt("num_elec_mujeres_zona"));
            OBJ.setNum_elec_zona(rs.getInt("num_elec_zona"));
            OBJ.setNum_elec_zona_max(rs.getInt("num_elec_zona_max"));
            OBJ.setNum_junta_hombre(rs.getInt("num_junta_hombre"));
            OBJ.setNum_junta_mujeres(rs.getInt("num_junta_mujeres"));
            OBJ.setNum_juntas(rs.getInt("num_juntas"));
            OBJ.setParroquia_nombre(rs.getString("nombre_parroquia"));
            
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
