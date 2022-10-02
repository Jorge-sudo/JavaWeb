package mx.com.gm.actions;

import com.opensymphony.xwork2.ActionSupport;
import mx.com.gm.model.Persona;
import org.apache.logging.log4j.*;

/*El concepto de OGNL es que nos permite acceder a las clases de struts 2 desde un jsp */
public class PersonasAction extends ActionSupport {

    Logger log = LogManager.getLogger(PersonasAction.class);

    private Persona persona;

    @Override
    public String execute() {
        if(this.persona != null){
            //Si la persona es diferente a null enviamos la persona
            log.info("\n");
            log.info("persona:" + persona);
        }
        else{
            //sino 
            log.info("Persona con valor nulo");
        }
        return SUCCESS;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
