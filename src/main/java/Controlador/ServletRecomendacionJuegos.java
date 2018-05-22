/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Juegos;
import DB.Usuarios;
import Modelo.Juego;
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

@WebServlet(name = "ServletRecomendacionJuegos", urlPatterns = {"/ServletRecomendacionJuegos"})
public class ServletRecomendacionJuegos extends HttpServlet{
    private Usuarios usuarios;
    private Juegos juegos;

    public ServletRecomendacionJuegos() {
        usuarios = new Usuarios();
        juegos = new Juegos();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //retornar info de un juego en especifico 
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("sessionId");
        Usuario u = this.usuarios.FindById(id);
        System.out.println("nom "+u.getNickname());
        ArrayList<Juego> juegos= (ArrayList<Juego>) this.juegos.findAll();
        ArrayList<Juego> j = new ArrayList<Juego>();
        for (int i = 0; i < juegos.size(); i++) {
             if(u.getGenerosJuego()!=null && juegos.get(i).getGenero().trim().equals(u.getGenerosJuego().trim())){
                 j.add(juegos.get(i));
             }
        }
        if(j.size()==0){
           for (int i = 0; i < juegos.size(); i++) {
                 j.add(juegos.get(i));
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
