<%-- 
   Document   : index
   Created on : Jul 12, 2014, 11:48:02 AM
   Author     : Generado V1.0
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="admin.Cacta" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos-Actas</title>
        <link href="../styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="../styles/basic.css" rel="stylesheet" type="text/css" media="screen" />

        <link rel="stylesheet" type="text/css" href="../includes/TableFilter/filtergrid.css" media="screen" />
        <script type="text/javascript" src="../includes/TableFilter/tablefilter.js"></script>
    </head>
    <body>
        <% SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); %>
        <form name="form1">
            <center>            
                <div>
                    <button disabled="true" class="boton"><a href="admin_controlador.srvlt_acta_listar_todos?op=<%=request.getParameter("op") %>">Refrescar</a></button>
                    <button disabled="true" class="boton"><a href="javascript:history.back(1)">Regresar</a></button>
                </div>
                <div class="contenedor_tabla">     
                    <h3><%= request.getParameter("tit") %></h3>
                    <table id="lista_table_filter_acta" class="clsTablaDatos form_style">
                        <thead>
                            <tr>               
                                <td><b>Canton</b></td>               
                                <td><b>Parroquia</b></td>               
                                <td><b>Zona</b></td>        
                                <td><b>Recinto</b></td>   
                                <td><b>Junta</b></td> 
                                <td><b>Dignidad</b></td>               
                                <td><b>Código de Acta CNE</b></td>               
                                <td><b>Total Huellas y Firmas</b></td>               
                                <td><b>No votaron</b></td>               
                                <td><b>Total de Votos en Blancos</b></td>               
                                <td><b>Total de Votos Nulos</b></td>               
                                <td><b>Cuadrada?</b></td>               
                                <td><b>Es Legible?</b></td>     
                                <td><b>Usuario</b></td>
                                <td><b>Fecha/Hora</b></td>        
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Cacta> lista = (ArrayList<Cacta>) session.getAttribute("lista_acta");
                                for (Cacta c : lista) {
                            %>
                            <tr ondblclick="document.location ='../dig_actas_dignidad_junta_ver.jsp?iddignidad=<%= c.getfr_id_dignidad() %>&idprovincia=<%= c.getcod_provincia() %>&idcanton=<%= c.getcod_canton() %>&idparroquia=<%= c.getcod_parroquia() %>&idzona=<%= c.getcod_zona() %>&idjunta=<%= c.getfr_id_junta() %>&ver=ver&dignidad=<%= c.getDignidad_string() %>&provincia=ESMERALDAS&canton=<%= c.getCanton_string() %>&parroquia=<%= c.getParroquia_string() %>&zona=<%= c.getZonas_string() %>&junta=<%= c.getjunta_string() %>'">
                                <td><%= c.getCanton_string()%></td>        
                                <td><%= c.getParroquia_string()%></td>   
                                <td><%= c.getZonas_string()%></td>   
                                <td><%= c.getRecinto_string()%></td> 
                                <td><%= c.getjunta_string()%></td>  
                                <td><%= c.getDignidad_string()%></td> 
                                <td><%= c.getcne_cod_acta()%></td>               
                                <td><%= c.getnum_validos()%></td>               
                                <td><%= c.getnum_no_voto()%></td>               
                                <td><%= c.getnum_blancos()%></td>               
                                <td><%= c.getnum_nulos()%></td>               
                                <td><% if (c.getcuadrada()) {%>SI<%} else {%>NO<%}%></td>               
                                <td><% if (c.getlegible()) {%>SI<%} else {%>NO<%}%></td>               
                                <td><%= c.getActa_usu_ing_string() %></td>               
                                <td><%= sdf.format(c.getacta_fi())%></td>               
                                <td>
                                    <a class="boton active" title="Ver Acta" href="../dig_actas_dignidad_junta_ver.jsp?iddignidad=<%= c.getfr_id_dignidad() %>&idprovincia=<%= c.getcod_provincia() %>&idcanton=<%= c.getcod_canton() %>&idparroquia=<%= c.getcod_parroquia() %>&idzona=<%= c.getcod_zona() %>&idjunta=<%= c.getfr_id_junta() %>&ver=ver&dignidad=<%= c.getDignidad_string() %>&provincia=ESMERALDAS&canton=<%= c.getCanton_string() %>&parroquia=<%= c.getParroquia_string() %>&zona=<%= c.getZonas_string() %>&junta=<%= c.getjunta_string() %>">Ver</a>
                                    <%
                                        }
                                    %>
                        </tbody>
                    </table>
                    <script language="javascript" type="text/javascript">
                        var table3Filters = {
                            sort: true,
                            sort_config: {sort_col: [0, false]},
                            btn_reset: true,
                            btn_reset_text: "Quitar Filtros",
                            rows_counter: true,
                            remember_grid_values: true,
                            rows_counter_text: "Total: ",
                            base_path: "../includes/TableFilter/",
                            col_0: "select",
                            col_1: "select",
                            col_2: "select",
                            col_3: "select",
                            col_4: "select",
                            col_5: "select",
                            col_6: "input",
                            col_7: "input",
                            col_8: "input",
                            col_9: "input",
                            col_10: "input",
                            col_11: "select",
                            col_12: "select",
                            col_13: "select",
                            col_14: "input",
                            col_15: "none",
                            display_all_text: "<TODOS>",
                            loader: true,
                            loader_css_class: "myLoader",
                            loader_html: '<img src="../includes/TableFilter/loader.gif" alt="" style="vertical-align:middle; margin-right:5px;">Cargando...'
                        };
                        var tf03 = setFilterGrid("lista_table_filter_acta", table3Filters);
                    </script> 
                </div>
            </center>
        </form>
    </body>
</html>