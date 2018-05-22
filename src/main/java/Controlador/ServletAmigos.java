/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Amigos;
import DB.Notificaciones;
import DB.Usuarios;
import Modelo.Amigo;
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
@WebServlet(name = "ServletAmigos", urlPatterns = {"/ServletAmigos"})
public class ServletAmigos extends HttpServlet {

    private Amigos amigos;
    private Usuarios usu;

    public ServletAmigos() {
        amigos = new Amigos();
        usu = new Usuarios();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //lista de amigos de una persona
        HttpSession respuesta = request.getSession();
        String email = (String) respuesta.getAttribute("sessionEmail");
        Usuarios usu = new Usuarios();
        Usuario u1 = usu.buscar2(email);
        ArrayList<Amigo> j1 = (ArrayList<Amigo>) this.amigos.findByIdUsuario(u1.getNickname());
        ArrayList<Usuario> j = new ArrayList<Usuario>();
        for (int i = 0; i < j1.size(); i++) {
            Usuario u = usu.FindById(j1.get(i).getIdUser2());
            u.setPassword("****");
            j.add(u);
        }
        String json = new Gson().toJson(j);
        response.setContentType("application/json");
        response.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //añadir amigo
         String r = "";
        String id = request.getParameter("IdUsuario").trim();
        HttpSession respuesta = request.getSession();
        String email = (String) respuesta.getAttribute("sessionEmail");
        Usuario u1 = usu.buscar2(email),u2=usu.FindById(id);
        Amigo a= new Amigo(""+(amigos.findAll().size()+1), id, u1.getNickname());
        amigos.insert(a);
        a= new Amigo(""+(amigos.findAll().size()+1), u1.getNickname(), id);
        if (amigos.insert(a)) {
                r = "agregado Correctamente";
                Notificaciones n= new Notificaciones();
                Notificacion nn=new Notificacion(null, u1.getNickname(), null, null, null, id);
                n.delete(nn);
            } else {
                r = "error ";
            }
    }

}
