/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.LoginDao;
import conexion.Conexion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ApoderadosBean;
import modelo.UsuarioBean;

/**
 *
 * @author juan.ruizusam
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "login":
                login(request, response);
                break;
            case "registrar":
                registrar(request, response);
                break;
            case "cerrar":
                cerrar(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    HttpSession session;

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String registro = request.getParameter("registro");
        String clave = request.getParameter("clave");

        Conexion conn = new Conexion();
        LoginDao login = new LoginDao(conn);
        UsuarioBean usuario = new UsuarioBean();
        usuario.setUsuario(registro);
        usuario.setCorreo(registro);
        usuario.setClave(clave);

        boolean user = login.consultarUsuario(usuario);

        boolean correo = login.consultarCorreo(usuario);

        if (user) {// valida si se ingresói un usuario
            if (login.consultarClave_usuario(usuario)) {// valida la clave
                
                
                
                
                
                if (login.consultarRol_usuario(usuario).getRol()) {// valida rol admin
                    session = request.getSession();
                    session.setAttribute("usuario", usuario.getUsuario());
                    session.setAttribute("rol", "admin");
                    response.sendRedirect("admin.jsp");


                } else {
                    session = request.getSession();// valida cliente
                    session.setAttribute("usuario", usuario.getUsuario());
                    session.setAttribute("rol", "cliente");
                    response.sendRedirect("cliente.jsp");

                   

                }
            } else {
                String msg = "Clave invalida";// clave invalida

                request.setAttribute("msg", msg);
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        } else {
            if (correo) {// valida si ingresó un correo
                
                registro=login.consultarRol_Correo(usuario).getUsuario();
                request.setAttribute("usuario", registro);
                if (login.consultarClave_correo(usuario)) {//valida la clave
                    if (login.consultarRol_Correo(usuario).getRol()) {//valida rol admin
                        session = request.getSession();
                        session.setAttribute("Correo", usuario.getCorreo());
                        session.setAttribute("usuario", login.consultarRol_Correo(usuario).getUsuario());
                        session.setAttribute("rol", "admin");
                        response.sendRedirect("admin.jsp");

                   

                    } else {
                        session = request.getSession(); //valida rol cliente
                        session.setAttribute("Correo", usuario.getCorreo());
                        session.setAttribute("rol", "cliente");
                        session.setAttribute("usuario", login.consultarRol_Correo(usuario).getUsuario());
                        response.sendRedirect("cliente.jsp");

                        

                    }
                } else {// clave invalida
                    String msg = "Clave invalida";

                    request.setAttribute("msg", msg);
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }

            } else {
                String msg = "no existe usuario o correo";  // no existe usuario

                request.setAttribute("msg", msg);
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }
    }

    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuarior = request.getParameter("usuario");
        String correor = request.getParameter("correo");
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dui = request.getParameter("dui");
        String telefono = request.getParameter("telefono");

        Conexion conn = new Conexion();
        LoginDao login = new LoginDao(conn);
        UsuarioBean usuario = new UsuarioBean(0);
        usuario.setUsuario(usuarior);
        usuario.setCorreo(correor);
        usuario.setClave(clave);

        boolean user = login.consultarUsuario(usuario);

        boolean correo = login.consultarCorreo(usuario);

        if (user) {

            request.setAttribute("msg", "Ya existe cuenta con este usuario");
            RequestDispatcher rd = request.getRequestDispatcher("registrate.jsp");
            rd.forward(request, response);
        } else {
            if (correo) {

                request.setAttribute("msg", "Ya existe cuenta con este correo");
                RequestDispatcher rd = request.getRequestDispatcher("registrate.jsp");
                rd.forward(request, response);

            } else {

                if (login.agregarUsuario(usuario)) {

                    ApoderadosBean apoderado = new ApoderadosBean(0);
                    apoderado.setApellido(apellido);
                    apoderado.setDui(dui);
                    apoderado.setNombre(nombre);
                    apoderado.setTelefono(telefono);
                    apoderado.setId_usuario(login.ultimo());
                    if (login.agregarApoderado(apoderado)) {

                        request.setAttribute("msg", "Registrado Exitosamente");
                        RequestDispatcher rd = request.getRequestDispatcher("registrate.jsp");
                        rd.forward(request, response);

                    } else {
                        login.eliminarUsuario(login.ultimo());
                        request.setAttribute("msg", "No fue posible llenar el formulario");
                        RequestDispatcher rd = request.getRequestDispatcher("registrate.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    request.setAttribute("msg", "No fue posible llenar el formulario");
                    RequestDispatcher rd = request.getRequestDispatcher("registrate.jsp");
                    rd.forward(request, response);
                }

            }
        }
    }

    protected void cerrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(true);

        session.invalidate();

        response.sendRedirect("Inicio.jsp");
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
