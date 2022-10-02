package Utilerias;

import java.text.*;
import java.util.*;

/**
 * @author JORGE
 */
public class Conversiones {
    private static final String FORMATO_FECHA="dd-MM-yyyy";
    
    public static String format(Date fecha){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
    
    //Con este metodo Provocaremos un error
    public static String format(String fecha){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
}
