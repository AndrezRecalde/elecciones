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
        <title>Datos-Juntas</title>
        	<LINK REL=StyleSheet HREF="../includes/tablas.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../includes/estillo_site.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../css/menu_opciones.css" TYPE="text/css" MEDIA=screen>
        <LINK REL=StyleSheet HREF="../css/form_style.css" TYPE="text/css" MEDIA=screen>
	<link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
         <form name="form1" action="admin_controlador.srvlt_junta_eliminar">         <center>
                <div class="menu_horizontal">
                    <ul>
                        <li><a href="junta_ingresar.jsp">Nueva junta</a></li>
                        <li><a href="admin_controlador.srvlt_fisc_tipo_planilla_listar_todos">Listar Todos</a></li>
                        <li><a href="javascript:history.back(1)">Cancelar</a></li>
                        <li><a href="javascript:history.back(1)">Regresar</a></li>
                        <ul style="float:right;list-style-type:none;">
                            <li><a class="active" href="../salir.jsp">Salir</a></li>
                        </ul>
                    </ul>
                </div>         <h1 class="titulo_h1">Datos-Juntas</h1>
         <div class="contenedor_tabla">
<table  class="clsTablaDatos form_style">

<thead>
<tr>
<td colspan="2">Elimninar Junta</td>
</tr>
</thead>
<tbody>

<tr class="alt"> 
<td><b>ID</b></td>
<td><input type="text" name="txt_idjunta" readonly value="<%= request.getParameter("txt_idjunta")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Zona</b></td>
<td><input type="text" name="txt_fr_id_zona" readonly value="<%= request.getParameter("txt_fr_id_zona")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Zona</b></td>
<td><input type="text" name="txt_zonas_string" readonly value="<%= request.getParameter("txt_zonas_string")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Código CNE</b></td>
<td><input type="text" name="txt_cne_cod_junta" readonly value="<%= request.getParameter("txt_cne_cod_junta")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Número</b></td>
<td><input type="text" name="txt_num_junta" readonly value="<%= request.getParameter("txt_num_junta")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Género</b></td>
<td><input type="text" name="txt_genero" readonly value="<%= request.getParameter("txt_genero")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Junta</b></td>
<td><input type="text" name="txt_junta_nombre" readonly value="<%= request.getParameter("txt_junta_nombre")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Número de electores CNE</b></td>
<td><input type="text" name="txt_num_electores_cne" readonly value="<%= request.getParameter("txt_num_electores_cne")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Total de Huellas y Firmas</b></td>
<td><input type="text" name="txt_num_votaron" readonly value="<%= request.getParameter("txt_num_votaron")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>No votaron</b></td>
<td><input type="text" name="txt_num_no_votaron" readonly value="<%= request.getParameter("txt_num_no_votaron")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Total de Huellas y Firmas 2</b></td>
<td><input type="text" name="txt_num_total_votaron" readonly value="<%= request.getParameter("txt_num_total_votaron")%>">
</td>
</tr>

<tr class="alt"><td><b>Receptada</b>
</td>
<td>
<input readonly type="text" name="txt_receptada" <% if(request.getParameter("txt_receptada").contains("true")){%>value="SI"<%}else{%>value="NO"<%}%>>
</td>
</tr>

<tr class="alt"> 
<td><b>Nombre responsable</b></td>
<td><input type="text" name="txt_responsable" readonly value="<%= request.getParameter("txt_responsable")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Teléfono responsable</b></td>
<td><input type="text" name="txt_responsable_telefono" readonly value="<%= request.getParameter("txt_responsable_telefono")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>ID Recinto</b></td>
<td><input type="text" name="txt_cod_recinto" readonly value="<%= request.getParameter("txt_cod_recinto")%>">
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
