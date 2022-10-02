/*
Sin esta clase el cliente no podra acceder a nuestro servicio */
package mx.com.gm.web;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

//Este es parte de la implementacion del filtro CORS
@Provider
public class CorsFilter implements ContainerResponseFilter{

    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crc1) throws IOException {
        //Aqui definimos la politica de CORSFILTER
        MultivaluedMap<String, Object> headers = crc1.getHeaders();
        //Agregamos mas cabezeros=headers a nuestro mapa
        headers.add("Access-Control-Allow-Origin", "*"); //Espesificamos que URL pueden acceder a nuestro services *(todos)
        //Para que permitamos credenciales como password si deseamos utilizarlo
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Headers", "Origin, X.Requested-With, Content-Type, Accept, Authorization");
        //Espesificamos los servicios que permitiremos
        headers.add("Access-Control-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
    //Si no hacemos esto no podremos comunicarnos desde nuestro cliente de angular
    
}
