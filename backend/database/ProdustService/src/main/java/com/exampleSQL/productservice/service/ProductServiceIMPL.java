package com.exampleSQL.productservice.service;

import com.exampleSQL.productservice.model.Product;
import com.exampleSQL.productservice.model.UserProduct;
import com.exampleSQL.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceIMPL implements ProductService{
    ProductRepository productRepository;
    @Autowired
    public ProductServiceIMPL(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {


        return productRepository.save(product);
    }

    @Override
    public List<Product> getallproducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean deleteproduct(int productid) {
        productRepository.deleteById(productid);
        return true;
    }

    @Override
    public Product updateProduct(Product product) {
        return  productRepository.save(product);
    }


}
