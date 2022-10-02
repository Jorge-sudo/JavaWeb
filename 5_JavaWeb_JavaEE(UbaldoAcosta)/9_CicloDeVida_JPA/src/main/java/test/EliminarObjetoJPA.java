package test;

import dominio.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class EliminarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Paso 1. Iniciamos transaccion
        tx.begin();
        log.debug("Iniciando Transaccion");
        
        /* Paso 2. Ejecutamos el SQL SELECT  */
        Persona persona = em.find(Persona.class, 10);
        log.debug("buscando persona con id 10 ");
        /*Para eliminar en una misma transaccion solo tenemos que hacer lo siguiente */
        //em.remove(persona);
        tx.commit(); //Con esto seria suficiente 
        log.debug("Termina la transaccion 1 ");
        
        //Objeto en estado detached
        log.debug("Objeto recuperado - estado detached: " + persona);
        
        //Iniciamos la segunda transaccion
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        log.debug("Iniciamos la 2 transaccion ");
        
        //paso 5. ejecutamos el SQL DELETE,pero primero haremos un merge para que se sincronize 
        //el objeto en memoria con la base de datos, ya que si no esta sincronizado no encontrara el objeto
        //a eliminar en la base de datos 
        em.remove(em.merge(persona));
        
        tx2.commit();
        log.debug("commit de la segunda transaccion");
        
        //Objeto eliminado esta en memoria pero en la base de datos ya no lo esta 
        log.debug("Objeto eliminado : " + persona);
        
        //cerramos el entity manager
        em.close();
        log.debug("Cerramos el EntityManager ");
        
        /*La relaciones de JPA trabajan con la etidad relacion de la base de datos  
            -Uno_a_Uno=@OneToOne
            -Uno_a_Muchos=@OneToMany
            -Muchoos_a_Uno=@ManyToOne
            -Muchos_a_Muchos=@ManyToMany
        */
    }
}
