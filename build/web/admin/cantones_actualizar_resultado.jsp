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
        <title>Control Electoral-Cantones</title>
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
         <form name="form1" action="admin_controlador.srvlt_cantones_actualizar">         <center>
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

<thead><tr><td colspan="2">Actualizar Cantón</td></tr></thead>
<tbody>
<tr >
<td><b>cod de canton</b>
</td><td><input type="text" name="txt_cod_canton" required  value="<%= request.getParameter("txt_cod_canton") %>" readonly>
</td>
</tr>
<tr >
<td><b>Provincia</b>
</td><td><%
if (session.getAttribute("lista_combo_provincia") == null) {
                                        response.sendRedirect("srvlt_provincia_listar_combo?red=cantones_ingresar.jsp");
                                        return;
                                    }   ArrayList<CObjetoCombo> lista_combo_provincia = (ArrayList<CObjetoCombo>) session.getAttribute("lista_combo_provincia");
   %>
<select name="txt_cod_provincia">   <%for (CObjetoCombo c : lista_combo_provincia) {
   %>
    
<option <% if(c.getId()== Integer.parseInt(request.getParameter("txt_cod_provincia").toString())){ %> selected <% }%> value="<%= c.getId() %>"><%= c.getValor() %></option>   <% } %></select>
</td>
</tr>
<tr >
<td><b>Nombre de canton</b>
</td><td><input type="text" name="txt_nombre_canton"  value="<%= request.getParameter("txt_nombre_canton") %>">
</td>
</tr>
<tr >
<td><b>Tiene circunscipciones</b>
</td><td><select name="txt_tiene_circunscipciones"><option value="1">SI</option><option value="0" <% if(!Boolean.parseBoolean(request.getParameter("txt_tiene_circunscipciones").toString())){ %> selected <% }%>>NO</option></select>
</td>
</tr>
<tr >
<td><b>Canton Padre</b>
</td><td><input type="text" name="txt_fr_id_canton_pertenece"   value="<%= request.getParameter("txt_fr_id_canton_pertenece") %>" >
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