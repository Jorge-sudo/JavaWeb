package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;



@WebServlet( name = "ServletControlador", urlPatterns = "/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1. Procesamos parametros
        
        //2. Creamos los JavaBeans que utilizaremos 
        Rectangulo rec = new Rectangulo(3, 6);
        
        //3. Agregamos JavaBean a algun alcance 
        request.setAttribute("mensaje", "Saludos desde el Servlet");
        
        //Compartimnos el JavaBean de Rectangulo pero en el alcance de "Session"
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectangulo", rec);
        
        //4. Redireccionamos la vista Seleccionada e indicamos que JSPs utilizaremos 
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariable.jsp");
        
        //Propagamos los Objetos request y response a el JSPs de respuesta
        rd.forward(request, response);
        
    }
}
