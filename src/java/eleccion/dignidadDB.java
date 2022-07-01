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
public class dignidadDB {
    
    public ArrayList <dignidad> CargarActivas()
    {
      ArrayList<dignidad> lista = new ArrayList<dignidad>();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select d.iddignidad,d.nombre_dignidad,d.activo,d.es_provincial,d.fr_id_id_provincia,"
                 + " d.fr_id_eleccion,d.num_candidato_lista,p.nombre_provincia,e.nombre_eleccion"
                 + " from dignidad as d"
                 + " inner join eleccion as e on e.ideleccion=d.fr_id_eleccion"
                 + " left join provincia as p on p.cne_cod_prov=d.fr_id_id_provincia"
                 + " where d.activo;";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            dignidad OBJ = new dignidad();
            OBJ.setActivo(rs.getBoolean("activo"));
            OBJ.setEleccion_nombre(rs.getString("nombre_eleccion"));
            OBJ.setEs_provincial(rs.getBoolean("es_provincial"));
            OBJ.setFr_id_eleccion(rs.getInt("fr_id_eleccion"));
            OBJ.setFr_id_id_provincia(rs.getInt("fr_id_id_provincia"));
            OBJ.setIddignidad(rs.getInt("idcandidato"));
            OBJ.setNombre_dignidad(rs.getString("nombre_dignidad"));
            OBJ.setNum_candidato_lista(rs.getInt("num_candidato_lista"));
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
