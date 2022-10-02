package mx.com.gm.test.cascade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;

public class PersistenciaCascadaTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //Creamos los objetos de domicilio contacto y alumno y lo insertarermos los 3
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Nogales");
        domicilio.setNoCalle("10");
        domicilio.setPais("Mexico");
        
        Contacto contacto = new Contacto();
        contacto.setEmail("carlosLara@mail.com");
        contacto.setTelefono("44332211");

        Alumno alumno = new Alumno();
        alumno.setNombre("Carlos");
        alumno.setApellido("Lara");
        //Insertamos en alumno los objetos de domicilio y contacto 
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        
        em.getTransaction().begin();
        em.persist(alumno);
        //Como configuramos en casada entonces se agregaran los 3 objetos a la base de datos 
        em.getTransaction().commit();
        
        System.out.println("alumno = " + alumno);
    }
}
