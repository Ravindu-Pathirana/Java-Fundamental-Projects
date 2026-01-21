package edu.icet.demo.controller;

import edu.icet.demo.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @PostMapping("/student")
    void createStudent(@RequestBody Student student){
        System.out.println(student);

    }



}
