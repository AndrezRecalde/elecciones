
package admin_controlador;

import herramientas.conexion;
import admin.Cacta_imagesDB;
import admin.Cacta_images;
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
public class srvlt_acta_images_buscar_eliminar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        PrintWriter out = response.getWriter();
        try {
           Cacta_imagesDB OBJDB = new Cacta_imagesDB();
           Cacta_images OBJ = new Cacta_images();
           OBJ = OBJDB.Seleccionar_Id(Integer.parseInt(request.getParameter("txt_idacta_images").toString()));
             if(OBJ.getusuario_string()==null){
                OBJ.setusuario_string("");
            }            if(OBJ.getjunta_string()==null){
                OBJ.setjunta_string("");
            }            if(OBJ.getdignidad_string()==null){
                OBJ.setdignidad_string("");
            }
           String param="?txt_idacta_images="+OBJ.getidacta_images()+"&txt_acta_image_usu_ing="+OBJ.getacta_image_usu_ing()+"&txt_usuario_string="+URLEncoder.encode(OBJ.getusuario_string(), "utf-8")+"&txt_acta_image_id_junta="+OBJ.getacta_image_id_junta()+"&txt_junta_string="+URLEncoder.encode(OBJ.getjunta_string(), "utf-8")+"&txt_acta_image_id_dignidad="+OBJ.getacta_image_id_dignidad()+"&txt_dignidad_string="+URLEncoder.encode(OBJ.getdignidad_string(), "utf-8")+"&txt_acta_image_activa="+OBJ.getacta_image_activa()+"&txt_acta_image_fi="+OBJ.getacta_image_fi()+"&txt_acta_image_um="+OBJ.getacta_image_um();
           response.sendRedirect("acta_images_eliminar_resultado.jsp"+param);
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