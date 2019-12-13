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
    </head>
    <%@ include file="/Menu_offline.jsp"%>
    <body style="background-color: #424242">


        <div class="container" >

            <div class="col-12" style="background-color: #fff; border-radius: 15px;">
                <div style="padding-top: 10px; padding-bottom: 10px; padding-left: 10px; " class="row">

                    <iframe src="https://www.google.com/maps/d/embed?mid=1UH7JDIKCGj8HUBValWChyJdlJl0" class="col-8" style="border-radius: 15px;" height="480"></iframe>


                    <div class="col-4" style="display: table; height:450px;">
                        <div style="padding-left: 15px; display: table-cell; vertical-align: middle; background-color: #efef7b; border-radius: 15px;">
                            <b><h3>Distritos disponibles de Santa Tecla</h3></b>
                            <c:forEach items="${lista}" var="d">
                                <label style="display: block;">${d.nombre}</label>
                            </c:forEach>
                            Consulta en el mapa tu distrito
                        </div>
                    </div>
                </div>
            </div>


            <br>
        </div>


    </body>
</html>
