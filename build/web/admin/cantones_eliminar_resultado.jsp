 <%-- 
    Document   : index
    Created on : Jul 12, 2014, 11:48:02 AM
    Author     : Generado V1.0
--%>

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
         <form name="form1" action="admin_controlador.srvlt_cantones_eliminar">         <center>
                <div class="menu_horizontal">
                    <ul>
                        <li><a href="cantones_ingresar.jsp">Nuevo</a></li>
                        <li><a href="admin_controlador.srvlt_cantones_listar_todos">Listar Todos</a></li>
                        <li><a href="javascript:history.back(1)">Cancelar</a></li>
                        <li><a href="javascript:history.back(1)">Regresar</a></li>
                        <ul style="float:right;list-style-type:none;">
                            <li><a class="active" href="../salir.jsp">Salir</a></li>
                        </ul>
                    </ul>
                </div>         <h1 class="titulo_h1">Control Electoral-Cantones</h1>
         <div class="contenedor_tabla">
<table  class="clsTablaDatos form_style">

<thead>
<tr>
<td colspan="2">Elimninar Cantón</td>
</tr>
</thead>
<tbody>

<tr class="alt"> 
<td><b>cod de canton</b></td>
<td><input type="text" name="txt_cod_canton" readonly value="<%= request.getParameter("txt_cod_canton")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Provincia</b></td>
<td><input type="text" name="txt_cod_provincia" readonly value="<%= request.getParameter("txt_cod_provincia")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Provincia</b></td>
<td><input type="text" name="txt_provincia_string" readonly value="<%= request.getParameter("txt_provincia_string")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Nombre de canton</b></td>
<td><input type="text" name="txt_nombre_canton" readonly value="<%= request.getParameter("txt_nombre_canton")%>">
</td>
</tr>

<tr class="alt"><td><b>Tiene circunscipciones</b>
</td>
<td>
<input readonly type="text" name="txt_tiene_circunscipciones" <% if(request.getParameter("txt_tiene_circunscipciones").contains("true")){%>value="SI"<%}else{%>value="NO"<%}%>>
</td>
</tr>

<tr class="alt"> 
<td><b>Canton Padre</b></td>
<td><input type="text" name="txt_fr_id_canton_pertenece" readonly value="<%= request.getParameter("txt_fr_id_canton_pertenece")%>">
</td>
</tr>

</tbody><tfoot>
<tr>
<td colspan="2" style="text-align:center;"><input type="submit" name="eliminar" value="Eliminar">
</td>
</tr>
<tr>
<td colspan="2" style="text-align:center;">
<a href="javascript:history.back(1)">Volver Atrás</a>
</td>
</tr>
</tfoot>         </table>
</div>
         </center>
         </form>
    </body>
</html>
