package admin_controlador;

import herramientas.conexion;
import admin.CusuarioDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import java.text.ParseException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Generador V1.0
 */
public class srvlt_usuario_actualizar_contrasena extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            CusuarioDB OBJ = new CusuarioDB();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            String Xclave = request.getParameter("clave");
            String Xclave2 = request.getParameter("clave2");
            int Xidusuario = Integer.parseInt(session.getAttribute("idusuario").toString());

            if (!Xclave.isEmpty()) {
                if (Xclave.equals(Xclave2)) {
                    if (OBJ.Actualizar(Xidusuario,  Xclave)) {
                        response.sendRedirect("../mensaje_normal.jsp?men=Ok, cambio exitoso.");
                    } else {
                        response.sendRedirect("../error.jsp?men=Error.");
                    }
                }else{
                    response.sendRedirect("../error.jsp?men=Error clave no coincide con la confirmación.");
                }

            } else {
                response.sendRedirect("../error.jsp?men=Error, ingrese una contraseña.");
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
