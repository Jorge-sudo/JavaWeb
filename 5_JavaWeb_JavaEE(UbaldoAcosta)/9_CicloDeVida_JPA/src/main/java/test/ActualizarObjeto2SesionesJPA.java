package test;

import dominio.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class ActualizarObjeto2SesionesJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Paso 1. Iniciamos transaccion
        tx.begin();
        log.debug("Iniciando Transaccion");
        
        /* Paso 2. Ejecutamos el SQL SELECT para encontrar el objeto que queremos actualizar y el id proporcionado debe
        existir en la base de datos */
        
        Persona persona = em.find(Persona.class, 1);
        log.debug("buscando persona con id 1 ");
        
        //Paso 3. termina la transaccion 1 
        tx.commit();//Aqui es donde se guarda en la base de datos 
        log.debug("Hacemos el 1 commit ");
        
        //Objeto en estado detached
        log.debug("Objeto recuperado - estado detached: " + persona);
        
        //paso 4. modificamos persona 
        persona.setApellido("Juarez");
        log.debug("Modificamos el Apellido de persona ");
        
        //paso 5. Iniciamos transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        log.debug("Iniciamos la 2 transaccion");
        
        //paso 6. hacemos el update 
        /*Merge hace la comparacion con el objeto en memoria y hace el cambio */
        em.merge(persona);
        log.debug("Agregamos la nueva persona a actualizar");
        
        /*Este metodo vacia toda la transaccion 1 y despues podemos seguir trabajando con la misma transaccion sin
        necesidad de crear la transaccion 2 */
        //em.flush();
        
        //paso 7. termina transaccion 2
        tx2.commit();
        log.debug("Realizamos el 2 commit ");
        
        //obejto estado de ditache
        log.debug("Objeto recuperado: "+ persona);
        
        
        //cerramos el entity manager
        em.close();
        log.debug("Cerramos el EntityManager ");
    }
}
