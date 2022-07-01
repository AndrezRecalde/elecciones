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
public class recintosDB {
    
    public recintos CargarRecintoId(int cod_recinto)
   {
        recintos OBJ = new recintos();
        Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select r.cod_recinto,r.cod_parroquia,r.nombre_recinto,"
                 + " r.direccion_recinto,r.cod_zona,r.num_jun_mas,r.num_jun_fem,r.num_juntas,"
                 + " r.jun_ini_f,r.jun_fin_f,r.jun_ini_m,r.jun_fin_m, p.nombre_parroquia"
                 + " from recintos as r"
                 + " inner join parroquias as p on p.cod_parroquia=r.cod_parroquia"
                 + " where r.cod_recinto="+cod_recinto+";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            OBJ.setCod_parroquia(rs.getInt("cod_parroquia"));
            OBJ.setCod_recinto(rs.getInt("cod_recinto"));
            OBJ.setCod_zona(rs.getInt("cod_zona"));
            OBJ.setDireccion_recinto(rs.getString("direccion_recinto"));
            OBJ.setJun_fin_f(rs.getInt("jun_fin_f"));
            OBJ.setJun_fin_m(rs.getInt("jun_fin_m"));
            OBJ.setJun_ini_f(rs.getInt("jun_ini_f"));
            OBJ.setJun_ini_m(rs.getInt("jun_ini_m"));
            OBJ.setNombre_recinto(rs.getString("nombre_recinto"));
            OBJ.setNum_jun_fem(rs.getInt("num_jun_fem"));
            OBJ.setNum_jun_mas(rs.getInt("num_jun_mas"));
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
    
   public ArrayList<recintos> CargarRecintoParroquia(int idparroquia)
   {
        ArrayList<recintos> lista = new ArrayList<recintos>();
        Connection con = null;
      try
      {
         con= conexion.getConexion();
         String sql="select r.cod_recinto,r.cod_parroquia,r.nombre_recinto,"
                 + " r.direccion_recinto,r.cod_zona,r.num_jun_mas,r.num_jun_fem,r.num_juntas,"
                 + " r.jun_ini_f,r.jun_fin_f,r.jun_ini_m,r.jun_fin_m, p.nombre_parroquia"
                 + " from recintos as r"
                 + " inner join parroquias as p on p.cod_parroquia=r.cod_parroquia"
                 + " where r.cod_parroquia="+idparroquia+";";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next())
         {
            recintos OBJ = new recintos();
            OBJ.setCod_parroquia(rs.getInt("cod_parroquia"));
            OBJ.setCod_recinto(rs.getInt("cod_recinto"));
            OBJ.setCod_zona(rs.getInt("cod_zona"));
            OBJ.setDireccion_recinto(rs.getString("direccion_recinto"));
            OBJ.setJun_fin_f(rs.getInt("jun_fin_f"));
            OBJ.setJun_fin_m(rs.getInt("jun_fin_m"));
            OBJ.setJun_ini_f(rs.getInt("jun_ini_f"));
            OBJ.setJun_ini_m(rs.getInt("jun_ini_m"));
            OBJ.setNombre_recinto(rs.getString("nombre_recinto"));
            OBJ.setNum_jun_fem(rs.getInt("num_jun_fem"));
            OBJ.setNum_jun_mas(rs.getInt("num_jun_mas"));
            OBJ.setNum_juntas(rs.getInt("num_juntas"));
            OBJ.setParroquia_nombre(rs.getString("nombre_parroquia"));
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
