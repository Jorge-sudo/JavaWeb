package testclienteWs;

import clientews.sevicio.ServicioSumarImplService;
import clientews.sevicio.ServicioSumarWS;

public class TestServicioSumarWS {
    public static void main(String[] args) {
        /*Aqui creamos una instancia del objeto servicio sumarimpl y generar instancia del servicio web 
        y con esto ya podemos llamar al servicio web */
        ServicioSumarWS servicioSumar = new ServicioSumarImplService().getServicioSumarImplPort();
        System.out.println("Ejecutando el servicio sumar WS ");
        int x = 6;
        int y = 3;
        int resultado = servicioSumar.sumar(y, x);
        System.out.println("resultado = " + resultado);
        System.out.println("Fin de servicio sumar WS");
    }
}
