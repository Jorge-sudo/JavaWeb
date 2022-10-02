package test;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Persona;

public class HolaMundoHibernate {
    public static void main(String[] args) {
        String hql = "SELECT p FROM Persona p";//Query HQL de hibernate 
        //Este es el objeto de fabrica 
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager entityManager = fabrica.createEntityManager();
        
        Query query = entityManager.createQuery(hql);//Esto nos regresa objetos de tipo persona
        List<Persona> personas = query.getResultList();//ResultList no regresa una lista 
        for(Persona p: personas){
            System.out.println("Persona:" + p);
        }
    }
}
