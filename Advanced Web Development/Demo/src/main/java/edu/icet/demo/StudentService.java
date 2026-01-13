package edu.icet.demo;

public class StudentService {
    public Student getStudent(){
        Student std = new Student();
        std.setName("Ravindu");
        std.setAge("22");

        Student std2 = new Student("Jayasankha","22");
        return std;
    }
}
