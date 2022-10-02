/*
El cliente es esta misma clase 
 */
package test;

import beans.HolaMundoEjbRemote;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Para mandar a llamar a nuestro EJB vamos a crear nuestro main para poder
 * ejecutar esta clase
 */
public class testHolaMundoEJB {

    public static void main(String[] args) {
        System.out.println("Iniciando llamada a EJB desde el cliente \n");

        try {
            //Esta sera la variable que utilizaremos para ubicar el componente del lado del servidor 
            Context jndi = new InitialContext();
            //El metodo lookup nos permite ubicar nuestro componente EJB del lado del servidor 
            HolaMundoEjbRemote holaMundo = (HolaMundoEjbRemote) jndi.lookup("java:global/HolaMundoEJB/HolaMundoEjbImpl!beans.HolaMundoEjbRemote");
            int resultado = holaMundo.sumar(5, 7);
            System.out.println("resultado = " + resultado);
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }
}
