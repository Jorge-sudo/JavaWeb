package com.example.demo.servicio;

import java.util.Optional;
import com.example.demo.entidades.Auto;
import com.example.demo.repositorio.AutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Con esto queremos decir que este componente es Inyectable
public class IAutoServiceImpl implements IAutoService {

    /*Para implementar los metodos utilizaremos inyeccion de dependencias que se llama una anotacion propia
    de Spring  con @Autowired nosotros podremos inyectar un objeto del repositorio en la capa de servicio
     */
    @Autowired
    private AutoRepositorio autoRepositorio;

    @Override
    public Auto crear(Auto auto) {
        return this.autoRepositorio.save(auto);
    }

    @Override
    public Optional<Auto> mostrarAutoId(Long id) {
        //FindById es un interfaz que nos pide un Id, por que este metodo nos buscara en la base de datos si existe o no
        return this.autoRepositorio.findById(id);
    }

    @Override
    public Auto actualizar(Long id, double nuevoPrecio) {
        return null;
    }

    @Override
    public boolean eliminar(Long id) {
        return false;
    }
}
