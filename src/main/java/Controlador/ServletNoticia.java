/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import DB.Noticias;
import Modelo.Noticia;
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
 * @author Oscar
 */
@WebServlet(name = "ServletNoticia", urlPatterns = {"/ServletNoticia"})
public class ServletNoticia extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Noticias p= new Noticias();
        ArrayList<Noticia> personas =new ArrayList<Noticia>();
         personas = (ArrayList) p.findAll();
            System.out.println(personas.get(0).getId());
            String json = new Gson().toJson(personas);
            response.setContentType("application/json");
            response.getWriter().write(json);
      
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
