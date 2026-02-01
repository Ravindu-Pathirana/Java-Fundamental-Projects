package edu.icet.demo.controller;

import edu.icet.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired // dependency injection / Field Injection
    ProductService productService; //dependency

    //constructor Injection
//    ProductController(ProductService productService){
//        this.productService= productService;
//    }

    //Rest API
    //http://localhost:8080/products/all
    //Method : GET

    @GetMapping("/all")
    Map<String, String> getStudents(){
        return productService.getStudents();

    }



}
