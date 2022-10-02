
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name="SessionesServlet", urlPatterns = "/SessionesServlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet ( HttpServletRequest request , HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        //Este metoodo recupera sesiones pero tambien crea sesiones
        HttpSession sesion = request.getSession();
        String titulo = null;
        
        //Pedir el atributo contadorVisitas a la sesion
        Integer contadorVisitas = (Integer)sesion.getAttribute("contadorVisitas");
        //Si es nulo es la primera vez que accedemos a la aplicacion
        if (contadorVisitas == null ) {
            contadorVisitas = 1;
            titulo = "Bienvenido Por Primera Vez";
        }else{
            contadorVisitas++;
            titulo = "Bienvenido Nuevamente";
        }
        //Agregamos el nuevo valor a la sesion
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        //Mandamos la respuesta al cliente
        PrintWriter out = response.getWriter();
        out.print(titulo);
        out.print("<br>");
        out.print(" Nro. Accesos al recurso : " + contadorVisitas);
        out.print("<br>");
        out.print(" ID de la Sesion: " + sesion.getId());
        out.close();
    }
}
