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
public class ClassResultadosBD {

    public ArrayList<ClassResultadosBasico> CargarBasicoProvincial(int id_dignidad, int idprovincial) {
        ArrayList<ClassResultadosBasico> lista = new ArrayList<ClassResultadosBasico>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select di.nombre_dignidad,ca.nombre,org.lista,org.color,org.siglas,"
                    + " sum(num_votos) as total_votos, sum(ac.num_validos) as total_votos_validos,"
                    + " sum(ac.num_no_voto) as total_votos_no_voto ,sum(ac.num_blancos) as total_votos_blancos"
                    + " ,sum(ac.num_nulos) as total_votos_nulos"
                    + " from  acta_detalle as ad"
                    + " inner join acta as ac on ad.fr_id_acta=ac.idacta"
                    + " inner join dignidad as di on ac.fr_id_dignidad = di.iddignidad"
                    + " inner join candidato as ca on ad.fr_id_candidato=ca.idcandidato "
                    + " inner join organizacion as org on org.idorganizacion=ca.fr_id_organizacion "
                    + " inner join junta as ju on ju.idjunta=ac.fr_id_junta"
                    + " inner join zonas as z on z.idzonas=ac.cod_zona"
                    + " inner join parroquias as pa on ac.cod_parroquia=pa.cod_parroquia"
                    + " inner join cantones as cn on cn.cod_canton=pa.cod_canton"
                    + " where di.iddignidad=" + id_dignidad + " and ca.fr_id_provincia=8 "
                    + " group by ad.fr_id_candidato order by org.orden asc;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosBasico OBJ = new ClassResultadosBasico();
                OBJ.setNombre(rs.getString("nombre"));
                OBJ.setColor(rs.getString("color"));
                OBJ.setListas(rs.getString("lista"));
                OBJ.setSiglas(rs.getString("siglas"));
                OBJ.setNombre_dignidad(rs.getString("nombre_dignidad"));
                OBJ.setTotal_votos(rs.getInt("total_votos"));
                OBJ.setTotal_votos_blancos(rs.getInt("total_votos_blancos"));
                OBJ.setTotal_votos_no_voto(rs.getInt("total_votos_no_voto"));
                OBJ.setTotal_votos_nulos(rs.getInt("total_votos_nulos"));
                OBJ.setTotal_votos_validos(rs.getInt("total_votos_validos"));
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
    
    public ArrayList<ClassResultadosBasico> CargarBasicoProvincialEscanio(int id_dignidad, int idprovincial) {
        ArrayList<ClassResultadosBasico> lista = new ArrayList<ClassResultadosBasico>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select di.nombre_dignidad,ca.nombre,org.lista,org.color,org.siglas,"
                    + " sum(num_votos) as total_votos, sum(ac.num_validos) as total_votos_validos,"
                    + " sum(ac.num_no_voto) as total_votos_no_voto ,sum(ac.num_blancos) as total_votos_blancos"
                    + " ,sum(ac.num_nulos) as total_votos_nulos"
                    + " from  acta_detalle as ad"
                    + " inner join acta as ac on ad.fr_id_acta=ac.idacta"
                    + " inner join dignidad as di on ac.fr_id_dignidad = di.iddignidad"
                    + " inner join candidato as ca on ad.fr_id_candidato=ca.idcandidato "
                    + " inner join organizacion as org on org.idorganizacion=ca.fr_id_organizacion "
                    + " inner join junta as ju on ju.idjunta=ac.fr_id_junta"
                    + " inner join zonas as z on z.idzonas=ac.cod_zona"
                    + " inner join parroquias as pa on ac.cod_parroquia=pa.cod_parroquia"
                    + " inner join cantones as cn on cn.cod_canton=pa.cod_canton"
                    + " where di.iddignidad=" + id_dignidad + " and ca.fr_id_provincia=8 "
                    + " group by ad.fr_id_candidato order by total_votos desc;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosBasico OBJ = new ClassResultadosBasico();
                OBJ.setNombre(rs.getString("nombre"));
                OBJ.setColor(rs.getString("color"));
                OBJ.setListas(rs.getString("lista"));
                OBJ.setSiglas(rs.getString("siglas"));
                OBJ.setNombre_dignidad(rs.getString("nombre_dignidad"));
                OBJ.setTotal_votos(rs.getInt("total_votos"));
                OBJ.setTotal_votos_blancos(rs.getInt("total_votos_blancos"));
                OBJ.setTotal_votos_no_voto(rs.getInt("total_votos_no_voto"));
                OBJ.setTotal_votos_nulos(rs.getInt("total_votos_nulos"));
                OBJ.setTotal_votos_validos(rs.getInt("total_votos_validos"));
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

    public ArrayList<ClassResultadosBasico> CargarPorDignidadCantonal(int id_dignidad, int idcanton) {
        ArrayList<ClassResultadosBasico> lista = new ArrayList<ClassResultadosBasico>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select di.nombre_dignidad,ca.nombre,org.lista,org.color,org.siglas,"
                    + " sum(num_votos) as total_votos, sum(ac.num_validos) as total_votos_validos,"
                    + " sum(ac.num_no_voto) as total_votos_no_voto ,sum(ac.num_blancos) as total_votos_blancos"
                    + " ,sum(ac.num_nulos) as total_votos_nulos"
                    + " from  acta_detalle as ad"
                    + " inner join acta as ac on ad.fr_id_acta=ac.idacta"
                    + " inner join dignidad as di on ac.fr_id_dignidad = di.iddignidad"
                    + " inner join candidato as ca on ad.fr_id_candidato=ca.idcandidato "
                    + " inner join organizacion as org on org.idorganizacion=ca.fr_id_organizacion "
                    + " inner join junta as ju on ju.idjunta=ac.fr_id_junta"
                    + " inner join zonas as z on z.idzonas=ac.cod_zona"
                    + " inner join parroquias as pa on ac.cod_parroquia=pa.cod_parroquia"
                    + " inner join cantones as cn on cn.cod_canton=pa.cod_canton"
                    + " where di.iddignidad=" + id_dignidad + " and cn.cod_canton=" + idcanton
                    + " group by ad.fr_id_candidato"
                    + " order by org.orden asc;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosBasico OBJ = new ClassResultadosBasico();
                OBJ.setNombre(rs.getString("nombre"));
                OBJ.setColor(rs.getString("color"));
                OBJ.setListas(rs.getString("lista"));
                OBJ.setSiglas(rs.getString("siglas"));
                OBJ.setNombre_dignidad(rs.getString("nombre_dignidad"));
                OBJ.setTotal_votos(rs.getInt("total_votos"));
                OBJ.setTotal_votos_blancos(rs.getInt("total_votos_blancos"));
                OBJ.setTotal_votos_no_voto(rs.getInt("total_votos_no_voto"));
                OBJ.setTotal_votos_nulos(rs.getInt("total_votos_nulos"));
                OBJ.setTotal_votos_validos(rs.getInt("total_votos_validos"));
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

    public ArrayList<ClassResultadosBasico> CargarPorDignidadCantonalPorLista(int id_dignidad, int idcanton) {
        ArrayList<ClassResultadosBasico> lista = new ArrayList<ClassResultadosBasico>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select di.nombre_dignidad,ca.nombre,org.lista,org.color,org.nombre_organizacion,org.siglas,org.idorganizacion,"
                    + " sum(num_votos) as total_votos, sum(ac.num_validos) as total_votos_validos,"
                    + " sum(ac.num_no_voto) as total_votos_no_voto ,sum(ac.num_blancos) as total_votos_blancos"
                    + " ,sum(ac.num_nulos) as total_votos_nulos"
                    + " from  acta_detalle as ad"
                    + " inner join acta as ac on ad.fr_id_acta=ac.idacta"
                    + " inner join dignidad as di on ac.fr_id_dignidad = di.iddignidad"
                    + " inner join candidato as ca on ad.fr_id_candidato=ca.idcandidato "
                    + " inner join organizacion as org on org.idorganizacion=ca.fr_id_organizacion "
                    + " inner join junta as ju on ju.idjunta=ac.fr_id_junta"
                    + " inner join zonas as z on z.idzonas=ac.cod_zona"
                    + " inner join parroquias as pa on ac.cod_parroquia=pa.cod_parroquia"
                    + " inner join cantones as cn on cn.cod_canton=pa.cod_canton"
                    + " where di.iddignidad=" + id_dignidad + " and cn.cod_canton=" + idcanton
                    + " group by org.idorganizacion order by org.orden asc;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosBasico OBJ = new ClassResultadosBasico();
                OBJ.setNombre(rs.getString("nombre"));
                OBJ.setColor(rs.getString("color"));
                OBJ.setListas(rs.getString("lista"));
                OBJ.setSiglas(rs.getString("siglas"));
                OBJ.setIdorganizacion(rs.getInt("idorganizacion"));
                OBJ.setNombre_organizacion(rs.getString("nombre_organizacion"));
                OBJ.setNombre_dignidad(rs.getString("nombre_dignidad"));
                OBJ.setTotal_votos(rs.getInt("total_votos"));
                OBJ.setTotal_votos_blancos(rs.getInt("total_votos_blancos"));
                OBJ.setTotal_votos_no_voto(rs.getInt("total_votos_no_voto"));
                OBJ.setTotal_votos_nulos(rs.getInt("total_votos_nulos"));
                OBJ.setTotal_votos_validos(rs.getInt("total_votos_validos"));
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

    public ArrayList<ClassResultadosBasico> CargarPorDignidadCantonalPadre(int id_dignidad, int fr_id_canton_pertenece) {
        ArrayList<ClassResultadosBasico> lista = new ArrayList<ClassResultadosBasico>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select di.nombre_dignidad,ca.nombre,org.lista,org.color,org.siglas,"
                    + " sum(num_votos) as total_votos, sum(ac.num_validos) as total_votos_validos,"
                    + " sum(ac.num_no_voto) as total_votos_no_voto ,sum(ac.num_blancos) as total_votos_blancos"
                    + " ,sum(ac.num_nulos) as total_votos_nulos"
                    + " from  acta_detalle as ad"
                    + " inner join acta as ac on ad.fr_id_acta=ac.idacta"
                    + " inner join dignidad as di on ac.fr_id_dignidad = di.iddignidad"
                    + " inner join candidato as ca on ad.fr_id_candidato=ca.idcandidato "
                    + " inner join organizacion as org on org.idorganizacion=ca.fr_id_organizacion "
                    + " inner join junta as ju on ju.idjunta=ac.fr_id_junta"
                    + " inner join zonas as z on z.idzonas=ac.cod_zona"
                    + " inner join parroquias as pa on ac.cod_parroquia=pa.cod_parroquia"
                    + " inner join cantones as cn on cn.cod_canton=pa.cod_canton"
                    + " where di.iddignidad=" + id_dignidad + " and cn.fr_id_canton_pertenece=" + fr_id_canton_pertenece
                    + " group by ad.fr_id_candidato "
                    + " order by org.orden asc;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosBasico OBJ = new ClassResultadosBasico();
                OBJ.setNombre(rs.getString("nombre"));
                OBJ.setColor(rs.getString("color"));
                OBJ.setListas(rs.getString("lista"));
                OBJ.setSiglas(rs.getString("siglas"));
                OBJ.setNombre_dignidad(rs.getString("nombre_dignidad"));
                OBJ.setTotal_votos(rs.getInt("total_votos"));
                OBJ.setTotal_votos_blancos(rs.getInt("total_votos_blancos"));
                OBJ.setTotal_votos_no_voto(rs.getInt("total_votos_no_voto"));
                OBJ.setTotal_votos_nulos(rs.getInt("total_votos_nulos"));
                OBJ.setTotal_votos_validos(rs.getInt("total_votos_validos"));
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

    public ArrayList<ClassResultadosBasico> CargarPorDiginidadParroquial(int iddignidad, int idparroquia) {
        ArrayList<ClassResultadosBasico> lista = new ArrayList<ClassResultadosBasico>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select di.nombre_dignidad,ca.nombre,org.lista,org.color,org.nombre_organizacion,org.siglas,"
                    + " sum(num_votos) as total_votos, sum(ac.num_validos) as total_votos_validos,"
                    + " sum(ac.num_no_voto) as total_votos_no_voto ,sum(ac.num_blancos) as total_votos_blancos"
                    + " ,sum(ac.num_nulos) as total_votos_nulos"
                    + " from  acta_detalle as ad"
                    + " inner join acta as ac on ad.fr_id_acta=ac.idacta"
                    + " inner join dignidad as di on ac.fr_id_dignidad = di.iddignidad"
                    + " inner join candidato as ca on ad.fr_id_candidato=ca.idcandidato "
                    + " inner join organizacion as org on org.idorganizacion=ca.fr_id_organizacion "
                    + " inner join junta as ju on ju.idjunta=ac.fr_id_junta"
                    + " inner join zonas as z on z.idzonas=ac.cod_zona"
                    + " inner join parroquias as pa on ac.cod_parroquia=pa.cod_parroquia"
                    + " inner join cantones as cn on cn.cod_canton=pa.cod_canton"
                    + " where di.iddignidad=" + iddignidad + " and pa.cod_parroquia=" + idparroquia
                    + " group by ad.fr_id_candidato"
                    + " order by org.orden asc;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosBasico OBJ = new ClassResultadosBasico();
                OBJ.setNombre(rs.getString("nombre"));
                OBJ.setColor(rs.getString("color"));
                OBJ.setListas(rs.getString("lista"));
                OBJ.setSiglas(rs.getString("siglas"));
                OBJ.setNombre_organizacion(rs.getString("nombre_organizacion"));
                OBJ.setNombre_dignidad(rs.getString("nombre_dignidad"));
                OBJ.setTotal_votos(rs.getInt("total_votos"));
                OBJ.setTotal_votos_blancos(rs.getInt("total_votos_blancos"));
                OBJ.setTotal_votos_no_voto(rs.getInt("total_votos_no_voto"));
                OBJ.setTotal_votos_nulos(rs.getInt("total_votos_nulos"));
                OBJ.setTotal_votos_validos(rs.getInt("total_votos_validos"));
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
    
    public ArrayList<ClassResultadosBasico> CargarPorDiginidadRecinto(int iddignidad, int idrecinto) {
        ArrayList<ClassResultadosBasico> lista = new ArrayList<ClassResultadosBasico>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select di.nombre_dignidad,ca.nombre,org.lista,org.color,org.nombre_organizacion,org.siglas,"
                    + " sum(num_votos) as total_votos, sum(ac.num_validos) as total_votos_validos,"
                    + " sum(ac.num_no_voto) as total_votos_no_voto ,sum(ac.num_blancos) as total_votos_blancos"
                    + " ,sum(ac.num_nulos) as total_votos_nulos"
                    + " from  acta_detalle as ad"
                    + " inner join acta as ac on ad.fr_id_acta=ac.idacta"
                    + " inner join dignidad as di on ac.fr_id_dignidad = di.iddignidad"
                    + " inner join candidato as ca on ad.fr_id_candidato=ca.idcandidato "
                    + " inner join organizacion as org on org.idorganizacion=ca.fr_id_organizacion "
                    + " inner join junta as ju on ju.idjunta=ac.fr_id_junta"
                    + " inner join zonas as z on z.idzonas=ac.cod_zona"
                    + " inner join parroquias as pa on ac.cod_parroquia=pa.cod_parroquia"
                    + " inner join cantones as cn on cn.cod_canton=pa.cod_canton"
                    + " inner join recintos as re on re.cod_parroquia=pa.cod_parroquia" 
                    + " where di.iddignidad=" + iddignidad + " and re.cod_recinto=" + idrecinto
                    + " group by ad.fr_id_candidato"
                    + " order by org.orden asc;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosBasico OBJ = new ClassResultadosBasico();
                OBJ.setNombre(rs.getString("nombre"));
                OBJ.setColor(rs.getString("color"));
                OBJ.setListas(rs.getString("lista"));
                OBJ.setSiglas(rs.getString("siglas"));
                OBJ.setNombre_organizacion(rs.getString("nombre_organizacion"));
                OBJ.setNombre_dignidad(rs.getString("nombre_dignidad"));
                OBJ.setTotal_votos(rs.getInt("total_votos"));
                OBJ.setTotal_votos_blancos(rs.getInt("total_votos_blancos"));
                OBJ.setTotal_votos_no_voto(rs.getInt("total_votos_no_voto"));
                OBJ.setTotal_votos_nulos(rs.getInt("total_votos_nulos"));
                OBJ.setTotal_votos_validos(rs.getInt("total_votos_validos"));
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

    public ArrayList<ClassResultadosBasico> CargarPorDiginidadParroquialPorLista(int iddignidad, int idparroquia) {
        ArrayList<ClassResultadosBasico> lista = new ArrayList<ClassResultadosBasico>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select di.nombre_dignidad,ca.nombre,org.lista,org.color,org.nombre_organizacion,org.siglas,org.idorganizacion,"
                    + " sum(num_votos) as total_votos, sum(ac.num_validos) as total_votos_validos,"
                    + " sum(ac.num_no_voto) as total_votos_no_voto ,sum(ac.num_blancos) as total_votos_blancos"
                    + " ,sum(ac.num_nulos) as total_votos_nulos"
                    + " from  acta_detalle as ad"
                    + " inner join acta as ac on ad.fr_id_acta=ac.idacta"
                    + " inner join dignidad as di on ac.fr_id_dignidad = di.iddignidad"
                    + " inner join candidato as ca on ad.fr_id_candidato=ca.idcandidato "
                    + " inner join organizacion as org on org.idorganizacion=ca.fr_id_organizacion "
                    + " inner join junta as ju on ju.idjunta=ac.fr_id_junta"
                    + " inner join zonas as z on z.idzonas=ac.cod_zona"
                    + " inner join parroquias as pa on ac.cod_parroquia=pa.cod_parroquia"
                    + " inner join cantones as cn on cn.cod_canton=pa.cod_canton"
                    + " where di.iddignidad=" + iddignidad + " and pa.cod_parroquia=" + idparroquia
                    + " group by org.idorganizacion order by org.orden asc;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosBasico OBJ = new ClassResultadosBasico();
                OBJ.setNombre(rs.getString("nombre"));
                OBJ.setColor(rs.getString("color"));
                OBJ.setListas(rs.getString("lista"));
                OBJ.setSiglas(rs.getString("siglas"));
                OBJ.setIdorganizacion(rs.getInt("idorganizacion"));
                OBJ.setNombre_organizacion(rs.getString("nombre_organizacion"));
                OBJ.setNombre_dignidad(rs.getString("nombre_dignidad"));
                OBJ.setTotal_votos(rs.getInt("total_votos"));
                OBJ.setTotal_votos_blancos(rs.getInt("total_votos_blancos"));
                OBJ.setTotal_votos_no_voto(rs.getInt("total_votos_no_voto"));
                OBJ.setTotal_votos_nulos(rs.getInt("total_votos_nulos"));
                OBJ.setTotal_votos_validos(rs.getInt("total_votos_validos"));
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

    public ArrayList<ClassResultadosAvanceEscrutinio> CargarAvanceEscrutinioActas() {
        ArrayList<ClassResultadosAvanceEscrutinio> lista = new ArrayList<ClassResultadosAvanceEscrutinio>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select *, COALESCE(( "
                    + "SELECT count(ca.cod_canton) "
                    + "FROM acta as ac "
                    + "left join cantones as ca on ac.cod_canton=ca.cod_canton  "
                    + "left join dignidad as di on di.iddignidad=ac.fr_id_dignidad "
                    + "where ca.cod_canton=c.cod_canton and di.iddignidad=d.iddignidad "
                    + "group by ca.cod_canton,di.iddignidad "
                    + "),0) as ingresadas, "
                    + "(select count(*) from junta as j  "
                    + "inner join zonas as z on j.fr_id_zona=z.idzonas "
                    + "inner join parroquias as p on p.cod_parroquia=z.cod_parroquia "
                    + "inner join cantones as ca on ca.cod_canton=p.cod_canton "
                    + "where ca.cod_canton=c.cod_canton) as total  "
                    + "from cantones as c, dignidad as d "
                    + "where c.cod_canton<>3";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosAvanceEscrutinio OBJ = new ClassResultadosAvanceEscrutinio();
                OBJ.setCod_canton(rs.getInt("cod_canton"));
                OBJ.setFr_id_canton_pertenece(rs.getInt("fr_id_canton_pertenece"));
                OBJ.setIddignidad(rs.getInt("iddignidad"));
                OBJ.setIngresadas(rs.getInt("ingresadas"));
                OBJ.setNombre_canton(rs.getString("nombre_canton"));
                OBJ.setNombre_dignidad(rs.getString("nombre_dignidad"));
                OBJ.setTotal(rs.getInt("total"));
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

    public ArrayList<ClassResultadosAvanceEscrutinio> CargarAvanceEscrutinioActasOrdenadoDignidad() {
        ArrayList<ClassResultadosAvanceEscrutinio> lista = new ArrayList<ClassResultadosAvanceEscrutinio>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select *, COALESCE(( "
                    + "SELECT count(ca.cod_canton) "
                    + "FROM acta as ac "
                    + "left join cantones as ca on ac.cod_canton=ca.cod_canton  "
                    + "left join dignidad as di on di.iddignidad=ac.fr_id_dignidad "
                    + "where ca.cod_canton=c.cod_canton and di.iddignidad=d.iddignidad "
                    + "group by ca.cod_canton,di.iddignidad "
                    + "),0) as ingresadas, "
                    + "(select count(*) from junta as j  "
                    + "inner join zonas as z on j.fr_id_zona=z.idzonas "
                    + "inner join parroquias as p on p.cod_parroquia=z.cod_parroquia "
                    + "inner join cantones as ca on ca.cod_canton=p.cod_canton "
                    + "where ca.cod_canton=c.cod_canton) as total  "
                    + "from cantones as c, dignidad as d "
                    + "where c.cod_canton<>3 "
                    + "order by iddignidad, cod_canton";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosAvanceEscrutinio OBJ = new ClassResultadosAvanceEscrutinio();
                OBJ.setCod_canton(rs.getInt("cod_canton"));
                OBJ.setFr_id_canton_pertenece(rs.getInt("fr_id_canton_pertenece"));
                OBJ.setIddignidad(rs.getInt("iddignidad"));
                OBJ.setNombre_dignidad(rs.getString("nombre_dignidad"));
                OBJ.setIngresadas(rs.getInt("ingresadas"));
                OBJ.setNombre_canton(rs.getString("nombre_canton"));
                OBJ.setTotal(rs.getInt("total"));
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

    public ArrayList<ClassResultadosAvanceEscrutinio> CargarAvanceEscrutinioActasCanton() {
        ArrayList<ClassResultadosAvanceEscrutinio> lista = new ArrayList<ClassResultadosAvanceEscrutinio>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select *, COALESCE(( "
                    + "SELECT count(ca.cod_canton) "
                    + "FROM acta as ac  "
                    + "left join cantones as ca on ac.cod_canton=ca.cod_canton  "
                    + "left join dignidad as di on di.iddignidad=ac.fr_id_dignidad "
                    + "where ca.cod_canton=c.cod_canton "
                    + "group by ca.cod_canton "
                    + "),0) as ingresadas, "
                    + "(select count(*) from junta as j  "
                    + "inner join zonas as z on j.fr_id_zona=z.idzonas "
                    + "inner join parroquias as p on p.cod_parroquia=z.cod_parroquia "
                    + "inner join cantones as ca on ca.cod_canton=p.cod_canton "
                    + "where ca.cod_canton=c.cod_canton) as total "
                    + "from cantones as c "
                    + "where c.cod_canton<>3;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosAvanceEscrutinio OBJ = new ClassResultadosAvanceEscrutinio();
                OBJ.setCod_canton(rs.getInt("cod_canton"));
                OBJ.setFr_id_canton_pertenece(rs.getInt("fr_id_canton_pertenece"));
                OBJ.setIngresadas(rs.getInt("ingresadas"));
                OBJ.setNombre_canton(rs.getString("nombre_canton"));
                OBJ.setTotal(rs.getInt("total"));
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

    public ArrayList<ClassResultadosAvanceEscrutinio> CargarAvanceDigninades() {
        ArrayList<ClassResultadosAvanceEscrutinio> lista = new ArrayList<ClassResultadosAvanceEscrutinio>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select *, COALESCE(( "
                    + "SELECT count(di.iddignidad) "
                    + "FROM acta as ac  "
                    + "left join cantones as ca on ac.cod_canton=ca.cod_canton  "
                    + "left join dignidad as di on di.iddignidad=ac.fr_id_dignidad "
                    + "where di.iddignidad=d.iddignidad "
                    + "group by di.iddignidad "
                    + "),0) as ingresadas "
                    + "from dignidad as d;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosAvanceEscrutinio OBJ = new ClassResultadosAvanceEscrutinio();
                OBJ.setIddignidad(rs.getInt("iddignidad"));
                OBJ.setNombre_dignidad(rs.getString("nombre_dignidad"));
                OBJ.setIngresadas(rs.getInt("ingresadas"));
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

    public ArrayList<ClassResultadosAvanceEscrutinio> CargarAvanceASignacionResponsableJunta() {
        ArrayList<ClassResultadosAvanceEscrutinio> lista = new ArrayList<ClassResultadosAvanceEscrutinio>();
        Connection con = null;
        try {
            con = conexion.getConexion();
            String sql = "select *, COALESCE(( "
                    + "SELECT count(j.idjunta) "
                    + "FROM junta as j  "
                    + "inner join zonas as z on j.fr_id_zona=z.idzonas "
                    + "inner join parroquias as p on p.cod_parroquia=z.cod_parroquia "
                    + "inner join cantones as ca on ca.cod_canton=p.cod_canton "
                    + "where ca.cod_canton=c.cod_canton and j.responsable is not null "
                    + "group by ca.cod_canton "
                    + "),0) as con_responsable, "
                    + "(select count(*) from junta as j  "
                    + "inner join zonas as z on j.fr_id_zona=z.idzonas "
                    + "inner join parroquias as p on p.cod_parroquia=z.cod_parroquia "
                    + "inner join cantones as ca on ca.cod_canton=p.cod_canton "
                    + "where ca.cod_canton=c.cod_canton) as total  "
                    + "from cantones as c "
                    + "where c.cod_canton<>3 "
                    + "order by cod_canton;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //System.out.print(sql);
            while (rs.next()) {
                ClassResultadosAvanceEscrutinio OBJ = new ClassResultadosAvanceEscrutinio();
                OBJ.setCod_canton(rs.getInt("cod_canton"));
                OBJ.setNombre_canton(rs.getString("nombre_canton"));
                OBJ.setCon_responsable(rs.getInt("con_responsable"));
                OBJ.setTotal(rs.getInt("total"));
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

}
