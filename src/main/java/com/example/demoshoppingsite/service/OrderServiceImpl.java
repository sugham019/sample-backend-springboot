package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.Order;
import com.example.demoshoppingsite.model.Response;
import com.example.demoshoppingsite.model.ResponseObj;
import com.example.demoshoppingsite.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{


    @Override
    public Response placeOrder(Order order) {
        return null;
    }

    @Override
    public Response cancelOrder(Order order) {
        return null;
    }

    @Override
    public ResponseObj<Order[]> viewCart(User user){
        return null;
    }
}
