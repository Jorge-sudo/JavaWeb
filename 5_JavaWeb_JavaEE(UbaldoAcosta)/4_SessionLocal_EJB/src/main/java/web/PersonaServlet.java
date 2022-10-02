package web;

import domain.Persona;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.PersonaService;


@WebServlet(name = "personas", urlPatterns = {"/personas"})
public class PersonaServlet extends HttpServlet  {
    
    @Inject
    PersonaService personaService;
    
    @Override
    protected void doGet (HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException{
        /*Este metodo accedemos al metodo personas*/
        List<Persona> personas = personaService.listarPersonas();
        System.out.println("personas: " + personas );
        request.setAttribute("personas", personas);
        /*Request dispacher para redirigir esto al listado de personas*/
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
    }
}
