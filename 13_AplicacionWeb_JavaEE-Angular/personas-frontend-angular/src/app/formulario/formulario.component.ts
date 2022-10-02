import { Component, OnInit } from '@angular/core';
import { PersonaService } from '../persona-service';
import { Router, ActivatedRoute } from '@angular/router';
import { Persona } from '../persona.model';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styles: []
})
export class FormularioComponent implements OnInit {

  //Definimos las variables la cual utilizaremos para insertar la persona
  idPersona: number;
  nombreInput: string;

  //injectamos en el contructor el componente de personaService
  constructor(private personaService: PersonaService,
              private router: Router,
              private route: ActivatedRoute
    ) { }

    //metodo de inicio=init
  ngOnInit() {
    //con el this.route.snapshot.params.idPersona nos devolvera el parametro del idPersona
    this.idPersona = this.route.snapshot.params.idPersona;
    //mandamos a la consola
    console.log('recuperamos el parametro idPersona:' + this.idPersona);
    //si idPersona es diferente a null
    if(this.idPersona != null){
      //encontramos la persona con el id y se asigna al objeto persona
      const persona = this.personaService.encontrarPersona(this.idPersona);
      //si la persona es diferente a null
      if(persona != null){
        //cargamos la persona en el campo de nombre de input
        this.nombreInput = persona.nombre;
      }
    }

  }

  /*Este metodo es para guardar una persona que se le llama desde el documento HTML */
  onGuardarPersona(){
    //variable persona con valores nulos
    const personaAGuardar = new Persona(this.idPersona, this.nombreInput);
    //si idPersona es diferente de null entonces se debe de modificar y no guardar
    if(this.idPersona != null){
      this.personaService.modificarPersona(this.idPersona, personaAGuardar);
    }
    else{
      //aqui es donde guardamos la persona en la base de datos
      this.personaService.agregarPersona(personaAGuardar);
    }
    //navegamos hacia el path de personas
    this.router.navigate(['personas']);
  }

  //metodo eliminar persona que  sera llamada desde el documento HTML
  onEliminarPersona(){
    //preguntamos si la idPersona es diferente a null
    if(this.idPersona != null){
      console.log('persona a eliminar:' + this.idPersona);
      //eliminamos la persona
      this.personaService.eliminarPersona(this.idPersona);
    }
    //hacemos una navegacion al path de personas=listado de personas
    this.router.navigate(['personas']);
  }

}
