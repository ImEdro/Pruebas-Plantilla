package com.crunchify.jsp.servlet;
 
import edu.co.sergio.mundo.dao.ObraDAO;
import edu.co.sergio.mundo.vo.Colmena;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
 
/**
 * @author Crunchify.com
 */
 
public class HelloCrunchify extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String autor = request.getParameter("autor");
        String valor = request.getParameter("valor");
        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        ObraDAO dao = new ObraDAO();
        
        Colmena obra = new Colmena();
        obra.setPaneles_con_alimento(autor);
        obra.setKilos_Miel(Integer.valueOf(valor));
        dao.insert(obra);
        
        //Listando la informacion  
        List<Colmena> obras =  dao.findAll();
        request.setAttribute("obras", obras);
       
       
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);
        
        
        }
}
