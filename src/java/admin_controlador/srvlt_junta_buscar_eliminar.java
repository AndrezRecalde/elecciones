
package admin_controlador;

import herramientas.conexion;
import admin.CjuntaDB;
import admin.Cjunta;
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
public class srvlt_junta_buscar_eliminar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        PrintWriter out = response.getWriter();
        try {
           CjuntaDB OBJDB = new CjuntaDB();
           Cjunta OBJ = new Cjunta();
           OBJ = OBJDB.Seleccionar_Id(Integer.parseInt(request.getParameter("txt_idjunta").toString()));
             if(OBJ.getzonas_string()==null){
                OBJ.setzonas_string("");
            }            if(OBJ.getgenero()==null){
                OBJ.setgenero("");
            }            if(OBJ.getjunta_nombre()==null){
                OBJ.setjunta_nombre("");
            }            if(OBJ.getresponsable()==null){
                OBJ.setresponsable("");
            }            if(OBJ.getresponsable_telefono()==null){
                OBJ.setresponsable_telefono("");
            }
           String param="?txt_idjunta="+OBJ.getidjunta()+"&txt_fr_id_zona="+OBJ.getfr_id_zona()+"&txt_zonas_string="+URLEncoder.encode(OBJ.getzonas_string(), "utf-8")+"&txt_cne_cod_junta="+OBJ.getcne_cod_junta()+"&txt_num_junta="+OBJ.getnum_junta()+"&txt_genero="+URLEncoder.encode(OBJ.getgenero(), "utf-8")+"&txt_junta_nombre="+URLEncoder.encode(OBJ.getjunta_nombre(), "utf-8")+"&txt_num_electores_cne="+OBJ.getnum_electores_cne()+"&txt_num_votaron="+OBJ.getnum_votaron()+"&txt_num_no_votaron="+OBJ.getnum_no_votaron()+"&txt_num_total_votaron="+OBJ.getnum_total_votaron()+"&txt_receptada="+OBJ.getreceptada()+"&txt_responsable="+URLEncoder.encode(OBJ.getresponsable(), "utf-8")+"&txt_responsable_telefono="+URLEncoder.encode(OBJ.getresponsable_telefono(), "utf-8")+"&txt_cod_recinto="+OBJ.getcod_recinto();
           response.sendRedirect("junta_eliminar_resultado.jsp"+param);
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