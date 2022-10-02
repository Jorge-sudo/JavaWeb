import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonasComponent } from './personas/personas.component';
import { FormularioComponent } from './formulario/formulario.component';


const routes: Routes = [
  {path: '', component: PersonasComponent},
  //agregamos el path de personas que se mandara a llamarse, pero tambien este path tendra path hijoscon children como agregar
  //y eliminar con el ID
  {path: 'personas', component: PersonasComponent, children:[
    {path: 'agregar', component: FormularioComponent},
    {path: ':idPersona', component: FormularioComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
