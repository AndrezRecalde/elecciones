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
         <title>Menu</title>
         <meta http-equiv="X-UA-Compatible" content="IE=edge">
         <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="../includes/styles_menu.css">
         <script src="../includes/jquery_menu.js" type="text/javascript"></script>
         <script src="../includes/script_menu.js"></script>        	<LINK REL=StyleSheet HREF="../includes/tablas.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../includes/estillo_site.css" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="../css/menu_opciones.css" TYPE="text/css" MEDIA=screen>
        <LINK REL=StyleSheet HREF="../css/form_style.css" TYPE="text/css" MEDIA=screen>
	<link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body><div id='cssmenu'>
<ul>

<li class='active has-sub'><a href='#'><span>ADMINISTRAR</span></a>
<ul>
<li class='has-sub'><a href='#'><span>Juntas</span></a>
<ul>
<li><a href='junta_ingresar.jsp' target="contenido">INGRESAR Juntas</span></a></li>
<li><a href='junta_buscar_buscar.jsp' target="contenido">BUSCAR Juntas</span></a></li>
<li><a href='junta_actualizar.jsp' target="contenido">ACTUALIZAR Juntas</span></a></li>
<li><a href='junta_eliminar_buscar.jsp' target="contenido">ELIMINAR Juntas</span></a></li>
<li class='last'><a href='admin_controlador.srvlt_junta_listar_todos' target="contenido">ADMINISTRAR Juntas</span></a></li></ul>
</li>
</ul>
</li>
</ul>
</div>
    </body>
</html>