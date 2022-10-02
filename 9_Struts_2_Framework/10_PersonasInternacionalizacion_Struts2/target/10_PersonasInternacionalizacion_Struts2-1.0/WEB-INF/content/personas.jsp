<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:text name="form.titulo"/></title>
        <s:head/>
    </head>
    <body>
        <!-- Recuperamos los elementos de los archivos de .propiertis --> 
        <h1><s:text name="form.titulo"/></h1>
        <s:form>
            <s:textfield key="form.nombre" name="persona.nombre" />
            <s:textfield key="form.calle" name="persona.domicilio.calle" />
            <s:textfield key="form.no.calle" name="persona.domicilio.numeroCalle" />
            <s:textfield key="form.pais" name="persona.domicilio.pais"/>
            <s:submit key="form.enviar"/>
        </s:form>

        <h2><s:text name="form.resultado" />:</h2>
        <s:text name="form.nombre" />: <s:property value="persona.nombre" /> <br/>
        <s:text name="form.calle" />: <s:property value="persona.domicilio.calle" /> <br/>
        <s:text name="form.no.calle" />: <s:property value="persona.domicilio.numeroCalle"/> <br/>
        <s:text name="form.pais" />: <s:property value="persona.domicilio.pais"/>

        <br/>
        <!--  Creamos dos URL para que el usuario seleccione cual idioma quire visualizar ->
        <s:url var="localeES" action="personas" ><!<!-- action=Personas para que se envie el parametro a la clase personaAction -->
            <!-- SE indica el parametro que se desea enviar en este caso español con request_locate 
            a la clase de personasAction donde actionSuport se encargara de cargar el idioma indicado-->
            <s:param name="request_locale">es</s:param>
        </s:url>

        <s:url var="localeEN" action="personas" >
            <s:param name="request_locale">en</s:param><!<!-- Ingles -->
        </s:url>
        <!-- El href de este link cuando demos click entonces lo que se va ejecutar el valor asociado 
        a la variable de "localeES" y el idioma seleccionado  -->
        <s:a href="%{localeES}"> <s:text name="form.idioma.espaniol"/> </s:a>  <!-<!-- Si el usuario selecciona esta opcion se carga el idioma de Español -->
            |
        <s:a href="%{localeEN}"> <s:text name="form.idioma.ingles"/> </s:a>

    </body>
</html>
