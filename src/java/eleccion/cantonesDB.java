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
public class cantonesDB {
    public ArrayList<cantones> CargarCantonesProvincia(int idprovincia)
   {
        ArrayList<cantones> lista = new ArrayList<cantones>();
        Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select c.cod_canton,c.cod_provincia,c.nombre_canton,"
                 + " p.nombre_provincia from cantones as c"
                 + " inner join provincia as p on p.cne_cod_prov=c.cod_provincia"
                 + " where c.cod_provincia="+idprovincia+";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            cantones OBJ = new cantones();
            OBJ.setCod_canton(rs.getInt("cod_canton"));
            OBJ.setCod_provincia(rs.getInt("cod_provincia"));
            OBJ.setNombre_canton(rs.getString("nombre_canton"));
            OBJ.setProvincia_nombre(rs.getString("provincia_nombre"));
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
    
    public cantones CargarCantonId(int idcanton)
   {
        cantones OBJ = new cantones();
        Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select c.cod_canton,c.cod_provincia,c.nombre_canton,"
                 + " p.nombre_provincia from cantones as c"
                 + " inner join provincia as p on p.cne_cod_prov=c.cod_provincia"
                 + " where c.cod_canton="+idcanton+";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            OBJ.setCod_canton(rs.getInt("cod_canton"));
            OBJ.setCod_provincia(rs.getInt("cod_provincia"));
            OBJ.setNombre_canton(rs.getString("nombre_canton"));
            OBJ.setProvincia_nombre(rs.getString("nombre_provincia"));
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
    
    
    public int CargarIdCantonPadre(int IdCircunscripcion)
   {
        int id=IdCircunscripcion;
        Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select c.cod_canton,c.cod_provincia,c.nombre_canton,"
                 + " p.nombre_provincia,c.tiene_circunscipciones,c.fr_id_canton_pertenece"
                 + " from cantones as c"
                 + " inner join provincia as p on p.cne_cod_prov=c.cod_provincia"
                 + " where c.cod_canton="+IdCircunscripcion+";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            if(rs.getInt("fr_id_canton_pertenece")!=0){
                id=rs.getInt("fr_id_canton_pertenece");
            }
         }
         rs.close();
         st.close();
         con.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return id;
   }
}
