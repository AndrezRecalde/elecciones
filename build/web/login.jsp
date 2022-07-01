<%-- 
    Document   : index
    Created on : 29-mar-2012, 14:20:30
    Author     : USUARIO
--%>

<%@page import="admin.CaccesosDB"%>
<%@page import="admin.Cusuario"%>
<%@page import="admin.CusuarioDB"%>
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

        <link rel="stylesheet" href="styles/screen.css">
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
        <!-- DEPENDENCIAS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <title>Control Electoral</title>
    </head>
    <body>
        <%
            if (request.getParameter("validar") != null) {
                usuario usu = new usuario();
                Date fe = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                if (usuario.isCorrecto(Cripto.md5(request.getParameter("usuario").toString()),
                        Cripto.md5(request.getParameter("pass").toString()),
                        Integer.parseInt(request.getParameter("id_prov").toString()))) {
                    usu = usuario.CargarUsuario(Cripto.md5(request.getParameter("usuario").toString()));
                    session.setAttribute("idusuario", usu.getIdusuario());
                    session.setAttribute("usuario", usu.getNombres());
                    session.setAttribute("tipo_usuario", usu.getFr_id_tipo_usuario());
                    session.setAttribute("sp", 50);
                    session.setAttribute("idprovincia", usu.getFr_id_provincia());
                    session.setAttribute("idtipousuario", usu.getFr_id_tipo_usuario());

                    CusuarioDB usuDBNew = new CusuarioDB();
                    Cusuario usuNew = new Cusuario();
                    usuNew = usuDBNew.Seleccionar_Id(usu.getIdusuario());
                    session.setAttribute("usu_es_cantonal", usuNew.getes_cantonal());
                    session.setAttribute("usu_id_canton", usuNew.getfr_id_canton());

                    CaccesosDB CAU = new CaccesosDB();
                    CAU.Ingresar(usu.getIdusuario(), 1);

                    usuario.ActualizaUltimoAcceso(usu.getIdusuario());

                    response.sendRedirect("principal.jsp");
                } else {
                    response.sendRedirect("error_acceso.jsp");
                }
            }
        %>
        <form name="s" method="post">
            <div class="wrapper">
                <div class="fadeInDown" id="formContent">
                    <!-- Tabs Titles -->
                    <!-- Icon -->
                    <div class="fadeIn first">
                        <img src="images/logo_up.png" id="icon" alt="User Icon" />
                    </div>

                    <!-- Login Form -->
                    <input type="text" id="login" class="fadeIn second" name="usuario" placeholder="login">
                    <input type="password" id="password" class="fadeIn third" name="pass" placeholder="password">
                    <input type="hidden" name="id_prov" value="8">
                    <input name="validar" type="submit" class="fadeIn fourth" value="Log In">

                    <!-- Remind Passowrd -->
                    <div id="formFooter">
                        <a class="underlineHover" href="#">
                            <span style="color:#cc0000" >
                                Forgot Password?
                            </span>
                        </a>
                    </div>

                </div>
                <span style="color: #004A6F">Estimado usuario para una mejor visualización del sistema presione la tecla <b>F11</b> de su teclado.</span>
            </div>
        </form>
    </body>
</html>
