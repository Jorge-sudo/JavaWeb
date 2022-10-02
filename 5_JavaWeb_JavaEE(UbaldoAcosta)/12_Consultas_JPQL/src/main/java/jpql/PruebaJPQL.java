package jpql;

import dominio.*;
import java.util.*;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class PruebaJPQL {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        /*Haremos consultas desde recuperar 1 objeto hasta una lista de Objetos y mas */
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null ;
        Iterator iter = null; //Lo utilizaremos para iterar elementos de una collection
        Object[] tupla = null ;
        List<String> nombres = null;
        List<Usuario> usuarios = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPu");
        EntityManager em = emf.createEntityManager();
        
        //Como seran consultas no realizaremos 1 transaccion
        
        //1. Consulta de todos los objetos de tipo persona
        log.debug(" 1. Consulta de todas las personas");
        jpql = "SELECT p FROM Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //2. Consulta filtrando una persona utilizando una llave primaria 
        log.debug("Consulta de la persona con id = 1");
        jpql = "SELECT p FROM Persona p WHERE p.idPersona = 1";
        persona = (Persona) em.createQuery(jpql).getSingleResult();//Con el cast convertimos Object a Persona
        //log.debug(persona);
        
        //3.Consulta filtrando por nombre
        jpql = "SELECT p FROM Persona p WHERE p.nombre = 'Jorge'";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //4.Consultaremos datos individuales por lo tanto creamos un arreglo se conoce como tupla
        log.debug("Consulta de datos individuales, se crea un arreglo (tupla) de tipo object de 3 columnas");
        jpql = "SELECT p.nombre AS Nombre, p.apellido AS Apellido, p.email AS Email FROM Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();//Con iterador iteramos los elementos 
        //Con el ciclo while iteramos cada uno de los elementos 
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            String nombre =  (String) tupla[0];
            String apellido = (String) tupla[1];
            String email = (String) tupla[2];
            //log.debug("Nombre: "+ nombre+", Apellido: "+ apellido +", Email: "+ email);
        }
        
        //5. Obtenemos el objeto persona y el id, se crea un arreglo de tipo Object con 2 columnas
        log.debug("Obtenemos el objeto persona y el id, se crea un arreglo de tipo Object con 2 columnas");
        jpql = "SELECT p, p.idPersona FROM Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            //log.debug("Objecto Persona: " + persona);
            //log.debug("id persona: " + idPersona);
        }
        
        //6. Consulta de todas las personas
        //Creamos un objeto de tipo persona pero solo con el campo de id
        log.debug("6. Consulta de todas las personas");
        jpql = "SELECT new dominio.Persona(p.idPersona) FROM Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //7. Regresa el valor minimo y maximo del iDpersona (scaler result)
        log.debug("Regresa el valor minimo y maximo del iDpersona (scaler result)");
        jpql = "SELECT min(p.idPersona) AS MinId, max(p.idPersona) as MaxId, count(p.idPersona) AS Contador FROM Persona p";
        //Iteramos ya que nos regresara una tupla de elementos 
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            Integer idMin = (Integer) tupla[0];
            Integer idMax = (Integer) tupla[1];
            Long count = (Long) tupla[2];
            //log.debug("idMin: " + idMin + ", idMax: "+ idMax + ", count: "+ count);
        }
        
        //8. Cuenta los nombres de las personas que son distintos 
        log.debug("8. Cuenta los nombres de las personas que son distintos");
        jpql = "SELECT count(distinct p.nombre) FROM Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        //log.debug("nro. de personas con nombre distinto: "+ contador);
        
        //9. Concatenamos y convertimos a mayusculas el nombre y apellido
        log.debug("9. Concatenamos y convertimos a mayusculas el nombre y apellido");
        jpql = "SELECT CONCAT (p.nombre, ' ', p.apellido) AS Nombre FROM Persona p";
        nombres = em.createQuery(jpql).getResultList();
        for(String nombreCompleto: nombres){
            //log.debug(nombreCompleto);
        }
        
        //10.Obtiene el objeto persona con id igual al parametro proporcionado
        log.debug("10.Obtiene el objeto persona con id igual al parametro proporcionado");
        int idPersona = 2;
        jpql = "SELECT p FROM Persona p WHERE p.idPersona = :id";
        q = em.createQuery(jpql);
        q.setParameter("id", idPersona);
        persona = (Persona) q.getSingleResult();
        //log.debug(persona);
        
        //11. Obtiene las personas que contengan una letra a en el nombre sin importar si es mayuscula o minuscula
        log.debug("11. Obtiene las personas que contengan una letra a en el nombre sin importar si es mayuscula o minuscula");
        jpql = "SELECT p FROM Persona p WHERE UPPER(p.nombre) LIKE (:parametro)" ;
        String parametro = "%a%";//es el caracter que utilizamos para la sentencia LIKE
        q = em.createQuery(jpql);
        q.setParameter("parametro", parametro);
        personas = q.getResultList();
        //mostrarPersonas(personas);
        
        //12. Uso de between
        log.debug("Uso de between");
        jpql = "SELECT p FROM Persona p WHERE p.idPersona BETWEEN 1 AND 4";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //13. Uso de l ordenamiento
        log.debug("13. Uso de l ordenamiento"); //DESC=Desendente O ASC=Ascendente
        jpql = "SELECT p FROM Persona p WHERE p.idPersona > 3 ORDER BY p.nombre ASC, p.apellido ASC";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        /*14.  Esta funcionalidad depende de la base de datos ya que no todas soportan subQuerys las que soportan son
        MysSQL Oracle PostgreSQL y SQLServer, ya que estas son una consulta dentra de otra
        */ 
        log.debug("Uso de SubQuery");
        jpql = "SELECT p FROM Persona p WHERE p.idPersona IN(SELECT MIN(p1.idPersona) FROM Persona p1)";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        /*15. Uso de JOIN y LAZY LOADING esto depende mucho de que metodo este definido lazy=manera_retardada  
        que es por defaul eager=manera directa pero pesada*/
        log.debug("15. Uso de JOIN con LAZY loading");
        jpql = "SELECT u FROM Usuario u JOIN u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
        
        /*16. Uso de LEFT JOIN con Eager Loading*/
        log.debug("16. Uso de LEFT JOIN con Eager Loading*/");
        jpql = "SELECT u FROM Usuario u LEFT JOIN FETCH u.persona";//con fetch realizamos de tipo EAGER
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona persona:personas){
            log.debug(persona);
        }
    }

    private static void mostrarUsuarios(List<Usuario> usuarios) {
        for(Usuario u:usuarios){
            log.debug(u);
        }
    }
    
}
