package beans.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;

public class LoginAction extends ActionSupport {
    
    Logger log = LogManager.getLogger(LoginAction.class);
    
    private String usuario;
    private String password;
    
    @Override
    public String execute(){
        return SUCCESS;//SUCCESS Esta por default significa que se puede pasar al siguiente jsp sin nigun problema
        /*En cambio con INPUT quiere decir que se pase al siguiente formulario si es que hubo algun error en el formulario */
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
