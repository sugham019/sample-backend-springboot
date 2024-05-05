package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.Order;
import com.example.demoshoppingsite.model.Response;
import com.example.demoshoppingsite.model.ResponseObj;
import com.example.demoshoppingsite.model.User;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    Response placeOrder(Order order);
    Response cancelOrder(Order order);
    ResponseObj<Order[]> viewCart(User user);
}
