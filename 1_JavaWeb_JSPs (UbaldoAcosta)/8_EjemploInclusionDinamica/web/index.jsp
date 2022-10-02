<%-- 
    Document   : index
    Created on : 16-06-2022, 06:24:25 PM
    Author     : JORGE
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Inclusion Dinamica</title>
    </head>
    <body>
        <h1>Ejemplo Inclusion Dinamica</h1>
        <br/>
        <jsp:include page="paginas/recursoPublico.jsp"/>
        <br/>
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="yellow"/>
        </jsp:include>
    </body>
</html>
