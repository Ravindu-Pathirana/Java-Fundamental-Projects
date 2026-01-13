package edu.icet.demo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Student student = service.getStudent();
        System.out.println(student);


    }
}
