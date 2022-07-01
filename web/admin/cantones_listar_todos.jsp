 <%-- 
    Document   : index
    Created on : Jul 12, 2014, 11:48:02 AM
    Author     : Generado V1.0
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="admin.Ccantones" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control Electoral-Cantones</title>
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
                        <li><a href="cantones_ingresar.jsp">Nuevo</a></li>
                        <li><a href="admin_controlador.srvlt_cantones_listar_todos">Listar Todos</a></li>
                        <li><a href="javascript:history.back(1)">Cancelar</a></li>
                        <li><a href="javascript:history.back(1)">Regresar</a></li>
                        <ul style="float:right;list-style-type:none;">
                            <li><a class="active" href="../salir.jsp">Salir</a></li>
                        </ul>
                    </ul>
                </div>
         <h1 class="titulo_h1">Control Electoral-Cantones</h1>
         <div class="contenedor_tabla">       <br>
      <span>Cantones </span>
<br>
<table id="lista_table_filter_cantones"   class="clsTablaDatos form_style">
<thead>
<tr>               
<td><b>cod de canton</b></td>               
<td><b>Provincia</b></td>               
<td><b>Nombre de canton</b></td>               
<td><b>Tiene circunscipciones</b></td>               
<td><b>Canton Padre</b></td><td></td>
</tr>
</thead>
<tbody>
                            <%
                                ArrayList<Ccantones> lista = (ArrayList<Ccantones>) session.getAttribute("lista_cantones");
                                for (Ccantones c : lista) {
                            %>
                            <tr ondblclick="document.location ='admin_controlador.srvlt_cantones_buscar?txt_cod_canton=<%= c.getcod_canton() %>'">
               
<td><%= c.getcod_canton() %></td>               
<td><%= c.getprovincia_string() %></td>               
<td><%= c.getnombre_canton() %></td>               
<td><% if(c.gettiene_circunscipciones()){%>SI<%}else{%>NO<%}%></td>               
<td><%= c.getfr_id_canton_pertenece() %></td><td><a class="boton active" title="Ver Cantón" href="admin_controlador.srvlt_cantones_buscar?txt_cod_canton=<%= c.getcod_canton() %>" >Ver</a>
  <a class="boton active" title="Editar Cantón" href="admin_controlador.srvlt_cantones_buscar_actualizar?txt_cod_canton=<%= c.getcod_canton() %>">Editar</a>
  <a class="boton active" title="Eliminar Cantón" href="admin_controlador.srvlt_cantones_buscar_eliminar?txt_cod_canton=<%= c.getcod_canton() %>">Eliminar</a>
<a class="boton active" title="Activar Cantón" href="admin_controlador.srvlt_cantones_buscar?txt_cod_canton=<%= c.getcod_canton() %>">Activar</a></td>                            </tr>
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
               col_1: "select",
               col_2: "input",
               col_3: "input",
               col_4: "input",
               col_5: "none",
                            display_all_text: "<TODOS>",
                            loader: true,
                            loader_css_class: "myLoader",
                            loader_html: '<img src="../includes/TableFilter/loader.gif" alt="" style="vertical-align:middle; margin-right:5px;">Cargando...'
                        };
                        var tf03 = setFilterGrid("lista_table_filter_cantones", table3Filters);
                    </script> 
         </div>
         </center>
         </form>
    </body>
</html>