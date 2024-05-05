package com.example.demoshoppingsite.model;

public class Order {

    private Item item;
    private String username;

    public Order(Item item, String username){
        this.item = item;
        this.username = username;
    }

    public Item getItem(){
        return item;
    }

    public String getUsername(){
        return username;
    }
}
