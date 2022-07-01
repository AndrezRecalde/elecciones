<%-- 
    Document   : act_recepcion
    Created on : 29/01/2013, 05:21:08 PM
    Author     : root
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="eleccion.ClassResultadosBasico"%>
<%@page import="eleccion.usuario"%>
<%@page import="eleccion.usuarioDB"%>
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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Digitacion de Actas</title>

        <link href="styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="styles/basic.css" rel="stylesheet" type="text/css" media="screen" />

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script type="text/javascript" src="includes/jquery-1.8.2.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/data.js"></script>
        <script src="https://code.highcharts.com/modules/drilldown.js"></script>

        <script type="text/javascript" src="includes/combinados_2.js"></script>

        <script>
            $(function () {
            $("#tabs").tabs();
            });
        </script>

    </head>
    <body>
        <form name="form1" action="resultados">
            <%
                usuarioDB usu = new usuarioDB();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                int idusu = 0;
                try {
                    idusu = Integer.parseInt(session.getAttribute("idusuario").toString());
                } catch (Exception e) {
                    response.sendRedirect("error.jsp?men=Su sesión ha caducado.");
                    return;
                }
                if (request.getParameter("actas") != null) {
                    actaDB actaDB = new actaDB();
                    int iddignidad = 0, idprovincia = 0, idcanton = 0, idparroquia = 0, idzona = 0, idjunta = 0, idrecinto=0;
                    String dignidad = "", provincia = "", canton = "", parroquia = "", zona = "", junta = "",recinto="";
                    boolean error = false;
                    String errorString = "";
                    if (request.getParameter("iddignidad") != null) {
                        iddignidad = Integer.parseInt(request.getParameter("iddignidad").toString());
                        if (iddignidad == -1) {
                            error = true;
                            errorString = "Por favor seleecione una Dignidad";
                        }
                        ArrayList lista = null;
                        if (session.getAttribute("dignidades") != null) {
                            lista = (ArrayList) session.getAttribute("dignidades");
                        }
                        if (lista.size() != 0) {
                            for (int x = 0; x < lista.size(); x = x + 2) {
                                if (lista.get(x).toString().equals(request.getParameter("iddignidad").toString())) {
                                    dignidad = lista.get(x + 1).toString();
                                }
                            }
                        }
                    }
                    if (request.getParameter("idprovincia") != null) {
                        idprovincia = Integer.parseInt(request.getParameter("idprovincia").toString());
                        if (idprovincia == -1) {
                            error = true;
                            errorString = "Por favor seleecione una Provincia";
                        }
                        ArrayList lista = null;
                        if (session.getAttribute("provincias") != null) {
                            lista = (ArrayList) session.getAttribute("provincias");
                        }
                        if (lista.size() != 0) {
                            for (int x = 0; x < lista.size(); x = x + 2) {
                                if (lista.get(x).toString().equals(request.getParameter("idprovincia").toString())) {
                                    provincia = lista.get(x + 1).toString();
                                }
                            }
                        }
                    }
                    if (request.getParameter("idcanton") != null) {
                        idcanton = Integer.parseInt(request.getParameter("idcanton").toString());
                        if (idcanton == -1) {
                            error = true;
                            errorString = "Por favor seleecione un Canton";
                        }
                        ArrayList lista = null;
                        if (session.getAttribute("cantones") != null) {
                            lista = (ArrayList) session.getAttribute("cantones");
                        }
                        if (lista.size() != 0) {
                            for (int x = 0; x < lista.size(); x = x + 3) {
                                if (lista.get(x).toString().equals(request.getParameter("idcanton").toString())) {
                                    canton = lista.get(x + 1).toString();
                                }
                            }
                        }
                    }
                    if (request.getParameter("idparroquia") != null) {
                        idparroquia = Integer.parseInt(request.getParameter("idparroquia").toString());
                        if (idparroquia == -1) {
                            error = true;
                            errorString = "Por favor seleecione una Parroquia";
                        }
                        ArrayList lista = null;
                        if (session.getAttribute("parroquias") != null) {
                            lista = (ArrayList) session.getAttribute("parroquias");
                        }
                        if (lista.size() != 0) {
                            for (int x = 0; x < lista.size(); x = x + 3) {
                                if (lista.get(x).toString().equals(request.getParameter("idparroquia").toString())) {
                                    parroquia = lista.get(x + 1).toString();
                                }
                            }
                        }
                    }
                    if (request.getParameter("idrecinto") != null) {
                        idrecinto = Integer.parseInt(request.getParameter("idrecinto").toString());
                        if (idrecinto == -1) {
                            error = true;
                            errorString = "Por favor seleecione un Recinto";
                        }
                        ArrayList lista = null;
                        if (session.getAttribute("recintos") != null) {
                            lista = (ArrayList) session.getAttribute("recintos");
                        }
                        if (lista.size() != 0) {
                            for (int x = 0; x < lista.size(); x = x + 3) {
                                if (lista.get(x).toString().equals(request.getParameter("idrecinto").toString())) {
                                    recinto = lista.get(x + 1).toString();
                                }
                            }
                        }
                    }
                    if (!error) {
                        //Veo si ya se ha ingresado el acta de esa dignidad
                        if (actaDB.ExisteJuntaDignidad(idjunta, iddignidad)) {
                            response.sendRedirect("dig_actas_dignidad_junta_ver.jsp?iddignidad=" + iddignidad + "&idjunta=" + idjunta);
                            return;
                        } else {
                            response.sendRedirect("dig_actas_dignidad_junta_digitar.jsp?iddignidad=" + iddignidad + "&idprovincia=" + idprovincia + "&idcanton=" + idcanton
                                    + "&idparroquia=" + idparroquia + "&idzona=" + idzona + "&idjunta=" + idjunta + "&ver=dig&dignidad=" + dignidad + "&provincia=" + provincia
                                    + "&canton=" + canton + "&parroquia=" + parroquia + "&zona=" + zona + "&junta=" + junta);
                            return;
                        }
                    } else {
            %>
            Error: <%= errorString%>
            <%
                    }
                }
            %>

            <section class="content">
                <div class="container-fluid">
                    <div class="row clearfix">
                        <div class="col-sm-6">
                            <div class="row">
                                <table class="table table-hover text-centered">
                                    <tr>
                                        <td style="text-align: center" colspan="2"><h1><b>RESULTADOS</b></h1>
                                            <b>Fecha y hora de reporte: <%= sdf.format(Calendar.getInstance().getTime())%></b>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>DIGNIDAD:</b></td>
                                        <td>
                                            <select name="iddignidad" id="iddignidad" style="width: 150px">
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>PROVINCIA:</b></td>
                                        <td>
                                            <select name="idprovincia" id="idprovincia" style="width: 150px">
                                            </select>
                                            <input type="submit" title="Actualizar reporte a nivel provincial" name="nivel_territorio_prov_jsp" class="img_boton_chart" value="">
                                            <input type="submit" title="Descargar datos en Excel a nivel provincial" name="nivel_territorio_prov_xls" class="img_boton_excel" value="">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>CANTÓN:</b></td>
                                        <td>
                                            <select name="idcanton" id="idcanton" style="width: 150px">
                                            </select>
                                            <input type="submit" title="Actualizar reporte a nivel cantonal" name="nivel_territorio_cant_jsp" class="img_boton_chart" value="">
                                            <input type="submit" title="Descargar datos en Excel a nivel cantonal" name="nivel_territorio_cant_xls" class="img_boton_excel" value="">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>PARROQUIA:</b></td>
                                        <td>
                                            <select name="idparroquia" id="idparroquia" style="width: 150px">
                                            </select>
                                            <input type="submit" title="Actualizar reporte a nivel parroquial" name="nivel_territorio_parr_jsp" class="img_boton_chart" value="">
                                            <input type="submit" title="Descargar datos en Excel a nivel parroquial" name="nivel_territorio_parr_xls" class="img_boton_excel" value="">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>RECINTO:</b></td>
                                        <td>
                                            <select name="idrecinto" id="idrecinto" style="width: 150px">
                                            </select>
                                            <input type="submit" title="Actualizar reporte a nivel recinto" name="nivel_territorio_recinto_jsp" class="img_boton_chart" value="">
                                            <input type="submit" title="Descargar datos en Excel a nivel recinto" name="nivel_territorio_recinto_xls" class="img_boton_excel" value="">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" style="text-align: center">
                                            Por favor seleccione el ícono de gráfico para actualizar los resultados y el de Excel para descargar los datos.
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <div class="row">   

                                <div class="rep_pie">
                                    <div id="pie-porcentaje-ingreso" style="min-width: 310px; height: 350px; max-width: 600px; margin: 0 auto"></div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="container-fluid">
                    <div class="row clearfix">
                        <div class="col-sm-12">
                            <div id="tabs">
                                <ul>
                                    <% if (request.getParameter("tipo_eleccion").equals("pluripersonal")) { %>
                                    <li><a href="#tabs-2">POR LISTAS</a></li>
                                        <% }%>
                                    <li><a href="#tabs-1">POR CANDIDATOS</a></li>
                                </ul>

                                <% if (request.getParameter("tipo_eleccion").equals("pluripersonal")) {%>
                                <div id="tabs-2">

                                    <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto">
                                        <script>
                                            // Create the chart
                                            Highcharts.chart('container', {
                                            chart: {
                                            type: 'column'
                                            },
                                                    title: {
                                                    text: 'RESULTADOS <%= request.getParameter("dignidad_string")%> 2020'
                                                    },
                                                    subtitle: {
                                                    text: 'De clic en la lista para ver el detalle de las votaciones por candidatos'
                                                    },
                                                    xAxis: {
                                                    type: 'category',
                                                    },
                                                    yAxis: {
                                                    title: {
                                                    text: 'Total de votos'
                                                    }
                                                    },
                                                    legend: {
                                                        enabled: false
                                                    },
                                                    plotOptions: {
                                                    column: {
                                                        pointPadding: 0.2,
                                                            borderWidth: 0,
                                                            dataLabels: {
                                                            enabled: true,
                                                                    useHTML: true,
                                                                    formatter: function () {
                                                                    return '<center><img style="width: 20px; height: 20px;" src="' + this.point.myImage + '"/><br>' + this.point.y + ' %' + ' - ' + this.point.val + ' votos ' + '</center>';
                                                                    }
                                                            }
                                                        }
                                                    },
                                                    tooltip: {
                                                        enabled: true,
                                                        positioner: function () {
                                                            return { header:true};
                                                        },
                                                        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                                                        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
                                                    },
                                                    "series": [
                                                    {
                                                        "name": "Total de Votos",
                                                            "colorByPoint": true,
                                                            "data": [
                                            <% ArrayList<ClassResultadosBasico> lista_chart_lista = (ArrayList<ClassResultadosBasico>) session.getAttribute("lista_chart_lista");
                                                float total_votos = Float.parseFloat(request.getParameter("total_votos"));
                                                float por = 0;
                                                for (ClassResultadosBasico c : lista_chart_lista) {
                                                    por = (c.getTotal_votos() / total_votos) * 100; %>
                                                            {
                                                                "name": "<%= c.getSiglas() + " " + c.getListas()%>",
                                                                "y": <%= Math.floor(por * 100) / 100d%>,
                                                                "val": <%= c.getTotal_votos()%>,
                                                                "myImage": "images/logos/<%= c.getIdorganizacion()%>.jpg",
                                                                "drilldown": "<%= c.getSiglas() + " " + c.getListas()%>",
                                                                "color": "<%= c.getColor()%>"
                                                            },<% } %>
                                                            ]
                                                    }
                                                    ],
                                                    "drilldown": {
                                                    "series": [
                                            <%ArrayList<ClassResultadosBasico> chart_lista_res_cand = (ArrayList<ClassResultadosBasico>) session.getAttribute("lista_chart_basic");
                                                for (ClassResultadosBasico c : lista_chart_lista) {%>
                                                    {
                                                        "name": "<%= c.getSiglas() + " " + c.getListas()%>",
                                                        "id": "<%= c.getSiglas() + " " + c.getListas()%>",
                                                        "data": [
                                            <%  
                                                for (ClassResultadosBasico can : chart_lista_res_cand) {
                                                    if (can.getListas().equals(c.getListas())) {
                                                        double por2=0;
                                                        if(c.getTotal_votos()>0){
                                                            por2 = can.getTotal_votos() * 100.00 / c.getTotal_votos();
                                                        }
                                            %>
                                                            {
                                                                name: "<%= can.getNombre()%>",
                                                                y: <%= Math.floor(por2 * 100) / 100d%>,
                                                                val: <%= can.getTotal_votos()%>,
                                                                myImage: "images/candidatos/1.png"
                                                            },
                                            <% }
                                                }%>
                                                            ]
                                                    },
                                            <% } %>
                                                    ]
                                                    }
                                            });
                                        </script>
                                    </div>
                                </div>
                                <% }%>

                                <div id="tabs-1">
                                    <div class="rep_contenedor" >
                                        <div id="bar-chart-unipersonal" style="background-color: white">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    if (request.getParameter("men") != null) {
                %>
                <%= request.getParameter("men").toString()%>
                <%
                    }
                %>

                <script>
                    Highcharts.chart('pie-porcentaje-ingreso', {
                    chart: {
                    plotBackgroundColor: null,
                            plotBorderWidth: 0,
                            plotShadow: false
                    },
                            title: {
                            text: 'Avance de Actas<br> <b>2020</b>',
                                    align: 'center',
                                    verticalAlign: 'middle',
                                    y: 40
                            },
                            tooltip: {
                            pointFormat: '{series.name}: <b>{point.percentage:.1f}%-{point.val}</b>'
                            },
                            plotOptions: {
                            pie: {
                            dataLabels: {
                            enabled: true,
                                    distance: - 50,
                                    style: {
                                    fontWeight: 'bold',
                                            color: 'white'
                                    }
                            },
                                    startAngle: - 90,
                                    endAngle: 90,
                                    center: ['50%', '85%']
                            }
                            },
                            series: [{
                            type: 'pie',
                                    name: 'Actas Ingresadas',
                                    innerSize: '50%',
                                    data: [
                                    {
                                    name: 'INGRESADAS-<%= request.getParameter("total_actas_ingresadas")%>',
                                            y: <%= request.getParameter("total_actas_ingresadas")%> * 100 /<%= request.getParameter("total_actas")%>,
                                            val: <%= request.getParameter("total_actas_ingresadas")%>,
                                            color: '#52b178'
                                    },
                                    {
                                    name: 'RESTANTES-<%= request.getParameter("total_actas_faltantes")%>',
                                            y: <%= request.getParameter("total_actas_faltantes")%> * 100 /<%= request.getParameter("total_actas")%>,
                                            val: <%= request.getParameter("total_actas_faltantes")%>,
                                            color: '#FF3D3D'
                                    }
                                    ]
                            }]
                    });
                </script>
                <script>
                    Highcharts.chart('bar-chart-unipersonal', {
                    chart: {
                    type: 'column'
                    },
                            title: {
                            text: 'RESULTADOS <%= request.getParameter("dignidad_string")%> 2020'
                            },
                            subtitle: {
                            text: 'Total de votos unipersonales'
                            },
                            tooltip: {
                            pointFormat: '<span style="color:{point.color}">{series.name}</span>: <b>{point.y:.2f}% - {point.val}</b> votos<br/>'
                            },
                            xAxis: {
                            categories: [
                                    'Candidatos'
                            ],
                                    crosshair: true
                            },
                            yAxis: {
                            min: 0,
                                    title: {
                                    text: 'Total de votos(%)'
                                    }
                            },
                            plotOptions: {
                            column: {
                            pointPadding: 0.2,
                                    borderWidth: 0
                            },
                                    series: {
                                    borderWidth: 0,
                                            dataLabels: {
                                            enabled: true,
                                                    format: '{point.siglas}:' + '{point.y:.1f}%' + ' - ' + ' {point.val}'
                                            }
                                    }
                            },
                            series: [
                    <% ArrayList<ClassResultadosBasico> chart_lista_res_basic = (ArrayList<ClassResultadosBasico>) session.getAttribute("lista_chart_basic");
                        for (ClassResultadosBasico c : chart_lista_res_basic) {%>
                            {
                            name: '<%= c.getNombre()%>-<%= c.getSiglas()%>',
                                                color: '<%= c.getColor()%>',
                                                data: [{y:<%= c.getTotal_votos()%> * 100 / <%= request.getParameter("total_votos")%>, val:<%= c.getTotal_votos()%>, siglas:'<%= c.getSiglas()%>'}]
                                        }, <% } %>
                                        ]
                                });

                </script>
                <div class="container-fluid">
                    <div class="row clearfix">
                        <div class="col-sm-12">
                            <table class="table table-hover text-centered">
                                <tr>
                                    <td><b>LISTA</b></td>
                                    <td><b>CANDIDATO</b></td>
                                    <td><b>TOTAL</b></td>
                                    <td><b>%</b></td>
                                </tr>
                                <%
                                    float total_votos = Float.parseFloat(request.getParameter("total_votos"));
                                    float por = 0;
                                    for (ClassResultadosBasico c : chart_lista_res_basic) {
                                        por = (c.getTotal_votos() / total_votos) * 100;
                                %>
                                <tr>
                                    <td><%= c.getListas()%></td>      
                                    <td><%= c.getNombre()%></td>      
                                    <td><%= c.getTotal_votos()%></td>    
                                    <td><%= Math.floor(por * 100) / 100d%></td> 
                                </tr>
                                <%}%>
                            </table>
                        </div>
                    </div>
                </div>
            </section>  
        </div>
    </form>
</body>
</html>
