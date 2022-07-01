<%-- 
    Document   : header
    Created on : 22/01/2013, 05:23:47 PM
    Author     : userver1
--%>

<%@page import="eleccion.actaDB"%>
<%@page import="eleccion.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SISTEMA DE ELECCIONES</title> 
        <link href="styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <jsp:useBean id="usuario" class="eleccion.usuarioDB" scope="page">
            <jsp:setProperty name="usuario" property="*"></jsp:setProperty>
        </jsp:useBean>
        <script type="text/javascript">
            function breakout() {
            <%
                if (request.getSession(false).getAttribute("idusuario") == null) {
            %>
                if (window.top != window.self) {
                    window.top.location = "/elecciones/index.jsp"
                }
            <%
                }
            %>
            }
        </script>
    </head>
    <body onload="breakout()">
        <%
            int idusu = 0;
            try {
                idusu = Integer.parseInt(session.getAttribute("idusuario").toString());
            } catch (Exception e) {
                response.sendRedirect("error.jsp?men=Su sesión ha caducado.");
            }
            usuario usu = usuario.CargarxId(idusu);
            actaDB acDB = new actaDB();
            int totac = acDB.ContarActasUsuario(idusu);
        %>
        <h1 style="text-align: right"><span style="color: #ffffff">SISTEMA DE CONTROL ELECTORAL</span></h1>
        <div style="top: 10px; position: absolute;">
            <font style="color: #e6e6f3"><b>Usuario: &nbsp; </b>
            <%= usu.getNombres()%><br>
            <%= usu.getUsuario()%><br>
            <%= usu.getTipo_usu_nombre()%><br>
            Total de Actas: <b><%= totac%></b> <a href="header.jsp" style="color: white"><img src="images/nuevo.png" width="15px" height="15px"></a>
            </font>
        </div>
    </body>
</html>
