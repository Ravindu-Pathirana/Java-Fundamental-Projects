package edu.icet.demo.entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="product")
public class ProductEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private String category;

}
