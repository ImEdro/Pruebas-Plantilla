/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.CalificacionComentarios;
import DB.CalificacionJuegos;
import DB.Juegos;
import Modelo.CalificacionComentario;
import Modelo.CalificacionJuego;
import Modelo.Juego;
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
 * @author william
 */
@WebServlet(name = "ServletCalificacionJuego", urlPatterns = {"/ServletCalificacionJuego"})
public class ServletCalificacionJuego extends HttpServlet {

    private CalificacionJuegos cjuegos;
    private Juegos juegos;
    public ServletCalificacionJuego() {
        this.cjuegos = new CalificacionJuegos();
        juegos=new Juegos();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //retornar por juego
        int id = Integer.parseInt(request.getParameter("IdJuego").trim());
        ArrayList<Double> c = new ArrayList<Double>();
        c.add(this.cjuegos.Likes(id));
        
        String json = new Gson().toJson(c);
        response.setContentType("application/json");
        response.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String r = "";
        //añadir Calificacion de un juego
        String nickname = request.getParameter("Nickname").trim();
        int id = Integer.parseInt(request.getParameter("IdJuego").trim());
        int cal = Integer.parseInt(request.getParameter("Calificacion").trim());
        CalificacionJuego c = new CalificacionJuego(nickname, id, cal);
        
        if (this.cjuegos.find(nickname, id).size()<=0) {
            if (this.cjuegos.insert(c)) {
                r = "inserto correctamente";
            } else {
                r = "null";
            }
        } else {
            if(this.cjuegos.find(nickname, id).get(0).getCalificacion()== cal){
                this.cjuegos.delete(c);
            }else {
                this.cjuegos.update(c);
            }
        }
        Juego j = this.juegos.findbyId(""+id).get(0);
        
        j.setCalificacion(""+this.cjuegos.Likes(id));
        this.juegos.update(j);
        System.out.println("--------------------" + r);
        response.setContentType("html/text");
        response.getWriter().write(r);
    }
}
