package mx.com.gm.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import mx.com.gm.datos.PersonaDao;
import mx.com.gm.dominio.Persona;

@Stateless
@Path("/personas") //Para comunicarnos a este servicio este es el path
public class PersonaServiceRS {
    @Inject
    private PersonaDao personaDao;
    
    //Metodo para encontrar todas las personas
    @GET
    @Produces(value = MediaType.APPLICATION_JSON) //Este servicio devolvera archivo JSON
    public List<Persona> listarPersonas(){
        //podriamos retornar directamente la lista de personas pero enviaremos antes el dato a la consola
        List<Persona> personas = personaDao.encontrarTodasPersonas();
        System.out.println("Personas encontradas: " + personas);
        return personas;
    }
    
    //metodo de encontrar las personas por ID
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}") //Hace referencia al path de: /personas/{id}, ejm. /personas/1
    public Persona encontrarPersona(@PathParam("id") int id ){
        Persona persona = personaDao.encontrarPersonaPorId(new Persona(id));
        System.out.println("Persona Encontrada: " + persona);
        return persona;
    }
    
    //metodo agregar persona con POST 
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON) //Este metodo consumira JSON
    @Produces(value = MediaType.APPLICATION_JSON) //Producira el objeto persona en formato JSON
    public Persona agregarPersona(Persona persona){
        personaDao.insertarPersona(persona);
        System.out.println("Persona Agregada: "+ persona);
        return persona;
    }
    
    //Agregamos el metodo de actualizar persona PUT
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON) //Este metodo consum
    @Produces(value = MediaType.APPLICATION_JSON) //Producira el objeto persona en formato JSONira JSON
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada){
        Persona persona = personaDao.encontrarPersonaPorId(new Persona(id));
        if(persona != null){
            personaDao.actualizarPersona(personaModificada);
            System.out.println("Persona modificada: " + personaModificada);
            return Response.ok().entity(personaModificada).build(); //Responsemos con la persona modificada
        }
        return Response.status(Status.NOT_FOUND).build();
    }
    
    //Metodo para eliminar persona 
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON) //Producira el objeto persona en formato JSONira JSON
    @Path("{id}")
    public Response eliminarPersona(@PathParam("id") int id){
        personaDao.eliminarPersona(new Persona(id));
        System.out.println("Persona Eliminada con el ID: " + id);
        return Response.ok().build();//build contruir persona
    }
}
