package mx.com.gm.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import mx.com.gm.capadatos.domain.Persona;
import mx.com.gm.capaservicio.PersonaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonasAction extends ActionSupport {

    private List<Persona> personas;

    private Persona persona;

    @Autowired
    private PersonaService personaService;

    Logger log = LogManager.getLogger(PersonasAction.class);

    @Action(value = "/listar", results = {
        @Result(name = "personas", location = "/WEB-INF/content/personas.jsp")})
    public String listar() {
        this.personas = personaService.listarPersonas();
        return "personas";
    }

    @Action(value = "/agregarPersona", results = {
        @Result(name = "persona", location = "/WEB-INF/content/persona.jsp")})
    public String agregar() {
        //Creamos un nuevo objeto de tipo persona
        persona = new Persona();
        return "persona";
    }

    @Action(value = "/editarPersona", results = {
        @Result(name = "persona", location = "/WEB-INF/content/persona.jsp")})
    public String editar() {
        persona = personaService.recuperarPersona(persona);
        return "persona";
    }

    @Action(value = "/eliminarPersona", results = {
        @Result(name = "success", location = "listar", type = "redirect")})
    public String eliminar() {
        //Recuperamos el objeto persona, ya que solo tenemos el idPersona
        log.info("Metodo eliminar persona antes de recuperar:" + persona);
        persona = personaService.recuperarPersona(persona); //revisar si se puede quitar el == y sigue funcionando, por referencia
        log.info("Metodo eliminar persona despues de recuperar:" + persona);
        personaService.eliminarPersona(persona);
        return SUCCESS;
    }

    //No basta con mandar al JSP, sino a la accion de listar
    //por ello redireccionamos a la accion listar
    @Action(value = "/guardarPersona", results = {
        @Result(name = "success", location = "listar", type = "redirect")})
    public String guardar() {
        //Diferenciamos la accion de agregar o editar con el idPersona
        if (persona.getIdPersona() == null) {
            personaService.agregarPersona(persona);
        } else {
            personaService.modificarPersona(persona);
        }
        return SUCCESS;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}