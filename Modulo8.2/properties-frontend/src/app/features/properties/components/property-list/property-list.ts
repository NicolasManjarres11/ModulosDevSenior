import { Component, computed, effect, inject, OnInit, signal } from '@angular/core';
import { Property } from '../../model/property';
import { PropertyCard } from "../property-card/property-card";
import { PropertyService } from '../../service/property-service';
import { Router, RouterLink } from "@angular/router";
import { PropertySearch } from "../property-search/property-search";

@Component({
  selector: 'app-property-list',
  imports: [PropertyCard, RouterLink, PropertySearch],
  templateUrl: './property-list.html',
  styleUrl: './property-list.css',
})
export class PropertyList implements OnInit{

  protected readonly isLoading = signal<boolean>(true);
  protected readonly properties = signal<Property[]>([]);
  protected readonly total = computed(() => this.properties().length);

  private propertyService = inject(PropertyService);
  private router = inject(Router);


  //constructor(private propertyService: PropertyService){
  constructor(){
    effect(() => {
      console.log(`Ha cambiado la información de propiedades y ahora hay ${this.total()} propiedades`);
      
    })
  }

ngOnInit(): void {
  
  this.isLoading.set(true);

  this.propertyService.getAll().subscribe({
    next: (data) => {
      this.properties.set(data);
      this.isLoading.set(false);
    },
    error: () => {
      console.error("Ocurrió un problema al obtener las propiedades");
      
    },
  });

  


/*   this.properties.update(current => {
    current.push(
      {
      id: 1,
      address: "Cra 1 2 # 654",
      description: " Una buena casa, muy bien ubicada en el sector.",
      price: 2000,
      city: "Bogota",
      bedrroms: 3,
      bathroom:2,
      image: "https://agentrealestateschools.com/wp-content/uploads/2021/11/real-estate-property.jpg"
    });
    current.push(
 {
      id: 2,
      address: "Cra 465 # 15-945",
      description: " Una gran casa",
      price: 3500,
      city: "Cali",
      bedrroms: 4,
      bathroom:3,
      image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCneQZOER6juUwx45rv6fKvsVHysSd1zDoww&s"
    });
    
    return current;
  }) */
  
   ;
}

  showDetails(id: number): void{
    //alert(`Ver detalles de la propiedad ${id}`);

    this.router.navigate(['properties', id]);

  }
  
  protected propertiesold: Property[] = [
    {
      id: 1,
      address: "Cra 1 2 # 654",
      description: " Una buena casa, muy bien ubicada en el sector.",
      price: 2000,
      city: "Bogota",
      bedrroms: 3,
      bathroom:2,
      image: "https://agentrealestateschools.com/wp-content/uploads/2021/11/real-estate-property.jpg"
    },
    {
      id: 2,
      address: "Cra 465 # 15-945",
      description: " Una gran casa",
      price: 3500,
      city: "Cali",
      bedrroms: 4,
      bathroom:3,
      image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCneQZOER6juUwx45rv6fKvsVHysSd1zDoww&s"
    },
    {
      id: 2,
      address: "Cra 14 # 15-5",
      description: " Una gran casa Y SUPER CASA, MUY GRANDE Y COMODA",
      price: 2100,
      city: "Cartagena",
      bedrroms: 6,
      bathroom:2,
      image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCneQZOER6juUwx45rv6fKvsVHysSd1zDoww&s"
    },
    {
      id: 3,
      address: "Cra 14 # 15-5",
      description: " Una gran casa Y SUPER CASA, MUY GRANDE Y COMODA",
      price: 2100,
      city: "Cartagena",
      bedrroms: 6,
      bathroom:2,
      image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCneQZOER6juUwx45rv6fKvsVHysSd1zDoww&s"
    }
  ]

  onSearchCityButton(city: String){

    this.isLoading.set(true);

    this.propertyService.getByCity(city)
      .subscribe({
        next: (data) => {
          this.properties.set(data);
          this.isLoading.set(false);

        },
        error: () => {
          alert('Error al consultar por ciudad');
          this.isLoading.set(false);

        }
      })
  }
  onSearchDescriptionButton(description: String){

    this.isLoading.set(true);

    this.propertyService.getByDescription(description)
      .subscribe({
        next: (data) => {
          this.properties.set(data);
          this.isLoading.set(false);

        },
        error: () => {
          alert('Error al consultar por ciudad');
          this.isLoading.set(false);

        }
      })
  }
}
