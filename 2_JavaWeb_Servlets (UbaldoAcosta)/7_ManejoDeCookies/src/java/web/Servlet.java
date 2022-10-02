package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//Aqui Monitorearemos si un usuario ya a hecho peticiones de manera recurente
//Vamos a detectar si ya lo hizo y lo enviaremos en un mensaje 
//Si es un usuario nuevo le daremmos la bienvenida 

@WebServlet( name = "CookiesServlet", urlPatterns = "/CookiesServlet")
public class Servlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //suponemos que el usuario visita por primera ver nuestro sitio
        boolean nuevoUsuario = true;
        
        //Obtenemos el arreglo de cookies
        //Los cookies basicamente es un achivo que tiene un nombre y un valor asociado es como un mapa 
        //y esta informacion se envia el servidor 
        Cookie[] cookies = request.getCookies();//Con esto obtenemos todos cookies
        
        //Buscamos si ya hay una Cookies ecistende ya creado anteriormente 
        //llamada visitante Recurente
        if (cookies != null) {
            for(Cookie c: cookies){
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                    //Si ya existe la cookie es un usuario recurrente
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        String mensaje = null;
        if(nuevoUsuario){
                                       //nombreCookie,ValorAsociado
            Cookie visitanteCokie = new Cookie("visitanteRecurrente", "si");
            //Agregamos cookies
            response.addCookie(visitanteCokie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        }else{
            mensaje = "Gracias por visitar NUEVAMENTE nuestro sitio";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Mensaje : "+ mensaje);
        out.close();
    }
}
