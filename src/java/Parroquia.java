                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author userver1
 */
@WebServlet(name = "Parroquia", urlPatterns = {"/Parroquia"})
public class Parroquia extends HttpServlet {

    String lista = new String("");

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
        try {
            Consultar Consultar = new Consultar();
            HttpSession session_actual = request.getSession(true);
            ArrayList Parroquias = null;
            if (session_actual.getAttribute("parroquias") == null) {
                Parroquias = Consultar.buscaParroquias();
                session_actual.setAttribute("parroquias", Parroquias);
            } else {
                Parroquias = (ArrayList) session_actual.getAttribute("parroquias");
            }
            //acceder al emtodo buscaCiudades con un parametro que seria el idciudad
            lista = "\"" + "Parroquias" + "\":" + "[";
            for (int x = 0; x < Parroquias.size(); x = x + 3) {
                if (Parroquias.get(x+2).toString().equals(request.getParameter("id").toString())) {
                    lista += "{" + "\"" + "id" + "\"" + ":" + Parroquias.get(x).toString()
                            + "," + "\"" + "nombre" + "\"" + ":" + " \"" + Parroquias.get(x + 1) + "\"" + "}" + ",";
                }
            }
            lista = lista.substring(0, lista.length() - 1);
        } catch (Exception e) {
            System.out.println("Error en servlet de Empleado:");
            e.printStackTrace();
        } finally {
            out.println("{" + lista + "]}");
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
