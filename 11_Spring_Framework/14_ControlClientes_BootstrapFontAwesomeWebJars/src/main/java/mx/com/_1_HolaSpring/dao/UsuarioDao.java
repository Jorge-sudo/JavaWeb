package mx.com._1_HolaSpring.dao;

//podemos utilizar el extends CrudRepository<Persona, Long> pero sin embargo jpaRepository tiene algunas mejoras

import mx.com._1_HolaSpring.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
                                    //<objecto, valor de llave primaria del objeto>
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    //Para la seguridad de Spring y JPA sobrescribimos este metodo 
    //una vez que proporcionemos un username entonces  por automatico Spring va recuperar un usuario filtrado por el username
    Usuario findByUsername(String username);
}
