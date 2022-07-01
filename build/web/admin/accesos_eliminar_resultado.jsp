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
         <form name="form1" action="admin_controlador.srvlt_accesos_eliminar">         <center>
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
         <div class="contenedor_tabla">
<table  class="clsTablaDatos form_style">

<thead>
<tr>
<td colspan="2">Elimninar Acceso</td>
</tr>
</thead>
<tbody>

<tr class="alt"> 
<td><b>ID</b></td>
<td><input type="text" name="txt_idaccesos" readonly value="<%= request.getParameter("txt_idaccesos")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>USUARIO</b></td>
<td><input type="text" name="txt_usuario_id" readonly value="<%= request.getParameter("txt_usuario_id")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>USUARIO</b></td>
<td><input type="text" name="txt_usuario_string" readonly value="<%= request.getParameter("txt_usuario_string")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>OPCIÓN</b></td>
<td><input type="text" name="txt_acceso_opcion_id" readonly value="<%= request.getParameter("txt_acceso_opcion_id")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>OPCIÓN</b></td>
<td><input type="text" name="txt_acceso_opcion_string" readonly value="<%= request.getParameter("txt_acceso_opcion_string")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>FECHA</b></td>
<td><input type="text" name="txt_acceso_fecha" readonly value="<%= request.getParameter("txt_acceso_fecha")%>">
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
