<%-- 
   Document   : index
   Created on : Jul 12, 2014, 11:48:02 AM
   Author     : Generado V1.0
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="admin.Cusuario" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control Electoral-usuario</title>

        <link href="../styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="../styles/basic.css" rel="stylesheet" type="text/css" media="screen" />

        <link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>

    </head>
    <body>
        <% SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); %>
        <form name="form1">
            <center>               
                <button disabled="true" class="boton"><a href="usuario_ingresar.jsp">Nuevo</a></button>
                <button disabled="true" class="boton"><a href="admin_controlador.srvlt_usuario_listar_todos">Listar Todos</a></button>
                <button disabled="true" class="boton"><a href="javascript:history.back(1)">Cancelar</a></button>
                <div class="contenedor_tabla">    
                    <table id="lista_table_filter_usuario" class="clsTablaDatos form_style">
                        <thead>
                            <tr>               
                                <td><b>Nombres y Apellidos</b></td>               
                                <td><b>Usuario</b></td>   
                                <td><b>Dirección</b></td>               
                                <td><b>Provincia</b></td>               
                                <td><b>Es provincial</b></td>               
                                <td><b>Canton</b></td>               
                                <td><b>Es cantonal</b></td>               
                                <td><b>Tipo de usuario</b></td>               
                                <td><b>Activo</b></td>               
                                <td><b>Último Acceso</b></td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Cusuario> lista = (ArrayList<Cusuario>) session.getAttribute("lista_usuario");
                                for (Cusuario c : lista) {
                            %>
                            <tr ondblclick="document.location = 'admin_controlador.srvlt_usuario_buscar?txt_idusuario=<%= c.getidusuario()%>'">
                                <td><%= c.getnombres()%></td>               
                                <td><%= c.getusuario()%></td>  
                                <td><%= c.getprovincia_nombre()%></td>               
                                <td><%= c.getprovincia_string()%></td>               
                                <td><% if (c.getes_provincial()) {%>SI<%} else {%>NO<%}%></td>               
                                <td><%= c.getcantones_string()%></td>               
                                <td><% if (c.getes_cantonal()) {%>SI<%} else {%>NO<%}%></td>               
                                <td><%= c.gettipo_usuario_string()%></td>               
                                <td><% if (c.getactivo()) {%>SI<%} else {%>NO<%}%></td>               
                                <td><% if( c.getusu_ui()!=null ){ %> <%= sdf.format(c.getusu_ui())%><%}%></td>               
                                <td>
                                    <a class="boton active" title="Ver usuario" href="admin_controlador.srvlt_usuario_buscar?txt_idusuario=<%= c.getidusuario()%>" >Ver</a>
                                    <a class="boton active" title="Editar usuario" href="admin_controlador.srvlt_usuario_buscar_actualizar?txt_idusuario=<%= c.getidusuario()%>">Editar</a>
                                    <a class="boton active" title="Eliminar usuario" href="admin_controlador.srvlt_usuario_buscar_eliminar?txt_idusuario=<%= c.getidusuario()%>">Eliminar</a>
                                    <a class="boton active" title="Ver usuario" href="admin_controlador.srvlt_accesos_listar_todos?txt_usuario_id=<%= c.getidusuario()%>&op=unico" >Accesos</a>
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
                            col_3: "select",
                            col_4: "select",
                            col_5: "select",
                            col_6: "select",
                            col_7: "select",
                            col_8: "select",
                            col_9: "select",
                            col_10: "none",
                            display_all_text: "<TODOS>",
                            loader: true,
                            loader_css_class: "myLoader",
                            loader_html: '<img src="../includes/TableFilter/loader.gif" alt="" style="vertical-align:middle; margin-right:5px;">Cargando...'
                        };
                        var tf03 = setFilterGrid("lista_table_filter_usuario", table3Filters);
                    </script> 
                </div>
            </center>
        </form>
    </body>
</html>