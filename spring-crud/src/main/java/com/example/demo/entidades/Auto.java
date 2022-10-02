package com.example.demo.entidades;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*Utilizando Lombok vamos a utilizar esta anotacion, esta nos permitira saber que esta clase se
podra acceder a esta clase */
@Data
@Entity
public class Auto {
    @Id /*Esto es una anotacion para identificar cual sera la clave primaria en el sistema de base de datos
    en este caso en la Entidad Auto*/
    private Long id;
    private String marca;
    private int anno;
    private int capacidad;
    private double precio;

}
