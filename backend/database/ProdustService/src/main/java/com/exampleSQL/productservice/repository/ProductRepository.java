package com.exampleSQL.productservice.repository;

import com.exampleSQL.productservice.model.Product;
import com.exampleSQL.productservice.model.UserProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,Integer> {






}
