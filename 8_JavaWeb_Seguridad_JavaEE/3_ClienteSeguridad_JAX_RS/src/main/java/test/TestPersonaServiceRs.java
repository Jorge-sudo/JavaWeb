package test;

import dominio.Persona;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

public class TestPersonaServiceRs {
    //Variable que vamos a utilizar 
    private static final String URL_BASE = "http://localhost:8080/1_WebServices_JAX_RS/webservices";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
        //Iniciamos el cliente
        cliente = ClientBuilder.newClient();
        
        //Leer una persona (metodo get)
        webTarget = cliente.target(URL_BASE).path("/personas");
        
        //proporcionamos un idPersona valido
        persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada: "+ persona);
        
        //Leer todas las personas  (metodo get con readEntity de tipo List<>)
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});       
        System.out.println("\n Personas recuperadas ");
        imprimirPersonas(personas);
        
        //Agregar una Persona
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Carlos");
        nuevaPersona.setApellido("Miranda");
        nuevaPersona.setEmail("cmiranda@gmail.com");
        nuevaPersona.setTelefono("65436787");
        
        //Agregaremos la persona
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        //Hacemos el POST 
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        //Recuperamos la persona recien agregada para despues modificarla y al final eliminarla 
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona agregada: "+ personaRecuperada);
        
        //modificar persona (metodo PUT)
        //persona recuperada anteriormente
        Persona personaModificar = personaRecuperada;
        personaModificar.setApellido("Ramirez");
        String pathId = "/" +personaModificar.getIdPersona();
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println("response: " + response.getStatus());
        System.out.println("Persona modificada: "+ response.readEntity(Persona.class));
        
        //Eliminar una persona 
        //Persona recuperada anteriormente
        Persona personaEliminar = personaRecuperada;
        String pathEliminarId =  "/"+ personaEliminar.getIdPersona();
        invocationBuilder = webTarget.path(pathEliminarId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        System.out.println("");
        System.out.println("response: "+  response.getStatus());
        System.out.println("Persona Eliminada: "+ personaEliminar);
    }

    private static void imprimirPersonas(List<Persona> personas) {
        for(Persona p: personas){
            System.out.println("Persona: " + p);
        }
    }
    
}
