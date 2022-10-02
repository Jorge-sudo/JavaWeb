/*Spring boot solo reconoce las clases java si esta dentro de la clase Application.java
si creamos clases que esten fuera de ello no lo reconocera */
package mx.com._1_HolaSpring;

import lombok.extern.slf4j.Slf4j;
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
        
        //esa variable saludar lo compartiremos con el Model y podremos compartir a Thymeleaf/index
                        //(llave, valor)
        model.addAttribute("mensaje", mensaje);
        
        model.addAttribute("saludo", saludo);
        
        //Este index se buscara en la carpeta de templates de resources
        return "index";//Retornara el nombre de la pagina que se desplegara en el navegador 
        //index de Thymeleaf
    }
}
