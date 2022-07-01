
package admin_controlador;

import herramientas.conexion;
import admin.CjuntaDB;
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
public class srvlt_junta_actualizar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           CjuntaDB OBJ = new CjuntaDB();
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
           		int Xidjunta =Integer.parseInt(request.getParameter("txt_idjunta"));
		int Xfr_id_zona =Integer.parseInt(request.getParameter("txt_fr_id_zona"));
		int Xcne_cod_junta =Integer.parseInt(request.getParameter("txt_cne_cod_junta"));
		int Xnum_junta =Integer.parseInt(request.getParameter("txt_num_junta"));
		String Xgenero =request.getParameter("txt_genero");
		String Xjunta_nombre =request.getParameter("txt_junta_nombre");
		int Xnum_electores_cne =Integer.parseInt(request.getParameter("txt_num_electores_cne"));
		int Xnum_votaron =Integer.parseInt(request.getParameter("txt_num_votaron"));
		int Xnum_no_votaron =Integer.parseInt(request.getParameter("txt_num_no_votaron"));
		int Xnum_total_votaron =Integer.parseInt(request.getParameter("txt_num_total_votaron"));
		boolean Xreceptada ="1".equals(request.getParameter("txt_receptada"));
		String Xresponsable =request.getParameter("txt_responsable");
		String Xresponsable_telefono =request.getParameter("txt_responsable_telefono");
		int Xcod_recinto =Integer.parseInt(request.getParameter("txt_cod_recinto"));
           if(OBJ.Actualizar(Xidjunta,Xfr_id_zona,Xcne_cod_junta,Xnum_junta,Xgenero,Xjunta_nombre,Xnum_electores_cne,Xnum_votaron,Xnum_no_votaron,Xnum_total_votaron,Xreceptada,Xresponsable,Xresponsable_telefono,Xcod_recinto)){
                if(request.getParameter("regresar_editar")!=null){
                    response.sendRedirect("admin_controlador.srvlt_junta_buscar_actualizar?txt_idjunta="+request.getParameter("txt_idjunta"));
                }else{
                    response.sendRedirect("admin_controlador.srvlt_junta_listar_todos");
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