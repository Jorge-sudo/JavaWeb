/*Spring boot solo reconoce las clases java si esta dentro de la clase Application.java
si creamos clases que esten fuera de ello no lo reconocera */
package mx.com._1_HolaSpring.web;

import lombok.extern.slf4j.Slf4j;
import mx.com._1_HolaSpring.domain.Persona;
import mx.com._1_HolaSpring.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller//Esto por detras trabaja con servlet y no es necesario extender de ninguna clase como en un servlet
@Slf4j //Esta anotacion es para el manejo del loj4
public class ControladorInicio {
    
    @Autowired //es igual a @Inject
    private PersonaService personaService;
    
    @GetMapping("/")//ya que esta en blanco entonces la direccion sera http://localhost:8080/
    public String inicio(Model model){//con model podemos agregar la informacion que queremos compartir con index/vista
        log.info("ejecutando el controlador Spring MVC");
        var personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
        return "index";//Retornara el nombre de la pagina que se desplegara en el navegador 
    }
    
            //PATH AGREGAR 
    @GetMapping("/agregar")//Recibimos un path de tipo persona y Spring lo buscara y si no lo encuentra lo creara y injectara
    public String agregar(Persona persona){
        return "modificar";
    }
    
    //Ahora agregamos el Path de guardar 
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    //Mapeamos el metodo de Editar
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){//Spring por default inicializa el objeto asi que no sera necesario hacer un set de id
        persona = personaService.encontrarPersona(persona); //Buscamos la persona con el id
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    //mapeamos el metodo Eliminar
    @GetMapping("/eliminar")
    public String eliminar (Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
