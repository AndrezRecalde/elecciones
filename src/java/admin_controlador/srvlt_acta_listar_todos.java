package admin_controlador;

import admin.CaccesosDB;
import herramientas.conexion;
import admin.Cacta;
import admin.CactaDB;
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
public class srvlt_acta_listar_todos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            ArrayList<Cacta> lista = new ArrayList<Cacta>();
            CactaDB OBJDB = new CactaDB();

            int id_usuario_session = Integer.parseInt(session.getAttribute("idusuario").toString());
            CaccesosDB CAU = new CaccesosDB();

            String tit = "Actas con novedades";
            if (request.getParameter("op").equals("inc")) {
                CAU.Ingresar(id_usuario_session, 9);
                lista = OBJDB.Cargar_Todos_Inconsistentes();
            }
            if (request.getParameter("op").equals("tod")) {
                CAU.Ingresar(id_usuario_session, 10);
                tit = "Actas Ingresadas";
                lista = OBJDB.Cargar_Todos();
            }
            session.setAttribute("lista_acta", lista);
            response.sendRedirect("acta_listar_todos.jsp?tit=" + tit + "&op=" + request.getParameter("op"));
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
