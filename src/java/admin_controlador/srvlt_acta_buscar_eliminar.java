
package admin_controlador;

import herramientas.conexion;
import admin.CactaDB;
import admin.Cacta;
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
public class srvlt_acta_buscar_eliminar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        PrintWriter out = response.getWriter();
        try {
           CactaDB OBJDB = new CactaDB();
           Cacta OBJ = new Cacta();
           OBJ = OBJDB.Seleccionar_Id(Integer.parseInt(request.getParameter("txt_idacta").toString()));
             if(OBJ.getjunta_string()==null){
                OBJ.setjunta_string("");
            }
           String param="?txt_idacta="+OBJ.getidacta()+"&txt_cod_provincia="+OBJ.getcod_provincia()+"&txt_cod_canton="+OBJ.getcod_canton()+"&txt_cod_parroquia="+OBJ.getcod_parroquia()+"&txt_cod_zona="+OBJ.getcod_zona()+"&txt_fr_id_junta="+OBJ.getfr_id_junta()+"&txt_junta_string="+URLEncoder.encode(OBJ.getjunta_string(), "utf-8")+"&txt_fr_id_dignidad="+OBJ.getfr_id_dignidad()+"&txt_cne_cod_acta="+OBJ.getcne_cod_acta()+"&txt_num_validos="+OBJ.getnum_validos()+"&txt_num_no_voto="+OBJ.getnum_no_voto()+"&txt_num_blancos="+OBJ.getnum_blancos()+"&txt_num_nulos="+OBJ.getnum_nulos()+"&txt_acta_usu_ing="+OBJ.getacta_usu_ing()+"&txt_acta_usu_mod="+OBJ.getacta_usu_mod()+"&txt_acta_fi="+OBJ.getacta_fi()+"&txt_acta_um="+OBJ.getacta_um()+"&txt_cuadrada="+OBJ.getcuadrada()+"&txt_legible="+OBJ.getlegible()+"&txt_fr_id_acta_estado="+OBJ.getfr_id_acta_estado();
           response.sendRedirect("acta_eliminar_resultado.jsp"+param);
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