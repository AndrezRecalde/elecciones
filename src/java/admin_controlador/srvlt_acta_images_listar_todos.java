package admin_controlador;

import herramientas.conexion;
import admin.Cacta_images;
import admin.Cacta_imagesDB;
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
public class srvlt_acta_images_listar_todos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            ArrayList<Cacta_images> lista = new ArrayList<Cacta_images>();
            Cacta_imagesDB OBJDB = new Cacta_imagesDB();

            if (request.getParameter("op").equals("todos")) {
                lista = OBJDB.Cargar_Todos();
                session.setAttribute("lista_acta_images", lista);
                response.sendRedirect("acta_images_listar_todos.jsp");

            } else {
                int id_junta = Integer.parseInt(request.getParameter("id_junta"));
                int id_dignidad = Integer.parseInt(request.getParameter("id_dignidad"));
                lista = OBJDB.Cargar_Activas(id_junta, id_dignidad);
                session.setAttribute("lista_acta_images_junta_dignidad", lista);
                response.sendRedirect("dig_actas_dignidad_junta_digitar.jsp");
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
