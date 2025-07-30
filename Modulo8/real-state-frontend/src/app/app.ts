import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';


@Component({
  selector: 'app-root', //Etiqueta en HTML
  imports: [RouterOutlet], 
  templateUrl: './app.html', //Plantilla
  styleUrl: './app.css' //Plantilla
})
export class App {
  
}
