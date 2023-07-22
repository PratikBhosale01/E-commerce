package com.exampleSQL.productservice.proxy;

import com.exampleSQL.productservice.model.UserProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name ="User-Authentication-service",url = "http://localhost:8085")
public interface
UserProxy {


    @PostMapping("/userservice/register")
    public ResponseEntity<?> saveUser(@RequestBody UserProduct userProduct);
}
