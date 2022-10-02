package mx.com._1_HolaSpring.servicio;

import java.util.List;
import mx.com._1_HolaSpring.domain.Persona;

public interface PersonaService {
    
    public List<Persona> listarPersonas();
    
    public void guardar(Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
    
}
