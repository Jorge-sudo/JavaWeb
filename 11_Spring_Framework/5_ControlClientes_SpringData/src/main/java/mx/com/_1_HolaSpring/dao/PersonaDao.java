package mx.com._1_HolaSpring.dao;

import mx.com._1_HolaSpring.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/*La ventaja de extender de CrudRepository es que cualquier clase Dao podremos extender de esta interfaz
que ya no tendremos que crear los metodo listar insertar actualizar y eliminar por que esta interfaz ya lo hara */
                //espesificamos que trabajaremos con (Objeto, tipo de  llave primaria)
public interface PersonaDao extends CrudRepository<Persona, Long>{
    /*Utilizaremos el repositorio de Spring Para crear nuestra clase de repositorio basta con hacer lo siguiente */
    
    /*Otra ventaja es que no tenemos que crear una implementacion de esta interface si no que Spring boot ya creara 
    la implementacion por default y los metodos ya estan creados por lo tanto no  hay que hacer nada 
    pero si queremos agregar otro metodo personalizado podemos agregarlo en esta interfaz*/
    
}
