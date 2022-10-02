package servicio;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import domain.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PersonaServiceImpl implements PersonaService {

    @Override
    public List<Persona> listarPersonas() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Juan", "Perez", "jperez@gamil.com", "5512738"));
        personas.add(new Persona(2, "Jorge", "Arone", "jarone123@gamil.com", "5566738"));
        return personas;
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return null;
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return null;
    }

    @Override
    public void registrarPersona(Persona persona) {
    }

    @Override
    public void modificarPersona(Persona persona) {
    }

    @Override
    public void eliminarPersona(Persona persona) {
    }
    
}
