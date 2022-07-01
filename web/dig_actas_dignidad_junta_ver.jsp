<%-- 
    Document   : act_recepcion
    Created on : 29/01/2013, 05:21:08 PM
    Author     : root
--%>

<%@page import="admin.Cacta_images"%>
<%@page import="admin.Cacta_imagesDB"%>
<%@page import="eleccion.juntaDB"%>
<%@page import="eleccion.junta"%>
<%@page import="eleccion.acta_detalleDB"%>
<%@page import="eleccion.acta_detalle"%>
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
        <script type="text/javascript">
            function activar_modificar() {
                document.getElementById("aceptar").disabled = false;
            }
        </script>
    </head>
    <body>
        <div id="myModal" class="modal">
            <div id="close" class="close">&times;</div>
            <img class="modal-content" id="img01">
            <div id="caption"></div>
        </div>
        <form name="form1" id="form1" action="calificador">
            <%
                acta AC = new acta();
                actaDB ACdb = new actaDB();
                eleccion.junta JU = new junta();
                eleccion.juntaDB JUDb = new juntaDB();
                acta_detalle ACDet = new acta_detalle();
                acta_detalleDB ACDetdb = new acta_detalleDB();
                int iddignidad = 0, idprovincia = 0, idcanton = 0, idparroquia = 0, idzona = 0, idjunta = 0;
                String dignidad = "", provincia = "", canton = "", parroquia = "", zona = "", junta = "";
                iddignidad = Integer.parseInt(request.getParameter("iddignidad").toString());
                idjunta = Integer.parseInt(request.getParameter("idjunta").toString());
                AC = ACdb.CargarJuntaDignidad(idjunta, iddignidad);
                junta = AC.getJunta_nombre();
                dignidad = AC.getDignidad_nombre();
                idprovincia = AC.getCod_provincia();
                provincia = AC.getProvincia_nombre();
                idcanton = AC.getCod_canton();
                canton = AC.getCanton_nombre();
                idparroquia = AC.getCod_parroquia();
                parroquia = AC.getParroquia_nombre();
                idzona = AC.getCod_zona();
                zona = AC.getZona_nombre();
                JU = JUDb.CargarJuntaxId(idjunta);

                //Cargo las actas
                Cacta_imagesDB acImDB = new Cacta_imagesDB();
                ArrayList<Cacta_images> lista_imagenes = (ArrayList<Cacta_images>) session.getAttribute("lista_acta_images");
                lista_imagenes = acImDB.Cargar_Activas(idjunta, iddignidad);

            %>

            <div class="container">
                <div class="clearfix text-center">
                    <input type="hidden" name="idusuario" value="<%= session.getAttribute("idusuario").toString()%>">
                    <h2>ACTA DE ESCRUTINIO</h2>    
                    <h2><%= dignidad%></h2> 
                    <label class="alert-warning"><b>ESTA ACTA HA SIDO INGRESADA EXITOSAMENTE!</b></label>
                </div>
            </div>

            <div class="container">
                <div class="form-group row">
                    <label for="acta_no" class="col-sm-2 col-form-label">ACTA Nº:</label>
                    <div class="col-sm-10">
                        <input id="acta_no" class="form-control" type="text" name="txt_id_acta" readonly="true" value="<%= AC.getIdacta()%>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_provincia" class="col-sm-2 col-form-label">PROVINCIA: </label>
                    <div class="col-sm-10">
                        <input type="hidden" name="iddignidad" value="<%= iddignidad%>">
                        <input type="hidden" name="dignidad" value="<%= dignidad%>">
                        <input type="hidden" name="idprovincia" value="<%= idprovincia%>">
                        <input type="hidden" name="provincia" value="<%= provincia%>">
                        <input type="hidden" name="idcanton" value="<%= idcanton%>">
                        <input type="hidden" name="canton" value="<%= canton%>">
                        <input type="hidden" name="idparroquia" value="<%= idparroquia%>">
                        <input type="hidden" name="parroquia" value="<%= parroquia%>">
                        <input type="hidden" name="idzona" value="<%= idzona%>">
                        <input type="hidden" name="zona" value="<%= zona%>">
                        <input type="hidden" name="idjunta" value="<%= idjunta%>">
                        <input type="hidden" name="junta" value="<%= junta%>">
                        <input type="hidden" name="idacta" value="<%= AC.getIdacta()%>">
                        <input type="text" id="txt_provincia" class="form-control" name="txt_provincia" readonly="true" value="<%= provincia%>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_canton" class="col-sm-2 col-form-label">CANTÓN:</label>
                    <div class="col-sm-10">
                        <input type="hidden" id="txt_circunsc" class="form-control" name="txt_circunsc" readonly="true" value="">
                        <input type="text" id="txt_canton" class="form-control" name="txt_canton" readonly="true" value="<%= canton%>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_parroquia" class="col-sm-2 col-form-label">PARROQUIA:</label>
                    <div class="col-sm-10">
                        <input type="text" id="txt_parroquia" class="form-control" name="txt_parroquia" readonly="true" value="<%= parroquia%>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_zona" class="col-sm-2 col-form-label">ZONA:</label>
                    <div class="col-sm-10">
                        <input type="text" id="txt_zona" class="form-control" name="txt_zona" readonly="true" value="<%= zona%>">
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
                        <input type="text" class="form-control" id="txt_junta" name="txt_junta" readonly="true" value="<%= junta%>">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="txt_cne_cod_acta" class="col-sm-2 col-form-label">CODIGO CNE DE ACTA:</label>
                    <div class="col-sm-10">
                        <input type="number" autocomplete="off" class="form-control" id="txt_cne_cod_acta" name="txt_cne_cod_acta" value="<%= AC.getCne_cod_acta()%>" placeholder="NO OBLIGATORIO">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="txt_total_votos" class="col-sm-2 col-form-label">TOTAL FIRMAS Y HUELLAS (Número):</label>
                    <div class="col-sm-10">
                        <input type="number" min="0" autocomplete="off" class="form-control" max="350" name="txt_total_votos" id="txt_total_votos" value="<%= AC.getNum_validos()%>" onchange="activar_modificar()" placeholder="INGRESE UN NÚMERO">

                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_votos_blanco" class="col-sm-2 col-form-label">VOTOS EN BLANCO (Número):</label>
                    <div class="col-sm-10">
                        <input type="number" min="0" autocomplete="off" class="form-control" max="350" name="txt_votos_blanco" id="txt_votos_blanco" value="<%= AC.getNum_blancos()%>" onchange="activar_modificar()" placeholder="INGRESE UN NÚMERO">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txt_votos_nulos" class="col-sm-2 col-form-label">VOTOS NULOS (Número):</label>
                    <div class="col-sm-10">
                        <input type="hidden" name="txt_no_votaron" id="txt_no_votaron" value="0"/>
                        <input type="number" min="0" max="350" autocomplete="off" class="form-control" name="txt_votos_nulos" id="txt_votos_nulos" value="<%= AC.getNum_nulos()%>" onchange="activar_modificar()" placeholder="INGRESE UN NÚMERO">
                    </div>
                </div>
                <div class="container text-center">
                    <h1>VOTOS</h1>
                </div>
            </div>
            <div class="container">
                <%
                    ArrayList<acta_detalle> lista = null;
                    //Estado 1 Pendientes
                    lista = ACDetdb.CargarActasDetalleIdActa(AC.getIdacta());

                    //Busco el factor num_canidato en lista
                    int num_cand_elec = 0;
                    breakLoop:
                    for (acta_detalle p : lista) {
                        for (acta_detalle q : lista) {
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
                    for (acta_detalle p : lista) {
                        t++;
                %>
                <div class="project">
                    <div class="row bg-white has-shadow">
                        <div class="col-lg-12 d-flex align-items-center justify-content-between">
                            <div class="project-title d-flex align-items-center">
                                <div class="image has-shadow"><img src="images/logos/<%= p.getFr_id_organizacion()%>.jpg" alt="..." class="img-fluid"></div>
                                <div class="text">
                                    <h3 class="h4"><%= p.getCandidato_nombre()%></h3><small><%= p.getOrganizacion_nombre()%></small>
                                </div>
                            </div>
                            <div class="project-date">
                                <input class="form-control" autocomplete="off" type="number" min="0" max="350" id="<%= t%>" name="<%= p.getFr_id_candidato()%>" value="<%= p.getNum_votos()%>" onchange="activar_modificar()">
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
                    <input type="checkbox" class="form-check-input" name="txt_es_legible" id="txt_es_legible" <% if (AC.isLegible()) { %> checked<% }%>/>
                    <label class="form-check-label" for="txt_es_legible">Si el acta no es legible, quite el check.</label>
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" name="txt_es_cuadrada" id="txt_es_cuadrada" <% if (AC.isCuadrada()) { %> checked<% }%>/>
                    <label class="form-check-label" for="txt_es_cuadrada">Si los valores del acta no coinciden, quite el check.</label>
                </div>

                <% if (request.getParameter("ver") != null) {
                        if (!request.getParameter("ver").equals("ver")) {%>
                <div class="form-group row text-center">
                    <div class="col-sm-10">
                        <input type="button" onclick="verifica_acta(<%= t%>,<%= num_cand_elec%>);" id="aceptar" name="Aceptar" value="Modificar Acta" disabled/>
                        <input type="button" id="regresar" onclick="javascript:history.back(1)" name="regresar" value="Regresar"/></td>
                    </div>
                </div>
                <% }
                } else {%>
                <div class="form-group row text-center">
                    <div class="col-sm-10">
                        <input type="button" onclick="verifica_acta(<%= t%>,<%= num_cand_elec%>);" id="aceptar" name="Aceptar" value="Modificar Acta" disabled/>
                        <input type="button" id="aceptar" onclick="window.location = 'dig_actas_dignidad.jsp'" name="regresar" value="Regresar"/></td>
                    </div>
                </div>
                <% }%>
                <div class="form-group row text-center">
                    <div class="col-sm-10">
                        ESTA ACTA FUE DIGITADA POR:
                        <b><%= AC.getUsuario_nombre() %></b>
                    </div>
                </div>
            </div>
        </form>
        <div class="container">
            <h1>Cargar imagen del acta</h1>
            <form method="POST" enctype="multipart/form-data" action="<%= request.getContextPath()%>/UploadFile">
                <% session.setAttribute("id_junta_subir", idjunta);
                    session.setAttribute("id_dignidad_subir", iddignidad);
                    session.setAttribute("subir_desde", "ver");%>
                Elija la imagen y luego de clic en <b>Cargar</b>. <input required type="file" name="fichero" style="cursor:pointer;" accept="image/jpeg">
                <input class="btn bg-green text-center" type="submit" value="Cargar">
            </form>
        </div>
        <div class="container text-center" >
            <a href="dig_actas_dignidad_junta_ver.jsp?iddignidad=<%= iddignidad%>&idjunta=<%= idjunta%>"><img style="width: 90px;margin-bottom: 5%;" src="images/refresh.png"></a>
        </div>
        <% for (Cacta_images image : lista_imagenes) {%>            
        <div class="centrar_imagen">
            <div class="eliminar_imagen">
                <a href="admin/acta_images_actualizar_resultado.jsp?txt_idacta_images=<%= image.getidacta_images()%>&iddignidad=<%= iddignidad%>&idjunta=<%= idjunta%>"><img style="width: 20%;" src="images/delete.png"></a>
            </div>
            <div class="la_imagen">
                <img class="myImg" id="img_<%= image.getidacta_images()%>" onclick="show_modal('img_<%= image.getidacta_images()%>')" src="images/actas/<%= image.getidacta_images()%>.jpg" alt="Acta">
            </div>
        </div>
        <% }%>
    </body>
</html>
