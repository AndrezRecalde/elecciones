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
        <title>Sistema de Control Electoral-Recintos</title>
        	<LINK REL=StyleSheet HREF="../includes/tablas.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../includes/estillo_site.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../css/menu_opciones.css" TYPE="text/css" MEDIA=screen>
        <LINK REL=StyleSheet HREF="../css/form_style.css" TYPE="text/css" MEDIA=screen>
	<link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
         <form name="form1" action="admin_controlador.srvlt_recintos_insert">         <center>
                <div class="menu_horizontal">
                    <ul>
                        <li><a href="recintos_ingresar.jsp">Nueva</a></li>
                        <li><a href="admin_controlador.srvlt_recintos_listar_todos">Listar Todas</a></li>
                        <li><a href="javascript:history.back(1)">Cancelar</a></li>
                        <li><a href="javascript:history.back(1)">Regresar</a></li>
                        <ul style="float:right;list-style-type:none;">
                            <li><a class="active" href="../salir.jsp">Salir</a></li>
                        </ul>
                    </ul>
                </div>         <h1 class="titulo_h1">Sistema de Control Electoral-Recintos</h1>
         <div class="contenedor_tabla"><table  class="clsTablaDatos form_style">

<thead><tr><td colspan="2">Detalles del Recinto</td></tr></thead>
<tbody>
<tr ><td><b>Cod de Recinto</b>
</td>
<td>
<input readonly type="text" name="txt_cod_recinto" value="<%= request.getParameter("txt_cod_recinto")%>">
</td>
</tr>

<tr ><td><b>Parroquia</b>
</td>
<td>
<input readonly type="text" name="txt_cod_parroquia" value="<%= request.getParameter("txt_cod_parroquia")%>">
</td>
</tr>

<tr ><td><b>Parroquia</b>
</td>
<td>
<input readonly type="text" name="txt_parroquia_nombre" value="<%= request.getParameter("txt_parroquia_nombre")%>">
</td>
</tr>

<tr ><td><b>Nombre de Recinto</b>
</td>
<td>
<input readonly type="text" name="txt_nombre_recinto" value="<%= request.getParameter("txt_nombre_recinto")%>">
</td>
</tr>

<tr ><td><b>Dirección de Recinto</b>
</td>
<td>
<input readonly type="text" name="txt_direccion_recinto" value="<%= request.getParameter("txt_direccion_recinto")%>">
</td>
</tr>

<tr ><td><b>Zona</b>
</td>
<td>
<input readonly type="text" name="txt_cod_zona" value="<%= request.getParameter("txt_cod_zona")%>">
</td>
</tr>

<tr ><td><b>Num Jun Mas</b>
</td>
<td>
<input readonly type="text" name="txt_num_jun_mas" value="<%= request.getParameter("txt_num_jun_mas")%>">
</td>
</tr>

<tr ><td><b>Num Jun Fem</b>
</td>
<td>
<input readonly type="text" name="txt_num_jun_fem" value="<%= request.getParameter("txt_num_jun_fem")%>">
</td>
</tr>

<tr ><td><b>Num Juntas</b>
</td>
<td>
<input readonly type="text" name="txt_num_juntas" value="<%= request.getParameter("txt_num_juntas")%>">
</td>
</tr>

<tr ><td><b>CI Responsable</b>
</td>
<td>
<input readonly type="text" name="txt_responsable_ci" value="<%= request.getParameter("txt_responsable_ci")%>">
</td>
</tr>

<tr ><td><b>Nombres y Apellidos del Responsable</b>
</td>
<td>
<input readonly type="text" name="txt_responsable_nombres" value="<%= request.getParameter("txt_responsable_nombres")%>">
</td>
</tr>

<tr ><td><b>Teléfonos del Responsable</b>
</td>
<td>
<input readonly type="text" name="txt_responsable_telefono" value="<%= request.getParameter("txt_responsable_telefono")%>">
</td>
</tr>

<tr ><td><b>Número en que Inicia Femenino</b>
</td>
<td>
<input readonly type="text" name="txt_jun_ini_f" value="<%= request.getParameter("txt_jun_ini_f")%>">
</td>
</tr>

<tr ><td><b>Número en que Finaliza Femenino</b>
</td>
<td>
<input readonly type="text" name="txt_jun_fin_f" value="<%= request.getParameter("txt_jun_fin_f")%>">
</td>
</tr>

<tr ><td><b>Número en que Inicia Masculino</b>
</td>
<td>
<input readonly type="text" name="txt_jun_ini_m" value="<%= request.getParameter("txt_jun_ini_m")%>">
</td>
</tr>

<tr ><td><b>Número en que Finaliza Masculino</b>
</td>
<td>
<input readonly type="text" name="txt_jun_fin_m" value="<%= request.getParameter("txt_jun_fin_m")%>">
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