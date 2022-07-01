
package admin_controlador;

import herramientas.conexion;
import admin.CrecintosDB;
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
public class srvlt_recintos_actualizar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           CrecintosDB OBJ = new CrecintosDB();
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
           		int Xcod_recinto =Integer.parseInt(request.getParameter("txt_cod_recinto"));
		String Xresponsable_ci =request.getParameter("txt_responsable_ci");
		String Xresponsable_nombres =request.getParameter("txt_responsable_nombres");
		String Xresponsable_telefono =request.getParameter("txt_responsable_telefono");
           if(OBJ.Actualizar(Xcod_recinto,Xresponsable_ci,Xresponsable_nombres,Xresponsable_telefono)){
                if(request.getParameter("regresar_editar")!=null){
                    response.sendRedirect("admin_controlador.srvlt_recintos_buscar_actualizar?txt_cod_recinto="+request.getParameter("txt_cod_recinto"));
                }else{
                    response.sendRedirect("admin_controlador.srvlt_recintos_listar_todos");
                }
            }else{
                out.write("ERROR NO SE PUDO ACTUALIZAR REGISTRO");
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