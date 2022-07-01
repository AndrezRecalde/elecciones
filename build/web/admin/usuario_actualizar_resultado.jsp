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
        <title>Control Electoral-usuario</title>
        <link href="../styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="../styles/basic.css" rel="stylesheet" type="text/css" media="screen" />

    </head>
    <body>
        <form name="form1" action="admin_controlador.srvlt_usuario_actualizar">       
            <center>
                <div>
                    <button disabled="true" class="boton"><a href="usuario_ingresar.jsp">Nuevo</a></button>
                    <button disabled="true" class="boton"><a href="admin_controlador.srvlt_usuario_listar_todos">Listar Todos</a></button>
                    <button disabled="true" class="boton"><a href="javascript:history.back(1)">Cancelar</a>
                    </button>
                </div>        
                <div class="contenedor_tabla">
                    <table class="clsTablaDatos form_style">
                        <thead><tr><td colspan="2">Actualizar usuario</td></tr>
                        </thead>
                        <tbody>
                            <tr >
                                <td><b>ID</b>
                                </td><td><input type="text" name="txt_idusuario" required  value="<%= request.getParameter("txt_idusuario")%>" readonly>
                                </td>
                            </tr>
                            <tr >
                                <td><b>Nombres y Apellidos</b>
                                </td><td><input type="text" name="txt_nombres"  value="<%= request.getParameter("txt_nombres")%>">
                                </td>
                            </tr>
                            <tr >
                                <td><b>Usuario</b>
                                </td><td><input type="text" name="txt_usuario"  value="<%= request.getParameter("txt_usuario")%>">
                                </td>
                            </tr>
                            <tr >
                                <td><b>Provincia</b>
                                </td><td><%
                                    if (session.getAttribute("lista_combo_provincia") == null) {
                                        response.sendRedirect("srvlt_provincia_listar_combo?red=usuario_ingresar.jsp");
                                        return;
                                    }
                                    ArrayList<CObjetoCombo> lista_combo_provincia = (ArrayList<CObjetoCombo>) session.getAttribute("lista_combo_provincia");
                                    %>
                                    <select name="txt_fr_id_provincia">   <%for (CObjetoCombo c : lista_combo_provincia) {
                                        %>

                                        <option <% if (c.getId() == Integer.parseInt(request.getParameter("txt_fr_id_provincia"))) { %> selected <% }%> value="<%= c.getId()%>"><%= c.getValor()%></option>   <% }%></select>
                                </td>
                            </tr>
                            <tr >
                                <td><b>Dirección</b>
                                </td><td><input type="text" name="txt_provincia_nombre"  value="<%= request.getParameter("txt_provincia_nombre")%>">
                                </td>
                            </tr>
                            <tr >
                                <td><b>Tipo de usuario</b>
                                </td><td><%
                                    if (session.getAttribute("lista_combo_tipo_usuario") == null) {
                                        response.sendRedirect("srvlt_tipo_usuario_listar_combo?red=usuario_ingresar.jsp");
                                        return;
                                    }
                                    ArrayList<CObjetoCombo> lista_combo_tipo_usuario = (ArrayList<CObjetoCombo>) session.getAttribute("lista_combo_tipo_usuario");
                                    %>
                                    <select name="txt_fr_id_tipo_usuario">   <%for (CObjetoCombo c : lista_combo_tipo_usuario) {
                                        %>
                                        <option <% if (c.getId() == Integer.parseInt(request.getParameter("txt_fr_id_tipo_usuario").toString())) { %> selected <% }%> value="<%= c.getId()%>"><%= c.getValor()%></option>   <% } %></select>
                                </td>
                            </tr>
                            <tr >
                                <td><b>Es provincial</b>
                                </td><td><select name="txt_es_provincial"><option value="1">SI</option><option value="0" <% if (!Boolean.parseBoolean(request.getParameter("txt_es_provincial").toString())) { %> selected <% }%>>NO</option></select>
                                </td>
                            </tr>
                            <tr >
                                <td><b>Canton</b>
                                </td><td><%
                                    if (session.getAttribute("lista_combo_cantones") == null) {
                                        response.sendRedirect("srvlt_cantones_listar_combo?red=usuario_ingresar.jsp");
                                        return;
                                    }
                                    ArrayList<CObjetoCombo> lista_combo_cantones = (ArrayList<CObjetoCombo>) session.getAttribute("lista_combo_cantones");
                                    %>
                                    <select name="txt_fr_id_canton">   <%for (CObjetoCombo c : lista_combo_cantones) {
                                        %>
                                        <option <% if (c.getId() == Integer.parseInt(request.getParameter("txt_fr_id_canton").toString())) { %> selected <% }%> value="<%= c.getId()%>"><%= c.getValor()%></option>   <% } %></select>
                                </td>
                            </tr>
                            <tr >
                                <td><b>Es cantonal</b>
                                </td><td><select name="txt_es_cantonal"><option value="1">SI</option><option value="0" <% if (!Boolean.parseBoolean(request.getParameter("txt_es_cantonal").toString())) { %> selected <% }%>>NO</option></select>
                                </td>
                            </tr>
                            <tr >
                                <td><b>Tipo de usuario</b>
                                </td><td><input type="text" name="txt_tipo_usu_nombre"  value="<%= request.getParameter("txt_tipo_usu_nombre")%>">
                                </td>
                            </tr>
                            <tr>
                                <td><b>Clave</b>
                                </td><td>
                                    <input type="hidden" name="txt_login"  value="" >
                                    <input type="password" name="txt_clave" placeholder="Vacío si no desea cambiar la clave">
                                </td>
                            </tr>
                            <tr >
                                <td><b>Activo</b>
                                </td><td><select name="txt_activo"><option value="1">SI</option><option value="0" <% if (!Boolean.parseBoolean(request.getParameter("txt_activo").toString())) { %> selected <% }%>>NO</option></select>
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