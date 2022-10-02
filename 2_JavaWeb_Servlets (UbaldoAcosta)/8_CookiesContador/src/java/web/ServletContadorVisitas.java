
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ServletContadorVisitas" , urlPatterns = "/ServletContadorVisitas")
public class ServletContadorVisitas extends HttpServlet{
    
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Declaramos una varible contador de tipo entero 
        int contador = 0;
        
        //Revisar si existe la cookie contadorVisitas
        Cookie[] cookies = request.getCookies();
        if( cookies != null){
            for(Cookie c: cookies){
                if(c.getName().equals("contadorVisitas")){
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        
        //Incrementamos el contador 
        contador++;
        //Agregamos la respuesta el navegador 
        Cookie c = new Cookie("contadorVisitas",Integer.toString(contador));
        
        //Indicamos que la Cookie Se almacenara en el cliente 1 hora (3600 seg)
        c.setMaxAge(3600);//Indicamos el numero de segundos en que expirara esta cookie
        
        //Agregamos enla respuesta
        response.addCookie(c);
        
        //Mandamos el mensaje al navegador 
        response.setContentType("text/html;charset=UTF-8");//Agregamos el tipo de contenido 
        PrintWriter out = response.getWriter();
        out.print("Contador de visitas de cada cliente: " +contador);
    }
}
