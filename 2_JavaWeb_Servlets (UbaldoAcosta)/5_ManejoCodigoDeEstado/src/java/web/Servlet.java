
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name="Servlet", urlPatterns = "/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Simulamos los valores correctos
        String usuarioOk = "Juan";
        String passwordOk = "123";
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        PrintWriter out = response.getWriter();
        
        if (usuarioOk.equals(usuario) && passwordOk.equals(password)) {
            out.print("<h1>");
            out.print("Datos Correctos");
            out.print("<br> Usuario : "+ usuario);
            out.print("<br> Password : "+ password);
            out.print("</h1>");
        }else{
            //De lo contrario utilizaremos un codigoo de estado 
            response.sendError(response.SC_UNAUTHORIZED, "Las Credenciales Son Incorrectas");
        }
    }
}
