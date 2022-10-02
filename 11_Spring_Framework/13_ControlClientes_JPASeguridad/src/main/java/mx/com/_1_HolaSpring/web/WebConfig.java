package mx.com._1_HolaSpring.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


/*Esta clase es para la configuracion de listener que Spring ya trae por default pero debemos configurarlo*/

@Configuration //Esto es para la configuracion para que se reconozca si no agregamos esto no servira de nada esta clase 
public class WebConfig implements WebMvcConfigurer {
    //Ahora vamos a implementar las clases y configurar 
    @Bean//Bean con esta anotacion agregara este metodo al contenedor de Spring
    public LocaleResolver localeResolver (){
        //Este es un objeto de Spring que configuraremos 
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));//idioma/en=ingles con Locate.getDefault ponemos en default dependiendo el pais
        return slr;//retornamos el objeto 
    }
    
    //Configuramos un interseptor para que podamos cambiar de idioma de manera dinamica
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor (){
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("idioma"); //Cual sera el parametro para cambiar de lenguaje
        return lci;
    }
    
    //Registramos el interceptor osea el metodo LocaleChangeInterceptor
    @Override //Sobrescribimos el metodo de la interfaz
    public void addInterceptors ( InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    //Ahora que la URL de la raiz esta bloqueada y no podemos ingresar entonces hacemos la siguinete configuracion
    @Override //este metodo es para agregar path que no pasen por el controlador
    public void addViewControllers (ViewControllerRegistry registro){
        //estos son path que utilizamos sin necesidad de pasar por un controlador 
        registro.addViewController("/").setViewName("index"); //le ponemos el nombre de index para que no este vacio 
        //ponemos login para que se redireccione
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
    }
}
