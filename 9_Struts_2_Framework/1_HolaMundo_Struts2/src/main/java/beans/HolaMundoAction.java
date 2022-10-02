package beans;

import org.apache.logging.log4j.*;

public class HolaMundoAction {
    
    //Lo unico que debe  tener nuestra clase accion es la impementacion de un metodo 
    Logger log = LogManager.getLogger(HolaMundoAction.class);
    
    //Agregamos un atributo que estaremos utilizando desde el JSP
    private String saludosAtr;
    
    //Este es el metodo que va ejecutar el Framework de Struts cuando se ejecute esta clase java
    public String execute(){
        log.info("Ejecutando metodo execute desde struts 2");
        this.saludosAtr = "Adios desde Struts 2";
        return "exito";
    }

    public String getSaludosAtr() {
        return saludosAtr;
    }

    public void setSaludosAtr(String saludosAtr) {
        this.saludosAtr = saludosAtr;
    }
    
}
