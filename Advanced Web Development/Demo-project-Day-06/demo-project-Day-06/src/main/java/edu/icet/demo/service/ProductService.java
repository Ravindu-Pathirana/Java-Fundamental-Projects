package edu.icet.demo.service;

import edu.icet.demo.model.Product;

import java.util.ArrayList;

public interface ProductService {
    void saveProduct(Product product);
    ArrayList<Product> getAllProducts();
}
