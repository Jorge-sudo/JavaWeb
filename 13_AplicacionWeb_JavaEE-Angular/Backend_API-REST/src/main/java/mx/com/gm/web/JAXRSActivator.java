package mx.com.gm.web;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("webservice") //Este path es para acceder a nuestros servicios web 
public class JAXRSActivator  extends Application{
    //Esta clase es para activar el servicio REST
    
    //Y con esto ya podemos acceder a nuestro servicio web JAX-RS
}
