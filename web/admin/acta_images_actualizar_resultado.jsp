<%-- 
   Document   : index
   Created on : Jul 12, 2014, 11:48:02 AM
   Author     : Generado V1.0
--%>

<%@page import="admin.CObjetoCombo"%>
<%@page import="java.util.ArrayList"%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Control Electoral-Imágenes de Actas</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <script type="text/javascript" src="script/numeros.js"></script>
        <link rel="stylesheet" href="styles/basic.css">
    </head>
    <body>
        <form name="form1" action="admin_controlador.srvlt_acta_images_actualizar">      
            <div class="container">
                <h1 class="titulo_h1">Eliminar Imagen</h1>
                <input type="hidden" name="iddignidad" value="<%= request.getParameter("iddignidad")%>">
                <input type="hidden" name="idjunta" value="<%= request.getParameter("idjunta")%>">

                <input type="hidden" name="txt_idacta_images" required  value="<%= request.getParameter("txt_idacta_images")%>" readonly>
                
                <input type="submit" name="actualizar" value="Eliminar"><br><br><br><br>
                <a href="javascript:history.back(1)">Volver Atrás</a>
            </div>
        </form>
    </body>
</html>