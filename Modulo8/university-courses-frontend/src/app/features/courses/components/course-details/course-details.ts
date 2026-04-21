import { CommonModule } from '@angular/common';
import { Component, effect, input, signal } from '@angular/core';
import { CourseService } from '../../services/course-service/course-service';
import { Router } from '@angular/router';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-details',
  imports: [CommonModule],
  templateUrl: './course-details.html',
  styleUrl: './course-details.css'
})
export class CourseDetails {

  courseId = input<string | undefined>();

  numericCouseId = signal<number | undefined>(undefined);

  courseDetails = signal<Course | undefined>(undefined);
  loading = signal<boolean>(true);
  error = signal<string | null>(null);



  constructor(private courseService: CourseService, private router: Router) {
    effect(() => {

      const idString = this.courseId();

      if(idString){
        const idNum = parseInt(idString, 10);

        if(!isNaN(idNum)){
          this.numericCouseId.set(idNum);
          this.loadCourseDetails(idNum);
        } else {
          this.error.set('ID del curso inválido.');
          this.loading.set(false);
        }
      } else{
        this.error.set('ID de curso no proporcionado.');
        this.loading.set(false);
      }

    })
  }

  private loadCourseDetails(id: number): void{
    this.loading.set(true);
    this.error.set(null);
    this.courseDetails.set(undefined);

    this.courseService.getCourseById(id)
      .then(course => {
        this.courseDetails.set(course);
        this.loading.set(false);
        if(!course){
          this.error.set('Curso no encontrado.');
        }
      })
      .catch( err => {
        console.error('Error al cargar los detalles del curso:', err);
        this.error.set('Error al cargar los detalles del curso.');
        this.loading.set(false);
      })
  }

    /**
   * Navega de vuelta a la lista de cursos.
  */
    goBack(): void {
      this.router.navigate(['/courses']); // Navegación programática
    }

}
