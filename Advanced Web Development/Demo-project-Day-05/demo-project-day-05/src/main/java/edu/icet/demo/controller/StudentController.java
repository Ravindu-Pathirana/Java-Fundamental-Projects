package edu.icet.demo.controller;

import edu.icet.demo.entity.StudentEntity;
import edu.icet.demo.model.Student;
import edu.icet.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
        System.out.println(student);
        return service.createStudent(student);

    }



}
