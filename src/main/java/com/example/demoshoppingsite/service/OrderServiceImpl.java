package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.Order;
import com.example.demoshoppingsite.model.User;
import org.springframework.http.ResponseEntity;

public class OrderServiceImpl implements OrderService{

    @Override
    public ResponseEntity placeOrder(Order order) {
        return null;
    }

    @Override
    public ResponseEntity cancelOrder(Order order) {
        return null;
    }

    @Override
    public ResponseEntity<Order[]> viewCart(User user) {
        return null;
    }
}
