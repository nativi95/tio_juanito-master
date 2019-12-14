/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ApoderadosDao;
import Dao.LoginDao;
import Dao.NinosDao;
import conexion.Conexion;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ApoderadosBean;
import modelo.NinosBean;
import modelo.UsuarioBean;

/**
 *
 * @author juana
 */
public class NinosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "inserNino":
                inserNino(request, response);
                break;
            case "actualizarNino":

                actualizarNino(request, response);
                break;
            case "eliminarNino":
                eliminarNino(request, response);
                break;
            case "mostrarNinos":
                mostrarNino(request, response);
                break;
        }
    }

    protected void mostrarNino(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        NinosDao ninod = new NinosDao(conn);
        String usuario = request.getParameter("usuario");
        UsuarioBean usuariob = new UsuarioBean();
        usuariob.setUsuario(usuario);
        LoginDao login = new LoginDao(conn);
        ApoderadosBean apoderado = new ApoderadosBean();
        apoderado.setId_usuario(login.consultarId_Usuario(usuariob));

        ApoderadosDao apoderadod = new ApoderadosDao(conn);
        apoderado = apoderadod.mostrarApoderadoById_usuario(usuariob);

        List<NinosBean> lista = ninod.mostrarNinos(apoderado);
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("hijos.jsp").forward(request, response);

    }

    protected void eliminarNino(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        NinosDao ninod = new NinosDao(conn);

        String usuario = request.getParameter("usuario");
        int id = Integer.parseInt(request.getParameter("id_nino"));
        NinosBean ninob = new NinosBean(id);

        if (ninod.eliminarNino(ninob)) {

            mostrarNino(request, response);

        } else {
            System.out.println(""+ninod.eliminarNino(ninob));
            String msg = "Formulario no enviado";

            request.setAttribute("msg", msg);
            request.getRequestDispatcher("hijos.jsp").forward(request, response);
        }

    }

    protected void actualizarNino(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        NinosDao ninod = new NinosDao(conn);
        int id_nino = Integer.parseInt(request.getParameter("id_ninoU"));
        String nombre = request.getParameter("nombreU");
        String apellido = request.getParameter("apellidoU");
        String direccion = request.getParameter("direccionU");
        String usuario = request.getParameter("usuario");
        NinosBean ninob = new NinosBean(id_nino);
        ninob.setApellido(apellido);
        ninob.setNombre(nombre);
        ninob.setDirecion(direccion);

        if (request.getParameter("disponibilidadU") != null) {
            ninob.setDisponibilidad(true);
        } else {
            ninob.setDisponibilidad(false);
        }

        if (ninod.actualizarNino(ninob)) {

            request.getRequestDispatcher("ninos?action=mostrarNinos&usuario=" + usuario).forward(request, response);

        } else {
            String msg = "Formulario no enviado";

            request.setAttribute("msg3", msg);
            request.getRequestDispatcher("hijos.jsp").forward(request, response);
        }

    }

    protected void inserNino(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        NinosDao ninod = new NinosDao(conn);
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");

        String usuario = request.getParameter("usuario");
        UsuarioBean usuariob = new UsuarioBean();
        usuariob.setUsuario(usuario);
        LoginDao login = new LoginDao(conn);
        ApoderadosBean apoderado = new ApoderadosBean();
        apoderado.setId_usuario(login.consultarId_Usuario(usuariob));

        NinosBean ninob = new NinosBean(0);
        ninob.setApellido(apellido);
        ninob.setNombre(nombre);
        ninob.setDirecion(direccion);
        if (request.getParameter("disponibilidad") != null) {
            ninob.setDisponibilidad(true);
        } else {
            ninob.setDisponibilidad(false);
        }

        ApoderadosDao apoderadod = new ApoderadosDao(conn);
        apoderado = apoderadod.mostrarApoderadoById_usuario(usuariob);

        ninob.setId_apoderado(apoderado);

        if (ninod.insertarNino(ninob)) {

            mostrarNino(request, response);

        } else {
            String msg = "Formulario no enviado";

            request.setAttribute("msg", msg);
            request.getRequestDispatcher("hijos.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
