/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Usuarios;
import Modelo.Usuario;
import Modelo.Validador;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
@WebServlet(name = "ServletSesion", urlPatterns = {"/ServletSesion"})
public class ServletSesion extends HttpServlet {

    private Usuarios usu;

    public ServletSesion() throws URISyntaxException {
        this.usu = new Usuarios();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //retorna la informacion del usuario en sesion 
        String r = "";
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("sessionEmail");
        Usuario u = usu.buscar2(email);
        if (u == null) {
            r = "null";
        } else {
            ArrayList<Usuario> a = new ArrayList<>();
            u.setPassword("*****");
            a.add(u);
            r = new Gson().toJson(a);
        }
        response.setContentType("application/json");
        response.getWriter().write(r);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // iniciar sesion sesion 
        String r = "";
        HttpSession respuesta = request.getSession(true);
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Pattern p = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        Matcher m = p.matcher(email);
        Validador v = new Validador();
        //campos vacios
        if (email.isEmpty() || password.isEmpty()) {
            r = "hay casillas vacias";
        } else //No hay campos vacios, veo que la direccion de email sea válida
        {
            if (m.find()) {
                //La direccion de email si es correcta, verifico que la contraseña tambien lo sea
                if (v.isUsernameOrPasswordValid(password)) {
                    if (usu.isAcountExists(email.trim(), password.trim())) {
                        //Significa que la cuenta si existe
                        //OBTENGO EL NOMBRE DEL USUARIO Y LO GUARDO EN UNA SESION
                        Usuario u = this.usu.buscar(email, password);
                        System.out.println("------ nu: " + u.getNombre());
                        respuesta.setAttribute("sessionId", u.getNickname());
                        respuesta.setAttribute("sessionNombre", u.getNombre());
                        respuesta.setAttribute("sessionEmail", email);
                        r = "ingresar";
                    } else {
                        r = "usuario o contraseña erroneo";
                    }
                } else {
                    r = "contraseña no valida";
                }
            } else {
                r = "direccion de correo incorrecta";
            }
        }

        response.setContentType("html/text");
        response.getWriter().write(r);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //cerrar sesion
        HttpSession session = request.getSession();
        session.removeAttribute("sessionId");
        session.removeAttribute("sessionNombre");
        session.removeAttribute("sessionEmail");
        session.invalidate();
    }
  
    
}
