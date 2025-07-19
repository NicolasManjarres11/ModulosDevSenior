import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PropertyList } from './features/properties/component/property-list/property-list';
import { SignalSample } from './features/samples/signal/signal-sample';
import { Lifecycle } from './features/samples/lifecycle/lifecycle';

@Component({
  selector: 'app-root', //Etiqueta en HTML
  imports: [PropertyList, SignalSample, Lifecycle], 
  templateUrl: './app.html', //Plantilla
  styleUrl: './app.css' //Plantilla
})
export class App {
  protected readonly title = ('Nicolas Real State');
}
