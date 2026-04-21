import { Routes } from "@angular/router";
import { PropertyList } from "./components/property-list/property-list";

export const propertyRoutes: Routes = [
 {
                path: '',
                component: PropertyList,
            },
            {
                path: 'new',
                loadComponent: () =>
                    import(
                        './components/property-form/property-form'
                    ).then((c) => c.PropertyForm),
            },
            {
                path: ':id',
                loadComponent: () =>
                    import(
                        './components/property-detail/property-detail'
                    ).then((c) => c.PropertyDetail),
            }
];