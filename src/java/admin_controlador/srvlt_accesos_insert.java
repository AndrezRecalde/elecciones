
package admin_controlador;

import herramientas.conexion;
import admin.CaccesosDB;
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
public class srvlt_accesos_insert extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           CaccesosDB OBJ = new CaccesosDB();
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
           		int Xusuario_id =Integer.parseInt(request.getParameter("txt_usuario_id"));
		int Xacceso_opcion_id =Integer.parseInt(request.getParameter("txt_acceso_opcion_id"));
           if(OBJ.Ingresar(Xusuario_id,Xacceso_opcion_id)){
                if(request.getParameter("crear_nueva")!=null){
                    response.sendRedirect("accesos_ingresar.jsp");
                }else{
                    response.sendRedirect("admin_controlador.srvlt_accesos_listar_todos");
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