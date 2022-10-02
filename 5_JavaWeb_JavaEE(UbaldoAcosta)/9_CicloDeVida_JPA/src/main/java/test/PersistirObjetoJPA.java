package test;

import dominio.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class PersistirObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Ahora se inicia la transaccion
        
        //paso 1. Crear nuevo Obejto
        //El Objeto esta en estado transitivo
        Persona persona1 = new Persona("Pepito", "Canchita", "pCachita@gmail.com", "12332457");
        log.debug("Obejto Iniciado");
        
        //Paso 2. Iniciamos transaccion
        tx.begin();
        log.debug("Iniciando Transaccion");
        
        //Paso3. Ejecutamos el SQL de INSERT
        em.persist(persona1);
        log.debug("Objeto persistido -  aun sin commit : " + persona1);
        
        //Paso 4. Hacemos commit/Rollback
        tx.commit();//Aqui es donde se guarda en la base de datos 
        
        //Objeto en estado detached
        log.debug("Objeto persistido - estado detached: " + persona1);
        
        //cerramos el entity manager
        em.close();
    }
}
