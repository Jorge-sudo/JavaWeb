package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "GeneracionExelServlet", urlPatterns = "/GeneracionExelServlet")
public class GeneracionExelServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
            //Indicamos el tipo de respuesta al navegador
        response.setContentType("application/vnd.ms-exel");
        //ahora haremos que se descarge el documento
                                             //attachment=se descargara un documento 
        response.setHeader("Content-Disposition", "attachment= exelEjemplo.xls.xls");
        //Para un uso mas profesional de exel se puede utilizar poi.apache.org
        
        //Para que cada vez que de click sea informacion nueva y no guarde cache en el navegador
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", -1);//Para que expire de manera inmediata
        
        //Desplegamos la informacion al cliente
        PrintWriter out = response.getWriter();
        out.println("\t valores");
        out.println("\t1");
        out.println("\t2");
        out.println("Total");
        out.println("\t=SUMA(B2:B3)");
    }
}
