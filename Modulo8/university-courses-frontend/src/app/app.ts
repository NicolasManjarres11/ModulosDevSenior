import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CourseList } from './features/courses/components/course-list/course-list';
import { CourseCardTraditional } from './features/courses/components/course-card-traditional/course-card-traditional';
import { CourseCardSignal } from './features/courses/components/course-card-signal/course-card-signal';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CourseList, CourseCardTraditional, CourseCardSignal],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('university-courses-frontend');
}
