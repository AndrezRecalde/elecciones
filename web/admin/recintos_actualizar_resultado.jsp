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
        <title>Sistema de Control Electoral-Recintos</title>
        <link href="../styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="../styles/basic.css" rel="stylesheet" type="text/css" media="screen" />

        <link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
        <form name="form1" action="admin_controlador.srvlt_recintos_actualizar">    
            <center>
                 <a href="admin_controlador.srvlt_acta_images_listar_todos?op=todos">Listar Todas</a>
                <button disabled="true" class="boton"><a href="javascript:history.back(1)">Volver</a></button>
                
                <h1 class="titulo_h1">Sistema de Control Electoral-Recintos</h1>
                <div class="contenedor_tabla">
                    <table  class="clsTablaDatos form_style">
                        <thead><tr><td colspan="2">Actualizar Coordinador de Recinto</td></tr></thead>
                        <tbody>
                            <tr >
                                <td><b>Cod de Recinto</b>
                                </td><td><input type="text" name="txt_cod_recinto" required  value="<%= request.getParameter("txt_cod_recinto")%>" readonly>
                                </td>
                            </tr>
                            <tr >
                                <td><b>CI Responsable</b>
                                </td><td><input type="text" name="txt_responsable_ci"  value="<%= request.getParameter("txt_responsable_ci")%>">
                                </td>
                            </tr>
                            <tr >
                                <td><b>Nombres y Apellidos del Responsable</b>
                                </td><td><input type="text" name="txt_responsable_nombres"  value="<%= request.getParameter("txt_responsable_nombres")%>">
                                </td>
                            </tr>
                            <tr >
                                <td><b>Teléfonos del Responsable</b>
                                </td><td><input type="text" name="txt_responsable_telefono"  value="<%= request.getParameter("txt_responsable_telefono")%>">
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