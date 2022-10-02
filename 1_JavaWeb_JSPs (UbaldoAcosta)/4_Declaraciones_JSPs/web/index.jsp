<%-- Agregamos una declaracion de JSP --%>
<%! 
    //Con <%! podemos declarar variables en la clase, pero con <% solo se puede crear variables dentro del try-catch
    
    //Declaramos una variable con su metodo get 
    private String usuario = "Alberto";
    public String getUsuario(){
        return this.usuario;
    }
    //Declaramos un contador de visitas 
    private int contadorVisitas = 1;
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de declaraciones con JSPs</title>
    </head>
    <body>
        <h1>Uso de declaraciones con JSPs</h1>
        Valor de usuario por medio del atributo: <%= this.usuario %>
        <br>
        Valor de usuario por medio del metodo: <%= this.getUsuario() %>
        <br>
        Contador visitas : <%= this.contadorVisitas++%>
    </body>
</html>
