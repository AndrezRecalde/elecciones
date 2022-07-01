package admin;

import herramientas.conexion;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Generador V1.0
 */
public class CrecintosDB {

    public boolean Ingresar() {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "insert into recintos()"
                    + "values( );";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean Actualizar(int Xcod_recinto, String Xresponsable_ci, String Xresponsable_nombres, String Xresponsable_telefono) {
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update recintos set  responsable_ci='" + Xresponsable_ci + "', responsable_nombres='" + Xresponsable_nombres + "', responsable_telefono='" + Xresponsable_telefono + "' "
                    + " where cod_recinto = " + Xcod_recinto + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public Crecintos Seleccionar_Id(int Xcod_recinto) {
        Crecintos OBJ = new Crecintos();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select cod_recinto,cod_parroquia,parroquia_nombre,nombre_recinto,direccion_recinto,cod_zona,num_jun_mas,num_jun_fem,num_juntas,responsable_ci,responsable_nombres,responsable_telefono,jun_ini_f,jun_fin_f,jun_ini_m,jun_fin_m"
                    + " from recintos"
                    + " where cod_recinto= " + Xcod_recinto + "; ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OBJ.setcod_recinto(rs.getInt("cod_recinto"));
                OBJ.setcod_parroquia(rs.getInt("cod_parroquia"));
                OBJ.setparroquia_nombre(rs.getString("parroquia_nombre"));
                OBJ.setnombre_recinto(rs.getString("nombre_recinto"));
                OBJ.setdireccion_recinto(rs.getString("direccion_recinto"));
                OBJ.setcod_zona(rs.getInt("cod_zona"));
                OBJ.setnum_jun_mas(rs.getInt("num_jun_mas"));
                OBJ.setnum_jun_fem(rs.getInt("num_jun_fem"));
                OBJ.setnum_juntas(rs.getInt("num_juntas"));
                OBJ.setresponsable_ci(rs.getString("responsable_ci"));
                OBJ.setresponsable_nombres(rs.getString("responsable_nombres"));
                OBJ.setresponsable_telefono(rs.getString("responsable_telefono"));
                OBJ.setjun_ini_f(rs.getInt("jun_ini_f"));
                OBJ.setjun_fin_f(rs.getInt("jun_fin_f"));
                OBJ.setjun_ini_m(rs.getInt("jun_ini_m"));
                OBJ.setjun_fin_m(rs.getInt("jun_fin_m"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OBJ;
    }

    public ArrayList<Crecintos> Cargar_Todos() {
        ArrayList<Crecintos> lista = new ArrayList<Crecintos>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select cod_recinto,recintos.cod_parroquia,recintos.parroquia_nombre,nombre_recinto,direccion_recinto,cod_zona,num_jun_mas,num_jun_fem,recintos.num_juntas,responsable_ci,responsable_nombres,responsable_telefono,recintos.jun_ini_f,recintos.jun_fin_f,recintos.jun_ini_m,recintos.jun_fin_m"
                    + " ,zonas.nombre_zona,cantones.cod_canton,cantones.nombre_canton from recintos"
                    + "     INNER JOIN zonas AS zonas ON recintos.cod_zona = zonas.idzonas  "
                    + "     INNER JOIN parroquias AS parroquias ON parroquias.cod_parroquia = zonas.cod_parroquia  "
                    + "     INNER JOIN cantones AS cantones ON cantones.cod_canton = parroquias.cod_canton ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Crecintos OBJ = new Crecintos();
                OBJ.setcod_recinto(rs.getInt("cod_recinto"));
                OBJ.setcod_parroquia(rs.getInt("cod_parroquia"));
                OBJ.setparroquia_nombre(rs.getString("parroquia_nombre"));
                
                OBJ.setCod_canton(rs.getInt("cod_canton"));
                OBJ.setNombre_canton(rs.getString("nombre_canton"));
                
                OBJ.setnombre_recinto(rs.getString("nombre_recinto"));
                OBJ.setdireccion_recinto(rs.getString("direccion_recinto"));
                OBJ.setcod_zona(rs.getInt("cod_zona"));
                OBJ.setnum_jun_mas(rs.getInt("num_jun_mas"));
                OBJ.setnum_jun_fem(rs.getInt("num_jun_fem"));
                OBJ.setnum_juntas(rs.getInt("num_juntas"));
                OBJ.setresponsable_ci(rs.getString("responsable_ci"));
                OBJ.setresponsable_nombres(rs.getString("responsable_nombres"));
                OBJ.setresponsable_telefono(rs.getString("responsable_telefono"));
                OBJ.setjun_ini_f(rs.getInt("jun_ini_f"));
                OBJ.setjun_fin_f(rs.getInt("jun_fin_f"));
                OBJ.setjun_ini_m(rs.getInt("jun_ini_m"));
                OBJ.setjun_fin_m(rs.getInt("jun_fin_m"));
                lista.add(OBJ);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public ArrayList<CObjetoCombo> Cargar_Combo() {
        ArrayList<CObjetoCombo> lista = new ArrayList<CObjetoCombo>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select cod_recinto,nombre_recinto"
                    + " from recintos";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                CObjetoCombo OBJ = new CObjetoCombo();

                OBJ.setId(rs.getInt(1));
                OBJ.setValor(rs.getString(2));
                lista.add(OBJ);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean Eliminar_Id(int Xcod_recinto) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = " delete from recintos"
                    + " where cod_recinto=" + Xcod_recinto + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }
}
