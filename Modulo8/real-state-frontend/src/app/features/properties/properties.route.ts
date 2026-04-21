import { Routes } from "@angular/router";

//En las rutas se debe tener presente las prioridades o el orden en el que se definen en la lista

export const property_routes: Routes = [

    {
        path: "",
        loadComponent: () => import ('./component/property-list/property-list').then(c => c.PropertyList),
    },
    {
        path:"new",
        loadComponent: () => import('./component/property-form/property-form').then(c => c.PropertyForm)
    },
    {
        path:"edit/:propertyId",
        loadComponent: () => import('./component/property-form/property-form').then(c => c.PropertyForm)
        
    },
    {
        path:":propertyId",
        loadComponent: () => import ('./component/property-detail/property-detail').then(c => c.PropertyDetail)
    }



]