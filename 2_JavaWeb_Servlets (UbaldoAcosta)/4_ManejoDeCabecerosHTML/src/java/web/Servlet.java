package web;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ServletHeaders", urlPatterns = "/ServletHeaders")
public class Servlet extends HttpServlet {
    
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        String metodoHTTP = request.getMethod();
        out.print("<html>");
        
        out.print("<head>");
        out.print("<title>Headers HTTP</title>");
        out.print("</head>");
        
        out.print("<body>");
        out.print("<h1>Headers HTTP</h1>");
        out.print("<br>");
        out.print(" metodo HTTP: "+metodoHTTP);
        out.print("<br>");
        String metodoURI = request.getRequestURI();
        out.print(" metodo URI: "+metodoURI);
        out.print("<br>");
        //Imprimimos todos los cabeceros disponibles 
        Enumeration cabeceros = request.getHeaderNames();
        while(cabeceros.hasMoreElements()){//HasMoresElements es para saber si tenemos as elemmentos que iterar
            String nombreCabecero = (String)cabeceros.nextElement();
            out.print("<b>" + nombreCabecero+ "</b> : ");
            out.print(request.getHeader(nombreCabecero));
            out.print("<br>");
        }
        
        out.print("</body>");
        
        out.print("</html>");
        
    }
    
}
