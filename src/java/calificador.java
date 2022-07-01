/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import eleccion.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@WebServlet(name = "calificador", urlPatterns = {"/calificador"})
public class calificador extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
        HttpSession session_actual = request.getSession(true);
        try {
            int iddignidad = 0, idprovincia = 0, idcanton = 0, idparroquia = 0, idzona = 0,
                    idjunta = 0, cne_cod_acta = 0, num_validos = 0, num_no_voto = 0, num_blancos = 0, num_nulos = 0, idusuario = 0;
            String dignidad = "", provincia = "", canton = "", parroquia = "", zona = "", junta = "";
            boolean cuadrada = false, legible = false, se_esta_modificando_acta = false, error = false;
            iddignidad = Integer.parseInt(request.getParameter("iddignidad").toString());
            dignidad = request.getParameter("dignidad").toString();
            idprovincia = Integer.parseInt(request.getParameter("idprovincia").toString());
            provincia = request.getParameter("provincia").toString();
            idcanton = Integer.parseInt(request.getParameter("idcanton").toString());
            canton = request.getParameter("canton").toString();
            idparroquia = Integer.parseInt(request.getParameter("idparroquia").toString());
            parroquia = request.getParameter("parroquia").toString();
            idzona = Integer.parseInt(request.getParameter("idzona").toString());
            zona = request.getParameter("zona").toString();
            idjunta = Integer.parseInt(request.getParameter("idjunta").toString());
            junta = request.getParameter("junta").toString();
            if (!request.getParameter("txt_cne_cod_acta").equals("")) {
                cne_cod_acta = Integer.parseInt(request.getParameter("txt_cne_cod_acta").toString());
            } else {
                cne_cod_acta = 0;
            }
            if (!request.getParameter("txt_total_votos").equals("")) {
                num_validos = Integer.parseInt(request.getParameter("txt_total_votos").toString());
            } else {
                num_validos = 0;
            }
            if (!request.getParameter("txt_no_votaron").equals("")) {
                num_no_voto = Integer.parseInt(request.getParameter("txt_no_votaron").toString());
            } else {
                num_no_voto = 0;
            }
            if (!request.getParameter("txt_votos_blanco").equals("")) {
                num_blancos = Integer.parseInt(request.getParameter("txt_votos_blanco").toString());
            } else {
                num_blancos = 0;
            }
            if (!request.getParameter("txt_votos_nulos").equals("")) {
                num_nulos = Integer.parseInt(request.getParameter("txt_votos_nulos").toString());
            } else {
                num_nulos = 0;
            }
            if (!request.getParameter("idusuario").equals("")) {
                idusuario = Integer.parseInt(session_actual.getAttribute("idusuario").toString());
            } else {
                idusuario = -1;
            }
            if (request.getParameter("txt_es_legible") != null) {
                legible = true;
            }
            if (request.getParameter("txt_es_cuadrada") != null) {
                cuadrada = true;
            }

            candidatoDB canDB = new candidatoDB();
            acta_detalleDB acDB = new acta_detalleDB();

            actaDB actaDB = new actaDB();
            int idacta = -1;
            //if (request.getParameter("Aceptar") != null) {
            //    if (request.getParameter("Aceptar").toString().contains("Modificar")) {

            if (request.getParameter("idacta") != null) {
                se_esta_modificando_acta = true;
                try{
                    idacta = Integer.parseInt(request.getParameter("idacta").toString());
                }catch(Exception e){
                    error=true;
                }
                if (!actaDB.EliminarActaId(idacta)) {
                    error = true;
                }
            }
            //    }
            //}
            if (!error) {
                idacta = actaDB.IngresarActaJuntaDignidad(iddignidad, idprovincia, idcanton, idparroquia, idzona, idjunta, cne_cod_acta, num_validos, num_no_voto,
                        num_blancos, num_nulos, idusuario, cuadrada, legible, 1);
                if (idacta > 0) {
                    List<candidato> listaCandidatos = null;
                    //Todos los candidatos son Provinciales
                    if (iddignidad == 1) {
                        listaCandidatos = canDB.CargarxDignidadProvincial(iddignidad, idprovincia);
                    }
                    if (iddignidad == 2) {
                        /*cantonesDB cantDB = new cantonesDB();
                        listaCandidatos = canDB.CargarxDignidadCantonal(iddignidad, cantDB.CargarIdCantonPadre(idcanton));*/
                        listaCandidatos = canDB.CargarxDignidadProvincial(iddignidad, idprovincia);
                    }
                    if (iddignidad == 3) {
                        /*listaCandidatos = canDB.CargarxDignidadCantonal(iddignidad, idcanton);*/
                        listaCandidatos = canDB.CargarxDignidadProvincial(iddignidad, idprovincia);
                    }
                    if (iddignidad == 4) {
                        /*
                        listaCandidatos = canDB.CargarxDignidadCantonal(iddignidad, idcanton);*/
                        listaCandidatos = canDB.CargarxDignidadProvincial(iddignidad, idprovincia);
                    }
                    /*
                    if (iddignidad == 5) {
                        listaCandidatos = canDB.CargarxDignidadParroquia(iddignidad, idparroquia);
                    }
                    if (iddignidad == 6 || iddignidad == 7 || iddignidad == 8) {
                        listaCandidatos = canDB.CargarxDignidadProvincial(iddignidad, idprovincia);
                    }*/
                    for (candidato c : listaCandidatos) {
                        String votos = request.getParameter(Integer.toString(c.getIdcandidato()));
                        int v = 0;
                        try {
                            v = Integer.parseInt(votos);
                        } catch (Exception e) {
                            v=0;
                        }
                        acDB.CalificarActaCandidato(idacta, c.getIdcandidato(), v);
                    }
                    //response.sendRedirect("dig_actas_dignidad.jsp?men=Acta de <b>" + dignidad + "</b> : <br> " + provincia + "/" + canton + "/" + parroquia + "/" + zona + "/JUNTA: " + junta + "<br><b>Ha sido ingresada con exito.</b>");
                    response.sendRedirect("dig_actas_dignidad_junta_ver.jsp?iddignidad="+iddignidad+"&ver=edit&idjunta="+idjunta+"&men=Acta de <b>" + dignidad + "</b> : <br> " + provincia + "/" + canton + "/" + parroquia + "/" + zona + "/JUNTA: " + junta + "<br><b>Ha sido ingresada con exito.</b>");
                    return;
                } else {
                    response.sendRedirect("error.jsp?men=Notifique al administrador esta acta: " + dignidad + ": " + provincia + "/" + canton + "/" + parroquia + "/" + zona + "/" + junta + " ingresada pero con problemas.");
                    return;
                }
            } else {
                response.sendRedirect("error.jsp?men=No se pudo modificar el acta.");
                return;
            }
        } catch (Exception e) {
            response.sendRedirect("error.jsp?men=Error." + e.toString());
            return;
        } finally {
            out.close();
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
