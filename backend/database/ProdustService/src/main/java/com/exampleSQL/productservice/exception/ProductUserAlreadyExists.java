package com.exampleSQL.productservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "user already there")
public class ProductUserAlreadyExists extends Exception {
}
