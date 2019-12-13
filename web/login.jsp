<%-- 
    Document   : login
    Created on : 11-29-2019, 04:07:18 PM
    Author     : juan.ruizusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/style_1.css" rel="stylesheet">
    </head>
   
    <body style="background-color: #424242">
       <%@ include file="/Menu_offline.jsp"%>
        <br>
        <br>
        <div class="container" >
            
            <div class="row">
                <div class="col-md-8" style="background-color: #dbeddc; border-radius: 15px;">
                    <br>

                </div>
                <div class="col-md-4" style="background-color:#dbeddc; border-radius: 15px;">
                    <br>
                    <form method="POST" action="login?action=login" role="form">
                        <div class="form-group">

                            <label for="exampleInputEmail1">
                                Usuario o correo electrónico
                            </label>
                            <input name="registro" class="form-control" id="exampleInputEmail1">
                        </div>
                        <div class="form-group">

                            <label for="exampleInputPassword1">
                                Clave
                            </label>
                            <input type="password" name="clave" class="form-control" id="exampleInputPassword1">
                        </div>


                        <button type="submit" class="btn btn-success">
                            Iniciar sesión
                        </button>
                    </form>
                    <b> ${msg}</b>
                    <br>
                </div>
            </div>
        </div>

        <script src=".../js/jquery.min.js"></script>
        <script src=".../js/bootstrap.min.js"></script>
        <script src=".../js/scripts.js"></script>
    </body>
</html>
