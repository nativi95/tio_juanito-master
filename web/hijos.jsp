<%-- 
    Document   : hijos
    Created on : 12-05-2019, 11:17:58 AM
    Author     : juan.ruizusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    String usuario;
    String Correo;

    if (sesion.getAttribute("usuario") != null) {

        if (sesion.getAttribute("rol").toString().equals("cliente")) {
            usuario = sesion.getAttribute("usuario").toString();
        } else {
            response.sendRedirect("admin.jsp");
        }
    } else {
        if (sesion.getAttribute("Correo") != null) {

            if (sesion.getAttribute("rol").toString().equals("cliente")) {
                Correo = sesion.getAttribute("Correo").toString();
            } else {
                response.sendRedirect("admin.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/scripts.js" type="text/javascript"></script>
    </head>
    <%@ include file="/Menu_online.jsp"%>
    <body style="background-color: #424242">


        <div class="container" >



            <div class="col-12" style="background-color: #fff;margin-top: 10px; border-radius: 15px;">

                <div><!--prueba modal-->
                    <!-- Button trigger modal -->
                    <button style="margin-top: 10px; margin-bottom: 10px;" type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModal">
                        Agrega un niño
                    </button> <label style="color:red">${msg2}</label>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">


                                    <form method="POST" action="ninos?action=inserNino&usuario=${usuario}">
                                        <h5 class="modal-title" id="exampleModalLabel">Agrega un menor</h5>
                                        <label style="display: block;">Nombre</label>
                                        <input style="display: block;" name="nombre">
                                        <label style="display: block;">Apellido</label>
                                        <input style="display: block;" name="apellido">
                                        <label>Disponibilidad de recibirlo</label>
                                        <input type="checkbox" style="display: inline" checked = "true" name="disponibilidad">
                                        <label style="display: block; ">Direción</label>
                                        <input style="display: block; margin-bottom: 10px;" name="direccion">
                                        <button>Enviar</button>
                                    </form>
                                    <label style="color:red;">
                                        ${msg}
                                    </label>

                                </div>


                            </div>
                        </div>
                    </div>


                </div>

                <c:forEach var="dato" items="${lista}">
                    <div style=" border: 1px; padding-bottom: 10px; padding-left: 10px;border-radius: 15px; " class="row">


                        <div class="col-5" style="border-radius: 15px; color:#fff; padding-top: 10px; height: 120px; margin-bottom: 10px; margin-left: 10px; margin-right: 10px; background-color: RGBA(115,115,255,0.47);">
                            <h4><label id="nombre" style="display: block">${dato.getNombre()} ${dato.getApellido()}</label></h4>
                            <input readonly="" hidden="" name="id_nino" value="${dato.getId_nino()}">
                            <label id="direccion" style="display: block">${dato.getDirecion()}</label>
                            <label>Disponible para ser recogido:${dato.isDisponibilidad()}</label>
                        </div>
                        <label hidden="" id="id">${dato.getId_nino()}</label>

                        <div class="col-3" style="border-radius: 15px; background-color: #ccf2cc; margin-right: 10px; height: 120px;">
                            <label style="display: block">Hora de salida al colegio</label>
                            ${dato.getSalida()}
                            <label style="display: block">Hora de llegada al domicilio</label>
                            ${dato.getLlegada()}
                        </div>


                        <div class="col-2" style="border-radius: 15px; background-color: #efef7b; height: 120px;">
                            <a href="ninos?action=eliminarNino&id_nino=${dato.getId_nino()}" style="display: block; margin-top: 8px; color: #fff" class="btn btn-danger">Eliminar</a>
                            <a onclick="ById('${dato.getId_nino()}', '${dato.getNombre()}', '${dato.getApellido()}', '${dato.getDirecion()}')" style="display: block;margin-top:8px; color: #fff" class="btn btn-info" data-toggle="modal" data-target="#actualizarmodal">Actualizar</a>




                        </div>

                    </div>
                </c:forEach>
                <div class="modal fade" id="actualizarmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">


                                <form method="POST" id="actualizarF" action="ninos?action=actualizarNino">  
                                    <h5 class="modal-title" >Actualizar registro del menor</h5>

                                    <label style="display: block;">Nombres</label>
                                    <input hidden="" id="IdM" name="id_ninoU"/>
                                    <input style="display: block;" id="nombreM"  name="nombreU">

                                    <label style="display: block;" >Apellidos</label>
                                    <input style="display: block;" id="apellidoM" name="apellidoU">

                                    <label>Disponibilidad de recibirlo</label>
                                    <input type="checkbox" style="display: inline" checked = "true" name="disponibilidadU">

                                    <label style="display: block;" >Direción</label>
                                    <input style="display: block; margin-bottom: 10px;" id="direcionM" name="direccionU">

                                    <button>Enviar</button>


                                </form>
                                ${msg3}
                                <label style="color:red;">

                                </label>

                            </div>
                        </div>


                        <br>
                    </div>
                </div>            
            </div>
        </div>


        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/scripts.js" type="text/javascript"></script>

        <script type="text/javascript">

                                function ById(id, nombre, apellido, direccion) {
                                    console.log(id);
                                    document.getElementById("IdM").value = id;
                                    document.getElementById("nombreM").value = nombre;
                                    document.getElementById("apellidoM").value = apellido;
                                    document.getElementById("direcionM").value = direccion;
                                }


        </script>


    </body>



</html>
