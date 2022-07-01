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
        <title>Datos-Provincias</title>
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

<thead><tr><td colspan="2">Ingresar Provincia</td>
</tr>
</thead>
<tbody>
<tr >
<td><b>Nombre</b>
</td><td><input type="text" name="txt_nombre_provincia" >
</td>
</tr>
<tr >
<td><b>num de vot de hombres</b>
</td><td><input type="text" name="txt_num_vot_hombres" >
</td>
</tr>
<tr >
<td><b>num de vot de mujeres</b>
</td><td><input type="text" name="txt_num_vot_mujeres" >
</td>
</tr>
<tr >
<td><b>activa</b>
</td><td><select name="txt_activa"><option value="1">SI</option><option value="0">NO</option></select>
</td>
</tr>
<tr>
                                <td colspan="2"><label for="crear_nueva"><input id="crear_nueva" type="checkbox" name="crear_nueva">Después del ingreso, regresar a esta pantalla para crear un nuevo registro.</label>
                                </td>
                            </tr>
</tbody>
<tfoot>
<tr>
<td colspan="2" style="text-align:center;">
<input type="submit" name="ingresar" value="Ingresar">
</td>
</tr>
</tfoot>
         </table>
</div>
         </center>
         </form>
    </body>
</html>