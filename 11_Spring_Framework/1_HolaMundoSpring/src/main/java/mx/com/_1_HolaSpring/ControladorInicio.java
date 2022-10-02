/*Spring boot solo reconoce las clases java si esta dentro de la clase Application.java
si creamos clases que esten fuera de ello no lo reconocera */
package mx.com._1_HolaSpring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Esta anotacion es para que Spring pueda reconocer la clase java si no agregamos 
//esta anotacion entonces Spring no podra reconocer
//Por lo tanto no lo podra utilizar dentro de las clases del contenedor de Spring 
@RestController
@Slf4j //Esta anotacion es para el manejo del loj4
public class ControladorInicio {

    /*Para indicar a al navegador que este metodo es el inicio entonces devemos mapearlo a un path
    en este caso con el metodo GET pero tambien se puede con los demas metodos como PUT POST y etc.*/
    @GetMapping("/")//ya que esta en blanco entonces la direccion sera http://localhost:8080/
    public String inicio(){
        log.info("ejecutando el controlador REST");//Este log esta habilidado por default a nivel de "info"
        log.debug("Mas detalle en el controlador ");
        return "Hola Mundo con Spring 2";
    }
}
