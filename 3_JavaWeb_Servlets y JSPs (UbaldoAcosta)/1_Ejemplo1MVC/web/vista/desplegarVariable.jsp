<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliege de Variables</title>
    </head>
    <body>
        <h1>Despliege de Variables</h1>
        <%--Lo que hace Expresion Language es que busca la variable "mensaje" en todos los alcances como son 
        page, request, session y aplication en el primer alcance que encuentre lo utilizara.--%>
        Variable en alcance de request: ${mensaje}
        <br/>
        <br>
        Variable en alcance de session: 
        <br>
        <br>
        Rectangulo:
        <ul>
            <li>
                Base: ${rectangulo.base}
            </li>
            <li>
                Altura: ${rectangulo.altura}
            </li>
            <li>
                Area: ${rectangulo.area}
            </li>
        </ul>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar al Inicio</a>
    </body>
</html>
