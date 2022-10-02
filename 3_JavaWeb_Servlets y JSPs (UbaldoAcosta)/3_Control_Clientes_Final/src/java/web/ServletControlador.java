package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ServletControlador", urlPatterns = "/ServletControlador")
public class ServletControlador extends HttpServlet {

    //doGET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("clientes = " + clientes);
        HttpSession sesion = request.getSession();

        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", calcularSaldoTotal(clientes));

        //Ponemos en comentarios esto por que este es el problema de el error que al actualizar 
        //la pagina se registra nuevamente los mismos datos ya registrados anteriormente 
        //el navegador no sabe que queremos hacer una a
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        //Con esto solucionamos el problema, ahora no nos carga los datos por que no hay un request por lo tanto no se recibe datos
        //Por lo tanto necesitamos enviar los datos por request
        response.sendRedirect("clientes.jsp");

    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recuperamos la id del cliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        //Con esto busca la persona mediante el ID y setea todos los datos de este cliente asi que 
        // este objeto cliente viene cargado con todos los datos
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        
        request.setAttribute("cliente", cliente);

        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";

        //Mandamos los datos a ese jsp del String
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }

    //doPost
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        //Recuperamos los valores del formulario editar cliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //Creamos el objeto de cliente (modelo)
        Cliente clienteNuevo = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);

        //Insertamos el nuevo Objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().actualizar(clienteNuevo);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia la accion por default
        this.accionDefault(request, response);
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recuperamos los valores del formulario agregar cliente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //Creamos el objeto de cliente (modelo)
        Cliente clienteNuevo = new Cliente(nombre, apellido, email, telefono, saldo);

        //Insertamos el nuevo Objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().insertar(clienteNuevo);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia la accion por default
        this.accionDefault(request, response);
    }
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        //Recuperamos los valores del formulario editar cliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        //Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(idCliente);

        //Eliminamos el Objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia la accion por default
        this.accionDefault(request, response);
    }
}
