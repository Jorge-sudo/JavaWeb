package test;

import dominio.Persona;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class PruebaRestWS {
    /*Ahora agregamos el concepto de seguridad */
    public static void main(String[] args) {
        
                //Con esto pasaremos la seguridad que requiere el EJB
        //Pasaremos la autenticacion HTTP
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive().credentials("admin", "admin").build();
        //Realizamos la configuracion de cliente 
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);
        
        Client cliente  = ClientBuilder.newClient(clientConfig);
        
        //Hacemos la llamada a nuestro client
        WebTarget webTarget = cliente.target("http://localhost:8080/1_WebServices_JAX_RS/webservices").path("/personas");
        //proporcionamos un idPersona valido
        Persona persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada: "+ persona );
    }
}
