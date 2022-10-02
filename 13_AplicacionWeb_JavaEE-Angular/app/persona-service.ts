import { DataService } from './data-service';
import { Injectable } from "@angular/core";
import { Persona } from "./persona.model";

//debido a que es un servicio y lo uutilizaremos en otras clases
@Injectable()
export class PersonaService {
  //esta clase va administrar el arreglo de personas asi que creamos la variable personas
  personas: Persona[] = []; //arreglo vacio

  //creamos el constructor con la clase de data-service
  constructor(private dataService:DataService){}

  //definimos el metodo set se usa para modificar el valor del arreglo debido a la llamada asincrona
  setPersonas(personas: Persona[]){
    this.personas = personas;
  }

  agregarPersona(persona: Persona){
    /*
    console.log('persona a agregar:' + persona.nombre);
        this.dataService.agregarPersona(persona)
            .subscribe(
                (persona: Persona) => {
                    console.log('Se agrega al arreglo la presona recien incertada subscriber: ' + persona.idPersona);
                    this.personas.push(persona);
                }
            );
    */
    let personaInsertada:Persona;
    console.log('persona a agregar: '+ persona.nombre);
    this.dataService.agregarPersona(persona);
      console.log('se agrega al arreglo la persona recien insertada suscriber:' + persona.idPersona
        + ' ' + persona.nombre);
      this.personas.push(persona);
  }

  encontrarPersona(id: number){
    //comparamos si el arreglo tiene el mismo id de la persona que recibimos y se asigna a al objeto persona
    const persona:Persona = this.personas.find(persona => persona.idPersona == id);
    console.log('p  ersona encontrada:' + persona.idPersona + ' ' + persona.nombre);
    return persona;
  }

  obtenerPersonas(){
    return this.dataService.cargarPersonas();
  }

  modificarPersona(id:number, persona:Persona){
    console.log('persona a modificar: '+ persona.idPersona);
    this.dataService.modificarPersona(id,persona);
  }

  eliminarPersona(id:number){
    console.log('eliminar persona con id: ' + id);
    const index = this.personas.findIndex(persona => persona.idPersona == id);//encontramos el indice en el arreglo
    //Con splice eliminamos el elemento (lugar, 1 elemento a eliminar)
    this.personas.splice(index,1);
    this.dataService.eliminarPersona(id);
  }

}
