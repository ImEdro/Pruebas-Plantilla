/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Usuarios;
import Modelo.Usuario;
import Modelo.Validador;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
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
@WebServlet(name = "ServletCrearCuenta", urlPatterns = {"/ServletCrearCuenta"})
public class ServletCrearCuenta extends HttpServlet {

    private Usuarios usu;

    public ServletCrearCuenta() throws URISyntaxException {
        this.usu = new Usuarios();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Crear Cuenta e iniciar sesion
        String r = "";
        HttpSession respuesta = request.getSession(true);
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String nick = request.getParameter("nick");
        String pais = request.getParameter("pais");

        Pattern p = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        Matcher m = p.matcher(email);
        Validador v = new Validador();
        r = "";
        //campos vacios
        if (email.isEmpty() || password.isEmpty()) {
            r = "hay casillas vacias";
        } else //No hay campos vacios, veo que la direccion de email sea válida
        {
            if (m.find()) {
                //La direccion de email si es correcta, verifico que la contraseña tambien lo sea
                if (v.isUsernameOrPasswordValid(password)) {
                    if (usu.createUsuario(nombre, nick, email, password)) {
                        //Se a creado la cuenta
                        //OBTENGO EL NOMBRE DEL USUARIO Y LO GUARDO EN UNA SESION
                        Usuario u = this.usu.buscar(email, password);
                        System.out.println("------ nu: " + u.getNombre());
                        respuesta.setAttribute("sessionId", u.getNickname());
                        respuesta.setAttribute("sessionNombre", u.getNombre());
                        respuesta.setAttribute("sessionEmail", email);
                        r = "ingresar";
                    } else {
                        r = "error al crear la cuenta";
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
}
