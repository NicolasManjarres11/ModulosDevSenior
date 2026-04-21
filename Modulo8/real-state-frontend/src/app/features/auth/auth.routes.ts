import { Routes } from '@angular/router';

export const auth_routes: Routes = [
  {
    path: 'login',
    loadComponent: () => import('./component/login/login').then(c => c.LoginComponent)
  },
  {
    path: 'register',
    loadComponent: () => import('./component/register/register').then(c => c.RegisterComponent)
  },
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  }
];
