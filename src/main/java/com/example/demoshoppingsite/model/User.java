package com.example.demoshoppingsite.model;

public class User {

    private String userName;

    public User(String username){
        this.userName = username;
    }

    public User(User user){
        this.userName = user.getUserName();
    }

    private String getUserName(){
        return userName;
    }
}
