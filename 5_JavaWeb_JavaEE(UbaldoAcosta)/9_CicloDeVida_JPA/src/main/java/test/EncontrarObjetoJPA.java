package test;

import dominio.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class EncontrarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Paso 1. Iniciamos transaccion
        tx.begin();
        log.debug("Iniciando Transaccion");
        
        /* Paso 2. Ejecutamos el SQL SELECT con el ID=1 ya que existe en la base de datos y si ponemos un id que no 
        existe nosregresara un valor null*/
        Persona persona = em.find(Persona.class, 1);
        
        //Paso 3. termina la transaccion
        tx.commit();//Aqui es donde se guarda en la base de datos 
        
        //Objeto en estado detached
        log.debug("Objeto recuperado - estado detached: " + persona);
        
        //cerramos el entity manager
        em.close();
    }
}
