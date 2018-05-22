/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Juegofavdb;
import DB.Juegos;
import DB.Usuarios;
import Modelo.Juego;
import Modelo.JuegoFav;
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
@WebServlet(name = "ServletJuegosUsuario", urlPatterns = {"/ServletJuegosUsuario"})
public class ServletJuegosUsuario extends HttpServlet {

    private Juegofavdb jf;
    private Juegos juegos;

    public ServletJuegosUsuario() {
        jf = new Juegofavdb();
        juegos = new Juegos();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //retornar juegos del usuario
        String id = request.getParameter("IdUsuario").trim();
        ArrayList<JuegoFav> juegosfav = (ArrayList<JuegoFav>) jf.findbyidUsuario(id);//buscar los juegos fav por usuario
        ArrayList<Juego> j = new ArrayList<Juego>();
        for (int i = 0; i < juegosfav.size(); i++) {
            Juego juego = (Juego) juegos.findbyId(juegosfav.get(i).getIdJuego()).get(0);
            j.add(juego);
        }
        String json = new Gson().toJson(j);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String r="";
        //añadir juegos favorito
        String id = request.getParameter("Idjuego").trim();
        HttpSession respuesta = request.getSession();
        String email = (String) respuesta.getAttribute("sessionEmail");
        Usuarios usu = new Usuarios();
        Usuario u = usu.buscar2(email);
        Juego j = juegos.findbyId(id).get(0);
        JuegoFav a = new JuegoFav("" + (jf.findAll().size() + 1), u.getNickname(), j.getId(), 0);
        if (jf.insert(a)) {
            r = " correcto ";
        } else {
            r = "null";
        }
        response.setContentType("html/text");
        response.getWriter().write(r);
    }

}
