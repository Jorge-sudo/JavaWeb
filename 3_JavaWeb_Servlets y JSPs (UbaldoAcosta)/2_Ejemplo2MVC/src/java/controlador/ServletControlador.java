package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;



@WebServlet( name = "ServletControlador", urlPatterns = "/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1. Procesamos parametros
        String accion = request.getParameter("accion");
        
        //2. Creamos los JavaBeans que utilizaremos 
        Rectangulo recRequest = new Rectangulo(1, 2);
        
        Rectangulo recSession = new Rectangulo(3, 4);
        
        Rectangulo recAplicacion = new Rectangulo (5, 6);
        
        //3. Agregamos JavaBean a algun alcance 
        
            //Revisamos la accion proporcionada
            
        //Compartimnos el JavaBean de Rectangulo 
        if("agregaVariables".equals(accion)){
            //Alcance Request
            request.setAttribute("rectanguloRequest", recRequest);
            //Alcance Session
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSession", recSession);
            //Alcance Aplicacion
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloAplicacion", recAplicacion);
            
            //Agregamos mensaje
            request.setAttribute("mensaje", "Las variables fueron agregadas");
            
            //4. reedirecionamos al JSPs de index
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if("listarVariables".equals(accion)){
            //4 Redireccionamos el JSPs que despliega las variables
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
        }else{
            //4. Redireccionamos a la pagina de inicio
            request.setAttribute("mensaje", "Accion no proporcionada o desconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
            //Esta linea no agregaria informacion al JSPs , ya que no propaga informacion a request o response
            //Con esto tambien podemos redirigir 
            //response.sendRedirect("index.jsp");
        }
        
        
        
    }
}
