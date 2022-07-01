/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import admin.CaccesosDB;
import admin.Ccantones;
import admin.CcantonesDB;
import admin.Cusuario;
import admin.CusuarioDB;
import eleccion.acta;
import eleccion.actaDB;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
public class responsables_juntas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            HttpSession session = request.getSession(true);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            session.setAttribute("fecha_reporte", sdf.format(new Date()));

            CusuarioDB usuDB = new CusuarioDB();
            Cusuario usu_edi = new Cusuario();
            int id_usuario_session = Integer.parseInt(session.getAttribute("idusuario").toString());
            usu_edi = usuDB.Seleccionar_Id(id_usuario_session);

            CaccesosDB CAU = new CaccesosDB();
            CAU.Ingresar(id_usuario_session, 3);

            actaDB actaDB = new actaDB();
            ArrayList<acta> listaActas = new ArrayList<acta>();
            if (request.getParameter("ver") != null) {
                int idprovincia = 0, idcanton = 0, idparroquia = 0, idzona = 0, idjunta = 0;
                String dignidad = "", provincia = "", canton = "", parroquia = "", zona = "", junta = "";
                boolean error = false;
                String errorString = "";
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
                    if (usu_edi.getes_cantonal()) {
                        CcantonesDB canDB = new CcantonesDB();
                        Ccantones can = new Ccantones();
                        can = canDB.Seleccionar_Id(idcanton);
                        if (usu_edi.getFr_id_canton_padre() != can.getfr_id_canton_pertenece()) {
                            error = true;
                            errorString = "Por favor seleeciona datos del cantón al que has sido asignado.";
                        }
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
                if (request.getParameter("idzona") != null) {
                    idzona = Integer.parseInt(request.getParameter("idzona").toString());
                    if (idzona == -1) {
                        error = true;
                        errorString = "Por favor seleecione una Zona";
                    }
                    ArrayList lista = null;
                    if (session.getAttribute("zonas") != null) {
                        lista = (ArrayList) session.getAttribute("zonas");
                    }
                    if (lista.size() != 0) {
                        for (int x = 0; x < lista.size(); x = x + 3) {
                            if (lista.get(x).toString().equals(request.getParameter("idzona").toString())) {
                                zona = lista.get(x + 1).toString();
                            }
                        }
                    }
                }

                if (!error) {
                    //Estado 1 Pendientes
                    if (request.getParameter("ver").toString().contains("Junta")) {
                        if (request.getParameter("idjunta") != null) {
                            idjunta = Integer.parseInt(request.getParameter("idjunta").toString());
                            if (idjunta == -1) {
                                error = true;
                                errorString = "Por favor seleecione una Junta";
                            } else {
                                listaActas = actaDB.CargarActasJunta(idjunta);
                                session.setAttribute("lista_resp_juntas", listaActas);
                            }
                            ArrayList lista = null;
                            if (session.getAttribute("juntas") != null) {
                                lista = (ArrayList) session.getAttribute("juntas");
                            }
                            if (lista.size() != 0) {
                                for (int x = 0; x < lista.size(); x = x + 3) {
                                    if (lista.get(x).toString().equals(request.getParameter("idjunta").toString())) {
                                        junta = lista.get(x + 1).toString();
                                    }
                                }
                            }
                        }

                    }
                    if (request.getParameter("ver").toString().contains("Zona")) {
                        listaActas = actaDB.CargarActasJuntaZona(idzona);
                        session.setAttribute("lista_resp_juntas", listaActas);
                        
                    }
                } else {
                    out.print("Error.");
                }
                response.sendRedirect("jun_responsable.jsp");
            }
            out.close();
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
