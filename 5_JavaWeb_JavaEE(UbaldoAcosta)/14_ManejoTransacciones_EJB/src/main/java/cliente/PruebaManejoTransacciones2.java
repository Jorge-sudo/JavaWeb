package cliente;

import dominio.Persona;
import javax.ejb.EJB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import servicio.PersonaService;

public class PruebaManejoTransacciones2 {
    static Logger log = LogManager.getRootLogger();
    @EJB
    static PersonaService pc;
    
    public static void main(String[] args) {
        log.debug("Iniciando prueba Manejo transaccional PersonaService");
        //Buscar un objeto persona
        Persona persona1 = pc.encontrarPersonaPorId(new Persona(1));
        log.debug("Persona recuperada:" + persona1);
        //Cambiar el apellido persona
        //persona1.setApellido("cambio con error....................................................................................");
        persona1.setApellido("Perez");
        pc.modificarPersona(persona1);
        log.debug("Objeto modificado:" + persona1);
        log.debug("Fin prueba EJB transaccional");
        
    }

}
