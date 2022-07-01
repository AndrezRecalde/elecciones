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
        <title>Datos-Actas</title>
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
         <form name="form1" action="admin_controlador.srvlt_acta_actualizar">         <center>
                <div class="menu_horizontal">
                    <ul>
                        <li><a href="acta_ingresar.jsp">Nueva junta</a></li>
                        <li><a href="admin_controlador.srvlt_acta_listar_todos">Listar Todos</a></li>
                        <li><a href="javascript:history.back(1)">Cancelar</a></li>
                        <li><a href="javascript:history.back(1)">Regresar</a></li>
                        <ul style="float:right;list-style-type:none;">
                            <li><a class="active" href="../salir.jsp">Salir</a></li>
                        </ul>
                    </ul>
                </div>         <h1 class="titulo_h1">Datos-Actas</h1>
         <div class="contenedor_tabla">
<table  class="clsTablaDatos form_style">

<thead><tr><td colspan="2">Actualizar Acta</td></tr></thead>
<tbody>
<tr >
<td><b>idacta</b>
</td><td><input type="text" name="txt_idacta" required  value="<%= request.getParameter("txt_idacta") %>" readonly>
</td>
</tr>
<tr >
<td><b>Provincia</b>
</td><td><input type="text" name="txt_cod_provincia"   value="<%= request.getParameter("txt_cod_provincia") %>" >
</td>
</tr>
<tr >
<td><b>Canton</b>
</td><td><input type="text" name="txt_cod_canton"   value="<%= request.getParameter("txt_cod_canton") %>" >
</td>
</tr>
<tr >
<td><b>Parroquia</b>
</td><td><input type="text" name="txt_cod_parroquia"   value="<%= request.getParameter("txt_cod_parroquia") %>" >
</td>
</tr>
<tr >
<td><b>Zona</b>
</td><td><input type="text" name="txt_cod_zona"   value="<%= request.getParameter("txt_cod_zona") %>" >
</td>
</tr>
<tr >
<td><b>Junta</b>
</td><td><%
if (session.getAttribute("lista_combo_junta") == null) {
                                        response.sendRedirect("srvlt_junta_listar_combo?red=acta_ingresar.jsp");
                                        return;
                                    }   ArrayList<CObjetoCombo> lista_combo_junta = (ArrayList<CObjetoCombo>) session.getAttribute("lista_combo_junta");
   %>
<select name="txt_fr_id_junta">   <%for (CObjetoCombo c : lista_combo_junta) {
   %>
    
<option <% if(c.getId()== Integer.parseInt(request.getParameter("txt_fr_id_junta").toString())){ %> selected <% }%> value="<%= c.getId() %>"><%= c.getValor() %></option>   <% } %></select>
</td>
</tr>
<tr >
<td><b>Dignidad</b>
</td><td><input type="text" name="txt_fr_id_dignidad"   value="<%= request.getParameter("txt_fr_id_dignidad") %>" >
</td>
</tr>
<tr >
<td><b>Código de Acta CNE</b>
</td><td><input type="text" name="txt_cne_cod_acta"   value="<%= request.getParameter("txt_cne_cod_acta") %>" >
</td>
</tr>
<tr >
<td><b>Total Huellas y Firmas</b>
</td><td><input type="text" name="txt_num_validos"   value="<%= request.getParameter("txt_num_validos") %>" >
</td>
</tr>
<tr >
<td><b>No votaron</b>
</td><td><input type="text" name="txt_num_no_voto"   value="<%= request.getParameter("txt_num_no_voto") %>" >
</td>
</tr>
<tr >
<td><b>Total de Votos en Blancos</b>
</td><td><input type="text" name="txt_num_blancos"   value="<%= request.getParameter("txt_num_blancos") %>" >
</td>
</tr>
<tr >
<td><b>Total de Votos Nulos</b>
</td><td><input type="text" name="txt_num_nulos"   value="<%= request.getParameter("txt_num_nulos") %>" >
</td>
</tr>
<tr >
<td><b>Ingresada</b>
</td><td><input type="text" name="txt_acta_usu_ing"   value="<%= request.getParameter("txt_acta_usu_ing") %>" >
</td>
</tr>
<tr >
<td><b>Modificada</b>
</td><td><input type="text" name="txt_acta_usu_mod"   value="<%= request.getParameter("txt_acta_usu_mod") %>" >
</td>
</tr>
<tr >
<td><b>Cuadrada?</b>
</td><td><select name="txt_cuadrada"><option value="1">SI</option><option value="0" <% if(!Boolean.parseBoolean(request.getParameter("txt_cuadrada").toString())){ %> selected <% }%>>NO</option></select>
</td>
</tr>
<tr >
<td><b>Es Legible?</b>
</td><td><select name="txt_legible"><option value="1">SI</option><option value="0" <% if(!Boolean.parseBoolean(request.getParameter("txt_legible").toString())){ %> selected <% }%>>NO</option></select>
</td>
</tr>
<tr >
<td><b>Estado</b>
</td><td><input type="text" name="txt_fr_id_acta_estado"   value="<%= request.getParameter("txt_fr_id_acta_estado") %>" >
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