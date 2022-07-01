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
        <title>Control Electoral-usuario</title>
        <link href="../styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="../styles/basic.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <form name="form1" action="admin_controlador.srvlt_usuario_eliminar">        
            <center>
                <div>
                    <button disabled="true" class="boton"><a href="usuario_ingresar.jsp">Nuevo</a></button>
                    <button disabled="true" class="boton"><a href="admin_controlador.srvlt_usuario_listar_todos">Listar Todos</a></button>
                    <button disabled="true" class="boton"><a href="javascript:history.back(1)">Cancelar</a>
                    </button>
                </div>       
                <div class="contenedor_tabla">
                    <table  class="clsTablaDatos form_style">
                        <thead>
                            <tr>
                                <td colspan="2">Elimninar usuario</td>
                            </tr>
                        </thead>
                        <tbody>

                            <tr class="alt"> 
                                <td><b>ID</b></td>
                                <td><input type="text" name="txt_idusuario" readonly value="<%= request.getParameter("txt_idusuario")%>">
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>Nombres y Apellidos</b></td>
                                <td><input type="text" name="txt_nombres" readonly value="<%= request.getParameter("txt_nombres")%>">
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>Usuario</b></td>
                                <td><input type="text" name="txt_usuario" readonly value="<%= request.getParameter("txt_usuario")%>">
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>Provincia</b></td>
                                <td><input type="text" name="txt_fr_id_provincia" readonly value="<%= request.getParameter("txt_fr_id_provincia")%>">
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>Provincia</b></td>
                                <td><input type="text" name="txt_provincia_string" readonly value="<%= request.getParameter("txt_provincia_string")%>">
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>Dirección</b></td>
                                <td><input type="text" name="txt_provincia_nombre" readonly value="<%= request.getParameter("txt_provincia_nombre")%>">
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>Tipo de usuario</b></td>
                                <td><input type="text" name="txt_fr_id_tipo_usuario" readonly value="<%= request.getParameter("txt_fr_id_tipo_usuario")%>">
                                </td>
                            </tr>

                            <tr class="alt"><td><b>Es provincial</b>
                                </td>
                                <td>
                                    <input readonly type="text" name="txt_es_provincial" <% if (request.getParameter("txt_es_provincial").contains("true")) {%>value="SI"<%} else {%>value="NO"<%}%>>
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>Canton</b></td>
                                <td><input type="text" name="txt_fr_id_canton" readonly value="<%= request.getParameter("txt_fr_id_canton")%>">
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>Canton</b></td>
                                <td><input type="text" name="txt_cantones_string" readonly value="<%= request.getParameter("txt_cantones_string")%>">
                                </td>
                            </tr>

                            <tr class="alt"><td><b>Es cantonal</b>
                                </td>
                                <td>
                                    <input readonly type="text" name="txt_es_cantonal" <% if (request.getParameter("txt_es_cantonal").contains("true")) {%>value="SI"<%} else {%>value="NO"<%}%>>
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>Tipo de usuario</b></td>
                                <td><input type="text" name="txt_tipo_usu_nombre" readonly value="<%= request.getParameter("txt_tipo_usu_nombre")%>">
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>Tipo de usuario</b></td>
                                <td><input type="text" name="txt_tipo_usuario_string" readonly value="<%= request.getParameter("txt_tipo_usuario_string")%>">
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>Login</b></td>
                                <td><input type="text" name="txt_login" readonly value="<%= request.getParameter("txt_login")%>">
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>Clave</b></td>
                                <td><input type="text" name="txt_clave" readonly value="<%= request.getParameter("txt_clave")%>">
                                </td>
                            </tr>

                            <tr class="alt"><td><b>Activo</b>
                                </td>
                                <td>
                                    <input readonly type="text" name="txt_activo" <% if (request.getParameter("txt_activo").contains("true")) {%>value="SI"<%} else {%>value="NO"<%}%>>
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>usu de ui</b></td>
                                <td><input type="text" name="txt_usu_ui" readonly value="<%= request.getParameter("txt_usu_ui")%>">
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>usu de fi</b></td>
                                <td><input type="text" name="txt_usu_fi" readonly value="<%= request.getParameter("txt_usu_fi")%>">
                                </td>
                            </tr>

                            <tr class="alt"> 
                                <td><b>usu de um</b></td>
                                <td><input type="text" name="txt_usu_um" readonly value="<%= request.getParameter("txt_usu_um")%>">
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
