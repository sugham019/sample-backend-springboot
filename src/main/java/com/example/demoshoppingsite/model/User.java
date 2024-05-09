package com.example.demoshoppingsite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String name;
    private int age;
    private String password;


    public User(String name, int age, String password){
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public User() {

    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
