package com.exampleSQL.productservice.controller;


import com.exampleSQL.productservice.model.UserProduct;
import com.exampleSQL.productservice.exception.ProductUserAlreadyExists;
import com.exampleSQL.productservice.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/userproduct/")
@RestController
public class UserProductController {


    ResponseEntity responseEntity;

    UserProductService userProductService;

    @Autowired
    public UserProductController(UserProductService userProductService) {
        this.userProductService = userProductService;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping("userproduct")
    public ResponseEntity<?> saveuserproduct(@RequestBody UserProduct userProduct){

        UserProduct userProduct1;
        try {
            userProduct1 = userProductService.saveUserProduct(userProduct);
        } catch (ProductUserAlreadyExists e) {
            throw new RuntimeException(e);
        }
        responseEntity=new ResponseEntity<>(userProduct1, HttpStatus.CREATED);

        return responseEntity;

    }
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("users")
    public ResponseEntity<?> gettrackuser(){

        responseEntity=new ResponseEntity<>(userProductService.getAllUserProduct(),HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping("user/{email}")
    public ResponseEntity<?> getUser(@PathVariable("email") String email  ){

        responseEntity=new ResponseEntity<>(userProductService.getUserByid(email),HttpStatus.OK);

        return responseEntity;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping("update")
    public ResponseEntity<?> updateProducts(@RequestBody UserProduct userProduct){

        responseEntity=new ResponseEntity<>(userProductService.updateProducts(userProduct), HttpStatus.CREATED);

        return responseEntity;

    }









}
