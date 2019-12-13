/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.RecorridosDao;
import conexion.Conexion;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.BarriosBean;
import modelo.ColegiosBean;

/**
 *
 * @author juan.ruizusam
 */
@MultipartConfig
public class RecorridosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action) {

            case "barrios":
                mostrarBarrios(request, response);
                break;
            case "mostrarColegios":
                mostrarColegios(request, response);
                break;

            case "agregarColegio":

                agregarColegio(request, response);
                break;

            case "eliminarColegio":

                eliminarColegio(request, response);
                break;

            case "actualizarColegios":

                actualizarColegio(request, response);
                break;

        }

    }

    protected void agregarColegio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        RecorridosDao recorridosd = new RecorridosDao(conn);
        ColegiosBean colegio = new ColegiosBean(0);
        String nombre = request.getParameter("nombre");

        String direcion = request.getParameter("direcion");
        Part part;
        part = request.getPart("fileFoto");
       
    
        InputStream inputStream;
        inputStream = part.getInputStream();

        colegio.setNombre(nombre);
        colegio.setDirecion(direcion);
        colegio.setFoto(inputStream);

        if (recorridosd.insertarColegio(colegio)) {

            request.getRequestDispatcher("recorridos?action=mostrarColegios&rol=1").forward(request, response);

        } else {
            String msg = "Formulario no enviado";

            request.setAttribute("msg", msg);
            RequestDispatcher rd = request.getRequestDispatcher("mostrar_agregar_colegios.jsp");
            rd.forward(request, response);
        }
    }

    protected void mostrarBarrios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        RecorridosDao barriosd = new RecorridosDao(conn);

        List<BarriosBean> lista = barriosd.mostrarBarrios();
        request.setAttribute("lista", lista);
        RequestDispatcher rd = request.getRequestDispatcher("distritos.jsp");
        rd.forward(request, response);

    }

    protected void mostrarColegios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        RecorridosDao recorridosd = new RecorridosDao(conn);

        List<ColegiosBean> lista = recorridosd.mostrarColegios();
        request.setAttribute("lista", lista);
        int rol = Integer.parseInt(request.getParameter("rol"));

        if (rol == 1) {
            RequestDispatcher rd = request.getRequestDispatcher("mostrar_agregar_colegios.jsp");
            rd.forward(request, response);
        } else {
            if (rol == 0) {
                RequestDispatcher rd = request.getRequestDispatcher("colegios.jsp");
                rd.forward(request, response);
            }
        }

    }

    protected void eliminarColegio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Conexion conn = new Conexion();
        RecorridosDao recorridosd = new RecorridosDao(conn);
        int id = Integer.parseInt(request.getParameter("id"));
        ColegiosBean colegio = new ColegiosBean(id);

        if (recorridosd.eliminarColegio(colegio)) {

            request.getRequestDispatcher("recorridos?action=mostrarColegios&rol=1").forward(request, response);

        } else {
            String msg2 = "No se envió formulario";

            request.setAttribute("msg2", msg2);
            RequestDispatcher rd = request.getRequestDispatcher("mostrar_agregar_colegios.jsp");
            rd.forward(request, response);
        }
    }

    protected void actualizarColegio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        RecorridosDao recorridosd = new RecorridosDao(conn);
        int id = Integer.parseInt(request.getParameter("idU"));

        ColegiosBean colegio = new ColegiosBean(id);
        String nombre = request.getParameter("nombreU");

        String direcion = request.getParameter("direcionU");
        String indicador = request.getParameter("indicador");
        
       

        if (indicador.equals("lleno")) {
            Part part;
            part = request.getPart("fileFotoU");
            InputStream inputStream;
            inputStream = part.getInputStream();

            colegio.setNombre(nombre);
            colegio.setDirecion(direcion);
            colegio.setFoto(inputStream);
            

            if (recorridosd.actualizarColegioConFoto(colegio)) {

                request.getRequestDispatcher("recorridos?action=mostrarColegios&rol=1").forward(request, response);

            } else {
                                              
                String msg3 = "Formulario no enviado";
                request.setAttribute("msg3", msg3);
                RequestDispatcher rd = request.getRequestDispatcher("mostrar_agregar_colegios.jsp");
                rd.forward(request, response);
            }

        } else {
            
            colegio.setNombre(nombre);
            colegio.setDirecion(direcion);
            

            if (recorridosd.actualizarColegioSinFoto(colegio)) {

                request.getRequestDispatcher("recorridos?action=mostrarColegios&rol=1").forward(request, response);

            } else {
                String msg3 = "Formulario no enviado";

                request.setAttribute("msg3", msg3);
                request.getRequestDispatcher("mostrar_agregar_colegios.jsp").forward(request, response);
            }
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
