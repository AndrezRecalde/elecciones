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
public class webster extends HttpServlet {

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
            
            String nombre_reporte = "";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            actaDB acDB = new actaDB();
            HttpSession session = request.getSession(true);

            int id_usuario_session = Integer.parseInt(session.getAttribute("idusuario").toString());
            CaccesosDB CAU = new CaccesosDB();
            CAU.Ingresar(id_usuario_session, 16);
            
            String tipo_eleccion = ""; //unipersonal, pluripersonal
            String dignidad_string = "";
            int total_actas = 0;
            int total_actas_ingresadas = 0;

            CusuarioDB usuDB = new CusuarioDB();
            Cusuario usu_edi = new Cusuario();
            usu_edi = usuDB.Seleccionar_Id(Integer.parseInt(session.getAttribute("idusuario").toString()));
            

            if (dignidad == 2) {
                nombre_reporte = "asambleista_webster" + sdf.format(new Date());
                listado = resDB.CargarBasicoProvincialEscanio(dignidad, 1);
                total_actas = acDB.TotalJuntasProvincia();
                total_actas_ingresadas = acDB.TotalActas(dignidad);
                dignidad_string = "REPARTICIÓN DE ESCAÑOS - MÉTODO WEBSTER";
                tipo_eleccion = "unipersonal";
            }

            if (listado.isEmpty()) {
                response.sendRedirect("mensaje.jsp?men=Aun no tenemos datos del informe seleccionado.");
                return;
            }

            String tipo="jsp";
            
            if (tipo.equals("jsp")) {
                session.setAttribute("resultados_webster", listado);
                response.sendRedirect("webster.jsp?tipo_eleccion=" + tipo_eleccion + "&dignidad_string=" +  URLEncoder.encode(dignidad_string,"utf-8") + "&tipo=" + tipo + "&total_votos=" + 0 + "&total_actas_ingresadas=" + total_actas_ingresadas + "&total_actas=" + total_actas + "&total_actas_faltantes=" + (total_actas - total_actas_ingresadas));
                return;
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
