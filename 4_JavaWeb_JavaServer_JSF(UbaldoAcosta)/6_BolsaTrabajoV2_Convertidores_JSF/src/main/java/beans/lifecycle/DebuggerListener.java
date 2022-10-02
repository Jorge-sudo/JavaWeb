package beans.lifecycle;

import javax.faces.event.*;
import org.apache.logging.log4j.*;

public class DebuggerListener implements javax.faces.event.PhaseListener {
    
        /*/Esto es mas que todo para saber en que fase estamos ya que en JavaServerFaces tenemos 6 faces y con esto
        Sabremos en que face estamos entre las 6 faces esta 
    
        1_RESTAURAR VISTA 
        2_APLICAR VALORES DE SOLICITUD
        3_VALIDACIONES DE PROCESOS 
        4_ACTUALIZAR VALORES DE MODELO 
        5_INVOCAR APLICACIÓN 
        6_RENDERIZAR RESPUESTA   */

    Logger log = LogManager.getRootLogger();
    @Override
    public void beforePhase(PhaseEvent event) {
        //Si esta habilitado este nivel enviamos mensaje y con getPhaseId mandamos en que etapa estamos
        if(log.isInfoEnabled()){
            log.info("Antes de la fase: " + event.getPhaseId().toString());
        }
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        //Si el nivel de info de Logj4 esta Habilitado se enviara el mensaje a la consola
        if(log.isInfoEnabled()){
            log.info("Despues de la fase: " + event.getPhaseId().toString() );
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
