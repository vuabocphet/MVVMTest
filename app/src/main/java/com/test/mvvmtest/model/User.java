package com.test.mvvmtest.model;

public class User {

    public String email;

    public String password;

    public static User init(){
        return new User();
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
