package edu.icet.demo.controller;


import edu.icet.demo.model.Product;
import edu.icet.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/save-product")
    void saveProduct(@RequestBody Product product){

        //ProductService service = new ProductService():
        service.saveProduct(product);

    }

    @GetMapping("/get-all-products")
    ArrayList<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/get-products-by-category/{category}")
    ArrayList<Product> getProductsByCategory(@PathVariable String category){
        return service.getProductsByCategory(category);
    }

}
