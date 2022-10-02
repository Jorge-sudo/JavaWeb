package mx.com.gm.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.com.gm.dominio.Persona;

/* Esta clase debe ser EJB para que pueda injectarse */
@Stateless
public class PersonaDaoImpl implements PersonaDao {
     //Injectamos la unidad de persistencia 
    @PersistenceContext(unitName = "PersonaPU") //Esto es el nombre de la persistencia
    EntityManager em; //Con esta clase ya podemos interactuar en nuestra base de datos 

    @Override
    public List<Persona> encontrarTodasPersonas() {
        /*Utilizaremos  el Query que ya definimos en la clase persona y nos regresara objetos de tipo persona y no columnas*/
        
        //Escribimos el Query que ya creamos en la clase Persona y nos retornara una List
        return em.createNamedQuery("Persona.encontrarTodasPersonas").getResultList(); 
    }
    
    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        /* Aqui definimos el metodo buscar por ID (Obejto, Id)*/
        return em.find(Persona.class, persona.getIdPersona());
    }
    
    @Override
    public void insertarPersona(Persona persona) {
        em.persist(persona);//Esto es todo para guardar informacion de la base de datos 
        em.flush();//Con esta linea se ejecuta el inser y se recupera la persona con el id
    }

    @Override
    public void actualizarPersona(Persona persona) {
        /*El metodo merge se encarga de sincronizar y detectar cualquier cambio y depende a eso si actualizar o no  */
        em.merge(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        /*Primero se actualiza-marge  el estado del objeto y luego remover-eliminar */
        em.remove(em.merge(persona));
    }
    
}
