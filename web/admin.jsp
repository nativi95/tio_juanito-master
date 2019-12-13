<%-- 
    Document   : admin
    Created on : 12-02-2019, 10:56:58 AM
    Author     : juan.ruizusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>


<%
    HttpSession sesion = request.getSession();
    String usuario;
    String Correo;

    if (sesion.getAttribute("usuario") != null) {
        
        if (sesion.getAttribute("rol").toString().equals("admin")) {
            usuario = sesion.getAttribute("usuario").toString();
        } else {
            response.sendRedirect("cliente.jsp");
        }
    } else {
        if (sesion.getAttribute("Correo") != null) {

            if (sesion.getAttribute("rol").toString().equals("admin")) {
                Correo = sesion.getAttribute("Correo").toString();
            } else {
                response.sendRedirect("cliente.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: #424242">

        <%@ include file="Menu_admin.jsp"%>

        <br><br>
        <div class="container" style="background-color: #dbeddc; border-radius: 15px; height: 300px">

            <h1>Lo nuevo</h1>
            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
        </div>

    </body>
</html>
