package mx.com._1_HolaSpring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/*Loombok*/
/*Con la anotacion data nos agrega todo codigo repetitivo como los metodos  equals, sets, gets, hashCode 
y toString. Todo lo necesario para que sea un JavaBean */
@Data
@Entity // utilizaremos en estandar JPA
@Table(name = "persona") //Espesificamos el nombre de la tabla por que en java es Persona y en MySQL es persona
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //opcion de generacion
    @Column(name = "id_persona")
    private Long idPersona;
    //@NonNull esto solo valida que no sea nulo pero el @NotEmpty valida que no sea nulo y que no este vacio la cadena
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email //Esto validara que sea un email correcto
    private String email;
    private String telefono;
}
