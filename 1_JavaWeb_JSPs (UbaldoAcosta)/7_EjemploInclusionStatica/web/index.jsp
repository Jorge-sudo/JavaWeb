<%-- 
    Document   : index
    Created on : 16-06-2022, 06:06:51 PM
    Author     : JORGE
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Incluicion Estatica</title>
    </head>
    <body>
        <h1>Ejemplo Incluicion Estatica</h1>
        <br/>
        <ul>
            <li> <%@include file="/paginas/noticias1.html" %> </li>
            <li> <%@include file="/paginas/noticias2.jsp" %> </li>
        </ul>
    </body>
</html>
