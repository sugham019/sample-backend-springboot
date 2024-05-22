package com.example.demoshoppingsite.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<Order> orders;

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

    public boolean hasPendingOrders(){
        return !orders.isEmpty();
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
