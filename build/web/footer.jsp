<%-- 
    Document   : footer
    Created on : 22/01/2013, 03:05:28 PM
    Author     : userver1
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Footer</title>
        <link href="styles/foot.css" rel="stylesheet" type="text/css" media="screen" />
        
    </head>
    <body>
    
        <% Calendar ca = null;
        ca= Calendar.getInstance();
        %>
        <div id="wrap">
           <b>All rigth reserved <%= ca.get(Calendar.YEAR) %>.<br>
              Info <a href="mailto:dubalquevedo89@gmail.com">dubalquevedo89@gmail.com</a>
           </b>
        </div>
    
    </body>
</html>
