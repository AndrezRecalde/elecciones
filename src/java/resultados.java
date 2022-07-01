/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import admin.CaccesosDB;
import admin.Ccantones;
import admin.CcantonesDB;
import admin.Cusuario;
import admin.CusuarioDB;
import eleccion.ClassResultadosBD;
import eleccion.ClassResultadosBasico;
import eleccion.actaDB;
import eleccion.cantones;
import eleccion.cantonesDB;
import eleccion.parroquias;
import eleccion.parroquiasDB;
import eleccion.recintos;
import eleccion.recintosDB;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
public class resultados extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            
            ArrayList<ClassResultadosBasico> listado = new ArrayList<ClassResultadosBasico>();
            ArrayList<ClassResultadosBasico> listadoporlista = new ArrayList<ClassResultadosBasico>();
            ClassResultadosBD resDB = new ClassResultadosBD();
            int dignidad = Integer.parseInt(request.getParameter("iddignidad").toString());
            int idcanton = Integer.parseInt(request.getParameter("idcanton").toString());
            int idcanton_padre = 0;
            int idparroquia = Integer.parseInt(request.getParameter("idparroquia").toString());
            int idrecinto = Integer.parseInt(request.getParameter("idrecinto").toString());
            String nombre_reporte = "";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            actaDB acDB = new actaDB();
            HttpSession session = request.getSession(true);

            int id_usuario_session = Integer.parseInt(session.getAttribute("idusuario").toString());
            CaccesosDB CAU = new CaccesosDB();
            CAU.Ingresar(id_usuario_session, 8);
            
            String tipo = "";
            String nivel_territorio = "";

            if (request.getParameter("nivel_territorio_prov_jsp") != null) {
                tipo = "jsp";
                nivel_territorio = "provincial";
            }
            if (request.getParameter("nivel_territorio_prov_xls") != null) {
                tipo = "xls";
                nivel_territorio = "provincial";
            }
            if (request.getParameter("nivel_territorio_cant_jsp") != null) {
                tipo = "jsp";
                nivel_territorio = "cantonal";
            }
            if (request.getParameter("nivel_territorio_cant_xls") != null) {
                tipo = "xls";
                nivel_territorio = "cantonal";
            }
            if (request.getParameter("nivel_territorio_parr_jsp") != null) {
                tipo = "jsp";
                nivel_territorio = "parroquial";
            }
            if (request.getParameter("nivel_territorio_parr_xls") != null) {
                tipo = "xls";
                nivel_territorio = "parroquial";
            }
            if (request.getParameter("nivel_territorio_recinto_jsp") != null) {
                tipo = "jsp";
                nivel_territorio = "recinto";
            }
            if (request.getParameter("nivel_territorio_recinto_xls") != null) {
                tipo = "xls";
                nivel_territorio = "recinto";
            }
            cantonesDB cantDB = new cantonesDB();
            parroquiasDB parrDB = new parroquiasDB();
            recintosDB recDB = new recintosDB();
            cantones OBJcan = new cantones();
            cantones OBJcanPadre = new cantones();
            parroquias OBJparr = new parroquias();
            recintos OBJrecinto = new recintos();

            String tipo_eleccion = ""; //unipersonal, pluripersonal
            String dignidad_string = "";
            int total_actas = 0;
            int total_actas_ingresadas = 0;

            CusuarioDB usuDB = new CusuarioDB();
            Cusuario usu_edi = new Cusuario();
            usu_edi = usuDB.Seleccionar_Id(Integer.parseInt(session.getAttribute("idusuario").toString()));
            CcantonesDB canDB = new CcantonesDB();
            Ccantones can = new Ccantones();

            /*  1 PREFECTO Y VICEPREFECTO
                2 ALCALDES MUNICIPALES
                3 CONCEJALES URBANOS 
                4 CONCEJALES RURALES
                5 VOCALES DE JUNTAS PARROQUIALES
                6 CPCCS */
            if (dignidad == -1) {
                response.sendRedirect("mensaje.jsp?men=Por favor seleeciona una dignidad.");
                return;
            }
            if (dignidad == 1) {
                if (nivel_territorio.equals("provincial")) {
                    nombre_reporte = "presidente_nivel_provincial_" + sdf.format(new Date());
                    listado = resDB.CargarBasicoProvincial(dignidad, 1);
                    total_actas = acDB.TotalJuntasProvincia();
                    total_actas_ingresadas = acDB.TotalActas(dignidad);
                    dignidad_string = "PRESIDENTE Y VICEPRESIDENTE A NIVEL PROVINCIAL";
                }
                if (nivel_territorio.equals("cantonal")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJcan = cantDB.CargarCantonId(idcanton);
                    nombre_reporte = "presidente_nivel_cantonal_" + sdf.format(new Date());
                    listado = resDB.CargarPorDignidadCantonal(dignidad, idcanton);
                    total_actas = acDB.TotalJuntasCanton(idcanton);
                    total_actas_ingresadas = acDB.TotalActasIngresadasCanton(dignidad, idcanton);
                    dignidad_string = "PRESIDENTE Y VICEPRESIDENTE A NIVEL CANTONAL-" + OBJcan.getNombre_canton();
                }
                if (nivel_territorio.equals("parroquial")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJparr = parrDB.CargarParroquiaId(idparroquia);
                    nombre_reporte = "presidente_nivel_parroquial_" + sdf.format(new Date());
                    listado = resDB.CargarPorDiginidadParroquial(dignidad, idparroquia);
                    total_actas = acDB.TotalJuntasParroquia(idparroquia);
                    total_actas_ingresadas = acDB.TotalActasIngresadasParroquia(dignidad, idparroquia);
                    dignidad_string = "PRESIDENTE Y VICEPRESIDENTE A NIVEL PARROQUIAL-" + OBJparr.getNombre_parroquia();
                }
                if (nivel_territorio.equals("recinto")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJrecinto = recDB.CargarRecintoId(idrecinto);
                    nombre_reporte = "presidente_nivel_recinto_" + sdf.format(new Date());
                    listado = resDB.CargarPorDiginidadRecinto(dignidad, idrecinto);
                    total_actas = acDB.TotalJuntasRecinto(idrecinto);
                    total_actas_ingresadas = acDB.TotalActasIngresadasRecinto(dignidad, idparroquia);
                    dignidad_string = "PRESIDENTE Y VICEPRESIDENTE A NIVEL RECINTO-" + OBJrecinto.getNombre_recinto();
                }
                tipo_eleccion = "unipersonal";
            }
            if (dignidad == 2) { //ASAMBLEISTA PROVINCIAL
                if (nivel_territorio.equals("provincial")) {
                    nombre_reporte = "asamb_prov_nivel_provincial_" + sdf.format(new Date());
                    listado = resDB.CargarBasicoProvincial(dignidad, 1);
                    total_actas = acDB.TotalJuntasProvincia();
                    total_actas_ingresadas = acDB.TotalActas(dignidad);
                    dignidad_string = "ASAMBLEISTA PROVINCIAL A NIVEL PROVINCIAL";
                }
                if (nivel_territorio.equals("cantonal")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJcanPadre = cantDB.CargarCantonId(cantDB.CargarIdCantonPadre(idcanton));
                    idcanton_padre = OBJcanPadre.getCod_canton();
                    nombre_reporte = "asamb_prov_nivel_cantonal_" + sdf.format(new Date());
                    listado = resDB.CargarPorDignidadCantonalPadre(dignidad, idcanton_padre);
                    total_actas = acDB.TotalJuntasCantonPadre(idcanton_padre);
                    total_actas_ingresadas = acDB.TotalActasIngresadasPadreCanton(dignidad, idcanton_padre);
                    dignidad_string = "ASAMBLEISTA PROVINCIAL NIVEL CANTONAL-" + OBJcanPadre.getNombre_canton();
                }
                if (nivel_territorio.equals("parroquial")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJparr = parrDB.CargarParroquiaId(idparroquia);
                    nombre_reporte = "asambleista_nivel_parroquial_" + sdf.format(new Date());
                    listado = resDB.CargarPorDiginidadParroquial(dignidad, idparroquia);
                    total_actas = acDB.TotalJuntasParroquia(idparroquia);
                    total_actas_ingresadas = acDB.TotalActasIngresadasParroquia(dignidad, idparroquia);
                    dignidad_string = "ASAMBLEISTA PROVINCIAL A NIVEL PARROQUIAL-" + OBJparr.getNombre_parroquia();
                }
                
                if (nivel_territorio.equals("recinto")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJrecinto = recDB.CargarRecintoId(idrecinto);
                    nombre_reporte = "asambleista_nivel_recinto_" + sdf.format(new Date());
                    listado = resDB.CargarPorDiginidadRecinto(dignidad, idrecinto);
                    total_actas = acDB.TotalJuntasRecinto(idrecinto);
                    total_actas_ingresadas = acDB.TotalActasIngresadasRecinto(dignidad, idparroquia);
                    dignidad_string = "ASAMBLEISTA PROVINCIAL A NIVEL RECINTO-" + OBJrecinto.getNombre_recinto();
                }
                tipo_eleccion = "unipersonal";
            }
            if (dignidad == 3) { //Urbanos
                if (nivel_territorio.equals("provincial")) {
                    //No hay resultados provinciales para alcaldes
                    nombre_reporte = "NA_urbanos_nivel_provincial_" + sdf.format(new Date());
                }
                if (nivel_territorio.equals("cantonal")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJcan = cantDB.CargarCantonId(idcanton);
                    nombre_reporte = "urbanos_nivel_cantonal_" + sdf.format(new Date());
                    listado = resDB.CargarPorDignidadCantonal(dignidad, idcanton);
                    listadoporlista = resDB.CargarPorDignidadCantonalPorLista(dignidad, idcanton);//por litas
                    total_actas = acDB.TotalJuntasCanton(idcanton);
                    total_actas_ingresadas = acDB.TotalActasIngresadasCanton(dignidad, idcanton);
                    dignidad_string = "CONCEJALES URBANOS A NIVEL CANTONAL-" + OBJcan.getNombre_canton();
                }
                if (nivel_territorio.equals("parroquial")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJparr = parrDB.CargarParroquiaId(idparroquia);
                    nombre_reporte = "urbanos_nivel_parroquial_" + sdf.format(new Date());
                    listado = resDB.CargarPorDiginidadParroquial(dignidad, idparroquia);
                    listadoporlista = resDB.CargarPorDiginidadParroquialPorLista(dignidad, idparroquia);//por litas
                    total_actas = acDB.TotalJuntasParroquia(idparroquia);
                    total_actas_ingresadas = acDB.TotalActasIngresadasParroquia(dignidad, idparroquia);
                    dignidad_string = "CONCEJALES URBANOS A NIVEL PARROQUIAL-" + OBJparr.getNombre_parroquia();
                }
                tipo_eleccion = "pluripersonal";
                //Al ser pluripersonal cargo listadoporlista
            }
            if (dignidad == 4) { //Rurales
                if (nivel_territorio.equals("provincial")) {
                    //No hay resultados provinciales para alcaldes
                    nombre_reporte = "NA_rurales_nivel_provincial_" + sdf.format(new Date());
                }
                if (nivel_territorio.equals("cantonal")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJcan = cantDB.CargarCantonId(idcanton);
                    nombre_reporte = "rurales_nivel_cantonal_" + sdf.format(new Date());
                    listado = resDB.CargarPorDignidadCantonal(dignidad, idcanton);
                    listadoporlista = resDB.CargarPorDignidadCantonalPorLista(dignidad, idcanton);//por litas
                    total_actas = acDB.TotalJuntasCanton(idcanton);
                    total_actas_ingresadas = acDB.TotalActasIngresadasCanton(dignidad, idcanton);
                    dignidad_string = "CONCEJALES RURALES A NIVEL CANTONAL-" + OBJcan.getNombre_canton();
                }
                if (nivel_territorio.equals("parroquial")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJparr = parrDB.CargarParroquiaId(idparroquia);
                    nombre_reporte = "rurales_nivel_parroquial_" + sdf.format(new Date());
                    listado = resDB.CargarPorDiginidadParroquial(dignidad, idparroquia);
                    listadoporlista = resDB.CargarPorDiginidadParroquialPorLista(dignidad, idparroquia);//por litas
                    total_actas = acDB.TotalJuntasParroquia(idparroquia);
                    total_actas_ingresadas = acDB.TotalActasIngresadasParroquia(dignidad, idparroquia);
                    dignidad_string = "CONCEJALES RURALES A NIVEL PARROQUIAL-" + OBJparr.getNombre_parroquia();
                }
                tipo_eleccion = "pluripersonal";
            }
            /*
            if (dignidad == 5) { //Vocales de Juntas Parroquiales
                if (nivel_territorio.equals("provincial")) {
                    //No hay resultados provinciales para alcaldes
                    nombre_reporte = "NA_vocales_nivel_provincial_" + sdf.format(new Date());
                }
                if (nivel_territorio.equals("cantonal")) {
                    nombre_reporte = "NA_vocales_nivel_cantonal_" + sdf.format(new Date());
                }
                if (nivel_territorio.equals("parroquial")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJparr = parrDB.CargarParroquiaId(idparroquia);
                    nombre_reporte = "rurales_nivel_parroquial_" + sdf.format(new Date());
                    listado = resDB.CargarPorDiginidadParroquial(dignidad, idparroquia);
                    listadoporlista = resDB.CargarPorDiginidadParroquialPorLista(dignidad, idparroquia);//por litas
                    total_actas = acDB.TotalJuntasParroquia(idparroquia);
                    total_actas_ingresadas = acDB.TotalActasIngresadasParroquia(dignidad, idparroquia);
                    dignidad_string = "VOCALES DE JUNTAS PARROQUIALES A NIVEL PARROQUIAL-" + OBJparr.getNombre_parroquia();
                }
                tipo_eleccion = "pluripersonal";
            }
            if (dignidad == 6 || dignidad == 7 || dignidad == 8) {
                if (nivel_territorio.equals("provincial")) {
                    nombre_reporte = "cpccs_nivel_provincial_" + sdf.format(new Date());
                    listado = resDB.CargarBasicoProvincial(dignidad, 1);
                    total_actas = acDB.TotalJuntasProvincia();
                    total_actas_ingresadas = acDB.TotalActas(dignidad);
                    dignidad_string = "CPCCS A NIVEL PROVINCIAL";
                }
                if (nivel_territorio.equals("cantonal")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJcan = cantDB.CargarCantonId(idcanton);
                    nombre_reporte = "cpccs_nivel_cantonal_" + sdf.format(new Date());
                    listado = resDB.CargarPorDignidadCantonal(dignidad, idcanton);
                    total_actas = acDB.TotalJuntasCanton(idcanton);
                    total_actas_ingresadas = acDB.TotalActasIngresadasCanton(dignidad, idcanton);
                    dignidad_string = "CPCCS A NIVEL CANTONAL-" + OBJcan.getNombre_canton();
                }
                if (nivel_territorio.equals("parroquial")) {

                    if (usu_edi.getes_cantonal()) {
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            response.sendRedirect("mensaje.jsp?men=Por favor seleeciona datos del cantón al que has sido asignado.");
                            return;
                        }
                    }

                    OBJparr = parrDB.CargarParroquiaId(idparroquia);
                    nombre_reporte = "cpccs_nivel_parroquial_" + sdf.format(new Date());
                    listado = resDB.CargarPorDiginidadParroquial(dignidad, idparroquia);
                    total_actas = acDB.TotalJuntasParroquia(idparroquia);
                    total_actas_ingresadas = acDB.TotalActasIngresadasParroquia(dignidad, idparroquia);
                    dignidad_string = "CPCCS A NIVEL PARROQUIAL-" + OBJparr.getNombre_parroquia();
                }
                tipo_eleccion = "unipersonal";
            }*/

            if (listado.isEmpty()) {
                response.sendRedirect("mensaje.jsp?men=Aun no tenemos datos del informe seleccionado.");
                return;
            }

            if (tipo.equals("jsp")) {

                int total_votos = 0;
                for (ClassResultadosBasico r : listado) {
                    total_votos = total_votos + r.getTotal_votos();
                }
                session.setAttribute("lista_chart_basic", listado);
                session.setAttribute("lista_chart_lista", listadoporlista);
                response.sendRedirect("rep_resultados.jsp?tipo_eleccion=" + tipo_eleccion + "&dignidad_string=" + URLEncoder.encode(dignidad_string,"utf-8") + "&tipo=" + tipo + "&total_votos=" + total_votos + "&total_actas_ingresadas=" + total_actas_ingresadas + "&total_actas=" + total_actas + "&total_actas_faltantes=" + (total_actas - total_actas_ingresadas));
                return;

                /*if (dignidad == 1) {
                    if (nivel_territorio.equals("provincial")) {
                        session.setAttribute("lista_chart_basic", listado);
                        response.sendRedirect("rep_resultados.jsp?tipo_eleccion=" + tipo_eleccion + "&dignidad_string=" + dignidad_string + "&tipo=" + tipo);
                        return;
                    }
                    if (nivel_territorio.equals("cantonal")) {
                        session.setAttribute("lista_chart_basic", listado);
                        response.sendRedirect("rep_resultados.jsp?tipo_eleccion=" + tipo_eleccion + "&dignidad_string=" + dignidad_string + "&tipo=" + tipo);
                        return;
                    }
                    if (nivel_territorio.equals("parroquial")) {
                        session.setAttribute("lista_chart_basic", listado);
                        response.sendRedirect("rep_resultados.jsp?tipo_eleccion=" + tipo_eleccion + "&dignidad_string=" + dignidad_string + "&tipo=" + tipo);
                        return;
                    }
                }*/
            }

            if (tipo.equals("xls")) {

                response.setHeader("Content-type", "application/vnd.ms-excel"); //Tipo de fichero.
                response.setHeader("Content-Disposition", "attachment;filename =reportes_" + nombre_reporte + ".xls"); //Configurar cabecera http

                out.write("<table>");
                out.write("<tr>");
                out.write("<td>DIGNIDAD</td>");
                out.write("<td>LISTA</td>");
                out.write("<td>CANDIDATO</td>");
                out.write("<td>TOTAL DE VOTOS</td>");
                out.write("<td>NUM. VOTOS VALIDOS</td>");
                out.write("<td>NUM. NO VOTO.</td>");
                out.write("<td>NUM. VOTOS BLANCOS.</td>");
                out.write("<td>NUM. VOTOS NULOS.</td>");
                out.write("</tr>");
                int total_votos = 0;
                for (ClassResultadosBasico r : listado) {
                    total_votos = total_votos + r.getTotal_votos();
                    out.write("<tr>");
                    out.write("<td>" + r.getNombre_dignidad() + "</td>");
                    out.write("<td>" + r.getListas() + "</td>");
                    out.write("<td>" + r.getNombre() + "</td>");
                    out.write("<td>" + r.getTotal_votos() + "</td>");
                    out.write("<td>" + r.getTotal_votos_validos() + "</td>");
                    out.write("<td>" + r.getTotal_votos_no_voto() + "</td>");
                    out.write("<td>" + r.getTotal_votos_blancos() + "</td>");
                    out.write("<td>" + r.getTotal_votos_nulos() + "</td>");
                    out.write("</tr>");
                }
                out.write("<tr>");
                out.write("<td></td><td></td><td>SUMAN:</td><td>" + total_votos + "</td>");
                out.write("</tr>");
                if (dignidad == 1) {
                    out.write("<tr></tr>");
                    out.write("<tr></tr>");
                    out.write("<tr></tr>");
                    out.write("<tr></tr>");
                    out.write("<tr>");
                    out.write("<td>");
                    out.write("</td>");
                    out.write("<td>ACTAS INGRESADAS</td><td>" + acDB.TotalActas(dignidad) + "</td>");
                    out.write("</tr>");
                    out.write("<tr>");
                    out.write("<td>");
                    out.write("</td>");
                    out.write("<td>ACTAS FALTANTES</td><td>" + (acDB.TotalJuntasProvincia() - acDB.TotalActas(dignidad)) + "</td>");
                    out.write("</tr>");
                    out.write("<tr>");
                    out.write("<td>");
                    out.write("</td>");
                    out.write("<td>ACTAS TOTALES</td><td>" + acDB.TotalJuntasProvincia() + "</td>");
                    out.write("</tr>");
                }
                out.write("</table>");
            }
            out.close();

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
