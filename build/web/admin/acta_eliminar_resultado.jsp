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
        <title>Datos-Actas</title>
        	<LINK REL=StyleSheet HREF="../includes/tablas.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../includes/estillo_site.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../css/menu_opciones.css" TYPE="text/css" MEDIA=screen>
        <LINK REL=StyleSheet HREF="../css/form_style.css" TYPE="text/css" MEDIA=screen>
	<link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
         <form name="form1" action="admin_controlador.srvlt_acta_eliminar">         <center>
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

<thead>
<tr>
<td colspan="2">Elimninar Acta</td>
</tr>
</thead>
<tbody>

<tr class="alt"> 
<td><b>idacta</b></td>
<td><input type="text" name="txt_idacta" readonly value="<%= request.getParameter("txt_idacta")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Provincia</b></td>
<td><input type="text" name="txt_cod_provincia" readonly value="<%= request.getParameter("txt_cod_provincia")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Canton</b></td>
<td><input type="text" name="txt_cod_canton" readonly value="<%= request.getParameter("txt_cod_canton")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Parroquia</b></td>
<td><input type="text" name="txt_cod_parroquia" readonly value="<%= request.getParameter("txt_cod_parroquia")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Zona</b></td>
<td><input type="text" name="txt_cod_zona" readonly value="<%= request.getParameter("txt_cod_zona")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Junta</b></td>
<td><input type="text" name="txt_fr_id_junta" readonly value="<%= request.getParameter("txt_fr_id_junta")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Junta</b></td>
<td><input type="text" name="txt_junta_string" readonly value="<%= request.getParameter("txt_junta_string")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Dignidad</b></td>
<td><input type="text" name="txt_fr_id_dignidad" readonly value="<%= request.getParameter("txt_fr_id_dignidad")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Código de Acta CNE</b></td>
<td><input type="text" name="txt_cne_cod_acta" readonly value="<%= request.getParameter("txt_cne_cod_acta")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Total Huellas y Firmas</b></td>
<td><input type="text" name="txt_num_validos" readonly value="<%= request.getParameter("txt_num_validos")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>No votaron</b></td>
<td><input type="text" name="txt_num_no_voto" readonly value="<%= request.getParameter("txt_num_no_voto")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Total de Votos en Blancos</b></td>
<td><input type="text" name="txt_num_blancos" readonly value="<%= request.getParameter("txt_num_blancos")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Total de Votos Nulos</b></td>
<td><input type="text" name="txt_num_nulos" readonly value="<%= request.getParameter("txt_num_nulos")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Ingresada</b></td>
<td><input type="text" name="txt_acta_usu_ing" readonly value="<%= request.getParameter("txt_acta_usu_ing")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Modificada</b></td>
<td><input type="text" name="txt_acta_usu_mod" readonly value="<%= request.getParameter("txt_acta_usu_mod")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>Fecha/Hora</b></td>
<td><input type="text" name="txt_acta_fi" readonly value="<%= request.getParameter("txt_acta_fi")%>">
</td>
</tr>

<tr class="alt"> 
<td><b>UM</b></td>
<td><input type="text" name="txt_acta_um" readonly value="<%= request.getParameter("txt_acta_um")%>">
</td>
</tr>

<tr class="alt"><td><b>Cuadrada?</b>
</td>
<td>
<input readonly type="text" name="txt_cuadrada" <% if(request.getParameter("txt_cuadrada").contains("true")){%>value="SI"<%}else{%>value="NO"<%}%>>
</td>
</tr>

<tr class="alt"><td><b>Es Legible?</b>
</td>
<td>
<input readonly type="text" name="txt_legible" <% if(request.getParameter("txt_legible").contains("true")){%>value="SI"<%}else{%>value="NO"<%}%>>
</td>
</tr>

<tr class="alt"> 
<td><b>Estado</b></td>
<td><input type="text" name="txt_fr_id_acta_estado" readonly value="<%= request.getParameter("txt_fr_id_acta_estado")%>">
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
