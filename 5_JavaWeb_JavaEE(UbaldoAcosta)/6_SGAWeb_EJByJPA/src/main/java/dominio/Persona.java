
package dominio;

import java.io.Serializable;
import javax.persistence.*;

/* Esta clase la convertiremos en una clase entidad para que podamos interactuar con JPA */

@Entity
/*Tambien se pueden agregar Queries asi que vamos a agregaremos uno*/
@NamedQueries({
    //Esto es JPQL en este caso recuperara obejtos de la base de datos y no columnas
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p ORDER BY p.idPersona") 
})
@Table(name = "persona") /*Si el nombre de la tabla no de podria identificar o el nombre de la clase java es distinto 
al de la tabla entonces aqui podemos espesificar el nombre con esta anotacion @Table */
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /*Sin envargo para que JPA reconozca esto como una clave primaria se le agrega la anotacion @Id*/
    @Id
    /*Ya que agregamos la ID autoincrementable en la base de datos hacemmos los siguiente */
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    /*Esta variable en la base de datos se llama id_persona , pero en nuestra clase se llama idPersona 
    por lo tanto espesificamos como esta en la base de datos con lo siguiente */
    @Column(name = "id_persona")
    private int idPersona;
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
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
