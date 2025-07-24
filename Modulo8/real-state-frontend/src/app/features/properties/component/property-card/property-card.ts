import { Component, EventEmitter, input, Input, output, Output } from '@angular/core';
import { Property } from '../../model/property.model';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-property-card',
  imports: [CurrencyPipe],
  templateUrl: './property-card.html',
  styleUrl: './property-card.css'
})
export class PropertyCard {


  data = input.required<Property>() ; //Campo obligatorio


  num = input<number>(1) ;  //Campo opcional

  detail = output<number>();

  onClickDetails(){
    this.detail.emit(this.data().id); 
  }

}
