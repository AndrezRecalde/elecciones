<%-- 
    Document   : act_recepcion
    Created on : 29/01/2013, 05:21:08 PM
    Author     : root
--%>

<%@page import="admin.CaccesosDB"%>
<%@page import="admin.Ccantones"%>
<%@page import="admin.CcantonesDB"%>
<%@page import="admin.Cusuario"%>
<%@page import="admin.CusuarioDB"%>
<%@page import="eleccion.acta"%>
<%@page import="eleccion.actaDB"%>
<%@page import="eleccion.provincia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eleccion.provinciaDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Digitacion de Actas</title>
        <link href="styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="styles/basic.css" rel="stylesheet" type="text/css" media="screen" />

        <script type="text/javascript" src="includes/jquery.js"></script>
        <script type="text/javascript" src="includes/combinados.js"></script>
    </head>
    <body>
        <form name="form1" action="responsables_juntas">
            <div id="cuerpo" style="text-align: center" >
                <center>
                    <table>
                        <tr>
                            <td style="text-align: center" colspan="2"><h1><b>DELEGADOS DE JUNTAS</b></h1></td>
                        </tr>
                        <tr>
                            <td><b>PROVINCIA:</b></td>
                            <td>
                                <select name="idprovincia" id="idprovincia" style="width: 150px">
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><b>CANTÓN:</b></td>
                            <td>
                                <select name="idcanton" id="idcanton" style="width: 150px">
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><b>PARROQUIA:</b></td>
                            <td>
                                <select name="idparroquia" id="idparroquia" style="width: 150px">
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><b>ZONA:</b></td>
                            <td colspan="3">
                                <select name="idzona" id="idzona" style="width: 150px">
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><b>JUNTA:</b></td>
                            <td>
                                <select name="idjunta" id="idjunta" style="width: 150px">
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                        <center>
                            <input type="button" id="aceptar" onclick="javascript:history.back(1)" name="Atras" value="Atrás"/>
                            <input type="submit" name="ver" value="Responsables por Junta" >
                            <input type="submit" name="ver" value="Responsables por Zona" >
                            <a href="jun_responsable.jsp?ver=<%= request.getParameter("ver")%>&idprovincia=<%= request.getParameter("idprovincia")%>&idcanton=<%= request.getParameter("idprovincia")%>&idparroquia=<%= request.getParameter("idparroquia")%>&idzona=<%= request.getParameter("idzona")%>&idjunta=<%= request.getParameter("idjunta")%>" title="Actualizar"><img style="width: 40px;height: 40px" src="images/refresh.png"></a>
                        </center>
                        </td>
                        </tr>
                    </table>

                    <table style="margin-top: 20px">
                        <tr>
                            <td colspan="8" style="text-align: center"><b>RESULTADOS.</b></td>
                        </tr>
                        <tr>
                            <td><b>DETALLE</b></td>
                            <td><b>RECINTO</b></td>
                            <td><b>JUNTA</b></td>
                            <td><b>ACTA-RECEPTADA</b></td>
                            <td><b>CI</b></td>
                            <td><b>DELEGADO</b></td>
                            <td><b>TELEFONO</b></td>
                            <td></td>
                        </tr>
                        <%
                            int t = 0;
                            ArrayList<acta> listaActas = null;
                            if (session.getAttribute("lista_resp_juntas") != null) {
                                listaActas = (ArrayList) session.getAttribute("lista_resp_juntas");
                            
                            for (acta p : listaActas) {
                        %>
                        <tr>
                            <td>
                                <%= p.getCanton_nombre()%>-<%= p.getParroquia_nombre()%>-<%= p.getZona_nombre()%>
                            </td>
                            <td>
                                <%= p.getRecinto_nombre()%>
                            </td>
                            <td>
                                <%= p.getJunta_nombre()%>
                            </td>
                            <td>
                                <%= p.getDignidad_nombre()%>
                            </td>
                            <td>
                                <%= p.getResponsable_cedula() %>
                            </td>
                            <td>
                                <%= p.getResponsable()%>
                            </td>
                            <td>
                                <%= p.getResponsable_telefono()%>
                            </td>
                            <td>
                                <button disabled="true" class="boton"><a class="nounderline" target="_blank" onclick="window.open(this.href, this.target, 'width=700,height=400'); return false;" href="responsable_junta_editar.jsp?id_junta=<%= p.getFr_id_junta()%>&canton=<%= p.getCanton_nombre()%>&parroquia=<%= p.getParroquia_nombre()%>&zona=<%= p.getZona_nombre()%>&recinto=<%= p.getRecinto_nombre()%>&cedula=00000000000">Editar</a></button>
                            </td>
                        </tr>
                        <%
                            }
}
                        %>
                    </table>
                    </table>
            </div>
        </form>
    </body>
</html>
