package beans.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//Para que sea reconocida esta clase por el Framework de JavaServer Faces necesitamos aplicar esta anotacion

@Named
@RequestScoped//Esta anotacion es para definir el tipo de alcance

public class Candidato {
    private String nombre = "Introduce tu nombre";
    
    Logger log = LogManager.getRootLogger();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        log.info("Modificando la propiedad de nombre: " + this.nombre);
    }
}
