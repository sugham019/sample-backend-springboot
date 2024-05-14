package com.example.demoshoppingsite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    @Id
    private String name;
    private int price;
    private int total;

    public Item(){}

    public Item(String name, int price, int total) {
        this.name = name;
        this.price = price;
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public String getName() {
        return name;
    }
}
