import { Injectable } from "@angular/core";
import { Property } from "../model/property";
import { delay, Observable, of, throwError } from "rxjs";

@Injectable({
    providedIn: 'root'  //lugar de la memoria en el que se guarda la inversión de clase
})
export class PropertyService{
    private properties: Property[] = [];


    constructor(){

      this.loadProperties();

/*          this.properties = ([
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
      id: 3,
      address: "Cra 14 # 15-5",
      description: " Una gran casa Y SUPER CASA, MUY GRANDE Y COMODA",
      price: 2100,
      city: "Cartagena",
      bedrroms: 6,
      bathroom:2,
      image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCneQZOER6juUwx45rv6fKvsVHysSd1zDoww&s"
    },
        {
      id: 4,
      address: "Cra 14 # 15-5",
      description: " Una gran casa Y SUPER CASA, MUY GRANDE Y COMODA",
      price: 2100,
      city: "Cartagena",
      bedrroms: 6,
      bathroom:2,
      image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCneQZOER6juUwx45rv6fKvsVHysSd1zDoww&s"
    }
  ]) */
    }

    private loadProperties(): void{
      const data = localStorage.getItem('properties');
      if(data !== null){
        const jsonData = JSON.parse(data);
        this.properties = jsonData;
      }
      else{
        this.properties = [];
      }
    }

    private saveProperties(): void {
      const jsonData = this.properties;
      const data = JSON.stringify(jsonData);
      localStorage.setItem('properties',data);
    }

    getAll(): Observable<Property[]>{
        return of(this.properties).pipe(delay(300));
    }

    getById(id: number): Observable<Property | undefined>{
      return of(this.properties.find(p => p.id === id)).pipe(delay(300))
    }

    getByCity(city: String): Observable<Property[]>{
      return of(this.properties.filter(p => p.city.toLowerCase().includes(city.toLowerCase())) ).pipe(delay(300));
    }
    getByDescription(description: String): Observable<Property[]>{
      return of(this.properties.filter(p => p.description.toLowerCase().includes(description.toLowerCase())) ).pipe(delay(300));
    }

    create (info: Omit<Property, 'id'>): Observable<undefined>{
      //Busco que el id no sea repetido, sino, error.

      //Si el id esta vacio, genera un nuevo id

        const maxId = this.properties.length === 0 ? 0 : this.properties.map(p => p.id).reduce((a,b) => a > b ? a : b);
        const newProperty: Property = {...info, id: maxId + 1};

      console.log("Propiedad agregada");
      
      this.properties = [...this.properties, newProperty];
      this.saveProperties();
      return of(undefined).pipe(delay(300));
    }
}