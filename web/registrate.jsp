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

            <div class="row" style="background-color: #fff; border-radius: 15px;">
                <b><label style="color: red;"><br>${msg}</label></b>
                <form method="POST" class="col-12"  action="login?action=registrar" role="form">

                    <div class="row">
                        <div class="col-4" style="background-color: #dbeddc; border-radius: 15px;">
                            <br>
                            <h3>Datos de ususario</h3>
                            <br>


                            <label>
                                Ingrese un usuario
                            </label>
                            <input name="usuario" class="form-control" id="exampleInputEmail1">




                            <label for="exampleInputPassword1">
                                Ingrese una clave
                            </label>
                            <input type="password" name="clave" class="form-control" id="clave">




                            <label for="exampleInputPassword1">
                                Confirme la clave
                            </label>
                            <input type="password"  class="form-control" id="confirmacion">

                            <br>


                        </div>

                        <div class="col-4" style="background-color: #dbeddc; border-radius: 15px;">
                            <br>
                            <h3>Datos personales del usuario</h3>
                            
                            <label>
                                Ingresar nombres
                            </label>
                            <input name="nombre" class="form-control" id="nombre">
                            <label>
                                Ingresar apellidos
                            </label>
                            <input name="apellido" class="form-control" id="apellido">
                            <label>
                                Ingresar DUI
                            </label>
                            <input name="dui" class="form-control" id="dui">

                        </div>

                        <div class="col-4" style="background-color:#dbeddc; border-radius: 15px;">
                            <br>
                            <h3>Datos de contacto</h3>
                            <br>


                            <label>
                                Ingrese un correo electrónico
                            </label>
                            <input name="correo" class="form-control" id="exampleInputEmail1">
                            <label>
                                Ingrese un teléfono
                            </label>
                            <input name="telefono" class="form-control" id="telefono">
                            <br>
                            <button type="submit" style="display: block" class="btn btn-success">
                                Regístrate
                            </button>

                        </div>




                    </div>





                </form>

            </div>

            <br>
        </div>

        <script src=".../js/jquery.min.js"></script>
        <script src=".../js/bootstrap.min.js"></script>
        <script src=".../js/scripts.js"></script>
    </body>
</html>
