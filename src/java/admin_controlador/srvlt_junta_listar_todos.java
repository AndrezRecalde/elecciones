package admin_controlador;

import admin.CaccesosDB;
import herramientas.conexion;
import admin.Cjunta;
import admin.CjuntaDB;
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
public class srvlt_junta_listar_todos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            ArrayList<Cjunta> lista = new ArrayList<Cjunta>();
            CjuntaDB OBJDB = new CjuntaDB();
            lista = OBJDB.Cargar_Todos();

            int id_usuario_session = Integer.parseInt(session.getAttribute("idusuario").toString());
            CaccesosDB CAU = new CaccesosDB();
            CAU.Ingresar(id_usuario_session, 4);

            session.setAttribute("lista_junta", lista);
            response.sendRedirect("junta_listar_todos.jsp");
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
