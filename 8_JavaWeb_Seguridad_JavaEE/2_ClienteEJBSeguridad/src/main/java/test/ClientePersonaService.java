package test;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import dominio.Persona;
import java.util.List;
import javax.naming.*;
import servicio.PersonaServiceRemote;

public class ClientePersonaService {
    /*Para que se ejecute este metodo tiene que estar la aplicacion web arriba en el servidor corriendo */
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente ");
        
        //Con esto pasamos la seguridad
        String authFile = "login.conf";
        System.setProperty("java.security.auth.login.config", authFile);
        ProgrammaticLogin programaticLogin = new ProgrammaticLogin();
        programaticLogin.login("admin", "admin".toCharArray()); //Con toCharArray para que se convierta en caracteres
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!servicio.PersonaServiceRemote");
            List<Persona> personas = personaService.listarPersonas();
            for(Persona p: personas){
                System.out.println("Personas: "+p);
            }
            System.out.println("Fin de la llamada desde EJB");
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
        }
        
}
