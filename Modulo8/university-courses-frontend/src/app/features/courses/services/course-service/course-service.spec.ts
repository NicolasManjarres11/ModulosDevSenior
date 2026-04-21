import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseService } from './course-service';

describe('CourseService', () => {
  let component: CourseService;
  let fixture: ComponentFixture<CourseService>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseService]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CourseService);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
