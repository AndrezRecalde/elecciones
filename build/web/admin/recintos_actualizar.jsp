 <%-- 
    Document   : index
    Created on : Jul 12, 2014, 11:48:02 AM
    Author     : Generador V1.0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Control Electoral-Recintos</title>
        	<LINK REL=StyleSheet HREF="../includes/tablas.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../includes/estillo_site.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../css/menu_opciones.css" TYPE="text/css" MEDIA=screen>
        <LINK REL=StyleSheet HREF="../css/form_style.css" TYPE="text/css" MEDIA=screen>
	<link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
         <form name="form1" action="admin_controlador.srvlt_recintos_buscar_actualizar">         <center>
         <h1 class="titulo_h1">Sistema de Control Electoral-Recintos</h1>
         <div class="contenedor_tabla"><table  class="clsTablaDatos form_style">

<thead>
<tr>
<td colspan="2">Actualizar registro recintos</td>
</tr>
</thead>
<tbody>
<tr>
<td>Ingrese el Cod de Recinto de Recintos a buscar </td><td><input type="text" name="txt_cod_recinto" required></td></tr>
</tbody><tfoot><tr><td colspan="2" style="text-align:center;"><input type="submit" name="buscar" value="Buscar"></td></tr></tfoot>         </table>
</div>
         </center>
         </form>
    </body>
</html>