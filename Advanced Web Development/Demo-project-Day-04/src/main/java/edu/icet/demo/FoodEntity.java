package edu.icet.demo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Food")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer foodId;
    private String name;
    private String description;
    private String price;

}
