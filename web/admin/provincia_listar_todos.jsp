 <%-- 
    Document   : index
    Created on : Jul 12, 2014, 11:48:02 AM
    Author     : Generado V1.0
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="admin.Cprovincia" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos-Provincias</title>
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
                        <li><a href="provincia_ingresar.jsp">Nueva</a></li>
                        <li><a href="admin_controlador.srvlt_provincia_listar_todos">Listar Todos</a></li>
                        <li><a href="javascript:history.back(1)">Cancelar</a></li>
                        <li><a href="javascript:history.back(1)">Regresar</a></li>
                        <ul style="float:right;list-style-type:none;">
                            <li><a class="active" href="../salir.jsp">Salir</a></li>
                        </ul>
                    </ul>
                </div>
         <h1 class="titulo_h1">Datos-Provincias</h1>
         <div class="contenedor_tabla">       <br>
      <span>Provincias </span>
<br>
<table id="lista_table_filter_provincia"   class="clsTablaDatos form_style">
<thead>
<tr>               
<td><b>CNE Cod Prov</b></td>               
<td><b>Nombre</b></td>               
<td><b>num de vot de hombres</b></td>               
<td><b>num de vot de mujeres</b></td>               
<td><b>activa</b></td><td></td>
</tr>
</thead>
<tbody>
                            <%
                                ArrayList<Cprovincia> lista = (ArrayList<Cprovincia>) session.getAttribute("lista_provincia");
                                for (Cprovincia c : lista) {
                            %>
                            <tr ondblclick="document.location ='admin_controlador.srvlt_provincia_buscar?txt_cne_cod_prov=<%= c.getcne_cod_prov() %>'">
               
<td><%= c.getcne_cod_prov() %></td>               
<td><%= c.getnombre_provincia() %></td>               
<td><%= c.getnum_vot_hombres() %></td>               
<td><%= c.getnum_vot_mujeres() %></td>               
<td><% if(c.getactiva()){%>SI<%}else{%>NO<%}%></td><td><a class="boton active" title="Ver Provincia" href="admin_controlador.srvlt_provincia_buscar?txt_cne_cod_prov=<%= c.getcne_cod_prov() %>" >Ver</a>
  <a class="boton active" title="Editar Provincia" href="admin_controlador.srvlt_provincia_buscar_actualizar?txt_cne_cod_prov=<%= c.getcne_cod_prov() %>">Editar</a>
  <a class="boton active" title="Eliminar Provincia" href="admin_controlador.srvlt_provincia_buscar_eliminar?txt_cne_cod_prov=<%= c.getcne_cod_prov() %>">Eliminar</a>
<a class="boton active" title="Activar Provincia" href="admin_controlador.srvlt_provincia_buscar?txt_cne_cod_prov=<%= c.getcne_cod_prov() %>">Activar</a></td>                            </tr>
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
               col_5: "none",
                            display_all_text: "<TODOS>",
                            loader: true,
                            loader_css_class: "myLoader",
                            loader_html: '<img src="../includes/TableFilter/loader.gif" alt="" style="vertical-align:middle; margin-right:5px;">Cargando...'
                        };
                        var tf03 = setFilterGrid("lista_table_filter_provincia", table3Filters);
                    </script> 
         </div>
         </center>
         </form>
    </body>
</html>