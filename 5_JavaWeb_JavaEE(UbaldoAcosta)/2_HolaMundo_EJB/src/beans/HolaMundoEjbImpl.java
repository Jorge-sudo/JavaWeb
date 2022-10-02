package beans;

import javax.ejb.Stateless;

/**
 Para que esta clase sea un EJB utilizaremos la anotacion Statelets
 */
@Stateless /*Glasfish debe poder detectar a este componente y por lo tanto poder acceder de manera remota*/
public class HolaMundoEjbImpl implements HolaMundoEjbRemote {

    @Override
    public int sumar(int a, int b) {
        /*Mandamos un mensaje al servidor para que sepamos cuando se esta ejecutando este metodo*/
        System.out.println("Ejecutando metodo suma en el servidor");
        return a+b;
    }
    /*La llamada a este componente sera remota*/
    /*Este componente debe estar desplegado en el servidor de glasfish para que sea reconocido para eso hay que darle al proyecto
    un clean and build  y se debe desplegar el archivo .jar del proyecto */
}
