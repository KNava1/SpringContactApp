<%-- 
    Document   : index
    Created on : Oct 14, 2017, 11:49:08 AM
    Author     : keerthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User-Dashboard Contact Application </title>
         <s:url var="url_css" value="static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
    </head>
    <s:url var="url_bg" value="/static/images/bgone.jpg"/>
    <body background="${url_bg}">
        <table border="1" width="80%" align="center">
            <tr>
                <td height="80px">
                    <jsp:include page="include/header.jsp"/>
            </td> 
            </tr>
            <tr>
                <td height="25px">
                <jsp:include page="include/menu.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="350px" valign="top" >
            <h1>User Dashboard </h1>
                </td>
            </tr>
            <tr>
                
                <td height="25px">
                <jsp:include page="include/footer.jsp"/>    
                </td> 
                    
            </tr> 
            
            
        </table>
    </body>
</html>
