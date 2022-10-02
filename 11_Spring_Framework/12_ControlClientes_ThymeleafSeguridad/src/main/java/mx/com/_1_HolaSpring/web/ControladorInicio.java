/*Spring boot solo reconoce las clases java si esta dentro de la clase Application.java
si creamos clases que esten fuera de ello no lo reconocera */
package mx.com._1_HolaSpring.web;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com._1_HolaSpring.domain.Persona;
import mx.com._1_HolaSpring.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller//Esto por detras trabaja con servlet y no es necesario extender de ninguna clase como en un servlet
@Slf4j //Esta anotacion es para el manejo del loj4
public class ControladorInicio {
    
    @Autowired //es igual a @Inject
    private PersonaService personaService;
    
    @GetMapping("/") //Spring injectara el User por defecto y podremos usarlo
    public String inicio(Model model, @AuthenticationPrincipal User user){ //Esto es para saber que usuario inicio session 
        log.info("ejecutando el controlador Spring MVC");
        //En este caso solo enviamos a consola el usuario que hizo login  
        log.info("Usuario que hizo Login: "+ user);
        List<Persona> personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
        return "index";//Retornara el nombre de la pagina que se desplegara en el navegador 
    }
    
            //PATH AGREGAR 
    @GetMapping("/agregar")//Recibimos un path de tipo persona y Spring lo buscara y si no lo encuentra lo creara y injectara
    public String agregar(Persona persona){
        return "modificar";
    }
    
    //Ahora agregamos el Path de guardar 
    @PostMapping("/guardar")//Persona se validara entonces pondremos la anotacion de @Valid
    public String guardar(@Valid Persona persona, Errors error){//y si tenemos errores tenemos que para el parametro de errors
        //Preguntamos si recibimos algun error 
        if(error.hasErrors()){
            //Si hay algun error retornamos a modificar 
            return "modificar";
        }
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
