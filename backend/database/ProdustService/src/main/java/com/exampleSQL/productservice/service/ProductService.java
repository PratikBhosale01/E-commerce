package com.exampleSQL.productservice.service;

import com.exampleSQL.productservice.exception.ProductUserAlreadyExists;
import com.exampleSQL.productservice.model.Product;
import com.exampleSQL.productservice.model.UserProduct;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product) ;
    public List<Product> getallproducts();

    public boolean deleteproduct(int productid);
    public Product updateProduct(Product product);













}
