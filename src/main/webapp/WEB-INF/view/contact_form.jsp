<%-- 
    Document   : index
    Created on : Oct 14, 2017, 11:49:08 AM
    Author     : keerthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Form- Contact Application </title>
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
            <h3>Contact Form</h3>
            <c:if test="${err!=null}">
                <p class="error">${err}</p>
            </c:if>
            <c:if test="${param.act eq 'lo'}">
                <p class="success">Logout Successfully</p>
            </c:if>    
            <s:url var="url_csave" value="/user/save_contact" />
            <f:form action="${url_csave}" modelAttribute="command">
                <table border="1">
                     <tr>
                        <td>Name</td>
                        <td><f:input path="NAME"/></td>
                    </tr>
                     <tr>
                        <td>Phone</td>
                        <td><f:input path="PHONE"/></td>
                    </tr>
                     <tr>
                        <td>Email</td>
                        <td><f:input path="EMAIL"/></td>
                    </tr>
                     <tr>
                        <td>Address</td>
                        <td><f:textarea path="ADDRESS"/></td>
                    </tr>
                    <tr>
                        <td>Remark</td>
                        <td><f:textarea path="REMARK"/></td>
                    </tr>
                    
                      <tr>
                          <td colspan="2" align="right">
                              <button>Save</button>
                      </td>
                    </tr>
                    
                </table>
                
            </f:form>
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
