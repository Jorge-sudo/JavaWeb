package servicio;

import datos.PersonaDao;
import dominio.Persona;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "servicio.PersonaServiceWs")//Agregamos la direccion de la interfaz a implementar
public class PersonaServiceImpl implements PersonaService, PersonaServiceWs {

    /*Injectamos la capa de Datos y utilizamos la clase PersonaDao */
    @Inject //Con esto ya tenemos acceso hacia la capa de datos 
    private PersonaDao personaDao;

    // con esta variable de contexto podremos hacer rollback de nuestra transaccion
    @Resource
    private SessionContext contexto;

    
    //Este metodo ya se esta exponiendo para nosotros la podamos consumir 
    //sin envargo tenemos que convertir la entidad persona a XML con el API JAX-WS eso configuramos en la clase persona
    @Override
    public List<Persona> listarPersonas() {
        return personaDao.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return personaDao.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return personaDao.findPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        /*Esto se puede hacer en cualquier metodo que utilize una transaccion*/
        try {
            personaDao.updatePersona(persona);
        } catch (Throwable t) {
            //ya que throwable es la clase padre de todas la excepciones en java
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
        /*Esto ya es suficiente para que el rollback se ejecute si es que ocurre algun error*/
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }

}
