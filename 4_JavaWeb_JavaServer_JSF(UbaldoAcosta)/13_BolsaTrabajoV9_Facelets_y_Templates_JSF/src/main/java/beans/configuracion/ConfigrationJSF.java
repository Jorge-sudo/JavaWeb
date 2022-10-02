package beans.configuracion;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;

/*Configuracion para que reconozca la ultima version de JSF, esto no es necesario para versiones posteriores
de Glasfish de 5.0  para abajo no es necesesario pero de 5.0 para delante si es necesario */

@FacesConfig(
        //Activa CDI build-in, para los beans que vamos a construir
        version = FacesConfig.Version.JSF_2_3
)
@ApplicationScoped
public class ConfigrationJSF {
    
}
