import { Component, OnInit } from '@angular/core';
import { PersonaService } from '../persona-service';
import { Router, ActivatedRoute } from '@angular/router';
import { Persona } from '../persona.model';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styles: []
})
export class PersonasComponent implements OnInit {

  personas: Persona[] = [];

  constructor(private personaService: PersonaService,
              private router: Router,
              private route: ActivatedRoute) { }

  //creamos nuestro metodo para inizialirar las personas
  ngOnInit(): void{
    //Este metodo obtener personas nos regresa un subscriber
    this.personaService.obtenerPersonas()
      .subscribe(
        (personasObtenidas: Persona[]) => {
          //cargamos los datos de persona obtenidos en el arreglo local
          this.personas = personasObtenidas;
          this.personaService.setPersonas(this.personas);
          console.log('personas obtenidas del subscriber:' + this.personas);
        }
      );
  }

  //Este metodo se mandara a llamar desde el documento HTML personas.component.html
  irAgregar(){
    console.log('nos vamos a agregar');
    //hacemos el cambio navitage = definimos la ruta que nos queremos ir donde definimos en routing 
    this.router.navigate(['./personas/agregar']);
  }

}
