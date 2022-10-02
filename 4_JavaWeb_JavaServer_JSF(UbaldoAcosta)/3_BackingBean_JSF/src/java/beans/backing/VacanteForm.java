package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named 
@RequestScoped
public class VacanteForm {
    
    //Agregamos la inyeccion del objeto candidato del otro javaBean
    @Inject //Con esto podemos utilizar el obejeto de Candidato
    private Candidato candidato;
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    //Haremos un reedireccionamiento a otra pagina
    public String enviar(){
        if(this.candidato.getNombre().equals("juan")){
            return "exito";
        }else{
            return "fallo";
        }
    }
}
