
package admin_controlador;

import herramientas.conexion;
import admin.CcantonesDB;
import admin.Ccantones;
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
public class srvlt_cantones_buscar_actualizar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
           CcantonesDB OBJDB = new CcantonesDB();
           Ccantones OBJ = new Ccantones();
           OBJ = OBJDB.Seleccionar_Id(Integer.parseInt(request.getParameter("txt_cod_canton").toString()));
             if(OBJ.getprovincia_string()==null){
                OBJ.setprovincia_string("");
            }            if(OBJ.getnombre_canton()==null){
                OBJ.setnombre_canton("");
            }
           String param="?txt_cod_canton="+OBJ.getcod_canton()+"&txt_cod_provincia="+OBJ.getcod_provincia()+"&txt_provincia_string="+URLEncoder.encode(OBJ.getprovincia_string(), "utf-8")+"&txt_nombre_canton="+URLEncoder.encode(OBJ.getnombre_canton(), "utf-8")+"&txt_tiene_circunscipciones="+OBJ.gettiene_circunscipciones()+"&txt_fr_id_canton_pertenece="+OBJ.getfr_id_canton_pertenece();
           response.sendRedirect("cantones_actualizar_resultado.jsp"+param);
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