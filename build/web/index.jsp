<%-- 
    Document   : index
    Created on : 29-mar-2012, 14:20:30
    Author     : USUARIO
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="eleccion.provinciaDB"%>
<%@page import="eleccion.provincia"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="eleccion.usuarioDB"%>
<%@page import="herramientas.Cripto"%>
<%@page import="org.omg.PortableInterceptor.SYSTEM_EXCEPTION"%>
<%@page import="java.util.Date"%>
<%@page import="eleccion.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <LINK REL="SHORTCUT ICON" HREF="images/logo_up.png">
        <jsp:useBean id="usuario" class="eleccion.usuarioDB" scope="page">
            <jsp:setProperty name="usuario" property="*"></jsp:setProperty>
        </jsp:useBean>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="styles/basic.css">
        <link rel="stylesheet" href="styles/screen.css">
        <title>Sistema de Control Electoral</title>
        
        <script type="text/javascript">
            function popup(url) 
            {
                params  = 'width='+screen.width;
                params += ', height='+screen.height;
                params += ', top=0, left=0'
                params += ', fullscreen';

                newwin=window.open(url,'windowname4', params);
                if (window.focus) {newwin.focus()}
                return false;
            }
        </script>
    </head>
    <body>
        <%  
            session.setAttribute("provincias", null);
            session.setAttribute("cantones", null);
            session.setAttribute("parroquias", null);
            session.setAttribute("zonas", null);
            session.setAttribute("recintos", null);
            session.setAttribute("juntas", null);
            session.setAttribute("dignidades", null);
            session.setAttribute("usu_es_cantonal", null);
            session.setAttribute("usu_id_canton", null);
        %>
        <BR><BR><BR><BR><BR><BR><BR><BR><BR>
        <table align="center" cellspacing="0" cellpadding="0" border="0">
            <tr>
                <td align ="center">
                    <img src="images/logo_up.png" width="100" height="100"><br>
                    <h1>Gracias por ingresar al sistema, favor para continuar de click.</h1>
                    <a href="javascript: void(0)" style="color: #D32F2F" target="_blank" onclick="popup('login.jsp'); return false;"><h1>Aquí!</h1></a>
                </td>
            </tr>
        </table>
    </body>
</html>
