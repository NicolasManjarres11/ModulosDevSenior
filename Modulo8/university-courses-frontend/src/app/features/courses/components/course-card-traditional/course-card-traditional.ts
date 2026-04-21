import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-card-traditional',
  imports: [CommonModule],
  templateUrl: './course-card-traditional.html',
  styleUrl: './course-card-traditional.css'
})
export class CourseCardTraditional {

  @Input() course!: Course;

  @Output() enrollCourse = new EventEmitter<number>(); //Emite el ID del curso para inscripción
  @Output() viewDetails = new EventEmitter<number>(); //Emite el ID del curso para ver detalles

  get isFull(): boolean{
    return this.course.enrolledStudents >= this.course.maxStudents;
  }


  onEnrollClick(): void{

    if(!this.isFull){
      alert('Intentando inscribir al curso (Tradicional): '+ this.course.name)
      this.enrollCourse.emit(this.course.id);
    } else{
      alert('Este curso está lleno y no se puede inscribir (Tradicional).');
    }
  
  }

  

  onViewDetailsClick(): void {
    this.viewDetails.emit(this.course.id)
  }

}
