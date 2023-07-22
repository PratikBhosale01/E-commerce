package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator
{
    @Override
    public Map<String, String> generateToken(UserModel user) {
        String token = null;
        Map<String,String> result= new HashMap<>();


        Map<String, Object> userdata = new HashMap<>();
        userdata.put("role_user",user.getUser_role());
        userdata.put("user_email",user.getEmail());

        token = Jwts.builder()
                .setClaims(userdata)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"mykey").compact();


        result.put("token",token);
        result.put("email",user.getEmail());
        result.put("message","User successfully logged in");
        result.put("role",user.getUser_role());
        return result;

    }
}
