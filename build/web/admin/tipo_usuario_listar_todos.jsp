 <%-- 
    Document   : index
    Created on : Jul 12, 2014, 11:48:02 AM
    Author     : Generado V1.0
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="admin.Ctipo_usuario" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos-Tipos de usuarios</title>
        	<LINK REL=StyleSheet HREF="../includes/tablas.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../includes/estillo_site.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../css/menu_opciones.css" TYPE="text/css" MEDIA=screen>
        <LINK REL=StyleSheet HREF="../css/form_style.css" TYPE="text/css" MEDIA=screen>
	<link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
    <% SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); %>
         <form name="form1">
         <center>                <div class="menu_horizontal">
                    <ul>
                        <li><a href="usuario_ingresar.jsp">Nueva junta</a></li>
                        <li><a href="admin_controlador.srvlt_usuario_listar_todos">Listar Todos</a></li>
                        <li><a href="javascript:history.back(1)">Cancelar</a></li>
                        <li><a href="javascript:history.back(1)">Regresar</a></li>
                        <ul style="float:right;list-style-type:none;">
                            <li><a class="active" href="../salir.jsp">Salir</a></li>
                        </ul>
                    </ul>
                </div>
         <h1 class="titulo_h1">Datos-Tipos de usuarios</h1>
         <div class="contenedor_tabla">       <br>
      <span>Tipos de usuarios </span>
<br>
<table id="lista_table_filter_tipo_usuario"   class="clsTablaDatos form_style">
<thead>
<tr>               
<td><b>idtipo de usuario</b></td>               
<td><b>nombre de tipo de usuario</b></td>               
<td><b>activo</b></td><td></td>
</tr>
</thead>
<tbody>
                            <%
                                ArrayList<Ctipo_usuario> lista = (ArrayList<Ctipo_usuario>) session.getAttribute("lista_tipo_usuario");
                                for (Ctipo_usuario c : lista) {
                            %>
                            <tr ondblclick="document.location ='admin_controlador.srvlt_tipo_usuario_buscar?txt_idtipo_usuario=<%= c.getidtipo_usuario() %>'">
               
<td><%= c.getidtipo_usuario() %></td>               
<td><%= c.getnombre_tipo_usuario() %></td>               
<td><% if(c.getactivo()){%>SI<%}else{%>NO<%}%></td><td><a class="boton active" title="Ver Tipo de usuario" href="admin_controlador.srvlt_tipo_usuario_buscar?txt_idtipo_usuario=<%= c.getidtipo_usuario() %>" >Ver</a>
  <a class="boton active" title="Editar Tipo de usuario" href="admin_controlador.srvlt_tipo_usuario_buscar_actualizar?txt_idtipo_usuario=<%= c.getidtipo_usuario() %>">Editar</a>
  <a class="boton active" title="Eliminar Tipo de usuario" href="admin_controlador.srvlt_tipo_usuario_buscar_eliminar?txt_idtipo_usuario=<%= c.getidtipo_usuario() %>">Eliminar</a>
<a class="boton active" title="Activar Tipo de usuario" href="admin_controlador.srvlt_tipo_usuario_buscar?txt_idtipo_usuario=<%= c.getidtipo_usuario() %>">Activar</a></td>                            </tr>
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
               col_3: "none",
                            display_all_text: "<TODOS>",
                            loader: true,
                            loader_css_class: "myLoader",
                            loader_html: '<img src="../includes/TableFilter/loader.gif" alt="" style="vertical-align:middle; margin-right:5px;">Cargando...'
                        };
                        var tf03 = setFilterGrid("lista_table_filter_tipo_usuario", table3Filters);
                    </script> 
         </div>
         </center>
         </form>
    </body>
</html>