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
public class srvlt_acta_images_actualizar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Cacta_imagesDB OBJ = new Cacta_imagesDB();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            int Xidacta_images = Integer.parseInt(request.getParameter("txt_idacta_images"));
            if (OBJ.Actualizar(Xidacta_images)) {
                response.sendRedirect("../dig_actas_dignidad_junta_ver.jsp?iddignidad=" + request.getParameter("iddignidad") + "&idjunta=" + request.getParameter("idjunta"));
            } else {
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
