package edu.icet.demo.service;

import edu.icet.demo.entity.ProductEntity;
import edu.icet.demo.model.Product;
import edu.icet.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

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
}
