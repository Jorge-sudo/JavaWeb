package test;

import dominio.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class ClienteEntidadPersona {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        /*En el constructor de createEntityManagerFactory(Nombrede Persistence-unit del archivo persistence.xml)*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPu");
        //Creamos una instancia de la clase Entyty manayer
        EntityManager em = emf.createEntityManager();
        //Abrimos una transaccion para poder trabajar con la base de datos
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        tx.begin();
        
        //No se debe espesificar el id de 
        Persona persona1 = new Persona("Pedro", "Luna", "pLuna@gmail.com", "13132457");
        log.debug("Objeto a persistir : " + persona1);
        
        //persistimos el objeto en la base de datos 
        em.persist(persona1); //Con el metodo persist agregamos objetos a la base de datos 
        
        //Terminamos la transaccion con el commit
        tx.commit();
        
        log.debug("Objeto persistido " + persona1);
        em.close(); //cerramos
    }
}
