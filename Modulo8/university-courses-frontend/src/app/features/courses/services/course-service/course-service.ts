import { Component, Injectable, signal } from '@angular/core';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-service',
  imports: [],
  templateUrl: './course-service.html',
  styleUrl: './course-service.css'
})

@Injectable({
  providedIn: 'root' //Este servicio será un singleton en toda la aplicación
})

export class CourseService {

  //Se gestionará los datos de los cursos como una signal

  private courseData = signal<Course[]>([
    
    {
      id: 1,
      code: 'CS101',
      name: 'Introducción a la Programación',
      credits: 3,
      department: 'Ciencias de la Computación',
      enrolledStudents: 25,
      maxStudents: 30,
      professor: 'Dr. Ana Pérez',
      description: 'Fundamentos de programación utilizando Python.',
      imageUrl: 'https://placehold.co/400x200/E0E0E0/333333?text=CS101'
    },
    {
      id: 2,
      code: 'MA203',
      name: 'Cálculo Multivariable',
      credits: 4,
      department: 'Matemáticas',
      enrolledStudents: 18,
      maxStudents: 25,
      professor: 'Prof. Juan García',
      description: 'Estudio de funciones de varias variables, derivadas parciales e integrales múltiples.',
      imageUrl: 'https://placehold.co/400x200/D0D0D0/444444?text=MA203'
    },
    {
      id: 3,
      code: 'HI301',
      name: 'Historia Universal',
      credits: 3,
      department: 'Historia',
      enrolledStudents: 32,
      maxStudents: 35,
      professor: 'Dra. Laura Gómez',
      description: 'Recorrido por los eventos y civilizaciones más importantes de la historia.',
      imageUrl: 'https://placehold.co/400x200/C0C0C0/555555?text=HI301'
    },
    {
      id: 4,
      code: 'PH101',
      name: 'Filosofía Antigua',
      credits: 3,
      department: 'Filosofía',
      enrolledStudents: 20,
      maxStudents: 28,
      professor: 'Prof. Carlos Ruiz',
      description: 'Exploración de las principales corrientes filosóficas de la antigüedad.',
      imageUrl: 'https://placehold.co/400x200/B0B0B0/666666?text=PH101'
    },
    {
      id: 5,
      code: 'CS205',
      name: 'Estructuras de Datos',
      credits: 4,
      department: 'Ciencias de la Computación',
      enrolledStudents: 22,
      maxStudents: 30,
      professor: 'Dr. Ana Pérez',
      description: 'Implementación y análisis de estructuras de datos fundamentales.',
      imageUrl: 'https://placehold.co/400x200/A0A0A0/777777?text=CS205'
    }
  ]);


  courses = this.courseData.asReadonly();

  constructor() {
    
  }


  getAllCourses(): Promise<Course[]>{
    return new Promise(resolve => {
      setTimeout(() => {
        resolve(this.courseData()); //Devuelve el valor actual de la Signal de cursos
      }, 500); 
    })
  }


  getCourseById(id: number): Promise<Course | undefined>{
    return new Promise(resolve => {
      setTimeout(() => {
        const course = this.courseData().find(c => c.id === id);
        resolve(course);
      }, 300);
    })
  }

  enrollStudent(courseId: number): void {
    this.courseData.update(currentCourse => 
      currentCourse.map(course => 
        course.id === courseId && course.enrolledStudents < course.maxStudents
        ? {...course, enrollStudent: course.enrolledStudents + 1}
        : course
      )
    ); console.log(`[CourseService] Estudiante inscrito en el curso con ID: ${courseId}`);
    
  }

}
