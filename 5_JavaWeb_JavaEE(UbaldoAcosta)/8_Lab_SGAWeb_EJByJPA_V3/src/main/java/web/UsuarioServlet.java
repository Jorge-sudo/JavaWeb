package web;

import dominio.Usuario;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.UsuarioService;

@WebServlet(name = "usuarios", urlPatterns = "/usuarios")
public class UsuarioServlet extends HttpServlet {
    
    @Inject
    UsuarioService usuarioService;
    
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /*Este metodo accedemos al metodo personas*/
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        System.out.println("personas: " + usuarios );
        request.setAttribute("usuarios", usuarios);
        /*Request dispacher para redirigir esto al listado de personas*/
        request.getRequestDispatcher("/listadoUsuarios.jsp").forward(request, response);
    }
    
}
