import { Routes } from '@angular/router';
import {PropertyList } from "./features/properties/component/property-list/property-list"
import { property_routes } from './features/properties/properties.route';
import { auth_routes } from './features/auth/auth.routes';

export const routes: Routes = [
    {
        path:'',
        redirectTo: 'properties',
        pathMatch: 'full'
    
    },
    {
        path: 'properties',
        loadChildren: () => import('./features/properties/properties.route').then(r => r.property_routes)
    },
    {
        path: '',
        loadChildren: () => import('./features/auth/auth.routes').then(r => r.auth_routes)
    }
];
