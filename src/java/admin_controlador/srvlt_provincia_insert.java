
package admin_controlador;

import herramientas.conexion;
import admin.CprovinciaDB;
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
public class srvlt_provincia_insert extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           CprovinciaDB OBJ = new CprovinciaDB();
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
           		String Xnombre_provincia =request.getParameter("txt_nombre_provincia");
		int Xnum_vot_hombres =Integer.parseInt(request.getParameter("txt_num_vot_hombres"));
		int Xnum_vot_mujeres =Integer.parseInt(request.getParameter("txt_num_vot_mujeres"));
		boolean Xactiva ="1".equals(request.getParameter("txt_activa"));
           if(OBJ.Ingresar(Xnombre_provincia,Xnum_vot_hombres,Xnum_vot_mujeres,Xactiva)){
                if(request.getParameter("crear_nueva")!=null){
                    response.sendRedirect("provincia_ingresar.jsp");
                }else{
                    response.sendRedirect("admin_controlador.srvlt_provincia_listar_todos");
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