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
 * @author william
 */
@WebServlet(name = "ServletRecomendacionUsuarios", urlPatterns = {"/ServletRecomendacionUsuarios"})
public class ServletRecomendacionUsuarios extends HttpServlet {

    private Usuarios usuarios;
    private Juegofavdb juegofav;
    private Juegos juegos;

    public ServletRecomendacionUsuarios() {
        usuarios = new Usuarios();
        juegofav = new Juegofavdb();
        juegos = new Juegos();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String ids = (String) session.getAttribute("sessionId");
        Usuario use = this.usuarios.FindById(ids);
        //retornar info de un juego en especifico 
        String id = (String) request.getParameter("IdJuego");
        Juego u = (Juego) this.juegos.findbyId(id).get(0);
        System.out.println("nom " + u.getNombre());
        ArrayList<JuegoFav> juegosfav = (ArrayList<JuegoFav>) this.juegofav.findAll();
        ArrayList<Usuario> j = new ArrayList<Usuario>();
        for (int i = 0; i < juegosfav.size(); i++) {
            if (u.getId() != null && juegosfav.get(i).getIdJuego().trim().equals(u.getId().trim())) {
                if(!use.getNickname().equals(juegosfav.get(i).getIdUsuario())){
                    
                Usuario us = this.usuarios.FindById(juegosfav.get(i).getIdUsuario());
                us.setPassword("****");
                j.add(us);
            }
            }
        }

        //j.add(this.usuarios.FindById(id));
        String json = new Gson().toJson(j);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
