package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "CarritoServlet", urlPatterns = "/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Creamos o recuperamos el objeto Http Session
        HttpSession sesion = request.getSession();

        //Recuperamos la lista de articulos agregados previamente si existen
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");

        //Verificamos si la lista de articulos existe 
        if (articulos == null) {
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }

        //Procesamos el nuevo articulo
        String articuloNuevo = request.getParameter("articulo");

        //Revisamos el articulo nuevo 
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }

        try ( //Esste try al momento de acabar de imprimir todos los datos se cerrara por automatico 
                //En este caso ya no lo tenemos que hacer nosotros con "out.close();" 

            //Imprimimos las lista de articulos
            PrintWriter out = response.getWriter()) {
            out.print("<h1>Lista de Articulos</h1>");
            out.print("<br>");
            //Iteramos todos los articulos
            for (String articulo : articulos) {
                out.print("<li>" + articulo + "</li>");
            }
            //Agregamos un link para regresar al inicio
            out.print("<br>");
            out.print("<a href='/10_CarritoDeCompras_Session'>Regresar al Inicio</a>");
        }
    }
}
