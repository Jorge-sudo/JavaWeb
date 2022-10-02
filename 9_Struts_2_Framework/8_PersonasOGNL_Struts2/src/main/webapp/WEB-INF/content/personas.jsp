<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario Personas</title>
        <s:head/><!-- Para agregar los stilos de struts -->
    </head>
    <body>
        <!-- Con OGNL podemos acceder a nuestros obejtos java podemos hacer el get o set  -->
        <h1>Formulario de Personas (OGNL)</h1>
        <s:form><!-- Aqui agregaremos a codigo duro sin arhcivo  de .properties -->
            <s:textfield label="Nombre" name="persona.nombre" />
            <s:textfield label="Calle" name="persona.domicilio.calle" /><!-- calle de la clase de domicilio -->
            <s:textfield label="No. Calle" name="persona.domicilio.numeroCalle" />
            <s:textfield label="Pais" name="persona.domicilio.pais"/>
            <s:submit value="Enviar"/>
        </s:form>
        
        <h2>Valores proporcionados:</h2>
        <!-- persona.nombre al atributo nombre se le  Struts2 llama el metodo get o set  -->
        Nombre: <s:property value="persona.nombre" /> <br/>
        Calle: <s:property value="persona.domicilio.calle" /> <br/>
        No. Calle: <s:property value="persona.domicilio.numeroCalle"/> <br/>
        Pais: <s:property value="persona.domicilio.pais"/>
        
    </body>
</html>
