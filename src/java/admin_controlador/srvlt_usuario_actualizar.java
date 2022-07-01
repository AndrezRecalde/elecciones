package admin_controlador;

import herramientas.conexion;
import admin.CusuarioDB;
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
public class srvlt_usuario_actualizar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            CusuarioDB OBJ = new CusuarioDB();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            int Xidusuario = Integer.parseInt(request.getParameter("txt_idusuario"));
            String Xnombres = request.getParameter("txt_nombres");
            String Xusuario = request.getParameter("txt_usuario");
            int Xfr_id_provincia = Integer.parseInt(request.getParameter("txt_fr_id_provincia"));
            String Xprovincia_nombre = request.getParameter("txt_provincia_nombre");
            int Xfr_id_tipo_usuario = Integer.parseInt(request.getParameter("txt_fr_id_tipo_usuario"));
            boolean Xes_provincial = "1".equals(request.getParameter("txt_es_provincial"));
            int Xfr_id_canton = Integer.parseInt(request.getParameter("txt_fr_id_canton"));
            boolean Xes_cantonal = "1".equals(request.getParameter("txt_es_cantonal"));
            String Xtipo_usu_nombre = request.getParameter("txt_tipo_usu_nombre");
            String Xclave = request.getParameter("txt_clave");
            boolean Xactivo = "1".equals(request.getParameter("txt_activo"));

            if (request.getParameter("txt_clave").equals("")) {
                if (OBJ.Actualizar(Xidusuario, Xnombres, Xusuario, Xfr_id_provincia, Xprovincia_nombre, Xfr_id_tipo_usuario, Xes_provincial, Xfr_id_canton, Xes_cantonal, Xtipo_usu_nombre, Xactivo)) {
                    if (request.getParameter("regresar_editar") != null) {
                        response.sendRedirect("admin_controlador.srvlt_usuario_buscar_actualizar?txt_idusuario=" + request.getParameter("txt_idusuario"));
                    } else {
                        response.sendRedirect("admin_controlador.srvlt_usuario_listar_todos");
                    }
                } else {
                    out.write("ERROR NO SE PUDO ACTUALIZAR REGISTRO");
                }
            } else {
                if (OBJ.Actualizar(Xidusuario, Xnombres, Xusuario, Xfr_id_provincia, Xprovincia_nombre, Xfr_id_tipo_usuario, Xes_provincial, Xfr_id_canton, Xes_cantonal, Xtipo_usu_nombre, Xclave, Xactivo)) {
                    if (request.getParameter("regresar_editar") != null) {
                        response.sendRedirect("admin_controlador.srvlt_usuario_buscar_actualizar?txt_idusuario=" + request.getParameter("txt_idusuario"));
                    } else {
                        response.sendRedirect("admin_controlador.srvlt_usuario_listar_todos");
                    }
                } else {
                    out.write("ERROR NO SE PUDO ACTUALIZAR REGISTRO");
                }
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
