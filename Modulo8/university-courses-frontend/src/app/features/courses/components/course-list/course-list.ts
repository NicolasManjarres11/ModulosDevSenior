import { Component, OnInit, signal, computed, effect } from '@angular/core';
import { CommonModule } from "@angular/common";
import { FormsModule, NgModel } from '@angular/forms';
import { Course } from '../../models/course.model';
import { CourseCardSignal } from '../course-card-signal/course-card-signal';
import { CourseCardTraditional } from '../course-card-traditional/course-card-traditional';
import { CourseService } from '../../services/course-service/course-service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-course-list',
  imports: [
    CommonModule, 
    FormsModule,
    CourseCardSignal],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  //Para almacenar la lista de cursos
  courses: Course[] = [];

  //Para guardar los cursos y permitir el filtrado
  allCourses = signal<Course[]>([]);

  //Propiedad para el cambo de busqueda
  filterTerm = signal<string>('');

  //Simulación de carga
  loading= signal<boolean>(true);

  //Propiedad para el error
  error = signal<string | null>(null);

  filteredCourses = computed(() => {

    const currentFilter = this.filterTerm().toLowerCase();

    if(!currentFilter){
      return this.allCourses()
    } else {
      return this.allCourses().filter(c => 
        c.code.toLowerCase().includes(currentFilter) ||
        c.name.toLowerCase().includes(currentFilter)
      );
    }

  });

  constructor(private courseService: CourseService,private router: Router){
    effect(() => {
      console.log(`El filtro del departamento ha cambiado a: "${this.filterTerm()}"`);
      
    })
  }

  ngOnInit(): void {

    this.loading.set(true);
    this.error.set(null);

    // Carga los cursos usando el servicio
    this.courseService.getAllCourses()
      .then(courses => {
        // Actualizar la signal allCourses con los datos del servicio
        this.allCourses.set(courses);
        this.loading.set(false);
      })
      .catch(err => {
        console.error('Error al cargar los cursos:', err);
        this.error.set('Error al cargar los cursos desde el servicio.');
        this.loading.set(false);
      });

  }

 // Método para actualizar la Signal 'filterTerm' desde el input del filtro

  onFilterInputChange(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    this.filterTerm.set(inputElement.value)
  }

  handleEnrollCourse(courseId: number): void {
    //Actualiza la Signal 'allCourses' de forma inmutable

/*     this.allCourses.update(currentCourses => 
      currentCourses.map(course => 
        course.id === courseId && course.enrolledStudents < course.maxStudents
        ? {...course, enrolledenrolledStudents: course.enrolledStudents + 1}
        : course
      )
    );

    console.log(`Inscrito con el curso con ID: ${courseId}`); */

    this.courseService.enrollStudent(courseId);
    console.log(`Inscrito en el curso con ID: ${courseId} (a través del servicio)`);
    
  }

  handleViewCourseDetails(courseId: number): void {
    console.log(`Ver detalles del curso con ID: ${courseId}`);
    // Aquí podrías navegar a una página de detalles o abrir un modal
    alert(`Has hecho clic en 'Ver Detalles' para el curso con ID: ${courseId}`);
  }


  //Filtro del curso
/* 
  filterCourse(): void {

    //Si no hay algún valor en la propiedad FilterTerm, mostrará todos los cursos
    if (!this.filterTerm) {
      this.courses = this.allCourses;
    }
    else {
      //Solo mostrará los cursos en los que el filterTerm coincida con el nombre
      this.courses = this.allCourses.filter(c =>
        c.name.toLowerCase().includes(this.filterTerm.toLowerCase()) ||
        c.code.toLowerCase().includes(this.filterTerm.toLowerCase())
      );
    }
  } */



}
