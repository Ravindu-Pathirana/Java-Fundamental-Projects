package edu.icet.demo;

public class StudentService {
    public Student getStudent(){
        Student std = new Student();
        std.setName("Ravindu");
        std.setAge("22");
        return std;
    }
}
