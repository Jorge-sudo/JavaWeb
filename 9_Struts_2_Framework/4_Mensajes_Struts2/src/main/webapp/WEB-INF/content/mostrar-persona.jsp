<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:property value="titulo" /> </title>
    </head>
    <body>
        <!--Aqui se manda a llamar el atributo saludosAtr de la clase HolaMundoAction con el metodo GET -->
        <h1> <s:property value="titulo" /></h1>
        <s:form >
            <s:textfield name="nombre" />
            <s:submit key="persona.boton" name="submit" />
        </s:form>
        <div>
            
            <s:property value="valor" /> <s:property value="nombre" />
        </div>
    </body>
</html>
