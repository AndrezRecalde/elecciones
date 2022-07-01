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
public class candidatoDB {
    
    public ArrayList <candidato> CargarxDignidad(int dignidad)
    {
      ArrayList<candidato> lista = new ArrayList<candidato>();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="SELECT c.idcandidato,c.fr_id_organizacion,c.nombre,c.fr_id_dignidad,"
                 + " c.imagen,c.activo,c.es_provincial,c.fr_id_provincia,o.nombre_organizacion,o.lista,"
                 + " p.nombre_provincia,d.nombre_dignidad from candidato as c"
                 + " inner join organizacion as o on o.idorganizacion=c.fr_id_organizacion"
                 + " inner join dignidad as d on d.iddignidad=c.fr_id_dignidad"
                 + " left join provincia as p on p.cne_cod_prov=c.fr_id_provincia"
                 + " where c.fr_id_dignidad="+dignidad+""
                 + " order by o.orden,c.can_orden;";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            candidato OBJ = new candidato();
            OBJ.setActivo(rs.getBoolean("activo"));
            OBJ.setDignidad_nombre(rs.getString("nombre_dignidad"));
            OBJ.setEs_provincial(rs.getBoolean("es_provincial"));
            OBJ.setFr_id_dignidad(rs.getInt("fr_id_dignidad"));
            OBJ.setFr_id_organizacion(rs.getInt("fr_id_organizacion"));
            OBJ.setFr_id_provincia(rs.getInt("fr_id_provincia"));
            OBJ.setIdcandidato(rs.getInt("idcandidato"));
            OBJ.setImagen(rs.getString("imagen"));
            OBJ.setNombre(rs.getString("nombre"));
            OBJ.setOrganizacion_lista(rs.getString("lista"));
            OBJ.setOrganizacion_nombre(rs.getString("nombre_organizacion"));
            OBJ.setProvincia_nombre(rs.getString("nombre_provincia"));
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
    
    public ArrayList <candidato> CargarxDignidadProvincial(int dignidad,int provincia)
    {
      ArrayList<candidato> lista = new ArrayList<candidato>();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="SELECT c.es_cantonal, c.fr_id_canton, c.es_parroquial, c.fr_id_parroquia,c.idcandidato,c.fr_id_organizacion,c.nombre,c.fr_id_dignidad,"
                 + " c.imagen,c.activo,c.es_provincial,c.fr_id_provincia,o.nombre_organizacion,o.lista,"
                 + " p.nombre_provincia,d.nombre_dignidad from candidato as c"
                 + " inner join organizacion as o on o.idorganizacion=c.fr_id_organizacion"
                 + " inner join dignidad as d on d.iddignidad=c.fr_id_dignidad"
                 + " left join provincia as p on p.cne_cod_prov=c.fr_id_provincia"
                 + " where c.fr_id_dignidad="+dignidad+" and c.es_provincial and c.fr_id_provincia="+provincia
                 + " order by o.orden,c.can_orden;";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            candidato OBJ = new candidato();
            OBJ.setActivo(rs.getBoolean("activo"));
            OBJ.setDignidad_nombre(rs.getString("nombre_dignidad"));
            OBJ.setEs_provincial(rs.getBoolean("es_provincial"));
            OBJ.setFr_id_dignidad(rs.getInt("fr_id_dignidad"));
            OBJ.setFr_id_organizacion(rs.getInt("fr_id_organizacion"));
            OBJ.setFr_id_provincia(rs.getInt("fr_id_provincia"));
            OBJ.setIdcandidato(rs.getInt("idcandidato"));
            OBJ.setImagen(rs.getString("imagen"));
            OBJ.setNombre(rs.getString("nombre"));
            OBJ.setOrganizacion_lista(rs.getString("lista"));
            OBJ.setOrganizacion_nombre(rs.getString("nombre_organizacion"));
            OBJ.setProvincia_nombre(rs.getString("nombre_provincia"));
            OBJ.setEs_cantonal(rs.getBoolean("es_cantonal"));
            OBJ.setEs_parroquial(rs.getBoolean("es_parroquial"));
            OBJ.setFr_id_canton(rs.getInt("fr_id_canton"));
            OBJ.setFr_id_parroquia(rs.getInt("fr_id_parroquia"));
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
    public ArrayList <candidato> CargarxDignidadCantonal(int dignidad,int idcanton)
    {
      ArrayList<candidato> lista = new ArrayList<candidato>();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="SELECT c.es_cantonal, c.fr_id_canton, c.es_parroquial, c.fr_id_parroquia,c.idcandidato,c.fr_id_organizacion,c.nombre,c.fr_id_dignidad,"
                 + " c.imagen,c.activo,c.es_provincial,c.fr_id_provincia,o.nombre_organizacion,o.lista,"
                 + " p.nombre_canton as nombre_provincia,d.nombre_dignidad from candidato as c"
                 + " inner join organizacion as o on o.idorganizacion=c.fr_id_organizacion"
                 + " inner join dignidad as d on d.iddignidad=c.fr_id_dignidad"
                 + " left join cantones as p on p.cod_canton=c.fr_id_canton"
                 + " where c.fr_id_dignidad="+dignidad+" and c.es_cantonal and c.fr_id_canton="+idcanton+""
                 + " order by o.orden,c.can_orden;";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            candidato OBJ = new candidato();
            OBJ.setActivo(rs.getBoolean("activo"));
            OBJ.setDignidad_nombre(rs.getString("nombre_dignidad"));
            OBJ.setEs_provincial(rs.getBoolean("es_provincial"));
            OBJ.setFr_id_dignidad(rs.getInt("fr_id_dignidad"));
            OBJ.setFr_id_organizacion(rs.getInt("fr_id_organizacion"));
            OBJ.setFr_id_provincia(rs.getInt("fr_id_provincia"));
            OBJ.setIdcandidato(rs.getInt("idcandidato"));
            OBJ.setImagen(rs.getString("imagen"));
            OBJ.setNombre(rs.getString("nombre"));
            OBJ.setOrganizacion_lista(rs.getString("lista"));
            OBJ.setOrganizacion_nombre(rs.getString("nombre_organizacion"));
            OBJ.setProvincia_nombre(rs.getString("nombre_provincia"));
            OBJ.setEs_cantonal(rs.getBoolean("es_cantonal"));
            OBJ.setEs_parroquial(rs.getBoolean("es_parroquial"));
            OBJ.setFr_id_canton(rs.getInt("fr_id_canton"));
            OBJ.setFr_id_parroquia(rs.getInt("fr_id_parroquia"));
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
    
    public ArrayList <candidato> CargarxDignidadParroquia(int dignidad,int idparroquia)
    {
      ArrayList<candidato> lista = new ArrayList<candidato>();
      Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="SELECT c.es_cantonal, c.fr_id_canton, c.es_parroquial, c.fr_id_parroquia,c.idcandidato,c.fr_id_organizacion,c.nombre,c.fr_id_dignidad,"
                 + " c.imagen,c.activo,c.es_provincial,c.fr_id_provincia,o.nombre_organizacion,o.lista,"
                 + " pa.nombre_parroquia as nombre_provincia,d.nombre_dignidad from candidato as c"
                 + " inner join organizacion as o on o.idorganizacion=c.fr_id_organizacion"
                 + " inner join dignidad as d on d.iddignidad=c.fr_id_dignidad"
                 + " left join parroquias as pa on pa.cod_parroquia=c.fr_id_parroquia"
                 + " where c.fr_id_dignidad="+dignidad+" and c.es_parroquial and c.fr_id_parroquia="+idparroquia+""
                 + " order by o.orden,c.can_orden;";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            candidato OBJ = new candidato();
            OBJ.setActivo(rs.getBoolean("activo"));
            OBJ.setDignidad_nombre(rs.getString("nombre_dignidad"));
            OBJ.setEs_provincial(rs.getBoolean("es_provincial"));
            OBJ.setFr_id_dignidad(rs.getInt("fr_id_dignidad"));
            OBJ.setFr_id_organizacion(rs.getInt("fr_id_organizacion"));
            OBJ.setFr_id_provincia(rs.getInt("fr_id_provincia"));
            OBJ.setIdcandidato(rs.getInt("idcandidato"));
            OBJ.setImagen(rs.getString("imagen"));
            OBJ.setNombre(rs.getString("nombre"));
            OBJ.setOrganizacion_lista(rs.getString("lista"));
            OBJ.setOrganizacion_nombre(rs.getString("nombre_organizacion"));
            OBJ.setProvincia_nombre(rs.getString("nombre_provincia"));
            OBJ.setEs_cantonal(rs.getBoolean("es_cantonal"));
            OBJ.setEs_parroquial(rs.getBoolean("es_parroquial"));
            OBJ.setFr_id_canton(rs.getInt("fr_id_canton"));
            OBJ.setFr_id_parroquia(rs.getInt("fr_id_parroquia"));
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
