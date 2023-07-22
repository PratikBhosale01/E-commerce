package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.UserModel;
import com.niit.UserAuthentication.exception.UserAlreadyExistException;
import com.niit.UserAuthentication.exception.UserNotFoundException;

public interface UserService
{
    public abstract UserModel addUser(UserModel user) throws UserAlreadyExistException;
    public abstract UserModel loginCheck(String email , String userPassword) throws UserNotFoundException;

}
