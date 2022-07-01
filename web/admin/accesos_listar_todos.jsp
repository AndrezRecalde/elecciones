<%-- 
   Document   : index
   Created on : Jul 12, 2014, 11:48:02 AM
   Author     : Generado V1.0
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="admin.Caccesos" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Control Electoral-Accesos de Usuarios</title>
        <link href="../styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="../styles/basic.css" rel="stylesheet" type="text/css" media="screen" />

        <link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
        <% SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); %>
        <form name="form1">
            <center>          
                <button disabled="true" class="boton"><a href="javascript:history.back(1)">Volver</a></button>
                <h1 class="titulo_h1">Accesos de Usuarios</h1>
                <div class="contenedor_tabla">
                    <table id="lista_table_filter_accesos" class="clsTablaDatos form_style">
                        <thead>
                            <tr>               
                                <td><b>ID</b></td>               
                                <td><b>USUARIO</b></td>               
                                <td><b>OPCIÓN</b></td>               
                                <td><b>FECHA</b></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Caccesos> lista = (ArrayList<Caccesos>) session.getAttribute("lista_accesos");
                                for (Caccesos c : lista) {
                            %>
                            <tr>
                                <td><%= c.getidaccesos()%></td>               
                                <td><%= c.getusuario_string()%></td>               
                                <td><%= c.getacceso_opcion_string()%></td>               
                                <td><%= sdf.format(c.getacceso_fecha())%></td>       
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
                            col_3: "input",
                            display_all_text: "<TODOS>",
                            loader: true,
                            loader_css_class: "myLoader",
                            loader_html: '<img src="../includes/TableFilter/loader.gif" alt="" style="vertical-align:middle; margin-right:5px;">Cargando...'
                        };
                        var tf03 = setFilterGrid("lista_table_filter_accesos", table3Filters);
                    </script> 
                </div>
            </center>
        </form>
    </body>
</html>