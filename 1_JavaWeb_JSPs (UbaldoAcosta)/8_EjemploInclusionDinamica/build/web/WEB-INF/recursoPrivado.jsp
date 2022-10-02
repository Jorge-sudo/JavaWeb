<%-- 
    Document   : recursoPrivado
    Created on : 16-06-2022, 06:25:42 PM
    Author     : JORGE
--%>
<% 
    String colorFondo = request.getParameter("colorFondo");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor='<%= colorFondo %>'>
    </body>
</html>
