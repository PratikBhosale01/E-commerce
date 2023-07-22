package com.niit.UserAuthentication.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserModel
{
    @Id
    private String email;
    private String password;
    private String user_role;

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public UserModel(String email, String password, String user_role) {
        this.email = email;
        this.password = password;
        this.user_role = user_role;
    }

    public UserModel()
    {

    }

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
