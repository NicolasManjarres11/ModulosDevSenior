import { Component, computed, input, output } from '@angular/core';
import { Course } from '../../models/course.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-course-card-signal',
  imports: [CommonModule],
  templateUrl: './course-card-signal.html',
  styleUrl: './course-card-signal.css'
})
export class CourseCardSignal {

  // Recibe un objeto Course del componente padre usando input()
  // 'required' significa que el padre DEBE proporcionar este input.

  course = input.required<Course>();

  //Emite el ID del curso para inscripción usando Output()
  enrollCourse = output<number>();

  //Emite el Id del curso para ver el detaller
  viewDetails = output<number>();

  // Signal computada para saber si el curso está lleno.
  // Se recalcula automáticamente cuando 'course().enrolledStudents' o 'course().maxStudents' cambian.
  isFull = computed(() => this.course().enrolledStudents >= this.course().maxStudents);

  onEnrollClick(): void {

    if(!this.isFull){

      alert('Intentando inscribir al curso (Signals): '+this.course().name);
      // Accede al valor de la Signal 'course' llamándola como función
      this.enrollCourse.emit(this.course().id);
    } else{
      alert('Este curso está lleno y no se puede inscribir (Signals)')
    }

  }

  onViewDetailsClick(): void {
    // Accede al valor de la Signal 'course' llamándola como función
    this.viewDetails.emit(this.course().id)
  }


}
