package beans.model;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//Para que sea reconocida esta clase por el Framework de JavaServer Faces necesitamos aplicar esta anotacion

@Named
@RequestScoped//Esta anotacion es para definir el tipo de alcance

public class Candidato {
    private String nombre ;
    private String apellido ;
    private int salarioDeseado;
    private Date fechaNacimiento;
    
    Logger log = LogManager.getRootLogger();
    
    public Candidato (){
        log.info("Creando el Objeto Candidato");
        //Aqui agregamos el caracter "Introduce tu nombre" para que aparezca en el capo de texto
        this.setNombre("Introduce tu nombre");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        log.info("Modificando la propiedad de nombre: " + this.nombre);
    }
    
     public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
        log.info("Modificando la propiedad de apellido: " + this.apellido);
    }

    public int getSalarioDeseado() {
        return salarioDeseado;
    }

    public void setSalarioDeseado(int salarioDeseado) {
        this.salarioDeseado = salarioDeseado;
        log.info("Modificando la propiedad de sueldo deseado: " + this.salarioDeseado);
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
