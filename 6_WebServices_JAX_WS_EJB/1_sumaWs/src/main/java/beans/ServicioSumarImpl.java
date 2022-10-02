package beans;

import javax.ejb.Stateless;
import javax.jws.WebService;


@Stateless //Esta clase sera un EJB por lo tanto añadimos esta anotacion
@WebService(endpointInterface = "beans.ServicioSumarWS")//En esta anotacion indicamos cual interfaz implementaremos
public class ServicioSumarImpl implements ServicioSumarWS {

    @Override
    public int sumar(int a, int b) {
        return a+b;
    }
    /*Despues de esto el archivo jar generado hay que subirlo al servidor de glasFish*/
}
