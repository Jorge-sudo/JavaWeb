<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar persona con Struts 2 </title>
    </head>
    <body>
        <!--Aqui se manda a llamar el atributo saludosAtr de la clase HolaMundoAction con el metodo GET -->
        <h1> Personas con Struts 2</h1>
        <s:form >
            <s:textfield name="nombre" />
            <s:submit value="Enviar" />
        </s:form>
        <div>
            Nombre Proporcionado: <s:property value="nombre" />
        </div>
    </body>
</html>
