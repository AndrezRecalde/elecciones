/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import admin.CaccesosDB;
import admin.Ccantones;
import admin.CcantonesDB;
import admin.Cusuario;
import admin.CusuarioDB;
import eleccion.ClassResultadosAvanceEscrutinio;
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
public class EstadoActasResumenSrlvt extends HttpServlet {

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
            HttpSession session = request.getSession(true);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            session.setAttribute("fecha_reporte", sdf.format(new Date()));

            ClassResultadosBD resDB = new ClassResultadosBD();
            int id_usuario_session = Integer.parseInt(session.getAttribute("idusuario").toString());
            CaccesosDB CAU = new CaccesosDB();

            if (request.getParameter("op").equals("avance_escrutinio")) {

                CAU.Ingresar(id_usuario_session, 6);

                ArrayList<ClassResultadosAvanceEscrutinio> listado_avance = new ArrayList<ClassResultadosAvanceEscrutinio>();
                ArrayList<ClassResultadosAvanceEscrutinio> listado_avance_canton = new ArrayList<ClassResultadosAvanceEscrutinio>();
                ArrayList<ClassResultadosAvanceEscrutinio> listado_avance_canton_orden_dignidad = new ArrayList<ClassResultadosAvanceEscrutinio>();
                ArrayList<ClassResultadosAvanceEscrutinio> listado_avance_dignidades = new ArrayList<ClassResultadosAvanceEscrutinio>();

                listado_avance = resDB.CargarAvanceEscrutinioActas();
                listado_avance_canton = resDB.CargarAvanceEscrutinioActasCanton();
                listado_avance_canton_orden_dignidad = resDB.CargarAvanceEscrutinioActasOrdenadoDignidad();
                listado_avance_dignidades = resDB.CargarAvanceDigninades();

                session.setAttribute("listado_avance", listado_avance);
                session.setAttribute("listado_avance_canton", listado_avance_canton);
                session.setAttribute("listado_avance_canton_orden_dignidad", listado_avance_canton_orden_dignidad);
                session.setAttribute("listado_avance_dignidades", listado_avance_dignidades);

                response.sendRedirect("rep_resultados_avance_escrutinio.jsp");
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
