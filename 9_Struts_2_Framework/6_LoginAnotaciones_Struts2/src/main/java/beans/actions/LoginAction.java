package beans.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
/*Estas anotaciones remplazan los archivos XML esto se implementa en struts2*/
//name=success si todo sale bien si el acceso es otorgado
//location si se logra el exito entonces se redirijira  a la direccion de login.jsp
@Result(name="success", location="/WEB-INF/content/login.jsp") //resultado
public class LoginAction extends ActionSupport {
    
    /*Este es el nombre de la accion que se realizara si se llama esta action */
    @Action("login") //action
    @Override
    public String execute(){
        return SUCCESS;
    }
    
}
