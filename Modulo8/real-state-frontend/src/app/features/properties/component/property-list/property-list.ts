import { Component, effect, inject, OnInit, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Property } from '../../model/property.model';
import { CurrencyPipe } from '@angular/common';
import { PropertyCard } from '../property-card/property-card';
import { PropertyService } from '../../service/propertyService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-property-list',
  imports: [PropertyCard, FormsModule],
  templateUrl: './property-list.html',
  styleUrl: './property-list.css'
})
export class PropertyList implements OnInit{

  protected readonly title = ('Nicolas Real State');

  allProperties = signal<Property[]>([]);
  properties = signal<Property[]>([]);
  loading = signal<boolean>(false);
  error = signal<string | undefined>(undefined);

  filterCity = signal<string>("");

  constructor( private service : PropertyService, private router:Router ){
    effect(() => {
      if(!this.filterCity()){
        this.properties.set(this.allProperties());
      } else{
        this.properties.set(this.allProperties()
          .filter((p) => p.city.toLowerCase().includes(this.filterCity().toLowerCase()))
      );
      }

    })
  }


  ngOnInit(): void {
    this.loadProperties();
  }

  showDetail(id: number){
    this.router.navigate(['properties', id]);
  }

  searchProperties(){
/*     if(!this.filterCity){
      this.properties = this.allProperties;
    } else{
      this.properties = this.allProperties
        .filter(p => p.city.toLowerCase().includes(this.filterCity.toLowerCase()));
    } */
  }

  private loadProperties(): void {

    
    this.loading.set(true);
    this.error.set(undefined);

    this.service.getAllProperties()
        .then(data => {

          
          this.allProperties.set(data);
          this.properties.set(this.allProperties());
          this.loading.set(false)

          
        })
        .catch(error =>
          this.error.set(error));

  }

}
