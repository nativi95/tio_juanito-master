<%@page import="modelo.ColegiosBean"%>
<%@page import="Dao.RecorridosDao"%>
<%@page import="conexion.Conexion"%>
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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <%@ include file="/Menu_admin.jsp"%>
    <body style="background-color: #424242">


        <div class="container" >



            <div class="col-12" style="background-color: #fff;margin-top: 10px; border-radius: 15px;">

                <div><!--prueba modal-->
                    <!-- Button trigger modal -->
                    <button style="margin-top: 10px; margin-bottom: 10px;" type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModal">
                        Nuevo colegio o escuela
                    </button> <label style="color:red">${msg2}</label>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">


                                    <form method="POST" action="recorridos?action=agregarColegio" enctype="multipart/form-data" >
                                        <h5 class="modal-title" id="exampleModalLabel">Agregar Colegio</h5>
                                        <label style="display: block;">Nombre</label>
                                        <input style="display: block;" name="nombre">

                                        <label style="display: block;">Direción</label>
                                        <input style="display: block;" name="direcion">

                                        <label style="display: block;">foto</label>
                                        <input style="display: block;" type="file" name="fileFoto">


                                        <input type="submit" value="Enviar"/>
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

                        <div style=" margin-bottom: 10px; margin-left: 10px; margin-right: 10px; border-color: #7373FF;" class="col-2" style="border-radius: 15px;">
                            <img style="border-radius: 15px;"  src="img?id=${dato.getId_colegio()}" width="150" height="130">
                        </div>
                        <div class="col-6" style="border-radius: 15px; color:#fff; padding-top: 10px; margin-bottom: 10px; margin-left: 10px; margin-right: 10px; background-color: RGBA(115,115,255,0.47);">
                            <h4><label id="nombre" style="display: block">${dato.getNombre()}</label></h4>
                            <label id="direccion" style="display: block">${dato.getDirecion()}</label>
                        </div>
                        <label hidden="" id="id">${dato.getId_colegio()}</label>


                        <div class="col-3" style="border-radius: 15px; background-color: #ccf2cc; height: 130px;">
                            <a href="recorridos?action=eliminarColegio&id=${dato.getId_colegio()}" style="display: block; margin-top: 15px; color: #fff" class="btn btn-danger">Eliminar </a>
                            <a onclick="ById('${dato.getId_colegio()}', '${dato.getNombre()}', '${dato.getDirecion()}')" style="display: block;margin-top:10px; color: #fff" class="btn btn-info" data-toggle="modal" data-target="#actualizarmodal">Actualizar</a>




                        </div>

                    </div>
                </c:forEach>
                <div class="modal fade" id="actualizarmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">


                                <form method="POST" id="actualizarF" action="recorridos?action=actualizarColegios" enctype="multipart/form-data">  
                                    <h5 class="modal-title" >Actualizar registro de colegio</h5>

                                    <label style="display: block;">Nombre</label>
                                    <input hidden="" id="IdM" name="idU"/>
                                    <input style="display: block;" id="nombreM"  name="nombreU">

                                    <label style="display: block;" >Direción</label>
                                    <input style="display: block;" id="direcionM" name="direcionU">

                                    <label style="display: block;">foto</label>
                                    <input style="display: block; margin-bottom: 10px;" type="file" id="fileFotoM" name="fileFotoU">
                                    <input  id="indicador" hidden="" name="indicador">

                                    <input type="submit" id="Aceptar" value="Enviar"/>
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

                                    function ById(id, nombre, direccion) {
                                        console.log(id);
                                        document.getElementById("IdM").value = id;
                                        document.getElementById("nombreM").value = nombre;
                                        document.getElementById("direcionM").value = direccion;
                                    }
                                    $(document).ready(function () {
                                        $("#Aceptar").on("click", function () {

                                            if ($("#fileFotoM")[0].files.length === 0) {

                                                $("#indicador").val("vacio");
                                                if ($("#indicador").val() === "vacio") {
                                                    $("#actualizarF").submit();
                                                }

                                            } else {
                                                $("#indicador").val("lleno");
                                                if ($("#indicador").val() === "lleno") {
                                                    $("#actualizarF").submit();
                                                }
                                            }
                                            return false;
                                        });
                                    });

        </script>


    </body>



</html>
