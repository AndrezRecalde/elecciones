<%-- 
    Document   : hont
    Created on : 07-ene-2021, 8:22:07
    Author     : TIC-DQUEVEDO
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eleccion.ClassResultadosBasico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Webster</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script type="text/javascript" src="includes/jquery-1.8.2.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/data.js"></script>
        <script src="https://code.highcharts.com/modules/drilldown.js"></script>
    </head>
    <body>
        <h1 class="text-centered"><%= request.getParameter("dignidad_string") %></h1>
        <% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); %>
        <b>Fecha y hora de reporte:</b> <%= sdf.format(Calendar.getInstance().getTime()) %>
        <div>
             <% ArrayList<ClassResultadosBasico> chart_lista_res_basic = (ArrayList<ClassResultadosBasico>) session.getAttribute("resultados_webster"); %>
            <div class="container-fluid">
                    <div class="row clearfix">
                        <div class="col-sm-8">
                            <table class="table table-hover text-centered">
                                <tr>
                                    <td><b>LISTAS</b></td>
                                    <td><b>ORGANIZACIÓN</b></td>
                                    <td><b>TOTAL VOTOS</b></td>
                                    <td><b>1</b></td>
                                    <td><b>3</b></td>
                                    <td><b>5</b></td>
                                    <td><b>7</b></td>
                                    <td><b># Escaños</b></td>
                                </tr>
                                <script>
                                    function marcar(i,id,code_color){
                                        var tot= document.getElementById(i).value;
                                        if(document.getElementById(id).style.fontWeight === "bold"){
                                            document.getElementById(id).removeAttribute("style");
                                            tot --;
                                        }else{
                                            document.getElementById(id).style.fontWeight = "bold";
                                            document.getElementById(id).style.backgroundColor = code_color;
                                            document.getElementById(id).style.padding = "5px";
                                            tot ++;
                                        }
                                        document.getElementById(i).value = tot ;
                                    }
                                </script>
                                <%
                                    float total_votos = Float.parseFloat(request.getParameter("total_votos"));
                                    float por = 0;
                                    int i=0;
                                    for (ClassResultadosBasico c : chart_lista_res_basic) {
                                        por = (c.getTotal_votos() / total_votos) * 100;
                                        i++;
                                %>
                                <tr>
                                    <td><img src="images/logos/<%= c.getListas() %>.jpg" style="width: 50px" class="img-fluid"></td>      
                                    <td><%= c.getNombre()%></td>      
                                    <td class="text-centered"><%= c.getTotal_votos()%></td>    
                                    <td class="text-centered"><span onclick="marcar(<%= i%>,'<%=i%>_1','<%= c.getColor() %>');" id="<%=i%>_1"><%= c.getTotal_votos()%></span></td> 
                                    <td class="text-centered"><span onclick="marcar(<%= i%>,'<%=i%>_3','<%= c.getColor() %>');" id="<%=i%>_3"><%= c.getTotal_votos()/3%></span></td>
                                    <td class="text-centered"><span onclick="marcar(<%= i%>,'<%=i%>_5','<%= c.getColor() %>');" id="<%=i%>_5"><%= c.getTotal_votos()/5%></span></td> 
                                    <td class="text-centered"><span onclick="marcar(<%= i%>,'<%=i%>_7','<%= c.getColor() %>');" id="<%=i%>_7"><%= c.getTotal_votos()/7%></span></td> 
                                    <td><input id="<%=i%>" type="number" value="0" style="width: 35px"/></td>
                                </tr>
                                <%}%>
                            </table>
                        </div>
                        <div class="col-sm-4">
                            <div class="row">   
                                <div class="rep_pie">
                                    <div id="pie-porcentaje-ingreso" style="min-width: 310px; height: 350px; max-width: 600px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
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
    </body>
</html>
