package com.example.webtest.entity;

public class User extends Base {

    public Integer id;
    public String username;
    public String password;
    public String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + username + '\'' +
                ", passWord='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
