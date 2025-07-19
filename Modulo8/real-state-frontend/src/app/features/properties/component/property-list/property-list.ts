import { Component } from '@angular/core';
import { Property } from '../../model/property.model';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-property-list',
  imports: [CurrencyPipe],
  templateUrl: './property-list.html',
  styleUrl: './property-list.css'
})
export class PropertyList {

  properties: Property[] = [];
  loading: boolean =  false;
  error: string | null = null;

  constructor(){
    this.loadProperties();
  }

  loadProperties(): void {
    this.loading = true;
    this.error = null;

    setTimeout(() => {
      this.properties = [
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
      }

      ];

      this.loading=false;

    }, 1500)
  }

}
