package com.example.demo.servicio;

import com.example.demo.entidades.Auto;
import java.util.Optional;

public interface IAutoService {
    Auto crear(Auto auto);
    Optional<Auto> mostrarAutoId(Long id);
    Auto actualizar(Long id, double nuevoPrecio);
    boolean eliminar(Long id);
}
