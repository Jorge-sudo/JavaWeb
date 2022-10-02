package beans.model;

//Para que sea reconocida esta clase por el Framework de JavaServer Faces necesitamos aplicar esta anotacion

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped//Esta anotacion es para definir el tipo de alcance

public class Candidato {
    private String nombre = "Introduce tu nombre";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
