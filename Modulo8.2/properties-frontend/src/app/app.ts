import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PropertyList } from "./features/properties/components/property-list/property-list";

@Component({
  selector: 'app-root',
  imports: [PropertyList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {


}
