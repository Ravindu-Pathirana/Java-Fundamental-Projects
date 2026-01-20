package edu.icet.demo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cusId;

    private String name;
    private String contactNumber;
    private boolean isActiveCustomer;
}
