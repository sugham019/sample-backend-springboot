package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.exceptions.AuthenticationException;
import com.example.demoshoppingsite.model.*;
import com.example.demoshoppingsite.exceptions.NotFoundException;
import com.example.demoshoppingsite.exceptions.OutOfStockException;

public interface OrderService {

    void placeOrder(OrderInfo orderInfo) throws OutOfStockException, NotFoundException, AuthenticationException;
    void cancelOrder(User user, Order order);
    void completeOrder(Long orderId) throws NotFoundException;
    Order[] getOrders(User user);
}
