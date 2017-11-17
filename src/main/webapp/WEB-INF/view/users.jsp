<%-- 
    Document   : index
    Created on : Oct 14, 2017, 11:49:08 AM
    Author     : keerthi
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List Contact Application </title>
         <s:url var="url_css" value="static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
         <s:url var="url_jqlib" value="/static/js/jquery-3.1.1.min.js"/>
        <script src="${url_jqlib}"></script> 
        <script>
            function changeStatus(uId,lStatus){
               // alert(userId + ", " + loginStatus);
                  $.ajax({
                     url: 'change_status',
                     data:{userId:uId, loginStatus:lStatus} ,
                     success: function(data){
                         alert(data);
                     }
                     
                 })
                
            }
        </script>
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
            <h3>User List</h3>
            <table border="1">
                <tr>
                    <th>SR</th>
                    <th>USER ID</th>
                    <th>NAME</th>
                    <th>PHONE</th>
                    <th>EMAIL</th>
                    <th>ADDRESS</th>
                    <th>USERNAME</th>
                    <th>STATUS</th>
                </tr>
                <c:forEach var="u" items="${userList}" varStatus="st">
                     <tr>
                    <td>${st.count}</td>
                    <td>${u.USERID}</td>
                    <td>${u.MY_NAME}</td>
                    <td>${u.PHONE}</td>
                    <td>${u.EMAIL}</td>
                    <td>${u.ADDRESS}</td>
                    <td>${u.LOGIN_NAME}</td>
                    <td>
                        <select id="id_${u.USERID}" onchange="changeStatus(${u.USERID},$(this).val())">
                            <option value="1">Active</option>
                            <option value="2">Blocked</option>
                        </select>
                            <script>
                                $('#id_${u.USERID}').val(${u.LOGIN_STATUS});
                            </script>
                    </td>
                </tr>
                    
                </c:forEach>
            </table>
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
