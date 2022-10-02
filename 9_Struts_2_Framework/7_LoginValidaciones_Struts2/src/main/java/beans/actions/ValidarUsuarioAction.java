package beans.actions;

import static com.opensymphony.xwork2.Action.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;
import org.apache.struts2.convention.annotation.*;

@Results({
    @Result(name="success", location="/WEB-INF/content/bienvenido.jsp"),
    @Result(name="input", location="/WEB-INF/content/login.jsp")
})
public class ValidarUsuarioAction extends ActionSupport {

    Logger log = LogManager.getLogger(LoginAction.class);

    private String usuario;
    private String password;

    @Action("validarUsuario")
    @Override
    public String execute() {
        if ("admin".equals(this.usuario)) {
            //Este metodo se encuentra definido dentro de la clase ActionSuport asi que para utilizar esto debemos extender de ello
            //este metodo nos permite enviar informacion al jsp 
            addActionMessage(getText("usuario.valido"));
            return SUCCESS;
        } else {
            return INPUT;
        }
    }
    
    /*Escribimos el metodo validate que esta definido en la clase actionSuport 
    que nos persmite validar datos*/
    @Override
    public void validate(){
        if(this.usuario == null || "".equals(this.usuario.trim())){
            //Si es usuario esta vacio o es igual a null enviamos el mensaje de error en el campo de usuario
            addFieldError("usuario",getText("val.usuario"));//enviamos este error al JSP 
        }else if(!usuarioValido()){
            /*Este metodo tambien esta definido en la clase ActionSuport y manda un error directamente */
            addActionError(getText("usuario.invalido"));//Este mensaje es generico y no esta asociado a ningun campo 
        }
        
        if(this.password == null || "".equals(this.password.trim())){
            addFieldError("password", getText("val.password"));
        }else if(this.password.length() < 3){
            //Aqui si el largo de caracteres es menor a 3 entonces enviaremos un error 
            addFieldError("password", getText("val.pass.min.lenght"));//Metodo asociado al campo password 
        }
    }
    
    private boolean usuarioValido(){
        //aqui verificamos si el usuarioValido es igual a "Admin" entonces retornara true o false
        return "admin".equals(this.usuario);
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
