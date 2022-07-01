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
        <form name="form1" action="admin_controlador.srvlt_usuario_insert">         <center>
               <div>
                    <button disabled="true" class="boton"><a href="usuario_ingresar.jsp">Nuevo</a></button>
                    <button disabled="true" class="boton"><a href="admin_controlador.srvlt_usuario_listar_todos">Listar Todos</a></button>
                    <button disabled="true" class="boton"><a href="javascript:history.back(1)">Cancelar</a>
                    </button>
                </div> 
                <div class="contenedor_tabla">
                    <table  class="clsTablaDatos form_style">
                        <thead>
                            <tr><td colspan="2">Ingresar usuario</td></tr>
                        </thead>
                        <tbody>
                            <tr >
                                <td><b>Nombres y Apellidos</b>
                                </td><td><input type="text" name="txt_nombres" >
                                </td>
                            </tr>
                            <tr >
                                <td><b>Usuario</b>
                                </td><td><input type="text" name="txt_usuario" >
                                </td>
                            </tr>
                            <tr >
                                <td><b>Provincia</b>
                                </td><td><%
                                    if (session.getAttribute("lista_combo_provincia") == null) {
                                        response.sendRedirect("admin_controlador.srvlt_provincia_listar_combo?red=usuario_ingresar.jsp");
                                        return;
                                    }
                                    ArrayList<CObjetoCombo> lista_combo_provincia = (ArrayList<CObjetoCombo>) session.getAttribute("lista_combo_provincia");
                                    %>
                                    <select name="txt_fr_id_provincia">   <%for (CObjetoCombo c : lista_combo_provincia) {
                                        %>
                                        <option value="<%= c.getId()%>"><%= c.getValor()%></option>   <% } %></select>
                                </td>
                            </tr>
                            <tr >
                                <td><b>Dirección</b>
                                </td><td><input type="text" name="txt_provincia_nombre" >
                                </td>
                            </tr>
                            <tr >
                                <td><b>Tipo de usuario</b>
                                </td><td><%
                                    if (session.getAttribute("lista_combo_tipo_usuario") == null) {
                                        response.sendRedirect("admin_controlador.srvlt_tipo_usuario_listar_combo?red=usuario_ingresar.jsp");
                                        return;
                                    }
                                    ArrayList<CObjetoCombo> lista_combo_tipo_usuario = (ArrayList<CObjetoCombo>) session.getAttribute("lista_combo_tipo_usuario");
                                    %>
                                    <select name="txt_fr_id_tipo_usuario">   <%for (CObjetoCombo c : lista_combo_tipo_usuario) {
                                        %>
                                        <option value="<%= c.getId()%>"><%= c.getValor()%></option>   <% } %></select>
                                </td>
                            </tr>
                            <tr >
                                <td><b>Es provincial</b>
                                </td><td><select name="txt_es_provincial"><option value="1">SI</option><option value="0">NO</option></select>
                                </td>
                            </tr>
                            <tr >
                                <td><b>Canton</b>
                                </td><td><%
                                    if (session.getAttribute("lista_combo_cantones") == null) {
                                        response.sendRedirect("admin_controlador.srvlt_cantones_listar_combo?red=usuario_ingresar.jsp");
                                        return;
                                    }
                                    ArrayList<CObjetoCombo> lista_combo_cantones = (ArrayList<CObjetoCombo>) session.getAttribute("lista_combo_cantones");
                                    %>
                                    <select name="txt_fr_id_canton">   <%for (CObjetoCombo c : lista_combo_cantones) {
                                        %>
                                        <option value="<%= c.getId()%>"><%= c.getValor()%></option>   <% }%></select>
                                </td>
                            </tr>
                            <tr >
                                <td><b>Es cantonal</b>
                                </td><td><select name="txt_es_cantonal"><option value="1">SI</option><option value="0">NO</option></select>
                                </td>
                            </tr>
                            <tr >
                                <td><b>Tipo de usuario</b>
                                </td><td><input type="text" name="txt_tipo_usu_nombre" >
                                </td>
                            </tr>
                            <tr >
                                <td><b>Clave</b>
                                </td><td><input type="password" name="txt_clave" >
                                </td>
                            </tr>
                            <tr >
                                <td><b>Activo</b>
                                </td><td><select name="txt_activo"><option value="1">SI</option><option value="0">NO</option></select>
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