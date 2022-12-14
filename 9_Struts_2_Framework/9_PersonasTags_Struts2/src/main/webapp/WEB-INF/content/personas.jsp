<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario Personas</title>
        <s:head/>
    </head>
    <body>
        <h1>Formulario de Personas (Tags)</h1>
        <s:form>
            <s:textfield label="Nombre" name="persona.nombre" />
            <s:textfield label="Calle" name="persona.domicilio.calle" />
            <s:textfield label="No. Calle" name="persona.domicilio.numeroCalle" />
            <s:textfield label="Pais" name="persona.domicilio.pais"/>
            <s:submit value="Enviar"/>
        </s:form>
        
        <h2>Valores proporcionados:</h2>
        Nombre: <s:property value="persona.nombre" /> <br/>
        Calle: <s:property value="persona.domicilio.calle" /> <br/>
        No. Calle: <s:property value="persona.domicilio.numeroCalle"/> <br/>
        Pais: <s:property value="persona.domicilio.pais"/>
        
        <br/>
        <!-- Este es uno de los tags de Struts 2 que es como una condicional si persona.nombre 
        es diferente a null y si persona.nombre es igual a admin entonces en mensaje de el usuario es administrado se ejecutara 
        sino el de no es administrador -->
        <s:if test="persona.nombre != null">
            <s:if test="persona.nombre == 'admin'">
                Es un usuario administrador
            </s:if>
            <s:else>
                El usuario NO es adminstrador
            </s:else>    
        </s:if>
        
    </body>
</html>
