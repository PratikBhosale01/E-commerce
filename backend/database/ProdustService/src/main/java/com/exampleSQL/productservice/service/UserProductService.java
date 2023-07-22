package com.exampleSQL.productservice.service;

import com.exampleSQL.productservice.exception.ProductUserAlreadyExists;
import com.exampleSQL.productservice.model.UserProduct;

import java.util.List;

public interface UserProductService {

    public UserProduct saveUserProduct(UserProduct userProduct) throws ProductUserAlreadyExists;
    public List<UserProduct> getAllUserProduct();

    public UserProduct updateProducts(UserProduct userProduct);


    public  UserProduct getUserByid(String id);





}
