/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package herramientas;

/**
 *
 * @author Administrador
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class conexion {
    //localhost    192.168.0.1
    private static String url = "jdbc:mysql://localhost:3306/elec2020";
    private static String user = "root";
    private static String password = "gad2012*";
    public static synchronized Connection getConexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Obtenemos la conexion
            cn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            cn = null;
            System.out.println("Error de conexion a MySql " + e.toString());
        } finally {
            return cn;
        }
    }
    
    public Connection getConection() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Obtenemos la conexion
            cn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            cn = null;
            System.out.println("Error de conexion a MySql " + e.toString());
        } finally {
            return cn;
        }
    }
    
    //Metodo utilizado para cerrar el callablestatemente
    public static synchronized void cerrarCall(CallableStatement cl) {
        try{cl.close();}catch(Exception e){}
    }
    //Metodo utilizado para cerrar el resulset de datos
    public static synchronized void cerrarConexion(ResultSet rs) {
        try{rs.close();} catch (Exception e) {}
    }
    //Metodo utilizado para cerrar la conexion
    public static synchronized void cerrarConexion(Connection cn) {
        try{cn.close();} catch (Exception e) {}
    }
    //Metodo utilizado para deshacer los cambios en la base de datos
    public static synchronized void deshacerCambios(Connection cn) {
        try{cn.rollback();}catch (Exception e){}
    }
}