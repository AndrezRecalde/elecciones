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
public class acta_detalleDB {
    
   public acta_detalle CargarActaDetalleId(int idactadetalle)
   {
      acta_detalle OBJ = new acta_detalle();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select idacta_detalle,fr_id_acta,fr_id_candidato,"
                 + " num_votos_letras,num_votos,act_det_fi,act_det_um,"
                 + " poco_legible, c.nombre,o.nombre_organizacion,o.lista FROM acta_detalle as a"
                 + " inner join candidato as c on a.fr_id_candidato=c.idcandidato"
                 + " inner join organizacion as o on c.fr_id_organizacion=o.idorganizacion "
                 + " where a.idacta_detalle="+idactadetalle+";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            OBJ.setAct_det_fi(rs.getTimestamp("act_det_fi"));
            OBJ.setAct_det_um(rs.getTimestamp("act_det_um"));
            OBJ.setCandidato_nombre(rs.getString("nombre"));
            OBJ.setFr_id_acta(rs.getInt("fr_id_acta"));
            OBJ.setFr_id_candidato(rs.getInt("fr_id_candidato"));
            OBJ.setIdacta_detalle(rs.getInt("idacta_detalle"));
            OBJ.setNum_votos(rs.getInt("num_votos"));
            OBJ.setNum_votos_letras(rs.getString("num_votos_letras"));
            OBJ.setPoco_legible(rs.getBoolean("poco_legible"));
            OBJ.setOrganizacion_nombre(rs.getString("nombre_organizacion"));
            OBJ.setLista_nombre(rs.getString("lista"));
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
   
   public ArrayList <acta_detalle> CargarActasDetalleIdActa(int idacta)
   {
      ArrayList<acta_detalle> lista = new ArrayList<acta_detalle>();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select idacta_detalle,fr_id_acta,fr_id_candidato,"
                 + " num_votos_letras,num_votos,act_det_fi,act_det_um,"
                 + " poco_legible, c.nombre,o.nombre_organizacion,o.lista,c.imagen,o.idorganizacion as idorganizacion FROM acta_detalle as a"
                 + " inner join candidato as c on a.fr_id_candidato=c.idcandidato"
                 + " inner join organizacion as o on c.fr_id_organizacion=o.idorganizacion "
                 + " where a.fr_id_acta="+idacta+";";
         Statement st = con.createStatement();
         System.out.println(sql);
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            acta_detalle OBJ = new acta_detalle();
            OBJ.setAct_det_fi(rs.getTimestamp("act_det_fi"));
            OBJ.setAct_det_um(rs.getTimestamp("act_det_um"));
            OBJ.setCandidato_nombre(rs.getString("nombre"));
            OBJ.setFr_id_organizacion(rs.getInt("idorganizacion"));
            OBJ.setImagen(rs.getString("imagen"));
            OBJ.setFr_id_acta(rs.getInt("fr_id_acta"));
            OBJ.setFr_id_candidato(rs.getInt("fr_id_candidato"));
            OBJ.setIdacta_detalle(rs.getInt("idacta_detalle"));
            OBJ.setNum_votos(rs.getInt("num_votos"));
            OBJ.setNum_votos_letras(rs.getString("num_votos_letras"));
            OBJ.setPoco_legible(rs.getBoolean("poco_legible"));
            OBJ.setOrganizacion_nombre(rs.getString("nombre_organizacion"));
            OBJ.setLista_nombre(rs.getString("lista"));
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
   
   public boolean CalificarActaCandidato(int idacta,int idcandidato, int calificacion)
   {
      boolean exito=false;
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="insert into acta_detalle(fr_id_acta,fr_id_candidato,num_votos)"
                 + "values("+idacta+" , "+idcandidato+" , "+calificacion+");";
         Statement st = con.createStatement();
         exito = st.executeUpdate(sql) == 1 ? true : false;
         st.close();
         con.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return exito;
   }
}
