<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:text name="form.titulo"/></title>
        <s:head/><!-- Esto agregamos para que se pueda manejar los mensajes y stilos de struts 2 -->
    </head>
    <body>
        <h1><s:text name="form.titulo"/></h1>
        
        <s:actionerror/> <!-- Este mensaje no esta asociado en ningun campo el metodo es addActionError
        por lo tanto es necesario agregarlo -->
        
        <s:form action="validarUsuario">
            <s:textfield key="form.usuario" name="usuario" /><!--El error asociado en este campo se agregaran de inmediato -->
            <s:password key="form.password" name="password"/>
            <s:submit key="form.boton" name="submit" />
        </s:form>
    </body>
</html>
