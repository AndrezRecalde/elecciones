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
        <title>Datos-Provincias</title>
        	<LINK REL=StyleSheet HREF="../includes/tablas.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../includes/estillo_site.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../css/menu_opciones.css" TYPE="text/css" MEDIA=screen>
        <LINK REL=StyleSheet HREF="../css/form_style.css" TYPE="text/css" MEDIA=screen>
	<link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
         <form name="form1" action="admin_controlador.srvlt_provincia_insert">         <center>
                <div class="menu_horizontal">
                    <ul>
                        <li><a href="provincia_ingresar.jsp">Nueva</a></li>
                        <li><a href="admin_controlador.srvlt_provincia_listar_todos">Listar Todos</a></li>
                        <li><a href="javascript:history.back(1)">Cancelar</a></li>
                        <li><a href="javascript:history.back(1)">Regresar</a></li>
                        <ul style="float:right;list-style-type:none;">
                            <li><a class="active" href="../salir.jsp">Salir</a></li>
                        </ul>
                    </ul>
                </div>         <h1 class="titulo_h1">Datos-Provincias</h1>
         <div class="contenedor_tabla"><table  class="clsTablaDatos form_style">

<thead><tr><td colspan="2">Detalles del Provincia</td></tr></thead>
<tbody>
<tr ><td><b>CNE Cod Prov</b>
</td>
<td>
<input readonly type="text" name="txt_cne_cod_prov" value="<%= request.getParameter("txt_cne_cod_prov")%>">
</td>
</tr>

<tr ><td><b>Nombre</b>
</td>
<td>
<input readonly type="text" name="txt_nombre_provincia" value="<%= request.getParameter("txt_nombre_provincia")%>">
</td>
</tr>

<tr ><td><b>num de vot de hombres</b>
</td>
<td>
<input readonly type="text" name="txt_num_vot_hombres" value="<%= request.getParameter("txt_num_vot_hombres")%>">
</td>
</tr>

<tr ><td><b>num de vot de mujeres</b>
</td>
<td>
<input readonly type="text" name="txt_num_vot_mujeres" value="<%= request.getParameter("txt_num_vot_mujeres")%>">
</td>
</tr>

<tr ><td><b>activa</b>
</td>
<td>
<input readonly type="text" name="txt_activa" <% if(request.getParameter("txt_activa").contains("true")){%>value="SI"<%}else{%>value="NO"<%}%>>
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