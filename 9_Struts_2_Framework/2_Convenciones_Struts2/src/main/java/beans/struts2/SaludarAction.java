package beans.struts2;

import org.apache.logging.log4j.*;

public class SaludarAction {
    
    //Lo unico que debe  tener nuestra clase accion es la impementacion de un metodo 
    Logger log = LogManager.getLogger(SaludarAction.class);
    
    //Agregamos un atributo que estaremos utilizando desde el JSP
    private String saludosAtr;
    
    //Este es el metodo que va ejecutar el Framework de Struts cuando se ejecute esta clase java
    public String execute(){
        log.info("Ejecutando metodo execute desde struts 2");
        this.saludosAtr = "Hola desde Struts 2 con convenciones ";
        return "exito";
    }

    public String getSaludosAtr() {
        return saludosAtr;
    }

    public void setSaludosAtr(String saludosAtr) {
        this.saludosAtr = saludosAtr;
    }
    
    /*En este caso en convenciones como estamos cambiando todos los nombres como son: de paquete clases y demas,
    ahora eliminamos la configuracion de struts.xml ya que no lo necesitaremos pero si necesitaremos agregar unas librerias 
    mas para las convenciones */
}
