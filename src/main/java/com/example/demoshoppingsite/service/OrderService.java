package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.Order;
import com.example.demoshoppingsite.model.User;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity placeOrder(Order order);
    ResponseEntity cancelOrder(Order order);
    ResponseEntity<Order[]> viewCart(User user);
}
