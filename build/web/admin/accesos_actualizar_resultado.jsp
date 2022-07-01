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
        <title>Sistema de Control Electoral-Accesos de Usuarios</title>
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
         <form name="form1" action="admin_controlador.srvlt_accesos_actualizar">         <center>
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

<thead><tr><td colspan="2">Actualizar Acceso</td></tr></thead>
<tbody>
<tr >
<td><b>ID</b>
</td><td><input type="text" name="txt_idaccesos" required  value="<%= request.getParameter("txt_idaccesos") %>" readonly>
</td>
</tr>
<tr >
<td><b>USUARIO</b>
</td><td><%
if (session.getAttribute("lista_combo_usuario") == null) {
                                        response.sendRedirect("srvlt_usuario_listar_combo?red=accesos_ingresar.jsp");
                                        return;
                                    }   ArrayList<CObjetoCombo> lista_combo_usuario = (ArrayList<CObjetoCombo>) session.getAttribute("lista_combo_usuario");
   %>
<select name="txt_usuario_id">   <%for (CObjetoCombo c : lista_combo_usuario) {
   %>
    
<option <% if(c.getId()== Integer.parseInt(request.getParameter("txt_usuario_id").toString())){ %> selected <% }%> value="<%= c.getId() %>"><%= c.getValor() %></option>   <% } %></select>
</td>
</tr>
<tr >
<td><b>OPCIÓN</b>
</td><td><%
if (session.getAttribute("lista_combo_acceso_opcion") == null) {
                                        response.sendRedirect("srvlt_acceso_opcion_listar_combo?red=accesos_ingresar.jsp");
                                        return;
                                    }   ArrayList<CObjetoCombo> lista_combo_acceso_opcion = (ArrayList<CObjetoCombo>) session.getAttribute("lista_combo_acceso_opcion");
   %>
<select name="txt_acceso_opcion_id">   <%for (CObjetoCombo c : lista_combo_acceso_opcion) {
   %>
    
<option <% if(c.getId()== Integer.parseInt(request.getParameter("txt_acceso_opcion_id").toString())){ %> selected <% }%> value="<%= c.getId() %>"><%= c.getValor() %></option>   <% } %></select>
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