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
        <title>Sistema de Control Electoral-Accesos de Usuarios</title>
        	<LINK REL=StyleSheet HREF="../includes/tablas.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../includes/estillo_site.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../css/menu_opciones.css" TYPE="text/css" MEDIA=screen>
        <LINK REL=StyleSheet HREF="../css/form_style.css" TYPE="text/css" MEDIA=screen>
	<link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
         <form name="form1" action="admin_controlador.srvlt_accesos_insert">         <center>
                <div class="menu_horizontal">
                    <ul>
                        <li><a href="accesos_ingresar.jsp">Nuevo</a></li>
                        <li><a href="admin_controlador.srvlt_accesos_listar_todos">Listar Todos</a></li>
                        <li><a href="javascript:history.back(1)">Cancelar</a></li>
                        <li><a href="javascript:history.back(1)">Regresar</a></li>
                        <ul style="float:right;list-style-type:none;">
                            <li><a class="active" href="../salir.jsp">Salir</a></li>
                        </ul>
                    </ul>
                </div>         <h1 class="titulo_h1">Sistema de Control Electoral-Accesos de Usuarios</h1>
         <div class="contenedor_tabla"><table  class="clsTablaDatos form_style">

<thead><tr><td colspan="2">Detalles del Acceso</td></tr></thead>
<tbody>
<tr ><td><b>ID</b>
</td>
<td>
<input readonly type="text" name="txt_idaccesos" value="<%= request.getParameter("txt_idaccesos")%>">
</td>
</tr>

<tr ><td><b>USUARIO</b>
</td>
<td>
<input readonly type="text" name="txt_usuario_id" value="<%= request.getParameter("txt_usuario_id")%>">
</td>
</tr>

<tr ><td><b>USUARIO</b>
</td>
<td>
<input readonly type="text" name="txt_usuario_string" value="<%= request.getParameter("txt_usuario_string")%>">
</td>
</tr>

<tr ><td><b>OPCIÓN</b>
</td>
<td>
<input readonly type="text" name="txt_acceso_opcion_id" value="<%= request.getParameter("txt_acceso_opcion_id")%>">
</td>
</tr>

<tr ><td><b>OPCIÓN</b>
</td>
<td>
<input readonly type="text" name="txt_acceso_opcion_string" value="<%= request.getParameter("txt_acceso_opcion_string")%>">
</td>
</tr>

<tr ><td><b>FECHA</b>
</td>
<td>
<input readonly type="text" name="txt_acceso_fecha" value="<%= request.getParameter("txt_acceso_fecha")%>">
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