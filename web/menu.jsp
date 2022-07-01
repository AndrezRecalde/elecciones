<%-- 
    Document   : menu
    Created on : 22/01/2013, 02:28:15 PM
    Author     : userver1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Principal</title>
        <LINK REL=StyleSheet HREF="menu.css" TYPE="text/css" MEDIA=screen>
        <LINK REL=StyleSheet HREF="medidas.css" TYPE="text/css" MEDIA=screen>
        <link href="styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body style="">
        <div align="center">
            <a href="welcome.jsp" target="dynamic" class="inici">INICIO</a>
            <div id="reportes">
                <ul class="menu_color">
                    <li>
                        <samp class="reporte">REPORTES</samp>
                        <ul>
                            <div id="first">
                                <li>
                                    <a href="resultados?iddignidad=1&idcanton=1&idparroquia=1&nivel_territorio_prov_jsp=" style="text-decoration: none" target="dynamic">RESULTADOS</a>
                                </li>
                            </div>
                        </ul>
                    </li>
                </ul>
            </div>
            <div id="actas">
                <ul class="menu_color">
                    <li>
                        <samp class="acta">JUNTAS</samp>
                        <ul>
                            <div id="first">
                                <li>
                                    <a href="jun_responsable.jsp" style="text-decoration: none" target="dynamic">RESPONSABLE</a>
                                </li>
                            </div>
                            <li>
                                <a href="act_recepcion.jsp?opc=ver" style="text-decoration: none" target="dynamic">VER ACTAS</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div id="organizaciones">
                <ul class="menu_color">
                    <li>
                        <samp class="organizacion">DIGITACION</samp>
                        <ul>
                            <div id="first">
                                <li>
                                    <a href="dig_actas_dignidad.jsp" style="text-decoration: none" target="dynamic">DIGITAR ACTAS</a>
                                </li>
                            </div>
                        </ul>
                    </li>
                </ul>
            </div>
            <a target="dynamic" href="salir.jsp" class="salir">SALIR</a>
        </div>
    </body>
</html>
