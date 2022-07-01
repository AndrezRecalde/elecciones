<%-- 
    Document   : principal
    Created on : 22/01/2013, 02:27:41 PM
    Author     : userver1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK REL="SHORTCUT ICON" HREF="images/icono.png">
        
        <title>Control Electoral</title>
        <SCRIPT LANGUAGE=javascript>
<!--
            function reSize()
            {
                try {
                    var oBody = ifrm.document.body;
                    var oFrame = document.all("frm");

                    oFrame.style.height = oBody.scrollHeight + (oBody.offsetHeight - oBody.clientHeight);
                    oFrame.style.width = oBody.scrollWidth + (oBody.offsetWidth - oBody.clientWidth);
                }
                //An error is raised if the IFrame domain != its container's domain
                catch (e)
                {
                    window.status = 'Error: ' + e.number + '; ' + e.description;
                }
            }
//-->
        </SCRIPT>
    </head>
    <FRAMESET rows="120px,*,30px" border="0" frameborder="0" framespacing="0">
        <FRAME name="header" src="header.jsp" scrolling = "auto" marginheight="0" noresize >
            <FRAMESET cols="160px,*" border="0" frameborder="0" framespacing="0">
                <FRAME name="menu" id="frm" src="menu.jsp" scrolling = "auto" marginheight="0" noresize />
                <FRAME name="dynamic" src="welcome.jsp" scrolling = "auto" marginheight="0" noresize />
            </frameset>
            <FRAME name="foot" src="footer.jsp" scrolling = "no" marginheight="0" noresize />
    </FRAMESET>
</html>
