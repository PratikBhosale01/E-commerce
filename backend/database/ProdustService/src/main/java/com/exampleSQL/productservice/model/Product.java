package com.exampleSQL.productservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Product {

    @Id
    private int productid;
    private String productname;

    private String img;
    private String des;





}
