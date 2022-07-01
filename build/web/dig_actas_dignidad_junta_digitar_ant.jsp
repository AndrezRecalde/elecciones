<%-- 
    Document   : act_recepcion
    Created on : 29/01/2013, 05:21:08 PM
    Author     : root
--%>

<%@page import="com.sun.org.apache.bcel.internal.generic.RET"%>
<%@page import="eleccion.parroquiasDB"%>
<%@page import="eleccion.junta"%>
<%@page import="eleccion.juntaDB"%>
<%@page import="eleccion.cantonesDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eleccion.candidatoDB"%>
<%@page import="eleccion.candidato"%>
<%@page import="eleccion.actaDB"%>
<%@page import="eleccion.acta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recepcion de Actas</title>
        <link href="styles/generales.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="styles/basic.css" rel="stylesheet" type="text/css" media="screen" />
        
        <script type="text/javascript" src="script/numeros.js"></script>

    </head>
    <body>
        <form name="form1" action="calificador">
            <%
                acta AC = new acta();
                actaDB ACdb = new actaDB();
                candidato CAND = new candidato();
                eleccion.junta JU = new junta();
                eleccion.juntaDB JUDb = new juntaDB();
                candidatoDB CANDdb = new candidatoDB();
                int iddignidad = 0, idprovincia = 0, idcanton = 0, idparroquia = 0, idzona = 0, idjunta = 0;
                String dignidad = "", provincia = "", canton = "", parroquia = "", zona = "", junta = "";
                iddignidad = Integer.parseInt(request.getParameter("iddignidad").toString());
                dignidad = request.getParameter("dignidad").toString();
                idprovincia = Integer.parseInt(request.getParameter("idprovincia").toString());
                provincia = request.getParameter("provincia").toString();
                idcanton = Integer.parseInt(request.getParameter("idcanton").toString());
                canton = request.getParameter("canton").toString();
                idparroquia = Integer.parseInt(request.getParameter("idparroquia").toString());
                parroquia = request.getParameter("parroquia").toString();
                idzona = Integer.parseInt(request.getParameter("idzona").toString());
                zona = request.getParameter("zona").toString();
                idjunta = Integer.parseInt(request.getParameter("idjunta").toString());
                junta = request.getParameter("junta").toString();
                JU = JUDb.CargarJuntaxId(idjunta);

                //CONDICION DEL TIPO DE PARROQUIA.
                /*
                * 1:PREFECTO
                * 2:ALCALDE
                * 3:CONCEJAR URBANO
                * 4:CONCEJAR RURAL
                * 5:JUNTA PARROQUIAL
                 */
                parroquiasDB parr = new parroquiasDB();
                String estParr = parr.CargarParroquiaId(idparroquia).getEstado_parroquia();
                if (estParr.equals("U")) {
                    if (iddignidad == 4 || iddignidad == 5) {
                        response.sendRedirect("mensaje.jsp?men=No se elije " + dignidad + " en una parroquia <b>URBANA</b>");
                        return;
                    }
                } else {
                    if (iddignidad == 3) {
                        response.sendRedirect("mensaje.jsp?men=No se elije " + dignidad + " en una parroquia <b>RURAL</b>");
                        return;
                    }
                }
            %>
            <div id="cuerpo" style="text-align: center" >
                <center>
                    <table>
                        <tr>
                            <td colspan="4" style="text-align: center">
                                <input type="hidden" name="idusuario" value="<%= session.getAttribute("idusuario").toString()%>">
                                <b><h2>ACTA DE ESCRUTINIO&nbsp;<%= request.getParameter("dignidad")%></h2></b>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: right" colspan="3"><b>ACTA Nº:</b></td>
                            <td>
                                <input type="text" name="txt_id_acta" readonly="true" value="(AUTO)">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3" style="text-align: right"><b>CODIGO CNE DE ACTA:</b></td>
                            <td>
                                <input autofocus type="text" id="txt_cne_cod_acta" onblur="valida_Text('txt_cne_cod_acta')" name="txt_cne_cod_acta" value="">
                            </td>
                        </tr>
                        <tr>
                            <td><b>PROVINCIA:</b></td>
                            <td>
                                <input type="hidden" name="iddignidad" value="<%= request.getParameter("iddignidad")%>">
                                <input type="hidden" name="dignidad" value="<%= request.getParameter("dignidad")%>">
                                <input type="hidden" name="idprovincia" value="<%= request.getParameter("idprovincia")%>">
                                <input type="hidden" name="provincia" value="<%= request.getParameter("provincia")%>">
                                <input type="hidden" name="idcanton" value="<%= request.getParameter("idcanton")%>">
                                <input type="hidden" name="canton" value="<%= request.getParameter("canton")%>">
                                <input type="hidden" name="idparroquia" value="<%= request.getParameter("idparroquia")%>">
                                <input type="hidden" name="parroquia" value="<%= request.getParameter("parroquia")%>">
                                <input type="hidden" name="idzona" value="<%= request.getParameter("idzona")%>">
                                <input type="hidden" name="zona" value="<%= request.getParameter("zona")%>">
                                <input type="hidden" name="idjunta" value="<%= request.getParameter("idjunta")%>">
                                <input type="hidden" name="junta" value="<%= request.getParameter("junta")%>">
                                <input type="text" name="txt_provincia" readonly="true" value="<%= request.getParameter("provincia")%>">
                            </td>
                            <td><b>PARROQUIA:</b></td>
                            <td>
                                <input type="text" name="txt_parroquia" readonly="true" value="<%= request.getParameter("parroquia")%>">
                            </td>
                        </tr>
                        <tr>
                            <td><b>CIRCUNSCRIPCIÓN</b></td>
                            <td>
                                <input type="text" name="txt_circunsc" readonly="true" value="">
                            </td>
                            <td><b>ZONA:</b></td>
                            <td>
                                <input type="text" name="txt_zona" readonly="true" value="<%= request.getParameter("zona")%>">
                            </td>
                        </tr>
                        <tr>
                            <td><b>CANTÓN:</b></td>
                            <td>
                                <input type="text" name="txt_canton" readonly="true" value="<%= request.getParameter("canton")%>">
                            </td>
                            <td><b>RECINTO:</b></td>
                            <td>
                                <input type="text" name="txt_recinto" readonly="true" value="<%= JU.getRecinto_nombre()%>">
                            </td>
                        </tr>
                        <tr>
                            <td><b>JUNTA:</b></td>
                            <td colspan="3">
                                <input type="text" name="txt_junta" readonly="true" value="<%= request.getParameter("junta")%>">
                            </td>
                        </tr>
                        <tr>
                            <td><b>TOTAL FIRMAS Y HUELLAS (Número):</b></td>
                            <td colspan="3"><input type="number" min="0" max="350" name="txt_total_votos" id="txt_total_votos" onblur="valida_Text('txt_total_votos')" value="0"></td>
                        </tr>
                        <tr>
                            <td><b>VOTOS EN BLANCO (Número):</b></td>
                            <td colspan="3"><input type="number" min="0" max="350" name="txt_votos_blanco" id="txt_votos_blanco" onblur="valida_Text('txt_votos_blanco')" value="0"></td>
                        </tr>
                        <tr>
                            <td><b>VOTOS NULOS (Número):</b></td>
                            <td colspan="3">
                                <input type="hidden" name="txt_no_votaron" id="txt_no_votaron" value="0"/>
                                <input type="number" min="0" max="350" name="txt_votos_nulos" id="txt_votos_nulos" onblur="valida_Text('txt_votos_nulos')"value="0">
                            </td>
                        </tr>
                    </table>
                    <table id="navegacion2">
                        <tr>
                            <td colspan="4" style="text-align: center">
                                <h1>VOTOS</h1>
                            </td>
                        </tr>
                        <%
                            ArrayList<candidato> lista = null;
                            //Estado 1 Pendientes
                            if (iddignidad == 1) { //Prefectura
                                lista = CANDdb.CargarxDignidadProvincial(iddignidad, idprovincia);
                            }
                            if (iddignidad == 2) { //Alcalde
                                cantonesDB cantDD = new cantonesDB();
                                lista = CANDdb.CargarxDignidadCantonal(iddignidad, cantDD.CargarIdCantonPadre(idcanton));
                            }
                            if (iddignidad == 3) { //Concejales Urbanos
                                lista = CANDdb.CargarxDignidadCantonal(iddignidad, idcanton);
                            }
                            if (iddignidad == 4) { //Concejales Rurales
                                lista = CANDdb.CargarxDignidadCantonal(iddignidad, idcanton);
                            }
                            if (iddignidad == 5) { //Presidente Junta
                                lista = CANDdb.CargarxDignidadParroquia(iddignidad, idparroquia);
                            }
                            if (iddignidad == 6) { //CPCCS MUJER
                                lista = CANDdb.CargarxDignidadProvincial(iddignidad, idprovincia);
                            }
                            if (iddignidad == 7) { //CPCCS HOMBRE
                                lista = CANDdb.CargarxDignidadProvincial(iddignidad, idprovincia);
                            }
                            if (iddignidad == 8) { //CPCCS MIN ETCN
                                lista = CANDdb.CargarxDignidadProvincial(iddignidad, idprovincia);
                            }
                            
                            //Busco el factor num_canidato en lista
                            int num_cand_elec=0;
                            breakLoop: for (candidato p : lista) {
                                for(candidato q : lista){
                                    if(p.getFr_id_organizacion()==q.getFr_id_organizacion()){
                                        num_cand_elec++;
                                    }else{
                                        break breakLoop;
                                    }
                                }
                                break breakLoop;
                            }
                            
                            //Excepción por CPCS numero de candidatos por lista
                            if (iddignidad == 6 ||iddignidad == 7 ||iddignidad == 8 ) {
                                num_cand_elec=1;
                            }
                            
                            int t = 0;
                            for (candidato p : lista) {
                                t++;
                        %>
                        <tr>
                            <td>
                                <img class="foto" src="images/logos/<%= p.getFr_id_organizacion()%>.jpg" style="width: 50px; height: 50px">
                            </td>
                            <td>
                                <b><%= p.getOrganizacion_nombre()%></b>
                            </td>
                            <td>
                                <b><%= p.getNombre()%></b>
                            </td>
                            <td>
                                <input type="number" min="0" max="350" id="<%= t%>" onblur="valida_Text('<%= t%>')" name="<%= p.getIdcandidato()%>" value="0">
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        <tr>
                            <td colspan="2"><b>EL ACTA ES LEGIBLE?</b></td>
                            <td colspan="2"><input type="checkbox" name="txt_es_legible" id="txt_es_legible" checked/><label for="txt_es_legible">Si el acta no es legible, quite el check.</label></td>
                        </tr>
                        <tr>
                            <td colspan="2"><b>EL ACTA ESTÁ CUADRADA?</b></td>
                            <td colspan="2"><input type="checkbox" name="txt_es_cuadrada" id="txt_es_cuadrada" checked/><label for="txt_es_cuadrada">Si los valores del acta no coinciden, quite el check.</label></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center">
                                <input type="button" id="aceptar" onclick="javascript:history.back(1)" name="regresar" value="Regresar"/></td>
                                <% if (t > 0) {%>
                            <td colspan="2" style="text-align: center">
                                <input type="button" onclick="verifica_acta(<%= t%>,<%= num_cand_elec %>);" id="aceptar" name="Aceptar" value="Aceptar"/>
                            </td>
                            <% }%>
                        </tr>
                    </table>
                </center>
            </div>
        </form>
    </body>
</html>
