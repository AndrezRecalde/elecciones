
package admin_controlador;

import herramientas.conexion;
import admin.Ctipo_usuarioDB;
import admin.Ctipo_usuario;
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
public class srvlt_tipo_usuario_buscar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
           Ctipo_usuarioDB OBJDB = new Ctipo_usuarioDB();
           Ctipo_usuario OBJ = new Ctipo_usuario();
           OBJ = OBJDB.Seleccionar_Id(Integer.parseInt(request.getParameter("txt_idtipo_usuario").toString()));
             if(OBJ.getnombre_tipo_usuario()==null){
                OBJ.setnombre_tipo_usuario("");
            }
           String param="?txt_idtipo_usuario="+OBJ.getidtipo_usuario()+"&txt_nombre_tipo_usuario="+URLEncoder.encode(OBJ.getnombre_tipo_usuario(), "utf-8")+"&txt_activo="+OBJ.getactivo();
           response.sendRedirect("tipo_usuario_buscar_resultado.jsp"+param);
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