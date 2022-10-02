package beans.struts2;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;

/*no es necesario extender esta clase pero tiene varias ventajas */
public class MostrarPersonaAction extends ActionSupport {
    
    //Lo unico que debe  tener nuestra clase accion es la impementacion de un metodo 
    Logger log = LogManager.getLogger(MostrarPersonaAction.class);
    
    //Agregamos un atributo que estaremos utilizando desde el JSP
    private String nombre;
    
    //Este es el metodo que va ejecutar el Framework de Struts cuando se ejecute esta clase java
    @Override
    public String execute(){
        log.info("El nombre es :" + this.nombre);
        return SUCCESS;
    }
    
    /*En este caso en convenciones como estamos cambiando todos los nombres como son: de paquete clases y demas,
    ahora eliminamos la configuracion de struts.xml ya que no lo necesitaremos pero si necesitaremos agregar unas librerias 
    mas para las convenciones */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
