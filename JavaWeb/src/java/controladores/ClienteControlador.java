package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.ClienteDAO;
import modelos.Cliente;


public class ClienteControlador extends HttpServlet {

    String lista = "vistas/listCliente.jsp";
    String add = "vistas/addCliente.jsp";
    String edit = "vistas/editCliente.jsp";
    ClienteDAO dao = new ClienteDAO();
    Cliente cliente = new Cliente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteControlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acceso = "";
        //Este accion es el dato que se resivira desde el navegador en este caso cuando samos click al boton
        //"listar clientes"
        String accion = request.getParameter("accion");
        //equals Es una igualdad absoluta
        if (accion.equalsIgnoreCase("listarClientes")) {
            acceso = lista;
        } else if (accion.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (accion.equalsIgnoreCase("Agregar")) {
            String dni = request.getParameter("txtDni");
            String nombre = request.getParameter("txtNombre");
            if (dni != null && nombre != null) {
                Cliente cliente1 = new Cliente(dni, nombre);
                dao.add(cliente1);
            }
            acceso = lista;
        }else if (accion.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            cliente.setId(id);
            dao.delete(id);
            acceso = lista;
        }
        //para retornar los datos
        request.getRequestDispatcher(acceso).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
