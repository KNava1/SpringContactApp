<%-- 
    Document   : test
    Created on : Nov 14, 2017, 3:09:26 PM
    Author     : keerthi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:url var="url_jqlib" value="/static/js/jquery-3.1.1.min.js"/>
        <script src="${url_jqlib}"></script> 
        <script>
            $(document).ready(function(){
               // alert("NAAAA");
               $("#id_get_time").click(function(){
                 //  alert("nammmak");
                 $.ajax({
                     url: 'get_time',
                     success: function(data){
                         $("#id_time").html(data);
                     }
                     
                 })
               });
            });
        </script> 
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ajax Test Page</h1>
        <button id="id_get_time">Get Server TIme</button> <br/>
        <p id="id_time"></p>
    </body>
</html>
