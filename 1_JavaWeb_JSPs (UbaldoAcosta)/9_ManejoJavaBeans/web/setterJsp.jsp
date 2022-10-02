<%-- 
    Document   : setterJsp
    Created on : 18-06-2022, 02:47:12 PM
    Author     : JORGE
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que modifica a un JavaBean de Rectangulo</title>
    </head>
    <body>
        <h1>JSP que modifica a un JavaBean de Rectangulo</h1>
        <%-- con este "useBean" indicamos que estamos trabajando con javaBean y con la condicion session estamos 
        indicando que la duracion de la variable sera a largo plazo solo se eliminara cuando pase 30Min de inactividad o que se 
        detenga la aplicacion,por que con el request se eliminaria la variable en instantes solo dura una peticion al
        volver al index ya se eliminara la variable, tambien con aplication solo se eliminara hasta que 
        se detenga la aplicacion tiene mas duracion que session--%>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"/>
        Modificamos los atributos:
        <br/>
        <br/>
        <%
            int baseValor = 5;
            int alturaValor = 10;
        %>
        <%-- mandamos a llamar "setBase" de la clase de rectangulo y como estamos utilizando JSPs esta es la accion--%>
        <jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>"/>
        <jsp:setProperty name="rectangulo" property="altura" value="<%=alturaValor%>"/>
        <br/>
        Nuevo valor de base: <%=baseValor%>
        <br/>
        Nuevo valos de altura: <%=alturaValor%>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
