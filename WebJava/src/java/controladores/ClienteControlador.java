/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Cliente;
import modelosDAO.ClienteDAO;

/**
 *
 * @author orion
 */
public class ClienteControlador extends HttpServlet {

      String list="vistas/listCliente.jsp";
      String add="vistas/addCliente.jsp";
      String edit="vistas/editCliente.jsp";
      Cliente clie=new Cliente();
      ClienteDAO dao=new ClienteDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
           String acceso="";
           String accion= request.getParameter("accion");
           if(accion.equalsIgnoreCase("listarClientes")){
                acceso=list;
               
           } else if(accion.equalsIgnoreCase("add")){
                acceso=add;
           } else if(accion.equalsIgnoreCase("Agregar")){
                String dni=request.getParameter("txtDni");
                String nom=request.getParameter("txtNombre");
                clie.setDni(dni);
                clie.setNombres(nom);
                dao.add(clie);
                acceso=list;
           }else if(accion.equalsIgnoreCase("delete")){
                int id= Integer.parseInt(request.getParameter("id"));
                clie.setId(id);
                dao.delete(id);
                acceso=list;
           }
           
           request.getRequestDispatcher(acceso).forward(request, response);
           
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
