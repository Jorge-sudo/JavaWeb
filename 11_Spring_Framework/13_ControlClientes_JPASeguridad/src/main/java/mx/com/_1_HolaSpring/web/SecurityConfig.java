package mx.com._1_HolaSpring.web;

//Esta clase es una clase de configuracion de Spring por lo tanto agregamos la configuracion de Spring

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity  //Agregamos esta anotacion para habilitar la seguridad Web
public class SecurityConfig extends WebSecurityConfigurerAdapter { //Esta clase debe extender de security para poder configurar
    
    //empezaremos injectando el servicio de Usuarios que ya emos creado 
    @Autowired
    private UserDetailsService userDetailsService;//esta es la inferzas para recuperar usuarios 
    
    /*Definimos un bean para que Spring pueda utilizar directamente este tipo de Encripcion 
    Crreamos una variable del mismo metodo que utilizamos para encriptar el usuario en la clase EncriptarPassword*/
    //@Bean 
    public BCryptPasswordEncoder passwordEncoder(){
        //este metodo estara disponible dentro de el contenedor de Spring
        return new BCryptPasswordEncoder();
    }
    
    //este metodo lo estamos injectanto por lo tanto buscara este metodo 
    @Autowired 
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{//Este es un objeto ya definido en Spring security
        //con esto  todo lo que configuramos en Service lo utilizara Spring 
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
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
