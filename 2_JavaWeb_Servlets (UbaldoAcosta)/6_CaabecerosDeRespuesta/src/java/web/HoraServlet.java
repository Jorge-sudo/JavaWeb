package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet( name = "HoraServlet", urlPatterns = "/HoraServlet")
public class HoraServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        //Le decimos al navegador que se refrescara cada segundo 
        response.setHeader("refresh", "1");
        
        //Agregamos la fecha
        Date fecha=new Date();
        SimpleDateFormat formateador=new SimpleDateFormat(" 'Hora Actualizada' HH:mm:ss ");
        String horaConFormato = formateador.format(fecha);
        
        PrintWriter out = response.getWriter();
        out.print(horaConFormato);
        out.close();
    }
}
