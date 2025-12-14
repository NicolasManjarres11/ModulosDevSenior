import { Routes } from '@angular/router';
import { PropertyList } from './features/properties/components/property-list/property-list';
import { PropertyForm } from './features/properties/components/property-form/property-form';
import { PropertyDetail } from './features/properties/components/property-detail/property-detail';
import { NotFound } from './features/properties/components/not-found/not-found';

export const routes: Routes = [
    {
        path: '',
        redirectTo: '/properties',
        pathMatch: 'full',
    },
    {
        path: 'properties',
        loadChildren: () => import('./features/properties/routes').then(m => m.propertyRoutes)
    },

    {
        path: '**',
        loadComponent: () =>
            import('./features/properties/components/not-found/not-found').then(
                (c) => c.NotFound
            ),
    },
];
