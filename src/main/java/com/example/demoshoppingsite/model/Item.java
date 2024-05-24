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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User vendor;

    private String name;
    private float price;
    private int total;

    public Item(){}

    public Item(String name, float price, int total, User vendor) {
        this.name = name;
        this.price = price;
        this.vendor = vendor;
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

    public User getVendor(){
        return vendor;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public float getPrice(){
        return price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
