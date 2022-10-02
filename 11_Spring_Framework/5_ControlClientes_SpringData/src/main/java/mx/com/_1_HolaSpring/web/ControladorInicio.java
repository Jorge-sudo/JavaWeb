/*Spring boot solo reconoce las clases java si esta dentro de la clase Application.java
si creamos clases que esten fuera de ello no lo reconocera */
package mx.com._1_HolaSpring.web;

import lombok.extern.slf4j.Slf4j;
import mx.com._1_HolaSpring.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*Con controller estamos trabajando con MVC*/
@Controller//Esto por detras trabaja con servlet y no es necesario extender de ninguna clase como en un servlet
@Slf4j //Esta anotacion es para el manejo del loj4
public class ControladorInicio {
    
    /*En spring para injectar un objeto que sea administrado por el contenedor bas con hacer lo siguinte */
    @Autowired //es igual a @Inject
    private PersonaService personaService;
    
    @GetMapping("/")//ya que esta en blanco entonces la direccion sera http://localhost:8080/
    public String inicio(Model model){//con model podemos agregar la informacion que queremos compartir con index/vista
        log.info("ejecutando el controlador Spring MVC");
        String mensaje = "Mensaje con Thymeleaf";
        var personas = personaService.listarPersonas();
       
        model.addAttribute("personas", personas);
        model.addAttribute("mensaje", mensaje);
        
        
        //Este index se buscara en la carpeta de templates de resources
        return "index";//Retornara el nombre de la pagina que se desplegara en el navegador 
        //index de Thymeleaf
    }
}
