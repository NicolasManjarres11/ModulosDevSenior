package com.devsenior.nmanja.restful_project.services;

import java.util.List;

import com.devsenior.nmanja.restful_project.models.dto.CourseRequest;
import com.devsenior.nmanja.restful_project.models.dto.CourseResponse;

public interface CourseService {

    List<CourseResponse> getAll();

    CourseResponse getOne(Long id);
    
    List<CourseResponse> getByName(String name);

    CourseResponse create(CourseRequest course);

    CourseResponse update(Long id, CourseRequest course);

    void delete(Long id);
}
