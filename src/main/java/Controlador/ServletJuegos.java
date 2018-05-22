/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Oscar
 */
import DB.Juegofavdb;
import DB.Juegos;
import Modelo.Juego;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletJuegos", urlPatterns = {"/ServletJuegos"})
public class ServletJuegos extends HttpServlet {

    private Juegofavdb jf;
    private Juegos juegos;

    public ServletJuegos() {
        jf = new Juegofavdb();
        juegos = new Juegos();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //retornar juegos 
        ArrayList<Juego> j = (ArrayList<Juego>) this.juegos.findAll();
        String json = new Gson().toJson(j);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
