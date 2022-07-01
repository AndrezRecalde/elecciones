<%-- 
    Document   : act_recepcion
    Created on : 29/01/2013, 05:21:08 PM
    Author     : root
--%>

<%@page import="admin.Cacta_images"%>
<%@page import="admin.Cacta_imagesDB"%>
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

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <script type="text/javascript" src="script/numeros3.js"></script>
        <link rel="stylesheet" href="styles/basic.css">
        <link rel="stylesheet" href="styles/listado.css">

        <link rel="stylesheet" href="styles/modal_acta.css">
        <script type="text/javascript" src="script/modal.js"></script>

    </head>
    <body>

        <div id="myModal" class="modal">
            <span class="close">&times;</span>
            <img style="transform: rotate(90deg);" class="modal-content" id="img01">
            <div id="caption"></div>
        </div>
        <form name="form1" id="form1" action="calificador">
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
                //Cargo las actas
                Cacta_imagesDB acImDB = new Cacta_imagesDB();
                ArrayList<Cacta_images> lista_imagenes = (ArrayList<Cacta_images>) session.getAttribute("lista_acta_images");
                lista_imagenes = acImDB.Cargar_Activas(idjunta, iddignidad);
                /*
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
                }*/
            %>
            <div class="container">
                <div class="clearfix text-center">
                    <input type="hidden" name="idusuario" value="<%= session.getAttribute("idusuario").toString()%>">
                    <h2>ACTA DE ESCRUTINIO</h2>    
                    <h2><%= request.getParameter("dignidad")%></h2> 
                </div>
            </div>

            <div class="container">
                <div class="form-group row">
                    <label for="acta_no" class="col-sm-2 col-form-label">ACTA Nº:</label>
                    <div class="col-sm-10">
                        <input id="acta_no" class="form-control" type="text" name="txt_id_acta" readonly="true" value="(AUTO)">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_provincia" class="col-sm-2 col-form-label">PROVINCIA: </label>
                    <div class="col-sm-10">
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
                        <input type="text" class="form-control" id="txt_provincia" name="txt_provincia" readonly="true" value="<%= request.getParameter("provincia")%>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_canton" class="col-sm-2 col-form-label">CANTÓN:</label>
                    <div class="col-sm-10">
                        <input type="hidden" id="txt_circunsc" class="form-control" name="txt_circunsc" readonly="true" value="">
                        <input type="text" id="txt_canton" class="form-control" name="txt_canton" readonly="true" value="<%= request.getParameter("canton")%>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_parroquia" class="col-sm-2 col-form-label">PARROQUIA:</label>
                    <div class="col-sm-10">
                        <input type="text" id="txt_parroquia" class="form-control" name="txt_parroquia" readonly="true" value="<%= request.getParameter("parroquia")%>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_zona" class="col-sm-2 col-form-label">ZONA:</label>
                    <div class="col-sm-10">
                        <input type="text" id="txt_zona" class="form-control" name="txt_zona" readonly="true" value="<%= request.getParameter("zona")%>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_recinto" class="col-sm-2 col-form-label">RECINTO:</label>
                    <div class="col-sm-10">
                        <input type="text" id="txt_recinto" class="form-control" name="txt_recinto" readonly="true" value="<%= JU.getRecinto_nombre()%>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_junta" class="col-sm-2 col-form-label">JUNTA:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="txt_junta" name="txt_junta" readonly="true" value="<%= request.getParameter("junta")%>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_cne_cod_acta" class="col-sm-2 col-form-label">CODIGO CNE DE ACTA:</label>
                    <div class="col-sm-10">
                        <input autofocus type="number" autocomplete="off" class="form-control" placeholder="NO OBLIGATORIO" id="txt_cne_cod_acta" name="txt_cne_cod_acta" value="">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_total_votos" class="col-sm-2 col-form-label">TOTAL FIRMAS Y HUELLAS (Número):</label>
                    <div class="col-sm-10">
                        <input type="number" autocomplete="off" min="0" class="form-control" placeholder="INGRESE UN NÚMERO" max="350" name="txt_total_votos" id="txt_total_votos" value="">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_votos_blanco" class="col-sm-2 col-form-label">VOTOS EN BLANCO (Número):</label>
                    <div class="col-sm-10">
                        <input type="number" autocomplete="off" min="0" class="form-control" placeholder="INGRESE UN NÚMERO" max="350" name="txt_votos_blanco" id="txt_votos_blanco" value="">

                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_votos_nulos" class="col-sm-2 col-form-label">VOTOS NULOS (Número):</label>
                    <div class="col-sm-10">
                        <input type="hidden" name="txt_no_votaron" id="txt_no_votaron" value="0"/>
                        <input type="number" autocomplete="off" min="0" max="350" class="form-control" placeholder="INGRESE UN NÚMERO" name="txt_votos_nulos" id="txt_votos_nulos" value="">
                    </div>
                </div>
                <div class="container text-center">
                    <h1>VOTOS</h1>
                </div>
            </div>
            <div class="container">
                <%
                    ArrayList<candidato> lista = null;
                    //Estado 1 Pendientes
                    if (iddignidad == 1) { //Presidente - Nacional
                        lista = CANDdb.CargarxDignidadProvincial(iddignidad, idprovincia);
                    }
                    if (iddignidad == 2) { //Asambleista Provincial
                        /*cantonesDB cantDD = new cantonesDB();
                        lista = CANDdb.CargarxDignidadCantonal(iddignidad, cantDD.CargarIdCantonPadre(idcanton));*/
                        lista = CANDdb.CargarxDignidadProvincial(iddignidad, idprovincia);
                    }
                    if (iddignidad == 3) { //Concejales Urbanos
                        //lista = CANDdb.CargarxDignidadCantonal(iddignidad, idcanton);
                        lista = CANDdb.CargarxDignidadProvincial(iddignidad, idprovincia);
                    }
                    if (iddignidad == 4) { //Concejales Rurales
                        //lista = CANDdb.CargarxDignidadCantonal(iddignidad, idcanton);
                        lista = CANDdb.CargarxDignidadProvincial(iddignidad, idprovincia);
                    }/*
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
                    }*/

                    //Busco el factor num_canidato en lista
                    int num_cand_elec = 0;
                    breakLoop:
                    for (candidato p : lista) {
                        for (candidato q : lista) {
                            if (p.getFr_id_organizacion() == q.getFr_id_organizacion()) {
                                num_cand_elec++;
                            } else {
                                break breakLoop;
                            }
                        }
                        break breakLoop;
                    }

                    //Excepción por CPCS numero de candidatos por lista
                    if (iddignidad == 6 || iddignidad == 7 || iddignidad == 8) {
                        num_cand_elec = 1;
                    }

                    int t = 0;
                    for (candidato p : lista) {
                        t++;
                %>
                <div class="project">
                    <div class="row bg-white has-shadow">
                        <div class="col-lg-12 d-flex align-items-center justify-content-between">
                            <div class="project-title d-flex align-items-center">
                                <div class="image has-shadow"><img src="images/logos/<%= p.getFr_id_organizacion()%>.jpg" alt="..." class="img-fluid"></div>
                                <div class="text">
                                    <h3 class="h4"><%= p.getNombre()%></h3><small><%= p.getOrganizacion_nombre()%></small>
                                </div>
                            </div>
                            <div class="project-date">
                                <input class="form-control" autocomplete="off" type="number" min="0" max="350" id="<%= t%>" name="<%= p.getIdcandidato()%>" value="">
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
            <div class="container">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" name="txt_es_legible" id="txt_es_legible" checked/>
                    <label class="form-check-label" for="txt_es_legible">Si el acta no es legible, quite el check.</label>
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" name="txt_es_cuadrada" id="txt_es_cuadrada" checked/>
                    <label class="form-check-label" for="txt_es_cuadrada">Si los valores del acta no coinciden, quite el check.</label>
                </div>
                <div class="form-group row text-center">
                    <div class="col-sm-10">
                        <% if (t > 0) {%>
                        <input type="button" onclick="verifica_acta(<%= t%>,<%= num_cand_elec%>);" id="aceptar" name="Aceptar" value="Ingresar Acta"/>
                        <% }%>
                        <input type="button" id="regresar" onclick="javascript:history.back(1)" name="regresar" value="Regresar"/></td>
                    </div>
                </div>
            </div>
        </form>
        <% for (Cacta_images image : lista_imagenes) {%>            
        <div class="centrar_imagen">
            <div class="la_imagen">
                <img class="myImg" id="img_<%= image.getidacta_images()%>" onclick="show_modal('img_<%= image.getidacta_images()%>')" src="images/actas/<%= image.getidacta_images()%>.jpg" alt="Acta">
            </div>
            <div class="eliminar_imagen">
                <a href="admin/acta_images_actualizar_resultado.jsp?txt_idacta_images=<%= image.getidacta_images()%>&iddignidad=<%= iddignidad%>&idjunta=<%= idjunta%>"><img style="width: 20%;" src="images/delete.png"></a>
            </div>
        </div>
        <% }%>

        <div class="container">
            <h1>Cargar imagen del acta</h1>
            <form method="POST" enctype="multipart/form-data" action="<%= request.getContextPath()%>/UploadFile">
                <% session.setAttribute("id_junta_subir", idjunta);
                    session.setAttribute("id_dignidad_subir", iddignidad);
                    session.setAttribute("subir_desde", "digitar");%>
                Elija la imagen y luego de clic en <b>Cargar</b>. <input required type="file" name="fichero" style="cursor:pointer;" accept="image/jpeg">
                <input class="btn bg-green text-center" type="submit" value="Cargar">
            </form>
        </div>
    </body>
</html>
