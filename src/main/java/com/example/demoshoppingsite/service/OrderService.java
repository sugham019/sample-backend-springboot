package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.*;
import com.example.demoshoppingsite.exceptions.NotFoundException;
import com.example.demoshoppingsite.exceptions.OutOfStockException;

public interface OrderService {

    void placeOrder(User user, Item product, int no) throws OutOfStockException, NotFoundException;
    void cancelOrder(User user, Order order);
    void completeOrder(User user, Order order);
    Order[] getOrders(User user);
}
