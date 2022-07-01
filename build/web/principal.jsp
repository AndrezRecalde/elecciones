<!DOCTYPE html>
<html lang="en">
    <head>
        <LINK REL="SHORTCUT ICON" HREF="images/logo_up.png">
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />

        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema de Control Electoral</title>

        <link href="styles/basic.css" rel="stylesheet" type="text/css" media="screen" />

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <style type="text/css">
            .bs-example{
                margin: 20px;
            }
            .main_cont{
                width: 100%;
                height: 100%;
                position: absolute;
                top: 50px
            }
        </style>

        <%
            if (session.getAttribute("tipo_usuario") == null) {
                response.sendRedirect("salir.jsp?men=Su sesion ha caducado.");
                return;
            }
        %>
    </head> 
    <body>
        <!-- Fixed navbar -->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="principal.jsp"><img src="images/logo_up.png" height="30px"></a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="principal.jsp">Home</a></li>
                            <% if (session.getAttribute("tipo_usuario").toString().equals("1")
                                        || session.getAttribute("tipo_usuario").toString().equals("2")
                                        || session.getAttribute("tipo_usuario").toString().equals("3")) { %>
                        <li><a href="dig_actas_dignidad.jsp" target="dynamic">Digitaci&oacute;n</a></li>
                            <% } %>
                            <% if (session.getAttribute("tipo_usuario").toString().equals("5")) { %>
                        <li><a href="dig_actas_dignidad.jsp" target="dynamic">Conteo R&aacute;pido</a></li>
                            <% } %>
                        <% if (session.getAttribute("tipo_usuario").toString().equals("1")
                                            || session.getAttribute("tipo_usuario").toString().equals("2")) { %>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Log&iacute;stica<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header">Juntas</li>
                                <li><a href="jun_responsable.jsp" style="text-decoration: none" target="dynamic">Delegados JRV</a></li>
                                <li><a href="admin/admin_controlador.srvlt_junta_listar_todos" style="text-decoration: none" target="dynamic">Listar JRV</a></li>
                                <li class="dropdown-header">Recintos</li>
                                <li><a href="admin/admin_controlador.srvlt_recintos_listar_todos" style="text-decoration: none" target="dynamic">Coordinadores Recintos</a></li>
                            </ul>
                        </li>
                        <% } %>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Preferencias<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="cambiar_contrasena.jsp" style="text-decoration: none" target="dynamic">Cambiar Contrase&ntilde;a</a></li>
                            </ul>
                        </li>
                        <% if (session.getAttribute("tipo_usuario").toString().equals("1")
                                            || session.getAttribute("tipo_usuario").toString().equals("2")
                                            || session.getAttribute("tipo_usuario").toString().equals("4")) { %>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reportes<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header">Avances y Resultados</li>
                                <li><a href="resultados_juntas?op=avance_escrutinio" style="text-decoration: none" target="dynamic">Escrutinio</a></li>
                                <li><a href="resultados_juntas?op=avance_responsables" style="text-decoration: none" target="dynamic">Delegados JRV</a></li>
                                <li><a href="resultados?iddignidad=1&idcanton=1&idparroquia=1&idrecinto=1&nivel_territorio_prov_jsp=" style="text-decoration: none" target="dynamic">Resultados</a></li>
                                <li><a href="webster?iddignidad=2" style="text-decoration: none" target="dynamic">Webster</a></li>
                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">Actas</li>
                                <li><a href="admin/admin_controlador.srvlt_acta_listar_todos?op=inc" style="text-decoration: none" target="dynamic">Inconsistentes</a></li>
                                <li><a href="admin/admin_controlador.srvlt_acta_listar_todos?op=tod" style="text-decoration: none" target="dynamic">Ingresadas</a></li>
                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">PDF</li>
                                <li><a href="responsables_pdf.jsp?tipo=pdf" style="text-decoration: none" target="dynamic">Delegados CNE</a></li>
                            </ul>
                        </li>
                        <% }%>
                        <% if (session.getAttribute("tipo_usuario").toString().equals("1")) { %>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Administrar<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="admin/admin_controlador.srvlt_usuario_listar_todos" style="text-decoration: none" target="dynamic">Usuarios</a></li>
                                <li><a href="admin/admin_controlador.srvlt_accesos_listar_todos?op=todos" style="text-decoration: none" target="dynamic">Accesos</a></li>
                                <li><a href="admin/admin_controlador.srvlt_acta_images_listar_todos?op=todos" style="text-decoration: none" target="dynamic">Im&aacute;genes de Actas</a></li>
                            </ul>
                        </li>
                        <% }%>
                        <li class="dropdown"> 
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ing. Dubal Quevedo.<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#" style="text-decoration: none"><b>Creado por:</b> Ing. Dubal Quevedo<br><b>Telf:</b> 0969655372</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><%= session.getAttribute("usuario")%><span class="sr-only">(current)</span></a></li>
                        <li class="active"><a href="./salir.jsp">Salir<span class="sr-only">(current)</span></a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="main_cont">
            <iframe src="welcome.jsp" style="width: 100%;height: 100%;" name="dynamic">

            </iframe>
        </div> <!-- /container -->

    </body>
</html>                            