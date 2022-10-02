package mx.com._1_HolaSpring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*El framework de spring es un contenedor de clases java */
@SpringBootApplication //Simplemente con agregar esta anotacion vamos a poder ejecutar las aplicaciones de Spring
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
