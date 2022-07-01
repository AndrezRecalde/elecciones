
package admin_controlador;

import herramientas.conexion;
import admin.CusuarioDB;
import admin.Cusuario;
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
public class srvlt_usuario_buscar_actualizar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
           CusuarioDB OBJDB = new CusuarioDB();
           Cusuario OBJ = new Cusuario();
           OBJ = OBJDB.Seleccionar_Id(Integer.parseInt(request.getParameter("txt_idusuario").toString()));
             if(OBJ.getnombres()==null){
                OBJ.setnombres("");
            }            if(OBJ.getusuario()==null){
                OBJ.setusuario("");
            }            if(OBJ.getprovincia_string()==null){
                OBJ.setprovincia_string("");
            }            if(OBJ.getprovincia_nombre()==null){
                OBJ.setprovincia_nombre("");
            }            if(OBJ.getcantones_string()==null){
                OBJ.setcantones_string("");
            }            if(OBJ.gettipo_usu_nombre()==null){
                OBJ.settipo_usu_nombre("");
            }            if(OBJ.gettipo_usuario_string()==null){
                OBJ.settipo_usuario_string("");
            }            if(OBJ.getlogin()==null){
                OBJ.setlogin("");
            }            if(OBJ.getclave()==null){
                OBJ.setclave("");
            }
           String param="?txt_idusuario="+OBJ.getidusuario()+"&txt_nombres="+URLEncoder.encode(OBJ.getnombres(), "utf-8")+"&txt_usuario="+URLEncoder.encode(OBJ.getusuario(), "utf-8")+"&txt_fr_id_provincia="+OBJ.getfr_id_provincia()+"&txt_provincia_string="+URLEncoder.encode(OBJ.getprovincia_string(), "utf-8")+"&txt_provincia_nombre="+URLEncoder.encode(OBJ.getprovincia_nombre(), "utf-8")+"&txt_fr_id_tipo_usuario="+OBJ.getfr_id_tipo_usuario()+"&txt_es_provincial="+OBJ.getes_provincial()+"&txt_fr_id_canton="+OBJ.getfr_id_canton()+"&txt_cantones_string="+URLEncoder.encode(OBJ.getcantones_string(), "utf-8")+"&txt_es_cantonal="+OBJ.getes_cantonal()+"&txt_tipo_usu_nombre="+URLEncoder.encode(OBJ.gettipo_usu_nombre(), "utf-8")+"&txt_tipo_usuario_string="+URLEncoder.encode(OBJ.gettipo_usuario_string(), "utf-8")+"&txt_login="+URLEncoder.encode(OBJ.getlogin(), "utf-8")+"&txt_clave="+URLEncoder.encode(OBJ.getclave(), "utf-8")+"&txt_activo="+OBJ.getactivo()+"&txt_usu_ui="+OBJ.getusu_ui()+"&txt_usu_fi="+OBJ.getusu_fi()+"&txt_usu_um="+OBJ.getusu_um();
           response.sendRedirect("usuario_actualizar_resultado.jsp"+param);
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