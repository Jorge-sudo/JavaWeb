package test;

import dominio.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class ActualizarObjetoSessionLarga {
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
        
        //Objeto en estado detached
        log.debug("Objeto recuperado - estado detached: " + persona);
        
        //paso 3. modificamos persona 
        persona.setApellido("jJuarez");
        //Tenemos la libertad de modificar lo que queramos 
        persona.setEmail("j.juare@gmail.com");//Este email se agregara es el ultimo y diferente al de la base de datos 
        log.debug("Modificamos el Email de persona ");
        
        //Ya no necesitamos el metodo merge para actualizar
       
        //paso 4. hacemos el commit
        tx.commit();//Aqui se hace el update
        log.debug("Realizamos el commit ");
        
        //Objeto modificado
        log.debug("Objeto actualizado : " + persona);
        
        //cerramos el entity manager
        em.close();
        log.debug("Cerramos el EntityManager ");
    }
}
