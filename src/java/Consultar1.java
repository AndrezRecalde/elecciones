
import java.util.ArrayList;
import herramientas.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author userver1
 */
public class Consultar1 {

    Connection connection = null;
    ResultSet rs = null;
    Statement st = null;

    public ArrayList buscaProvincias() {
        //creacion del arraylist ciudades
        ArrayList Padres = new ArrayList();
        try {
            //Realizar la conexion a la base de datos
            //Obviamente con una Clase Conexion tambien en el paquete del modelo
            conexion cnn = new conexion();
            connection = cnn.getConection();
            st = connection.createStatement();
            rs = st.executeQuery("select cne_cod_prov, nombre_provincia from provincia where activa"); //
            //iterar los resultados
            while (rs.next()) {
                Padres.add(rs.getInt("cne_cod_prov"));
                Padres.add(rs.getString("nombre_provincia"));
            }
        } catch (SQLException e) {
            System.err.println("error " + e.getMessage());
            //se cierran la conexion y el Statement
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error en consulta");
                e.printStackTrace();
            }
        }
        //retornar el arrayList
        return Padres;
    }

    public ArrayList buscaCantones(int idpadre) {
        //creacion del arraylist ciudades
        ArrayList Hijos = new ArrayList();
        try {
            //Realizar la conexion a la base de datos
            //Obviamente con una Clase Conexion tambien en el paquete del modelo
            conexion cnn = new conexion();
            connection = null;
            connection = cnn.getConection();

            st = connection.createStatement();
            rs = st.executeQuery("select cod_canton, nombre_canton from cantones where cod_provincia=" + idpadre);
            //iterar los resultados
            while (rs.next()) {
                Hijos.add(rs.getString("cod_canton"));
                Hijos.add(rs.getString("nombre_canton"));
            }
        } catch (SQLException e) {
            System.err.println("error " + e.getMessage());
            //se cierran la conexion y el Statement
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error en consulta");
                e.printStackTrace();
            }
        }
        //retornar el arrayList
        return Hijos;
    }

    public ArrayList buscaCantones() {
        //creacion del arraylist ciudades
        ArrayList Hijos = new ArrayList();
        try {
            //Realizar la conexion a la base de datos
            //Obviamente con una Clase Conexion tambien en el paquete del modelo
            conexion cnn = new conexion();
            connection = null;
            connection = cnn.getConection();

            st = connection.createStatement();
            rs = st.executeQuery("select cod_canton, nombre_canton,cod_provincia from cantones ");
            //iterar los resultados
            while (rs.next()) {
                Hijos.add(rs.getString("cod_canton"));
                Hijos.add(rs.getString("nombre_canton"));
                Hijos.add(rs.getString("cod_provincia"));
            }
        } catch (SQLException e) {
            System.err.println("error " + e.getMessage());
            //se cierran la conexion y el Statement
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error en consulta");
                e.printStackTrace();
            }
        }
        //retornar el arrayList
        return Hijos;
    }
    
    public ArrayList buscaParroquias(int idpadre) {
        //creacion del arraylist ciudades
        ArrayList Hijos = new ArrayList();
        try {
            //Realizar la conexion a la base de datos
            //Obviamente con una Clase Conexion tambien en el paquete del modelo
            conexion cnn = new conexion();
            connection = null;
            connection = cnn.getConection();

            st = connection.createStatement();
            rs = st.executeQuery("select cod_parroquia, nombre_parroquia from parroquias where cod_canton=" + idpadre);
            //iterar los resultados
            while (rs.next()) {
                Hijos.add(rs.getString("cod_parroquia"));
                Hijos.add(rs.getString("nombre_parroquia"));
            }
        } catch (SQLException e) {
            System.err.println("error " + e.getMessage());
            //se cierran la conexion y el Statement
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error en consulta");
                e.printStackTrace();
            }
        }
        //retornar el arrayList
        return Hijos;
    }
    
    public ArrayList buscaParroquias() {
        //creacion del arraylist ciudades
        ArrayList Hijos = new ArrayList();
        try {
            //Realizar la conexion a la base de datos
            //Obviamente con una Clase Conexion tambien en el paquete del modelo
            conexion cnn = new conexion();
            connection = null;
            connection = cnn.getConection();

            st = connection.createStatement();
            rs = st.executeQuery("select cod_parroquia, nombre_parroquia,cod_canton from parroquias");
            //iterar los resultados
            while (rs.next()) {
                Hijos.add(rs.getString("cod_parroquia"));
                Hijos.add(rs.getString("nombre_parroquia"));
                Hijos.add(rs.getString("cod_canton"));
            }
        } catch (SQLException e) {
            System.err.println("error " + e.getMessage());
            //se cierran la conexion y el Statement
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error en consulta");
                e.printStackTrace();
            }
        }
        //retornar el arrayList
        return Hijos;
    }

    public ArrayList buscaZonas(int idpadre) {
        //creacion del arraylist ciudades
        ArrayList Hijos = new ArrayList();
        try {
            //Realizar la conexion a la base de datos
            //Obviamente con una Clase Conexion tambien en el paquete del modelo
            conexion cnn = new conexion();
            connection = null;
            connection = cnn.getConection();

            st = connection.createStatement();
            rs = st.executeQuery("select cod_zona, nombre_zona from zonas where cod_parroquia=" + idpadre);
            //iterar los resultados
            while (rs.next()) {
                Hijos.add(rs.getString("cod_zona"));
                Hijos.add(rs.getString("nombre_zona"));
            }
        } catch (SQLException e) {
            System.err.println("error " + e.getMessage());
            //se cierran la conexion y el Statement
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error en consulta");
                e.printStackTrace();
            }
        }
        //retornar el arrayList
        return Hijos;
    }
    
    public ArrayList buscaZonas() {
        //creacion del arraylist ciudades
        ArrayList Hijos = new ArrayList();
        try {
            //Realizar la conexion a la base de datos
            //Obviamente con una Clase Conexion tambien en el paquete del modelo
            conexion cnn = new conexion();
            connection = null;
            connection = cnn.getConection();

            st = connection.createStatement();
            rs = st.executeQuery("select cod_zona, nombre_zona,cod_parroquia from zonas");
            //iterar los resultados
            while (rs.next()) {
                Hijos.add(rs.getString("cod_zona"));
                Hijos.add(rs.getString("nombre_zona"));
                Hijos.add(rs.getString("cod_parroquia"));
            }
        } catch (SQLException e) {
            System.err.println("error " + e.getMessage());
            //se cierran la conexion y el Statement
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error en consulta");
                e.printStackTrace();
            }
        }
        //retornar el arrayList
        return Hijos;
    }


    public ArrayList buscaRecintos(int idpadre) {
        //creacion del arraylist ciudades
        ArrayList Hijos = new ArrayList();
        try {
            //Realizar la conexion a la base de datos
            //Obviamente con una Clase Conexion tambien en el paquete del modelo
            conexion cnn = new conexion();
            connection = null;
            connection = cnn.getConection();

            st = connection.createStatement();
            rs = st.executeQuery("select cod_recinto, nombre_recinto from recintos where cod_parroquia=" + idpadre);
            //iterar los resultados
            while (rs.next()) {
                Hijos.add(rs.getString("cod_recinto"));
                Hijos.add(rs.getString("nombre_recinto"));
            }
        } catch (SQLException e) {
            System.err.println("error " + e.getMessage());
            //se cierran la conexion y el Statement
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error en consulta");
                e.printStackTrace();
            }
        }
        //retornar el arrayList
        return Hijos;
    }

    public ArrayList buscaRecintos(int idpadre, int idpadre2) {
        //creacion del arraylist ciudades
        ArrayList Hijos = new ArrayList();
        try {
            //Realizar la conexion a la base de datos
            //Obviamente con una Clase Conexion tambien en el paquete del modelo
            conexion cnn = new conexion();
            connection = null;
            connection = cnn.getConection();

            st = connection.createStatement();
            rs = st.executeQuery("select cod_recinto, nombre_recinto from recintos where cod_parroquia=" + idpadre + " and cod_zona=" + idpadre2);
            //iterar los resultados
            while (rs.next()) {
                Hijos.add(rs.getString("cod_recinto"));
                Hijos.add(rs.getString("nombre_recinto"));
            }
        } catch (SQLException e) {
            System.err.println("error " + e.getMessage());
            //se cierran la conexion y el Statement
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error en consulta");
                e.printStackTrace();
            }
        }
        //retornar el arrayList
        return Hijos;
    }

    public ArrayList buscaJuntas(int idpadre) {
        //creacion del arraylist ciudades
        ArrayList Hijos = new ArrayList();
        try {
            //Realizar la conexion a la base de datos
            //Obviamente con una Clase Conexion tambien en el paquete del modelo
            conexion cnn = new conexion();
            connection = null;
            connection = cnn.getConection();
            st = connection.createStatement();
            rs = st.executeQuery("select idjunta, CONCAT( num_junta ,' ', genero) as junta from junta where fr_id_zona=" + idpadre);
            //iterar los resultados
            while (rs.next()) {
                Hijos.add(rs.getString("idjunta"));
                Hijos.add(rs.getString("junta"));
            }
        } catch (SQLException e) {
            System.err.println("error " + e.getMessage());
            //se cierran la conexion y el Statement
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error en consulta");
                e.printStackTrace();
            }
        }
        //retornar el arrayList
        return Hijos;
    }
    
    public ArrayList buscaJuntas() {
        //creacion del arraylist ciudades
        ArrayList Hijos = new ArrayList();
        try {
            //Realizar la conexion a la base de datos
            //Obviamente con una Clase Conexion tambien en el paquete del modelo
            conexion cnn = new conexion();
            connection = null;
            connection = cnn.getConection();
            st = connection.createStatement();
            rs = st.executeQuery("select idjunta, CONCAT( num_junta ,' ', genero) as junta,fr_id_zona from junta");
            //iterar los resultados
            while (rs.next()) {
                Hijos.add(rs.getString("idjunta"));
                Hijos.add(rs.getString("junta"));
                Hijos.add(rs.getString("fr_id_zona"));
            }
        } catch (SQLException e) {
            System.err.println("error " + e.getMessage());
            //se cierran la conexion y el Statement
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error en consulta");
                e.printStackTrace();
            }
        }
        //retornar el arrayList
        return Hijos;
    }
}
