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
        <title>Sistema de Control Electoral-Imágenes de Actas</title>
        	<LINK REL=StyleSheet HREF="../includes/tablas.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../includes/estillo_site.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../css/menu_opciones.css" TYPE="text/css" MEDIA=screen>
        <LINK REL=StyleSheet HREF="../css/form_style.css" TYPE="text/css" MEDIA=screen>
	<link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
         <form name="form1" action="admin_controlador.srvlt_acta_images_insert">         <center>
                <div class="menu_horizontal">
                    <ul>
                        <li><a href="acta_images_ingresar.jsp">Nueva</a></li>
                        <li><a href="admin_controlador.srvlt_acta_images_listar_todos">Listar Todas</a></li>
                        <li><a href="javascript:history.back(1)">Cancelar</a></li>
                        <li><a href="javascript:history.back(1)">Regresar</a></li>
                        <ul style="float:right;list-style-type:none;">
                            <li><a class="active" href="../salir.jsp">Salir</a></li>
                        </ul>
                    </ul>
                </div>         <h1 class="titulo_h1">Sistema de Control Electoral-Imágenes de Actas</h1>
         <div class="contenedor_tabla"><table  class="clsTablaDatos form_style">

<thead><tr><td colspan="2">Detalles del Imágen de acta</td></tr></thead>
<tbody>
<tr ><td><b>ID</b>
</td>
<td>
<input readonly type="text" name="txt_idacta_images" value="<%= request.getParameter("txt_idacta_images")%>">
</td>
</tr>

<tr ><td><b>Subida por</b>
</td>
<td>
<input readonly type="text" name="txt_acta_image_usu_ing" value="<%= request.getParameter("txt_acta_image_usu_ing")%>">
</td>
</tr>

<tr ><td><b>Subida por</b>
</td>
<td>
<input readonly type="text" name="txt_usuario_string" value="<%= request.getParameter("txt_usuario_string")%>">
</td>
</tr>

<tr ><td><b>Junta</b>
</td>
<td>
<input readonly type="text" name="txt_acta_image_id_junta" value="<%= request.getParameter("txt_acta_image_id_junta")%>">
</td>
</tr>

<tr ><td><b>Junta</b>
</td>
<td>
<input readonly type="text" name="txt_junta_string" value="<%= request.getParameter("txt_junta_string")%>">
</td>
</tr>

<tr ><td><b>Dignidad</b>
</td>
<td>
<input readonly type="text" name="txt_acta_image_id_dignidad" value="<%= request.getParameter("txt_acta_image_id_dignidad")%>">
</td>
</tr>

<tr ><td><b>Dignidad</b>
</td>
<td>
<input readonly type="text" name="txt_dignidad_string" value="<%= request.getParameter("txt_dignidad_string")%>">
</td>
</tr>

<tr ><td><b>Activa</b>
</td>
<td>
<input readonly type="text" name="txt_acta_image_activa" <% if(request.getParameter("txt_acta_image_activa").contains("true")){%>value="SI"<%}else{%>value="NO"<%}%>>
</td>
</tr>

<tr ><td><b>Fecha de Subida</b>
</td>
<td>
<input readonly type="text" name="txt_acta_image_fi" value="<%= request.getParameter("txt_acta_image_fi")%>">
</td>
</tr>

<tr ><td><b>UM</b>
</td>
<td>
<input readonly type="text" name="txt_acta_image_um" value="<%= request.getParameter("txt_acta_image_um")%>">
</td>
</tr>

</tbody>
<tfoot>
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