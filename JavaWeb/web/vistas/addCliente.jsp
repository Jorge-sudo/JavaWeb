<%-- 
    Document   : addCliente
    Created on : 11-05-2022, 09:02:55 PM
    Author     : JORGE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>AGREGAR CLIENTE</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-4">
                <form action="ClienteControlador">
                    DNI:<br>
                    <input type="text" placeholder="Ingrese su ID" name="txtDni"><br>
                    NOMBRE:<br>
                    <input type="text" placeholder="Ingrese su Nombre" name="txtNombre"><br>
                    <br>
                    <input type="submit" name="accion" value="Agregar">
                </form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
