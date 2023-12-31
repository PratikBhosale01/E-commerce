package com.exampleSQL.productservice.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Jwtfilter extends GenericFilterBean {

    // @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String authHeader = request.getHeader("authorization");
        // if the method is options the request  can pass through not validation of token is required
        if("OPTIONS".equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request,response);
        }
        else if(authHeader==null || !authHeader.startsWith("Bearer")){
            throw new ServletException("Missing or invalid exception");
        }
        String token=authHeader.substring(7);

        // parse the payload of token
        Claims claims = Jwts.parser().setSigningKey("mykey").parseClaimsJws(token).getBody();
        request.setAttribute("claims",claims);
        filterChain.doFilter(request, response);
    }
}