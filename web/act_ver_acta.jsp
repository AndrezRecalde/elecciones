<%-- 
    Document   : act_recepcion
    Created on : 29/01/2013, 05:21:08 PM
    Author     : root
--%>

<%@page import="eleccion.zonasDB"%>
<%@page import="eleccion.zonas"%>
<%@page import="eleccion.actaDB"%>
<%@page import="eleccion.acta"%>
<%@page import="eleccion.cantonesDB"%>
<%@page import="eleccion.parroquiasDB"%>
<%@page import="eleccion.recintosDB"%>
<%@page import="eleccion.juntaDB"%>
<%@page import="eleccion.cantones"%>
<%@page import="eleccion.parroquias"%>
<%@page import="eleccion.recintos"%>
<%@page import="eleccion.junta"%>
<%@page import="eleccion.provincia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eleccion.provinciaDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recepcion de Actas</title>
        <link href="styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="includes/jquery.js"></script>
        <script type="text/javascript" src="includes/combinados.js"></script>
    </head>
    <body>
        <form name="form1" action="act_recepcion_junta.jsp">
            <%
            junta JU = new junta();
            recintos RE = new recintos();
            parroquias PA = new parroquias();
            cantones CA = new cantones();
            provincia PR = new provincia();
            juntaDB JUdb = new juntaDB();
            recintosDB REdb = new recintosDB();
            parroquiasDB PAdb = new parroquiasDB();
            cantonesDB CAdb = new cantonesDB();
            provinciaDB PRdb = new provinciaDB();
            acta AC = new acta();
            actaDB ACdb = new actaDB();
            zonas ZO = new zonas();
            zonasDB ZOdb = new zonasDB();
            int junta = 0,acta=0;
            int recinto=0,provincia=0,canton=0,parroquia=0;
                if(request.getParameter("acta")!=null){
                    provincia=Integer.parseInt(request.getParameter("provincia").toString());
                    canton=Integer.parseInt(request.getParameter("canton").toString());
                    parroquia=Integer.parseInt(request.getParameter("parroquia").toString());
                    recinto=Integer.parseInt(request.getParameter("recinto").toString());
                    junta=Integer.parseInt(request.getParameter("junta").toString());
                    acta=Integer.parseInt(request.getParameter("acta").toString());
                    JU= JUdb.CargarJuntaxId(junta);  //CargarxId Habia un error aqui
                    RE= REdb.CargarRecintoId(recinto);
                    PA= PAdb.CargarParroquiaId(parroquia);
                    CA= CAdb.CargarCantonId(canton);
                    PR= PRdb.CargarxId(provincia);
                    ZO= ZOdb.CargarxId(RE.getCod_zona(), PA.getCod_parroquia());
                    AC= ACdb.CargarActaId(acta);
                }else{
                    response.sendRedirect("error.jsp?men=Por favor seleccione una junta.");
                }
            %>
        <div id="cuerpo">
            <table id="navegacion">
                <tr>
                    <td><b>PROVINCIA:</b></td>
                    <td>
                        <input type="text" name="txt_provincia" readonly="true" value="<%= PR.getNombre_provincia() %>">
                    </td>
                </tr>
                <tr>
                    <td><b>CANTÓN:</b></td>
                    <td>
                        <input type="text" name="txt_canton" readonly="true" value="<%= CA.getNombre_canton() %>">
                    </td>
                </tr>
                <tr>
                    <td><b>PARROQUIA:</b></td>
                    <td>
                        <input type="text" name="txt_parroquia" readonly="true" value="<%= PA.getNombre_parroquia() %>">
                    </td>
                </tr>
                <tr>
                    <td><b>ZONA:</b></td>
                    <td>
                        <input type="text" name="txt_zona" readonly="true" value="<%= ZO.getNombre_zona() %>">
                    </td>
                </tr>
                <tr>
                    <td><b>RECINTO:</b></td>
                    <td>
                        <input type="text" name="txt_recinto" readonly="true" value="<%= RE.getNombre_recinto() %>">
                    </td>
                </tr>
                <tr>
                    <td><b>JUNTA:</b></td>
                    <td>
                        <input type="text" name="txt_junta" readonly="true" value="<%= JU.getJunta_nombre() %>">
                    </td>
                </tr>
                <tr>
                    <td><b>ACTA</b></td><td><%= AC.getIdacta() %></td>
                    <td><b>DIGNIDAD</b></td><td><%= AC.getDignidad_nombre() %></td>
                    <td><b>VALIDOS</b></td><td><%= AC.getNum_validos() %></td>
                    <td><b>NO VOTO</b></td><td><%= AC.getNum_no_voto() %></td>
                    <td><b>BLANCOS</b></td><td><%= AC.getNum_blancos() %></td>
                    <td><b>NULOS</b></td><td><%= AC.getNum_nulos() %></td>
                    <td><b>LEGIBLE</b></td>
                    <td><% if(AC.isLegible())
                                {
                                out.println("SI");
                                }
                                else{
                                    out.println("NO");
                                } 
                            %>
                    </td>
                    <td><b>CUADRADA</b></td>
                    <td><% if(AC.isCuadrada())
                                {
                                out.println("SI");
                                }
                                else{
                                    out.println("NO");
                                } 
                            %>
                    </td>
                    <td><b>ESTADO</b></td><%= AC.getEstado_nombre() %>
                </tr>
                <tr>
                    <td colspan="2">
                    <table id="tabla_actas">
                        <tr style="background-color:white;font-size: 12px">
                            
                        </tr>
                        <%
                            ArrayList <acta> lista = null;
                            //Estado 1 Pendientes
                            lista =ACdb.CargarActasJunta(JU.getIdjunta());
                            int t=0;
                            for (acta p : lista) {
                                t++;
                                if(t%2==0){
                        %>
                            <tr style="background-color:#7fcb91; font-size: 12px">
                        <%
                            }else{
                        %>
                                <tr style="background-color:white;font-size: 12px"><%
                            }
                        %>
                        <td>
                            <%= p.getIdacta()  %>
                        </td>
                        <td>
                            <%= p.getDignidad_nombre()  %>
                        </td>
                        <td>
                            <%= p.getNum_validos()  %>
                        </td>
                        <td>
                            <%= p.getNum_no_voto()  %>
                        </td>
                        <td>
                            <%= p.getNum_blancos()  %>
                        </td>
                        <td>
                            <%= p.getNum_nulos()  %>
                        </td>
                        <td>
                            <%= p.isLegible()  %>
                        </td>
                        <td>
                            <%= p.isCuadrada()  %>
                        </td>
                        <td>
                            <%= p.getEstado_nombre()  %>
                        </td>
                        </tr>
                        <%
                        } 
                    %>
                    </table>
                    
                    </td>
                </tr>
            </table>
        </div>
        </form>
    </body>
</html>
