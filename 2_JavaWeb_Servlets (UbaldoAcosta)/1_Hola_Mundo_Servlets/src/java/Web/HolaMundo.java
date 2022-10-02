
package Web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//Este es una notacion puede ser cualquier nombre no importa si es diferente a la clase
//Esto tambien es para configurar para que podamos acceder desde el navegador
@WebServlet(name = "HolaMundo", urlPatterns = {"/HolaMundo"})
public class HolaMundo extends HttpServlet{
    
    //Ahora implementaremos que metodo sera llamado desde el navegador doGET o doPOST
    
    //Este metodo ya esta sobre Escribido 
    //El servidor de aplicaciones en este caso GlashFis se encargara en el llamado de este metodo
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Con esto decimos que envaremos al navegador texto de tipo html
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(" Hola Mundo desde Servelt");
    }
    //Nota: Esto solo funciona con proyectos Maven
}
