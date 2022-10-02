package beans;

import javax.ejb.Remote;
/*Con la anotacion de remote Glasfish podra publicar este componente y por lo tanto podremos acceder desde el cliente */
@Remote
public interface HolaMundoEjbRemote {
    /*Agregamos el metodo que utilizaremos*/
    public int sumar(int a, int b);
}
