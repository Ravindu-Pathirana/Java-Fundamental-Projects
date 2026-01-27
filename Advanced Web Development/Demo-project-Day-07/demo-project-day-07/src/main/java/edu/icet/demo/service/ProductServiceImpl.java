package edu.icet.demo.service;

import edu.icet.demo.entity.ProductEntity;
import edu.icet.demo.model.Product;
import edu.icet.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    ObjectMapper mapper;

    public Product persist(Product product){
       ProductEntity savedProduct =  repository.save(
                                        mapper.convertValue(
                                            product,ProductEntity.class));
       return mapper.convertValue(savedProduct,Product.class);
    }

    public ArrayList<Product> retrieve(){
        Iterable<ProductEntity> productList = repository.findAll();
        ArrayList<Product> productModels = new ArrayList<>();

        productList.forEach(productEntity -> {
            productModels.add(mapper.convertValue(productEntity, Product.class));
        });
        return productModels;
    }
}
