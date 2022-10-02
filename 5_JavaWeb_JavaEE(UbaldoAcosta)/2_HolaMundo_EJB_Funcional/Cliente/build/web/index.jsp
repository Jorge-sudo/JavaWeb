
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Suma de Numeros</h1>
        <form action="ServletControlador" method="POST">
            Ingrese el 1er Numero: <input type="text" name="a" />
            <br><br>
            Ingrese el 2do Numero: <input type="text" name="b" />
            <br><br> 
            <input type="submit" value="Sumar" />
        </form>
    </body>
</html>
