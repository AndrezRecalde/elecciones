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
        <title>Mensaje</title>
        <link href="styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="styles/basic.css" rel="stylesheet" type="text/css" media="screen" />
        
    </head>
    <body>
    <center>
        <table>
            <tr>
                <td align ="center">
                    <font style="color: white"> 
                    <img src="images/informacion.png" style="width: 80px;height: 80px">
                    <h2>Mensaje...</h2>
                    </font>
                    <h3>
                        <%
                            String datoUno = request.getParameter("men");
                            out.println(datoUno);
                        %>
                    </h3>
                    <button disabled="true" class="boton"><a class="nounderline" href="javascript:window.open('','_self').close();">Cerrar</a></button>
                    <br>
                    <br>
                    <input type="button" id="aceptar" onclick="javascript:history.back(1)" name="Atras" value="REGRESAR"/>
                </td>
            </tr>
        </table>
    </center>
</body>
</html>
