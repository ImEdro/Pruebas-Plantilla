/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Notificaciones;
import DB.Usuarios;
import Modelo.Notificacion;
import Modelo.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
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
@WebServlet(name = "ServletNotificacion", urlPatterns = {"/ServletNotificacion"})
public class ServletNotificacion extends HttpServlet {

    private Notificaciones not;

    public ServletNotificacion() {
        not = new Notificaciones();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //retornar las notificaciones de un usuario
        HttpSession respuesta = request.getSession();
        String email = (String) respuesta.getAttribute("sessionEmail");
        Usuarios usu = new Usuarios();
        Usuario u = usu.buscar2(email);
        ArrayList<Notificacion> notificaciones = new ArrayList<Notificacion>();
        notificaciones = (ArrayList) not.findByIdUsuario(u.getNickname());
        String json = new Gson().toJson(notificaciones);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // borrar una notificacion
        String id = request.getParameter("IdNotificacion").trim();
        Notificacion nn = new Notificacion(id, null, null, null, null, null);
        not.delete(nn);
      
    }

}
