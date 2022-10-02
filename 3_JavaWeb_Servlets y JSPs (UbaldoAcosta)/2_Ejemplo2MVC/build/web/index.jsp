<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC 2</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Ejemplo MVC 2</div>
        <br/>
        <div style="color: red">${mensaje}</div>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador">
            Link al Servlet controlador sin parametros
        </a>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregaVariables">
            Link al Servlet controlador para agregar variables
        </a>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
            Link al Servlet controlador para listar variables
        </a>
    </body>
</html>
