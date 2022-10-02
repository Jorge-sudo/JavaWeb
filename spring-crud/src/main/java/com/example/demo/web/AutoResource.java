package com.example.demo.web;
/*Este es el controlador de Auto, por lo tanto con la anotacion @RestController estamos diciendo que es un
controlador REST y por lo tanto estara recibiendo peticiones HTTP */

import com.example.demo.entidades.Auto;
import com.example.demo.servicio.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1") /*  Esta es una anotacion que nos indicara el camino de nuestra peticion, es
importante versionarlas por si mañana agregamos otro controlador necesitamos saber la versiona*/
public class AutoResource {
    /*El controlador debe acceder a la caa de servicio son buenas practicas */
    @Autowired
    private IAutoService autoService;

    /*Creamos nuestro controlador REST con los metodos HTTP POST y etc. */
    @PostMapping("autos")      //Con el requestBody se espera que lo que llegue un obejto de tipo auto
    public ResponseEntity<Auto> crearAuto( @RequestBody Auto auto ){
        /*Inyectamos una dependecnia de la capa de servicio y le dijimos que responda una peticion POST*/
        return new ResponseEntity(this.autoService.crear(auto), HttpStatus.CREATED);//Codigo de estado CREATED
    }

    @GetMapping("autos/{id}")
    public ResponseEntity<Auto> obtenerAutoId( @PathVariable("id") Long id) {
        Optional<Auto> optionalAuto = this.autoService.mostrarAutoId(id);
        if(optionalAuto.isPresent())
            return new ResponseEntity(optionalAuto.get(), HttpStatus.OK);
        return ResponseEntity.notFound().build();
    }
}
