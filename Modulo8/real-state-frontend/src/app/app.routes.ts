import { Routes } from '@angular/router';
import {PropertyList } from "./features/properties/component/property-list/property-list"
import { property_routes } from './features/properties/properties.route';


export const routes: Routes = [
    {
        path:'',
        redirectTo: 'properties',
        pathMatch: 'full'
    
    },
    {
        path: 'properties',
        loadChildren: () => import('./features/properties/properties.route').then(r => r.property_routes)
    }
];
