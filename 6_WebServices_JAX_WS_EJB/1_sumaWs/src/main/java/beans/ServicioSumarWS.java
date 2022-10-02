package beans;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService //Esta interface la exponemos como un servicio web 
public interface ServicioSumarWS {
    
    @WebMethod
    public int sumar(int a, int b);
}
