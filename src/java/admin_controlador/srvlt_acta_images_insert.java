package admin_controlador;

import herramientas.conexion;
import admin.Cacta_imagesDB;
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
public class srvlt_acta_images_insert extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Cacta_imagesDB OBJ = new Cacta_imagesDB();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            int Xacta_image_usu_ing = Integer.parseInt(request.getParameter("txt_acta_image_usu_ing"));
            int Xacta_image_id_junta = Integer.parseInt(request.getParameter("txt_acta_image_id_junta"));
            int Xacta_image_id_dignidad = Integer.parseInt(request.getParameter("txt_acta_image_id_dignidad"));
            boolean Xacta_image_activa = "1".equals(request.getParameter("txt_acta_image_activa"));
            if (OBJ.Ingresar(Xacta_image_usu_ing, Xacta_image_id_junta, Xacta_image_id_dignidad, Xacta_image_activa) != 0) {
                if (request.getParameter("crear_nueva") != null) {
                    response.sendRedirect("acta_images_ingresar.jsp");
                } else {
                    response.sendRedirect("admin_controlador.srvlt_acta_images_listar_todos");
                }
            } else {
                out.write("ERROR");
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
