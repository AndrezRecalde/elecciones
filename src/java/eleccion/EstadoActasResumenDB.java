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
public class EstadoActasResumenDB {

    public EstadoActasResumen CargarActas() {
        EstadoActasResumen OBJ = new EstadoActasResumen();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select c.nombre_canton,p.nombre_parroquia, z.nombre_zona, r.nombre_recinto, j.junta_nombre,\n"
                    + "  existe_acta_junta_dignidad(j.idjunta, 1) as 'Presidente y Viceprecidente',\n"
                    + "  existe_acta_junta_dignidad(j.idjunta, 2) as 'Asambleístas Provinciales',\n"
                    + "   existe_acta_junta_dignidad(j.idjunta, 3) as 'Parlamentarios Andinos',\n"
                    + "    existe_acta_junta_dignidad(j.idjunta, 4) as 'Asambleístas Nacionales' from junta as j\n"
                    + "inner join zonas as z on z.idzonas=j.fr_id_zona\n"
                    + "inner join parroquias as p on p.cod_parroquia=z.cod_parroquia\n"
                    + "inner join cantones as c on c.cod_canton=z.cod_parroquia\n"
                    + "inner join recintos as r on j.cod_recinto=r.cod_recinto ;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OBJ.setProvincia("Esmeraldas");
                OBJ.setCanton(rs.getString("nombre_canton"));
                OBJ.setParroquia(rs.getString("nombre_parroquia"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OBJ;
    }

    public int TotalActas(int iddignidad) {
        int total = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select total_de_actas_digitadas_de_una_dignidad(" + iddignidad + ") digitadas;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("digitadas");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int TotalActasIngresadasCanton(int iddignidad, int id_canton) {
        int total = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select count(*) as digitadas\n"
                    + " from acta as a inner join acta_estado as ae on a.fr_id_acta_estado=ae.idacta_estado\n"
                    + " inner join provincia as p on p.cne_cod_prov=a.cod_provincia\n"
                    + " inner join cantones as c on c.cod_canton=a.cod_canton\n"
                    + " inner join parroquias as pa on pa.cod_parroquia=a.cod_parroquia\n"
                    + " inner join zonas as z on z.idzonas=a.cod_zona\n"
                    + " inner join dignidad as d on d.iddignidad=a.fr_id_dignidad\n"
                    + " inner join junta as j on j.idjunta=a.fr_id_junta\n"
                    + " inner join usuario as us on us.idusuario=a.acta_usu_ing\n"
                    + " where a.fr_id_dignidad=" + iddignidad + " and c.cod_canton=" + id_canton + " ;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("digitadas");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int TotalActasIngresadasPadreCanton(int iddignidad, int id_canton_padre) {
        int total = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select count(*) as digitadas\n"
                    + " from acta as a inner join acta_estado as ae on a.fr_id_acta_estado=ae.idacta_estado\n"
                    + " inner join provincia as p on p.cne_cod_prov=a.cod_provincia\n"
                    + " inner join cantones as c on c.cod_canton=a.cod_canton\n"
                    + " inner join parroquias as pa on pa.cod_parroquia=a.cod_parroquia\n"
                    + " inner join zonas as z on z.idzonas=a.cod_zona\n"
                    + " inner join dignidad as d on d.iddignidad=a.fr_id_dignidad\n"
                    + " inner join junta as j on j.idjunta=a.fr_id_junta\n"
                    + " inner join usuario as us on us.idusuario=a.acta_usu_ing\n"
                    + " where a.fr_id_dignidad=" + iddignidad + " and c.fr_id_canton_pertenece=" + id_canton_padre + " ;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("digitadas");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int TotalActasIngresadasParroquia(int iddignidad, int id_parr) {
        int total = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select count(*) as digitadas\n"
                    + " from acta as a inner join acta_estado as ae on a.fr_id_acta_estado=ae.idacta_estado\n"
                    + " inner join provincia as p on p.cne_cod_prov=a.cod_provincia\n"
                    + " inner join cantones as c on c.cod_canton=a.cod_canton\n"
                    + " inner join parroquias as pa on pa.cod_parroquia=a.cod_parroquia\n"
                    + " inner join zonas as z on z.idzonas=a.cod_zona\n"
                    + " inner join dignidad as d on d.iddignidad=a.fr_id_dignidad\n"
                    + " inner join junta as j on j.idjunta=a.fr_id_junta\n"
                    + " inner join usuario as us on us.idusuario=a.acta_usu_ing\n"
                    + " where a.fr_id_dignidad=" + iddignidad + " and pa.cod_parroquia=" + id_parr + " ;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("digitadas");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int TotalJuntasProvincia() {
        int total = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select total_de_juntas() total;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int TotalJuntasCanton(int id_canton) {
        int total = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "SELECT count(*) as total FROM junta as ju\n"
                    + "join zonas as zo on zo.idzonas=ju.fr_id_zona\n"
                    + "join parroquias as pa on pa.cod_parroquia = zo.cod_parroquia\n"
                    + "join cantones as ca on ca.cod_canton=pa.cod_canton\n"
                    + "where ca.cod_canton=" + id_canton;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int TotalJuntasCantonPadre(int id_canton) {
        int total = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "SELECT count(*) as total FROM junta as ju\n"
                    + "join zonas as zo on zo.idzonas=ju.fr_id_zona\n"
                    + "join parroquias as pa on pa.cod_parroquia = zo.cod_parroquia\n"
                    + "join cantones as ca on ca.cod_canton=pa.cod_canton\n"
                    + "where ca.fr_id_canton_pertenece=" + id_canton;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int TotalJuntasParroquia(int id_parr) {
        int total = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "SELECT count(*) as total FROM junta as ju\n"
                    + "join zonas as zo on zo.idzonas=ju.fr_id_zona\n"
                    + "join parroquias as pa on pa.cod_parroquia = zo.cod_parroquia\n"
                    + "join cantones as ca on ca.cod_canton=pa.cod_canton\n"
                    + "where pa.cod_parroquia=" + id_parr;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public boolean CambiarEstadoActaId(int idacta, int idestado, int idusuario) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "update acta set fr_id_acta_estado=" + idestado + ", acta_usu_ing=" + idusuario + " where idacta=" + idacta + ";";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public ArrayList<acta> CargarActasJunta(int idjunta) {
        ArrayList<acta> lista = new ArrayList<acta>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select a.cod_provincia, a.cod_provincia, a.cod_canton, a.cod_parroquia,"
                    + " a.cod_zona,a.idacta,a.fr_id_junta,a.fr_id_dignidad,"
                    + " a.cne_cod_acta,a.num_validos,a.num_no_voto,a.num_blancos,"
                    + " a.num_nulos,a.acta_usu_ing,a.acta_usu_mod,a.acta_fi,a.acta_um,"
                    + " a.cuadrada,a.legible,a.fr_id_acta_estado,ae.estado_nombre,d.nombre_dignidad, "
                    + " concat(j.num_junta,' ',genero) junta_nombre, p.nombre_provincia, pa.nombre_parroquia,"
                    + " c.nombre_canton, z.nombre_zona,j.responsable,j.responsable_telefono,re.nombre_recinto,j.idjunta,j.responsable_cedula "
                    + " from junta as j"
                    + " inner join recintos as re on re.cod_recinto=j.cod_recinto "
                    + " left join zonas as z on z.idzonas=j.fr_id_zona "
                    + " left join parroquias as pa on pa.cod_parroquia=z.cod_parroquia "
                    + " left join cantones as c on c.cod_canton=pa.cod_canton "
                    + " left join provincia as p on p.cne_cod_prov=c.cod_provincia "
                    + " left join acta as a on a.fr_id_junta = j.idjunta"
                    + " left join acta_estado as ae on ae.idacta_estado =a.fr_id_acta_estado"
                    + " left join dignidad as d on d.iddignidad=a.fr_id_dignidad "
                    + " where j.idjunta=" + idjunta + ";";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                acta OBJ = new acta();
                OBJ.setActa_fi(rs.getTimestamp("acta_fi"));
                OBJ.setActa_um(rs.getTimestamp("acta_um"));
                OBJ.setActa_usu_ing(rs.getInt("acta_usu_ing"));
                OBJ.setActa_usu_mod(rs.getInt("acta_usu_mod"));
                OBJ.setCne_cod_acta(rs.getInt("cne_cod_acta"));
                OBJ.setCuadrada(rs.getBoolean("cuadrada"));
                OBJ.setDignidad_nombre(rs.getString("nombre_dignidad"));
                OBJ.setEstado_nombre(rs.getString("estado_nombre"));
                OBJ.setFr_id_acta_estado(rs.getInt("fr_id_acta_estado"));
                OBJ.setFr_id_dignidad(rs.getInt("fr_id_dignidad"));
                OBJ.setFr_id_junta(rs.getInt("idjunta"));
                OBJ.setIdacta(rs.getInt("idacta"));
                OBJ.setJunta_nombre(rs.getString("junta_nombre"));
                OBJ.setLegible(rs.getBoolean("legible"));
                OBJ.setNum_blancos(rs.getInt("num_blancos"));
                OBJ.setNum_no_voto(rs.getInt("num_no_voto"));
                OBJ.setNum_nulos(rs.getInt("num_nulos"));
                OBJ.setNum_validos(rs.getInt("num_validos"));
                OBJ.setCod_provincia(rs.getInt("cod_provincia"));
                OBJ.setCod_canton(rs.getInt("cod_canton"));
                OBJ.setCod_parroquia(rs.getInt("cod_parroquia"));
                OBJ.setCod_zona(rs.getInt("cod_zona"));
                OBJ.setProvincia_nombre(rs.getString("nombre_provincia"));
                OBJ.setParroquia_nombre(rs.getString("nombre_parroquia"));
                OBJ.setCanton_nombre(rs.getString("nombre_canton"));
                OBJ.setZona_nombre(rs.getString("nombre_zona"));
                OBJ.setResponsable(rs.getString("responsable"));
                OBJ.setResponsable_telefono(rs.getString("responsable_telefono"));
                OBJ.setRecinto_nombre(rs.getString("nombre_recinto"));
                OBJ.setResponsable_cedula(rs.getString("responsable_cedula"));
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

    public ArrayList<acta> CargarActasJuntaZona(int idzona) {
        ArrayList<acta> lista = new ArrayList<acta>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select a.cod_provincia, a.cod_provincia, a.cod_canton, a.cod_parroquia,"
                    + " a.cod_zona,a.idacta,a.fr_id_junta,a.fr_id_dignidad,"
                    + " a.cne_cod_acta,a.num_validos,a.num_no_voto,a.num_blancos,"
                    + " a.num_nulos,a.acta_usu_ing,a.acta_usu_mod,a.acta_fi,a.acta_um,"
                    + " a.cuadrada,a.legible,a.fr_id_acta_estado,ae.estado_nombre,d.nombre_dignidad, "
                    + " concat(j.num_junta,' ',genero) junta_nombre, p.nombre_provincia, pa.nombre_parroquia,"
                    + " c.nombre_canton, z.nombre_zona,j.responsable,j.responsable_telefono,re.nombre_recinto,j.idjunta,j.responsable_cedula "
                    + " from junta as j"
                    + " inner join recintos as re on re.cod_recinto=j.cod_recinto "
                    + " left join zonas as z on z.idzonas=j.fr_id_zona "
                    + " left join parroquias as pa on pa.cod_parroquia=z.cod_parroquia "
                    + " left join cantones as c on c.cod_canton=pa.cod_canton "
                    + " left join provincia as p on p.cne_cod_prov=c.cod_provincia "
                    + " left join acta as a on a.fr_id_junta = j.idjunta"
                    + " left join acta_estado as ae on ae.idacta_estado =a.fr_id_acta_estado"
                    + " left join dignidad as d on d.iddignidad=a.fr_id_dignidad "
                    + " where fr_id_zona=" + idzona + ";";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                acta OBJ = new acta();
                OBJ.setActa_fi(rs.getTimestamp("acta_fi"));
                OBJ.setActa_um(rs.getTimestamp("acta_um"));
                OBJ.setActa_usu_ing(rs.getInt("acta_usu_ing"));
                OBJ.setActa_usu_mod(rs.getInt("acta_usu_mod"));
                OBJ.setCne_cod_acta(rs.getInt("cne_cod_acta"));
                OBJ.setCuadrada(rs.getBoolean("cuadrada"));
                OBJ.setDignidad_nombre(rs.getString("nombre_dignidad"));
                OBJ.setEstado_nombre(rs.getString("estado_nombre"));
                OBJ.setFr_id_acta_estado(rs.getInt("fr_id_acta_estado"));
                OBJ.setFr_id_dignidad(rs.getInt("fr_id_dignidad"));
                OBJ.setFr_id_junta(rs.getInt("idjunta"));
                OBJ.setIdacta(rs.getInt("idacta"));
                OBJ.setJunta_nombre(rs.getString("junta_nombre"));
                OBJ.setLegible(rs.getBoolean("legible"));
                OBJ.setNum_blancos(rs.getInt("num_blancos"));
                OBJ.setNum_no_voto(rs.getInt("num_no_voto"));
                OBJ.setNum_nulos(rs.getInt("num_nulos"));
                OBJ.setNum_validos(rs.getInt("num_validos"));
                OBJ.setCod_provincia(rs.getInt("cod_provincia"));
                OBJ.setCod_canton(rs.getInt("cod_canton"));
                OBJ.setCod_parroquia(rs.getInt("cod_parroquia"));
                OBJ.setCod_zona(rs.getInt("cod_zona"));
                OBJ.setProvincia_nombre(rs.getString("nombre_provincia"));
                OBJ.setParroquia_nombre(rs.getString("nombre_parroquia"));
                OBJ.setCanton_nombre(rs.getString("nombre_canton"));
                OBJ.setZona_nombre(rs.getString("nombre_zona"));
                OBJ.setResponsable(rs.getString("responsable"));
                OBJ.setResponsable_telefono(rs.getString("responsable_telefono"));
                OBJ.setRecinto_nombre(rs.getString("nombre_recinto"));
                OBJ.setResponsable_cedula(rs.getString("responsable_cedula"));
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

    public int ContarActasUsuario(int fr_id_usuario) {
        int total = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "SELECT count(*) as total from acta where acta_usu_ing=" + fr_id_usuario;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int ContarActasUsuarioDignidad(int fr_id_usuario, int fr_id_dignidad) {
        int total = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "SELECT count(*) as total from acta where acta_usu_ing=" + fr_id_usuario + " and fr_id_dignidad=" + fr_id_dignidad;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int ContarActasXDignidad(int fr_id_dignidad) {
        int total = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "SELECT count(*) as total from acta where fr_id_dignidad=" + fr_id_dignidad;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int ContarActasTotal(int fr_id_dignidad) {
        int total = 0;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "SELECT count(*) as total from acta where fr_id_dignidad=" + fr_id_dignidad;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int IngresarActaJuntaDignidad(int fr_id_dignidad, int cod_provincia,
            int cod_canton, int cod_parroquia, int cod_zona, int fr_id_junta, int cne_cod_acta, int num_validos,
            int num_no_voto, int num_blancos, int num_nulos, int acta_usu_ing,
            boolean cuadrada, boolean legible, int fr_id_acta_estado) {
        boolean exito = false;
        int idacta = -1;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "insert into acta(fr_id_dignidad,cod_provincia,cod_canton,cod_parroquia,cod_zona,"
                    + "fr_id_junta,cne_cod_acta,num_validos,num_no_voto,num_blancos,num_nulos,"
                    + "acta_usu_ing,cuadrada,legible,fr_id_acta_estado)"
                    + "values(" + fr_id_dignidad + " , " + cod_provincia + ", " + cod_canton + " , "
                    + cod_parroquia + " , " + cod_zona + " , " + fr_id_junta + ", " + cne_cod_acta + " , "
                    + num_validos + " , " + num_no_voto + " , " + num_blancos + ", " + num_nulos + " , "
                    + acta_usu_ing + " , " + cuadrada + " , " + legible + ", " + fr_id_acta_estado + ");";
            Statement st = con.createStatement();
            exito = st.executeUpdate(sql) == 1 ? true : false;
            if (exito) {
                ResultSet rs = st.executeQuery("select idacta from acta where fr_id_junta=" + fr_id_junta + " and fr_id_dignidad=" + fr_id_dignidad);
                while (rs.next()) {
                    idacta = rs.getInt("idacta");
                }
            } else {
                return -1;
            }
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idacta;
    }

    public acta CargarJuntaDignidad(int idjunta, int iddignidad) {
        acta OBJ = new acta();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select a.cod_provincia, a.cod_provincia, a.cod_canton, a.cod_parroquia,"
                    + " a.cod_zona,a.idacta,a.fr_id_junta,a.fr_id_dignidad,"
                    + " a.cne_cod_acta,a.num_validos,a.num_no_voto,a.num_blancos,"
                    + " a.num_nulos,a.acta_usu_ing,a.acta_usu_mod,a.acta_fi,a.acta_um,"
                    + " a.cuadrada,a.legible,a.fr_id_acta_estado,ae.estado_nombre,d.nombre_dignidad, "
                    + " concat(j.num_junta,' ',genero) junta_nombre, p.nombre_provincia, pa.nombre_parroquia,"
                    + " c.nombre_canton, z.nombre_zona,j.responsable,j.responsable_telefono,us.nombres,us.usuario"
                    + " from acta as a inner join acta_estado as ae on a.fr_id_acta_estado=ae.idacta_estado"
                    + " inner join provincia as p on p.cne_cod_prov=a.cod_provincia"
                    + " inner join cantones as c on c.cod_canton=a.cod_canton"
                    + " inner join parroquias as pa on pa.cod_parroquia=a.cod_parroquia"
                    + " inner join zonas as z on z.idzonas=a.cod_zona"
                    + " inner join dignidad as d on d.iddignidad=a.fr_id_dignidad"
                    + " inner join junta as j on j.idjunta=a.fr_id_junta"
                    + " inner join usuario as us on us.idusuario=a.acta_usu_ing"
                    + " where a.fr_id_junta=" + idjunta + " and a.fr_id_dignidad=" + iddignidad + ";";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                OBJ.setActa_fi(rs.getTimestamp("acta_fi"));
                OBJ.setActa_um(rs.getTimestamp("acta_um"));
                OBJ.setActa_usu_ing(rs.getInt("acta_usu_ing"));
                OBJ.setActa_usu_mod(rs.getInt("acta_usu_mod"));
                OBJ.setCne_cod_acta(rs.getInt("cne_cod_acta"));
                OBJ.setCuadrada(rs.getBoolean("cuadrada"));
                OBJ.setDignidad_nombre(rs.getString("nombre_dignidad"));
                OBJ.setEstado_nombre(rs.getString("estado_nombre"));
                OBJ.setFr_id_acta_estado(rs.getInt("fr_id_acta_estado"));
                OBJ.setFr_id_dignidad(rs.getInt("fr_id_dignidad"));
                OBJ.setFr_id_junta(rs.getInt("fr_id_junta"));
                OBJ.setIdacta(rs.getInt("idacta"));
                OBJ.setJunta_nombre(rs.getString("junta_nombre"));
                OBJ.setLegible(rs.getBoolean("legible"));
                OBJ.setNum_blancos(rs.getInt("num_blancos"));
                OBJ.setNum_no_voto(rs.getInt("num_no_voto"));
                OBJ.setNum_nulos(rs.getInt("num_nulos"));
                OBJ.setNum_validos(rs.getInt("num_validos"));
                OBJ.setCod_provincia(rs.getInt("cod_provincia"));
                OBJ.setCod_canton(rs.getInt("cod_canton"));
                OBJ.setCod_parroquia(rs.getInt("cod_parroquia"));
                OBJ.setCod_zona(rs.getInt("cod_zona"));
                OBJ.setProvincia_nombre(rs.getString("nombre_provincia"));
                OBJ.setParroquia_nombre(rs.getString("nombre_parroquia"));
                OBJ.setCanton_nombre(rs.getString("nombre_canton"));
                OBJ.setZona_nombre(rs.getString("nombre_zona"));
                OBJ.setResponsable(rs.getString("responsable"));
                OBJ.setResponsable_telefono(rs.getString("responsable_telefono"));
                OBJ.setUsuario_nombre(rs.getString("nombres"));
                OBJ.setUsuario_usuario(rs.getString("usuario"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OBJ;
    }

    public boolean ExisteJuntaDignidad(int idjunta, int iddignidad) {
        boolean existe = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select * from acta as a where a.fr_id_junta=" + idjunta + " and a.fr_id_dignidad=" + iddignidad + ";";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                existe = true;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return existe;
    }

    public boolean EliminarActaId(int idacta) {
        boolean exito = false;
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "delete from acta where idacta=" + idacta + ";";
            Statement st = con.createStatement();
            System.out.println(sql);
            exito = st.executeUpdate(sql) == 1 ? true : false;
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }
}
