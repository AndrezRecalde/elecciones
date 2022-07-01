/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import admin.Cacta_imagesDB;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author userver1
 */
@WebServlet(urlPatterns = {"/UploadFile"})
public class UploadFile extends HttpServlet {

    private String dirUploadFiles; //directorio donde se guardara los archivos

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // 1. obtengo el directorio donde guardare los archivos, desde un parametro de
            // contexto en el archivo web.xml
            dirUploadFiles = getServletContext().getInitParameter("dirUploadFiles");
            String NuevoNombre = "";
            HttpSession session = request.getSession(true);

            int id_usuario = 0;

            if (session.getAttribute("idusuario") != null) {
                id_usuario = Integer.parseInt(session.getAttribute("idusuario").toString());

            } else {
                response.sendRedirect("error.jsp?men=Error. No se ha podido continuar. " + session.getAttribute("idusuario") + ".png");
                return;
            }

            int id_junta = Integer.parseInt(session.getAttribute("id_junta_subir").toString());
            int id_dignidad = Integer.parseInt(session.getAttribute("id_dignidad_subir").toString());

            Cacta_imagesDB acImDB = new Cacta_imagesDB();
            int id_acta_imagen = acImDB.Ingresar(id_usuario, id_junta, id_dignidad, true);

            NuevoNombre = id_acta_imagen + ".jpg";

            // 2. Si la peticion es de tipo multi-part,
            // static boolean isMultipartContent() devuelve true/false
            if (ServletFileUpload.isMultipartContent(request)) {

                // 3. crear el arhivo factory
                // DiskFileItemfactory es una implementacion de FileItemfactory
                // esta implementacion crea una instacia de FileItem que guarda su
                // contenido ya sea en la memoria, para elementos pequeños,
                // o en un archivo temporal en el disco, para los
                // elementos de mayor tamaño
                FileItemFactory factory = new DiskFileItemFactory();

                // 4. crear el servlet upload
                // es un API de alto nivel para procesar subida de archivos
                // Por defecto la instancia de ServletFileUpload tiene los siguientes valores:
                // * Size threshold = 10,240 bytes. Si el tamaño del archivo está por debajo del umbral,
                //   se almacenará en memoria. En otro caso se almacenara en un archivo temporal en disco.
                // * Tamaño Maximo del cuerpo de la request HTTP = -1.
                //   El servidor aceptará cuerpos de request de cualquier tamaño.
                // * Repository = Directorio que el sistema usa para archivos temporales.
                //   Se puede recuperar llamando a System.getProperty("java.io.tmpdir").
                ServletFileUpload upload = new ServletFileUpload(factory);
                /* 5. declaro listUploadFiles
                 * Contendrá una lista de items de archivo que son instancias de FileItem
                 * Un item de archivo puede contener un archivo para upload o un
                 * campo del formulario con la estructura simple nombre-valor
                 * (ejemplo: <input name="text_field" type="text" />)
                 *
                 * Podemos cambiar las opciones mediante setSizeThreshold() y setRespository()
                 de la clase DiskFileItemFactory y el
                 método setSizeMax() de la clase ServletFileUpload, por ejemplo:

                 DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
                 diskFileItemFactory.setSizeThreshold(40960); // bytes

                 File repositoryPath = new File("/temp");
                 diskFileItemFactory.setRepository(repositoryPath);

                 ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
                 servletFileUpload.setSizeMax(81920); // bytes

                 *
                 */
                // limito a 300 Kb el humbral del tamaño del archivo a subir
                // Long.parseLong( getServletContext().getInitParameter( "maxFileSize" ) )
                upload.setSizeMax(new Long(getServletContext().getInitParameter("maxFileSize")).longValue()); // 1024 x 300 = 307200 bytes = 300 Kb

                List listUploadFiles = null;
                FileItem item = null;

                try {
                    // 6. adquiere la lista de FileItem asociados a la peticion
                    listUploadFiles = upload.parseRequest(request);

                    /* 7. Iterar para obtener todos los FileItem
                     * vamos a trabajar con generalidad
                     * programaremos como si quisieramos leer todos los
                     * campos sean 'simples' o 'file'. Por ello iteramos
                     * sobre todos los FileItem que recibimos:
                     * Los parámetros simples los diferenciaremos de los parámetros 'file'
                     * por medio del método isFormField()
                     */
                    Iterator it = listUploadFiles.iterator();
                    while (it.hasNext()) {
                        item = (FileItem) it.next();
                        // 8. evaluamos si el campo es de tipo file, para subir al servidor
                        if (!item.isFormField()) {
                            //9. verificamos si el archivo es > 0
                            if (item.getSize() > 0) {
                                // 10. obtener el nombre del archivo
                                String nombre = item.getName();

                                // 11. obtener el tipo de archivo
                                // e. .jpg = "image/jpeg", .txt = "text/plain"
                                String tipo = item.getContentType();
                                // 12. obtener el tamaño del archivo
                                long tamanio = item.getSize();
                                // 13. obtener la extension
                                String extension = nombre.substring(nombre.lastIndexOf("."));

                                out.println("Nombre: " + nombre + "<br>");
                                out.println("Tipo: " + tipo + "<br>");
                                out.println("Extension: " + extension + "<br>");
                                // 14. determinar si el caracter slash es de linux, o windows
                                //String slashType = ( nombre.lastIndexOf( "\\" ) > 0 ) ?  "\\" : "/"; // Windows o Linux
                                // 15. obtener la ultima posicion del slash en el nombre del archivo
                                //int startIndex = nombre.lastIndexOf( slashType );
                                // 16. obtener el nombre del archivo ignorando la ruta completa
                                //String myArchivo = nombre.substring( startIndex + 1, nombre.length() );
                                // 17. Guardo archivo del cliente en servidor, con un nombre 'fijo' y la
                                // extensión que me manda el cliente,
                                // Create new File object
                                File archivo = new File(dirUploadFiles, NuevoNombre);

                                // 18. Write the uploaded file to the system
                                item.write(archivo);
                                if (archivo.exists()) {
                                    out.println("GUARDADO " + archivo.getAbsolutePath() + "</p>");
                                } else {
                                    // nunca se llega a ejecutar
                                    out.println("FALLO AL GUARDAR. NO EXISTE " + archivo.getAbsolutePath() + "</p>");
                                }

                            }
                        }
                    }

                } catch (FileUploadException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    // poner respuesta = false; si existe alguna problema
                    e.printStackTrace();
                    out.println(e.toString());
                    response.sendRedirect("perfil.jsp?men=Ups! La imagen que quieres subir es muy grande....");
                    return;
                }
            }
            if (session.getAttribute("subir_desde").toString().equals("digitar")) {
                response.sendRedirect("dig_actas_dignidad.jsp");
            } else {
                response.sendRedirect("dig_actas_dignidad_junta_ver.jsp?iddignidad=" + id_dignidad + "&idjunta=" + id_junta);
            }
        } finally {
            out.close();
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
