<%-- 
    Document   : rpt_ruta
    Created on : 10-abr-2012, 13:58:06
    Author     : USUARIO
--%>

<%@page import="admin.CaccesosDB"%>
<%@page import="javax.print.attribute.standard.MediaSizeName"%>
<%@page import="javax.print.attribute.PrintRequestAttributeSet"%>
<%@page import="javax.print.DocFlavor"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="com.lowagie.text.Document"%>
<%@page import="com.lowagie.text.pdf.PdfAction"%>
<%@page import="com.lowagie.text.pdf.PdfWriter"%>
<%@page import="com.lowagie.text.pdf.PdfStamper"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="com.lowagie.text.pdf.PdfReader"%>
<%@page import="java.net.URL"%>
<%@page import="net.sf.jasperreports.engine.util.JRLoader"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="net.sf.jasperreports.engine.JasperPrintManager"%>
<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@page import="net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter"%>
<%@page import="net.sf.jasperreports.engine.export.JExcelApiExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.export.JRXlsExporter"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="net.sf.jasperreports.engine.export.JRXlsExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JRExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="herramientas.conexion"%>
<%@page import="java.sql.Connection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script>
            function imprimir() {
                window.print();
            }
        </script>
    </head>
    <body>
        <%
            if (request.getParameter("tipo") != null) {
                int id_usuario_session = Integer.parseInt(session.getAttribute("idusuario").toString());
                CaccesosDB CAU = new CaccesosDB();
                CAU.Ingresar(id_usuario_session, 11);

                File reportFile = new File(application.getRealPath("reportes/reporte_responsable_juntas.jasper"));
                Connection conn = conexion.getConexion();
                Map parameters = new HashMap();
                parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/"));
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conn);
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();
                ouputStream.close();

            } else {
                response.sendRedirect("error.jsp?men=No se pudo generar el reporte. Contacte con el Administrador");
                return;
            }
        %>
    </body>
</html>
