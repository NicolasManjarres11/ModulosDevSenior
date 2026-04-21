import { Routes } from '@angular/router';
import { CourseList } from './components/course-list/course-list';
import { CourseDetails } from './components/course-details/course-details';

export const COURSES_ROUTES: Routes = [
{ 
    path: '', 
    component: CourseList 
}, // Ruta base para /courses
{ 
    path: ':id', 
    component: CourseDetails 
}, // Ruta para /courses/:id
];