package Criteria;

import dominio.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import org.apache.logging.log4j.*;

public class PruebaApiCriteria {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPu");
        EntityManager em = emf.createEntityManager();
        
        //Estas variables son para el API de Criteria
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        //Query utilizando el API de Criteria
        //1. Consulta de todas las personas
        
        //Paso1. El objeto Entity manager crea instancia CriteriaBuilder
        cb = em.getCriteriaBuilder();
        //paso2. Secrea un objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        
        //Paso3 Creamos el objeto reiz de query
        fromPersona = criteriaQuery.from(Persona.class);
        
        //Paso4 Seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);
        
        //Paso5. Creamos el tipo de query typeSafe
        query = em.createQuery(criteriaQuery);
        
        //Paso6. Ejecutamos la consulta
        personas = query.getResultList();
        
        //mostrarPersonas(personas);
        
                //AQUI EJECUTAMOS EL 2 QUERY LO HAREMOS EL MISMO PERO CON DIFERENTES OPCIONES
                
        //2-a. Consulta de la Persona con ID = 2
        //jpql = "SELECT p FROM Persona p WHERE p.idPersona = 1"
        log.debug("2-a. Consulta de la Persona con ID = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 2));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        //log.debug(persona);
        
        //2-b. Consulta de la persona con id = 2
        log.debug("2-b. Consulta de la persona con id = 2");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);
        
        //La clase predicate nos permite agregar varios criterios dinamicamente 
        List<Predicate> criterios = new ArrayList<Predicate>();
        //Verificamos si tenemos criterios que agregar 
        Integer idPersonaParam = 1;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));
        
        //Agregamos los criterios
        if(criterios.isEmpty()){
            throw new RuntimeException("Sin criterios");
        }else if(criterios.size() == 1){
            criteriaQuery.where(criterios.get(0));
        }else{
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        
        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);
        
        //Ejcutamos el Query 
        persona = query.getSingleResult();
        log.debug(persona);
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona p:personas){
            log.debug(p);
        }
    }
}
