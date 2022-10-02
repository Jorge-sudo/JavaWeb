package mx.com._1_HolaSpring.web;

//Esta clase es una clase de configuracion de Spring por lo tanto agregamos la configuracion de Spring

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebSecurity  //Agregamos esta anotacion para habilitar la seguridad Web
public class SecurityConfig extends WebSecurityConfigurerAdapter { //Esta clase debe extender de security para poder configurar
    
    //Este metodo nos permitira para agregar mas usuarios y personalizarlos 
    @Override //Autenticacion un usuario ingresa sus credenciales y es para ingresar al sistema
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //Agregaremos usuarios creados en memoria
        auth.inMemoryAuthentication()
                .withUser("admin") //los tabuladores no son necesarios 
                    .password("{noop}123") //con {noop} le decimos que no queremos que se encripte el password
                    .roles("ADMIN", "USER") //Spring por automatico pone el "ROLE" osea "ROLE_ADMIN"
                .and() //Con and agregamos otro usuario personalizado
                .withUser("user")
                    .password("{noop}1234")
                    .roles("USER")
                ;
        
    }
    
    //Este metodo es para restringir los URL de nuestra aplicacion Web 
    @Override 
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()  //Con "**" queremos decir que todo lo siguiente del path eliminar no se podra hacer
                .antMatchers("/editar/**", "/agregar/**", "/eliminar") //Con esto restringimos el Path de editar y agregar
                    .hasRole("ADMIN") //Solo el ADMIN podra acceder al path de editar eliminar y  agregar
                .antMatchers("/") //path Raiz
                    .hasAnyRole("USER", "ADMIN") //al path "raiz" solo podran acceder el user y admin como son 2 utilizamos hasAnyRole
                .and()
                    .formLogin() //llamamos el metodo para agregar el login personalizado
                    .loginPage("/login") //agregamos el nombre del login personalizado
                .and() //agregaremos otra condicion donde indicaremos la pagina de errores
                    .exceptionHandling().accessDeniedPage("/errores/403")
                ;
                
    }
    
}
