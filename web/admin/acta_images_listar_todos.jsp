<%-- 
   Document   : index
   Created on : Jul 12, 2014, 11:48:02 AM
   Author     : Generado V1.0
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="admin.Cacta_images" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Control Electoral-Imágenes de Actas</title>

        <link href="../styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="../styles/basic.css" rel="stylesheet" type="text/css" media="screen" />

        <link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>

    </head>
    <body>
        <% SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); %>
        <form name="form1">
            <center>              
                <a href="admin_controlador.srvlt_acta_images_listar_todos?op=todos">Listar Todas</a>
                <button disabled="true" class="boton"><a href="javascript:history.back(1)">Volver</a></button>
                <h1 class="titulo_h1">Imágenes de Actas</h1>
                <div class="contenedor_tabla">     
                    <br>
                    <table id="lista_table_filter_acta_imagesy" class="clsTablaDatos form_style">
                        <thead>
                            <tr>
                                <td><b>ID</b></td>
                                <td><b>Subida por</b></td>
                                <td><b>Canton</b></td>
                                <td><b>Parroquia</b></td>
                                <td><b>Zona</b></td>
                                <td><b>Recinto</b></td>
                                <td><b>Junta</b></td>
                                <td><b>Dignidad</b></td>
                                <td><b>Activa</b></td>
                                <td><b>Fecha de Subida</b></td>
                                <td><b>UM</b></td><td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Cacta_images> lista = (ArrayList<Cacta_images>) session.getAttribute("lista_acta_images");
                                for (Cacta_images c : lista) {
                            %>
                            <tr>
                                <td><%= c.getidacta_images()%></td>
                                <td><%= c.getusuario_string()%></td>
                                <td><%= c.getCanton_string() %></td>
                                <td><%= c.getParroquia_string() %></td>
                                <td><%= c.getZona_string() %></td>
                                <td><%= c.getRecinto_string() %></td>
                                <td><%= c.getjunta_string()%></td>
                                <td><%= c.getdignidad_string()%></td>
                                <td><% if (c.getacta_image_activa()) {%>SI<%} else {%>NO<%}%></td>
                                <td><%= sdf.format(c.getacta_image_fi())%></td>
                                <td><%= sdf.format(c.getacta_image_um())%></td><td>
                                    <a title="Ver Imágen de acta" href="../images/actas/<%= c.getidacta_images()%>.jpg">VER</a>
                                    <a title="Detalles de Imágen de acta" href="admin_controlador.srvlt_acta_images_buscar?txt_idacta_images=<%= c.getidacta_images()%>" >Detalles</a>
                                    <a title="Eliminar Imágen de acta" href="admin_controlador.srvlt_acta_images_buscar_actualizar?txt_idacta_images=<%= c.getidacta_images()%>">Eliminar</a>
                                </td>            
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <script language="javascript" type="text/javascript">
                        var table3Filters = {
                            sort: true,
                            btn_reset: true,
                            btn_reset_text: "Quitar Filtros",
                            rows_counter: true,
                            remember_grid_values: true,
                            rows_counter_text: "Total: ",
                            base_path: "../includes/TableFilter/",
                            col_0: "input",
                            col_1: "select",
                            col_2: "select",
                            col_3: "select",
                            col_4: "select",
                            col_5: "select",
                            col_6: "select",
                            col_7: "select",
                            col_8: "select",
                            col_9: "input",
                            col_10: "input",
                            col_11: "none",
                            display_all_text: "<TODOS>",
                            loader: true,
                            loader_css_class: "myLoader",
                            loader_html: '<img src="../includes/TableFilter/loader.gif" alt="" style="vertical-align:middle; margin-right:5px;">Cargando...'
                        };
                        var tf03 = setFilterGrid("lista_table_filter_acta_imagesy", table3Filters);
                    </script> 
                </div>
            </center>
        </form>
    </body>
</html>