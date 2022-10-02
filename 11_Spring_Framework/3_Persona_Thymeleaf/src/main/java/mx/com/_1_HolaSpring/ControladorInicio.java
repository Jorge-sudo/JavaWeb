/*Spring boot solo reconoce las clases java si esta dentro de la clase Application.java
si creamos clases que esten fuera de ello no lo reconocera */
package mx.com._1_HolaSpring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*Con controller estamos trabajando con MVC*/
@Controller//Esto por detras trabaja con servlet y no es necesario extender de ninguna clase como en un servlet
@Slf4j //Esta anotacion es para el manejo del loj4
public class ControladorInicio {
    
    /*Definimos una variable para almacenar el valor de application.properties*/
    @Value("${index.saludo}")//Con esto injectamos para que esta llave busque el valor y lo injecte el valor a la variable saludo
    private String saludo;   

    @GetMapping("/")//ya que esta en blanco entonces la direccion sera http://localhost:8080/
    public String inicio(Model model){//con model podemos agregar la informacion que queremos compartir con index/vista
        log.info("ejecutando el controlador Spring MVC");
        String mensaje = "Mensaje con Thymeleaf";
        
        
        Persona p = new Persona();
        p.setNombre("Juan");
        p.setApellido("Perez");
        p.setEmail("perez@gmail.com");
        p.setTelefono("5643787");
        
        Persona p2 = new Persona();
        p2.setNombre("Karla");
        p2.setApellido("Gomez");
        p2.setEmail("gomez@gmail.com");
        p2.setTelefono("6542787");
        
                //PRIMERA FORMA
//        List<Persona> personas = new ArrayList<>();
//        personas.add(p);
//        personas.add(p2);

                //SEGUNDA FORMA 
        List<Persona> personas = Arrays.asList(p, p2) ;
        //List<Persona> personas = new ArrayList<>(); //Para que muestre que la lista esta vacia en la vista 
        model.addAttribute("personas", personas);
        //model.addAttribute("persona", p);
        
        //esa variable saludar lo compartiremos con el Model y podremos compartir a Thymeleaf/index
                        //(llave, valor)
        model.addAttribute("mensaje", mensaje);
        
        model.addAttribute("saludo", saludo);
        
        //Este index se buscara en la carpeta de templates de resources
        return "index";//Retornara el nombre de la pagina que se desplegara en el navegador 
        //index de Thymeleaf
    }
}
