
package admin_controlador;

import herramientas.conexion;
import admin.CprovinciaDB;
import admin.Cprovincia;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
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
public class srvlt_provincia_buscar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           CprovinciaDB OBJDB = new CprovinciaDB();
           Cprovincia OBJ = new Cprovincia();
           OBJ = OBJDB.Seleccionar_Id(Integer.parseInt(request.getParameter("txt_cne_cod_prov").toString()));
             if(OBJ.getnombre_provincia()==null){
                OBJ.setnombre_provincia("");
            }
           String param="?txt_cne_cod_prov="+OBJ.getcne_cod_prov()+"&txt_nombre_provincia="+URLEncoder.encode(OBJ.getnombre_provincia(), "utf-8")+"&txt_num_vot_hombres="+OBJ.getnum_vot_hombres()+"&txt_num_vot_mujeres="+OBJ.getnum_vot_mujeres()+"&txt_activa="+OBJ.getactiva();
           response.sendRedirect("provincia_buscar_resultado.jsp"+param);
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