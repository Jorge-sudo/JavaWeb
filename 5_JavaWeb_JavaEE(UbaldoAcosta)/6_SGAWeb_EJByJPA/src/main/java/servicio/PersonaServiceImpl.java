package servicio;

import datos.PersonaDao;
import dominio.Persona;
import java.util.List;
import javax.inject.Inject;

public class PersonaServiceImpl implements PersonaService {

    /*Injectamos la capa de Datos y utilizamos la clase PersonaDao */
    @Inject //Con esto ya tenemos acceso hacia la capa de datos 
    private PersonaDao personaDao;
    
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
        personaDao.updatePersona(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }
    
}
