package admin_controlador;

import herramientas.conexion;
import admin.Caccesos;
import admin.CaccesosDB;
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
public class srvlt_accesos_listar_todos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);

            int id_usuario_session = Integer.parseInt(session.getAttribute("idusuario").toString());
            CaccesosDB CAU = new CaccesosDB();

            ArrayList<Caccesos> lista = new ArrayList<Caccesos>();
            CaccesosDB OBJDB = new CaccesosDB();
            int usuario_id = 0;

            if (request.getParameter("op").equals("todos")) {
                lista = OBJDB.Cargar_Todos();
                CAU.Ingresar(id_usuario_session, 15);
            } else {
                usuario_id = Integer.parseInt(request.getParameter("txt_usuario_id"));
                lista = OBJDB.Cargar_Todos(usuario_id);
                CAU.Ingresar(id_usuario_session, 14);
            }
            session.setAttribute("lista_accesos", lista);
            response.sendRedirect("accesos_listar_todos.jsp");
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
