<%-- 
    Document   : reporteExcel
    Created on : 16-06-2022, 11:09:43 AM
    Author     : JORGE
--%>
<%-- Aqui importamos las clases que necesitaremos--%>
<%@page import="Utilerias.Conversiones, java.util.Date" %>
<%-- Aqui declaramos con que ripo de contenido responderemos al cliente en este caso de tipo Excel--%>
<%@page contentType="appplication/vnd.ms-excel" %>
<%--Declaramos el escriplet --%>
<%
    String nombreArchivo ="reporte.xls";
    //indicamos el tipo de contenido que responderemos en este caso el tipo Excel con el nombre de "reporte.xls"
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>
<%-- Importamos la directiva para el manejo de errores, si ocurre algun error en este JSPs se reedirijita a la 
manejoErrores.jsp--%>
<%@page errorPage="/WEB-INF/manejoErrores.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        <br/>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprendemos la sintais basica de Java</td>
                <td><%= Conversiones.format(new Date())%></td>
            </tr>
            <tr>
                <td>2. Programacion con Java</td>
                <td>Pondremos en practica de programacion orientada a objetos</td>
                <td><%= Conversiones.format(new Date())%></td>
            </tr>
        </table>
    </body>
</html>
