package testClienteWs;

import clientews.sevicio.Persona;
import clientews.sevicio.PersonaServiceImplService;
import clientews.sevicio.PersonaServiceWs;
import java.util.List;

public class TestPersonaServicesWS {
    public static void main(String[] args) {
        PersonaServiceWs personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
        
        System.out.println("Ejecutando servicio de listar Personas Ws");
        List<Persona> personas = personaService.listarPersonas();
        for(Persona p: personas){
            System.out.println("Persona idPersona : " + p.getIdPersona()+ ", nombre: "+ p.getNombre()
            + ", apellido : "+p.getApellido() + ", email: " + p.getEmail() + ", telefono : "+ p.getTelefono());
        }
        System.out.println("Fin de servicio listar personas WS");
    }
}
