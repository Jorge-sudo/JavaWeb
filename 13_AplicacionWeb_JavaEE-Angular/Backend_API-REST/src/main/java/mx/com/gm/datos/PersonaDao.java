package mx.com.gm.datos;

import java.util.List;
import mx.com.gm.dominio.Persona;

public interface PersonaDao {
    
    public List<Persona> encontrarTodasPersonas();
    
    public Persona encontrarPersonaPorId(Persona persona);
    
    public void insertarPersona(Persona persona);
    
    public void actualizarPersona(Persona persona);
    
    public void eliminarPersona(Persona persona);
}
