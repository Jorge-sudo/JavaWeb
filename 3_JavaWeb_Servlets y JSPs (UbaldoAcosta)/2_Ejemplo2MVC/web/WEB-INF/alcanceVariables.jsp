<%-- 
    Document   : alcanceVariables
    Created on : 18-06-2022, 09:38:10 PM
    Author     : JORGE
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance variables</title>
    </head>
    <body>
        <h1>Alcance variables</h1>
        <br/>
        Variable request: 
        <ul>
            <li>
                Base: ${rectanguloRequest.base}
            </li>
            <li>
                Altura: ${rectanguloRequest.altura}
            </li>
            <li>
                Area: ${rectanguloRequest.area}
            </li>
        </ul>
        <br/>
        <br/>
        Variable Session:
        <ul>
            <li>
                Base: ${rectanguloSession.base}
            </li>
            <li>
                Altura: ${rectanguloSession.altura}
            </li>
            <li>
                Area: ${rectanguloSession.area}
            </li>
        </ul>
        <br/>
        <br/>
        Variable Aplicacion:
        <ul>
            <li>
                Base: ${rectanguloAplicacion.base}
            </li>
            <li>
                Altura: ${rectanguloAplicacion.altura}
            </li>
            <li>
                Area: ${rectanguloAplicacion.area}
            </li>
        </ul>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar al Inicio</a>
    </body>
</html>
