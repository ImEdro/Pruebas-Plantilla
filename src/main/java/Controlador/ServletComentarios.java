/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Comentarios;
import Modelo.Comentario;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Date;
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
@WebServlet(name = "ServletComentarios", urlPatterns = {"/ServletComentarios"})
public class ServletComentarios extends HttpServlet {

    private Comentarios comentarios;

    public ServletComentarios() {
        this.comentarios = new Comentarios();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //retornar por juego
        String idjuego = request.getParameter("IdJuego").trim();
        ArrayList<Comentario> c = (ArrayList<Comentario>) comentarios.findbyIdJuego(idjuego);
        String json = new Gson().toJson(c);
        response.setContentType("application/json");
        response.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String r = "";
        //añadir comentario de un juego 
        HttpSession respuesta = request.getSession();
        String idUsuario = (String) respuesta.getAttribute("sessionId");
        String idjuego = request.getParameter("IdJuego").trim();
        String com = request.getParameter("Comentario").trim();
        Date a = new Date(2018, 3, 6);
        Comentario c = new Comentario(comentarios.findAll().size() + 1, idUsuario, idjuego, com, "0", a);

        if (comentarios.insert(c)) {
            r = "inserto correctamente";
        } else {
            r = "null";
        }

        System.out.println("--------------------" + r);
        response.setContentType("html/text");
        response.getWriter().write(r);
    }

}
