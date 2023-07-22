package com.exampleSQL.productservice.controller;

import com.exampleSQL.productservice.exception.ProductUserAlreadyExists;
import com.exampleSQL.productservice.model.Product;
import com.exampleSQL.productservice.model.UserProduct;
import com.exampleSQL.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody Product userProduct) {
        Product product = productService.saveProduct(userProduct);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/get")
    public ResponseEntity<?> getProducts(){
        return new ResponseEntity<>(productService.getallproducts(),HttpStatus.OK);
    }


    @DeleteMapping("/delete-product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId){
        return new ResponseEntity<>(productService.deleteproduct(Integer.parseInt(productId)),HttpStatus.OK);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping("/update")
    public ResponseEntity<?> editProduct(@RequestBody Product userProduct) {
        Product product = productService.updateProduct(userProduct);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}


