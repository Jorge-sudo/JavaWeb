<%-- 
    Document   : listCliente
    Created on : 11-05-2022, 09:03:57 PM
    Author     : JORGE
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelos.Cliente"%>
<%@page import="modeloDAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>CLIENTES</title>
    </head>

    <body>
        <div class="container">
            <hr>

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
                <tbody>
                    <%
                        ClienteDAO dao = new ClienteDAO();
                        List<Cliente> list = dao.listar();
                        Iterator<Cliente> iter = list.iterator();
                        Cliente cli = null;
                        while (iter.hasNext()) {
                            cli = iter.next();
                    %>
                    <tr>

                        <td><%=cli.getId()%></td>
                        <td><%=cli.getDni()%></td>
                        <td><%=cli.getNombre()%></td>
                        <td>
                            <a class="btn btn-warning" href="ClienteControlador?accion=edit">Editar</a>  
                            <a class="btn btn-danger" href="ClienteControlador?accion=delete&id=<%= cli.getId()%>">Eliminar</a>  
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>

            <hr>

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
                                        DNI:<br>
                                        <input class="from-control" type="text" placeholder="Ingrese su ID" name="txtDni"><br>
                                        NOMBRE:<br>
                                        <input class="from-control" type="text" placeholder="Ingrese su Nombre" name="txtNombre"><br>
                                        <br>
                                        <input type="submit" class="btn btn-warning" name="accion" value="Agregar">
                                        
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>

            <script>
                var myModal = document.getElementById('myModal')
                var myInput = document.getElementById('myInput')

                myModal.addEventListener('shown.bs.modal', function () {
                    myInput.focus()
                })
            </script>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
