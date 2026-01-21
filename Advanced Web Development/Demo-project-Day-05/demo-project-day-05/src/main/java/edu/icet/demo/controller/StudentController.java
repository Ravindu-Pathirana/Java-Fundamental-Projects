package edu.icet.demo.controller;

import edu.icet.demo.entity.StudentEntity;
import edu.icet.demo.model.Student;
import edu.icet.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repository;

    @Autowired
    ObjectMapper mapper;

    @PostMapping("/student")
    void createStudent(@RequestBody Student student){
        System.out.println(student);
        StudentEntity studentEntity =  mapper.convertValue(student, StudentEntity.class);
        repository.save(studentEntity);

    }



}
