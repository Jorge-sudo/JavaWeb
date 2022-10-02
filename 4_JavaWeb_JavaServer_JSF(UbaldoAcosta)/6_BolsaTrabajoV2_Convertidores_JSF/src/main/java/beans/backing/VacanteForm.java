package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named 
@RequestScoped
public class VacanteForm {
    
    //Agregamos la inyeccion del objeto candidato del otro javaBean
    @Inject //Con esto podemos utilizar el obejeto de Candidato
    private Candidato candidato;
    
    Logger log = LogManager.getRootLogger();
    
    public VacanteForm(){
        log.info("Creando el Objeto VacanteForm");
    }
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    //Haremos un reedireccionamiento a otra pagina
    public String enviar(){
        if(this.candidato.getNombre().equals("Juan")){
            if(this.candidato.getApellido().equals("Perez")){
                String msg = "Gracias, pero Juan Perez ya trabaja con nosotros.";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg,msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componetId  = null;//Este mensaje va ser de tipo global
                facesContext.addMessage(componetId, facesMessage);//La primera parte es null por que es global 
                return "index";
            }
            log.info("Entrando al caso de exito");
            /*Si el nombre es igual a juan y Es un exito entonces se redirigira a la pagina "exito.xhtml", pero 
            no es necesario que escribamos la extencion "xhtml"*/
            return "exito";
        }else{
            log.info("Entrando al caso de fallo");
            return "fallo";
        }
    }
}
