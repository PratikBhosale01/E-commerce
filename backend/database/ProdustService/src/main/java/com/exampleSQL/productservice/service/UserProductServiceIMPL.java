package com.exampleSQL.productservice.service;

import com.exampleSQL.productservice.exception.ProductUserAlreadyExists;
import com.exampleSQL.productservice.model.UserProduct;
import com.exampleSQL.productservice.proxy.UserProxy;
import com.exampleSQL.productservice.repository.UserProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProductServiceIMPL implements UserProductService {
    private UserProxy userProxy;
    UserProductRepos userProductRepos;

    @Autowired
    public UserProductServiceIMPL(UserProxy userProxy, UserProductRepos userProductRepos) {
        this.userProxy = userProxy;
        this.userProductRepos = userProductRepos;
    }



    @Override
    public UserProduct saveUserProduct(UserProduct userProduct) throws ProductUserAlreadyExists {

        if(userProductRepos.findById(userProduct.getEmail()).isPresent()){
            throw new ProductUserAlreadyExists();
       } UserProduct userProduct1= userProductRepos.save(userProduct);
        if(!(userProduct1.getEmail().isEmpty())){
            ResponseEntity r =userProxy.saveUser(userProduct);
            System.out.println(r.getBody());
        }

        return userProduct1;
    }
    @Override
    public List<UserProduct> getAllUserProduct() {
        return userProductRepos.findAll();
    }

    @Override
    public UserProduct updateProducts(UserProduct userProduct) {
        return userProductRepos.save(userProduct);
    }

    @Override
    public UserProduct getUserByid(String id1) {

        return userProductRepos.findByEmail(id1);

    }





    }



