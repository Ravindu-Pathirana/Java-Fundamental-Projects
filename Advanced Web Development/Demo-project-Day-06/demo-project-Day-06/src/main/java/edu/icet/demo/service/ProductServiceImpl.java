package edu.icet.demo.service;

import edu.icet.demo.entity.ProductEntity;
import edu.icet.demo.model.Product;
import edu.icet.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    ProductRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void saveProduct(Product product) {

//        ProductEntity entity = new ProductEntity();
//        entity.setCategory(product.getCategory());
//        entity.setName(product.getName());

        ProductEntity entity = mapper.convertValue(product,ProductEntity.class);
        repository.save(entity);
    }

    public ArrayList<Product> getAllProducts(){
        Iterable<ProductEntity> allProducts = repository.findAll();

        ArrayList<Product> products = new ArrayList<>();

        allProducts.forEach(productEntity -> {
            Product product = mapper.convertValue(productEntity, Product.class);
            products.add(product);
        });
        return products;

    }
}
