import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        redirectTo: '/courses', //Redirije la raíz a la lista de cursos
        pathMatch: 'full'
    },
    {
        path: 'courses',
        loadChildren: () => import('./features/courses/courses.routes').then(m => m.COURSES_ROUTES)
    },
    {
        path: '**',
        redirectTo: '/courses'  //Ruta comodin para URL no definidas
    }
];
