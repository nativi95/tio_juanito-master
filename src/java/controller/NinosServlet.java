/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
            case "mostrarNino":
                mostrarNino(request, response);
                break;
        }
    }

    protected void mostrarNino(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    protected void eliminarNino(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void actualizarNino(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        NinosDao ninod = new NinosDao(conn);
        String usuario=request.getParameter("apoderado");
        UsuarioBean usuariob= new UsuarioBean();
        usuariob.setUsuario(usuario);
        LoginDao login=new LoginDao(conn);
        ApoderadosBean apoderado=new ApoderadosBean();
        apoderado.setId_usuario(login.consultarId_Usuario(usuariob).getId_usuario());
        
        List<NinosBean> lista=ninod.mostrarNinos(apoderado)
    }

    protected void inserNino(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        NinosDao ninod = new NinosDao(conn);
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        boolean disponibilidad = Boolean.parseBoolean(request.getParameter("disponibilidad"));
        int id_apoderado = Integer.parseInt(request.getParameter("id_apoderado"));

        NinosBean ninob = new NinosBean(0);
        ninob.setApellido(apellido);
        ninob.setNombre(nombre);
        ninob.setDirecion(direccion);
        ninob.setDisponibilidad(disponibilidad);
        ApoderadosBean apoderado = new ApoderadosBean(id_apoderado);
        ninob.setId_apoderado(apoderado);
        if (ninod.insertarNino(ninob)) {

            request.getRequestDispatcher("hijos.jsp").forward(request, response);

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
