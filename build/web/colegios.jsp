<%-- 
    Document   : distritos
    Created on : 12-04-2019, 02:35:40 PM
    Author     : juan.ruizusam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <%@ include file="/Menu_offline.jsp"%>
    <body style="background-color: #424242">


        <div class="container" >

            <div class="col-12" style="background-color: #fff; border-radius: 15px;">
                <c:forEach var="dato" items="${lista}">
                    <div style="padding-top: 10px; padding-bottom: 10px; padding-left: 10px;border-radius: 15px; " class="row">

                        <div class="col-2" style="border-radius: 15px; ">
                            <img src="img?id=${dato.getId_colegio()}" width="150" height="130">
                        </div>
                        <div class="col-8" style="border-radius: 15px; color:#fff; padding-top: 10px; margin-bottom: 10px; margin-left: 10px; margin-right: 10px; background-color: RGBA(115,115,255,0.47); ">
                            <h4><label style="display: block">${dato.getNombre()}</label></h4>
                            <label style="display: block">${dato.getDirecion()}</label>
                        </div>
                    </div>
                </c:forEach>
            </div>


            <br>
        </div>

        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/scripts.js" type="text/javascript"></script>
    </body>
</html>
