import { Component, signal } from '@angular/core';
import { PropertyList } from './features/properties/component/property-list/property-list';


@Component({
  selector: 'app-root', //Etiqueta en HTML
  imports: [PropertyList], 
  templateUrl: './app.html', //Plantilla
  styleUrl: './app.css' //Plantilla
})
export class App {
  protected readonly title = ('Nicolas Real State');
}
