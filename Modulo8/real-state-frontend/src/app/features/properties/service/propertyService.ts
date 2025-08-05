import { Injectable, signal } from '@angular/core';
import { Property } from '../model/property.model';

@Injectable({
  providedIn: 'root'
})
export class PropertyService {

  private properties = signal<Property[]>( [
    {
      id: 1,
      address: '123 Main St',
      city: 'New York',
      price: 950000,
      bedrooms: 3,
      bathrooms: 2,
      imageUrl: 'https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=800&q=80',
      description: 'Hermoso departamento en el corazón de Manhattan, cerca de Central Park.'
    },
    {
      id: 2,
      address: '456 Ocean Drive',
      city: 'Miami',
      price: 1200000,
      bedrooms: 4,
      bathrooms: 3,
      imageUrl: 'https://images.unsplash.com/photo-1460518451285-97b6aa326961?auto=format&fit=crop&w=800&q=80',
      description: 'Casa moderna frente al mar con piscina privada y acceso directo a la playa.'
    },
    {
      id: 3,
      address: '789 Sunset Blvd',
      city: 'Los Angeles',
      price: 2100000,
      bedrooms: 5,
      bathrooms: 4,
      imageUrl: 'https://images.unsplash.com/photo-1507089947368-19c1da9775ae?auto=format&fit=crop&w=800&q=80',
      description: 'Mansión de lujo en Beverly Hills con vistas panorámicas de la ciudad.'
    },
    {
      id: 4,
      address: '321 Maple Ave',
      city: 'Chicago',
      price: 670000,
      bedrooms: 3,
      bathrooms: 2,
      imageUrl: 'https://images.unsplash.com/photo-1512918728675-ed5a9ecdebfd?auto=format&fit=crop&w=800&q=80',
      description: 'Acogedora casa familiar en un barrio tranquilo, cerca de parques y escuelas.'
    },
    {
      id: 5,
      address: '654 Mountain Rd',
      city: 'Denver',
      price: 850000,
      bedrooms: 4,
      bathrooms: 3,
      imageUrl: 'https://images.unsplash.com/photo-1523217582562-09d0def993a6?auto=format&fit=crop&w=800&q=80',
      description: 'Chalet con vistas a las montañas, ideal para los amantes de la naturaleza.'
    },
    {
      id: 6,
      address: '987 Lakeview Dr',
      city: 'Seattle',
      price: 780000,
      bedrooms: 3,
      bathrooms: 2,
      imageUrl: 'https://images.unsplash.com/photo-1465101046530-73398c7f28ca?auto=format&fit=crop&w=800&q=80',
      description: 'Casa moderna con vista al lago, rodeada de naturaleza y tranquilidad.'
    },
    {
      id: 7,
      address: '159 Pine St',
      city: 'Boston',
      price: 920000,
      bedrooms: 4,
      bathrooms: 3,
      imageUrl: 'https://images.unsplash.com/photo-1505691938895-1758d7feb511?auto=format&fit=crop&w=800&q=80',
      description: 'Elegante casa de estilo clásico en el centro histórico de Boston.'
    },
    {
      id: 8,
      address: '753 River Rd',
      city: 'Austin',
      price: 690000,
      bedrooms: 3,
      bathrooms: 2,
      imageUrl: 'https://images.unsplash.com/photo-1519985176271-adb1088fa94c?auto=format&fit=crop&w=800&q=80',
      description: 'Propiedad junto al río con amplio jardín y zona de barbacoa.'
    },
    {
      id: 9,
      address: '246 Palm Ave',
      city: 'San Diego',
      price: 1100000,
      bedrooms: 5,
      bathrooms: 4,
      imageUrl: 'https://images.unsplash.com/photo-1464037866556-6812c9d1c72e?auto=format&fit=crop&w=800&q=80',
      description: 'Residencia de lujo con piscina y palmeras, a minutos de la playa.'
    },
    {
      id: 10,
      address: '369 Oak Lane',
      city: 'Portland',
      price: 580000,
      bedrooms: 2,
      bathrooms: 2,
      imageUrl: 'https://images.unsplash.com/photo-1503389152951-9c3d8bca6c94?auto=format&fit=crop&w=800&q=80',
      description: 'Encantadora cabaña de madera en zona boscosa, perfecta para escapadas.'
    }

    ]);

  constructor(){}

  getAllProperties(): Promise<Property[]>  {

    
    return new Promise((resolve, reject) => {
      setTimeout (() => {

        
        resolve(this.properties());
        reject("No hay datos disponibles")
      }, 1500);
    });
  }

  getProperty(id: number): Promise<Property> {
    return new Promise((resolve, reject) => {

      setTimeout(() => {

        const property = this.properties()
          .filter(p => p.id == id);

        if(property.length == 0){
          reject(`No se ha encontrado la propiedad con id: ` + id)
        } else {
          resolve(property[0])
        }

      }, 500)

    })
  }

  addNewProperty(property : Property) : void{

    //Generar el id y agregarlo a la lista de elementos

    const newId = Math.max( ...this.properties().map( p => p.id)) + 1;

    const propertyToAdd = {...property, id: newId};

    this.properties.update( data => [...data, propertyToAdd]);

  }

  deleteProperty(id : number) : void{
    this.properties.update(data => data.filter(p => p.id !== id));
  }

  updateProperty(id: number, property: Property){
    
    this.properties.update(data => {
      const index = data.findIndex(p => p.id === id);
      if(index > -1){
        data[index] = property
      }
      return data;
    })
  }
}
