/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Juegos;
import Modelo.Juego;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author willy
 */
@WebServlet(name = "ServletInfoJuego", urlPatterns = {"/ServletInfoJuego"})
public class ServletInfoJuego extends HttpServlet {

    private Juegos juegos;

    public ServletInfoJuego() {
        juegos = new Juegos();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //retornar info de un juego en especifico 
        String id = request.getParameter("IdJuego").trim();
        
        ArrayList<Juego> j = (ArrayList<Juego>) this.juegos.findbyId(id);
        String json = new Gson().toJson(j);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
