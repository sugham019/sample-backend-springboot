package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.exceptions.AuthenticationException;
import com.example.demoshoppingsite.exceptions.NotFoundException;
import com.example.demoshoppingsite.exceptions.OutOfStockException;
import com.example.demoshoppingsite.model.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void placeOrder() throws OutOfStockException, AuthenticationException, NotFoundException {
        OrderInfo orderInfo = new OrderInfo("Test123", "Test123", 1L, 10);

        orderService.placeOrder(orderInfo);
    }

    @Test
    public void completeOrder() throws NotFoundException {

        orderService.completeOrder(2L);
    }
}
