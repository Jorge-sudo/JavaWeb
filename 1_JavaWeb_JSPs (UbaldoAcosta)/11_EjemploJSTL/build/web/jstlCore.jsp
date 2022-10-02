<%-- 
    Document   : jstlCore
    Created on : 18-06-2022, 04:28:17 PM
    Author     : JORGE
--%>
<%-- Importamos la libreria de JSTL solo utilizaremos "core"--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core(Jsp Standard Tag Linrary)</h1>
        <h2>Manipulacion de variables</h2>
        <!-- Manipulacion de Variables -->
        <!-- Definimos la variable nombre=Ernesto -->
        <c:set var="nombre" value="Ernerso"/>
        <!-- Imprimimos la variable nombre -->
        Variable nombre: <c:out value="${nombre}"/>
        <br/>
        Variable con codigo HTML:
        <c:out value="<h4>Hola</h4>" escapeXml="false"/>
        <h2>Condicionales con JSTL</h2>
        <!-- Codigo Condicionado, uso de if-->
        <c:set var="bandera" value="true"/>

        <c:if test="${bandera}">
            La bandera es verdadera 
        </c:if>

        <c:if test="${!bandera}">
            La bandera es falso
        </c:if>
        <br/>
        <h2>Switch con JSTL</h2>
        <!-- Utilizaremos Switch-->
        <c:if test="${param.opcion != null}">
            <c:choose >
                <c:when test="${param.opcion == 1}">
                    <br/>
                    Opcion 1 seleccionada
                </c:when>
                <c:when test="${param.opcion == 2}">
                    <br/>
                    Opcion 2 seleccionada
                </c:when>
                <%-- Por default si no es ninguno de las demas opciones es valida--%>
                <c:otherwise>
                    <br/>
                    Opcion proporcionada desconocida: ${param.opcion}
                </c:otherwise>
            </c:choose>
        </c:if>
        <h2>Iteramos un arreglos con un forEach de JSTL</h2>
        <%-- Iteramos un arreglo--%>
        <%
            String nombres[]={"claudia","pedro","juan"};
            //Esto hacemos para que podamos compartir nuestra variable en Expresion Language
            request.setAttribute("nombres", nombres);
        %>
        Lista de Nombres:
        <br/>
        <ul>
            <%--El Expresion Language primero buscara la variable "nombres" en Pages, Request, Session y Aplicattion. 
            En este caso lo almacenamos en el alcance de request asi que ahi encontrara el vector--%>
            <c:forEach var="persona" items="${nombres}">
                <li>${persona}</li>
            </c:forEach>
        </ul> 
        <br/>
        <a href="index.jsp">Regresar Inicio</a>
    </body>
</html>
