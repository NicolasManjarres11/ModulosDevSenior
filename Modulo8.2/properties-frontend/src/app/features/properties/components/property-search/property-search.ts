import { Component, computed, input, output, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-property-search',
  imports: [FormsModule],
  templateUrl: './property-search.html',
  styleUrl: './property-search.css',
})
export class PropertySearch {

  readonly placeholder = input.required<String>();
  readonly search = output<String>();

  protected queryString = signal<String>('');
  protected isValid = computed<boolean>(() => {
    console.log(this.queryString());
    
    return this.queryString().trim().length !== 0
  });

  onSearch() : void {
    if(this.isValid()){
      this.search.emit(this.queryString().trim());
    }
  }

}
