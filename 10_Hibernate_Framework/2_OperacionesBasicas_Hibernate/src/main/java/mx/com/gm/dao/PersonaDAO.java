package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Persona;

public class PersonaDAO {

    //Variables para comunicarnos con la base de datos 
    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonaDAO() {
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();
    }

    //Este metodo no regresa nada si que lo imprimiremos 
    public void listar() {
        //HQL es muy similar a JPQL
        String hql = "SELECT p FROM Persona p";//Query
        Query query = em.createQuery(hql);
        List<Persona> personas = query.getResultList();//Retorna ua lista de tipo Persona
        for (Persona p : personas) {
            System.out.println("p = " + p);
        }
    }

    /* Como nosotros no estamos trabajando con un servidor entonces debemos abrir y cerrar una transaccion
    en cambio cuando trabajamos un el servidor el servidor se encarga de ello automaticamente */
    public void insertar(Persona persona) {
        try {
            //iniciamos la transaccion
            em.getTransaction().begin();
            //metodo persist es para guardar en la base de datos 
            em.persist(persona);
            //Hacemos commit de la transaccion
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            //Si ocurre algun error entramos a rollback 
            em.getTransaction().rollback();
        }
//        finally{
//            if(em != null){
//                em.close();
//            }
//        }
    }

    public void modificar(Persona persona) {
        try {
            //Iniciamos transaccion
            em.getTransaction().begin();
            //Primero merge sincroniza el objeto con la base de datos y luego actualiza
            em.merge(persona);//merge nos permite modificar algun dato 
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        }//Se cierra la transaccion con finally 
//        finally{
//            if(em != null){
//                em.close();
//            }
//        }
    }

    public Persona buscarPersonaPorId(Persona p) {
                      //Retorna una persona y se inserta el id para buscar la persona con find
        //No es necesario iniciar una transaccion por que solo estamos recuperando informacion no modificando o insertando 
        return em.find(Persona.class, p.getIdPersona());
    }

    public void eliminar(Persona persona) {
        try {
            em.getTransaction().begin();
            /*En eliminar primero hacemos el merge para sincronizar cualquier cambio que tengamos en la base 
            de datos y luego eliminar en el registro esto es debido a que si no tenemos sincronizado con la 
            base de datos entonces no podemos eliminar el registro primero merge luego remove*/
            em.remove(em.merge(persona));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
//        finally{
//            if(em != null){
//                em.close();
//            }
//        }
    }

}
