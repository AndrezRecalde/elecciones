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
@WebServlet(name = "Provincia", urlPatterns = {"/Provincia"})
public class Provincia extends HttpServlet {
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
           //acceder al metodo buscaPaises              
            HttpSession session_actual=request.getSession(true);
            ArrayList Provincias = null;
            if(session_actual.getAttribute("provincias")==null){
                Provincias = Consultar.buscaProvincias();
                session_actual.setAttribute("provincias", Provincias);
            }else{
                Provincias=(ArrayList) session_actual.getAttribute("provincias");
            }
            if (Provincias.size() != 0) {
                lista = "\"" + "Provincias" + "\":" + "[";               
                for (int x = 0; x < Provincias.size(); x=x+2) {
                    lista += "{" + "\"" + "id" + "\"" + ":"  + Provincias.get(x).toString() +  "," +
                            "\"" + "nombre" + "\"" + ":" + " \"" + Provincias.get(x+1) + "\"" + "}" + ",";
                        //formar la cadena en formato JSON para enviarlo a la vista con jquery
                    }
                //quitar la ultima coma para parsear la cadena JSON
                lista = lista.substring(0, lista.length() - 1);
            } else {
                out.println("No se logro obtener datos");
            }
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