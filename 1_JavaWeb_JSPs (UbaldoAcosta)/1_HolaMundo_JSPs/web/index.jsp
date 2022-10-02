<%-- 
    Document   : index
    Created on : 17-05-2022, 07:37:59 PM
    Author     : JORGE
--%>

<%-- Este documento JSPs se traducira a un Servlet, por que no es un documento HTML en si 
Tambien se aplica el ciclo de vida de un Servlet, entonces un JSPs es un componente del lado del servidor --%>

<%--  Esto de abajo es un metodo de directiva de que tipo sera este documento --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- Definimos la libreria que queremos utilizar --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Hola Mundo JSPs</title>
    </head>
    <body>
        <h1>Hola Mundo JSPs</h1>
        <ul>
            <%-- Primero utilizaremos el Scriplets = Dentro de estos Scriplets se puede agregar codigo Java--%>
            <%-- La variable "out" esta disponible por defecto en este cocumento JSPs y hay muchas funciones disponibles --%>
            <li> <% out.print("Hola Mundo con Scriplets"); %> </li>
            
            <%-- Utilizaremos expresion Language --%>
            <li> ${"Hola Mundo con Expression Language (EL) "} </li>
            
            <%-- Utilizaremos Expresiones
            Este parametro de inmediato se enviara a imprimir con el metodo "out" por defecto--%>
            <li> <%= "Hola mundo con Expresiones" %> </li>
            
            <%-- Utilizaremos JSTL=JavaServer Pages Standard Tag Library --%>
            <li> <c:out value="Hola Mundo con JSTL"/> </li>
            <
        </ul>
    </body>
</html>
