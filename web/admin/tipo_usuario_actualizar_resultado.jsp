 <%-- 
    Document   : index
    Created on : Jul 12, 2014, 11:48:02 AM
    Author     : Generado V1.0
--%>

<%@page import="admin.CObjetoCombo"%>
<%@page import="java.util.ArrayList"%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos-Tipos de usuarios</title>
        <link href="includes/CalendarControl.css" rel="stylesheet" type="text/css">
        <script src="includes/CalendarControl.js" language="javascript">
</script>
        	<LINK REL=StyleSheet HREF="../includes/tablas.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../includes/estillo_site.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../css/menu_opciones.css" TYPE="text/css" MEDIA=screen>
        <LINK REL=StyleSheet HREF="../css/form_style.css" TYPE="text/css" MEDIA=screen>
	<link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
         <form name="form1" action="admin_controlador.srvlt_tipo_usuario_actualizar">         <center>
                <div class="menu_horizontal">
                    <ul>
                        <li><a href="usuario_ingresar.jsp">Nueva junta</a></li>
                        <li><a href="admin_controlador.srvlt_usuario_listar_todos">Listar Todos</a></li>
                        <li><a href="javascript:history.back(1)">Cancelar</a></li>
                        <li><a href="javascript:history.back(1)">Regresar</a></li>
                        <ul style="float:right;list-style-type:none;">
                            <li><a class="active" href="../salir.jsp">Salir</a></li>
                        </ul>
                    </ul>
                </div>         <h1 class="titulo_h1">Datos-Tipos de usuarios</h1>
         <div class="contenedor_tabla">
<table  class="clsTablaDatos form_style">

<thead><tr><td colspan="2">Actualizar Tipo de usuario</td></tr></thead>
<tbody>
<tr >
<td><b>idtipo de usuario</b>
</td><td><input type="text" name="txt_idtipo_usuario" required  value="<%= request.getParameter("txt_idtipo_usuario") %>" readonly>
</td>
</tr>
<tr >
<td><b>nombre de tipo de usuario</b>
</td><td><input type="text" name="txt_nombre_tipo_usuario"  value="<%= request.getParameter("txt_nombre_tipo_usuario") %>">
</td>
</tr>
<tr >
<td><b>activo</b>
</td><td><select name="txt_activo"><option value="1">SI</option><option value="0" <% if(!Boolean.parseBoolean(request.getParameter("txt_activo").toString())){ %> selected <% }%>>NO</option></select>
</td>
</tr>
<tr>
                                <td colspan="2"><label for="regresar_editar"><input id="regresar_editar" type="checkbox" name="regresar_editar">Actualizar y quedarse en esta pantalla para ver el registro modificado.</label>
                                </td>
                            </tr></tbody><tfoot>
<tr>
<td colspan="2" style="text-align:center;">
<input type="submit" name="actualizar" value="Actualizar">
</td>
</tr>
<tr>
<td colspan="2" style="text-align:center;">
<a href="javascript:history.back(1)">Volver Atrás</a>
</td>
</tr>
</tfoot>
         </table>
</div>
         </center>
         </form>
    </body>
</html>