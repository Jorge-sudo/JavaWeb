<%-- 
    Document   : variablesImplicitas
    Created on : 18-06-2022, 03:47:09 PM
    Author     : JORGE
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL y variables Implicitas</title>
    </head>
    <body>
        <h1>EL y variables Implicitas</h1>
        <ul>
            <li>Nombre de la aplicacion: ${pageContext.request.contextPath}</li>
            <li>Navegador del Cliente: ${header["User-Agent"]}</li>
            <li>Id Session: ${cookie.JSESSIONID.value}</li>
            <li>Web Server: ${pageContext.servletContext.serverInfo}</li>
            <%-- Se puede obetener los datos de 2 formas una sirve para vectores y la otra para algo individual pero 
            las 2 funcionan --%>
            <li>Valor parametro: ${param["usuario"]}</li>
            <li>Valor parametro 2: ${param.usuario}</li>
        </ul>
        <br/>
        <br/>
        <a href="index.jsp">Regresar Inicio</a>
    </body>
</html>
