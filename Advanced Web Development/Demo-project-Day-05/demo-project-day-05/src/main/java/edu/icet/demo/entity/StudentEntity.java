package edu.icet.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer stdId;

    private String firstname;
    private String lastname;
    private String province;
}
