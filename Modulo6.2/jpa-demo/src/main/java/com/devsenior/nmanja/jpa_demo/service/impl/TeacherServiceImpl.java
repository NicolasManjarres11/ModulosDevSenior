package com.devsenior.nmanja.jpa_demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.devsenior.nmanja.jpa_demo.model.DTO.TeacherCreateRequest;
import com.devsenior.nmanja.jpa_demo.model.DTO.TeacherResponse;
import com.devsenior.nmanja.jpa_demo.model.entity.City;
import com.devsenior.nmanja.jpa_demo.model.entity.Teacher;
import com.devsenior.nmanja.jpa_demo.repository.CityRepository;
import com.devsenior.nmanja.jpa_demo.repository.CustomRepository;
import com.devsenior.nmanja.jpa_demo.repository.TeacherRepository;
import com.devsenior.nmanja.jpa_demo.service.TeacherService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;
    private final CityRepository cityRepository;
    private final CustomRepository customRepository;



    public TeacherServiceImpl(TeacherRepository teacherRepository,CityRepository cityRepository, CustomRepository customRepository) {
        this.teacherRepository = teacherRepository;
        this.cityRepository = cityRepository;
        this.customRepository = customRepository;
    }



    @Override
    public List<TeacherResponse> getAll() {
        var teachers = teacherRepository.findAll();

        var teacherResponse = teachers.stream()
        .map(this::toResponse)
        .toList();

        return teacherResponse;
    }

    @Override
    public TeacherResponse create(TeacherCreateRequest teacher) {

        var newEntity = teacherRepository.save(toEntity(teacher));

        return toResponse(newEntity);

    }


    private Teacher toEntity(TeacherCreateRequest teacher){

        var city = cityRepository.findById(teacher.getCity());
        return new Teacher(
            teacher.getDocument(),
            teacher.getFirstName(),
            teacher.getSecondName(),
            teacher.getLastname(),
            teacher.getSecondLastname(),
            teacher.getEmail(),
            teacher.getIndicative(),
            teacher.getPhoneNumber(),
            teacher.getAddress(),
            teacher.getAditionalAddress(),
            city.orElseGet(() -> {
                var entity = new City(teacher.getCity());
                entity = cityRepository.save(entity);
                return entity;
            }),
            teacher.getSalary()
        );
    }

    private TeacherResponse toResponse(Teacher teacher){

        var response = new TeacherResponse();
            response.setDocument(teacher.getDocument());
            response.setFisrtName(teacher.getFirstName() + 
                (teacher.getSecondName() == null ? " " : " " + teacher.getSecondName()));
            response.setLastName(teacher.getLastname() + 
                (teacher.getSecondLastname() == null ? " " : " " + teacher.getSecondLastname()));
            response.setEmail(teacher.getEmail());
            response.setPhone((teacher.getIndicative() == null ? " " : teacher.getIndicative()) + 
                        " " + teacher.getPhoneNumber());
            response.setAddress(teacher.getAddress() + 
                    (teacher.getAditionalAddress() == null ? " ": " " + teacher.getAditionalAddress()));
            response.setCity(teacher.getCity().getName());
            var city = cityRepository.findById(teacher.getCity().getName());
            if(city.isPresent()){
                response.setDepartment(city.get().getDepartment());
            }

            return response;
    }

    @Override
    public List<TeacherResponse> getByCity(String city) {

        
        return teacherRepository.findAllByCityNameContaining(city).stream()
            .map(this::toResponse)
            .toList();
    }

    @Override
    public List<TeacherResponse> getByName(String name1, String name2, String lastname1, String lastname2) {

/*         if(name1 != null && name2 != null && lastname1!=null && lastname2!=null){
            return teacherRepository.findByFirstNameAndSecondNameAndLastnameAndSecondLastname(name1, name2, lastname1, lastname2).stream()
                .map(this::toResponse)
                .toList();
        }

        return teacherRepository.findByFirstNameOrSecondNameOrLastnameOrSecondLastname(name1, name2, lastname1, lastname2).stream()
            .map(this::toResponse)
            .toList(); */

        //return criteriaQueryExample(name1, name2, lastname1, lastname2);

        //teacherRepository.findAll

/*         return customRepository.findByTeacherName(name1, name2, lastname1, lastname2).stream()
            .map(this::toResponse)
            .toList(); */

            //findByExample

            var query = new Teacher();

            query.setFirstName(name1 != null ? name1 : null);
            query.setSecondName(name2 != null ? name2 : null);
            query.setLastname(lastname1 != null ? lastname1 : null);
            query.setSecondLastname(lastname2 != null ? lastname2 : null);

            return teacherRepository.findAll(Example.of(query)).stream()
                .map(this::toResponse)
                .toList();

    }

    @Override
    public List<TeacherResponse> getBySalary(Double salary) {
        // TODO Auto-generated method stub
        return teacherRepository.lookingBySalary(salary).stream()
            .map(this::toResponse)
            .toList();
    }

   
    
}
