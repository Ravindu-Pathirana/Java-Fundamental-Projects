package edu.icet.demo.repository;

import edu.icet.demo.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity,Integer>{

    Iterable<ProductEntity> findAllByCategory(String category);
}
