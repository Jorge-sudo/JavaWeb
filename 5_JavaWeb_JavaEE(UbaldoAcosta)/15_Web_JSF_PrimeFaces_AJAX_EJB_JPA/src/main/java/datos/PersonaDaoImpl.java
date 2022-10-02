package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import dominio.Persona;

/* Esta clase debe ser EJB para que pueda injectarse */
@Stateless
public class PersonaDaoImpl implements PersonaDao {
     //Injectamos la unidad de persistencia 
    @PersistenceContext(unitName = "PersonaPu") //Esto es el nombre de la persistencia
    EntityManager em; //Con esta clase ya podemos interactuar en nuestra base de datos 

    @Override
    public List<Persona> findAllPersonas() {
        /*Utilizaremos  el Query que ya definimos en la clase persona y nos regresara objetos de tipo persona y no columnas*/
        
        //Escribimos el Query que ya creamos en la clase Persona y nos retornara una List
        return em.createNamedQuery("Persona.findAll").getResultList(); 
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        /* Aqui definimos el metodo buscar por ID (Obejto, Id)*/
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        /*Aqui estamos creando un Query para que veamos que por aqui tambien se puede */
        Query query = em.createQuery("FROM Persona p WHERE p.email =: email");
        query.setParameter("email", persona.getEmail());
        /*En la base de datos debemos espesificar que el email es un valor unico con UQ(Unique), para que en 
        este campo no se pueda duplicar valores */
        return (Persona) query.getSingleResult();
    }

    @Override
    public void insertPersona(Persona persona) {
        em.persist(persona);//Esto es todo para guardar informacion de la base de datos 
    }

    @Override
    public void updatePersona(Persona persona) {
        /*El metodo merge se encarga de sincronizar y detectar cualquier cambio y depende a eso si actualizar o no  */
        em.merge(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        /*Primero se actualiza-marge  el estado del objeto y luego remover-eliminar */
        em.remove(em.merge(persona));
    }
    
}
