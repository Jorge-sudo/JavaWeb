import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DataService } from './data-service';
import { PersonaService } from './persona-service';
import { PersonasComponent } from './personas/personas.component';

@NgModule({
  declarations: [
    AppComponent,
    PersonasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  //importamos para que podamos utilizar los servicios
  providers: [PersonaService, DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
