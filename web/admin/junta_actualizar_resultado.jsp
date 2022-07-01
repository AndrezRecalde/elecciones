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
        <title>Datos-Juntas</title>
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
         <form name="form1" action="admin_controlador.srvlt_junta_actualizar">         <center>
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

<thead><tr><td colspan="2">Actualizar Junta</td></tr></thead>
<tbody>
<tr >
<td><b>ID</b>
</td><td><input type="text" name="txt_idjunta" required  value="<%= request.getParameter("txt_idjunta") %>" readonly>
</td>
</tr>
<tr >
<td><b>Zona</b>
</td><td><%
if (session.getAttribute("lista_combo_zonas") == null) {
                                        response.sendRedirect("srvlt_zonas_listar_combo?red=junta_ingresar.jsp");
                                        return;
                                    }   ArrayList<CObjetoCombo> lista_combo_zonas = (ArrayList<CObjetoCombo>) session.getAttribute("lista_combo_zonas");
   %>
<select name="txt_fr_id_zona">   <%for (CObjetoCombo c : lista_combo_zonas) {
   %>
    
<option <% if(c.getId()== Integer.parseInt(request.getParameter("txt_fr_id_zona").toString())){ %> selected <% }%> value="<%= c.getId() %>"><%= c.getValor() %></option>   <% } %></select>
</td>
</tr>
<tr >
<td><b>Código CNE</b>
</td><td><input type="text" name="txt_cne_cod_junta"   value="<%= request.getParameter("txt_cne_cod_junta") %>" >
</td>
</tr>
<tr >
<td><b>Número</b>
</td><td><input type="text" name="txt_num_junta"   value="<%= request.getParameter("txt_num_junta") %>" >
</td>
</tr>
<tr >
<td><b>Género</b>
</td><td><input type="text" name="txt_genero"  value="<%= request.getParameter("txt_genero") %>">
</td>
</tr>
<tr >
<td><b>Junta</b>
</td><td><input type="text" name="txt_junta_nombre"  value="<%= request.getParameter("txt_junta_nombre") %>">
</td>
</tr>
<tr >
<td><b>Número de electores CNE</b>
</td><td><input type="text" name="txt_num_electores_cne"   value="<%= request.getParameter("txt_num_electores_cne") %>" >
</td>
</tr>
<tr >
<td><b>Total de Huellas y Firmas</b>
</td><td><input type="text" name="txt_num_votaron"   value="<%= request.getParameter("txt_num_votaron") %>" >
</td>
</tr>
<tr >
<td><b>No votaron</b>
</td><td><input type="text" name="txt_num_no_votaron"   value="<%= request.getParameter("txt_num_no_votaron") %>" >
</td>
</tr>
<tr >
<td><b>Total de Huellas y Firmas 2</b>
</td><td><input type="text" name="txt_num_total_votaron"   value="<%= request.getParameter("txt_num_total_votaron") %>" >
</td>
</tr>
<tr >
<td><b>Receptada</b>
</td><td><select name="txt_receptada"><option value="1">SI</option><option value="0" <% if(!Boolean.parseBoolean(request.getParameter("txt_receptada").toString())){ %> selected <% }%>>NO</option></select>
</td>
</tr>
<tr >
<td><b>Nombre responsable</b>
</td><td><input type="text" name="txt_responsable"  value="<%= request.getParameter("txt_responsable") %>">
</td>
</tr>
<tr >
<td><b>Teléfono responsable</b>
</td><td><input type="text" name="txt_responsable_telefono"  value="<%= request.getParameter("txt_responsable_telefono") %>">
</td>
</tr>
<tr >
<td><b>ID Recinto</b>
</td><td><input type="text" name="txt_cod_recinto"   value="<%= request.getParameter("txt_cod_recinto") %>" >
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