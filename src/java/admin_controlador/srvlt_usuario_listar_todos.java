package admin_controlador;

import admin.CObjetoCombo;
import admin.CaccesosDB;
import admin.CcantonesDB;
import admin.CprovinciaDB;
import admin.Ctipo_usuarioDB;
import herramientas.conexion;
import admin.Cusuario;
import admin.CusuarioDB;
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
public class srvlt_usuario_listar_todos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            
            int id_usuario_session = Integer.parseInt(session.getAttribute("idusuario").toString());
            CaccesosDB CAU = new CaccesosDB();
            CAU.Ingresar(id_usuario_session, 12);
            
            ArrayList<Cusuario> lista = new ArrayList<Cusuario>();
            CusuarioDB OBJDB = new CusuarioDB();
            lista = OBJDB.Cargar_Todos();
            session.setAttribute("lista_usuario", lista);

            ArrayList<CObjetoCombo> lista2 = new ArrayList<CObjetoCombo>();
            CusuarioDB OBJDB2 = new CusuarioDB();
            lista2 = OBJDB2.Cargar_Combo();
            session.setAttribute("lista_combo_usuario", lista2);

            CprovinciaDB OBJDB3 = new CprovinciaDB();
            lista2 = OBJDB3.Cargar_Combo();
            session.setAttribute("lista_combo_provincia", lista2);
            
            CcantonesDB OBJDB4 = new CcantonesDB();
            lista2 = OBJDB4.Cargar_Combo();
            session.setAttribute("lista_combo_cantones", lista2);
            
            Ctipo_usuarioDB OBJDB5 = new Ctipo_usuarioDB();
            lista2 = OBJDB5.Cargar_Combo();
            session.setAttribute("lista_combo_tipo_usuario", lista2);

            response.sendRedirect("usuario_listar_todos.jsp");
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
