<%-- 
   Document   : index
   Created on : Jul 12, 2014, 11:48:02 AM
   Author     : Generado V1.0
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="admin.Cjunta" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos-Juntas</title>
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
                    <button disabled="true" class="boton"><a href="admin_controlador.srvlt_junta_listar_todos">Refrescar</a></button>
                    <button disabled="true" class="boton"><a href="javascript:history.back(1)">Regresar</a></button>
                </div>
                <div class="contenedor_tabla">    
                    <table id="lista_table_filter_junta" class="clsTablaDatos form_style">
                        <thead>
                            <tr>               
                                <td><b>Canton</b></td>               
                                <td><b>Parroquia</b></td>               
                                <td><b>Zona</b></td>        
                                <td><b>Recinto</b></td> 
                                <td><b>Código CNE</b></td>   
                                <td><b>Género</b></td>               
                                <td><b>Junta</b></td> 
                                <td><b>Número de Electores CNE</b></td>  
                                <td><b>Nombre Delegado</b></td>               
                                <td><b>Teléfono Delegado</b></td>              
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Cjunta> lista = (ArrayList<Cjunta>) session.getAttribute("lista_junta");
                                for (Cjunta c : lista) {
                            %>
                            <tr>
                                <td><%= c.getCanton_string()%></td>        
                                <td><%= c.getParroquia_string()%></td>   
                                <td><%= c.getzonas_string()%></td>   
                                <td><%= c.getRecinto_string()%></td>               
                                <td><%= c.getcne_cod_junta()%></td> 
                                <td><%= c.getgenero()%></td>               
                                <td><%= c.getjunta_nombre()%></td>   
                                <td><%= c.getnum_electores_cne()%></td>                                    
                                <td><%= c.getresponsable()%></td>               
                                <td><%= c.getresponsable_telefono()%></td>               
                            </tr>
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
                            col_4: "input",
                            col_5: "select",
                            col_6: "input",
                            col_7: "input",
                            col_8: "input",
                            col_9: "input",
                            display_all_text: "<TODOS>",
                            loader: true,
                            loader_css_class: "myLoader",
                            loader_html: '<img src="../includes/TableFilter/loader.gif" alt="" style="vertical-align:middle; margin-right:5px;">Cargando...'
                        };
                        var tf03 = setFilterGrid("lista_table_filter_junta", table3Filters);
                    </script> 
                </div>
            </center>
        </form>
    </body>
</html>