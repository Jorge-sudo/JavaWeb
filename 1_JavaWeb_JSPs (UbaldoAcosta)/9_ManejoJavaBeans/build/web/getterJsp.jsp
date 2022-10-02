<%-- 
    Document   : getterJsp
    Created on : 18-06-2022, 02:48:24 PM
    Author     : JORGE
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que lee los valores del JavaBean </title>
    </head>
    <body>
        <h1>JSP que lee los valores del JavaBean </h1>
        
        <%-- con este "useBean" indicamos que estamos trabajando con javaBean y con la condicion session estamos 
        indicando que la duracion de la variable sera a largo plazo solo se eliminara cuando pase 30Min de inactividad o que se 
        detenga la aplicacion,por que con el request se eliminaria la variable en instantes solo dura una peticion al
        volver al index ya se eliminara la variable, tambien con aplication solo se eliminara hasta que 
        se detenga la aplicacion tiene mas duracion que session--%>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"/>
        <br/>
        
        <%-- Para llamar los metodos get debemos hacer la siguiente accion indicar la clase y el atributo--%>
        Valor Base: <jsp:getProperty name="rectangulo" property="base" />
        <br/>
        Valor Altura: <jsp:getProperty name="rectangulo" property="altura"/>
        <br/>
        <%-- tambien podemos llamar el metodo "getArea" aun que no tenga su atributo --%>
        Valor Area: <jsp:getProperty name="rectangulo" property="area"/>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
