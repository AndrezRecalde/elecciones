<%-- 
    Document   : welcome
    Created on : 22/01/2013, 02:31:30 PM
    Author     : userver1
--%>

<%@page import="eleccion.usuario"%>
<%@page import="eleccion.actaDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control Electoral</title>
        <link href="styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="styles/basic.css" rel="stylesheet" type="text/css" media="screen" />

        <jsp:useBean id="usuario" class="eleccion.usuarioDB" scope="page">
            <jsp:setProperty name="usuario" property="*"></jsp:setProperty>
        </jsp:useBean>

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css"/>

        <!-- Bootstrap Core Css -->
        <link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet"/>

        <!-- Waves Effect Css -->
        <link href="plugins/node-waves/waves.css" rel="stylesheet" />

        <!-- Animation Css -->
        <link href="plugins/animate-css/animate.css" rel="stylesheet" />

        <!-- Morris Chart Css-->
        <link href="plugins/morrisjs/morris.css" rel="stylesheet" />

        <!-- Custom Css -->
        <link href="css/style.css" rel="stylesheet"/>

        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="css/themes/all-themes.css" rel="stylesheet" />
    </head>
    <body>
        <%
            int idusu = 0;
            try {
                idusu = Integer.parseInt(session.getAttribute("idusuario").toString());
            } catch (Exception e) {
                response.sendRedirect("error.jsp?men=Su sesión ha caducado.");
            }
            usuario usu = usuario.CargarxId(idusu);
            actaDB acDB = new actaDB();
            //int totac = acDB.ContarActasUsuario(idusu);

            int totacUsuPres, totacUsuAN, totacUsuPA, totacUsuAP, totacUsuCP, totacUsuPCH, totacUsuPCM, totacUsuPCME;
            int idTipoUsuario = Integer.parseInt(session.getAttribute("idtipousuario").toString());
            if (idTipoUsuario == 3 || idTipoUsuario == 5) {//Digitador o conteo rapido
                totacUsuPres = acDB.ContarActasUsuarioDignidad(idusu, 1);
                totacUsuAN = acDB.ContarActasUsuarioDignidad(idusu, 2);
                totacUsuPA = acDB.ContarActasUsuarioDignidad(idusu, 3);
                totacUsuAP = acDB.ContarActasUsuarioDignidad(idusu, 4);
            } else {
                totacUsuPres = acDB.ContarActasXDignidad(1);
                totacUsuAN = acDB.ContarActasXDignidad(2);
                totacUsuPA = acDB.ContarActasXDignidad(3);
                totacUsuAP = acDB.ContarActasXDignidad(4);
            }
        %>
        <div class=""></div>
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-lg-12 col-xs-12">
                        <div class="text-center">
                            <h1>Bienvenido al sistema-Actas ingresadas</h1>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="info-box bg-green hover-zoom-effect">
                            <div class="icon">
                                <i class="material-icons">account_balance</i>
                            </div>
                            <div class="content">
                                <div class="text"><b>PRESIDENTE Y VICEPRESIDENTE</b></div>
                                <div class="number count-to" data-from="0" data-to="<%= totacUsuPres%>" data-speed="1000" data-fresh-interval="20"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="info-box bg-red hover-zoom-effect">
                            <div class="icon">
                                <i class="material-icons">how_to_reg</i>
                            </div>
                            <div class="content">
                                <div class="text"><b>ASAMBLEÍSTAS PROVINCIALES</b></div>
                                <div class="number count-to" data-from="0" data-to="<%= totacUsuAN%>" data-speed="1000" data-fresh-interval="20"></div>
                            </div>
                        </div>
                    </div>
                </DIV>
                <div class="row clearfix">          
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="info-box bg-blue hover-zoom-effect">
                            <div class="icon">
                                <i class="material-icons">people</i>
                            </div>
                            <div class="content">
                                <div class="text"><b>PARLAMENTARIO ANDINO</b></div>
                                <div class="number count-to" data-from="0" data-to="<%= totacUsuPA%>" data-speed="1000" data-fresh-interval="20"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="info-box bg-orange hover-zoom-effect">
                            <div class="icon">
                                <i class="material-icons">domain</i>
                            </div>
                            <div class="content">
                                <div class="text"><b>ASAMBLEÍSTAS NACIONALES</b></div>
                                <div class="number count-to" data-from="0" data-to="<%= totacUsuAP%>" data-speed="1000" data-fresh-interval="20"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container-fluid">
                    <div class="row clearfix">
                        <div class="col-lg-12 col-xs-12">
                            <div class="text-center">
                                <br>
                                <p><b>Creado por: </b>Ing. Dubal Quevedo.</p>
                                <p><b>Contactos: </b>0969655372 - dubalquevedo@hotmail.com</p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
    </body>
    <!-- Jquery Core Js -->
    <script src="plugins/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Select Plugin Js -->
    <script src="plugins/bootstrap-select/js/bootstrap-select.js"></script>

    <!-- Slimscroll Plugin Js -->
    <script src="plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="plugins/node-waves/waves.js"></script>

    <!-- Jquery CountTo Plugin Js -->
    <script src="plugins/jquery-countto/jquery.countTo.js"></script>

    <!-- Morris Plugin Js -->
    <script src="plugins/raphael/raphael.min.js"></script>
    <script src="plugins/morrisjs/morris.js"></script>

    <!-- ChartJs -->
    <script src="plugins/chartjs/Chart.bundle.js"></script>

    <!-- Flot Charts Plugin Js -->
    <script src="plugins/flot-charts/jquery.flot.js"></script>
    <script src="plugins/flot-charts/jquery.flot.resize.js"></script>
    <script src="plugins/flot-charts/jquery.flot.pie.js"></script>
    <script src="plugins/flot-charts/jquery.flot.categories.js"></script>
    <script src="plugins/flot-charts/jquery.flot.time.js"></script>

    <!-- Sparkline Chart Plugin Js -->
    <script src="plugins/jquery-sparkline/jquery.sparkline.js"></script>

    <!-- Custom Js -->
    <script src="js/admin.js"></script>
    <script src="js/pages/index.js"></script>
</html>

