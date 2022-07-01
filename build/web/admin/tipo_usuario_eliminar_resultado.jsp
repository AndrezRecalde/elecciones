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
        <title>Datos-Tipos de usuarios</title>
        	<LINK REL=StyleSheet HREF="../includes/tablas.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../includes/estillo_site.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../css/menu_opciones.css" TYPE="text/css" MEDIA=screen>
        <LINK REL=StyleSheet HREF="../css/form_style.css" TYPE="text/css" MEDIA=screen>
	<link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
         <form name="form1" action="admin_controlador.srvlt_tipo_usuario_eliminar">         <center>
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

<thead>
<tr>
<td colspan="2">Elimninar Tipo de usuario</td>
</tr>
</thead>
<tbody>

<tr class="alt"> 
<td><b>idtipo de usuario</b></td>
<td><input type="text" name="txt_idtipo_usuario" readonly value="<%= request.getParameter("txt_idtipo_usuario")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>nombre de tipo de usuario</b></td>
<td><input type="text" name="txt_nombre_tipo_usuario" readonly value="<%= request.getParameter("txt_nombre_tipo_usuario")%>">
</td>
</tr>

<tr class="alt"><td><b>activo</b>
</td>
<td>
<input readonly type="text" name="txt_activo" <% if(request.getParameter("txt_activo").contains("true")){%>value="SI"<%}else{%>value="NO"<%}%>>
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
