<%-- 
    Document   : manejoErrores
    Created on : 16-06-2022, 11:43:57 AM
    Author     : JORGE
--%>
<%-- Este JSPs es para el manejo de errores, para que el navegador no tenga acceso a esto lo pondemos en la carpeta de
WEB-INF--%>

<%-- Esta directiva que estmos agregando nos permite utilizar la clase Exception --%>
<%@page isErrorPage="true" %>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo de Errores</title>
    </head>
    <body>
        <h1>Manejo de Errores</h1>
        <br/>
        Ocurrio una Excepcion: <%= exception.getMessage()%>
        <br/>
        <textarea cols="30" rows="5">  
                <% exception.printStackTrace(new PrintWriter(out));%>
        </textarea>
    </body>
</html>
