<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saludos desde Struts</title>
    </head>
    <body>
        <!--Aqui se manda a llamar el atributo saludosAtr de la clase HolaMundoAction con el metodo GET -->
        <h1> <s:property value="saludosAtr"></s:property> </h1>
    </body>
</html>
