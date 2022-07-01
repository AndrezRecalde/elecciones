
package admin_controlador;

import herramientas.conexion;
import admin.CaccesosDB;
import admin.Caccesos;
import java.io.IOException;
import java.net.URLEncoder;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Generador V1.0
 */
public class srvlt_accesos_buscar_actualizar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
           CaccesosDB OBJDB = new CaccesosDB();
           Caccesos OBJ = new Caccesos();
           OBJ = OBJDB.Seleccionar_Id(Integer.parseInt(request.getParameter("txt_idaccesos").toString()));
             if(OBJ.getusuario_string()==null){
                OBJ.setusuario_string("");
            }            if(OBJ.getacceso_opcion_string()==null){
                OBJ.setacceso_opcion_string("");
            }
           String param="?txt_idaccesos="+OBJ.getidaccesos()+"&txt_usuario_id="+OBJ.getusuario_id()+"&txt_usuario_string="+URLEncoder.encode(OBJ.getusuario_string(), "utf-8")+"&txt_acceso_opcion_id="+OBJ.getacceso_opcion_id()+"&txt_acceso_opcion_string="+URLEncoder.encode(OBJ.getacceso_opcion_string(), "utf-8")+"&txt_acceso_fecha="+OBJ.getacceso_fecha();
           response.sendRedirect("accesos_actualizar_resultado.jsp"+param);
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