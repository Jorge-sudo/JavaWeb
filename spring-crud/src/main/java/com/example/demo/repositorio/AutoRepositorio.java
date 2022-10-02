package com.example.demo.repositorio;

import com.example.demo.entidades.Auto;
import org.springframework.data.repository.CrudRepository;

public interface AutoRepositorio extends CrudRepository <Auto, Long> {
    /*Con esto ya tenemos todas las herramientas necesarias para hacer un CRUD en nuestro proyecto */
}
