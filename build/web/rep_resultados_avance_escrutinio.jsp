<%-- 
    Document   : act_recepcion
    Created on : 29/01/2013, 05:21:08 PM
    Author     : root
--%>

<%@page import="eleccion.ClassResultadosAvanceEscrutinio"%>
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
        <title>Avacne de Escrutinio</title>

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

        <link rel="stylesheet" type="text/css" href="includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="includes/TableFilter/tablefilter.js"></script>

    </head>
    <body>
        <%
            ArrayList<ClassResultadosAvanceEscrutinio> listado_avance = (ArrayList<ClassResultadosAvanceEscrutinio>) session.getAttribute("listado_avance");
            ArrayList<ClassResultadosAvanceEscrutinio> listado_avance_canton = (ArrayList<ClassResultadosAvanceEscrutinio>) session.getAttribute("listado_avance_canton");
            ArrayList<ClassResultadosAvanceEscrutinio> listado_avance_canton_orden_dignidad = (ArrayList<ClassResultadosAvanceEscrutinio>) session.getAttribute("listado_avance_canton_orden_dignidad");
            ArrayList<ClassResultadosAvanceEscrutinio> listado_avance_dignidades = (ArrayList<ClassResultadosAvanceEscrutinio>) session.getAttribute("listado_avance_dignidades");
        %>
        <section class="content">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-sm-12">
                        <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto">
                            <script>
                                Highcharts.chart('container', {
                                    chart: {
                                        type: 'column'
                                    },
                                    title: {
                                        text: 'Avance de Escrutinio por Dingnidades'
                                    },
                                    subtitle: {
                                        text: 'Fecha y hora de reporte: <%= session.getAttribute("fecha_reporte")%>'
                                    },
                                    xAxis: {
                                        categories: [
                                            <%
                                    for (ClassResultadosAvanceEscrutinio c : listado_avance_canton) {
                                %>
                                            '<%= c.getNombre_canton() %>',<% } %>
                                        ],
                                        crosshair: true
                                    },
                                    yAxis: {
                                        min: 0,
                                        title: {
                                            text: 'Total de Actas(%)'
                                        }
                                    },
                                    tooltip: {
                                        positioner: function(){
                                            return { header:true };
                                        },
                                        headerFormat: '<span style="font-size:10px">{point.key}</span><table><td><b>Dignidad</b></td><td><b>Ing.</b></td><td><b>Tot. Jun.</b></td><td><b>%</b></td>',
                                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                                                '<td style="padding:0"><b>{point.val}</b></td><td style="padding:0"><b>{point.val2}</b></td><td style="padding:0"><b>{point.y:.2f}</b></td></tr>',
                                        footerFormat: '</table>',
                                        shared: true,
                                        useHTML: true
                                    },
                                    plotOptions: {
                                        column: {
                                            pointPadding: 0.2,
                                            borderWidth: 0,
                                            dataLabels: {
                                                enabled: true,
                                                useHTML: true,
                                                formatter: function () {
                                                    return '<center>' + this.point.y + '%' + ' : ' + this.point.val + ' de ' + this.point.val2 + '</center>';
                                                }
                                            }
                                        }
                                    },
                                    series: [
                                        <% for(ClassResultadosAvanceEscrutinio c : listado_avance_dignidades) { %>
                                        {
                                            name: '<%= c.getNombre_dignidad() %>',
                                            data: [
                                                <% for(ClassResultadosAvanceEscrutinio ac : listado_avance_canton_orden_dignidad) { 
                                                if(ac.getIddignidad()==c.getIddignidad()){
                                                    double porc=ac.getIngresadas() * 100.0 / ac.getTotal(); 
                                                %>
                                                {y: <%= Math.floor(porc *100) / 100d%>, val: <%= ac.getIngresadas() %>, val2: <%= ac.getTotal() %>},
                                                  <% }
                                                } %>
                                            ]
                                        },
                                        <% } %>
                                        ]
                                });
                            </script>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-sm-12">
                        <table id="lista_table_filter_avance_escrutinio" class="table table-hover text-centered">
                            <thead>
                                <tr>
                                    <td><b>CANTON</b></td>
                                    <td><b>DIGNIDAD</b></td>
                                    <td><b>INGRESADAS</b></td>
                                    <td><b>TOTAL DE JUNTAS</b></td>
                                    <td><b>% AVANCE</b></td>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    double por = 0;
                                    for (ClassResultadosAvanceEscrutinio c : listado_avance) {
                                        por = (c.getIngresadas() * 100.00 ) / c.getTotal();
                                %>
                                <tr>
                                    <td><%= c.getNombre_canton()%></td>      
                                    <td><%= c.getNombre_dignidad()%></td>      
                                    <td><%= c.getIngresadas()%></td>    
                                    <td><%= c.getTotal()%></td>    
                                    <td><%= Math.floor(por * 100) / 100d%></td> 
                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                        <script language="javascript" type="text/javascript">
                            var table3Filters = {
                                sort: true,
                                sort_config: { sort_types: ['String','String','Number','Number','Number']}, 
                                help_instructions:false,
                                col_operation: {
                                    id: ["table8Tot1"], 
                                    col: [2],
                                    operation: ["sum"],
                                    decimal_precision: [1],
                                    write_method: ["innerhtml"] 
                                },
                                btn_reset: true,
                                btn_reset_text: "Quitar Filtros",
                                rows_counter: true,
                                remember_grid_values: true,
                                rows_counter_text: "Total: ",
                                base_path: "includes/TableFilter/",
                                col_0: "select",
                                col_1: "select",
                                col_2: "input",
                                col_3: "input",
                                col_4: "none",
                                display_all_text: "<TODOS>",
                                loader: true,
                                loader_css_class: "myLoader",
                                loader_html: '<img src="includes/TableFilter/loader.gif" alt="" style="vertical-align:middle; margin-right:5px;">Cargando...'
                            };
                            var tf03 = setFilterGrid("lista_table_filter_avance_escrutinio", table3Filters);
                        </script> 

                    </div>
                </div>
            </div>
        </section>  
    </body>
</html>
