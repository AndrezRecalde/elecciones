
package admin_controlador;

import herramientas.conexion;
import admin.CactaDB;
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
public class srvlt_acta_actualizar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           CactaDB OBJ = new CactaDB();
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
           		int Xidacta =Integer.parseInt(request.getParameter("txt_idacta"));
		int Xcod_provincia =Integer.parseInt(request.getParameter("txt_cod_provincia"));
		int Xcod_canton =Integer.parseInt(request.getParameter("txt_cod_canton"));
		int Xcod_parroquia =Integer.parseInt(request.getParameter("txt_cod_parroquia"));
		int Xcod_zona =Integer.parseInt(request.getParameter("txt_cod_zona"));
		int Xfr_id_junta =Integer.parseInt(request.getParameter("txt_fr_id_junta"));
		int Xfr_id_dignidad =Integer.parseInt(request.getParameter("txt_fr_id_dignidad"));
		int Xcne_cod_acta =Integer.parseInt(request.getParameter("txt_cne_cod_acta"));
		int Xnum_validos =Integer.parseInt(request.getParameter("txt_num_validos"));
		int Xnum_no_voto =Integer.parseInt(request.getParameter("txt_num_no_voto"));
		int Xnum_blancos =Integer.parseInt(request.getParameter("txt_num_blancos"));
		int Xnum_nulos =Integer.parseInt(request.getParameter("txt_num_nulos"));
		int Xacta_usu_ing =Integer.parseInt(request.getParameter("txt_acta_usu_ing"));
		int Xacta_usu_mod =Integer.parseInt(request.getParameter("txt_acta_usu_mod"));
		boolean Xcuadrada ="1".equals(request.getParameter("txt_cuadrada"));
		boolean Xlegible ="1".equals(request.getParameter("txt_legible"));
		int Xfr_id_acta_estado =Integer.parseInt(request.getParameter("txt_fr_id_acta_estado"));
           if(OBJ.Actualizar(Xidacta,Xcod_provincia,Xcod_canton,Xcod_parroquia,Xcod_zona,Xfr_id_junta,Xfr_id_dignidad,Xcne_cod_acta,Xnum_validos,Xnum_no_voto,Xnum_blancos,Xnum_nulos,Xacta_usu_ing,Xacta_usu_mod,Xcuadrada,Xlegible,Xfr_id_acta_estado)){
                if(request.getParameter("regresar_editar")!=null){
                    response.sendRedirect("admin_controlador.srvlt_acta_buscar_actualizar?txt_idacta="+request.getParameter("txt_idacta"));
                }else{
                    response.sendRedirect("admin_controlador.srvlt_acta_listar_todos");
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