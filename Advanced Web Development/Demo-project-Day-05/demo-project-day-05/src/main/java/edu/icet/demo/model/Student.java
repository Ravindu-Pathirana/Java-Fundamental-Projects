package edu.icet.demo.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {

    private Integer stdId;
    private String firstname;
    private String lastname;
    private String province;
}
