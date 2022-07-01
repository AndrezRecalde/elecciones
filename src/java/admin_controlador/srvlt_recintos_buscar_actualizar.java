
package admin_controlador;

import herramientas.conexion;
import admin.CrecintosDB;
import admin.Crecintos;
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
public class srvlt_recintos_buscar_actualizar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
           CrecintosDB OBJDB = new CrecintosDB();
           Crecintos OBJ = new Crecintos();
           OBJ = OBJDB.Seleccionar_Id(Integer.parseInt(request.getParameter("txt_cod_recinto").toString()));
             if(OBJ.getparroquia_nombre()==null){
                OBJ.setparroquia_nombre("");
            }            if(OBJ.getnombre_recinto()==null){
                OBJ.setnombre_recinto("");
            }            if(OBJ.getdireccion_recinto()==null){
                OBJ.setdireccion_recinto("");
            }            if(OBJ.getresponsable_ci()==null){
                OBJ.setresponsable_ci("");
            }            if(OBJ.getresponsable_nombres()==null){
                OBJ.setresponsable_nombres("");
            }            if(OBJ.getresponsable_telefono()==null){
                OBJ.setresponsable_telefono("");
            }
           String param="?txt_cod_recinto="+OBJ.getcod_recinto()+"&txt_cod_parroquia="+OBJ.getcod_parroquia()+"&txt_parroquia_nombre="+URLEncoder.encode(OBJ.getparroquia_nombre(), "utf-8")+"&txt_nombre_recinto="+URLEncoder.encode(OBJ.getnombre_recinto(), "utf-8")+"&txt_direccion_recinto="+URLEncoder.encode(OBJ.getdireccion_recinto(), "utf-8")+"&txt_cod_zona="+OBJ.getcod_zona()+"&txt_num_jun_mas="+OBJ.getnum_jun_mas()+"&txt_num_jun_fem="+OBJ.getnum_jun_fem()+"&txt_num_juntas="+OBJ.getnum_juntas()+"&txt_responsable_ci="+URLEncoder.encode(OBJ.getresponsable_ci(), "utf-8")+"&txt_responsable_nombres="+URLEncoder.encode(OBJ.getresponsable_nombres(), "utf-8")+"&txt_responsable_telefono="+URLEncoder.encode(OBJ.getresponsable_telefono(), "utf-8")+"&txt_jun_ini_f="+OBJ.getjun_ini_f()+"&txt_jun_fin_f="+OBJ.getjun_fin_f()+"&txt_jun_ini_m="+OBJ.getjun_ini_m()+"&txt_jun_fin_m="+OBJ.getjun_fin_m();
           response.sendRedirect("recintos_actualizar_resultado.jsp"+param);
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