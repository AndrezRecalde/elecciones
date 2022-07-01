
package admin_controlador;

import herramientas.conexion;
import admin.CcantonesDB;
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
public class srvlt_cantones_insert extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           CcantonesDB OBJ = new CcantonesDB();
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
           		int Xcod_provincia =Integer.parseInt(request.getParameter("txt_cod_provincia"));
		String Xnombre_canton =request.getParameter("txt_nombre_canton");
		boolean Xtiene_circunscipciones ="1".equals(request.getParameter("txt_tiene_circunscipciones"));
		int Xfr_id_canton_pertenece =Integer.parseInt(request.getParameter("txt_fr_id_canton_pertenece"));
           if(OBJ.Ingresar(Xcod_provincia,Xnombre_canton,Xtiene_circunscipciones,Xfr_id_canton_pertenece)){
                if(request.getParameter("crear_nueva")!=null){
                    response.sendRedirect("cantones_ingresar.jsp");
                }else{
                    response.sendRedirect("admin_controlador.srvlt_cantones_listar_todos");
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