package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado1Persistido {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1. estado transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("clara@gmail.com");
        contacto.setTelefono("11223344");
        
        //2.persistimos el objeto
        em.getTransaction().begin();
        
        em.persist(contacto);
        //Con el commit se guarda la informacion en la base de datos 
        //em.flush(); con esto se sincroniza el objeto con la base de datos 
        em.getTransaction().commit();
        
        //3. detached (separado)
        System.out.println("contacto = " + contacto);
    }
    
}
