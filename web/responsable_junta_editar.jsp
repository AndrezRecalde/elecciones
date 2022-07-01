<%-- 
    Document   : responsable_junta_editar
    Created on : 04/02/2014, 03:45:10 PM
    Author     : root
--%>

<%@page import="com.sun.org.apache.bcel.internal.generic.AALOAD"%>
<%@page import="eleccion.juntaDB"%>
<%@page import="eleccion.junta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Responsable de Junta</title>
        <link href="styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <form name="form1" action="responsable_junta_editar.jsp">
            <div id="cuerpo" style="text-align: center" >
                <center>
                    <table>
                        <%
                            int id_junta = 0;
                            junta JU = new junta();
                            juntaDB JUDB = new juntaDB();
                            if (request.getParameter("id_junta") != null) {
                                id_junta = Integer.parseInt(request.getParameter("id_junta").toString());
                                JU = JUDB.CargarJuntaxId(id_junta);
                            }
                            if (request.getParameter("editar") != null) {
                                id_junta = Integer.parseInt(request.getParameter("id_junta").toString());
                                String cedula = request.getParameter("cedula").toString();
                                String nombre = request.getParameter("responsable").toString();
                                String telefono = request.getParameter("telefono").toString();
                                if (JUDB.ActualizarResponsables(id_junta, nombre, telefono,cedula)) {
                                    response.sendRedirect("mensaje.jsp?men=Actualizada con exito.!");
                                } else {
                                    response.sendRedirect("error.jsp?men=No se ha actualizado..!");
                                }
                            }
                        %>
                        <tr>
                            <td style="text-align: center" colspan="2"><h1><b>EDITAR RESPONSABLE DE UNA JUNTA</b></h1></td>
                        </tr>
                        <tr>
                            <td><b>ID JUNTA:</b></td>
                            <td>
                                <input type="hidden" name="id_junta" value="<%= JU.getIdjunta()%>">
                                <input readonly="true" name="junta" value="<%= JU.getJunta_nombre()%>">
                            </td>
                        </tr>
                        <tr>
                            <td><b>CANTON:</b></td>
                            <td>
                                <input readonly="true"  name="canton" value="<%= request.getParameter("canton") %>">
                            </td>
                        </tr>
                        <tr>
                            <td><b>PARROQUIA:</b></td>
                            <td>
                                <input readonly="true"  name="parroquia" value="<%= request.getParameter("parroquia") %>">
                            </td>
                        </tr>
                        <tr>
                            <td><b>ZONA:</b></td>
                            <td>
                                <input readonly="true"  name="zona" value="<%= request.getParameter("zona") %>">
                            </td>
                        </tr>
                        <tr>
                            <td><b>RECINTO:</b></td>
                            <td>
                                <input readonly="true" name="recinto" value="<%= request.getParameter("recinto") %>">
                            </td>
                        </tr>
                        <tr>
                            <td><b>CÉDULA DE IDENTIDAD</b></td>
                            <td>
                                <input name="cedula" value="<%= JU.getCedula() %>">
                            </td>
                        </tr>
                        <tr>
                            <td><b>RESPONSABLE:</b></td>
                            <td>
                                <input name="responsable" value="<%= JU.getResponsable()%>">
                            </td>
                        </tr>
                        <tr>
                            <td><b>TELEFONO DE RESPONSABLE:</b></td>
                            <td>
                                <input name="telefono" value="<%= JU.getResponsable_telefono()%>">
                            </td>
                        </tr>
                        <%
                            if (request.getParameter("men") != null) {
                        %>
                        <tr>
                            <td>
                                <%= request.getParameter("men").toString()%>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        <tr>
                            <td colspan="1" style="text-align: center">
                                <input type="button" onclick="javascript:window.open('','_self').close();" value="Cerrar">
                            </td>
                            <td colspan="1" style="text-align: center">
                                <input type="submit" name="editar" value="Actualizar">
                            </td>
                        </tr>
                    </table>
                </center>
            </div>
        </form>
    </body>
</html>
