
package admin_controlador;

import herramientas.conexion;
import admin.Ctipo_usuarioDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import java.text.ParseException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Generador V1.0
 */
public class srvlt_tipo_usuario_insert extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           Ctipo_usuarioDB OBJ = new Ctipo_usuarioDB();
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
           		String Xnombre_tipo_usuario =request.getParameter("txt_nombre_tipo_usuario");
		boolean Xactivo ="1".equals(request.getParameter("txt_activo"));
           if(OBJ.Ingresar(Xnombre_tipo_usuario,Xactivo)){
                if(request.getParameter("crear_nueva")!=null){
                    response.sendRedirect("tipo_usuario_ingresar.jsp");
                }else{
                    response.sendRedirect("admin_controlador.srvlt_tipo_usuario_listar_todos");
                }
            }else{
                out.write("ERROR");
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