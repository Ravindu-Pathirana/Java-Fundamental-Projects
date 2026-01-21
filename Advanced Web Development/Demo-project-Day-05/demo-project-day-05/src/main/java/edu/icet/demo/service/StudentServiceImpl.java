package edu.icet.demo.service;

import edu.icet.demo.entity.StudentEntity;
import edu.icet.demo.model.Student;
import edu.icet.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository repository;

    @Autowired
    ObjectMapper mapper;

    public Student createStudent(Student student){
        StudentEntity studentEntity =  mapper.convertValue(student, StudentEntity.class);

        StudentEntity savedStudent = repository.save(studentEntity);

        return mapper.convertValue(savedStudent,Student.class);

    }
}
