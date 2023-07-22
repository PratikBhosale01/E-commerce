package com.exampleSQL.productservice.repository;

import com.exampleSQL.productservice.model.UserProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProductRepos extends MongoRepository<UserProduct,String> {


    public UserProduct findByEmail(String email);

}
