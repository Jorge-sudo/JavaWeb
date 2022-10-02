package servicio;

import dominio.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

@Path("/personas") //Este es el path para poder acceder a este web services
@Stateless //Esta clase sera un EJB para que podamos injectar personaService
public class PersonaServiceRS {

    @Inject //Injectamos PersonaService 
    private PersonaService personaService;

    //Agregamos metodos GET POST DELETE PUT
    //Este metodo solo se encarga de listar personas o recuperar personas por ID
    @GET //Este metodo es por Default y se le llamara primero con /personas/
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //Espesificamos que tipo de informacion va regresar XML y JSON como son varios lo hacemos con {} si es uno no utilizamos {}
    public List<Persona> listarPersonas() {
        return personaService.listarPersonas();
    }

    //Ahora el metodo encontrar persona por ID
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}") //Este subpath es para recuperar personas por id sera /personas/{id}
    public Persona encontrarPersonaPorId(@PathParam("id") int id) { //Aqui sacamos el parametro del path para buscar por ID
        return personaService.encontrarPersonaPorId(new Persona(id));
    }

    //Ahora definimos el metodo de agregar persona POST
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})//Produce
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //Esto es para que pueda consumir cuando enviamos un JSON a este URL se registrara una persona
    public Response agregarPersona(Persona persona) {
        try {
            personaService.registrarPersona(persona);
            /*Enviamos la respuesta de 200 OK , luego con entity agregamos el objeto Persona para que pueda contruir
        la respuesta mandando a llamar el metodo buildbuild para que se 
        pueda contruir la respuesta */
            return Response.ok().entity(persona).build();
        } catch (Exception e) {
            //Si ocurre algun error enviamos respuesta al cliente
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Agregamos el metodo de Modificar persona PUT consume y produce igual que POST
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})//Produce
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //Esto es para que pueda consumir cuando enviamos un JSON a este URL se registrara una persona
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada) {
        try {
            Persona persona = personaService.encontrarPersonaPorId(new Persona(id));
            if (persona != null) {
                personaService.modificarPersona(personaModificada);
                return Response.ok().entity(personaModificada).build();
            } else {
                return Response.status(Status.NOT_FOUND).build(); //NOT_FOUND = No existe
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build(); //Si ocurre un error 
        }
    }
    
    //Agregamos el metodo DELETE 
    @DELETE
    @Path("{id}")
    public Response eliminarPersonaPorId(@PathParam("id") int id){
        try{
        personaService.eliminarPersona(new Persona(id));
        return Response.ok().build();
        }catch (Exception e){
            e.printStackTrace(System.out);
            return Response.ok().status(404).build(); //NOT_FOUND = 404
        }
    }

}
