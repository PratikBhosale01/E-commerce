package com.exampleSQL.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserProduct {

    private String user_role;
    private String username;
    @Id
    private String email;
    private String address;
    List<Product> products;

    private String password;


}
