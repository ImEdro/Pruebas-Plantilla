/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Usuarios;
import Modelo.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author willy
 */
@WebServlet(name = "ServletValidarSesion", urlPatterns = {"/ServletValidarSesion"})
public class ServletValidarSesion extends HttpServlet {

    private Usuarios usu;

    public ServletValidarSesion() throws URISyntaxException {
        this.usu = new Usuarios();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //retorna info de usuario en sesion 
        String r = "null";
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("sessionEmail");
        Usuario u = usu.buscar2(email);
        if (u == null) {
            r = "null";
        } else {
            ArrayList<Usuario> a = new ArrayList<>();
            u.setPassword("*****");
            a.add(u);
            r = new Gson().toJson(a);
        }
        response.setContentType("application/json");
        response.getWriter().write(r);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //validar sesion
        String r = "";
        HttpSession session = request.getSession();
        String nombre = (String) session.getAttribute("sessionNombre");
        if (nombre == null) {
            r = "null";
        } else {
            r = nombre;
        }
        response.setContentType("html/text");
        response.getWriter().write(r);
    }
}
