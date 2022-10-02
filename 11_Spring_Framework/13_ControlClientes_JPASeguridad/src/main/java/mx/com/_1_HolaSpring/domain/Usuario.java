package mx.com._1_HolaSpring.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;


@Entity
@Data
@Table( name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    
    //Realizamos la anotacion de uno=usuario a muchos=roles
    @OneToMany
    @JoinColumn(name = "id_usuario") //definimos cual es la relacion
    private List<Rol> roles;
}
