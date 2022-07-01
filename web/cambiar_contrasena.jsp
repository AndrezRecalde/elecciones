<%-- 
    Document   : cambiar_contrasena
    Created on : 11/03/2019, 8:32:14
    Author     : DQuevedo
--%>

<%@page import="admin.CaccesosDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cambiar contraseña</title>

        <link href="styles/basic.css" rel="stylesheet" type="text/css" media="screen" />

        <!-- Bootstrap Core Css -->
        <link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

        <!-- Jquery Core Js -->
        <script src="plugins/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core Js -->
        <script src="plugins/bootstrap/js/bootstrap.js"></script>

    </head>
    <body>
        <%
            int id_usuario_session = Integer.parseInt(session.getAttribute("idusuario").toString());
            CaccesosDB CAU = new CaccesosDB();
            CAU.Ingresar(id_usuario_session, 5);
        %>
        <form method="post" action="admin/admin_controlador.srvlt_usuario_actualizar_contrasena">
            <div class="center-block">
                <div class="col-md-6 col-md-offset-3">
                    <h1>Cambiar contraseña</h1>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="clave" placeholder="Contraseña Nueva" required autofocus>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="clave2" placeholder="Confirmar Contraseña" required autofocus>
                        </div>
                    </div>
                    <button type="submit" name="validar" class="btn btn-block btn-lg bg-green waves-effect">Cambiar</button>
                </div>
            </div>
        </form>
    </body>
</html>
