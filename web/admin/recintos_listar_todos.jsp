<%-- 
   Document   : index
   Created on : Jul 12, 2014, 11:48:02 AM
   Author     : Generado V1.0
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="admin.Crecintos" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Control Electoral-Recintos</title>
        <link href="../styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="../styles/basic.css" rel="stylesheet" type="text/css" media="screen" />

        <link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
        <% SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); %>
        <form name="form1">
            <center>  
                <div>
                    <button disabled="true" class="boton"><a href="admin_controlador.srvlt_recintos_listar_todos?op=todos">Listar Todas</a></button>
                    <button disabled="true" class="boton"><a href="javascript:history.back(1)">Volver</a></button>
                </div>
                <h1 class="titulo_h1">Coordinadores2 de Recintos</h1>
                <div class="contenedor_tabla">      
                    <br>
                    <table id="lista_table_filter_recintos"   class="clsTablaDatos form_style">
                        <thead>
                            <tr>               
                                <td><b>Cantón</b></td>               
                                <td><b>Parroquia</b></td>               
                                <td><b>Nombre de Recinto</b></td>     
                                <td><b>Juntas Masculinas</b></td> 
                                <td><b>Juntas Femeninas</b></td> 
                                <td><b>CI Responsable</b></td>               
                                <td><b>Nombres y Apellidos del Responsable</b></td>               
                                <td><b>Teléfonos del Responsable</b></td>               
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Crecintos> lista = (ArrayList<Crecintos>) session.getAttribute("lista_recintos");
                                for (Crecintos c : lista) {
                            %>
                            <tr>
                                <td><%= c.getNombre_canton() %></td>               
                                <td><%= c.getparroquia_nombre()%></td>               
                                <td><%= c.getnombre_recinto()%></td>               
                                <td><%= c.getnum_jun_mas()%></td>               
                                <td><%= c.getnum_jun_fem()%></td>               
                                <td><%= c.getresponsable_ci()%></td>               
                                <td><%= c.getresponsable_nombres()%></td>               
                                <td><%= c.getresponsable_telefono()%></td>               
                                <td>
                                    <a class="boton active" title="Editar Recinto" href="admin_controlador.srvlt_recintos_buscar_actualizar?txt_cod_recinto=<%= c.getcod_recinto()%>">Editar</a>
                                    <a class="boton active" title="Padrón Cantonal" href="../coordinadores_recinto_pdf.jsp?tipo=pdf&txt_cod_recinto=<%= c.getCod_canton() %>">Padrón Cantonal</a>
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
                            sort_config: {sort_col: [0, false]},
                            btn_reset: true,
                            btn_reset_text: "Quitar Filtros",
                            rows_counter: true,
                            remember_grid_values: true,
                            rows_counter_text: "Total: ",
                            base_path: "../includes/TableFilter/",
                            col_0: "input",
                            col_1: "input",
                            col_2: "input",
                            col_3: "input",
                            col_4: "input",
                            col_5: "input",
                            col_6: "input",
                            col_7: "input",
                            col_8: "input",
                            col_9: "input",
                            col_10: "input",
                            col_11: "input",
                            col_12: "input",
                            col_13: "input",
                            col_14: "input",
                            col_15: "input",
                            col_16: "none",
                            display_all_text: "<TODOS>",
                            loader: true,
                            loader_css_class: "myLoader",
                            loader_html: '<img src="../includes/TableFilter/loader.gif" alt="" style="vertical-align:middle; margin-right:5px;">Cargando...'
                        };
                        var tf03 = setFilterGrid("lista_table_filter_recintos", table3Filters);
                    </script> 
                </div>
            </center>
        </form>
    </body>
</html>