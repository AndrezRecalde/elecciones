
package admin_controlador;

import herramientas.conexion;
import admin.CObjetoCombo;
import admin.CrecintosDB;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Generador V1.0
 */
public class srvlt_recintos_listar_combo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           HttpSession session= request.getSession(true);
           ArrayList <CObjetoCombo> lista = new ArrayList <CObjetoCombo>();
           CrecintosDB OBJDB = new CrecintosDB();
           lista = OBJDB.Cargar_Combo();
           session.setAttribute("lista_combo_recintos", lista);
           if(request.getParameter("red")!=null){
               response.sendRedirect(request.getParameter("red").toString());
           }else{
               out.println("OK");
           }
        } finally {            
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}