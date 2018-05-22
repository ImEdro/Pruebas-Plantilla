/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Usuarios;
import Modelo.Juego;
import Modelo.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Oscar
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends HttpServlet {

    private Usuarios usuarios;

    public ServletUsuario() {
        usuarios = new Usuarios();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //retornar info de un juego en especifico 
        String id = request.getParameter("IdUsuario");
        ArrayList<Usuario> j = new ArrayList<Usuario>();
        j.add(this.usuarios.FindById(id));
        String json = new Gson().toJson(j);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String r="";
        String id = request.getParameter("IdUsuario");
        String nombre = request.getParameter("Nombre");
        Date FechaNacimiento = Date.valueOf(request.getParameter("FechaNacimiento"));
        String ExperienciaVideojuegos = request.getParameter("ExperienciaVideojuegos");
        String HorasPromedioJuego = request.getParameter("HorasPromedioJuego");
        String PlataformasVideojuegos = request.getParameter("PlataformasVideojuegos");
        String Idiomas = request.getParameter("Idiomas");
        String DiasJuego = request.getParameter("DiasJuego");
        String HorarioJuego = request.getParameter("HorarioJuego");
        String GenerosJuego = request.getParameter("GenerosJuego");
        Usuario u = this.usuarios.FindById(id);
        u.setNombre(nombre);
        u.setFechaNacimiento(FechaNacimiento);
        u.setExperienciaVideojuegos(ExperienciaVideojuegos);
        u.setHorasPromedioJuego(HorasPromedioJuego);
        u.setPlataformasVideojuegos(PlataformasVideojuegos);
        u.setIdiomas(Idiomas);
        u.setHorarioJuego(HorarioJuego);
        u.setGenerosJuego(GenerosJuego);
        u.setDiasJuego(DiasJuego);
        if (usuarios.update(u)) {
            r = "realizado";
        } else {
            r = "error al actualizar datos";
        }

        response.setContentType("html/text");
        response.getWriter().write(r);
    }
}
