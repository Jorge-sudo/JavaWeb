package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity //Con esta anotacion señalamos que esta clase es un obejto/Entidad
@Table(name = "persona")//Con esto referenciamos a que tabla nos estamos refiriendo en este caso a la tabla persona no es necesario si la tabla es igual a la clase 
public class Persona implements Serializable {
    
    //Con esto impllementamos la interfaz serializable
    private static final long serialVersionUID = 1L;
    //Espesificamos la columna ya que en la base de datos esta con id_persona y el la clase idPersona
    @Column(name="id_persona")
    @Id //Espesificamos la llave primaria
    private int idPersona;
    /*Por lo que los demas atributos son iguales a loa nombres de las columnas de la tabla persona 
    de la base de datos no es necesario agregar la anotacion @Colum por que por defecto se los comparara
    y como son iguales no hay problema */
    private String nombre;
    
    private String apellido;
    
    private String email;
    
    private String telefono;
    
    public Persona(){
        
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
}
