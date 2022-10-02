//Esta clase de dataService solo se encarga de recuperar informacion y no de administrar el arreglo de personas

//import {lo que importaremos } from "de donde lo importaremos"
import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import { Persona } from './persona.model';

/* Esta clase es para conectarnos con el cliente HTTP de angular al Servicio Web de java Con JAX-RS */
@Injectable()//Con esto ya configuramos nuestra clase para que sea un servicio y se pueda itilizar desde otras partes
export class DataService {

  //El constructor recibira 1 variable privada de tipo HttpClient
  constructor(private httpClient: HttpClient) {}

  //Agregamos la variable que contendra la URL de nuestro servicio web
  urlBase = 'http://localhost:8080/Backend_API-REST/webservice/personas';

  //este metodo hace una llamada web al webServices de listar personas el por default
  cargarPersonas(){
    //Con esto es suficiente para que nos regrese el listado de personas
    return this.httpClient.get(this.urlBase);
    //Debido a que no nos estamos suscribiendo desde esta llamada get pero la hara otra clase llamada
    //PersonaServices la cual se encargara de administrar el arreglo de personas
  }

  agregarPersona(persona: Persona){
    //insertar persona con el metodo POST
    return this.httpClient.post(this.urlBase, persona);
  }

  modificarPersona(idPersona: number, persona: Persona){
    //declaramos otra variable
    let url: string;
    url = this.urlBase + '/' + idPersona;
    //En este caso si nos suscribiremos ya que recuperaremos el objeto modificado
    this.httpClient.put(url, persona)
      .subscribe(
        (response) => {//en casode exito se envia la respuesta a la consola
          console.log('resultado modificar persona: ' + response);
        }, //en dado caso de error se manda un mensaje a la consola
        (error) => console.log('Error en modificar persona:' + error)
      );
  }

  eliminarPersona(idPersona: number){
    let url: string;
    url = this.urlBase + '/' + idPersona;
    this.httpClient.delete(url)
    .subscribe(
      (response) => {//en casode exito se envia la respuesta a la consola
        console.log('resultado eliminar persona: ' + response);
      },//en dado caso de error se manda un mensaje a la consola
      (error) => console.log('Error en eliminar persona:' + error)
    );
  }



}
