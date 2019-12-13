<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style >


    .contenedor{
        position: relative;
        display: inline-block;
        text-align: left;
        font-family: 'Calistoga', cursive;
        background-image: url('imagenes/menu3.jpg');
        height: 400px;



    }


    .menu{
        position: absolute;
        top: 20px;
        left:10px;
        background-color: #424242;

        border-radius: 15px; 

        font-size: 1.5rem;
        opacity: 0.80;
        height: 3.5rem;
        width: 80%;
     

    }



</style>





<div class="contenedor col-12" style=" ">
   
    <div class="row">
        <div class="col-8">
            <ul class="nav menu ">
                <li class="nav-item ">
                    <a class="nav-link active" href="Inicio.jsp" style="color: #fff;">Tio Juanito</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: #fff;" href="recorridos?action=barrios">Distritos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: #fff;" href="recorridos?action=mostrarColegios&rol=${0}">Colegios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: #fff;" href="#">Contáctanos</a>
                </li>
            </ul>
        </div>
        <div class="col-4">
            <ul class="nav menu ">
                <li class="nav-item" style="right: 50px">
                    <a class="nav-link" style="color: #fff;" href="login.jsp">Login</a>
                </li>
                <li class="nav-item" style="right: 50px">
                    <a class="nav-link" style="color: #fff;" href="registrate.jsp">Regístrate</a>
                </li>
            </ul>
        </div>
    </div>


</div>



