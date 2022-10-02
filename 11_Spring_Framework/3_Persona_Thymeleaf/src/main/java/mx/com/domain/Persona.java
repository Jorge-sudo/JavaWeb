package mx.com.domain;

import lombok.Data;

/*Loombok*/
/*Con la anotacion data nos agrega todo codigo repetitivo como los metodos  equals, sets, gets, hashCode 
y toString. Todo lo necesario para que sea un JavaBean */
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
