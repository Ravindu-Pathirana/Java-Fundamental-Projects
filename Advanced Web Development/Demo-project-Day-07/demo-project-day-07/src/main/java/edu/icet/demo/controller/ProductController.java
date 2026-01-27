package edu.icet.demo.controller;

import edu.icet.demo.model.Product;
import edu.icet.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productservice;

    @PostMapping("/product")
    Product persist(@RequestBody Product product){
        return productservice.persist(product);

    }

    @GetMapping("/product")
    ArrayList<Product> retrive(){
        return productservice.retrive();
    }

}
