<%-- 
    Document   : error
    Created on : 04-abr-2012, 9:24:11
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <LINK REL="SHORTCUT ICON" HREF="icon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Error</title>
        <link href="styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="styles/basic.css" rel="stylesheet" type="text/css" media="screen" />
        
        <script type="text/javascript">
        function breakout() {
            <%
            if ( request.getSession(false).getAttribute("idusuario") == null) {
            %>
                    if (window.top != window.self) {
                        window.top.location="/elecciones/index.jsp"
                    }
            <%
            }
            %>
            }
        </script>
    </head>
    <body onload="javascript:breakout();">
        <table align="center" cellspacing="0" cellpadding="0" border="0">
            <tr>
                <td align ="center">
                    <font style="color: red"> 
                    <img src="images/error.png" style="width: 80px;height: 80px">
                    <h2>Ups! Algo salió mal...</h2>
                    </font>
                    <h3>
                    <%
                      String datoUno = request.getParameter("men");
                      out.println(datoUno);
                    %>
                    </h3>
                    <input type="button" id="aceptar" onclick="javascript:history.back(1)" name="Atras" value="REGRESAR"/>
                </td>
            </tr>
        </table>
    </body>
</html>
