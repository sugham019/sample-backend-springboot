package com.example.demoshoppingsite.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Date orderDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private Item product;

    private int total;

    public Order(){}

    public Order(User user, Item item, Date orderDate, int total){
        this.product = item;
        this.user = user;
        this.orderDate = orderDate;
        this.total = total;
    }

    public Date getOrderDate(){
        return orderDate;
    }

    public User getUser(){
        return user;
    }

    public Item getProduct(){
        return product;
    }

    public void setOrderDate(Date orderDate){
        this.orderDate = orderDate;
    }

}
