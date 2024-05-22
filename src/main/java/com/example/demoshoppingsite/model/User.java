package com.example.demoshoppingsite.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String name;

    private int age;
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public User(String name, int age, String password){
        this.name = name;
        this.age = age;
        this.password = password;

    }

    public User() {}

    public List<Order> getOrders(){
        return orders;
    }

    public void clearOrders(){
        orders = null;
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
