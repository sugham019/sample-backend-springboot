package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.*;
import com.example.demoshoppingsite.repository.OrderRepository;
import com.example.demoshoppingsite.exceptions.NotFoundException;
import com.example.demoshoppingsite.exceptions.OutOfStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductCatalogService productCatalogService;

    @Override
    public void placeOrder(User user, Item product, int total) throws OutOfStockException, NotFoundException {

        if(product.getTotal() < total)
            throw new OutOfStockException();

        Date currentDate = new Date();
        Order order = new Order(user, product, currentDate, total);

        productCatalogService.updateStock(product.getId(), -total);
        orderRepository.save(order);
    }

    @Override
    public void cancelOrder(User user, Order order) {

    }

    @Override
    public void completeOrder(User user, Order order) {

    }

    @Override
    public Order[] getOrders(User user) {
        return new Order[0];
    }


}
