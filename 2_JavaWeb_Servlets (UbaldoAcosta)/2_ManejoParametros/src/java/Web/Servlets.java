package Web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Servlet", urlPatterns = "/Servlet")
public class Servlets extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //leer los parametros del form HTML
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        System.out.println("usuario = " + usuario);
        System.out.println("password = " + password);

        PrintWriter out = response.getWriter();
        //Print o println es lo mismo el navegador no reconoce el salto de linea 
        out.println("<html>");//Esto es para imprimier en el navegador
        out.println("<body>");
        out.println(" El parametro del usuario es :" + usuario);
        out.println("<br/>");
        out.println(" El parametro del password es :" + password);
        out.println("</body>");
        out.println("</html>");
    }
}
