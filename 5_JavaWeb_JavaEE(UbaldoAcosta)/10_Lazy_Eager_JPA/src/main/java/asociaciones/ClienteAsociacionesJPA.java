package asociaciones;

import dominio.Persona;
import dominio.Usuario;
import java.util.List;
import javax.persistence.*;
import org.apache.logging.log4j.*;


public class ClienteAsociacionesJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPu");
        EntityManager em = emf.createEntityManager();
        
        /*Ahora no iniciaremos una transaccion por que no haremos ningun cambio en la base de datos solo
        haremos un SELECT */
        
        /*Ejecutamos el findAll de la clase persona la cual esta en codigo JPQL y nos regresara Objetos y 
        no columnas */
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        
        //cerramos la conexion
        em.close();
        
        /*Este es el Lazy=Carga retardado primero se hace un SELECT de persona luego se hace otro del Usuario para saber que 
        usuario esta relacionado a tal Persona */
        //Una ve recuperado la clase persona en la lista lo imprimimos 
        for(Persona persona:personas){
            log.debug(" Persona: "+ persona);
            //Recuperamos los usuarios relacionados a cada persona
            for(Usuario usuario:persona.getUsuarioList()){
                log.debug(" Usuario: " + usuario);
            }
        }
        /*Eager=CargaAnticipado recupera todos las personas y usuarios al mismo tiempo, pero demanda mas recursos al
        cargar todos los datos relacionados*/
    }
}