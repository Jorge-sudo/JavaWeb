package cascada;

import dominio.*;
import javax.persistence.*;
import org.apache.logging.log4j.*;


public class PersistenciaCascadaJPA {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        log.debug("Iniciamos transaccion");
        //Creamos Objeto 
        Persona persona1 = new Persona("Hugo", "Hernandez", "hEernandes@gmail.com", "5546789");
        log.debug("Creamos Objeto persona");
        
        //Creamos Usuario, que tendra el objeto persona dentro 
        Usuario usuario = new Usuario("hernandez12", "12345", persona1);
        log.debug("Creamos Objeto Usuario");
        
        //Persistimos el Objeto Usuario 
        em.persist(usuario);//y por automatico se agregara la persona
        log.debug("Persistimos Usuario con Persona");
        
        //Hacemos commit para que se guarden los cambios en la base de datos 
        tx.commit();
        log.debug("Realizamos el cambio=Commit");    
       
        //objetos en estado de Ditache
        log.debug("Objeto persistido persona: "+ persona1);
        log.debug("Objeto persistido usuario: "+ usuario);
        
        em.close();
    }
}
