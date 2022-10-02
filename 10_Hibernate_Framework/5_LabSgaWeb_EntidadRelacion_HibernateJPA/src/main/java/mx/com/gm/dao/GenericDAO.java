package mx.com.gm.dao;

import javax.persistence.*;
/*ESTA CLASE ABSTRACTA ES UNA CLASE BASE PARA TODAS LAS CLASES DAO QUE CREAMOS "LA IDEA ES QUE NO PODAMOS CREAR 
OBJETOS DE ESTA CLASE" LOS ATRIBUTOS SON PARA QUE LOS PODAMOS ACCEDER DIRECTAMENTE DESDE NUESTRAS CLASES HIJAS*/
//Esta abstraccion es para inicializar los metodos 
public abstract class GenericDAO {
    
    protected static EntityManager em;
    private static EntityManagerFactory emf;
    //Nombre de la unidad de persistencia para hacer la conexion a la base de datos 
    private static final String PU = "HibernateJpaPU";
    
    
    //metodo para crear el entity manager si es que no esta creada es el constructor que se inicializara siempre 
    public GenericDAO(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }
    //Aqui devolvemos el entity manager ya creado para hacer el uso de ello para conectarnos a la base de datos 
    protected EntityManager getEntityManager(){
        if(em == null){
            em = emf.createEntityManager();
        }
        return em;
    }
}
