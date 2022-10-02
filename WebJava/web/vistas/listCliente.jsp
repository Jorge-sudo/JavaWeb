<%-- 
    Document   : listCliente
    Created on : May 8, 2022, 8:17:58 PM
    Author     : orion
--%>
<%@taglib prefix="c" uri=""%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelos.Cliente"%>
<%@page import="modelosDAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Control de Clientes</title>
    </head>
    <body>
        <h1>Control de Clientes</h1>

        <div class="container">
            
            
            <br>
            <a class="btn btn-warning" href="ClienteControlador?accion=add">Nuevo Cliente</a>  
           
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Nuevo Cliente modal
            </button>
              <hr>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>NOMBRES</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    ClienteDAO dao = new ClienteDAO();
                    List<Cliente> list = dao.listar();
                    Iterator<Cliente> iter = list.iterator();
                    Cliente cli = null;
                    while (iter.hasNext()) {
                        cli = iter.next();


                %>

                <tbody>
                    <tr>
                        <td><%= cli.getId()%></td>
                        <td><%= cli.getDni()%></td>
                        <td><%= cli.getNombres()%></td>
                        <td>
                            <a class="btn btn-warning" >Editar</a>  
                            <a class="btn btn-danger" href="ClienteControlador?accion=delete&id=<%= cli.getId()%>">Eliminar</a>  
                        </td>
                    </tr>

                    <% }%>
                </tbody>
            </table>
        </div>



        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="container">
                            <div class="col-lg-4">

                                <form action="ClienteControlador">
                                    DNI:<br><!-- comment -->
                                    <input class="form-control" type="text" placeholder="Ingrese el DNI" name="txtDni"  onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required><br><!-- comment -->
                                    NOMBRES:<br><!-- comment -->
                                    <input class="form-control" type="text" placeholder="Ingrese el Nombre" name="txtNombre" onkeypress="return soloLetras(event)" required><br><!-- comment -->
                                    <br><!-- comment -->
                                    <input type="submit" class="btn btn-primary" name="accion" value="Agregar">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    
                                </form>

                            </div>

                        </div>
                    </div>
                    <div class="modal-footer">
                       
                    </div>
                </div>
            </div>
        </div>        




    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script> 

</body>
</html>
